package com.google.android.gms.ads.mediation;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@Deprecated
/* loaded from: classes4.dex */
public interface MediationNativeListener {
    void onAdClicked(@NonNull MediationNativeAdapter mediationNativeAdapter);

    void onAdClosed(@NonNull MediationNativeAdapter mediationNativeAdapter);

    @Deprecated
    void onAdFailedToLoad(@NonNull MediationNativeAdapter mediationNativeAdapter, int i4);

    void onAdFailedToLoad(@NonNull MediationNativeAdapter mediationNativeAdapter, @NonNull AdError adError);

    void onAdImpression(@NonNull MediationNativeAdapter mediationNativeAdapter);

    void onAdLeftApplication(@NonNull MediationNativeAdapter mediationNativeAdapter);

    void onAdLoaded(@NonNull MediationNativeAdapter mediationNativeAdapter, @NonNull UnifiedNativeAdMapper unifiedNativeAdMapper);

    void onAdOpened(@NonNull MediationNativeAdapter mediationNativeAdapter);

    void onVideoEnd(@NonNull MediationNativeAdapter mediationNativeAdapter);

    void zzc(@NonNull MediationNativeAdapter mediationNativeAdapter, @NonNull NativeCustomTemplateAd nativeCustomTemplateAd);

    void zze(@NonNull MediationNativeAdapter mediationNativeAdapter, @NonNull NativeCustomTemplateAd nativeCustomTemplateAd, @NonNull String str);
}
