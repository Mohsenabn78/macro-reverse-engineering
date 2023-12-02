package com.arlosoft.macrodroid.action.dim;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.events.DrawerHandleUpdateEvent;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.settings.Settings;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class DimOverlayService extends Service {
    public static final String KEY_PERCENTAGE = "percentage";
    public static int dimPercentage = 100;
    public static boolean isDimmed = false;

    /* renamed from: a  reason: collision with root package name */
    private WindowManager f3363a;

    /* renamed from: b  reason: collision with root package name */
    private View f3364b;

    /* renamed from: c  reason: collision with root package name */
    private int f3365c;

    private void a() {
        Display defaultDisplay = this.f3363a.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.f3364b.setBackgroundColor(-16777216);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, (int) (point.y * 1.5d), 0, 0, b(), 1816, -3);
        layoutParams.alpha = (this.f3365c / 100.0f) * 0.8f;
        layoutParams.gravity = 17;
        try {
            this.f3363a.addView(this.f3364b, layoutParams);
        } catch (Exception e4) {
            SystemLog.logWarning("Dim Overlay failed: requires SYSTEM_ALERT_WINDOW permission - " + e4.toString());
            Context applicationContext = getApplicationContext();
            ToastCompat.makeText(applicationContext, (CharSequence) (getString(R.string.action_dim_screen) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getString(R.string.action_failed_requires_permission)), 0).show();
        }
    }

    private int b() {
        if (Build.VERSION.SDK_INT >= 26) {
            return 2038;
        }
        return 2006;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        View view;
        super.onConfigurationChanged(configuration);
        try {
            WindowManager windowManager = this.f3363a;
            if (windowManager != null && (view = this.f3364b) != null) {
                windowManager.removeView(view);
            }
        } catch (IllegalArgumentException unused) {
        }
        a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            this.f3363a.removeView(this.f3364b);
        } catch (Exception unused) {
        }
        isDimmed = false;
        EventBusUtils.getEventBus().post(new DrawerHandleUpdateEvent(Settings.getDrawerConfiguration(this)));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        int intExtra = intent.getIntExtra(KEY_PERCENTAGE, 50);
        this.f3365c = intExtra;
        dimPercentage = intExtra;
        this.f3363a = (WindowManager) getSystemService("window");
        this.f3364b = View.inflate(getBaseContext(), R.layout.dimmer_overlay, null);
        a();
        isDimmed = true;
        EventBusUtils.getEventBus().post(new DrawerHandleUpdateEvent(Settings.getDrawerConfiguration(this)));
        return 3;
    }
}
