package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzahb {
    private static final int[] zza = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean zza(zzaax zzaaxVar) throws IOException {
        return zzc(zzaaxVar, true, false);
    }

    public static boolean zzb(zzaax zzaaxVar, boolean z3) throws IOException {
        return zzc(zzaaxVar, false, false);
    }

    private static boolean zzc(zzaax zzaaxVar, boolean z3, boolean z4) throws IOException {
        boolean z5;
        long j4;
        int i4;
        long zzd = zzaaxVar.zzd();
        long j5 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        long j6 = -1;
        int i5 = (zzd > (-1L) ? 1 : (zzd == (-1L) ? 0 : -1));
        if (i5 != 0 && zzd <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j5 = zzd;
        }
        zzfa zzfaVar = new zzfa(64);
        int i6 = (int) j5;
        int i7 = 0;
        boolean z6 = false;
        while (i7 < i6) {
            zzfaVar.zzC(8);
            if (!zzaaxVar.zzm(zzfaVar.zzH(), 0, 8, true)) {
                break;
            }
            long zzs = zzfaVar.zzs();
            int zze = zzfaVar.zze();
            if (zzs == 1) {
                zzaaxVar.zzh(zzfaVar.zzH(), 8, 8);
                i4 = 16;
                zzfaVar.zzE(16);
                j4 = zzfaVar.zzr();
            } else {
                if (zzs == 0) {
                    long zzd2 = zzaaxVar.zzd();
                    if (zzd2 != j6) {
                        zzs = (zzd2 - zzaaxVar.zze()) + 8;
                    }
                }
                j4 = zzs;
                i4 = 8;
            }
            long j7 = i4;
            if (j4 < j7) {
                return false;
            }
            i7 += i4;
            if (zze == 1836019574) {
                i6 += (int) j4;
                if (i5 != 0 && i6 > zzd) {
                    i6 = (int) zzd;
                }
            } else if (zze != 1836019558 && zze != 1836475768) {
                long j8 = zzd;
                if ((i7 + j4) - j7 >= i6) {
                    break;
                }
                int i8 = (int) (j4 - j7);
                i7 += i8;
                if (zze == 1718909296) {
                    if (i8 < 8) {
                        return false;
                    }
                    zzfaVar.zzC(i8);
                    zzaaxVar.zzh(zzfaVar.zzH(), 0, i8);
                    int i9 = i8 >> 2;
                    for (int i10 = 0; i10 < i9; i10++) {
                        if (i10 == 1) {
                            zzfaVar.zzG(4);
                        } else {
                            int zze2 = zzfaVar.zze();
                            if ((zze2 >>> 8) != 3368816) {
                                if (zze2 == 1751476579) {
                                    zze2 = 1751476579;
                                }
                                int[] iArr = zza;
                                for (int i11 = 0; i11 < 29; i11++) {
                                    if (iArr[i11] != zze2) {
                                    }
                                }
                                continue;
                            }
                            z6 = true;
                            break;
                        }
                    }
                    if (!z6) {
                        return false;
                    }
                } else if (i8 != 0) {
                    zzaaxVar.zzg(i8);
                }
                zzd = j8;
            } else {
                z5 = true;
                break;
            }
            j6 = -1;
        }
        z5 = false;
        if (!z6 || z3 != z5) {
            return false;
        }
        return true;
    }
}
