package com.arlosoft.macrodroid.extras.ui;

import com.arlosoft.macrodroid.extras.data.ExtraPackage;
import com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState;
import com.arlosoft.macrodroid.remoteconfig.ExtraMinVersion;
import org.jetbrains.annotations.NotNull;

/* compiled from: ExtrasAdapter.kt */
/* loaded from: classes3.dex */
public interface ExtraPackageClickListener {

    /* compiled from: ExtrasAdapter.kt */
    /* loaded from: classes3.dex */
    public enum PurchasePeriod {
        WEEKLY,
        MONTHLY,
        YEARLY,
        WEEKLY_PREPAID,
        MONTHLY_PREPAID,
        YEARLY_PREPAID
    }

    void onEmailClicked(@NotNull ExtraPackageWithPriceAndState extraPackageWithPriceAndState);

    void onInstallVersionUpdateClicked(@NotNull ExtraPackageWithPriceAndState extraPackageWithPriceAndState);

    void onManageSubscriptionClicked(@NotNull ExtraPackage extraPackage);

    void onNeedsMacroDroidUpdate(@NotNull ExtraMinVersion extraMinVersion);

    void onPurchaseClick(@NotNull ExtraPackageWithPriceAndState extraPackageWithPriceAndState, @NotNull PurchasePeriod purchasePeriod);

    void onRetryValidationClicked(@NotNull ExtraPackageWithPriceAndState extraPackageWithPriceAndState);

    void onTelegramClicked(@NotNull String str);

    void onVersionHistoryClicked(@NotNull ExtraPackage extraPackage);

    void onWhatsAppClicked(@NotNull String str);
}
