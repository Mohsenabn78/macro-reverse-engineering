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
public final class zzsn implements zzrp {
    private final MediaCodec zza;
    @Nullable
    private ByteBuffer[] zzb;
    @Nullable
    private ByteBuffer[] zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzsn(MediaCodec mediaCodec, zzsm zzsmVar) {
        this.zza = mediaCodec;
        if (zzfj.zza < 21) {
            this.zzb = mediaCodec.getInputBuffers();
            this.zzc = mediaCodec.getOutputBuffers();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final int zza() {
        return this.zza.dequeueInputBuffer(0L);
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            dequeueOutputBuffer = this.zza.dequeueOutputBuffer(bufferInfo, 0L);
            if (dequeueOutputBuffer == -3) {
                if (zzfj.zza < 21) {
                    this.zzc = this.zza.getOutputBuffers();
                }
                dequeueOutputBuffer = -3;
                continue;
            }
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final MediaFormat zzc() {
        return this.zza.getOutputFormat();
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    @Nullable
    public final ByteBuffer zzf(int i4) {
        if (zzfj.zza >= 21) {
            return this.zza.getInputBuffer(i4);
        }
        return this.zzb[i4];
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    @Nullable
    public final ByteBuffer zzg(int i4) {
        if (zzfj.zza >= 21) {
            return this.zza.getOutputBuffer(i4);
        }
        return this.zzc[i4];
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final void zzi() {
        this.zza.flush();
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final void zzj(int i4, int i5, int i6, long j4, int i7) {
        this.zza.queueInputBuffer(i4, 0, i6, j4, i7);
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final void zzk(int i4, int i5, zzhm zzhmVar, long j4, int i6) {
        this.zza.queueSecureInputBuffer(i4, 0, zzhmVar.zza(), j4, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final void zzl() {
        this.zzb = null;
        this.zzc = null;
        this.zza.release();
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    @RequiresApi(21)
    public final void zzm(int i4, long j4) {
        this.zza.releaseOutputBuffer(i4, j4);
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final void zzn(int i4, boolean z3) {
        this.zza.releaseOutputBuffer(i4, z3);
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    @RequiresApi(23)
    public final void zzo(Surface surface) {
        this.zza.setOutputSurface(surface);
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    @RequiresApi(19)
    public final void zzp(Bundle bundle) {
        this.zza.setParameters(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final void zzq(int i4) {
        this.zza.setVideoScalingMode(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final boolean zzr() {
        return false;
    }
}
