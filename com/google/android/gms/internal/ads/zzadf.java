package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzadf extends zzade {
    private final zzfa zzb;
    private final zzfa zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    public zzadf(zzabz zzabzVar) {
        super(zzabzVar);
        this.zzb = new zzfa(zzfu.zza);
        this.zzc = new zzfa(4);
    }

    @Override // com.google.android.gms.internal.ads.zzade
    protected final boolean zza(zzfa zzfaVar) throws zzadd {
        int zzk = zzfaVar.zzk();
        int i4 = zzk >> 4;
        int i5 = zzk & 15;
        if (i5 == 7) {
            this.zzg = i4;
            if (i4 != 5) {
                return true;
            }
            return false;
        }
        throw new zzadd("Video format not supported: " + i5);
    }

    @Override // com.google.android.gms.internal.ads.zzade
    protected final boolean zzb(zzfa zzfaVar, long j4) throws zzcd {
        int i4;
        int zzk = zzfaVar.zzk();
        long zzf = zzfaVar.zzf();
        if (zzk == 0) {
            if (!this.zze) {
                zzfa zzfaVar2 = new zzfa(new byte[zzfaVar.zza()]);
                zzfaVar.zzB(zzfaVar2.zzH(), 0, zzfaVar.zza());
                zzaab zza = zzaab.zza(zzfaVar2);
                this.zzd = zza.zzb;
                zzak zzakVar = new zzak();
                zzakVar.zzS("video/avc");
                zzakVar.zzx(zza.zzi);
                zzakVar.zzX(zza.zzc);
                zzakVar.zzF(zza.zzd);
                zzakVar.zzP(zza.zzh);
                zzakVar.zzI(zza.zza);
                this.zza.zzk(zzakVar.zzY());
                this.zze = true;
                return false;
            }
        } else if (zzk == 1 && this.zze) {
            if (this.zzg == 1) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            if (!this.zzf && i4 == 0) {
                return false;
            }
            byte[] zzH = this.zzc.zzH();
            zzH[0] = 0;
            zzH[1] = 0;
            zzH[2] = 0;
            int i5 = 4 - this.zzd;
            int i6 = 0;
            while (zzfaVar.zza() > 0) {
                zzfaVar.zzB(this.zzc.zzH(), i5, this.zzd);
                this.zzc.zzF(0);
                int zzn = this.zzc.zzn();
                this.zzb.zzF(0);
                this.zza.zzq(this.zzb, 4);
                this.zza.zzq(zzfaVar, zzn);
                i6 = i6 + 4 + zzn;
            }
            this.zza.zzs(j4 + (zzf * 1000), i4, i6, 0, null);
            this.zzf = true;
            return true;
        }
        return false;
    }
}
