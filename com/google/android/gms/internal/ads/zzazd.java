package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzazd extends zzgpm implements zzgqx {
    private static final zzazd zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzazd zzazdVar = new zzazd();
        zzb = zzazdVar;
        zzgpm.zzaU(zzazd.class, zzazdVar);
    }

    private zzazd() {
    }

    public static zzayw zza() {
        return (zzayw) zzb.zzaA();
    }

    public static zzazd zzd() {
        return zzb;
    }

    public static /* synthetic */ void zzi(zzazd zzazdVar, int i4) {
        zzazdVar.zze = i4 - 1;
        zzazdVar.zzd |= 1;
    }

    public static /* synthetic */ void zzj(zzazd zzazdVar, int i4) {
        zzazdVar.zzf = i4 - 1;
        zzazdVar.zzd |= 2;
    }

    @Override // com.google.android.gms.internal.ads.zzgpm
    public final Object zzb(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 != 0) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 4) {
                        if (i5 != 5) {
                            return null;
                        }
                        return zzb;
                    }
                    return new zzayw(null);
                }
                return new zzazd();
            }
            return zzgpm.zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzd", "zze", zzazb.zza, "zzf", zzayy.zza});
        }
        return (byte) 1;
    }

    public final boolean zze() {
        if ((this.zzd & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzf() {
        if ((this.zzd & 1) != 0) {
            return true;
        }
        return false;
    }

    public final int zzg() {
        int zza = zzayz.zza(this.zzf);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzh() {
        int zza = zzazc.zza(this.zze);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }
}
