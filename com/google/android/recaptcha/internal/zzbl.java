package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzbl {
    @NotNull
    private final zzbn zza;
    @NotNull
    private String zzb = "recaptcha.m.Main.rge";
    private int zzc;
    @NotNull
    private final zzbm zzd;

    public zzbl(@NotNull zzbn zzbnVar) {
        this.zza = zzbnVar;
        this.zzd = zzbnVar.zzb();
    }

    public final byte zza() {
        return this.zza.zza();
    }

    public final int zzb() {
        return this.zzc;
    }

    @NotNull
    public final zzbm zzc() {
        return this.zzd;
    }

    @NotNull
    public final String zzd() {
        return this.zzb;
    }

    public final void zze() {
        this.zza.zzc();
    }

    public final void zzf(@NotNull String str) {
        this.zzb = str;
    }

    public final void zzg(int i4) {
        this.zzc = i4;
    }

    public final void zzh(byte b4) {
        this.zza.zzd(b4);
    }
}
