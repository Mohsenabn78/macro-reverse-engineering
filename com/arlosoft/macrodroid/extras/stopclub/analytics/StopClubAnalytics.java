package com.arlosoft.macrodroid.extras.stopclub.analytics;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.ktx.AnalyticsKt;
import com.google.firebase.ktx.Firebase;
import org.jetbrains.annotations.NotNull;

/* compiled from: StopClubAnalytics.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class StopClubAnalytics {
    public static final int $stable = 0;
    @NotNull
    public static final StopClubAnalytics INSTANCE = new StopClubAnalytics();

    private StopClubAnalytics() {
    }

    public final void setFailedValidation() {
        SystemLog.logDebug("stopclub_status: failed_validation");
        AnalyticsKt.getAnalytics(Firebase.INSTANCE).setUserProperty("stopclub_status", "failed_validation");
    }

    public final void setNoSubscription() {
        SystemLog.logDebug("stopclub_status: opened");
        AnalyticsKt.getAnalytics(Firebase.INSTANCE).setUserProperty("stopclub_status", "opened");
    }

    public final void setSubscriptionActive() {
        SystemLog.logDebug("stopclub_status: active");
        AnalyticsKt.getAnalytics(Firebase.INSTANCE).setUserProperty("stopclub_status", AppMeasurementSdk.ConditionalUserProperty.ACTIVE);
    }

    public final void setSubscriptionExpired() {
        SystemLog.logDebug("stopclub_status: expired");
        AnalyticsKt.getAnalytics(Firebase.INSTANCE).setUserProperty("stopclub_status", "expired");
    }
}
