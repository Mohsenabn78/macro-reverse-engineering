package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzrk {
    private long zza;
    private long zzb;
    private boolean zzc;

    private final long zzd(long j4) {
        return this.zza + Math.max(0L, ((this.zzb - 529) * AnimationKt.MillisToNanos) / j4);
    }

    public final long zza(zzam zzamVar) {
        return zzd(zzamVar.zzA);
    }

    public final long zzb(zzam zzamVar, zzhp zzhpVar) {
        if (this.zzb == 0) {
            this.zza = zzhpVar.zzd;
        }
        if (this.zzc) {
            return zzhpVar.zzd;
        }
        ByteBuffer byteBuffer = zzhpVar.zzb;
        byteBuffer.getClass();
        int i4 = 0;
        for (int i5 = 0; i5 < 4; i5++) {
            i4 = (i4 << 8) | (byteBuffer.get(i5) & 255);
        }
        int zzc = zzabq.zzc(i4);
        if (zzc == -1) {
            this.zzc = true;
            this.zzb = 0L;
            this.zza = zzhpVar.zzd;
            zzer.zzf("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
            return zzhpVar.zzd;
        }
        long zzd = zzd(zzamVar.zzA);
        this.zzb += zzc;
        return zzd;
    }

    public final void zzc() {
        this.zza = 0L;
        this.zzb = 0L;
        this.zzc = false;
    }
}
