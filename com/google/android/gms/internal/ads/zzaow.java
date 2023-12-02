package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaow extends zzgpm implements zzgqx {
    private static final zzaow zzb;
    private int zzd;
    private long zze;
    private String zzf = "";
    private zzgoe zzg = zzgoe.zzb;

    static {
        zzaow zzaowVar = new zzaow();
        zzb = zzaowVar;
        zzgpm.zzaU(zzaow.class, zzaowVar);
    }

    private zzaow() {
    }

    public static zzaow zzd() {
        return zzb;
    }

    public final long zza() {
        return this.zze;
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
                    return new zzaov(null);
                }
                return new zzaow();
            }
            return zzgpm.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }

    public final boolean zze() {
        if ((this.zzd & 1) != 0) {
            return true;
        }
        return false;
    }
}
