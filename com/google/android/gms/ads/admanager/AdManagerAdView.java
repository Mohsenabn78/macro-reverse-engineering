package com.google.android.gms.ads.admanager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbdd;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzbzg;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class AdManagerAdView extends BaseAdView {
    public AdManagerAdView(@NonNull Context context) {
        super(context, 0);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(AdManagerAdRequest adManagerAdRequest) {
        try {
            this.f18975a.zzm(adManagerAdRequest.zza());
        } catch (IllegalStateException e4) {
            zzbsw.zza(getContext()).zzf(e4, "AdManagerAdView.loadAd");
        }
    }

    @Nullable
    public AdSize[] getAdSizes() {
        return this.f18975a.zzB();
    }

    @Nullable
    public AppEventListener getAppEventListener() {
        return this.f18975a.zzh();
    }

    @NonNull
    public VideoController getVideoController() {
        return this.f18975a.zzf();
    }

    @Nullable
    public VideoOptions getVideoOptions() {
        return this.f18975a.zzg();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(@NonNull final AdManagerAdRequest adManagerAdRequest) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbm.zza(getContext());
        if (((Boolean) zzbdd.zzf.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjJ)).booleanValue()) {
                zzbzg.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.admanager.zzb
                    @Override // java.lang.Runnable
                    public final void run() {
                        AdManagerAdView.this.a(adManagerAdRequest);
                    }
                });
                return;
            }
        }
        this.f18975a.zzm(adManagerAdRequest.zza());
    }

    public void recordManualImpression() {
        this.f18975a.zzo();
    }

    public void setAdSizes(@NonNull AdSize... adSizeArr) {
        if (adSizeArr != null && adSizeArr.length > 0) {
            this.f18975a.zzt(adSizeArr);
            return;
        }
        throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
    }

    public void setAppEventListener(@Nullable AppEventListener appEventListener) {
        this.f18975a.zzv(appEventListener);
    }

    public void setManualImpressionsEnabled(boolean z3) {
        this.f18975a.zzw(z3);
    }

    public void setVideoOptions(@NonNull VideoOptions videoOptions) {
        this.f18975a.zzy(videoOptions);
    }

    public final boolean zzb(zzbu zzbuVar) {
        return this.f18975a.zzz(zzbuVar);
    }

    public AdManagerAdView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet, true);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public AdManagerAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4, 0, true);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }
}
