package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzglf extends zzgpm implements zzgqx {
    private static final zzglf zzb;
    private int zzd;
    private zzgli zze;

    static {
        zzglf zzglfVar = new zzglf();
        zzb = zzglfVar;
        zzgpm.zzaU(zzglf.class, zzglfVar);
    }

    private zzglf() {
    }

    public static zzgle zzc() {
        return (zzgle) zzb.zzaA();
    }

    public static zzglf zze(zzgoe zzgoeVar, zzgoy zzgoyVar) throws zzgpy {
        return (zzglf) zzgpm.zzaG(zzb, zzgoeVar, zzgoyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzglf zzglfVar, zzgli zzgliVar) {
        zzgliVar.getClass();
        zzglfVar.zze = zzgliVar;
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
                    return new zzgle(null);
                }
                return new zzglf();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzd", "zze"});
        }
        return (byte) 1;
    }

    public final zzgli zzf() {
        zzgli zzgliVar = this.zze;
        if (zzgliVar == null) {
            return zzgli.zzc();
        }
        return zzgliVar;
    }
}
