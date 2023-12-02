package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@RequiresApi(23)
/* loaded from: classes4.dex */
public final class zzrc implements zzrp {
    private final MediaCodec zza;
    private final zzri zzb;
    private final zzrg zzc;
    private boolean zzd;
    private int zze = 0;

    public /* synthetic */ zzrc(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z3, zzrb zzrbVar) {
        this.zza = mediaCodec;
        this.zzb = new zzri(handlerThread);
        this.zzc = new zzrg(mediaCodec, handlerThread2);
    }

    public static /* synthetic */ String zzd(int i4) {
        return zzs(i4, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    public static /* synthetic */ String zze(int i4) {
        return zzs(i4, "ExoPlayer:MediaCodecQueueingThread:");
    }

    public static /* synthetic */ void zzh(zzrc zzrcVar, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i4) {
        zzrcVar.zzb.zzf(zzrcVar.zza);
        int i5 = zzfj.zza;
        Trace.beginSection("configureCodec");
        zzrcVar.zza.configure(mediaFormat, surface, (MediaCrypto) null, 0);
        Trace.endSection();
        zzrcVar.zzc.zzg();
        Trace.beginSection("startCodec");
        zzrcVar.zza.start();
        Trace.endSection();
        zzrcVar.zze = 1;
    }

    public static String zzs(int i4, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i4 == 1) {
            sb.append("Audio");
        } else if (i4 == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i4);
            sb.append(")");
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final int zza() {
        this.zzc.zzc();
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        this.zzc.zzc();
        return this.zzb.zzb(bufferInfo);
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final MediaFormat zzc() {
        return this.zzb.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    @Nullable
    public final ByteBuffer zzf(int i4) {
        return this.zza.getInputBuffer(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    @Nullable
    public final ByteBuffer zzg(int i4) {
        return this.zza.getOutputBuffer(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final void zzi() {
        this.zzc.zzb();
        this.zza.flush();
        this.zzb.zze();
        this.zza.start();
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final void zzj(int i4, int i5, int i6, long j4, int i7) {
        this.zzc.zzd(i4, 0, i6, j4, i7);
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final void zzk(int i4, int i5, zzhm zzhmVar, long j4, int i6) {
        this.zzc.zze(i4, 0, zzhmVar, j4, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final void zzl() {
        try {
            if (this.zze == 1) {
                this.zzc.zzf();
                this.zzb.zzg();
            }
            this.zze = 2;
            if (!this.zzd) {
                this.zza.release();
                this.zzd = true;
            }
        } catch (Throwable th) {
            if (!this.zzd) {
                this.zza.release();
                this.zzd = true;
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final void zzm(int i4, long j4) {
        this.zza.releaseOutputBuffer(i4, j4);
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final void zzn(int i4, boolean z3) {
        this.zza.releaseOutputBuffer(i4, z3);
    }

    @Override // com.google.android.gms.internal.ads.zzrp
    public final void zzo(Surface surface) {
        this.zza.setOutputSurface(surface);
    }

    @Override // com.google.android.gms.internal.ads.zzrp
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
