package com.android.billingclient.api;

import android.os.Bundle;
import com.android.billingclient.api.BillingResult;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes2.dex */
public final class zzbl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static BillingResult zza(Bundle bundle, String str, String str2) {
        BillingResult billingResult = zzbc.zzj;
        if (bundle == null) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", String.format("%s got null owned items list", str2));
            return billingResult;
        }
        int zzb = com.google.android.gms.internal.play_billing.zzb.zzb(bundle, "BillingClient");
        String zzf = com.google.android.gms.internal.play_billing.zzb.zzf(bundle, "BillingClient");
        BillingResult.Builder newBuilder = BillingResult.newBuilder();
        newBuilder.setResponseCode(zzb);
        newBuilder.setDebugMessage(zzf);
        BillingResult build = newBuilder.build();
        if (zzb != 0) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", String.format("%s failed. Response code: %s", str2, Integer.valueOf(zzb)));
            return build;
        } else if (bundle.containsKey("INAPP_PURCHASE_ITEM_LIST") && bundle.containsKey("INAPP_PURCHASE_DATA_LIST") && bundle.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList<String> stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            if (stringArrayList == null) {
                com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", str2));
                return billingResult;
            } else if (stringArrayList2 == null) {
                com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", String.format("Bundle returned from %s contains null purchases list.", str2));
                return billingResult;
            } else if (stringArrayList3 == null) {
                com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", String.format("Bundle returned from %s contains null signatures list.", str2));
                return billingResult;
            } else {
                return zzbc.zzl;
            }
        } else {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", String.format("Bundle returned from %s doesn't contain required fields.", str2));
            return billingResult;
        }
    }
}
