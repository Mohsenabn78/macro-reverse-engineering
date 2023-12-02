package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgll extends zzgpm implements zzgqx {
    private static final zzgll zzb;
    private int zzd;
    private zzglo zze;

    static {
        zzgll zzgllVar = new zzgll();
        zzb = zzgllVar;
        zzgpm.zzaU(zzgll.class, zzgllVar);
    }

    private zzgll() {
    }

    public static zzglk zzc() {
        return (zzglk) zzb.zzaA();
    }

    public static zzgll zze(zzgoe zzgoeVar, zzgoy zzgoyVar) throws zzgpy {
        return (zzgll) zzgpm.zzaG(zzb, zzgoeVar, zzgoyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzgll zzgllVar, zzglo zzgloVar) {
        zzgloVar.getClass();
        zzgllVar.zze = zzgloVar;
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
                    return new zzglk(null);
                }
                return new zzgll();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzd", "zze"});
        }
        return (byte) 1;
    }

    public final zzglo zzf() {
        zzglo zzgloVar = this.zze;
        if (zzgloVar == null) {
            return zzglo.zzd();
        }
        return zzgloVar;
    }
}
