package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbgw {
    private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zza;
    @Nullable
    private final NativeCustomTemplateAd.OnCustomClickListener zzb;
    @Nullable
    @GuardedBy("this")
    private NativeCustomTemplateAd zzc;

    public zzbgw(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, @Nullable NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zza = onCustomTemplateAdLoadedListener;
        this.zzb = onCustomClickListener;
    }

    public final synchronized NativeCustomTemplateAd zzf(zzbfl zzbflVar) {
        NativeCustomTemplateAd nativeCustomTemplateAd = this.zzc;
        if (nativeCustomTemplateAd != null) {
            return nativeCustomTemplateAd;
        }
        zzbfm zzbfmVar = new zzbfm(zzbflVar);
        this.zzc = zzbfmVar;
        return zzbfmVar;
    }

    @Nullable
    public final zzbfv zzd() {
        if (this.zzb == null) {
            return null;
        }
        return new zzbgt(this, null);
    }

    public final zzbfy zze() {
        return new zzbgv(this, null);
    }
}
