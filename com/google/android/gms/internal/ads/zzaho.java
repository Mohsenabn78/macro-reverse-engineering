package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzaho {
    public int zza;
    public long zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public final int[] zzf = new int[255];
    private final zzfa zzg = new zzfa(255);

    public final void zza() {
        this.zza = 0;
        this.zzb = 0L;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = 0;
    }

    public final boolean zzb(zzaax zzaaxVar, boolean z3) throws IOException {
        zza();
        this.zzg.zzC(27);
        if (zzaba.zzc(zzaaxVar, this.zzg.zzH(), 0, 27, z3) && this.zzg.zzs() == 1332176723) {
            if (this.zzg.zzk() != 0) {
                if (z3) {
                    return false;
                }
                throw zzcd.zzc("unsupported bit stream revision");
            }
            this.zza = this.zzg.zzk();
            this.zzb = this.zzg.zzp();
            this.zzg.zzq();
            this.zzg.zzq();
            this.zzg.zzq();
            int zzk = this.zzg.zzk();
            this.zzc = zzk;
            this.zzd = zzk + 27;
            this.zzg.zzC(zzk);
            if (zzaba.zzc(zzaaxVar, this.zzg.zzH(), 0, this.zzc, z3)) {
                for (int i4 = 0; i4 < this.zzc; i4++) {
                    this.zzf[i4] = this.zzg.zzk();
                    this.zze += this.zzf[i4];
                }
                return true;
            }
        }
        return false;
    }

    public final boolean zzc(zzaax zzaaxVar, long j4) throws IOException {
        boolean z3;
        int i4;
        if (zzaaxVar.zzf() == zzaaxVar.zze()) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzd(z3);
        this.zzg.zzC(4);
        while (true) {
            i4 = (j4 > (-1L) ? 1 : (j4 == (-1L) ? 0 : -1));
            if ((i4 == 0 || zzaaxVar.zzf() + 4 < j4) && zzaba.zzc(zzaaxVar, this.zzg.zzH(), 0, 4, true)) {
                this.zzg.zzF(0);
                if (this.zzg.zzs() != 1332176723) {
                    ((zzaam) zzaaxVar).zzo(1, false);
                } else {
                    zzaaxVar.zzj();
                    return true;
                }
            }
        }
        do {
            if (i4 != 0 && zzaaxVar.zzf() >= j4) {
                break;
            }
        } while (zzaaxVar.zzc(1) != -1);
        return false;
    }
}
