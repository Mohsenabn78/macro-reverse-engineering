package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgjr extends zzgpm implements zzgqx {
    private static final zzgjr zzb;
    private int zzd;
    private zzgoe zze = zzgoe.zzb;

    static {
        zzgjr zzgjrVar = new zzgjr();
        zzb = zzgjrVar;
        zzgpm.zzaU(zzgjr.class, zzgjrVar);
    }

    private zzgjr() {
    }

    public static zzgjq zzc() {
        return (zzgjq) zzb.zzaA();
    }

    public static zzgjr zze(zzgoe zzgoeVar, zzgoy zzgoyVar) throws zzgpy {
        return (zzgjr) zzgpm.zzaG(zzb, zzgoeVar, zzgoyVar);
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
                    return new zzgjq(null);
                }
                return new zzgjr();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzd", "zze"});
        }
        return (byte) 1;
    }

    public final zzgoe zzf() {
        return this.zze;
    }
}
