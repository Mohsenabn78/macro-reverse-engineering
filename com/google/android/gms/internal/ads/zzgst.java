package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgst extends zzgss {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r13[r14] <= (-65)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0047, code lost:
        if (r13[r14] <= (-65)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0083, code lost:
        if (r13[r14] <= (-65)) goto L11;
     */
    @Override // com.google.android.gms.internal.ads.zzgss
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(int r12, byte[] r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgst.zza(int, byte[], int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgss
    public final String zzb(byte[] bArr, int i4, int i5) throws zzgpy {
        int length = bArr.length;
        if ((((length - i4) - i5) | i4 | i5) >= 0) {
            int i6 = i4 + i5;
            char[] cArr = new char[i5];
            int i7 = 0;
            while (i4 < i6) {
                byte b4 = bArr[i4];
                if (!zzgsr.zzd(b4)) {
                    break;
                }
                i4++;
                cArr[i7] = (char) b4;
                i7++;
            }
            while (i4 < i6) {
                int i8 = i4 + 1;
                byte b5 = bArr[i4];
                if (zzgsr.zzd(b5)) {
                    int i9 = i7 + 1;
                    cArr[i7] = (char) b5;
                    i4 = i8;
                    while (true) {
                        i7 = i9;
                        if (i4 < i6) {
                            byte b6 = bArr[i4];
                            if (zzgsr.zzd(b6)) {
                                i4++;
                                i9 = i7 + 1;
                                cArr[i7] = (char) b6;
                            }
                        }
                    }
                } else if (zzgsr.zzf(b5)) {
                    if (i8 < i6) {
                        zzgsr.zzc(b5, bArr[i8], cArr, i7);
                        i4 = i8 + 1;
                        i7++;
                    } else {
                        throw zzgpy.zzd();
                    }
                } else if (zzgsr.zze(b5)) {
                    if (i8 < i6 - 1) {
                        int i10 = i8 + 1;
                        zzgsr.zzb(b5, bArr[i8], bArr[i10], cArr, i7);
                        i4 = i10 + 1;
                        i7++;
                    } else {
                        throw zzgpy.zzd();
                    }
                } else if (i8 < i6 - 2) {
                    int i11 = i8 + 1;
                    byte b7 = bArr[i8];
                    int i12 = i11 + 1;
                    zzgsr.zza(b5, b7, bArr[i11], bArr[i12], cArr, i7);
                    i7 += 2;
                    i4 = i12 + 1;
                } else {
                    throw zzgpy.zzd();
                }
            }
            return new String(cArr, 0, i7);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i4), Integer.valueOf(i5)));
    }
}
