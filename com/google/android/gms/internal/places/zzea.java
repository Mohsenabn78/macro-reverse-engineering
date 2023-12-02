package com.google.android.gms.internal.places;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzea {
    private static final zzec zzni;

    static {
        boolean z3;
        zzec zzebVar;
        if (zzdy.zzdl() && zzdy.zzdm()) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 && !zzp.zzy()) {
            zzebVar = new zzed();
        } else {
            zzebVar = new zzeb();
        }
        zzni = zzebVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzao(int i4) {
        if (i4 > -12) {
            return -1;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(CharSequence charSequence) {
        int length = charSequence.length();
        int i4 = 0;
        int i5 = 0;
        while (i5 < length && charSequence.charAt(i5) < 128) {
            i5++;
        }
        int i6 = length;
        while (true) {
            if (i5 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i5);
            if (charAt < 2048) {
                i6 += (127 - charAt) >>> 31;
                i5++;
            } else {
                int length2 = charSequence.length();
                while (i5 < length2) {
                    char charAt2 = charSequence.charAt(i5);
                    if (charAt2 < 2048) {
                        i4 += (127 - charAt2) >>> 31;
                    } else {
                        i4 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i5) < 65536) {
                                throw new zzee(i5, length2);
                            }
                            i5++;
                        }
                    }
                    i5++;
                }
                i6 += i4;
            }
        }
        if (i6 >= length) {
            return i6;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(i6 + 4294967296L);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzd(int i4, int i5, int i6) {
        if (i4 <= -12 && i5 <= -65 && i6 <= -65) {
            return (i4 ^ (i5 << 8)) ^ (i6 << 16);
        }
        return -1;
    }

    public static boolean zze(byte[] bArr) {
        return zzni.zzf(bArr, 0, bArr.length);
    }

    public static boolean zzf(byte[] bArr, int i4, int i5) {
        return zzni.zzf(bArr, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzg(byte[] bArr, int i4, int i5) {
        byte b4 = bArr[i4 - 1];
        int i6 = i5 - i4;
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 == 2) {
                    return zzd(b4, bArr[i4], bArr[i4 + 1]);
                }
                throw new AssertionError();
            }
            return zzs(b4, bArr[i4]);
        }
        return zzao(b4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzh(byte[] bArr, int i4, int i5) throws zzbk {
        return zzni.zzh(bArr, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzs(int i4, int i5) {
        if (i4 <= -12 && i5 <= -65) {
            return i4 ^ (i5 << 8);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(CharSequence charSequence, byte[] bArr, int i4, int i5) {
        return zzni.zzc(charSequence, bArr, i4, i5);
    }
}
