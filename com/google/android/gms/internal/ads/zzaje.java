package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzaje {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzfh zza = new zzfh(0);
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private final zzfa zzb = new zzfa();

    public static long zzc(zzfa zzfaVar) {
        int zzc = zzfaVar.zzc();
        if (zzfaVar.zza() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        zzfaVar.zzB(bArr, 0, 9);
        zzfaVar.zzF(zzc);
        byte b4 = bArr[0];
        if ((b4 & 196) == 68) {
            byte b5 = bArr[2];
            if ((b5 & 4) == 4) {
                byte b6 = bArr[4];
                if ((b6 & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3) {
                    long j4 = b4;
                    long j5 = b5;
                    return ((j5 & 3) << 13) | ((j4 & 3) << 28) | (((56 & j4) >> 3) << 30) | ((bArr[1] & 255) << 20) | (((j5 & 248) >> 3) << 15) | ((255 & bArr[3]) << 5) | ((b6 & 248) >> 3);
                }
            }
        }
        return -9223372036854775807L;
    }

    private final int zzf(zzaax zzaaxVar) {
        zzfa zzfaVar = this.zzb;
        byte[] bArr = zzfj.zzf;
        int length = bArr.length;
        zzfaVar.zzD(bArr, 0);
        this.zzc = true;
        zzaaxVar.zzj();
        return 0;
    }

    private static final int zzg(byte[] bArr, int i4) {
        return (bArr[i4 + 3] & 255) | ((bArr[i4] & 255) << 24) | ((bArr[i4 + 1] & 255) << 16) | ((bArr[i4 + 2] & 255) << 8);
    }

    public final int zza(zzaax zzaaxVar, zzabs zzabsVar) throws IOException {
        long j4 = -9223372036854775807L;
        if (!this.zze) {
            long zzd = zzaaxVar.zzd();
            int min = (int) Math.min(20000L, zzd);
            long j5 = zzd - min;
            if (zzaaxVar.zzf() != j5) {
                zzabsVar.zza = j5;
                return 1;
            }
            this.zzb.zzC(min);
            zzaaxVar.zzj();
            ((zzaam) zzaaxVar).zzm(this.zzb.zzH(), 0, min, false);
            zzfa zzfaVar = this.zzb;
            int zzc = zzfaVar.zzc();
            int zzd2 = zzfaVar.zzd() - 4;
            while (true) {
                if (zzd2 < zzc) {
                    break;
                }
                if (zzg(zzfaVar.zzH(), zzd2) == 442) {
                    zzfaVar.zzF(zzd2 + 4);
                    long zzc2 = zzc(zzfaVar);
                    if (zzc2 != -9223372036854775807L) {
                        j4 = zzc2;
                        break;
                    }
                }
                zzd2--;
            }
            this.zzg = j4;
            this.zze = true;
            return 0;
        } else if (this.zzg == -9223372036854775807L) {
            zzf(zzaaxVar);
            return 0;
        } else if (!this.zzd) {
            int min2 = (int) Math.min(20000L, zzaaxVar.zzd());
            if (zzaaxVar.zzf() != 0) {
                zzabsVar.zza = 0L;
                return 1;
            }
            this.zzb.zzC(min2);
            zzaaxVar.zzj();
            ((zzaam) zzaaxVar).zzm(this.zzb.zzH(), 0, min2, false);
            zzfa zzfaVar2 = this.zzb;
            int zzc3 = zzfaVar2.zzc();
            int zzd3 = zzfaVar2.zzd();
            while (true) {
                if (zzc3 >= zzd3 - 3) {
                    break;
                }
                if (zzg(zzfaVar2.zzH(), zzc3) == 442) {
                    zzfaVar2.zzF(zzc3 + 4);
                    long zzc4 = zzc(zzfaVar2);
                    if (zzc4 != -9223372036854775807L) {
                        j4 = zzc4;
                        break;
                    }
                }
                zzc3++;
            }
            this.zzf = j4;
            this.zzd = true;
            return 0;
        } else {
            long j6 = this.zzf;
            if (j6 == -9223372036854775807L) {
                zzf(zzaaxVar);
                return 0;
            }
            long zzb = this.zza.zzb(this.zzg) - this.zza.zzb(j6);
            this.zzh = zzb;
            if (zzb < 0) {
                zzer.zzf("PsDurationReader", "Invalid duration: " + zzb + ". Using TIME_UNSET instead.");
                this.zzh = -9223372036854775807L;
            }
            zzf(zzaaxVar);
            return 0;
        }
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzfh zzd() {
        return this.zza;
    }

    public final boolean zze() {
        return this.zzc;
    }
}
