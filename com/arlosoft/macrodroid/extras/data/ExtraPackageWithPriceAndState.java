package com.arlosoft.macrodroid.extras.data;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.remoteconfig.ExtraMinVersion;
import com.arlosoft.macrodroid.upgrade.billing.SubscriptionPrice;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExtraPackage.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class ExtraPackageWithPriceAndState {
    public static final int $stable = 8;
    @Nullable
    private final List<Macro> decryptedMacros;
    @NotNull
    private final ExtraPackage extra;
    @Nullable
    private Integer installedVersion;
    private boolean isEnabled;
    @NotNull
    private ExtraMinVersion minVersionRemoteConfig;
    @Nullable
    private SubscriptionPrice priceMonthly;
    @Nullable
    private SubscriptionPrice priceWeekly;
    @Nullable
    private SubscriptionPrice priceYearly;
    @NotNull
    private UpdateState updateState;
    private boolean usedTrial;
    @NotNull
    private ValidationState validationState;

    /* JADX WARN: Multi-variable type inference failed */
    public ExtraPackageWithPriceAndState(@NotNull ExtraPackage extra, @NotNull ExtraMinVersion minVersionRemoteConfig, @Nullable SubscriptionPrice subscriptionPrice, @Nullable SubscriptionPrice subscriptionPrice2, @Nullable SubscriptionPrice subscriptionPrice3, @Nullable Integer num, @Nullable List<? extends Macro> list, @NotNull ValidationState validationState, @NotNull UpdateState updateState, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        Intrinsics.checkNotNullParameter(minVersionRemoteConfig, "minVersionRemoteConfig");
        Intrinsics.checkNotNullParameter(validationState, "validationState");
        Intrinsics.checkNotNullParameter(updateState, "updateState");
        this.extra = extra;
        this.minVersionRemoteConfig = minVersionRemoteConfig;
        this.priceWeekly = subscriptionPrice;
        this.priceMonthly = subscriptionPrice2;
        this.priceYearly = subscriptionPrice3;
        this.installedVersion = num;
        this.decryptedMacros = list;
        this.validationState = validationState;
        this.updateState = updateState;
        this.usedTrial = z3;
        this.isEnabled = z4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExtraPackageWithPriceAndState copy$default(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, ExtraPackage extraPackage, ExtraMinVersion extraMinVersion, SubscriptionPrice subscriptionPrice, SubscriptionPrice subscriptionPrice2, SubscriptionPrice subscriptionPrice3, Integer num, List list, ValidationState validationState, UpdateState updateState, boolean z3, boolean z4, int i4, Object obj) {
        ExtraPackage extraPackage2;
        ExtraMinVersion extraMinVersion2;
        SubscriptionPrice subscriptionPrice4;
        SubscriptionPrice subscriptionPrice5;
        SubscriptionPrice subscriptionPrice6;
        Integer num2;
        List<Macro> list2;
        ValidationState validationState2;
        UpdateState updateState2;
        boolean z5;
        boolean z6;
        if ((i4 & 1) != 0) {
            extraPackage2 = extraPackageWithPriceAndState.extra;
        } else {
            extraPackage2 = extraPackage;
        }
        if ((i4 & 2) != 0) {
            extraMinVersion2 = extraPackageWithPriceAndState.minVersionRemoteConfig;
        } else {
            extraMinVersion2 = extraMinVersion;
        }
        if ((i4 & 4) != 0) {
            subscriptionPrice4 = extraPackageWithPriceAndState.priceWeekly;
        } else {
            subscriptionPrice4 = subscriptionPrice;
        }
        if ((i4 & 8) != 0) {
            subscriptionPrice5 = extraPackageWithPriceAndState.priceMonthly;
        } else {
            subscriptionPrice5 = subscriptionPrice2;
        }
        if ((i4 & 16) != 0) {
            subscriptionPrice6 = extraPackageWithPriceAndState.priceYearly;
        } else {
            subscriptionPrice6 = subscriptionPrice3;
        }
        if ((i4 & 32) != 0) {
            num2 = extraPackageWithPriceAndState.installedVersion;
        } else {
            num2 = num;
        }
        if ((i4 & 64) != 0) {
            list2 = extraPackageWithPriceAndState.decryptedMacros;
        } else {
            list2 = list;
        }
        if ((i4 & 128) != 0) {
            validationState2 = extraPackageWithPriceAndState.validationState;
        } else {
            validationState2 = validationState;
        }
        if ((i4 & 256) != 0) {
            updateState2 = extraPackageWithPriceAndState.updateState;
        } else {
            updateState2 = updateState;
        }
        if ((i4 & 512) != 0) {
            z5 = extraPackageWithPriceAndState.usedTrial;
        } else {
            z5 = z3;
        }
        if ((i4 & 1024) != 0) {
            z6 = extraPackageWithPriceAndState.isEnabled;
        } else {
            z6 = z4;
        }
        return extraPackageWithPriceAndState.copy(extraPackage2, extraMinVersion2, subscriptionPrice4, subscriptionPrice5, subscriptionPrice6, num2, list2, validationState2, updateState2, z5, z6);
    }

    @NotNull
    public final ExtraPackage component1() {
        return this.extra;
    }

    public final boolean component10() {
        return this.usedTrial;
    }

    public final boolean component11() {
        return this.isEnabled;
    }

    @NotNull
    public final ExtraMinVersion component2() {
        return this.minVersionRemoteConfig;
    }

    @Nullable
    public final SubscriptionPrice component3() {
        return this.priceWeekly;
    }

    @Nullable
    public final SubscriptionPrice component4() {
        return this.priceMonthly;
    }

    @Nullable
    public final SubscriptionPrice component5() {
        return this.priceYearly;
    }

    @Nullable
    public final Integer component6() {
        return this.installedVersion;
    }

    @Nullable
    public final List<Macro> component7() {
        return this.decryptedMacros;
    }

    @NotNull
    public final ValidationState component8() {
        return this.validationState;
    }

    @NotNull
    public final UpdateState component9() {
        return this.updateState;
    }

    @NotNull
    public final ExtraPackageWithPriceAndState copy(@NotNull ExtraPackage extra, @NotNull ExtraMinVersion minVersionRemoteConfig, @Nullable SubscriptionPrice subscriptionPrice, @Nullable SubscriptionPrice subscriptionPrice2, @Nullable SubscriptionPrice subscriptionPrice3, @Nullable Integer num, @Nullable List<? extends Macro> list, @NotNull ValidationState validationState, @NotNull UpdateState updateState, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        Intrinsics.checkNotNullParameter(minVersionRemoteConfig, "minVersionRemoteConfig");
        Intrinsics.checkNotNullParameter(validationState, "validationState");
        Intrinsics.checkNotNullParameter(updateState, "updateState");
        return new ExtraPackageWithPriceAndState(extra, minVersionRemoteConfig, subscriptionPrice, subscriptionPrice2, subscriptionPrice3, num, list, validationState, updateState, z3, z4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtraPackageWithPriceAndState)) {
            return false;
        }
        ExtraPackageWithPriceAndState extraPackageWithPriceAndState = (ExtraPackageWithPriceAndState) obj;
        if (Intrinsics.areEqual(this.extra, extraPackageWithPriceAndState.extra) && Intrinsics.areEqual(this.minVersionRemoteConfig, extraPackageWithPriceAndState.minVersionRemoteConfig) && Intrinsics.areEqual(this.priceWeekly, extraPackageWithPriceAndState.priceWeekly) && Intrinsics.areEqual(this.priceMonthly, extraPackageWithPriceAndState.priceMonthly) && Intrinsics.areEqual(this.priceYearly, extraPackageWithPriceAndState.priceYearly) && Intrinsics.areEqual(this.installedVersion, extraPackageWithPriceAndState.installedVersion) && Intrinsics.areEqual(this.decryptedMacros, extraPackageWithPriceAndState.decryptedMacros) && this.validationState == extraPackageWithPriceAndState.validationState && this.updateState == extraPackageWithPriceAndState.updateState && this.usedTrial == extraPackageWithPriceAndState.usedTrial && this.isEnabled == extraPackageWithPriceAndState.isEnabled) {
            return true;
        }
        return false;
    }

    @Nullable
    public final List<Macro> getDecryptedMacros() {
        return this.decryptedMacros;
    }

    @NotNull
    public final ExtraPackage getExtra() {
        return this.extra;
    }

    @Nullable
    public final Integer getInstalledVersion() {
        return this.installedVersion;
    }

    @NotNull
    public final ExtraMinVersion getMinVersionRemoteConfig() {
        return this.minVersionRemoteConfig;
    }

    @Nullable
    public final SubscriptionPrice getPriceMonthly() {
        return this.priceMonthly;
    }

    @Nullable
    public final SubscriptionPrice getPriceWeekly() {
        return this.priceWeekly;
    }

    @Nullable
    public final SubscriptionPrice getPriceYearly() {
        return this.priceYearly;
    }

    @NotNull
    public final UpdateState getUpdateState() {
        return this.updateState;
    }

    public final boolean getUsedTrial() {
        return this.usedTrial;
    }

    @NotNull
    public final ValidationState getValidationState() {
        return this.validationState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5 = ((this.extra.hashCode() * 31) + this.minVersionRemoteConfig.hashCode()) * 31;
        SubscriptionPrice subscriptionPrice = this.priceWeekly;
        int i4 = 0;
        if (subscriptionPrice == null) {
            hashCode = 0;
        } else {
            hashCode = subscriptionPrice.hashCode();
        }
        int i5 = (hashCode5 + hashCode) * 31;
        SubscriptionPrice subscriptionPrice2 = this.priceMonthly;
        if (subscriptionPrice2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = subscriptionPrice2.hashCode();
        }
        int i6 = (i5 + hashCode2) * 31;
        SubscriptionPrice subscriptionPrice3 = this.priceYearly;
        if (subscriptionPrice3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = subscriptionPrice3.hashCode();
        }
        int i7 = (i6 + hashCode3) * 31;
        Integer num = this.installedVersion;
        if (num == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = num.hashCode();
        }
        int i8 = (i7 + hashCode4) * 31;
        List<Macro> list = this.decryptedMacros;
        if (list != null) {
            i4 = list.hashCode();
        }
        int hashCode6 = (((((i8 + i4) * 31) + this.validationState.hashCode()) * 31) + this.updateState.hashCode()) * 31;
        boolean z3 = this.usedTrial;
        int i9 = 1;
        int i10 = z3;
        if (z3 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode6 + i10) * 31;
        boolean z4 = this.isEnabled;
        if (!z4) {
            i9 = z4 ? 1 : 0;
        }
        return i11 + i9;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final void setEnabled(boolean z3) {
        this.isEnabled = z3;
    }

    public final void setInstalledVersion(@Nullable Integer num) {
        this.installedVersion = num;
    }

    public final void setMinVersionRemoteConfig(@NotNull ExtraMinVersion extraMinVersion) {
        Intrinsics.checkNotNullParameter(extraMinVersion, "<set-?>");
        this.minVersionRemoteConfig = extraMinVersion;
    }

    public final void setPriceMonthly(@Nullable SubscriptionPrice subscriptionPrice) {
        this.priceMonthly = subscriptionPrice;
    }

    public final void setPriceWeekly(@Nullable SubscriptionPrice subscriptionPrice) {
        this.priceWeekly = subscriptionPrice;
    }

    public final void setPriceYearly(@Nullable SubscriptionPrice subscriptionPrice) {
        this.priceYearly = subscriptionPrice;
    }

    public final void setUpdateState(@NotNull UpdateState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "<set-?>");
        this.updateState = updateState;
    }

    public final void setUsedTrial(boolean z3) {
        this.usedTrial = z3;
    }

    public final void setValidationState(@NotNull ValidationState validationState) {
        Intrinsics.checkNotNullParameter(validationState, "<set-?>");
        this.validationState = validationState;
    }

    @NotNull
    public String toString() {
        String id = this.extra.getId();
        int versionCode = this.extra.getVersionCode();
        Integer num = this.installedVersion;
        ValidationState validationState = this.validationState;
        return "id = " + id + ", versionCode = " + versionCode + ", installedVersion = " + num + ", validationState = " + validationState;
    }

    public /* synthetic */ ExtraPackageWithPriceAndState(ExtraPackage extraPackage, ExtraMinVersion extraMinVersion, SubscriptionPrice subscriptionPrice, SubscriptionPrice subscriptionPrice2, SubscriptionPrice subscriptionPrice3, Integer num, List list, ValidationState validationState, UpdateState updateState, boolean z3, boolean z4, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(extraPackage, extraMinVersion, (i4 & 4) != 0 ? null : subscriptionPrice, (i4 & 8) != 0 ? null : subscriptionPrice2, (i4 & 16) != 0 ? null : subscriptionPrice3, (i4 & 32) != 0 ? null : num, (i4 & 64) != 0 ? null : list, (i4 & 128) != 0 ? ValidationState.NOT_VALIDATING : validationState, (i4 & 256) != 0 ? UpdateState.NOT_UPDATING : updateState, (i4 & 512) != 0 ? false : z3, (i4 & 1024) != 0 ? false : z4);
    }
}
