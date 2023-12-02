package com.arlosoft.macrodroid.action.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.events.DrawerHandleUpdateEvent;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.settings.Settings;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BlockTouchesService.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class BlockTouchesService extends Service {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private WindowManager f4867a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private View f4868b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final ScreenOffReceiver f4869c = new ScreenOffReceiver();
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f4866d = true;

    /* compiled from: BlockTouchesService.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isEnabled() {
            return BlockTouchesService.f4866d;
        }
    }

    private final void a() {
        WindowManager windowManager = this.f4867a;
        Intrinsics.checkNotNull(windowManager);
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        View view = this.f4868b;
        Intrinsics.checkNotNull(view);
        view.setBackgroundColor(0);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, (int) (point.y * 1.5d), 0, 0, b(), 786472, -3);
        try {
            WindowManager windowManager2 = this.f4867a;
            Intrinsics.checkNotNull(windowManager2);
            windowManager2.addView(this.f4868b, layoutParams);
        } catch (Exception e4) {
            SystemLog.logWarning("Block touches failed: requires SYSTEM_ALERT_WINDOW permission - " + e4);
            Context applicationContext = getApplicationContext();
            String string = getString(R.string.action_dim_screen);
            String string2 = getString(R.string.action_failed_requires_permission);
            ToastCompat.makeText(applicationContext, (CharSequence) (string + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + string2), 0).show();
        }
    }

    private final int b() {
        if (Build.VERSION.SDK_INT >= 26) {
            return 2038;
        }
        return 2006;
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        try {
            WindowManager windowManager = this.f4867a;
            if (windowManager != null && this.f4868b != null) {
                Intrinsics.checkNotNull(windowManager);
                windowManager.removeView(this.f4868b);
            }
        } catch (IllegalArgumentException unused) {
        }
        a();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        f4866d = true;
        registerReceiver(this.f4869c, intentFilter);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f4866d = false;
        try {
            WindowManager windowManager = this.f4867a;
            Intrinsics.checkNotNull(windowManager);
            windowManager.removeView(this.f4868b);
        } catch (Exception unused) {
        }
        try {
            unregisterReceiver(this.f4869c);
        } catch (Exception unused2) {
        }
        EventBusUtils.getEventBus().post(new DrawerHandleUpdateEvent(Settings.getDrawerConfiguration(this)));
    }

    @Override // android.app.Service
    public int onStartCommand(@NotNull Intent intent, int i4, int i5) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Object systemService = getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.f4867a = (WindowManager) systemService;
        this.f4868b = View.inflate(getBaseContext(), R.layout.dimmer_overlay, null);
        a();
        EventBusUtils.getEventBus().post(new DrawerHandleUpdateEvent(Settings.getDrawerConfiguration(this)));
        return 3;
    }
}
