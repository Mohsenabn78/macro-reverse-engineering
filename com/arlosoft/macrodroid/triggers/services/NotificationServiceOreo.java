package com.arlosoft.macrodroid.triggers.services;

import android.annotation.TargetApi;
import android.media.AudioManager;
import android.os.Build;
import android.view.KeyEvent;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.ListenForVolumeLongPressEvent;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.VolumeLongPressTrigger;
import com.arlosoft.macrodroid.triggers.services.mediasessionmanager.MediaSessionManagerWrapper;
import java.util.ArrayList;
import java.util.Iterator;

@TargetApi(26)
/* loaded from: classes3.dex */
public class NotificationServiceOreo extends NotificationService implements MediaSessionManagerWrapper.VolumeKeyLongPressListener {

    /* renamed from: l  reason: collision with root package name */
    private long f15518l = 2000;

    /* renamed from: m  reason: collision with root package name */
    private long f15519m = 0;

    /* renamed from: n  reason: collision with root package name */
    private boolean f15520n = false;

    /* renamed from: o  reason: collision with root package name */
    private MediaSessionManagerWrapper f15521o;

    @Override // com.arlosoft.macrodroid.triggers.services.NotificationService, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26 && ContextCompat.checkSelfPermission(this, "android.permission.SET_VOLUME_KEY_LONG_PRESS_LISTENER") == 0) {
            this.f15521o = new MediaSessionManagerWrapper(this, this);
        }
        EventBusUtils.getEventBus().register(this);
    }

    @Override // com.arlosoft.macrodroid.triggers.services.NotificationService, android.service.notification.NotificationListenerService, android.app.Service
    public void onDestroy() {
        try {
            EventBusUtils.getEventBus().unregister(this);
        } catch (Exception unused) {
        }
        super.onDestroy();
    }

    public void onEventMainThread(ListenForVolumeLongPressEvent listenForVolumeLongPressEvent) {
        if (Build.VERSION.SDK_INT >= 26 && ContextCompat.checkSelfPermission(this, "android.permission.SET_VOLUME_KEY_LONG_PRESS_LISTENER") == 0) {
            if (this.f15521o == null) {
                SystemLog.logVerbose("Creating new Media Session Manager Wrapper");
                this.f15521o = new MediaSessionManagerWrapper(this, this);
                return;
            }
            SystemLog.logVerbose("Media Session Manager Wrapper already exists");
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.services.mediasessionmanager.MediaSessionManagerWrapper.VolumeKeyLongPressListener
    public void onVolumeKeyLongPress(KeyEvent keyEvent) {
        boolean z3;
        boolean z4;
        long currentTimeMillis = System.currentTimeMillis();
        int flags = keyEvent.getFlags();
        if (flags != 8 && flags != 128) {
            return;
        }
        if (currentTimeMillis - this.f15519m < this.f15518l && this.f15520n) {
            return;
        }
        this.f15519m = currentTimeMillis;
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if ((next instanceof VolumeLongPressTrigger) && next.isEnabled()) {
                        if (((VolumeLongPressTrigger) next).getOption() == 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (keyEvent.getKeyCode() == 24) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4 == z3 && next.constraintsMet()) {
                            macro.setTriggerThatInvoked(next);
                            if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                arrayList.add(macro);
                            }
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Macro macro2 = (Macro) it2.next();
            macro2.invokeActions(macro2.getTriggerContextInfo());
        }
        if (arrayList.size() == 0) {
            AudioManager audioManager = (AudioManager) getSystemService("audio");
            if (keyEvent.getKeyCode() == 25) {
                audioManager.adjustVolume(-1, 1);
            } else if (keyEvent.getKeyCode() == 24) {
                audioManager.adjustVolume(1, 1);
            }
            this.f15520n = false;
            return;
        }
        this.f15520n = true;
    }
}
