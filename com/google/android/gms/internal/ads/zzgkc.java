package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgkc extends zzgpm implements zzgqx {
    private static final zzgkc zzb;
    private zzgkf zzd;
    private int zze;
    private int zzf;

    static {
        zzgkc zzgkcVar = new zzgkc();
        zzb = zzgkcVar;
        zzgpm.zzaU(zzgkc.class, zzgkcVar);
    }

    private zzgkc() {
    }

    public static zzgkb zzd() {
        return (zzgkb) zzb.zzaA();
    }

    public static zzgkc zzf() {
        return zzb;
    }

    public static zzgkc zzg(zzgoe zzgoeVar, zzgoy zzgoyVar) throws zzgpy {
        return (zzgkc) zzgpm.zzaG(zzb, zzgoeVar, zzgoyVar);
    }

    public static /* synthetic */ void zzi(zzgkc zzgkcVar, zzgkf zzgkfVar) {
        zzgkfVar.getClass();
        zzgkcVar.zzd = zzgkfVar;
    }

    public final int zza() {
        return this.zze;
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
                    return new zzgkb(null);
                }
                return new zzgkc();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }

    public final int zzc() {
        return this.zzf;
    }

    public final zzgkf zzh() {
        zzgkf zzgkfVar = this.zzd;
        if (zzgkfVar == null) {
            return zzgkf.zze();
        }
        return zzgkfVar;
    }
}
