package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfkc extends zzgpm implements zzgqx {
    private static final zzfkc zzb;
    private int zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private zzfjy zzh;

    static {
        zzfkc zzfkcVar = new zzfkc();
        zzb = zzfkcVar;
        zzgpm.zzaU(zzfkc.class, zzfkcVar);
    }

    private zzfkc() {
    }

    public static zzfka zza() {
        return (zzfka) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzfkc zzfkcVar, String str) {
        str.getClass();
        zzfkcVar.zzd |= 2;
        zzfkcVar.zzf = str;
    }

    public static /* synthetic */ void zze(zzfkc zzfkcVar, zzfjy zzfjyVar) {
        zzfjyVar.getClass();
        zzfkcVar.zzh = zzfjyVar;
        zzfkcVar.zzd |= 8;
    }

    public static /* synthetic */ void zzf(zzfkc zzfkcVar, int i4) {
        zzfkcVar.zze = 1;
        zzfkcVar.zzd = 1 | zzfkcVar.zzd;
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
                    return new zzfka(null);
                }
                return new zzfkc();
            }
            return zzgpm.zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zzd", "zze", zzfkb.zza, "zzf", "zzg", "zzh"});
        }
        return (byte) 1;
    }
}
