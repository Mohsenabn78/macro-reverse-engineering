package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgju extends zzgpm implements zzgqx {
    private static final zzgju zzb;

    static {
        zzgju zzgjuVar = new zzgju();
        zzb = zzgjuVar;
        zzgpm.zzaU(zzgju.class, zzgjuVar);
    }

    private zzgju() {
    }

    public static zzgju zzc() {
        return zzb;
    }

    public static zzgju zzd(zzgoe zzgoeVar, zzgoy zzgoyVar) throws zzgpy {
        return (zzgju) zzgpm.zzaG(zzb, zzgoeVar, zzgoyVar);
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
                    return new zzgjt(null);
                }
                return new zzgju();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0000", null);
        }
        return (byte) 1;
    }
}
