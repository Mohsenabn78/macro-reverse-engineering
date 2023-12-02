package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public interface zzrp {
    int zza();

    int zzb(MediaCodec.BufferInfo bufferInfo);

    MediaFormat zzc();

    @Nullable
    ByteBuffer zzf(int i4);

    @Nullable
    ByteBuffer zzg(int i4);

    void zzi();

    void zzj(int i4, int i5, int i6, long j4, int i7);

    void zzk(int i4, int i5, zzhm zzhmVar, long j4, int i6);

    void zzl();

    @RequiresApi(21)
    void zzm(int i4, long j4);

    void zzn(int i4, boolean z3);

    @RequiresApi(23)
    void zzo(Surface surface);

    @RequiresApi(19)
    void zzp(Bundle bundle);

    void zzq(int i4);

    boolean zzr();
}
