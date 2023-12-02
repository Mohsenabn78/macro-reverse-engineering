package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzsi implements zzsg {
    private zzsi() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzsi(zzsh zzshVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final int zza() {
        return MediaCodecList.getCodecCount();
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final MediaCodecInfo zzb(int i4) {
        return MediaCodecList.getCodecInfoAt(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final boolean zzc(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final boolean zzd(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        if ("secure-playback".equals(str) && "video/avc".equals(str2)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final boolean zze() {
        return false;
    }
}
