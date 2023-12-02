package com.google.android.gms.internal.mlkit_translate;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zznj {
    private Long zza;
    private zzv zzb;
    private zzv zzc;
    private zzv zzd;
    private Integer zze;

    public final zznj zzd(Long l4) {
        this.zza = Long.valueOf(l4.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zznj zze(zzv zzvVar) {
        this.zzb = zzvVar;
        return this;
    }

    public final zznj zzf(Integer num) {
        this.zze = num;
        return this;
    }

    public final zznj zzg(zzv zzvVar) {
        this.zzc = zzvVar;
        return this;
    }

    public final zznj zzh(zzv zzvVar) {
        this.zzd = zzvVar;
        return this;
    }

    public final zznm zzi() {
        return new zznm(this, null);
    }
}
