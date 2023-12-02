package com.google.android.gms.ads.mediation.customevent;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.internal.ads.zzbzr;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
final class zzc implements CustomEventNativeListener {

    /* renamed from: a  reason: collision with root package name */
    private final CustomEventAdapter f19464a;

    /* renamed from: b  reason: collision with root package name */
    private final MediationNativeListener f19465b;

    public zzc(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
        this.f19464a = customEventAdapter;
        this.f19465b = mediationNativeListener;
    }

    @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
    public final void onAdClicked() {
        zzbzr.zze("Custom event adapter called onAdClicked.");
        this.f19465b.onAdClicked(this.f19464a);
    }

    @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
    public final void onAdClosed() {
        zzbzr.zze("Custom event adapter called onAdClosed.");
        this.f19465b.onAdClosed(this.f19464a);
    }

    @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
    public final void onAdFailedToLoad(int i4) {
        zzbzr.zze("Custom event adapter called onAdFailedToLoad.");
        this.f19465b.onAdFailedToLoad(this.f19464a, i4);
    }

    @Override // com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
    public final void onAdImpression() {
        zzbzr.zze("Custom event adapter called onAdImpression.");
        this.f19465b.onAdImpression(this.f19464a);
    }

    @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
    public final void onAdLeftApplication() {
        zzbzr.zze("Custom event adapter called onAdLeftApplication.");
        this.f19465b.onAdLeftApplication(this.f19464a);
    }

    @Override // com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
    public final void onAdLoaded(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        zzbzr.zze("Custom event adapter called onAdLoaded.");
        this.f19465b.onAdLoaded(this.f19464a, unifiedNativeAdMapper);
    }

    @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
    public final void onAdOpened() {
        zzbzr.zze("Custom event adapter called onAdOpened.");
        this.f19465b.onAdOpened(this.f19464a);
    }

    @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
    public final void onAdFailedToLoad(AdError adError) {
        zzbzr.zze("Custom event adapter called onAdFailedToLoad.");
        this.f19465b.onAdFailedToLoad(this.f19464a, adError);
    }
}
