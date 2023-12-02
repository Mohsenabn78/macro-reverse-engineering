package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgtx extends zzgpm implements zzgqx {
    private static final zzgtx zzb;
    private int zzd;
    private zzgoe zze;
    private zzgoe zzf;
    private byte zzg = 2;

    static {
        zzgtx zzgtxVar = new zzgtx();
        zzb = zzgtxVar;
        zzgpm.zzaU(zzgtx.class, zzgtxVar);
    }

    private zzgtx() {
        zzgoe zzgoeVar = zzgoe.zzb;
        this.zze = zzgoeVar;
        this.zzf = zzgoeVar;
    }

    public static zzgtw zza() {
        return (zzgtw) zzb.zzaA();
    }

    public static /* synthetic */ zzgtx zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zzgtx zzgtxVar, zzgoe zzgoeVar) {
        zzgtxVar.zzd |= 1;
        zzgtxVar.zze = zzgoeVar;
    }

    public static /* synthetic */ void zze(zzgtx zzgtxVar, zzgoe zzgoeVar) {
        zzgtxVar.zzd |= 2;
        zzgtxVar.zzf = zzgoeVar;
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
                            this.zzg = b4;
                            return null;
                        }
                        return zzb;
                    }
                    return new zzgtw(null);
                }
                return new zzgtx();
            }
            return zzgpm.zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        return Byte.valueOf(this.zzg);
    }
}
