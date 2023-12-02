package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgin extends zzgpm implements zzgqx {
    private static final zzgin zzb;
    private int zzd;
    private zzgit zze;
    private zzgoe zzf = zzgoe.zzb;

    static {
        zzgin zzginVar = new zzgin();
        zzb = zzginVar;
        zzgpm.zzaU(zzgin.class, zzginVar);
    }

    private zzgin() {
    }

    public static zzgim zzc() {
        return (zzgim) zzb.zzaA();
    }

    public static zzgin zze() {
        return zzb;
    }

    public static zzgin zzf(zzgoe zzgoeVar, zzgoy zzgoyVar) throws zzgpy {
        return (zzgin) zzgpm.zzaG(zzb, zzgoeVar, zzgoyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzj(zzgin zzginVar, zzgit zzgitVar) {
        zzgitVar.getClass();
        zzginVar.zze = zzgitVar;
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
                    return new zzgim(null);
                }
                return new zzgin();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }

    public final zzgit zzg() {
        zzgit zzgitVar = this.zze;
        if (zzgitVar == null) {
            return zzgit.zze();
        }
        return zzgitVar;
    }

    public final zzgoe zzh() {
        return this.zzf;
    }
}
