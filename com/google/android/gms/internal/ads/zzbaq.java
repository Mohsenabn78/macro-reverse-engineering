package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbaq extends zzgpm implements zzgqx {
    private static final zzbaq zzb;
    private int zzd;
    private int zze = 1000;
    private zzbag zzf;
    private zzazx zzg;

    static {
        zzbaq zzbaqVar = new zzbaq();
        zzb = zzbaqVar;
        zzgpm.zzaU(zzbaq.class, zzbaqVar);
    }

    private zzbaq() {
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
                    return new zzbap(null);
                }
                return new zzbaq();
            }
            return zzgpm.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzaym.zza, "zzf", "zzg"});
        }
        return (byte) 1;
    }
}
