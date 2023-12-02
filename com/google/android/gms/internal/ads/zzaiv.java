package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaiv implements zzaij {
    private zzabz zzb;
    private boolean zzc;
    private int zze;
    private int zzf;
    private final zzfa zza = new zzfa(10);
    private long zzd = -9223372036854775807L;

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zza(zzfa zzfaVar) {
        zzdy.zzb(this.zzb);
        if (!this.zzc) {
            return;
        }
        int zza = zzfaVar.zza();
        int i4 = this.zzf;
        if (i4 < 10) {
            int min = Math.min(zza, 10 - i4);
            System.arraycopy(zzfaVar.zzH(), zzfaVar.zzc(), this.zza.zzH(), this.zzf, min);
            if (this.zzf + min == 10) {
                this.zza.zzF(0);
                if (this.zza.zzk() == 73 && this.zza.zzk() == 68 && this.zza.zzk() == 51) {
                    this.zza.zzG(3);
                    this.zze = this.zza.zzj() + 10;
                } else {
                    zzer.zzf("Id3Reader", "Discarding invalid ID3 tag");
                    this.zzc = false;
                    return;
                }
            }
        }
        int min2 = Math.min(zza, this.zze - this.zzf);
        this.zzb.zzq(zzfaVar, min2);
        this.zzf += min2;
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzb(zzaaz zzaazVar, zzajv zzajvVar) {
        zzajvVar.zzc();
        zzabz zzv = zzaazVar.zzv(zzajvVar.zza(), 5);
        this.zzb = zzv;
        zzak zzakVar = new zzak();
        zzakVar.zzH(zzajvVar.zzb());
        zzakVar.zzS("application/id3");
        zzv.zzk(zzakVar.zzY());
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzc() {
        int i4;
        zzdy.zzb(this.zzb);
        if (this.zzc && (i4 = this.zze) != 0 && this.zzf == i4) {
            long j4 = this.zzd;
            if (j4 != -9223372036854775807L) {
                this.zzb.zzs(j4, 1, i4, 0, null);
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
            this.zzd = j4;
        }
        this.zze = 0;
        this.zzf = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zze() {
        this.zzc = false;
        this.zzd = -9223372036854775807L;
    }
}
