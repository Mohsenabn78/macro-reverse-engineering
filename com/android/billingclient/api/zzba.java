package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzfa;
import com.google.android.gms.internal.play_billing.zzfb;
import com.google.android.gms.internal.play_billing.zzfe;
import com.google.android.gms.internal.play_billing.zzff;
import com.google.android.gms.internal.play_billing.zzfh;
import com.google.android.gms.internal.play_billing.zzfj;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class zzba {
    public static zzfb zza(int i4, int i5, BillingResult billingResult) {
        zzfa zzu = zzfb.zzu();
        zzfh zzu2 = zzfj.zzu();
        zzu2.zzj(billingResult.getResponseCode());
        zzu2.zzi(billingResult.getDebugMessage());
        zzu2.zzk(i4);
        zzu.zzi(zzu2);
        zzu.zzj(i5);
        return (zzfb) zzu.zzc();
    }

    public static zzff zzb(int i4) {
        zzfe zzu = zzff.zzu();
        zzu.zzi(i4);
        return (zzff) zzu.zzc();
    }
}
