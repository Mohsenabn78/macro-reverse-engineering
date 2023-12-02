package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcsu implements zzcwu, com.google.android.gms.ads.internal.client.zza, zzcyb, zzcwa, zzcvg, zzdan {
    private final Clock zza;
    private final zzbyt zzb;

    public zzcsu(Clock clock, zzbyt zzbytVar) {
        this.zza = clock;
        this.zzb = zzbytVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        this.zzb.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzcyb
    public final void zzb(zzezz zzezzVar) {
        this.zzb.zzk(this.zza.elapsedRealtime());
    }

    public final String zzc() {
        return this.zzb.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzdan
    public final void zze(zzaxu zzaxuVar) {
        this.zzb.zzi();
    }

    public final void zzg(com.google.android.gms.ads.internal.client.zzl zzlVar) {
        this.zzb.zzj(zzlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdan
    public final void zzi(zzaxu zzaxuVar) {
        this.zzb.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzj() {
        this.zzb.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzcwa
    public final void zzl() {
        this.zzb.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final void zzn() {
        this.zzb.zzh(true);
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzbr() {
    }

    @Override // com.google.android.gms.internal.ads.zzdan
    public final void zzd() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzm() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzo() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzq() {
    }

    @Override // com.google.android.gms.internal.ads.zzcyb
    public final void zzbA(zzbue zzbueVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdan
    public final void zzf(zzaxu zzaxuVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdan
    public final void zzh(boolean z3) {
    }

    @Override // com.google.android.gms.internal.ads.zzdan
    public final void zzk(boolean z3) {
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzp(zzbuu zzbuuVar, String str, String str2) {
    }
}
