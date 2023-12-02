package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgjz extends zzgpm implements zzgqx {
    private static final zzgjz zzb;
    private int zzd;
    private zzgkf zze;
    private zzgoe zzf = zzgoe.zzb;

    static {
        zzgjz zzgjzVar = new zzgjz();
        zzb = zzgjzVar;
        zzgpm.zzaU(zzgjz.class, zzgjzVar);
    }

    private zzgjz() {
    }

    public static zzgjy zzc() {
        return (zzgjy) zzb.zzaA();
    }

    public static zzgjz zze() {
        return zzb;
    }

    public static zzgjz zzf(zzgoe zzgoeVar, zzgoy zzgoyVar) throws zzgpy {
        return (zzgjz) zzgpm.zzaG(zzb, zzgoeVar, zzgoyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzj(zzgjz zzgjzVar, zzgkf zzgkfVar) {
        zzgkfVar.getClass();
        zzgjzVar.zze = zzgkfVar;
    }

    public final int zza() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
                    return new zzgjy(null);
                }
                return new zzgjz();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }

    public final zzgkf zzg() {
        zzgkf zzgkfVar = this.zze;
        if (zzgkfVar == null) {
            return zzgkf.zze();
        }
        return zzgkfVar;
    }

    public final zzgoe zzh() {
        return this.zzf;
    }
}
