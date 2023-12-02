package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzajg {
    private final zzaij zza;
    private final zzfh zzb;
    private final zzez zzc = new zzez(new byte[64], 64);
    private boolean zzd;
    private boolean zze;
    private boolean zzf;

    public zzajg(zzaij zzaijVar, zzfh zzfhVar) {
        this.zza = zzaijVar;
        this.zzb = zzfhVar;
    }

    public final void zza(zzfa zzfaVar) throws zzcd {
        long j4;
        zzfaVar.zzB(this.zzc.zza, 0, 3);
        this.zzc.zzj(0);
        this.zzc.zzl(8);
        this.zzd = this.zzc.zzn();
        this.zze = this.zzc.zzn();
        this.zzc.zzl(6);
        zzfaVar.zzB(this.zzc.zza, 0, this.zzc.zzd(8));
        this.zzc.zzj(0);
        if (this.zzd) {
            this.zzc.zzl(4);
            long zzd = this.zzc.zzd(3);
            this.zzc.zzl(1);
            int zzd2 = this.zzc.zzd(15) << 15;
            this.zzc.zzl(1);
            long zzd3 = this.zzc.zzd(15);
            this.zzc.zzl(1);
            if (!this.zzf && this.zze) {
                this.zzc.zzl(4);
                this.zzc.zzl(1);
                this.zzc.zzl(1);
                long zzd4 = this.zzc.zzd(15);
                this.zzc.zzl(1);
                this.zzb.zzb((this.zzc.zzd(15) << 15) | (this.zzc.zzd(3) << 30) | zzd4);
                this.zzf = true;
            }
            j4 = this.zzb.zzb((zzd << 30) | zzd2 | zzd3);
        } else {
            j4 = 0;
        }
        this.zza.zzd(j4, 4);
        this.zza.zza(zzfaVar);
        this.zza.zzc();
    }

    public final void zzb() {
        this.zzf = false;
        this.zza.zze();
    }
}
