package com.google.android.gms.internal.mlkit_translate;

import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzao {
    final int zza;
    final int zzb;
    final int zzc;
    private final String zzd;
    private final char[] zze;
    private final byte[] zzf;
    private final boolean[] zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzao(String str, char[] cArr) {
        boolean z3;
        this.zzd = str;
        cArr.getClass();
        this.zze = cArr;
        try {
            int zzb = zzax.zzb(cArr.length, RoundingMode.UNNECESSARY);
            this.zza = zzb;
            int min = Math.min(8, Integer.lowestOneBit(zzb));
            try {
                this.zzb = 8 / min;
                this.zzc = zzb / min;
                byte[] bArr = new byte[128];
                Arrays.fill(bArr, (byte) -1);
                int i4 = 0;
                while (true) {
                    boolean z4 = true;
                    if (i4 >= cArr.length) {
                        break;
                    }
                    char c4 = cArr[i4];
                    if (c4 < 128) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zzj.zzd(z3, "Non-ASCII character: %s", c4);
                    if (bArr[c4] != -1) {
                        z4 = false;
                    }
                    zzj.zzd(z4, "Duplicate character: %s", c4);
                    bArr[c4] = (byte) i4;
                    i4++;
                }
                this.zzf = bArr;
                boolean[] zArr = new boolean[this.zzb];
                for (int i5 = 0; i5 < this.zzc; i5++) {
                    zArr[zzax.zza(i5 * 8, this.zza, RoundingMode.CEILING)] = true;
                }
                this.zzg = zArr;
            } catch (ArithmeticException e4) {
                throw new IllegalArgumentException("Illegal alphabet ".concat(new String(cArr)), e4);
            }
        } catch (ArithmeticException e5) {
            throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e5);
        }
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzao) {
            return Arrays.equals(this.zze, ((zzao) obj).zze);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zze);
    }

    public final String toString() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final char zza(int i4) {
        return this.zze[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzb(char c4) throws zzar {
        if (c4 <= 127) {
            byte b4 = this.zzf[c4];
            if (b4 == -1) {
                if (c4 > ' ' && c4 != 127) {
                    throw new zzar("Unrecognized character: " + c4);
                }
                throw new zzar("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c4))));
            }
            return b4;
        }
        throw new zzar("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c4))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzc(int i4) {
        return this.zzg[i4 % this.zzb];
    }

    public final boolean zzd(char c4) {
        if (c4 < 128 && this.zzf[c4] != -1) {
            return true;
        }
        return false;
    }
}
