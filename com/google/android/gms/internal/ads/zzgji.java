package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgji extends zzgpm implements zzgqx {
    private static final zzgji zzb;
    private int zzd;
    private int zze;

    static {
        zzgji zzgjiVar = new zzgji();
        zzb = zzgjiVar;
        zzgpm.zzaU(zzgji.class, zzgjiVar);
    }

    private zzgji() {
    }

    public static zzgjh zzc() {
        return (zzgjh) zzb.zzaA();
    }

    public static zzgji zze(zzgoe zzgoeVar, zzgoy zzgoyVar) throws zzgpy {
        return (zzgji) zzgpm.zzaG(zzb, zzgoeVar, zzgoyVar);
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
                    return new zzgjh(null);
                }
                return new zzgji();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzd", "zze"});
        }
        return (byte) 1;
    }
}
