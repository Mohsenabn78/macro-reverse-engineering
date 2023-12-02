package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaor extends zzgpm implements zzgqx {
    private static final zzaor zzb;
    private int zzd;
    private zzgoe zze;
    private zzgoe zzf;
    private zzgoe zzg;
    private zzgoe zzh;

    static {
        zzaor zzaorVar = new zzaor();
        zzb = zzaorVar;
        zzgpm.zzaU(zzaor.class, zzaorVar);
    }

    private zzaor() {
        zzgoe zzgoeVar = zzgoe.zzb;
        this.zze = zzgoeVar;
        this.zzf = zzgoeVar;
        this.zzg = zzgoeVar;
        this.zzh = zzgoeVar;
    }

    public static zzaoq zza() {
        return (zzaoq) zzb.zzaA();
    }

    public static zzaor zzd(byte[] bArr, zzgoy zzgoyVar) throws zzgpy {
        return (zzaor) zzgpm.zzaI(zzb, bArr, zzgoyVar);
    }

    public static /* synthetic */ void zzi(zzaor zzaorVar, zzgoe zzgoeVar) {
        zzaorVar.zzd |= 1;
        zzaorVar.zze = zzgoeVar;
    }

    public static /* synthetic */ void zzj(zzaor zzaorVar, zzgoe zzgoeVar) {
        zzaorVar.zzd |= 2;
        zzaorVar.zzf = zzgoeVar;
    }

    public static /* synthetic */ void zzk(zzaor zzaorVar, zzgoe zzgoeVar) {
        zzaorVar.zzd |= 4;
        zzaorVar.zzg = zzgoeVar;
    }

    public static /* synthetic */ void zzl(zzaor zzaorVar, zzgoe zzgoeVar) {
        zzaorVar.zzd |= 8;
        zzaorVar.zzh = zzgoeVar;
    }

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
                    return new zzaoq(null);
                }
                return new zzaor();
            }
            return zzgpm.zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        return (byte) 1;
    }

    public final zzgoe zze() {
        return this.zze;
    }

    public final zzgoe zzf() {
        return this.zzf;
    }

    public final zzgoe zzg() {
        return this.zzh;
    }

    public final zzgoe zzh() {
        return this.zzg;
    }
}
