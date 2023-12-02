package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgli extends zzgpm implements zzgqx {
    private static final zzgli zzb;
    private String zzd = "";

    static {
        zzgli zzgliVar = new zzgli();
        zzb = zzgliVar;
        zzgpm.zzaU(zzgli.class, zzgliVar);
    }

    private zzgli() {
    }

    public static zzgli zzc() {
        return zzb;
    }

    public static zzgli zzd(zzgoe zzgoeVar, zzgoy zzgoyVar) throws zzgpy {
        return (zzgli) zzgpm.zzaG(zzb, zzgoeVar, zzgoyVar);
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
                    return new zzglh(null);
                }
                return new zzgli();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzd"});
        }
        return (byte) 1;
    }

    public final String zze() {
        return this.zzd;
    }
}
