package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzglz extends zzgpm implements zzgqx {
    private static final zzglz zzb;
    private int zzd;

    static {
        zzglz zzglzVar = new zzglz();
        zzb = zzglzVar;
        zzgpm.zzaU(zzglz.class, zzglzVar);
    }

    private zzglz() {
    }

    public static zzglz zzc() {
        return zzb;
    }

    public static zzglz zzd(zzgoe zzgoeVar, zzgoy zzgoyVar) throws zzgpy {
        return (zzglz) zzgpm.zzaG(zzb, zzgoeVar, zzgoyVar);
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
                    return new zzgly(null);
                }
                return new zzglz();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzd"});
        }
        return (byte) 1;
    }
}
