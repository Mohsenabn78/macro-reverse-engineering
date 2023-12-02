package com.arlosoft.macrodroid.drawer;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.arlosoft.macrodroid.drawer.model.DrawerConfiguration;
import com.arlosoft.macrodroid.events.CloseDrawerEvent;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.DrawerOpenCloseTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class DrawerOverlayService extends Service {
    public static boolean drawerOpen = false;

    /* renamed from: a  reason: collision with root package name */
    private WindowManager f11440a;

    /* renamed from: b  reason: collision with root package name */
    private int f11441b;

    /* renamed from: c  reason: collision with root package name */
    WindowManager.LayoutParams f11442c;

    /* renamed from: d  reason: collision with root package name */
    private View f11443d;

    /* renamed from: e  reason: collision with root package name */
    private View f11444e;

    /* renamed from: f  reason: collision with root package name */
    private DrawerFrameLayout f11445f;

    /* renamed from: g  reason: collision with root package name */
    private int f11446g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11447h;

    /* renamed from: i  reason: collision with root package name */
    private DrawerConfiguration f11448i;

    private void h() {
        int i4;
        int i5;
        View view = this.f11443d;
        if (this.f11448i.leftSide) {
            i4 = -this.f11441b;
        } else {
            i4 = this.f11441b;
        }
        view.setX(i4);
        if (this.f11448i.leftSide) {
            i5 = 0;
        } else {
            i5 = this.f11441b - this.f11446g;
        }
        this.f11443d.animate().setInterpolator(new DecelerateInterpolator()).setDuration(250L).x(i5);
        this.f11444e.animate().setDuration(250L).alpha(0.3f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void k() {
        int i4;
        if (this.f11447h) {
            return;
        }
        this.f11447h = true;
        if (this.f11448i.leftSide) {
            i4 = -this.f11446g;
        } else {
            i4 = this.f11446g;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, i4, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        translateAnimation.setDuration(250L);
        this.f11444e.animate().setDuration(250L).alpha(0.0f);
        translateAnimation.setAnimationListener(new a());
        this.f11443d.startAnimation(translateAnimation);
    }

    private void j(boolean z3) {
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if ((next instanceof DrawerOpenCloseTrigger) && ((DrawerOpenCloseTrigger) next).isOpen() == z3 && next.constraintsMet()) {
                        macro.setTriggerThatInvoked(next);
                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                            arrayList.add(macro);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
        stopSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(View view) {
        stopSelf();
        Intent intent = new Intent(this, NewHomeScreenActivity.class);
        intent.addFlags(268435456);
        startActivity(intent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0183, code lost:
        if (r0 != false) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void p() {
        /*
            Method dump skipped, instructions count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.drawer.DrawerOverlayService.p():void");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.f11440a.removeView(this.f11445f);
        } catch (Exception unused) {
        }
        stopSelf();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        EventBusUtils.getEventBus().register(this);
        this.f11448i = Settings.getDrawerConfiguration(this);
        p();
        j(true);
        drawerOpen = true;
    }

    @Override // android.app.Service
    public void onDestroy() {
        k();
        EventBusUtils.getEventBus().unregister(this);
        j(false);
        drawerOpen = false;
        super.onDestroy();
    }

    public void onEventMainThread(CloseDrawerEvent closeDrawerEvent) {
        k();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            DrawerOverlayService.this.f11440a.removeView(DrawerOverlayService.this.f11445f);
            DrawerOverlayService.this.stopSelf();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
