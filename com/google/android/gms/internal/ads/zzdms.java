package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdms implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;

    public zzdms(zzgwr zzgwrVar, zzgwr zzgwrVar2, zzgwr zzgwrVar3) {
        this.zza = zzgwrVar;
        this.zzb = zzgwrVar2;
        this.zzc = zzgwrVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final /* synthetic */ Object zzb() {
        zzgwr zzgwrVar = this.zza;
        zzgwr zzgwrVar2 = this.zzb;
        int i4 = ((zzcux) this.zzc).zza().zzo.zza;
        int i5 = i4 - 1;
        if (i4 != 0) {
            if (i5 != 0) {
                return ((zzehi) zzgwrVar2).zzb();
            }
            return ((zzehi) zzgwrVar).zzb();
        }
        throw null;
    }
}
