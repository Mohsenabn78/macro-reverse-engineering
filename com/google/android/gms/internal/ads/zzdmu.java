package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdmu implements zzgwe {
    private final zzgwr zza;

    public zzdmu(zzgwr zzgwrVar) {
        this.zza = zzgwrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzaxj zzaxjVar;
        if (((zzcux) this.zza).zza().zzo.zza == 3) {
            zzaxjVar = zzaxj.REWARDED_INTERSTITIAL;
        } else {
            zzaxjVar = zzaxj.REWARD_BASED_VIDEO_AD;
        }
        zzgwm.zzb(zzaxjVar);
        return zzaxjVar;
    }
}
