package com.google.android.gms.internal.ads;

import android.media.AudioFormat;
import android.media.AudioTrack;
import androidx.compose.animation.core.AnimationKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzpo {
    public final zzam zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final zzdo zzi;
    public final boolean zzj = false;
    public final boolean zzk = false;

    public zzpo(zzam zzamVar, int i4, int i5, int i6, int i7, int i8, int i9, int i10, zzdo zzdoVar, boolean z3, boolean z4) {
        this.zza = zzamVar;
        this.zzb = i4;
        this.zzc = i5;
        this.zzd = i6;
        this.zze = i7;
        this.zzf = i8;
        this.zzg = i9;
        this.zzh = i10;
        this.zzi = zzdoVar;
    }

    public final long zza(long j4) {
        return (j4 * AnimationKt.MillisToNanos) / this.zze;
    }

    public final AudioTrack zzb(boolean z3, zzk zzkVar, int i4) throws zzov {
        AudioTrack audioTrack;
        AudioTrack.Builder audioAttributes;
        AudioTrack.Builder audioFormat;
        AudioTrack.Builder transferMode;
        AudioTrack.Builder bufferSizeInBytes;
        AudioTrack.Builder sessionId;
        boolean z4;
        AudioTrack.Builder offloadedPlayback;
        try {
            int i5 = zzfj.zza;
            if (i5 >= 29) {
                AudioFormat zzs = zzfj.zzs(this.zze, this.zzf, this.zzg);
                audioAttributes = new AudioTrack.Builder().setAudioAttributes(zzkVar.zza().zza);
                audioFormat = audioAttributes.setAudioFormat(zzs);
                transferMode = audioFormat.setTransferMode(1);
                bufferSizeInBytes = transferMode.setBufferSizeInBytes(this.zzh);
                sessionId = bufferSizeInBytes.setSessionId(i4);
                if (this.zzc == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                offloadedPlayback = sessionId.setOffloadedPlayback(z4);
                audioTrack = offloadedPlayback.build();
            } else if (i5 < 21) {
                int i6 = zzkVar.zzc;
                if (i4 == 0) {
                    audioTrack = new AudioTrack(3, this.zze, this.zzf, this.zzg, this.zzh, 1);
                } else {
                    audioTrack = new AudioTrack(3, this.zze, this.zzf, this.zzg, this.zzh, 1, i4);
                }
            } else {
                audioTrack = new AudioTrack(zzkVar.zza().zza, zzfj.zzs(this.zze, this.zzf, this.zzg), this.zzh, 1, i4);
            }
            int state = audioTrack.getState();
            if (state == 1) {
                return audioTrack;
            }
            try {
                audioTrack.release();
            } catch (Exception unused) {
            }
            throw new zzov(state, this.zze, this.zzf, this.zzh, this.zza, zzc(), null);
        } catch (IllegalArgumentException | UnsupportedOperationException e4) {
            throw new zzov(0, this.zze, this.zzf, this.zzh, this.zza, zzc(), e4);
        }
    }

    public final boolean zzc() {
        if (this.zzc == 1) {
            return true;
        }
        return false;
    }
}
