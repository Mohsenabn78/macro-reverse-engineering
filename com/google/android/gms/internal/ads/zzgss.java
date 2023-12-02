package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
abstract class zzgss {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String zzd(ByteBuffer byteBuffer, int i4, int i5) throws zzgpy {
        if ((((byteBuffer.limit() - i4) - i5) | i4 | i5) >= 0) {
            int i6 = i4 + i5;
            char[] cArr = new char[i5];
            int i7 = 0;
            while (i4 < i6) {
                byte b4 = byteBuffer.get(i4);
                if (!zzgsr.zzd(b4)) {
                    break;
                }
                i4++;
                cArr[i7] = (char) b4;
                i7++;
            }
            int i8 = i7;
            while (i4 < i6) {
                int i9 = i4 + 1;
                byte b5 = byteBuffer.get(i4);
                if (zzgsr.zzd(b5)) {
                    int i10 = i8 + 1;
                    cArr[i8] = (char) b5;
                    i4 = i9;
                    while (true) {
                        i8 = i10;
                        if (i4 < i6) {
                            byte b6 = byteBuffer.get(i4);
                            if (zzgsr.zzd(b6)) {
                                i4++;
                                i10 = i8 + 1;
                                cArr[i8] = (char) b6;
                            }
                        }
                    }
                } else if (zzgsr.zzf(b5)) {
                    if (i9 < i6) {
                        zzgsr.zzc(b5, byteBuffer.get(i9), cArr, i8);
                        i4 = i9 + 1;
                        i8++;
                    } else {
                        throw zzgpy.zzd();
                    }
                } else if (zzgsr.zze(b5)) {
                    if (i9 < i6 - 1) {
                        int i11 = i9 + 1;
                        zzgsr.zzb(b5, byteBuffer.get(i9), byteBuffer.get(i11), cArr, i8);
                        i4 = i11 + 1;
                        i8++;
                    } else {
                        throw zzgpy.zzd();
                    }
                } else if (i9 < i6 - 2) {
                    int i12 = i9 + 1;
                    byte b7 = byteBuffer.get(i9);
                    int i13 = i12 + 1;
                    zzgsr.zza(b5, b7, byteBuffer.get(i12), byteBuffer.get(i13), cArr, i8);
                    i8 += 2;
                    i4 = i13 + 1;
                } else {
                    throw zzgpy.zzd();
                }
            }
            return new String(cArr, 0, i8);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i4), Integer.valueOf(i5)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zza(int i4, byte[] bArr, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String zzb(byte[] bArr, int i4, int i5) throws zzgpy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzc(byte[] bArr, int i4, int i5) {
        if (zza(0, bArr, i4, i5) != 0) {
            return false;
        }
        return true;
    }
}
