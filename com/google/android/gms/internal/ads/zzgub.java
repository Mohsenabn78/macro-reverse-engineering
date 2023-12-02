package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgub extends zzgpm implements zzgqx {
    private static final zzgub zzb;
    private int zzd;
    private zzgua zze;
    private zzgoe zzg;
    private zzgoe zzh;
    private int zzi;
    private byte zzj = 2;
    private zzgpv zzf = zzgpm.zzaN();

    static {
        zzgub zzgubVar = new zzgub();
        zzb = zzgubVar;
        zzgpm.zzaU(zzgub.class, zzgubVar);
    }

    private zzgub() {
        zzgoe zzgoeVar = zzgoe.zzb;
        this.zzg = zzgoeVar;
        this.zzh = zzgoeVar;
    }

    public static zzgty zza() {
        return (zzgty) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzgub zzgubVar, zzgtx zzgtxVar) {
        zzgtxVar.getClass();
        zzgpv zzgpvVar = zzgubVar.zzf;
        if (!zzgpvVar.zzc()) {
            zzgubVar.zzf = zzgpm.zzaO(zzgpvVar);
        }
        zzgubVar.zzf.add(zzgtxVar);
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
                            this.zzj = b4;
                            return null;
                        }
                        return zzb;
                    }
                    return new zzgty(null);
                }
                return new zzgub();
            }
            return zzgpm.zzaR(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zzd", "zze", "zzf", zzgtx.class, "zzg", "zzh", "zzi"});
        }
        return Byte.valueOf(this.zzj);
    }
}
