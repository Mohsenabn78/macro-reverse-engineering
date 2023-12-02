package com.google.android.gms.ads.mediation;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public interface MediationRewardedAdCallback extends MediationAdCallback {
    void onAdFailedToShow(@NonNull AdError adError);

    @Deprecated
    void onAdFailedToShow(@NonNull String str);

    void onUserEarnedReward(@NonNull RewardItem rewardItem);

    void onVideoComplete();

    void onVideoStart();
}
