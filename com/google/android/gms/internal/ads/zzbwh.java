package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbwh extends RewardedInterstitialAd {
    private final String zza;
    private final zzbvn zzb;
    private final Context zzc;
    private final zzbwf zzd = new zzbwf();
    @Nullable
    private FullScreenContentCallback zze;
    @Nullable
    private OnAdMetadataChangedListener zzf;
    @Nullable
    private OnPaidEventListener zzg;

    public zzbwh(Context context, String str) {
        this.zza = str;
        this.zzc = context.getApplicationContext();
        this.zzb = com.google.android.gms.ads.internal.client.zzay.zza().zzq(context, str, new zzbnt());
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final Bundle getAdMetadata() {
        try {
            zzbvn zzbvnVar = this.zzb;
            if (zzbvnVar != null) {
                return zzbvnVar.zzb();
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final String getAdUnitId() {
        return this.zza;
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    @Nullable
    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zze;
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    @Nullable
    public final OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        return this.zzf;
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    @Nullable
    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzg;
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    @NonNull
    public final ResponseInfo getResponseInfo() {
        com.google.android.gms.ads.internal.client.zzdn zzdnVar = null;
        try {
            zzbvn zzbvnVar = this.zzb;
            if (zzbvnVar != null) {
                zzdnVar = zzbvnVar.zzc();
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
        return ResponseInfo.zzb(zzdnVar);
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    @NonNull
    public final RewardItem getRewardItem() {
        zzbvk zzbvkVar;
        try {
            zzbvn zzbvnVar = this.zzb;
            if (zzbvnVar != null) {
                zzbvkVar = zzbvnVar.zzd();
            } else {
                zzbvkVar = null;
            }
            if (zzbvkVar != null) {
                return new zzbvx(zzbvkVar);
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
        return RewardItem.DEFAULT_REWARD;
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void setFullScreenContentCallback(@Nullable FullScreenContentCallback fullScreenContentCallback) {
        this.zze = fullScreenContentCallback;
        this.zzd.zzb(fullScreenContentCallback);
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void setImmersiveMode(boolean z3) {
        try {
            zzbvn zzbvnVar = this.zzb;
            if (zzbvnVar != null) {
                zzbvnVar.zzh(z3);
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void setOnAdMetadataChangedListener(@Nullable OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzf = onAdMetadataChangedListener;
        try {
            zzbvn zzbvnVar = this.zzb;
            if (zzbvnVar != null) {
                zzbvnVar.zzi(new com.google.android.gms.ads.internal.client.zzfd(onAdMetadataChangedListener));
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        this.zzg = onPaidEventListener;
        try {
            zzbvn zzbvnVar = this.zzb;
            if (zzbvnVar != null) {
                zzbvnVar.zzj(new com.google.android.gms.ads.internal.client.zzfe(onPaidEventListener));
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            zzbvn zzbvnVar = this.zzb;
            if (zzbvnVar != null) {
                zzbvnVar.zzl(new zzbwb(serverSideVerificationOptions));
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void show(@NonNull Activity activity, @NonNull OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzd.zzc(onUserEarnedRewardListener);
        try {
            zzbvn zzbvnVar = this.zzb;
            if (zzbvnVar != null) {
                zzbvnVar.zzk(this.zzd);
                this.zzb.zzm(ObjectWrapper.wrap(activity));
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
    }

    public final void zza(com.google.android.gms.ads.internal.client.zzdx zzdxVar, RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        try {
            zzbvn zzbvnVar = this.zzb;
            if (zzbvnVar != null) {
                zzbvnVar.zzg(com.google.android.gms.ads.internal.client.zzp.zza.zza(this.zzc, zzdxVar), new zzbwg(rewardedInterstitialAdLoadCallback, this));
            }
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
    }
}
