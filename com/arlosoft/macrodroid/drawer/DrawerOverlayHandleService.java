package com.arlosoft.macrodroid.drawer;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.dim.DimOverlayService;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.drawer.model.DrawerConfiguration;
import com.arlosoft.macrodroid.events.DrawerHandleUpdateEvent;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.settings.Settings;

/* loaded from: classes3.dex */
public class DrawerOverlayHandleService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private WindowManager f11432a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11433b;

    /* renamed from: c  reason: collision with root package name */
    private int f11434c;

    /* renamed from: d  reason: collision with root package name */
    private int f11435d;

    /* renamed from: e  reason: collision with root package name */
    private View f11436e;

    /* renamed from: f  reason: collision with root package name */
    private View f11437f;

    /* renamed from: g  reason: collision with root package name */
    private int f11438g;

    /* renamed from: h  reason: collision with root package name */
    private DrawerConfiguration f11439h;

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00e0, code lost:
        if (r1 != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void b() {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.drawer.DrawerOverlayHandleService.b():void");
    }

    private int c() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean d(View view, MotionEvent motionEvent) {
        View view2 = this.f11436e;
        if (view2 != null && ViewCompat.isAttachedToWindow(view2)) {
            try {
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            int i4 = rawX - this.f11434c;
                            int i5 = rawY - this.f11435d;
                            if (Settings.isDrawerSwipeHorizontallyEnabled(this) && (((i4 > 100 && this.f11439h.leftSide) || (i4 < -100 && !this.f11439h.leftSide)) && !this.f11433b)) {
                                this.f11433b = true;
                                startService(new Intent(this, DrawerOverlayService.class));
                            }
                            if (((i5 > 100 && Settings.isDrawerSwipeDownEnabled(this)) || (i5 < -100 && Settings.isDrawerSwipeUpEnabled(this))) && !this.f11433b) {
                                this.f11433b = true;
                                startService(new Intent(this, DrawerOverlayService.class));
                            }
                        }
                    } else {
                        this.f11433b = false;
                    }
                } else {
                    this.f11434c = rawX;
                    this.f11435d = rawY;
                }
            } catch (IllegalArgumentException e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
        }
        return true;
    }

    private void e() {
        int i4;
        View view = this.f11437f;
        if (this.f11439h.leftSide) {
            i4 = R.drawable.drawer_swipe_bg_left;
        } else {
            i4 = R.drawable.drawer_swipe_bg_right;
        }
        view.setBackgroundResource(i4);
        DrawerConfiguration drawerConfiguration = this.f11439h;
        int alphaComponent = ColorUtils.setAlphaComponent(drawerConfiguration.swipeAreaColor, Math.min(drawerConfiguration.swipeAreaOpacity, 255));
        Drawable background = this.f11437f.getBackground();
        if (background instanceof ShapeDrawable) {
            ((ShapeDrawable) background).getPaint().setColor(alphaComponent);
        } else if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(alphaComponent);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background).setColor(alphaComponent);
        }
    }

    private void f() {
        FrameLayout frameLayout = (FrameLayout) this.f11436e.findViewById(R.id.drawer_container);
        if (DimOverlayService.isDimmed) {
            frameLayout.setAlpha(((100 - DimOverlayService.dimPercentage) + 20) / 120.0f);
        } else {
            frameLayout.setAlpha(1.0f);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.f11432a.removeView(this.f11436e);
        } catch (Exception unused) {
        }
        b();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        b();
        EventBusUtils.getEventBus().register(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            this.f11432a.removeView(this.f11436e);
        } catch (Exception unused) {
        }
        EventBusUtils.getEventBus().unregister(this);
        super.onDestroy();
    }

    public void onEventMainThread(DrawerHandleUpdateEvent drawerHandleUpdateEvent) {
        int i4;
        int i5;
        if (this.f11436e == null) {
            return;
        }
        this.f11439h = drawerHandleUpdateEvent.getDrawerConfiguration();
        e();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f11437f.getLayoutParams();
        if (this.f11439h.leftSide) {
            i4 = 3;
        } else {
            i4 = 5;
        }
        layoutParams.gravity = i4;
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) this.f11436e.getLayoutParams();
        int i6 = (int) (this.f11439h.swipeAreaWidth * getResources().getDisplayMetrics().density);
        int visibleWidth = (int) (this.f11439h.getVisibleWidth() * getResources().getDisplayMetrics().density);
        DrawerConfiguration drawerConfiguration = this.f11439h;
        int i7 = this.f11438g;
        int i8 = (int) (((drawerConfiguration.swipeAreaHeight + 10) / 100.0f) * i7);
        int c4 = (((int) (((drawerConfiguration.swipeAreaOffset + 10) / 100.0f) * i7)) - (i7 / 2)) - c();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f11432a.getDefaultDisplay().getRealMetrics(displayMetrics);
        int i9 = displayMetrics.widthPixels;
        int i10 = (int) (this.f11439h.swipeAreaWidth * getResources().getDisplayMetrics().density);
        if (this.f11439h.leftSide) {
            i5 = -i9;
        } else {
            i5 = i9 - i10;
        }
        layoutParams2.x = i5;
        layoutParams2.y = c4;
        layoutParams2.width = i6;
        layoutParams2.height = i8;
        this.f11432a.updateViewLayout(this.f11436e, layoutParams2);
        this.f11437f.getLayoutParams().width = visibleWidth;
        f();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        stopSelf();
    }
}
