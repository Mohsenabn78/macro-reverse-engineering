package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzajn {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzfh zza = new zzfh(0);
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private final zzfa zzb = new zzfa();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajn(int i4) {
    }

    private final int zze(zzaax zzaaxVar) {
        zzfa zzfaVar = this.zzb;
        byte[] bArr = zzfj.zzf;
        int length = bArr.length;
        zzfaVar.zzD(bArr, 0);
        this.zzc = true;
        zzaaxVar.zzj();
        return 0;
    }

    public final int zza(zzaax zzaaxVar, zzabs zzabsVar, int i4) throws IOException {
        if (i4 <= 0) {
            zze(zzaaxVar);
            return 0;
        }
        long j4 = -9223372036854775807L;
        if (!this.zze) {
            long zzd = zzaaxVar.zzd();
            int min = (int) Math.min(112800L, zzd);
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
            int zzd2 = zzfaVar.zzd();
            int i5 = zzd2 - 188;
            while (true) {
                if (i5 < zzc) {
                    break;
                }
                byte[] zzH = zzfaVar.zzH();
                int i6 = -4;
                int i7 = 0;
                while (true) {
                    if (i6 > 4) {
                        break;
                    }
                    int i8 = (i6 * 188) + i5;
                    if (i8 >= zzc && i8 < zzd2 && zzH[i8] == 71) {
                        i7++;
                        if (i7 == 5) {
                            long zzb = zzajx.zzb(zzfaVar, i5, i4);
                            if (zzb != -9223372036854775807L) {
                                j4 = zzb;
                                break;
                            }
                        }
                    } else {
                        i7 = 0;
                    }
                    i6++;
                }
                i5--;
            }
            this.zzg = j4;
            this.zze = true;
            return 0;
        } else if (this.zzg == -9223372036854775807L) {
            zze(zzaaxVar);
            return 0;
        } else if (!this.zzd) {
            int min2 = (int) Math.min(112800L, zzaaxVar.zzd());
            if (zzaaxVar.zzf() != 0) {
                zzabsVar.zza = 0L;
                return 1;
            }
            this.zzb.zzC(min2);
            zzaaxVar.zzj();
            ((zzaam) zzaaxVar).zzm(this.zzb.zzH(), 0, min2, false);
            zzfa zzfaVar2 = this.zzb;
            int zzc2 = zzfaVar2.zzc();
            int zzd3 = zzfaVar2.zzd();
            while (true) {
                if (zzc2 >= zzd3) {
                    break;
                }
                if (zzfaVar2.zzH()[zzc2] == 71) {
                    long zzb2 = zzajx.zzb(zzfaVar2, zzc2, i4);
                    if (zzb2 != -9223372036854775807L) {
                        j4 = zzb2;
                        break;
                    }
                }
                zzc2++;
            }
            this.zzf = j4;
            this.zzd = true;
            return 0;
        } else {
            long j6 = this.zzf;
            if (j6 == -9223372036854775807L) {
                zze(zzaaxVar);
                return 0;
            }
            long zzb3 = this.zza.zzb(this.zzg) - this.zza.zzb(j6);
            this.zzh = zzb3;
            if (zzb3 < 0) {
                zzer.zzf("TsDurationReader", "Invalid duration: " + zzb3 + ". Using TIME_UNSET instead.");
                this.zzh = -9223372036854775807L;
            }
            zze(zzaaxVar);
            return 0;
        }
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzfh zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzc;
    }
}
