package com.google.android.gms.ads.mediation.customevent;

import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.internal.ads.zzbzr;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
final class zza implements CustomEventBannerListener {

    /* renamed from: a  reason: collision with root package name */
    private final CustomEventAdapter f19459a;

    /* renamed from: b  reason: collision with root package name */
    private final MediationBannerListener f19460b;

    public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
        this.f19459a = customEventAdapter;
        this.f19460b = mediationBannerListener;
    }

    @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
    public final void onAdClicked() {
        zzbzr.zze("Custom event adapter called onAdClicked.");
        this.f19460b.onAdClicked(this.f19459a);
    }

    @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
    public final void onAdClosed() {
        zzbzr.zze("Custom event adapter called onAdClosed.");
        this.f19460b.onAdClosed(this.f19459a);
    }

    @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
    public final void onAdFailedToLoad(int i4) {
        zzbzr.zze("Custom event adapter called onAdFailedToLoad.");
        this.f19460b.onAdFailedToLoad(this.f19459a, i4);
    }

    @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
    public final void onAdLeftApplication() {
        zzbzr.zze("Custom event adapter called onAdLeftApplication.");
        this.f19460b.onAdLeftApplication(this.f19459a);
    }

    @Override // com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener
    public final void onAdLoaded(View view) {
        zzbzr.zze("Custom event adapter called onAdLoaded.");
        this.f19459a.f19454a = view;
        this.f19460b.onAdLoaded(this.f19459a);
    }

    @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
    public final void onAdOpened() {
        zzbzr.zze("Custom event adapter called onAdOpened.");
        this.f19460b.onAdOpened(this.f19459a);
    }

    @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
    public final void onAdFailedToLoad(AdError adError) {
        zzbzr.zze("Custom event adapter called onAdFailedToLoad.");
        this.f19460b.onAdFailedToLoad(this.f19459a, adError);
    }
}
