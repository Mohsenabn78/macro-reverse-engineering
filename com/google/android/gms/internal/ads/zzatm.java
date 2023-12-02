package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzatm extends zzgpm implements zzgqx {
    private static final zzatm zzb;
    private int zzd;
    private zzatp zze;
    private zzgoe zzf;
    private zzgoe zzg;

    static {
        zzatm zzatmVar = new zzatm();
        zzb = zzatmVar;
        zzgpm.zzaU(zzatm.class, zzatmVar);
    }

    private zzatm() {
        zzgoe zzgoeVar = zzgoe.zzb;
        this.zzf = zzgoeVar;
        this.zzg = zzgoeVar;
    }

    public static zzatm zzc(zzgoe zzgoeVar, zzgoy zzgoyVar) throws zzgpy {
        return (zzatm) zzgpm.zzaG(zzb, zzgoeVar, zzgoyVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
                    return new zzatl(null);
                }
                return new zzatm();
            }
            return zzgpm.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }

    public final zzatp zzd() {
        zzatp zzatpVar = this.zze;
        if (zzatpVar == null) {
            return zzatp.zzg();
        }
        return zzatpVar;
    }

    public final zzgoe zze() {
        return this.zzg;
    }

    public final zzgoe zzf() {
        return this.zzf;
    }
}
