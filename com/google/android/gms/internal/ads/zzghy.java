package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzghy extends zzgpm implements zzgqx {
    private static final zzghy zzb;
    private int zzd;
    private zzgoe zze = zzgoe.zzb;
    private zzgie zzf;

    static {
        zzghy zzghyVar = new zzghy();
        zzb = zzghyVar;
        zzgpm.zzaU(zzghy.class, zzghyVar);
    }

    private zzghy() {
    }

    public static zzghx zzc() {
        return (zzghx) zzb.zzaA();
    }

    public static zzghy zze(zzgoe zzgoeVar, zzgoy zzgoyVar) throws zzgpy {
        return (zzghy) zzgpm.zzaG(zzb, zzgoeVar, zzgoyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzj(zzghy zzghyVar, zzgie zzgieVar) {
        zzgieVar.getClass();
        zzghyVar.zzf = zzgieVar;
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
                    return new zzghx(null);
                }
                return new zzghy();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }

    public final zzgie zzf() {
        zzgie zzgieVar = this.zzf;
        if (zzgieVar == null) {
            return zzgie.zze();
        }
        return zzgieVar;
    }

    public final zzgoe zzg() {
        return this.zze;
    }
}
