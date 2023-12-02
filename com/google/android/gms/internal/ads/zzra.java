package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.HandlerThread;
import android.os.Trace;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzra implements zzro {
    private final zzfpx zzb;
    private final zzfpx zzc;

    public zzra(int i4, boolean z3) {
        zzqy zzqyVar = new zzqy(i4);
        zzqz zzqzVar = new zzqz(i4);
        this.zzb = zzqyVar;
        this.zzc = zzqzVar;
    }

    public static /* synthetic */ HandlerThread zza(int i4) {
        String zzs;
        zzs = zzrc.zzs(i4, "ExoPlayer:MediaCodecAsyncAdapter:");
        return new HandlerThread(zzs);
    }

    public static /* synthetic */ HandlerThread zzb(int i4) {
        String zzs;
        zzs = zzrc.zzs(i4, "ExoPlayer:MediaCodecQueueingThread:");
        return new HandlerThread(zzs);
    }

    public final zzrc zzc(zzrn zzrnVar) throws IOException {
        MediaCodec mediaCodec;
        String str = zzrnVar.zza.zza;
        zzrc zzrcVar = null;
        try {
            int i4 = zzfj.zza;
            Trace.beginSection("createCodec:" + str);
            mediaCodec = MediaCodec.createByCodecName(str);
            try {
                zzrc zzrcVar2 = new zzrc(mediaCodec, zza(((zzqy) this.zzb).zza), zzb(((zzqz) this.zzc).zza), false, null);
                try {
                    Trace.endSection();
                    zzrc.zzh(zzrcVar2, zzrnVar.zzb, zzrnVar.zzd, null, 0);
                    return zzrcVar2;
                } catch (Exception e4) {
                    e = e4;
                    zzrcVar = zzrcVar2;
                    if (zzrcVar == null) {
                        if (mediaCodec != null) {
                            mediaCodec.release();
                        }
                    } else {
                        zzrcVar.zzl();
                    }
                    throw e;
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Exception e6) {
            e = e6;
            mediaCodec = null;
        }
    }
}
