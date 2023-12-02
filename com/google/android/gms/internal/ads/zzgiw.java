package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgiw extends zzgpm implements zzgqx {
    private static final zzgiw zzb;
    private int zzd;
    private zzgjc zze;
    private zzgoe zzf = zzgoe.zzb;

    static {
        zzgiw zzgiwVar = new zzgiw();
        zzb = zzgiwVar;
        zzgpm.zzaU(zzgiw.class, zzgiwVar);
    }

    private zzgiw() {
    }

    public static zzgiv zzc() {
        return (zzgiv) zzb.zzaA();
    }

    public static zzgiw zze(zzgoe zzgoeVar, zzgoy zzgoyVar) throws zzgpy {
        return (zzgiw) zzgpm.zzaG(zzb, zzgoeVar, zzgoyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzgiw zzgiwVar, zzgjc zzgjcVar) {
        zzgjcVar.getClass();
        zzgiwVar.zze = zzgjcVar;
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
                    return new zzgiv(null);
                }
                return new zzgiw();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }

    public final zzgjc zzf() {
        zzgjc zzgjcVar = this.zze;
        if (zzgjcVar == null) {
            return zzgjc.zze();
        }
        return zzgjcVar;
    }

    public final zzgoe zzg() {
        return this.zzf;
    }
}
