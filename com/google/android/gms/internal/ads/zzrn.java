package com.google.android.gms.internal.ads;

import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzrn {
    public final zzrs zza;
    public final MediaFormat zzb;
    public final zzam zzc;
    @Nullable
    public final Surface zzd;
    @Nullable
    public final MediaCrypto zze = null;

    private zzrn(zzrs zzrsVar, MediaFormat mediaFormat, zzam zzamVar, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i4) {
        this.zza = zzrsVar;
        this.zzb = mediaFormat;
        this.zzc = zzamVar;
        this.zzd = surface;
    }

    public static zzrn zza(zzrs zzrsVar, MediaFormat mediaFormat, zzam zzamVar, @Nullable MediaCrypto mediaCrypto) {
        return new zzrn(zzrsVar, mediaFormat, zzamVar, null, null, 0);
    }

    public static zzrn zzb(zzrs zzrsVar, MediaFormat mediaFormat, zzam zzamVar, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto) {
        return new zzrn(zzrsVar, mediaFormat, zzamVar, surface, null, 0);
    }
}
