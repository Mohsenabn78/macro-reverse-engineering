package com.google.android.gms.internal.ads;

import androidx.annotation.IntRange;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzrj extends zzhp {
    private long zzf;
    private int zzg;
    private int zzh;

    public zzrj() {
        super(2, 0);
        this.zzh = 32;
    }

    @Override // com.google.android.gms.internal.ads.zzhp, com.google.android.gms.internal.ads.zzhj
    public final void zzb() {
        super.zzb();
        this.zzg = 0;
    }

    public final int zzm() {
        return this.zzg;
    }

    public final long zzn() {
        return this.zzf;
    }

    public final void zzo(@IntRange(from = 1) int i4) {
        this.zzh = i4;
    }

    public final boolean zzp(zzhp zzhpVar) {
        ByteBuffer byteBuffer;
        zzdy.zzd(!zzhpVar.zzd(1073741824));
        zzdy.zzd(!zzhpVar.zzd(268435456));
        zzdy.zzd(!zzhpVar.zzd(4));
        if (zzq()) {
            if (this.zzg < this.zzh && zzhpVar.zzd(Integer.MIN_VALUE) == zzd(Integer.MIN_VALUE)) {
                ByteBuffer byteBuffer2 = zzhpVar.zzb;
                if (byteBuffer2 != null && (byteBuffer = this.zzb) != null && byteBuffer.position() + byteBuffer2.remaining() > 3072000) {
                    return false;
                }
            } else {
                return false;
            }
        }
        int i4 = this.zzg;
        this.zzg = i4 + 1;
        if (i4 == 0) {
            this.zzd = zzhpVar.zzd;
            if (zzhpVar.zzd(1)) {
                zzc(1);
            }
        }
        if (zzhpVar.zzd(Integer.MIN_VALUE)) {
            zzc(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer3 = zzhpVar.zzb;
        if (byteBuffer3 != null) {
            zzj(byteBuffer3.remaining());
            this.zzb.put(byteBuffer3);
        }
        this.zzf = zzhpVar.zzd;
        return true;
    }

    public final boolean zzq() {
        if (this.zzg > 0) {
            return true;
        }
        return false;
    }
}
