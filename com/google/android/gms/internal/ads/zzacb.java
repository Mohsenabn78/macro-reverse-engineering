package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzacb {
    private final byte[] zza;
    private final int zzb;
    private int zzc;
    private int zzd;

    public zzacb(byte[] bArr) {
        this.zza = bArr;
        this.zzb = bArr.length;
    }

    public final int zza() {
        return (this.zzc * 8) + this.zzd;
    }

    public final int zzb(int i4) {
        int i5 = this.zzc;
        int i6 = i5 + 1;
        int min = Math.min(i4, 8 - this.zzd);
        int i7 = ((this.zza[i5] & 255) >> this.zzd) & (255 >> (8 - min));
        while (min < i4) {
            i7 |= (this.zza[i6] & 255) << min;
            min += 8;
            i6++;
        }
        int i8 = i7 & ((-1) >>> (32 - i4));
        zzc(i4);
        return i8;
    }

    public final void zzc(int i4) {
        int i5;
        int i6 = i4 / 8;
        int i7 = this.zzc + i6;
        this.zzc = i7;
        int i8 = this.zzd + (i4 - (i6 * 8));
        this.zzd = i8;
        if (i8 > 7) {
            i7++;
            this.zzc = i7;
            i8 -= 8;
            this.zzd = i8;
        }
        boolean z3 = false;
        if (i7 >= 0 && (i7 < (i5 = this.zzb) || (i7 == i5 && i8 == 0))) {
            z3 = true;
        }
        zzdy.zzf(z3);
    }

    public final boolean zzd() {
        zzc(1);
        if (1 == (((this.zza[this.zzc] & 255) >> this.zzd) & 1)) {
            return true;
        }
        return false;
    }
}
