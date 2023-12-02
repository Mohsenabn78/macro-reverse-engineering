package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbrg {
    private final NativeCustomFormatAd.OnCustomFormatAdLoadedListener zza;
    @Nullable
    private final NativeCustomFormatAd.OnCustomClickListener zzb;
    @Nullable
    @GuardedBy("this")
    private NativeCustomFormatAd zzc;

    public zzbrg(NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener, @Nullable NativeCustomFormatAd.OnCustomClickListener onCustomClickListener) {
        this.zza = onCustomFormatAdLoadedListener;
        this.zzb = onCustomClickListener;
    }

    public final synchronized NativeCustomFormatAd zzf(zzbfl zzbflVar) {
        NativeCustomFormatAd nativeCustomFormatAd = this.zzc;
        if (nativeCustomFormatAd != null) {
            return nativeCustomFormatAd;
        }
        zzbrh zzbrhVar = new zzbrh(zzbflVar);
        this.zzc = zzbrhVar;
        return zzbrhVar;
    }

    @Nullable
    public final zzbfv zza() {
        if (this.zzb == null) {
            return null;
        }
        return new zzbrd(this, null);
    }

    public final zzbfy zzb() {
        return new zzbrf(this, null);
    }
}
