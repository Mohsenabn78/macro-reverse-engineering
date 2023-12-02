package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaii implements zzaij {
    private final List zza;
    private final zzabz[] zzb;
    private boolean zzc;
    private int zzd;
    private int zze;
    private long zzf = -9223372036854775807L;

    public zzaii(List list) {
        this.zza = list;
        this.zzb = new zzabz[list.size()];
    }

    private final boolean zzf(zzfa zzfaVar, int i4) {
        if (zzfaVar.zza() == 0) {
            return false;
        }
        if (zzfaVar.zzk() != i4) {
            this.zzc = false;
        }
        this.zzd--;
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zza(zzfa zzfaVar) {
        zzabz[] zzabzVarArr;
        if (this.zzc) {
            if (this.zzd == 2 && !zzf(zzfaVar, 32)) {
                return;
            }
            if (this.zzd == 1 && !zzf(zzfaVar, 0)) {
                return;
            }
            int zzc = zzfaVar.zzc();
            int zza = zzfaVar.zza();
            for (zzabz zzabzVar : this.zzb) {
                zzfaVar.zzF(zzc);
                zzabzVar.zzq(zzfaVar, zza);
            }
            this.zze += zza;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzb(zzaaz zzaazVar, zzajv zzajvVar) {
        for (int i4 = 0; i4 < this.zzb.length; i4++) {
            zzajs zzajsVar = (zzajs) this.zza.get(i4);
            zzajvVar.zzc();
            zzabz zzv = zzaazVar.zzv(zzajvVar.zza(), 3);
            zzak zzakVar = new zzak();
            zzakVar.zzH(zzajvVar.zzb());
            zzakVar.zzS("application/dvbsubs");
            zzakVar.zzI(Collections.singletonList(zzajsVar.zzb));
            zzakVar.zzK(zzajsVar.zza);
            zzv.zzk(zzakVar.zzY());
            this.zzb[i4] = zzv;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzc() {
        if (this.zzc) {
            if (this.zzf != -9223372036854775807L) {
                for (zzabz zzabzVar : this.zzb) {
                    zzabzVar.zzs(this.zzf, 1, this.zze, 0, null);
                }
            }
            this.zzc = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzd(long j4, int i4) {
        if ((i4 & 4) == 0) {
            return;
        }
        this.zzc = true;
        if (j4 != -9223372036854775807L) {
            this.zzf = j4;
        }
        this.zze = 0;
        this.zzd = 2;
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zze() {
        this.zzc = false;
        this.zzf = -9223372036854775807L;
    }
}
