package com.arlosoft.macrodroid.confirmation.validation;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExtraSubscriptionData.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class ExtraSubscriptionData {
    public static final int $stable = 0;
    @NotNull
    private final String orderId;
    @NotNull
    private final String sku;
    @NotNull
    private final String token;
    @NotNull
    private final String validationCode;

    public ExtraSubscriptionData(@NotNull String sku, @NotNull String token, @NotNull String orderId, @NotNull String validationCode) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        Intrinsics.checkNotNullParameter(validationCode, "validationCode");
        this.sku = sku;
        this.token = token;
        this.orderId = orderId;
        this.validationCode = validationCode;
    }

    public static /* synthetic */ ExtraSubscriptionData copy$default(ExtraSubscriptionData extraSubscriptionData, String str, String str2, String str3, String str4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = extraSubscriptionData.sku;
        }
        if ((i4 & 2) != 0) {
            str2 = extraSubscriptionData.token;
        }
        if ((i4 & 4) != 0) {
            str3 = extraSubscriptionData.orderId;
        }
        if ((i4 & 8) != 0) {
            str4 = extraSubscriptionData.validationCode;
        }
        return extraSubscriptionData.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.sku;
    }

    @NotNull
    public final String component2() {
        return this.token;
    }

    @NotNull
    public final String component3() {
        return this.orderId;
    }

    @NotNull
    public final String component4() {
        return this.validationCode;
    }

    @NotNull
    public final ExtraSubscriptionData copy(@NotNull String sku, @NotNull String token, @NotNull String orderId, @NotNull String validationCode) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        Intrinsics.checkNotNullParameter(validationCode, "validationCode");
        return new ExtraSubscriptionData(sku, token, orderId, validationCode);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtraSubscriptionData)) {
            return false;
        }
        ExtraSubscriptionData extraSubscriptionData = (ExtraSubscriptionData) obj;
        if (Intrinsics.areEqual(this.sku, extraSubscriptionData.sku) && Intrinsics.areEqual(this.token, extraSubscriptionData.token) && Intrinsics.areEqual(this.orderId, extraSubscriptionData.orderId) && Intrinsics.areEqual(this.validationCode, extraSubscriptionData.validationCode)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getOrderId() {
        return this.orderId;
    }

    @NotNull
    public final String getSku() {
        return this.sku;
    }

    @NotNull
    public final String getToken() {
        return this.token;
    }

    @NotNull
    public final String getValidationCode() {
        return this.validationCode;
    }

    public int hashCode() {
        return (((((this.sku.hashCode() * 31) + this.token.hashCode()) * 31) + this.orderId.hashCode()) * 31) + this.validationCode.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.sku;
        String str2 = this.token;
        String str3 = this.orderId;
        String str4 = this.validationCode;
        return "ExtraSubscriptionData(sku=" + str + ", token=" + str2 + ", orderId=" + str3 + ", validationCode=" + str4 + ")";
    }
}
