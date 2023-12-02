package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.Logger;

/* loaded from: classes5.dex */
class BatteryState {

    /* renamed from: a  reason: collision with root package name */
    private final Float f29388a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f29389b;

    private BatteryState(Float f4, boolean z3) {
        this.f29389b = z3;
        this.f29388a = f4;
    }

    public static BatteryState a(Context context) {
        boolean z3 = false;
        Float f4 = null;
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                z3 = e(registerReceiver);
                f4 = d(registerReceiver);
            }
        } catch (IllegalStateException e4) {
            Logger.getLogger().e("An error occurred getting battery state.", e4);
        }
        return new BatteryState(f4, z3);
    }

    private static Float d(Intent intent) {
        int intExtra = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        if (intExtra != -1 && intExtra2 != -1) {
            return Float.valueOf(intExtra / intExtra2);
        }
        return null;
    }

    private static boolean e(Intent intent) {
        int intExtra = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
        if (intExtra == -1) {
            return false;
        }
        if (intExtra != 2 && intExtra != 5) {
            return false;
        }
        return true;
    }

    public Float b() {
        return this.f29388a;
    }

    public int c() {
        Float f4;
        if (this.f29389b && (f4 = this.f29388a) != null) {
            if (f4.floatValue() < 0.99d) {
                return 2;
            }
            return 3;
        }
        return 1;
    }
}
