package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
public final class zzle {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private zzao zze;
    private String zzf;
    private Boolean zzg;
    private Boolean zzh;
    private Boolean zzi;
    private Integer zzj;
    private Integer zzk;

    public final zzle zzb(String str) {
        this.zza = str;
        return this;
    }

    public final zzle zzc(String str) {
        this.zzb = str;
        return this;
    }

    public final zzle zzd(Integer num) {
        this.zzj = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzle zze(Boolean bool) {
        this.zzg = bool;
        return this;
    }

    public final zzle zzf(Boolean bool) {
        this.zzi = bool;
        return this;
    }

    public final zzle zzg(Boolean bool) {
        this.zzh = bool;
        return this;
    }

    public final zzle zzh(zzao zzaoVar) {
        this.zze = zzaoVar;
        return this;
    }

    public final zzle zzi(String str) {
        this.zzf = str;
        return this;
    }

    public final zzle zzj(String str) {
        this.zzc = str;
        return this;
    }

    public final zzle zzk(Integer num) {
        this.zzk = num;
        return this;
    }

    public final zzle zzl(String str) {
        this.zzd = str;
        return this;
    }

    public final zzlg zzm() {
        return new zzlg(this, null);
    }
}
