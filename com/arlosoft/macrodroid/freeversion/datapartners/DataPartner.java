package com.arlosoft.macrodroid.freeversion.datapartners;

import androidx.compose.runtime.internal.StabilityInferred;
import com.google.firebase.analytics.ktx.AnalyticsKt;
import com.google.firebase.ktx.Firebase;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: DataPartner.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class DataPartner {
    public static final int $stable = 0;

    public abstract void disableDataSharing(boolean z3);

    public abstract void enableDataSharing();

    public abstract void initialise(@NotNull Function1<? super Boolean, Unit> function1);

    @NotNull
    public abstract String partnerName();

    public final void trackDataSharingDisabled() {
        AnalyticsKt.getAnalytics(Firebase.INSTANCE).setUserProperty("data_sharing", "");
    }

    public final void trackDataSharingEnabled() {
        AnalyticsKt.getAnalytics(Firebase.INSTANCE).setUserProperty("data_sharing", partnerName());
    }
}
