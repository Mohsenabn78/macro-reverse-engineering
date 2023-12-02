package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcjm {
    private zzcgx zza;
    private zzckz zzb;
    private zzfep zzc;
    private zzcll zzd;
    private zzfbj zze;

    private zzcjm() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcjm(zzcjl zzcjlVar) {
    }

    public final zzcgu zza() {
        zzgwm.zzc(this.zza, zzcgx.class);
        zzgwm.zzc(this.zzb, zzckz.class);
        if (this.zzc == null) {
            this.zzc = new zzfep();
        }
        if (this.zzd == null) {
            this.zzd = new zzcll();
        }
        if (this.zze == null) {
            this.zze = new zzfbj();
        }
        return new zzciq(this.zza, this.zzb, this.zzc, this.zzd, this.zze, null);
    }

    public final zzcjm zzb(zzcgx zzcgxVar) {
        this.zza = zzcgxVar;
        return this;
    }

    public final zzcjm zzc(zzckz zzckzVar) {
        this.zzb = zzckzVar;
        return this;
    }
}
