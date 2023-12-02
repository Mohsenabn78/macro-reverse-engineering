package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgiq extends zzgpm implements zzgqx {
    private static final zzgiq zzb;
    private zzgit zzd;
    private int zze;

    static {
        zzgiq zzgiqVar = new zzgiq();
        zzb = zzgiqVar;
        zzgpm.zzaU(zzgiq.class, zzgiqVar);
    }

    private zzgiq() {
    }

    public static zzgip zzc() {
        return (zzgip) zzb.zzaA();
    }

    public static zzgiq zze() {
        return zzb;
    }

    public static zzgiq zzf(zzgoe zzgoeVar, zzgoy zzgoyVar) throws zzgpy {
        return (zzgiq) zzgpm.zzaG(zzb, zzgoeVar, zzgoyVar);
    }

    public static /* synthetic */ void zzh(zzgiq zzgiqVar, zzgit zzgitVar) {
        zzgitVar.getClass();
        zzgiqVar.zzd = zzgitVar;
    }

    public final int zza() {
        return this.zze;
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
                    return new zzgip(null);
                }
                return new zzgiq();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzd", "zze"});
        }
        return (byte) 1;
    }

    public final zzgit zzg() {
        zzgit zzgitVar = this.zzd;
        if (zzgitVar == null) {
            return zzgit.zze();
        }
        return zzgitVar;
    }
}
