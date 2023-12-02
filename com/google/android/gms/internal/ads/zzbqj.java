package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.mediation.MediationInterstitialListener;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzbqj implements com.google.android.gms.ads.internal.overlay.zzo {
    final /* synthetic */ zzbql zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbqj(zzbql zzbqlVar) {
        this.zza = zzbqlVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzb() {
        MediationInterstitialListener mediationInterstitialListener;
        zzbzr.zze("Opening AdMobCustomTabsAdapter overlay.");
        zzbql zzbqlVar = this.zza;
        mediationInterstitialListener = zzbqlVar.zzb;
        mediationInterstitialListener.onAdOpened(zzbqlVar);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzbF() {
        zzbzr.zze("AdMobCustomTabsAdapter overlay is resumed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzbo() {
        zzbzr.zze("AdMobCustomTabsAdapter overlay is paused.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzby() {
        zzbzr.zze("Delay close AdMobCustomTabsAdapter overlay.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzf(int i4) {
        MediationInterstitialListener mediationInterstitialListener;
        zzbzr.zze("AdMobCustomTabsAdapter overlay is closed.");
        zzbql zzbqlVar = this.zza;
        mediationInterstitialListener = zzbqlVar.zzb;
        mediationInterstitialListener.onAdClosed(zzbqlVar);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zze() {
    }
}
