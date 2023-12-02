package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzfb;
import java.util.List;
import org.json.JSONException;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes2.dex */
public final class zzn extends BroadcastReceiver {
    final /* synthetic */ zzo zza;
    private final PurchasesUpdatedListener zzb;
    private final zzbf zzc;
    private final AlternativeBillingListener zzd;
    private boolean zze;
    private final zzbh zzf;

    public /* synthetic */ zzn(zzo zzoVar, zzbf zzbfVar, zzbh zzbhVar, zzm zzmVar) {
        this.zza = zzoVar;
        this.zzb = null;
        this.zzd = null;
        this.zzc = null;
        this.zzf = zzbhVar;
    }

    public static /* bridge */ /* synthetic */ zzbf zza(zzn zznVar) {
        zzbf zzbfVar = zznVar.zzc;
        return null;
    }

    private static final void zze(Bundle bundle, BillingResult billingResult, int i4) {
        if (bundle.getByteArray("FAILURE_LOGGING_PAYLOAD") != null) {
            try {
                zzfb.zzw(bundle.getByteArray("FAILURE_LOGGING_PAYLOAD"), com.google.android.gms.internal.play_billing.zzbn.zza());
                return;
            } catch (Throwable unused) {
                com.google.android.gms.internal.play_billing.zzb.zzj("BillingBroadcastManager", "Failed parsing Api failure.");
                return;
            }
        }
        zzba.zza(23, i4, billingResult);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingBroadcastManager", "Bundle is null.");
            BillingResult billingResult = zzbc.zzj;
            zzba.zza(11, 1, billingResult);
            PurchasesUpdatedListener purchasesUpdatedListener = this.zzb;
            if (purchasesUpdatedListener != null) {
                purchasesUpdatedListener.onPurchasesUpdated(billingResult, null);
                return;
            }
            return;
        }
        BillingResult zzd = com.google.android.gms.internal.play_billing.zzb.zzd(intent, "BillingBroadcastManager");
        String action = intent.getAction();
        String string = extras.getString("INTENT_SOURCE");
        int i4 = 2;
        if (string != "LAUNCH_BILLING_FLOW" && (string == null || !string.equals("LAUNCH_BILLING_FLOW"))) {
            i4 = 1;
        }
        if (action.equals("com.android.vending.billing.PURCHASES_UPDATED")) {
            if (!extras.getBoolean("IS_FIRST_PARTY_PURCHASE", false) && this.zzb != null) {
                List<Purchase> zzh = com.google.android.gms.internal.play_billing.zzb.zzh(extras);
                if (zzd.getResponseCode() == 0) {
                    zzba.zzb(i4);
                } else {
                    zze(extras, zzd, i4);
                }
                this.zzb.onPurchasesUpdated(zzd, zzh);
                return;
            }
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingBroadcastManager", "Received purchase and no valid listener registered.");
            zzba.zza(12, i4, zzbc.zzj);
        } else if (action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
            if (zzd.getResponseCode() != 0) {
                zze(extras, zzd, i4);
                this.zzb.onPurchasesUpdated(zzd, com.google.android.gms.internal.play_billing.zzu.zzk());
            } else if (this.zzd == null) {
                com.google.android.gms.internal.play_billing.zzb.zzj("BillingBroadcastManager", "AlternativeBillingListener is null.");
                BillingResult billingResult2 = zzbc.zzj;
                zzba.zza(15, i4, billingResult2);
                this.zzb.onPurchasesUpdated(billingResult2, com.google.android.gms.internal.play_billing.zzu.zzk());
            } else {
                String string2 = extras.getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                if (string2 == null) {
                    com.google.android.gms.internal.play_billing.zzb.zzj("BillingBroadcastManager", "Couldn't find alternative billing user choice data in bundle.");
                    BillingResult billingResult3 = zzbc.zzj;
                    zzba.zza(16, i4, billingResult3);
                    this.zzb.onPurchasesUpdated(billingResult3, com.google.android.gms.internal.play_billing.zzu.zzk());
                    return;
                }
                try {
                    AlternativeChoiceDetails alternativeChoiceDetails = new AlternativeChoiceDetails(string2);
                    zzba.zzb(i4);
                    this.zzd.userSelectedAlternativeBilling(alternativeChoiceDetails);
                } catch (JSONException unused) {
                    com.google.android.gms.internal.play_billing.zzb.zzj("BillingBroadcastManager", String.format("Error when parsing invalid alternative choice data: [%s]", string2));
                    BillingResult billingResult4 = zzbc.zzj;
                    zzba.zza(17, i4, billingResult4);
                    this.zzb.onPurchasesUpdated(billingResult4, com.google.android.gms.internal.play_billing.zzu.zzk());
                }
            }
        }
    }

    public final void zzc(Context context, IntentFilter intentFilter) {
        zzn zznVar;
        if (!this.zze) {
            zznVar = this.zza.zzb;
            context.registerReceiver(zznVar, intentFilter);
            this.zze = true;
        }
    }

    public final void zzd(Context context) {
        zzn zznVar;
        if (this.zze) {
            zznVar = this.zza.zzb;
            context.unregisterReceiver(zznVar);
            this.zze = false;
            return;
        }
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingBroadcastManager", "Receiver is not registered.");
    }

    public /* synthetic */ zzn(zzo zzoVar, PurchasesUpdatedListener purchasesUpdatedListener, AlternativeBillingListener alternativeBillingListener, zzbh zzbhVar, zzm zzmVar) {
        this.zza = zzoVar;
        this.zzb = purchasesUpdatedListener;
        this.zzf = zzbhVar;
        this.zzd = alternativeBillingListener;
        this.zzc = null;
    }
}
