package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbgv extends zzbfx {
    final /* synthetic */ zzbgw zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbgv(zzbgw zzbgwVar, zzbgu zzbguVar) {
        this.zza = zzbgwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfy
    public final void zze(zzbfl zzbflVar) {
        NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener;
        NativeCustomTemplateAd zzf;
        zzbgw zzbgwVar = this.zza;
        onCustomTemplateAdLoadedListener = zzbgwVar.zza;
        zzf = zzbgwVar.zzf(zzbflVar);
        onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded(zzf);
    }
}
