package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgjo extends zzgpm implements zzgqx {
    private static final zzgjo zzb;
    private int zzd;
    private int zze;

    static {
        zzgjo zzgjoVar = new zzgjo();
        zzb = zzgjoVar;
        zzgpm.zzaU(zzgjo.class, zzgjoVar);
    }

    private zzgjo() {
    }

    public static zzgjn zzc() {
        return (zzgjn) zzb.zzaA();
    }

    public static zzgjo zze(zzgoe zzgoeVar, zzgoy zzgoyVar) throws zzgpy {
        return (zzgjo) zzgpm.zzaG(zzb, zzgoeVar, zzgoyVar);
    }

    public final int zza() {
        return this.zzd;
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
                    return new zzgjn(null);
                }
                return new zzgjo();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzd"});
        }
        return (byte) 1;
    }
}
