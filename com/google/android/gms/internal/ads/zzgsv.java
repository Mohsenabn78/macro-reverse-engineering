package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgsv {
    private static final zzgss zza;

    static {
        if (zzgsq.zzA() && zzgsq.zzB()) {
            int i4 = zzgnp.zza;
        }
        zza = new zzgst();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ int zzc(byte[] bArr, int i4, int i5) {
        int i6 = i5 - i4;
        byte b4 = bArr[i4 - 1];
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 == 2) {
                    return zzl(b4, bArr[i4], bArr[i4 + 1]);
                }
                throw new AssertionError();
            }
            return zzk(b4, bArr[i4]);
        } else if (b4 > -12) {
            return -1;
        } else {
            return b4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ff, code lost:
        return r9 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zzd(java.lang.CharSequence r7, byte[] r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgsv.zzd(java.lang.CharSequence, byte[], int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(CharSequence charSequence) {
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
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i5) >= 65536) {
                                i5++;
                            } else {
                                throw new zzgsu(i5, length2);
                            }
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
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i6 + 4294967296L));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(int i4, byte[] bArr, int i5, int i6) {
        return zza.zza(i4, bArr, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzg(ByteBuffer byteBuffer, int i4, int i5) throws zzgpy {
        zzgss zzgssVar = zza;
        if (byteBuffer.hasArray()) {
            return zzgssVar.zzb(byteBuffer.array(), byteBuffer.arrayOffset() + i4, i5);
        } else if (byteBuffer.isDirect()) {
            return zzgss.zzd(byteBuffer, i4, i5);
        } else {
            return zzgss.zzd(byteBuffer, i4, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzh(byte[] bArr, int i4, int i5) throws zzgpy {
        return zza.zzb(bArr, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzi(byte[] bArr) {
        return zza.zzc(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzj(byte[] bArr, int i4, int i5) {
        return zza.zzc(bArr, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzk(int i4, int i5) {
        if (i4 <= -12 && i5 <= -65) {
            return i4 ^ (i5 << 8);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzl(int i4, int i5, int i6) {
        if (i4 <= -12 && i5 <= -65 && i6 <= -65) {
            return (i4 ^ (i5 << 8)) ^ (i6 << 16);
        }
        return -1;
    }
}
