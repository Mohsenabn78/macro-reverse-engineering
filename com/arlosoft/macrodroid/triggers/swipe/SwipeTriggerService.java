package com.arlosoft.macrodroid.triggers.swipe;

import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.SwipeTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class SwipeTriggerService extends OverlayService {

    /* renamed from: f  reason: collision with root package name */
    private static WeakReference<SwipeTriggerService> f15588f;

    /* renamed from: d  reason: collision with root package name */
    private SwipeTriggerView f15589d;

    /* renamed from: e  reason: collision with root package name */
    private SwipeTriggerView f15590e;

    public static void stop() {
        WeakReference<SwipeTriggerService> weakReference = f15588f;
        if (weakReference != null && weakReference.get() != null) {
            f15588f.get().stopSelf();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        f15588f = new WeakReference<>(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        SwipeTriggerView swipeTriggerView = this.f15589d;
        if (swipeTriggerView != null) {
            swipeTriggerView.destroy();
        }
        SwipeTriggerView swipeTriggerView2 = this.f15590e;
        if (swipeTriggerView2 != null) {
            swipeTriggerView2.destroy();
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.swipe.OverlayService, android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        boolean canDrawOverlays;
        if (Build.VERSION.SDK_INT >= 23) {
            canDrawOverlays = Settings.canDrawOverlays(this);
            if (!canDrawOverlays) {
                SystemLog.logError("Swipe Trigger setup failed - needs can draw overlays permission");
                return 2;
            }
        }
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if (next instanceof SwipeTrigger) {
                    SwipeTrigger swipeTrigger = (SwipeTrigger) next;
                    if (swipeTrigger.getSwipeStartArea() == 0 && this.f15589d == null) {
                        this.f15589d = new SwipeTriggerView(this, 0);
                    }
                    if (swipeTrigger.getSwipeStartArea() == 1 && this.f15590e == null) {
                        this.f15590e = new SwipeTriggerView(this, 1);
                    }
                }
            }
        }
        return 1;
    }
}
