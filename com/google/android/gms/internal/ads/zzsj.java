package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@RequiresApi(21)
/* loaded from: classes4.dex */
final class zzsj implements zzsg {
    private final int zza;
    @Nullable
    private MediaCodecInfo[] zzb;

    public zzsj(boolean z3, boolean z4) {
        int i4 = 1;
        if (!z3 && !z4) {
            i4 = 0;
        }
        this.zza = i4;
    }

    @EnsuresNonNull({"mediaCodecInfos"})
    private final void zzf() {
        if (this.zzb == null) {
            this.zzb = new MediaCodecList(this.zza).getCodecInfos();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final int zza() {
        zzf();
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final MediaCodecInfo zzb(int i4) {
        zzf();
        return this.zzb[i4];
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final boolean zzc(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(str);
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final boolean zzd(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(str);
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final boolean zze() {
        return true;
    }
}
