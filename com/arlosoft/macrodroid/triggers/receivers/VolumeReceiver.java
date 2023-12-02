package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.preference.PreferenceManager;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.VolumeButtonTrigger;
import java.util.ArrayList;
import java.util.Iterator;
import timber.log.Timber;

/* loaded from: classes3.dex */
public class VolumeReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static long f15365a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static int f15366b = 2;

    /* renamed from: c  reason: collision with root package name */
    private static final SharedPreferences f15367c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f15368d;

    /* renamed from: e  reason: collision with root package name */
    private static final SharedPreferences.OnSharedPreferenceChangeListener f15369e;

    /* loaded from: classes3.dex */
    class a implements SharedPreferences.OnSharedPreferenceChangeListener {
        a() {
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            boolean unused = VolumeReceiver.f15368d = Settings.getVolumeButtonAlternativeConfig(MacroDroidApplication.getInstance());
        }
    }

    static {
        a aVar = new a();
        f15369e = aVar;
        f15368d = Settings.getVolumeButtonAlternativeConfig(MacroDroidApplication.getInstance());
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MacroDroidApplication.getInstance());
        f15367c = defaultSharedPreferences;
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(aVar);
    }

    private void b(Context context, boolean z3, int i4, int i5) {
        Timber.d("VolumeReceiver volumeChanged:" + z3 + "," + i4 + "," + i5, new Object[0]);
        ArrayList arrayList = new ArrayList();
        boolean z4 = false;
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if (next instanceof VolumeButtonTrigger) {
                        VolumeButtonTrigger volumeButtonTrigger = (VolumeButtonTrigger) next;
                        if (volumeButtonTrigger.getMonitorOption() == 1 && volumeButtonTrigger.isVolumeUp() == z3 && next.constraintsMet() && macro.canInvoke(macro.getTriggerContextInfo())) {
                            if (volumeButtonTrigger.isDontChangeVolume()) {
                                z4 = true;
                            }
                            arrayList.add(macro);
                            macro.setTriggerThatInvoked(next);
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Macro macro2 = (Macro) it2.next();
            macro2.invokeActions(macro2.getTriggerContextInfo());
            Timber.d("++ Volumebutton invoking macro", new Object[0]);
        }
        if (arrayList.size() > 0 && z4) {
            try {
                Timber.d("++ Volume restore stream=" + i4 + " volume=" + i5, new Object[0]);
                ((AudioManager) context.getSystemService("audio")).setStreamVolume(i4, i5, 0);
            } catch (SecurityException e4) {
                SystemLog.logError("Could not set stream volume: " + e4.toString());
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        long currentTimeMillis = System.currentTimeMillis();
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int ringerMode = audioManager.getRingerMode();
        if (currentTimeMillis < f15365a + 200) {
            return;
        }
        f15365a = currentTimeMillis;
        int intExtra = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", 0);
        int intExtra2 = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", 0);
        int intExtra3 = intent.getIntExtra("android.media.EXTRA_PREV_VOLUME_STREAM_VALUE", 0);
        StringBuilder sb = new StringBuilder();
        sb.append("VolumeReceiver: stream=");
        sb.append(intExtra2);
        sb.append(",volume=");
        sb.append(intExtra);
        sb.append(",previous=");
        sb.append(intExtra3);
        if (intExtra != intExtra3 + 1 && intExtra != intExtra3 + 2) {
            if (intExtra3 != intExtra + 1 && intExtra3 != intExtra + 2) {
                if (intExtra == audioManager.getStreamMaxVolume(intExtra2)) {
                    b(context, true, intExtra2, intExtra3);
                } else if (intExtra == 0) {
                    if (intExtra2 == 2) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("VolumeReceiver silent=");
                        sb2.append(ringerMode);
                        if (f15368d) {
                            if (ringerMode == 0) {
                                if (f15366b == 2) {
                                    b(context, false, intExtra2, intExtra3);
                                } else {
                                    b(context, true, intExtra2, intExtra3);
                                }
                            } else {
                                b(context, false, intExtra2, intExtra3);
                            }
                            f15366b = ringerMode;
                        } else if (ringerMode == 0) {
                            b(context, false, intExtra2, intExtra3);
                        } else {
                            b(context, true, intExtra2, intExtra3);
                        }
                    } else {
                        b(context, false, intExtra2, intExtra3);
                    }
                } else if (intExtra == 1 && intExtra3 == 1) {
                    b(context, true, intExtra2, 0);
                }
            } else {
                b(context, false, intExtra2, intExtra3);
            }
        } else {
            b(context, true, intExtra2, intExtra3);
        }
        f15366b = ringerMode;
    }
}
