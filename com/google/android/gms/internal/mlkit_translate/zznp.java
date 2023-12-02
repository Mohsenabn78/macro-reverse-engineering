package com.google.android.gms.internal.mlkit_translate;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zznp {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private zzv zze;
    private String zzf;
    private Boolean zzg;
    private Boolean zzh;
    private Boolean zzi;
    private Integer zzj;
    private Integer zzk;

    public final zznp zzb(String str) {
        this.zza = str;
        return this;
    }

    public final zznp zzc(String str) {
        this.zzb = str;
        return this;
    }

    public final zznp zzd(Integer num) {
        this.zzj = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zznp zze(Boolean bool) {
        this.zzg = bool;
        return this;
    }

    public final zznp zzf(Boolean bool) {
        this.zzi = bool;
        return this;
    }

    public final zznp zzg(Boolean bool) {
        this.zzh = bool;
        return this;
    }

    public final zznp zzh(zzv zzvVar) {
        this.zze = zzvVar;
        return this;
    }

    public final zznp zzi(String str) {
        this.zzf = str;
        return this;
    }

    public final zznp zzj(String str) {
        this.zzc = str;
        return this;
    }

    public final zznp zzk(Integer num) {
        this.zzk = num;
        return this;
    }

    public final zznp zzl(String str) {
        this.zzd = str;
        return this;
    }

    public final zznr zzm() {
        return new zznr(this, null);
    }
}
