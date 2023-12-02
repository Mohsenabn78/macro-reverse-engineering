package com.android.billingclient.api;

import androidx.annotation.NonNull;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
@zzk
/* loaded from: classes2.dex */
public interface PurchasesResponseListener {
    @zzk
    void onQueryPurchasesResponse(@NonNull BillingResult billingResult, @NonNull List<Purchase> list);
}
