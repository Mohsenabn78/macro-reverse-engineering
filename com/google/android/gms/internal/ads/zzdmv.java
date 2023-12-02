package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdmv implements zzgwe {
    private final zzgwr zza;

    public zzdmv(zzgwr zzgwrVar) {
        this.zza = zzgwrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final /* bridge */ /* synthetic */ Object zzb() {
        if (((zzcux) this.zza).zza().zzo.zza == 3) {
            return "rewarded_interstitial";
        }
        return "rewarded";
    }
}
