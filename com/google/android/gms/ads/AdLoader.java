package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbn;
import com.google.android.gms.ads.internal.client.zzbq;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.internal.client.zzeu;
import com.google.android.gms.ads.internal.client.zzfl;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbdd;
import com.google.android.gms.internal.ads.zzbef;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbgy;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbnt;
import com.google.android.gms.internal.ads.zzbrg;
import com.google.android.gms.internal.ads.zzbri;
import com.google.android.gms.internal.ads.zzbzg;
import com.google.android.gms.internal.ads.zzbzr;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public class AdLoader {

    /* renamed from: a  reason: collision with root package name */
    private final zzp f18955a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f18956b;

    /* renamed from: c  reason: collision with root package name */
    private final zzbn f18957c;

    AdLoader(Context context, zzbn zzbnVar, zzp zzpVar) {
        this.f18956b = context;
        this.f18957c = zzbnVar;
        this.f18955a = zzpVar;
    }

    private final void b(final zzdx zzdxVar) {
        zzbbm.zza(this.f18956b);
        if (((Boolean) zzbdd.zzc.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjJ)).booleanValue()) {
                zzbzg.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.zza
                    @Override // java.lang.Runnable
                    public final void run() {
                        AdLoader.this.a(zzdxVar);
                    }
                });
                return;
            }
        }
        try {
            this.f18957c.zzg(this.f18955a.zza(this.f18956b, zzdxVar));
        } catch (RemoteException e4) {
            zzbzr.zzh("Failed to load ad.", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzdx zzdxVar) {
        try {
            this.f18957c.zzg(this.f18955a.zza(this.f18956b, zzdxVar));
        } catch (RemoteException e4) {
            zzbzr.zzh("Failed to load ad.", e4);
        }
    }

    public boolean isLoading() {
        try {
            return this.f18957c.zzi();
        } catch (RemoteException e4) {
            zzbzr.zzk("Failed to check if ad is loading.", e4);
            return false;
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(@NonNull AdRequest adRequest) {
        b(adRequest.f18960a);
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAds(@NonNull AdRequest adRequest, int i4) {
        try {
            this.f18957c.zzh(this.f18955a.zza(this.f18956b, adRequest.f18960a), i4);
        } catch (RemoteException e4) {
            zzbzr.zzh("Failed to load ads.", e4);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final Context f18958a;

        /* renamed from: b  reason: collision with root package name */
        private final zzbq f18959b;

        public Builder(@NonNull Context context, @NonNull String str) {
            zzbq zzc = zzay.zza().zzc(context, str, new zzbnt());
            this.f18958a = (Context) Preconditions.checkNotNull(context, "context cannot be null");
            this.f18959b = zzc;
        }

        @NonNull
        public AdLoader build() {
            try {
                return new AdLoader(this.f18958a, this.f18959b.zze(), zzp.zza);
            } catch (RemoteException e4) {
                zzbzr.zzh("Failed to build AdLoader.", e4);
                return new AdLoader(this.f18958a, new zzeu().zzc(), zzp.zza);
            }
        }

        @NonNull
        public Builder forAdManagerAdView(@NonNull OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener, @NonNull AdSize... adSizeArr) {
            if (adSizeArr != null && adSizeArr.length > 0) {
                try {
                    this.f18959b.zzj(new zzbgy(onAdManagerAdViewLoadedListener), new zzq(this.f18958a, adSizeArr));
                } catch (RemoteException e4) {
                    zzbzr.zzk("Failed to add Google Ad Manager banner ad listener", e4);
                }
                return this;
            }
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }

        @NonNull
        public Builder forCustomFormatAd(@NonNull String str, @NonNull NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener, @Nullable NativeCustomFormatAd.OnCustomClickListener onCustomClickListener) {
            zzbrg zzbrgVar = new zzbrg(onCustomFormatAdLoadedListener, onCustomClickListener);
            try {
                this.f18959b.zzh(str, zzbrgVar.zzb(), zzbrgVar.zza());
            } catch (RemoteException e4) {
                zzbzr.zzk("Failed to add custom format ad listener", e4);
            }
            return this;
        }

        @NonNull
        @Deprecated
        public Builder forCustomTemplateAd(@NonNull String str, @NonNull NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, @Nullable NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            zzbgw zzbgwVar = new zzbgw(onCustomTemplateAdLoadedListener, onCustomClickListener);
            try {
                this.f18959b.zzh(str, zzbgwVar.zze(), zzbgwVar.zzd());
            } catch (RemoteException e4) {
                zzbzr.zzk("Failed to add custom template ad listener", e4);
            }
            return this;
        }

        @NonNull
        public Builder forNativeAd(@NonNull NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
            try {
                this.f18959b.zzk(new zzbri(onNativeAdLoadedListener));
            } catch (RemoteException e4) {
                zzbzr.zzk("Failed to add google native ad listener", e4);
            }
            return this;
        }

        @NonNull
        @Deprecated
        public Builder forUnifiedNativeAd(@NonNull UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
            try {
                this.f18959b.zzk(new zzbgz(onUnifiedNativeAdLoadedListener));
            } catch (RemoteException e4) {
                zzbzr.zzk("Failed to add google native ad listener", e4);
            }
            return this;
        }

        @NonNull
        public Builder withAdListener(@NonNull AdListener adListener) {
            try {
                this.f18959b.zzl(new com.google.android.gms.ads.internal.client.zzg(adListener));
            } catch (RemoteException e4) {
                zzbzr.zzk("Failed to set AdListener.", e4);
            }
            return this;
        }

        @NonNull
        public Builder withAdManagerAdViewOptions(@NonNull AdManagerAdViewOptions adManagerAdViewOptions) {
            try {
                this.f18959b.zzm(adManagerAdViewOptions);
            } catch (RemoteException e4) {
                zzbzr.zzk("Failed to specify Ad Manager banner ad options", e4);
            }
            return this;
        }

        @NonNull
        @Deprecated
        public Builder withNativeAdOptions(@NonNull NativeAdOptions nativeAdOptions) {
            try {
                this.f18959b.zzo(new zzbef(nativeAdOptions));
            } catch (RemoteException e4) {
                zzbzr.zzk("Failed to specify native ad options", e4);
            }
            return this;
        }

        @NonNull
        public Builder withNativeAdOptions(@NonNull com.google.android.gms.ads.nativead.NativeAdOptions nativeAdOptions) {
            try {
                this.f18959b.zzo(new zzbef(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), -1, nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzfl(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zzc(), nativeAdOptions.getMediaAspectRatio(), nativeAdOptions.zza(), nativeAdOptions.zzb()));
            } catch (RemoteException e4) {
                zzbzr.zzk("Failed to specify native ad options", e4);
            }
            return this;
        }
    }

    public void loadAd(@NonNull AdManagerAdRequest adManagerAdRequest) {
        b(adManagerAdRequest.f18960a);
    }
}
