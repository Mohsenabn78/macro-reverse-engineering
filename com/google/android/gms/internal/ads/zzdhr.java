package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdhr implements zzgwe {
    private final zzdhm zza;
    private final zzgwr zzb;
    private final zzgwr zzc;

    public zzdhr(zzdhm zzdhmVar, zzgwr zzgwrVar, zzgwr zzgwrVar2) {
        this.zza = zzdhmVar;
        this.zzb = zzgwrVar;
        this.zzc = zzgwrVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    /* renamed from: zza */
    public final zzbxe zzb() {
        return new zzbxe(((zzcha) this.zzb).zza(), ((zzcux) this.zzc).zza().zzf);
    }
}
