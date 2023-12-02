package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
public final class zzjd {
    private zzjp zza;
    private Long zzb;
    private zziy zzc;
    private Long zzd;
    private zzje zze;
    private Long zzf;

    public static /* bridge */ /* synthetic */ zziy zza(zzjd zzjdVar) {
        return zzjdVar.zzc;
    }

    public static /* bridge */ /* synthetic */ zzje zzh(zzjd zzjdVar) {
        return zzjdVar.zze;
    }

    public static /* bridge */ /* synthetic */ zzjp zzj(zzjd zzjdVar) {
        return zzjdVar.zza;
    }

    public static /* bridge */ /* synthetic */ Long zzk(zzjd zzjdVar) {
        return zzjdVar.zzf;
    }

    public static /* bridge */ /* synthetic */ Long zzl(zzjd zzjdVar) {
        return zzjdVar.zzd;
    }

    public static /* bridge */ /* synthetic */ Long zzm(zzjd zzjdVar) {
        return zzjdVar.zzb;
    }

    public final zzjd zzb(Long l4) {
        this.zzf = l4;
        return this;
    }

    public final zzjd zzc(zzje zzjeVar) {
        this.zze = zzjeVar;
        return this;
    }

    public final zzjd zzd(zziy zziyVar) {
        this.zzc = zziyVar;
        return this;
    }

    public final zzjd zze(Long l4) {
        this.zzd = Long.valueOf(l4.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzjd zzf(zzjp zzjpVar) {
        this.zza = zzjpVar;
        return this;
    }

    public final zzjd zzg(Long l4) {
        this.zzb = Long.valueOf(l4.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzjg zzi() {
        return new zzjg(this, null);
    }
}
