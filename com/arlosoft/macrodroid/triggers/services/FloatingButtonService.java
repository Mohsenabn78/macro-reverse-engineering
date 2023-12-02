package com.arlosoft.macrodroid.triggers.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.WaitUntilTriggerAction;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.database.Database;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.FloatingButtonsUpdateEvent;
import com.arlosoft.macrodroid.events.MacroEnabledStateChangeEvent;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.FloatingButtonTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.utils.Debouncer;
import com.arlosoft.macrodroid.utils.OverlayUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.melnykov.fab.FloatingActionButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class FloatingButtonService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private WindowManager f15427a;

    /* renamed from: c  reason: collision with root package name */
    private float f15429c;

    /* renamed from: e  reason: collision with root package name */
    private int f15431e;

    /* renamed from: f  reason: collision with root package name */
    private int f15432f;

    /* renamed from: g  reason: collision with root package name */
    private View f15433g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f15434h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f15435i;

    /* renamed from: k  reason: collision with root package name */
    private int f15437k;

    /* renamed from: l  reason: collision with root package name */
    private int f15438l;

    /* renamed from: m  reason: collision with root package name */
    private int f15439m;

    /* renamed from: o  reason: collision with root package name */
    WindowManager.LayoutParams f15441o;

    /* renamed from: b  reason: collision with root package name */
    private List<View> f15428b = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    private final Debouncer f15436j = new Debouncer();

    /* renamed from: n  reason: collision with root package name */
    private int f15440n = 0;

    /* renamed from: d  reason: collision with root package name */
    private Database f15430d = Database.getInstance();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        long f15442a = 0;

        /* renamed from: b  reason: collision with root package name */
        long f15443b = 0;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FloatingActionButton f15444c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f15445d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ FloatingButtonTrigger f15446e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f15447f;

        a(FloatingActionButton floatingActionButton, View view, FloatingButtonTrigger floatingButtonTrigger, int i4) {
            this.f15444c = floatingActionButton;
            this.f15445d = view;
            this.f15446e = floatingButtonTrigger;
            this.f15447f = i4;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z3;
            FloatingActionButton floatingActionButton = this.f15444c;
            if (floatingActionButton != null && ViewCompat.isAttachedToWindow(floatingActionButton)) {
                try {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f15445d.getLayoutParams();
                    int rawX = (int) motionEvent.getRawX();
                    int rawY = (int) motionEvent.getRawY();
                    int action = motionEvent.getAction();
                    if (action != 0) {
                        boolean z4 = false;
                        if (action != 1) {
                            if (action == 2 && System.currentTimeMillis() > this.f15442a + 325) {
                                FloatingButtonService.this.f15434h = true;
                                int i4 = rawX - FloatingButtonService.this.f15437k;
                                int i5 = rawY - FloatingButtonService.this.f15438l;
                                layoutParams.x = FloatingButtonService.this.f15439m + i4;
                                layoutParams.y = FloatingButtonService.this.f15440n + i5;
                                FloatingButtonService.this.f15427a.updateViewLayout(this.f15445d, layoutParams);
                                if (!this.f15446e.getPreventRemoveByDrag() && (i4 > FloatingButtonService.this.f15429c || i5 > FloatingButtonService.this.f15429c)) {
                                    int i6 = ((WindowManager.LayoutParams) this.f15445d.getLayoutParams()).x;
                                    if (((WindowManager.LayoutParams) this.f15445d.getLayoutParams()).y >= (this.f15447f / 2) - (FloatingButtonService.this.f15432f * 1.3d) && Math.abs(i6) < FloatingButtonService.this.f15432f * 0.5d) {
                                        z4 = true;
                                    }
                                    FloatingButtonService.this.y(this.f15447f, z4);
                                }
                            }
                        } else {
                            int i7 = rawX - FloatingButtonService.this.f15437k;
                            int i8 = rawY - FloatingButtonService.this.f15438l;
                            FloatingButtonService.this.f15427a.updateViewLayout(this.f15445d, layoutParams);
                            if (!FloatingButtonService.this.f15434h || (i7 < FloatingButtonService.this.f15429c && i8 < FloatingButtonService.this.f15429c)) {
                                FloatingButtonService.this.w((Trigger) this.f15444c.getTag());
                            }
                            FloatingButtonService.this.f15427a.updateViewLayout(this.f15445d, layoutParams);
                            this.f15444c.setPressed(false);
                            int i9 = ((WindowManager.LayoutParams) this.f15445d.getLayoutParams()).x;
                            int i10 = ((WindowManager.LayoutParams) this.f15445d.getLayoutParams()).y;
                            FloatingButtonService.this.f15434h = false;
                            if (!this.f15446e.getPreventRemoveByDrag() && FloatingButtonService.this.f15433g != null && i10 >= (this.f15447f / 2) - (FloatingButtonService.this.f15432f * 1.3d) && Math.abs(i9) < FloatingButtonService.this.f15432f * 0.5d) {
                                Macro macro = this.f15446e.getMacro();
                                if (macro != null) {
                                    WaitUntilTriggerAction waitForTriggerActive = macro.getWaitForTriggerActive();
                                    if (waitForTriggerActive != null) {
                                        Iterator<Trigger> it = waitForTriggerActive.getTriggersToWaitFor().iterator();
                                        while (it.hasNext()) {
                                            if (it.next().getSIGUID() == this.f15446e.getSIGUID()) {
                                                this.f15446e.disableTriggerThreadSafe();
                                                z3 = true;
                                                break;
                                            }
                                        }
                                    }
                                    z3 = false;
                                    if (!z3) {
                                        if (this.f15446e.getIsDisableTriggerOnRemove()) {
                                            this.f15446e.setEnabled(false);
                                            FloatingButtonService.this.v();
                                        } else {
                                            macro.setEnabled(false);
                                            MacroStore.getInstance().updateMacroState(macro);
                                            EventBusUtils.getEventBus().post(new MacroEnabledStateChangeEvent(this.f15446e.getMacro(), false));
                                            Context applicationContext = FloatingButtonService.this.getApplicationContext();
                                            ToastCompat.makeText(applicationContext, (CharSequence) (this.f15446e.getMacro().getName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + FloatingButtonService.this.getString(R.string.disabled)), 0).show();
                                        }
                                    }
                                }
                                z4 = true;
                            }
                            if (!z4) {
                                if (FloatingButtonService.this.f15431e < this.f15447f) {
                                    FloatingButtonService.this.f15430d.setLocationOfFloatingButtonPortrait(this.f15446e.getSIGUID(), i9, i10);
                                } else {
                                    FloatingButtonService.this.f15430d.setLocationOfFloatingButtonLandscape(this.f15446e.getSIGUID(), i9, i10);
                                }
                            }
                            FloatingButtonService.this.x();
                        }
                    } else {
                        this.f15442a = System.currentTimeMillis();
                        FloatingButtonService.this.f15437k = rawX;
                        FloatingButtonService.this.f15438l = rawY;
                        FloatingButtonService.this.f15439m = layoutParams.x;
                        FloatingButtonService.this.f15440n = layoutParams.y;
                        this.f15444c.setPressed(true);
                    }
                } catch (IllegalArgumentException e4) {
                    FirebaseAnalyticsEventLogger.logHandledException(e4);
                }
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    class b implements Runnable {

        /* loaded from: classes3.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (FloatingButtonService.this.f15435i) {
                    FloatingButtonService.this.v();
                }
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            new Handler(Looper.getMainLooper()).post(new a());
        }
    }

    public static int makeDarkerColor(int i4) {
        Color.colorToHSV(i4, r0);
        float[] fArr = {0.0f, 0.0f, fArr[2] * 0.75f};
        return Color.HSVToColor(fArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void v() {
        boolean z3;
        Set<String> set;
        int intValue;
        int i4;
        int overlayType;
        int i5;
        boolean canDrawOverlays;
        int i6;
        int i7;
        int i8;
        float f4;
        for (View view : this.f15428b) {
            try {
                this.f15427a.removeView(view);
            } catch (Exception unused) {
            }
        }
        this.f15428b.clear();
        if (!Settings.getMacroDroidEnabled(this)) {
            return;
        }
        WindowManager windowManager = (WindowManager) getSystemService("window");
        this.f15427a = windowManager;
        this.f15431e = windowManager.getDefaultDisplay().getWidth();
        int height = this.f15427a.getDefaultDisplay().getHeight();
        if (this.f15431e < height) {
            z3 = true;
        } else {
            z3 = false;
        }
        Set<String> disabledCategories = Settings.getDisabledCategories(this);
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if ((next instanceof FloatingButtonTrigger) && next.isEnabled() && (macro.isExtra() || !disabledCategories.contains(macro.getCategory()))) {
                    FloatingButtonTrigger floatingButtonTrigger = (FloatingButtonTrigger) next;
                    Pair<Integer, Integer> locationOfFloatingButton = this.f15430d.getLocationOfFloatingButton(floatingButtonTrigger.getSIGUID(), z3, this.f15431e, height, this.f15432f);
                    if (floatingButtonTrigger.getSize() == 0) {
                        this.f15432f = getResources().getDimensionPixelSize(R.dimen.floating_button_size);
                    } else {
                        this.f15432f = getResources().getDimensionPixelSize(R.dimen.floating_button_size_mini);
                    }
                    Point forcedStartLocation = floatingButtonTrigger.getForcedStartLocation();
                    if (forcedStartLocation != null) {
                        if (floatingButtonTrigger.getForceStartLocationIsPercent()) {
                            int i9 = forcedStartLocation.x;
                            int i10 = this.f15431e;
                            int i11 = ((i9 * i10) / 100) - (i10 / 2);
                            i6 = ((forcedStartLocation.y * height) / 100) - (height / 2);
                            float abs = Math.abs(i11) / (this.f15431e / 2.0f);
                            float abs2 = Math.abs(i6) / (height / 2.0f);
                            if (i11 < 0) {
                                i8 = this.f15432f / 2;
                            } else {
                                i8 = (-this.f15432f) / 2;
                            }
                            i4 = i11 + ((int) (i8 * abs));
                            if (i6 < 0) {
                                f4 = (this.f15432f / 2) * abs;
                            } else {
                                f4 = abs2 * ((-this.f15432f) / 2);
                            }
                            i7 = (int) f4;
                        } else {
                            int i12 = forcedStartLocation.x - (this.f15431e / 2);
                            int i13 = this.f15432f;
                            i4 = i12 + (i13 / 2);
                            i6 = forcedStartLocation.y - (height / 2);
                            i7 = i13 / 2;
                        }
                        intValue = i6 + i7;
                    } else if (locationOfFloatingButton == null) {
                        i4 = (this.f15431e / 2) - (this.f15432f / 2);
                        intValue = 0;
                    } else {
                        int intValue2 = locationOfFloatingButton.first.intValue();
                        intValue = locationOfFloatingButton.second.intValue();
                        i4 = intValue2;
                    }
                    int i14 = this.f15431e;
                    int i15 = this.f15432f;
                    if (i4 < ((-i14) / 2) + (i15 / 2)) {
                        i4 = ((-i14) / 2) + (i15 / 2);
                    } else if (i4 > (i14 / 2) - (i15 / 2)) {
                        i4 = (i14 / 2) - (i15 / 2);
                    }
                    int i16 = i4;
                    int i17 = -height;
                    if (intValue < (i17 / 2) + (i15 / 2)) {
                        intValue = (i17 / 2) + (i15 / 2);
                    } else if (intValue > (height / 2) - (i15 / 2)) {
                        intValue = (height / 2) - (i15 / 2);
                    }
                    int i18 = intValue;
                    int i19 = this.f15432f;
                    if (floatingButtonTrigger.getShowOnLockScreen()) {
                        overlayType = OverlayUtils.getOverlayTypeLockScreen();
                    } else {
                        overlayType = OverlayUtils.getOverlayType();
                    }
                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(i19, i19, i16, i18, overlayType, 786472, -3);
                    this.f15441o = layoutParams;
                    layoutParams.windowAnimations = R.style.FloatingButtonAnimation;
                    View inflate = View.inflate(getApplicationContext(), R.layout.floating_button, null);
                    FloatingActionButton floatingActionButton = (FloatingActionButton) inflate.findViewById(R.id.fab);
                    this.f15428b.add(inflate);
                    floatingActionButton.setTag(floatingButtonTrigger);
                    int makeDarkerColor = makeDarkerColor(floatingButtonTrigger.getBackgroundColor());
                    floatingActionButton.setColorNormal(floatingButtonTrigger.getBackgroundColor());
                    floatingActionButton.setColorRipple(makeDarkerColor);
                    floatingActionButton.setColorPressed(floatingButtonTrigger.getBackgroundColor());
                    floatingActionButton.setAlpha(floatingButtonTrigger.getAlpha() / 100.0f);
                    floatingButtonTrigger.setImageOnFloatingView(floatingActionButton);
                    if (floatingButtonTrigger.getSize() == 0) {
                        i5 = 0;
                    } else {
                        i5 = 1;
                    }
                    floatingActionButton.setType(i5);
                    set = disabledCategories;
                    floatingActionButton.setOnTouchListener(new a(floatingActionButton, inflate, floatingButtonTrigger, height));
                    if (Build.VERSION.SDK_INT >= 23) {
                        canDrawOverlays = android.provider.Settings.canDrawOverlays(this);
                        if (!canDrawOverlays) {
                        }
                    }
                    try {
                        this.f15427a.addView(inflate, this.f15441o);
                    } catch (Exception e4) {
                        SystemLog.logError("Failed to add floating button: " + e4);
                    }
                } else {
                    set = disabledCategories;
                }
                disabledCategories = set;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Trigger trigger) {
        if (trigger.constraintsMet()) {
            Macro macro = trigger.getMacro();
            if (macro == null) {
                SystemLog.logError("No macro associated with floating button trigger");
                return;
            }
            macro.setTriggerThatInvoked(trigger);
            if (macro.canInvoke(macro.getTriggerContextInfo())) {
                trigger.getMacro().invokeActions(macro.getTriggerContextInfo());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        View view = this.f15433g;
        if (view != null) {
            try {
                this.f15427a.removeView(view);
            } catch (Exception unused) {
            }
            this.f15433g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(float f4, boolean z3) {
        int i4;
        if (this.f15433g == null) {
            this.f15433g = View.inflate(getBaseContext(), R.layout.floating_button_delete, null);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 0, (((int) f4) / 2) - this.f15432f, OverlayUtils.getOverlayType(), 786472, -3);
            layoutParams.windowAnimations = R.style.FloatingButtonAnimation;
            this.f15427a.addView(this.f15433g, layoutParams);
        }
        View view = this.f15433g;
        if (z3) {
            i4 = R.drawable.floating_button_delete_active_background;
        } else {
            i4 = R.drawable.floating_button_delete_background;
        }
        view.setBackgroundResource(i4);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f15435i = true;
        EventBusUtils.getEventBus().register(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f15435i = false;
        EventBusUtils.getEventBus().unregister(this);
        for (View view : this.f15428b) {
            try {
                this.f15427a.removeView(view);
            } catch (Exception unused) {
            }
        }
        this.f15428b.clear();
        super.onDestroy();
    }

    public void onEventMainThread(FloatingButtonsUpdateEvent floatingButtonsUpdateEvent) {
        this.f15436j.debounce(Void.class, new b(), 400L, TimeUnit.MILLISECONDS);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        this.f15429c = TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        v();
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        stopSelf();
    }
}
