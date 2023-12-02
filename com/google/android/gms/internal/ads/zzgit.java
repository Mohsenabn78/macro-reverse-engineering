package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgit extends zzgpm implements zzgqx {
    private static final zzgit zzb;
    private int zzd;

    static {
        zzgit zzgitVar = new zzgit();
        zzb = zzgitVar;
        zzgpm.zzaU(zzgit.class, zzgitVar);
    }

    private zzgit() {
    }

    public static zzgis zzc() {
        return (zzgis) zzb.zzaA();
    }

    public static zzgit zze() {
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
                    return new zzgis(null);
                }
                return new zzgit();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzd"});
        }
        return (byte) 1;
    }
}
