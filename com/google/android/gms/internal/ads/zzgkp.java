package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgkp extends zzgpm implements zzgqx {
    private static final zzgkp zzb;
    private String zzd = "";
    private zzgoe zze = zzgoe.zzb;
    private int zzf;

    static {
        zzgkp zzgkpVar = new zzgkp();
        zzb = zzgkpVar;
        zzgpm.zzaU(zzgkp.class, zzgkpVar);
    }

    private zzgkp() {
    }

    public static zzgko zza() {
        return (zzgko) zzb.zzaA();
    }

    public static zzgkp zzd() {
        return zzb;
    }

    public static zzgkp zze(byte[] bArr, zzgoy zzgoyVar) throws zzgpy {
        return (zzgkp) zzgpm.zzaI(zzb, bArr, zzgoyVar);
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
                    return new zzgko(null);
                }
                return new zzgkp();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }

    public final zzglq zzf() {
        zzglq zzb2 = zzglq.zzb(this.zzf);
        if (zzb2 == null) {
            return zzglq.UNRECOGNIZED;
        }
        return zzb2;
    }

    public final zzgoe zzg() {
        return this.zze;
    }

    public final String zzh() {
        return this.zzd;
    }
}
