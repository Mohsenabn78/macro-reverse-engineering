package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzguf extends zzgpm implements zzgqx {
    private static final zzguf zzb;
    private int zzd;
    private zzgue zze;
    private zzgoe zzg;
    private zzgoe zzh;
    private int zzi;
    private zzgoe zzj;
    private byte zzk = 2;
    private zzgpv zzf = zzgpm.zzaN();

    static {
        zzguf zzgufVar = new zzguf();
        zzb = zzgufVar;
        zzgpm.zzaU(zzguf.class, zzgufVar);
    }

    private zzguf() {
        zzgoe zzgoeVar = zzgoe.zzb;
        this.zzg = zzgoeVar;
        this.zzh = zzgoeVar;
        this.zzj = zzgoeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgpm
    public final Object zzb(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 != 0) {
            byte b4 = 1;
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 4) {
                        if (i5 != 5) {
                            if (obj == null) {
                                b4 = 0;
                            }
                            this.zzk = b4;
                            return null;
                        }
                        return zzb;
                    }
                    return new zzguc(null);
                }
                return new zzguf();
            }
            return zzgpm.zzaR(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zzd", "zze", "zzf", zzgtx.class, "zzg", "zzh", "zzi", "zzj"});
        }
        return Byte.valueOf(this.zzk);
    }
}
