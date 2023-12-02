package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzguz extends zzgpm implements zzgqx {
    private static final zzguz zzb;
    private int zzd;
    private String zze = "";
    private zzgoe zzf = zzgoe.zzb;

    static {
        zzguz zzguzVar = new zzguz();
        zzb = zzguzVar;
        zzgpm.zzaU(zzguz.class, zzguzVar);
    }

    private zzguz() {
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
                    return new zzguy(null);
                }
                return new zzguz();
            }
            return zzgpm.zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ည\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
