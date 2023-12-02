package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfjy extends zzgpm implements zzgqx {
    private static final zzgps zzb = new zzfjv();
    private static final zzfjy zzd;
    private int zze;
    private zzgpr zzf = zzgpm.zzaJ();
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";

    static {
        zzfjy zzfjyVar = new zzfjy();
        zzd = zzfjyVar;
        zzgpm.zzaU(zzfjy.class, zzfjyVar);
    }

    private zzfjy() {
    }

    public static zzfjx zza() {
        return (zzfjx) zzd.zzaA();
    }

    public static /* synthetic */ void zzd(zzfjy zzfjyVar, String str) {
        str.getClass();
        zzfjyVar.zze |= 1;
        zzfjyVar.zzg = str;
    }

    public static /* synthetic */ void zze(zzfjy zzfjyVar, int i4) {
        zzgpr zzgprVar = zzfjyVar.zzf;
        if (!zzgprVar.zzc()) {
            zzfjyVar.zzf = zzgpm.zzaK(zzgprVar);
        }
        zzfjyVar.zzf.zzh(2);
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
                        return zzd;
                    }
                    return new zzfjx(null);
                }
                return new zzfjy();
            }
            return zzgpm.zzaR(zzd, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ࠞ\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zze", "zzf", zzfjw.zza, "zzg", "zzh", "zzi"});
        }
        return (byte) 1;
    }
}
