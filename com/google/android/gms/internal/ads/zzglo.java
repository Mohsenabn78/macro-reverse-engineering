package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzglo extends zzgpm implements zzgqx {
    private static final zzglo zzb;
    private String zzd = "";
    private zzgkp zze;

    static {
        zzglo zzgloVar = new zzglo();
        zzb = zzgloVar;
        zzgpm.zzaU(zzglo.class, zzgloVar);
    }

    private zzglo() {
    }

    public static zzglo zzd() {
        return zzb;
    }

    public static zzglo zze(zzgoe zzgoeVar, zzgoy zzgoyVar) throws zzgpy {
        return (zzglo) zzgpm.zzaG(zzb, zzgoeVar, zzgoyVar);
    }

    public final zzgkp zza() {
        zzgkp zzgkpVar = this.zze;
        if (zzgkpVar == null) {
            return zzgkp.zzd();
        }
        return zzgkpVar;
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
                    return new zzgln(null);
                }
                return new zzglo();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzd", "zze"});
        }
        return (byte) 1;
    }

    public final String zzf() {
        return this.zzd;
    }

    public final boolean zzg() {
        if (this.zze != null) {
            return true;
        }
        return false;
    }
}
