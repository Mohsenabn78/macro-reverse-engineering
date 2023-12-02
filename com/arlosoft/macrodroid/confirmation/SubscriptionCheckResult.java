package com.arlosoft.macrodroid.confirmation;

import androidx.compose.animation.a;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SubscriptionData.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class SubscriptionCheckResult {
    public static final int $stable = 0;
    private final long checkTime;
    @NotNull
    private final String expiryTime;
    @NotNull
    private final String message;
    private final int status;
    @NotNull
    private final String subscriptionState;

    public SubscriptionCheckResult(int i4, @NotNull String message, @NotNull String subscriptionState, long j4, @NotNull String expiryTime) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(subscriptionState, "subscriptionState");
        Intrinsics.checkNotNullParameter(expiryTime, "expiryTime");
        this.status = i4;
        this.message = message;
        this.subscriptionState = subscriptionState;
        this.checkTime = j4;
        this.expiryTime = expiryTime;
    }

    public static /* synthetic */ SubscriptionCheckResult copy$default(SubscriptionCheckResult subscriptionCheckResult, int i4, String str, String str2, long j4, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = subscriptionCheckResult.status;
        }
        if ((i5 & 2) != 0) {
            str = subscriptionCheckResult.message;
        }
        String str4 = str;
        if ((i5 & 4) != 0) {
            str2 = subscriptionCheckResult.subscriptionState;
        }
        String str5 = str2;
        if ((i5 & 8) != 0) {
            j4 = subscriptionCheckResult.checkTime;
        }
        long j5 = j4;
        if ((i5 & 16) != 0) {
            str3 = subscriptionCheckResult.expiryTime;
        }
        return subscriptionCheckResult.copy(i4, str4, str5, j5, str3);
    }

    public final int component1() {
        return this.status;
    }

    @NotNull
    public final String component2() {
        return this.message;
    }

    @NotNull
    public final String component3() {
        return this.subscriptionState;
    }

    public final long component4() {
        return this.checkTime;
    }

    @NotNull
    public final String component5() {
        return this.expiryTime;
    }

    @NotNull
    public final SubscriptionCheckResult copy(int i4, @NotNull String message, @NotNull String subscriptionState, long j4, @NotNull String expiryTime) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(subscriptionState, "subscriptionState");
        Intrinsics.checkNotNullParameter(expiryTime, "expiryTime");
        return new SubscriptionCheckResult(i4, message, subscriptionState, j4, expiryTime);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionCheckResult)) {
            return false;
        }
        SubscriptionCheckResult subscriptionCheckResult = (SubscriptionCheckResult) obj;
        if (this.status == subscriptionCheckResult.status && Intrinsics.areEqual(this.message, subscriptionCheckResult.message) && Intrinsics.areEqual(this.subscriptionState, subscriptionCheckResult.subscriptionState) && this.checkTime == subscriptionCheckResult.checkTime && Intrinsics.areEqual(this.expiryTime, subscriptionCheckResult.expiryTime)) {
            return true;
        }
        return false;
    }

    public final long getCheckTime() {
        return this.checkTime;
    }

    @NotNull
    public final String getExpiryTime() {
        return this.expiryTime;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public final int getStatus() {
        return this.status;
    }

    @NotNull
    public final String getSubscriptionState() {
        return this.subscriptionState;
    }

    public int hashCode() {
        return (((((((this.status * 31) + this.message.hashCode()) * 31) + this.subscriptionState.hashCode()) * 31) + a.a(this.checkTime)) * 31) + this.expiryTime.hashCode();
    }

    @NotNull
    public String toString() {
        int i4 = this.status;
        String str = this.message;
        String str2 = this.subscriptionState;
        long j4 = this.checkTime;
        String str3 = this.expiryTime;
        return "SubscriptionCheckResult(status=" + i4 + ", message=" + str + ", subscriptionState=" + str2 + ", checkTime=" + j4 + ", expiryTime=" + str3 + ")";
    }
}
