package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgih extends zzgpm implements zzgqx {
    private static final zzgih zzb;
    private int zzd;
    private zzgin zze;
    private zzgjz zzf;

    static {
        zzgih zzgihVar = new zzgih();
        zzb = zzgihVar;
        zzgpm.zzaU(zzgih.class, zzgihVar);
    }

    private zzgih() {
    }

    public static zzgig zzc() {
        return (zzgig) zzb.zzaA();
    }

    public static zzgih zze(zzgoe zzgoeVar, zzgoy zzgoyVar) throws zzgpy {
        return (zzgih) zzgpm.zzaG(zzb, zzgoeVar, zzgoyVar);
    }

    public static /* synthetic */ void zzi(zzgih zzgihVar, zzgin zzginVar) {
        zzginVar.getClass();
        zzgihVar.zze = zzginVar;
    }

    public static /* synthetic */ void zzj(zzgih zzgihVar, zzgjz zzgjzVar) {
        zzgjzVar.getClass();
        zzgihVar.zzf = zzgjzVar;
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
                    return new zzgig(null);
                }
                return new zzgih();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }

    public final zzgin zzf() {
        zzgin zzginVar = this.zze;
        if (zzginVar == null) {
            return zzgin.zze();
        }
        return zzginVar;
    }

    public final zzgjz zzg() {
        zzgjz zzgjzVar = this.zzf;
        if (zzgjzVar == null) {
            return zzgjz.zze();
        }
        return zzgjzVar;
    }
}
