package com.google.android.gms.ads.mediation.customevent;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.ads.zzbzr;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
final class zzb implements CustomEventInterstitialListener {

    /* renamed from: a  reason: collision with root package name */
    private final CustomEventAdapter f19461a;

    /* renamed from: b  reason: collision with root package name */
    private final MediationInterstitialListener f19462b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ CustomEventAdapter f19463c;

    public zzb(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
        this.f19463c = customEventAdapter;
        this.f19461a = customEventAdapter2;
        this.f19462b = mediationInterstitialListener;
    }

    @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
    public final void onAdClicked() {
        zzbzr.zze("Custom event adapter called onAdClicked.");
        this.f19462b.onAdClicked(this.f19461a);
    }

    @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
    public final void onAdClosed() {
        zzbzr.zze("Custom event adapter called onAdClosed.");
        this.f19462b.onAdClosed(this.f19461a);
    }

    @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
    public final void onAdFailedToLoad(int i4) {
        zzbzr.zze("Custom event adapter called onFailedToReceiveAd.");
        this.f19462b.onAdFailedToLoad(this.f19461a, i4);
    }

    @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
    public final void onAdLeftApplication() {
        zzbzr.zze("Custom event adapter called onAdLeftApplication.");
        this.f19462b.onAdLeftApplication(this.f19461a);
    }

    @Override // com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener
    public final void onAdLoaded() {
        zzbzr.zze("Custom event adapter called onReceivedAd.");
        this.f19462b.onAdLoaded(this.f19463c);
    }

    @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
    public final void onAdOpened() {
        zzbzr.zze("Custom event adapter called onAdOpened.");
        this.f19462b.onAdOpened(this.f19461a);
    }

    @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
    public final void onAdFailedToLoad(AdError adError) {
        zzbzr.zze("Custom event adapter called onFailedToReceiveAd.");
        this.f19462b.onAdFailedToLoad(this.f19461a, adError);
    }
}
