package com.google.android.gms.internal.ads;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import androidx.annotation.RequiresApi;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@RequiresApi(19)
/* loaded from: classes4.dex */
final class zzpa {
    private final AudioTrack zza;
    private final AudioTimestamp zzb = new AudioTimestamp();
    private long zzc;
    private long zzd;
    private long zze;

    public zzpa(AudioTrack audioTrack) {
        this.zza = audioTrack;
    }

    public final long zza() {
        return this.zze;
    }

    public final long zzb() {
        return this.zzb.nanoTime / 1000;
    }

    public final boolean zzc() {
        boolean timestamp = this.zza.getTimestamp(this.zzb);
        if (timestamp) {
            long j4 = this.zzb.framePosition;
            if (this.zzd > j4) {
                this.zzc++;
            }
            this.zzd = j4;
            this.zze = j4 + (this.zzc << 32);
        }
        return timestamp;
    }
}
