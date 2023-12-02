package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzabf {
    public static int zza(zzfa zzfaVar, int i4) {
        switch (i4) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i4 - 2);
            case 6:
                return zzfaVar.zzk() + 1;
            case 7:
                return zzfaVar.zzo() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i4 - 8);
            default:
                return -1;
        }
    }

    public static long zzb(zzaax zzaaxVar, zzabj zzabjVar) throws IOException {
        boolean z3;
        int i4;
        zzaaxVar.zzj();
        zzaam zzaamVar = (zzaam) zzaaxVar;
        zzaamVar.zzl(1, false);
        byte[] bArr = new byte[1];
        zzaamVar.zzm(bArr, 0, 1, false);
        int i5 = bArr[0] & 1;
        if (1 != i5) {
            z3 = false;
        } else {
            z3 = true;
        }
        zzaamVar.zzl(2, false);
        if (1 != i5) {
            i4 = 6;
        } else {
            i4 = 7;
        }
        zzfa zzfaVar = new zzfa(i4);
        zzfaVar.zzE(zzaba.zza(zzaaxVar, zzfaVar.zzH(), 0, i4));
        zzaaxVar.zzj();
        zzabe zzabeVar = new zzabe();
        if (zzd(zzfaVar, zzabjVar, z3, zzabeVar)) {
            return zzabeVar.zza;
        }
        throw zzcd.zza(null, null);
    }

    public static boolean zzc(zzfa zzfaVar, zzabj zzabjVar, int i4, zzabe zzabeVar) {
        boolean z3;
        int zza;
        int zzc = zzfaVar.zzc();
        long zzs = zzfaVar.zzs();
        long j4 = zzs >>> 16;
        if (j4 != i4) {
            return false;
        }
        if ((j4 & 1) == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        long j5 = zzs >> 12;
        long j6 = zzs >> 8;
        long j7 = zzs >> 4;
        long j8 = zzs >> 1;
        long j9 = zzs & 1;
        int i5 = (int) (j7 & 15);
        if (i5 <= 7) {
            if (i5 != zzabjVar.zzg - 1) {
                return false;
            }
        } else if (i5 > 10 || zzabjVar.zzg != 2) {
            return false;
        }
        int i6 = (int) (j8 & 7);
        if ((i6 == 0 || i6 == zzabjVar.zzi) && j9 != 1 && zzd(zzfaVar, zzabjVar, z3, zzabeVar) && (zza = zza(zzfaVar, (int) (j5 & 15))) != -1 && zza <= zzabjVar.zzb) {
            int i7 = zzabjVar.zze;
            int i8 = (int) (j6 & 15);
            if (i8 != 0) {
                if (i8 <= 11) {
                    if (i8 != zzabjVar.zzf) {
                        return false;
                    }
                } else if (i8 == 12) {
                    if (zzfaVar.zzk() * 1000 != i7) {
                        return false;
                    }
                } else if (i8 <= 14) {
                    int zzo = zzfaVar.zzo();
                    if (i8 == 14) {
                        zzo *= 10;
                    }
                    if (zzo != i7) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            if (zzfaVar.zzk() == zzfj.zze(zzfaVar.zzH(), zzc, zzfaVar.zzc() - 1, 0)) {
                return true;
            }
            return false;
        }
        return false;
    }

    private static boolean zzd(zzfa zzfaVar, zzabj zzabjVar, boolean z3, zzabe zzabeVar) {
        try {
            long zzu = zzfaVar.zzu();
            if (!z3) {
                zzu *= zzabjVar.zzb;
            }
            zzabeVar.zza = zzu;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
