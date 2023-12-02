package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaem {
    public static final zzaek zza = new zzaek() { // from class: com.google.android.gms.internal.ads.zzaej
    };

    /* JADX WARN: Removed duplicated region for block: B:34:0x00af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b0  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.google.android.gms.internal.ads.zzbz zza(byte[] r11, int r12, com.google.android.gms.internal.ads.zzaek r13, com.google.android.gms.internal.ads.zzadn r14) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaem.zza(byte[], int, com.google.android.gms.internal.ads.zzaek, com.google.android.gms.internal.ads.zzadn):com.google.android.gms.internal.ads.zzbz");
    }

    private static int zzb(int i4) {
        if (i4 != 0 && i4 != 3) {
            return 2;
        }
        return 1;
    }

    private static int zzc(byte[] bArr, int i4, int i5) {
        int zzd = zzd(bArr, i4);
        if (i5 == 0 || i5 == 3) {
            return zzd;
        }
        while (true) {
            int length = bArr.length;
            if (zzd < length - 1) {
                if ((zzd - i4) % 2 == 0 && bArr[zzd + 1] == 0) {
                    return zzd;
                }
                zzd = zzd(bArr, zzd + 1);
            } else {
                return length;
            }
        }
    }

    private static int zzd(byte[] bArr, int i4) {
        while (true) {
            int length = bArr.length;
            if (i4 < length) {
                if (bArr[i4] == 0) {
                    return i4;
                }
                i4++;
            } else {
                return length;
            }
        }
    }

    private static int zze(zzfa zzfaVar, int i4) {
        byte[] zzH = zzfaVar.zzH();
        int zzc = zzfaVar.zzc();
        int i5 = zzc;
        while (true) {
            int i6 = i5 + 1;
            if (i6 < zzc + i4) {
                if ((zzH[i5] & 255) == 255 && zzH[i6] == 0) {
                    System.arraycopy(zzH, i5 + 2, zzH, i6, (i4 - (i5 - zzc)) - 2);
                    i4--;
                }
                i5 = i6;
            } else {
                return i4;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:139:0x026e, code lost:
        if (r9 == 67) goto L108;
     */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x04f5 A[Catch: all -> 0x051a, TRY_LEAVE, TryCatch #0 {all -> 0x051a, blocks: (B:223:0x04f5, B:124:0x0219, B:140:0x0270, B:142:0x0282, B:149:0x02c3, B:146:0x02a4, B:148:0x02bd, B:161:0x0305, B:170:0x034c, B:173:0x0381, B:176:0x0392, B:177:0x039a, B:179:0x03a0, B:181:0x03a7, B:182:0x03ab, B:189:0x03cd, B:193:0x03fa, B:195:0x0404, B:196:0x0437, B:197:0x0443, B:199:0x0449, B:201:0x0450, B:202:0x0454, B:206:0x0469, B:215:0x0494, B:217:0x04be, B:218:0x04cd, B:221:0x04e4), top: B:235:0x00f4 }] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.gms.internal.ads.zzaen zzf(int r35, com.google.android.gms.internal.ads.zzfa r36, boolean r37, int r38, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzaek r39) {
        /*
            Method dump skipped, instructions count: 1336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaem.zzf(int, com.google.android.gms.internal.ads.zzfa, boolean, int, com.google.android.gms.internal.ads.zzaek):com.google.android.gms.internal.ads.zzaen");
    }

    private static zzfsc zzg(byte[] bArr, int i4, int i5) {
        if (i5 >= bArr.length) {
            return zzfsc.zzm("");
        }
        zzfrz zzfrzVar = new zzfrz();
        int zzc = zzc(bArr, i5, i4);
        while (i5 < zzc) {
            zzfrzVar.zzf(new String(bArr, i5, zzc - i5, zzj(i4)));
            i5 = zzb(i4) + zzc;
            zzc = zzc(bArr, i5, i4);
        }
        zzfsc zzi = zzfrzVar.zzi();
        if (zzi.isEmpty()) {
            return zzfsc.zzm("");
        }
        return zzi;
    }

    private static String zzh(byte[] bArr, int i4, int i5, Charset charset) {
        if (i5 > i4 && i5 <= bArr.length) {
            return new String(bArr, i4, i5 - i4, charset);
        }
        return "";
    }

    private static String zzi(int i4, int i5, int i6, int i7, int i8) {
        if (i4 == 2) {
            return String.format(Locale.US, "%c%c%c", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
        }
        return String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
    }

    private static Charset zzj(int i4) {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    return zzfot.zzb;
                }
                return zzfot.zzc;
            }
            return zzfot.zzd;
        }
        return zzfot.zzf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0087, code lost:
        if ((r10 & 128) != 0) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean zzk(com.google.android.gms.internal.ads.zzfa r21, int r22, int r23, boolean r24) {
        /*
            r1 = r21
            r0 = r22
            int r2 = r21.zzc()
        L8:
            int r3 = r21.zza()     // Catch: java.lang.Throwable -> Lb0
            r4 = 1
            r5 = r23
            if (r3 < r5) goto Lac
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L22
            int r7 = r21.zze()     // Catch: java.lang.Throwable -> Lb0
            long r8 = r21.zzs()     // Catch: java.lang.Throwable -> Lb0
            int r10 = r21.zzo()     // Catch: java.lang.Throwable -> Lb0
            goto L2c
        L22:
            int r7 = r21.zzm()     // Catch: java.lang.Throwable -> Lb0
            int r8 = r21.zzm()     // Catch: java.lang.Throwable -> Lb0
            long r8 = (long) r8
            r10 = 0
        L2c:
            r11 = 0
            if (r7 != 0) goto L3b
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L3b
            if (r10 == 0) goto L37
            goto L3b
        L37:
            r1.zzF(r2)
            return r4
        L3b:
            r7 = 4
            if (r0 != r7) goto L6c
            if (r24 != 0) goto L6c
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L4c
            r1.zzF(r2)
            return r6
        L4c:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            r17 = 16
            long r17 = r8 >> r17
            r19 = 24
            long r8 = r8 >> r19
            long r15 = r15 & r11
            long r11 = r17 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 14
            long r11 = r11 << r15
            long r11 = r11 | r13
            r13 = 21
            long r8 = r8 << r13
            long r8 = r8 | r11
        L6c:
            if (r0 != r7) goto L7c
            r3 = r10 & 64
            if (r3 == 0) goto L73
            goto L74
        L73:
            r4 = 0
        L74:
            r3 = r10 & 1
            r20 = r4
            r4 = r3
            r3 = r20
            goto L8c
        L7c:
            if (r0 != r3) goto L8a
            r3 = r10 & 32
            if (r3 == 0) goto L84
            r3 = 1
            goto L85
        L84:
            r3 = 0
        L85:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L8b
            goto L8c
        L8a:
            r3 = 0
        L8b:
            r4 = 0
        L8c:
            if (r4 == 0) goto L90
            int r3 = r3 + 4
        L90:
            long r3 = (long) r3
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L99
            r1.zzF(r2)
            return r6
        L99:
            int r3 = r21.zza()     // Catch: java.lang.Throwable -> Lb0
            long r3 = (long) r3
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto La6
            r1.zzF(r2)
            return r6
        La6:
            int r3 = (int) r8
            r1.zzG(r3)     // Catch: java.lang.Throwable -> Lb0
            goto L8
        Lac:
            r1.zzF(r2)
            return r4
        Lb0:
            r0 = move-exception
            r1.zzF(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaem.zzk(com.google.android.gms.internal.ads.zzfa, int, int, boolean):boolean");
    }

    private static byte[] zzl(byte[] bArr, int i4, int i5) {
        if (i5 <= i4) {
            return zzfj.zzf;
        }
        return Arrays.copyOfRange(bArr, i4, i5);
    }
}
