package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayDeque;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@RequiresApi(23)
/* loaded from: classes4.dex */
public final class zzri extends MediaCodec.Callback {
    private final HandlerThread zzb;
    private Handler zzc;
    @Nullable
    @GuardedBy("lock")
    private MediaFormat zzh;
    @Nullable
    @GuardedBy("lock")
    private MediaFormat zzi;
    @Nullable
    @GuardedBy("lock")
    private MediaCodec.CodecException zzj;
    @GuardedBy("lock")
    private long zzk;
    @GuardedBy("lock")
    private boolean zzl;
    @Nullable
    @GuardedBy("lock")
    private IllegalStateException zzm;
    private final Object zza = new Object();
    @GuardedBy("lock")
    private final zzrm zzd = new zzrm();
    @GuardedBy("lock")
    private final zzrm zze = new zzrm();
    @GuardedBy("lock")
    private final ArrayDeque zzf = new ArrayDeque();
    @GuardedBy("lock")
    private final ArrayDeque zzg = new ArrayDeque();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzri(HandlerThread handlerThread) {
        this.zzb = handlerThread;
    }

    public static /* synthetic */ void zzd(zzri zzriVar) {
        synchronized (zzriVar.zza) {
            if (zzriVar.zzl) {
                return;
            }
            long j4 = zzriVar.zzk - 1;
            zzriVar.zzk = j4;
            int i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
            if (i4 > 0) {
                return;
            }
            if (i4 < 0) {
                IllegalStateException illegalStateException = new IllegalStateException();
                synchronized (zzriVar.zza) {
                    zzriVar.zzm = illegalStateException;
                }
                return;
            }
            zzriVar.zzi();
        }
    }

    @GuardedBy("lock")
    private final void zzh(MediaFormat mediaFormat) {
        this.zze.zzb(-2);
        this.zzg.add(mediaFormat);
    }

    @GuardedBy("lock")
    private final void zzi() {
        if (!this.zzg.isEmpty()) {
            this.zzi = (MediaFormat) this.zzg.getLast();
        }
        this.zzd.zzc();
        this.zze.zzc();
        this.zzf.clear();
        this.zzg.clear();
    }

    @GuardedBy("lock")
    private final void zzj() {
        IllegalStateException illegalStateException = this.zzm;
        if (illegalStateException == null) {
            return;
        }
        this.zzm = null;
        throw illegalStateException;
    }

    @GuardedBy("lock")
    private final void zzk() {
        MediaCodec.CodecException codecException = this.zzj;
        if (codecException == null) {
            return;
        }
        this.zzj = null;
        throw codecException;
    }

    @GuardedBy("lock")
    private final boolean zzl() {
        if (this.zzk <= 0 && !this.zzl) {
            return false;
        }
        return true;
    }

    @Override // android.media.MediaCodec.Callback
    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.zza) {
            this.zzj = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i4) {
        synchronized (this.zza) {
            this.zzd.zzb(i4);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i4, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.zza) {
            MediaFormat mediaFormat = this.zzi;
            if (mediaFormat != null) {
                zzh(mediaFormat);
                this.zzi = null;
            }
            this.zze.zzb(i4);
            this.zzf.add(bufferInfo);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.zza) {
            zzh(mediaFormat);
            this.zzi = null;
        }
    }

    public final int zza() {
        synchronized (this.zza) {
            int i4 = -1;
            if (zzl()) {
                return -1;
            }
            zzj();
            zzk();
            if (!this.zzd.zzd()) {
                i4 = this.zzd.zza();
            }
            return i4;
        }
    }

    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.zza) {
            if (zzl()) {
                return -1;
            }
            zzj();
            zzk();
            if (this.zze.zzd()) {
                return -1;
            }
            int zza = this.zze.zza();
            if (zza >= 0) {
                zzdy.zzb(this.zzh);
                MediaCodec.BufferInfo bufferInfo2 = (MediaCodec.BufferInfo) this.zzf.remove();
                bufferInfo.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
            } else if (zza == -2) {
                this.zzh = (MediaFormat) this.zzg.remove();
                zza = -2;
            }
            return zza;
        }
    }

    public final MediaFormat zzc() {
        MediaFormat mediaFormat;
        synchronized (this.zza) {
            mediaFormat = this.zzh;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    public final void zze() {
        synchronized (this.zza) {
            this.zzk++;
            Handler handler = this.zzc;
            int i4 = zzfj.zza;
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrh
                @Override // java.lang.Runnable
                public final void run() {
                    zzri.zzd(zzri.this);
                }
            });
        }
    }

    public final void zzf(MediaCodec mediaCodec) {
        boolean z3;
        if (this.zzc == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzf(z3);
        this.zzb.start();
        Handler handler = new Handler(this.zzb.getLooper());
        mediaCodec.setCallback(this, handler);
        this.zzc = handler;
    }

    public final void zzg() {
        synchronized (this.zza) {
            this.zzl = true;
            this.zzb.quit();
            zzi();
        }
    }
}
