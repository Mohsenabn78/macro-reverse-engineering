package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import androidx.annotation.RequiresApi;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@RequiresApi(24)
/* loaded from: classes4.dex */
final class zzhl {
    private final MediaCodec.CryptoInfo zza;
    private final MediaCodec.CryptoInfo.Pattern zzb = new MediaCodec.CryptoInfo.Pattern(0, 0);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zza(zzhl zzhlVar, int i4, int i5) {
        zzhlVar.zzb.set(i4, i5);
        zzhlVar.zza.setPattern(zzhlVar.zzb);
    }
}
