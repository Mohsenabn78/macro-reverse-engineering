package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzuu implements zzua {
    private final zzgd zzc;
    private int zzd;
    private final zzut zze;
    private final zzxt zzf;
    private final zzql zzg;

    public zzuu(zzgd zzgdVar, zzut zzutVar) {
        zzql zzqlVar = new zzql();
        zzxt zzxtVar = new zzxt();
        this.zzc = zzgdVar;
        this.zze = zzutVar;
        this.zzg = zzqlVar;
        this.zzf = zzxtVar;
        this.zzd = 1048576;
    }

    public final zzuu zza(int i4) {
        this.zzd = i4;
        return this;
    }

    public final zzuw zzb(zzbp zzbpVar) {
        zzbpVar.zzd.getClass();
        return new zzuw(zzbpVar, this.zzc, this.zze, zzqu.zza, this.zzf, this.zzd, null);
    }
}
