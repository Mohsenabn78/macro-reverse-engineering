package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzagn {
    private static final byte[] zza;

    static {
        int i4 = zzfj.zza;
        zza = "OpusHead".getBytes(zzfot.zzc);
    }

    @Nullable
    public static zzbz zza(zzagc zzagcVar) {
        zzfn zzfnVar;
        zzagd zzb = zzagcVar.zzb(1751411826);
        zzagd zzb2 = zzagcVar.zzb(1801812339);
        zzagd zzb3 = zzagcVar.zzb(1768715124);
        if (zzb == null || zzb2 == null || zzb3 == null || zzg(zzb.zza) != 1835299937) {
            return null;
        }
        zzfa zzfaVar = zzb2.zza;
        zzfaVar.zzF(12);
        int zze = zzfaVar.zze();
        String[] strArr = new String[zze];
        for (int i4 = 0; i4 < zze; i4++) {
            int zze2 = zzfaVar.zze();
            zzfaVar.zzG(4);
            strArr[i4] = zzfaVar.zzx(zze2 - 8, zzfot.zzc);
        }
        zzfa zzfaVar2 = zzb3.zza;
        zzfaVar2.zzF(8);
        ArrayList arrayList = new ArrayList();
        while (zzfaVar2.zza() > 8) {
            int zzc = zzfaVar2.zzc();
            int zze3 = zzfaVar2.zze();
            int zze4 = zzfaVar2.zze() - 1;
            if (zze4 >= 0 && zze4 < zze) {
                String str = strArr[zze4];
                int i5 = zzc + zze3;
                int i6 = zzagu.zzb;
                while (true) {
                    int zzc2 = zzfaVar2.zzc();
                    if (zzc2 < i5) {
                        int zze5 = zzfaVar2.zze();
                        if (zzfaVar2.zze() == 1684108385) {
                            int zze6 = zzfaVar2.zze();
                            int zze7 = zzfaVar2.zze();
                            int i7 = zze5 - 16;
                            byte[] bArr = new byte[i7];
                            zzfaVar2.zzB(bArr, 0, i7);
                            zzfnVar = new zzfn(str, bArr, zze7, zze6);
                            break;
                        }
                        zzfaVar2.zzF(zzc2 + zze5);
                    } else {
                        zzfnVar = null;
                        break;
                    }
                }
                if (zzfnVar != null) {
                    arrayList.add(zzfnVar);
                }
            } else {
                zzer.zzf("AtomParsers", "Skipped metadata with unknown key index: " + zze4);
            }
            zzfaVar2.zzF(zzc + zze3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzbz(arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b0, code lost:
        if (r3 != 13) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzagm zzb(com.google.android.gms.internal.ads.zzagd r12) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagn.zzb(com.google.android.gms.internal.ads.zzagd):com.google.android.gms.internal.ads.zzagm");
    }

    /* JADX WARN: Removed duplicated region for block: B:378:0x07f5  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x08a3  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x0a4f  */
    /* JADX WARN: Removed duplicated region for block: B:495:0x0b31 A[LOOP:13: B:495:0x0b31->B:499:0x0b3b, LOOP_START, PHI: r21 
      PHI: (r21v17 int) = (r21v16 int), (r21v18 int) binds: [B:494:0x0b2f, B:499:0x0b3b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:502:0x0b44  */
    /* JADX WARN: Removed duplicated region for block: B:513:0x0b97  */
    /* JADX WARN: Removed duplicated region for block: B:517:0x0be4  */
    /* JADX WARN: Removed duplicated region for block: B:518:0x0be7  */
    /* JADX WARN: Removed duplicated region for block: B:523:0x0c0a  */
    /* JADX WARN: Removed duplicated region for block: B:524:0x0c22  */
    /* JADX WARN: Removed duplicated region for block: B:612:0x0e74  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:620:0x0e83 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:639:0x0b26 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x018a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List zzc(com.google.android.gms.internal.ads.zzagc r58, com.google.android.gms.internal.ads.zzabl r59, long r60, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzad r62, boolean r63, boolean r64, com.google.android.gms.internal.ads.zzfov r65) throws com.google.android.gms.internal.ads.zzcd {
        /*
            Method dump skipped, instructions count: 3725
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagn.zzc(com.google.android.gms.internal.ads.zzagc, com.google.android.gms.internal.ads.zzabl, long, com.google.android.gms.internal.ads.zzad, boolean, boolean, com.google.android.gms.internal.ads.zzfov):java.util.List");
    }

    public static void zzd(zzfa zzfaVar) {
        int zzc = zzfaVar.zzc();
        zzfaVar.zzG(4);
        if (zzfaVar.zze() != 1751411826) {
            zzc += 4;
        }
        zzfaVar.zzF(zzc);
    }

    private static int zze(int i4) {
        if (i4 == 1936684398) {
            return 1;
        }
        if (i4 == 1986618469) {
            return 2;
        }
        if (i4 != 1952807028 && i4 != 1935832172 && i4 != 1937072756 && i4 != 1668047728) {
            if (i4 == 1835365473) {
                return 5;
            }
            return -1;
        }
        return 3;
    }

    private static int zzf(zzfa zzfaVar) {
        int zzk = zzfaVar.zzk();
        int i4 = zzk & 127;
        while ((zzk & 128) == 128) {
            zzk = zzfaVar.zzk();
            i4 = (i4 << 7) | (zzk & 127);
        }
        return i4;
    }

    private static int zzg(zzfa zzfaVar) {
        zzfaVar.zzF(16);
        return zzfaVar.zze();
    }

    @Nullable
    private static Pair zzh(zzagc zzagcVar) {
        long zzs;
        long zze;
        zzagd zzb = zzagcVar.zzb(1701606260);
        if (zzb == null) {
            return null;
        }
        zzfa zzfaVar = zzb.zza;
        zzfaVar.zzF(8);
        int zze2 = zzage.zze(zzfaVar.zze());
        int zzn = zzfaVar.zzn();
        long[] jArr = new long[zzn];
        long[] jArr2 = new long[zzn];
        for (int i4 = 0; i4 < zzn; i4++) {
            if (zze2 == 1) {
                zzs = zzfaVar.zzt();
            } else {
                zzs = zzfaVar.zzs();
            }
            jArr[i4] = zzs;
            if (zze2 == 1) {
                zze = zzfaVar.zzr();
            } else {
                zze = zzfaVar.zze();
            }
            jArr2[i4] = zze;
            if (zzfaVar.zzy() == 1) {
                zzfaVar.zzG(2);
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    private static Pair zzi(zzfa zzfaVar) {
        int i4;
        int i5 = 8;
        zzfaVar.zzF(8);
        int zze = zzage.zze(zzfaVar.zze());
        if (zze == 0) {
            i4 = 8;
        } else {
            i4 = 16;
        }
        zzfaVar.zzG(i4);
        long zzs = zzfaVar.zzs();
        if (zze == 0) {
            i5 = 4;
        }
        zzfaVar.zzG(i5);
        int zzo = zzfaVar.zzo();
        StringBuilder sb = new StringBuilder();
        sb.append((char) (((zzo >> 10) & 31) + 96));
        sb.append((char) (((zzo >> 5) & 31) + 96));
        sb.append((char) ((zzo & 31) + 96));
        return Pair.create(Long.valueOf(zzs), sb.toString());
    }

    @Nullable
    private static Pair zzj(zzfa zzfaVar, int i4, int i5) throws zzcd {
        boolean z3;
        boolean z4;
        boolean z5;
        Integer num;
        zzahd zzahdVar;
        Pair create;
        int i6;
        int i7;
        boolean z6;
        byte[] bArr;
        int zzc = zzfaVar.zzc();
        while (zzc - i4 < i5) {
            zzfaVar.zzF(zzc);
            int zze = zzfaVar.zze();
            boolean z7 = true;
            if (zze > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            zzaba.zzb(z3, "childAtomSize must be positive");
            if (zzfaVar.zze() == 1936289382) {
                int i8 = zzc + 8;
                int i9 = -1;
                int i10 = 0;
                String str = null;
                Integer num2 = null;
                while (i8 - zzc < zze) {
                    zzfaVar.zzF(i8);
                    int zze2 = zzfaVar.zze();
                    int zze3 = zzfaVar.zze();
                    if (zze3 == 1718775137) {
                        num2 = Integer.valueOf(zzfaVar.zze());
                    } else if (zze3 == 1935894637) {
                        zzfaVar.zzG(4);
                        str = zzfaVar.zzx(4, zzfot.zzc);
                    } else if (zze3 == 1935894633) {
                        i9 = i8;
                        i10 = zze2;
                    }
                    i8 += zze2;
                }
                if (!"cenc".equals(str) && !"cbc1".equals(str) && !"cens".equals(str) && !"cbcs".equals(str)) {
                    create = null;
                } else {
                    if (num2 != null) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    zzaba.zzb(z4, "frma atom is mandatory");
                    if (i9 != -1) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    zzaba.zzb(z5, "schi atom is mandatory");
                    int i11 = i9 + 8;
                    while (true) {
                        if (i11 - i9 < i10) {
                            zzfaVar.zzF(i11);
                            int zze4 = zzfaVar.zze();
                            if (zzfaVar.zze() == 1952804451) {
                                int zze5 = zzage.zze(zzfaVar.zze());
                                zzfaVar.zzG(1);
                                if (zze5 == 0) {
                                    zzfaVar.zzG(1);
                                    i6 = 0;
                                    i7 = 0;
                                } else {
                                    int zzk = zzfaVar.zzk();
                                    int i12 = zzk & 240;
                                    i6 = zzk & 15;
                                    i7 = i12 >> 4;
                                }
                                if (zzfaVar.zzk() == 1) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                int zzk2 = zzfaVar.zzk();
                                byte[] bArr2 = new byte[16];
                                zzfaVar.zzB(bArr2, 0, 16);
                                if (z6 && zzk2 == 0) {
                                    int zzk3 = zzfaVar.zzk();
                                    byte[] bArr3 = new byte[zzk3];
                                    zzfaVar.zzB(bArr3, 0, zzk3);
                                    bArr = bArr3;
                                } else {
                                    bArr = null;
                                }
                                num = num2;
                                zzahdVar = new zzahd(z6, str, zzk2, bArr2, i7, i6, bArr);
                            } else {
                                i11 += zze4;
                            }
                        } else {
                            num = num2;
                            zzahdVar = null;
                            break;
                        }
                    }
                    if (zzahdVar == null) {
                        z7 = false;
                    }
                    zzaba.zzb(z7, "tenc atom is mandatory");
                    int i13 = zzfj.zza;
                    create = Pair.create(num, zzahdVar);
                }
                if (create != null) {
                    return create;
                }
            }
            zzc += zze;
        }
        return null;
    }

    @Nullable
    private static zzbz zzk(zzfa zzfaVar) {
        short zzy = zzfaVar.zzy();
        zzfaVar.zzG(2);
        String zzx = zzfaVar.zzx(zzy, zzfot.zzc);
        int max = Math.max(zzx.lastIndexOf(43), zzx.lastIndexOf(45));
        try {
            return new zzbz(-9223372036854775807L, new zzfq(Float.parseFloat(zzx.substring(0, max)), Float.parseFloat(zzx.substring(max, zzx.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static zzagg zzl(zzfa zzfaVar, int i4) {
        long j4;
        long j5;
        zzfaVar.zzF(i4 + 12);
        zzfaVar.zzG(1);
        zzf(zzfaVar);
        zzfaVar.zzG(2);
        int zzk = zzfaVar.zzk();
        if ((zzk & 128) != 0) {
            zzfaVar.zzG(2);
        }
        if ((zzk & 64) != 0) {
            zzfaVar.zzG(zzfaVar.zzk());
        }
        if ((zzk & 32) != 0) {
            zzfaVar.zzG(2);
        }
        zzfaVar.zzG(1);
        zzf(zzfaVar);
        String zzd = zzcc.zzd(zzfaVar.zzk());
        if (!"audio/mpeg".equals(zzd) && !"audio/vnd.dts".equals(zzd) && !"audio/vnd.dts.hd".equals(zzd)) {
            zzfaVar.zzG(4);
            long zzs = zzfaVar.zzs();
            long zzs2 = zzfaVar.zzs();
            zzfaVar.zzG(1);
            int zzf = zzf(zzfaVar);
            byte[] bArr = new byte[zzf];
            zzfaVar.zzB(bArr, 0, zzf);
            if (zzs2 <= 0) {
                j4 = -1;
            } else {
                j4 = zzs2;
            }
            if (zzs > 0) {
                j5 = zzs;
            } else {
                j5 = -1;
            }
            return new zzagg(zzd, bArr, j4, j5);
        }
        return new zzagg(zzd, null, -1L, -1L);
    }

    private static ByteBuffer zzm() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03ab A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:194:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zzn(com.google.android.gms.internal.ads.zzfa r23, int r24, int r25, int r26, int r27, java.lang.String r28, boolean r29, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzad r30, com.google.android.gms.internal.ads.zzagi r31, int r32) throws com.google.android.gms.internal.ads.zzcd {
        /*
            Method dump skipped, instructions count: 1010
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagn.zzn(com.google.android.gms.internal.ads.zzfa, int, int, int, int, java.lang.String, boolean, com.google.android.gms.internal.ads.zzad, com.google.android.gms.internal.ads.zzagi, int):void");
    }

    private static void zzo(zzfa zzfaVar, int i4, int i5, int i6, zzagi zzagiVar) {
        zzfaVar.zzF(i5 + 16);
        zzfaVar.zzv((char) 0);
        String zzv = zzfaVar.zzv((char) 0);
        if (zzv != null) {
            zzak zzakVar = new zzak();
            zzakVar.zzG(i6);
            zzakVar.zzS(zzv);
            zzagiVar.zzb = zzakVar.zzY();
        }
    }

    private static boolean zzp(long[] jArr, long j4, long j5, long j6) {
        int length = jArr.length;
        int i4 = length - 1;
        int max = Math.max(0, Math.min(4, i4));
        int max2 = Math.max(0, Math.min(length - 4, i4));
        if (jArr[0] > j5 || j5 >= jArr[max] || jArr[max2] >= j6 || j6 > j4) {
            return false;
        }
        return true;
    }

    @Nullable
    private static byte[] zzq(zzfa zzfaVar, int i4, int i5) {
        int i6 = i4 + 8;
        while (i6 - i4 < i5) {
            zzfaVar.zzF(i6);
            int zze = zzfaVar.zze();
            if (zzfaVar.zze() == 1886547818) {
                return Arrays.copyOfRange(zzfaVar.zzH(), i6, zze + i6);
            }
            i6 += zze;
        }
        return null;
    }
}
