package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaaj {
    public static void zza(long j4, zzfa zzfaVar, zzabz[] zzabzVarArr) {
        int i4;
        boolean z3;
        while (true) {
            boolean z4 = true;
            if (zzfaVar.zza() > 1) {
                int zzc = zzc(zzfaVar);
                int zzc2 = zzc(zzfaVar);
                int zzc3 = zzfaVar.zzc() + zzc2;
                if (zzc2 != -1 && zzc2 <= zzfaVar.zza()) {
                    if (zzc == 4 && zzc2 >= 8) {
                        int zzk = zzfaVar.zzk();
                        int zzo = zzfaVar.zzo();
                        if (zzo == 49) {
                            i4 = zzfaVar.zze();
                            zzo = 49;
                        } else {
                            i4 = 0;
                        }
                        int zzk2 = zzfaVar.zzk();
                        if (zzo == 47) {
                            zzfaVar.zzG(1);
                            zzo = 47;
                        }
                        if (zzk == 181 && ((zzo == 49 || zzo == 47) && zzk2 == 3)) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (zzo == 49) {
                            if (i4 != 1195456820) {
                                z4 = false;
                            }
                            z3 &= z4;
                        }
                        if (z3) {
                            zzb(j4, zzfaVar, zzabzVarArr);
                        }
                    }
                } else {
                    zzer.zzf("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                    zzc3 = zzfaVar.zzd();
                }
                zzfaVar.zzF(zzc3);
            } else {
                return;
            }
        }
    }

    public static void zzb(long j4, zzfa zzfaVar, zzabz[] zzabzVarArr) {
        int zzk = zzfaVar.zzk();
        if ((zzk & 64) != 0) {
            int i4 = zzk & 31;
            zzfaVar.zzG(1);
            int zzc = zzfaVar.zzc();
            for (zzabz zzabzVar : zzabzVarArr) {
                int i5 = i4 * 3;
                zzfaVar.zzF(zzc);
                zzabzVar.zzq(zzfaVar, i5);
                if (j4 != -9223372036854775807L) {
                    zzabzVar.zzs(j4, 1, i5, 0, null);
                }
            }
        }
    }

    private static int zzc(zzfa zzfaVar) {
        int i4 = 0;
        while (zzfaVar.zza() != 0) {
            int zzk = zzfaVar.zzk();
            i4 += zzk;
            if (zzk != 255) {
                return i4;
            }
        }
        return -1;
    }
}
