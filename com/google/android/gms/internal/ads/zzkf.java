package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzkf {
    public zzlc zza;
    public int zzb;
    public boolean zzc;
    public int zzd;
    public boolean zze;
    public int zzf;
    private boolean zzg;

    public zzkf(zzlc zzlcVar) {
        this.zza = zzlcVar;
    }

    public final void zza(int i4) {
        boolean z3 = true;
        if (1 != ((this.zzg ? 1 : 0) | i4)) {
            z3 = false;
        }
        this.zzg = z3;
        this.zzb += i4;
    }

    public final void zzb(int i4) {
        this.zzg = true;
        this.zze = true;
        this.zzf = i4;
    }

    public final void zzc(zzlc zzlcVar) {
        boolean z3;
        boolean z4 = this.zzg;
        if (this.zza != zzlcVar) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.zzg = z4 | z3;
        this.zza = zzlcVar;
    }

    public final void zzd(int i4) {
        boolean z3 = true;
        if (this.zzc && this.zzd != 5) {
            if (i4 != 5) {
                z3 = false;
            }
            zzdy.zzd(z3);
            return;
        }
        this.zzg = true;
        this.zzc = true;
        this.zzd = i4;
    }
}
