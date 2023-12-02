package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzapa extends zzgpm implements zzgqx {
    private static final zzapa zzb;
    private int zzd;
    private zzgpv zze = zzgpm.zzaN();
    private zzgoe zzf = zzgoe.zzb;
    private int zzg = 1;
    private int zzh = 1;

    static {
        zzapa zzapaVar = new zzapa();
        zzb = zzapaVar;
        zzgpm.zzaU(zzapa.class, zzapaVar);
    }

    private zzapa() {
    }

    public static zzaoz zza() {
        return (zzaoz) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzapa zzapaVar, zzgoe zzgoeVar) {
        zzgpv zzgpvVar = zzapaVar.zze;
        if (!zzgpvVar.zzc()) {
            zzapaVar.zze = zzgpm.zzaO(zzgpvVar);
        }
        zzapaVar.zze.add(zzgoeVar);
    }

    public static /* synthetic */ void zze(zzapa zzapaVar, zzgoe zzgoeVar) {
        zzapaVar.zzd |= 1;
        zzapaVar.zzf = zzgoeVar;
    }

    public static /* synthetic */ void zzf(zzapa zzapaVar, int i4) {
        zzapaVar.zzh = 4;
        zzapaVar.zzd = 4 | zzapaVar.zzd;
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
                    return new zzaoz(null);
                }
                return new zzapa();
            }
            return zzgpm.zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003᠌\u0001\u0004᠌\u0002", new Object[]{"zzd", "zze", "zzf", "zzg", zzaou.zza, "zzh", zzaos.zza});
        }
        return (byte) 1;
    }
}
