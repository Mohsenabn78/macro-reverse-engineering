package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgik extends zzgpm implements zzgqx {
    private static final zzgik zzb;
    private zzgiq zzd;
    private zzgkc zze;

    static {
        zzgik zzgikVar = new zzgik();
        zzb = zzgikVar;
        zzgpm.zzaU(zzgik.class, zzgikVar);
    }

    private zzgik() {
    }

    public static zzgij zza() {
        return (zzgij) zzb.zzaA();
    }

    public static zzgik zzd(zzgoe zzgoeVar, zzgoy zzgoyVar) throws zzgpy {
        return (zzgik) zzgpm.zzaG(zzb, zzgoeVar, zzgoyVar);
    }

    public static /* synthetic */ void zzg(zzgik zzgikVar, zzgiq zzgiqVar) {
        zzgiqVar.getClass();
        zzgikVar.zzd = zzgiqVar;
    }

    public static /* synthetic */ void zzh(zzgik zzgikVar, zzgkc zzgkcVar) {
        zzgkcVar.getClass();
        zzgikVar.zze = zzgkcVar;
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
                    return new zzgij(null);
                }
                return new zzgik();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzd", "zze"});
        }
        return (byte) 1;
    }

    public final zzgiq zze() {
        zzgiq zzgiqVar = this.zzd;
        if (zzgiqVar == null) {
            return zzgiq.zze();
        }
        return zzgiqVar;
    }

    public final zzgkc zzf() {
        zzgkc zzgkcVar = this.zze;
        if (zzgkcVar == null) {
            return zzgkc.zzf();
        }
        return zzgkcVar;
    }
}
