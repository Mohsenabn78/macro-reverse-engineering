package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgie extends zzgpm implements zzgqx {
    private static final zzgie zzb;
    private int zzd;

    static {
        zzgie zzgieVar = new zzgie();
        zzb = zzgieVar;
        zzgpm.zzaU(zzgie.class, zzgieVar);
    }

    private zzgie() {
    }

    public static zzgid zzc() {
        return (zzgid) zzb.zzaA();
    }

    public static zzgie zze() {
        return zzb;
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
                    return new zzgid(null);
                }
                return new zzgie();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzd"});
        }
        return (byte) 1;
    }
}
