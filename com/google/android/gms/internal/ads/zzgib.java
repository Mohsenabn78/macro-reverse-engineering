package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgib extends zzgpm implements zzgqx {
    private static final zzgib zzb;
    private int zzd;
    private zzgie zze;

    static {
        zzgib zzgibVar = new zzgib();
        zzb = zzgibVar;
        zzgpm.zzaU(zzgib.class, zzgibVar);
    }

    private zzgib() {
    }

    public static zzgia zzc() {
        return (zzgia) zzb.zzaA();
    }

    public static zzgib zze(zzgoe zzgoeVar, zzgoy zzgoyVar) throws zzgpy {
        return (zzgib) zzgpm.zzaG(zzb, zzgoeVar, zzgoyVar);
    }

    public static /* synthetic */ void zzh(zzgib zzgibVar, zzgie zzgieVar) {
        zzgieVar.getClass();
        zzgibVar.zze = zzgieVar;
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
                    return new zzgia(null);
                }
                return new zzgib();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzd", "zze"});
        }
        return (byte) 1;
    }

    public final zzgie zzf() {
        zzgie zzgieVar = this.zze;
        if (zzgieVar == null) {
            return zzgie.zze();
        }
        return zzgieVar;
    }
}
