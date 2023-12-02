package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeip extends com.google.android.gms.ads.internal.client.zzbp {
    @VisibleForTesting
    final zzfag zza;
    @VisibleForTesting
    final zzdhj zzb;
    private final Context zzc;
    private final zzcgu zzd;
    private com.google.android.gms.ads.internal.client.zzbh zze;

    public zzeip(zzcgu zzcguVar, Context context, String str) {
        zzfag zzfagVar = new zzfag();
        this.zza = zzfagVar;
        this.zzb = new zzdhj();
        this.zzd = zzcguVar;
        zzfagVar.zzs(str);
        this.zzc = context;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final com.google.android.gms.ads.internal.client.zzbn zze() {
        zzdhl zzg = this.zzb.zzg();
        this.zza.zzB(zzg.zzi());
        this.zza.zzC(zzg.zzh());
        zzfag zzfagVar = this.zza;
        if (zzfagVar.zzg() == null) {
            zzfagVar.zzr(com.google.android.gms.ads.internal.client.zzq.zzc());
        }
        return new zzeiq(this.zzc, this.zzd, this.zza, zzg, this.zze);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzf(zzbfp zzbfpVar) {
        this.zzb.zza(zzbfpVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzg(zzbfs zzbfsVar) {
        this.zzb.zzb(zzbfsVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzh(String str, zzbfy zzbfyVar, @Nullable zzbfv zzbfvVar) {
        this.zzb.zzc(str, zzbfyVar, zzbfvVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzi(zzbla zzblaVar) {
        this.zzb.zzd(zzblaVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzj(zzbgc zzbgcVar, com.google.android.gms.ads.internal.client.zzq zzqVar) {
        this.zzb.zze(zzbgcVar);
        this.zza.zzr(zzqVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzk(zzbgf zzbgfVar) {
        this.zzb.zzf(zzbgfVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzl(com.google.android.gms.ads.internal.client.zzbh zzbhVar) {
        this.zze = zzbhVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzm(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zza.zzq(adManagerAdViewOptions);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzn(zzbkr zzbkrVar) {
        this.zza.zzv(zzbkrVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzo(zzbef zzbefVar) {
        this.zza.zzA(zzbefVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzp(PublisherAdViewOptions publisherAdViewOptions) {
        this.zza.zzD(publisherAdViewOptions);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzq(com.google.android.gms.ads.internal.client.zzcf zzcfVar) {
        this.zza.zzQ(zzcfVar);
    }
}
