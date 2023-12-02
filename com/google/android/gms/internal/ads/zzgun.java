package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgun extends zzgpm implements zzgqx {
    private static final zzgun zzb;
    private int zzd;
    private int zze;
    private String zzf = "";
    private zzgoe zzg;
    private zzgoe zzh;

    static {
        zzgun zzgunVar = new zzgun();
        zzb = zzgunVar;
        zzgpm.zzaU(zzgun.class, zzgunVar);
    }

    private zzgun() {
        zzgoe zzgoeVar = zzgoe.zzb;
        this.zzg = zzgoeVar;
        this.zzh = zzgoeVar;
    }

    public static zzgul zza() {
        return (zzgul) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzgun zzgunVar, String str) {
        zzgunVar.zzd |= 2;
        zzgunVar.zzf = "image/png";
    }

    public static /* synthetic */ void zze(zzgun zzgunVar, zzgoe zzgoeVar) {
        zzgoeVar.getClass();
        zzgunVar.zzd |= 4;
        zzgunVar.zzg = zzgoeVar;
    }

    public static /* synthetic */ void zzf(zzgun zzgunVar, int i4) {
        zzgunVar.zze = 1;
        zzgunVar.zzd = 1 | zzgunVar.zzd;
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
                    return new zzgul(null);
                }
                return new zzgun();
            }
            return zzgpm.zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzd", "zze", zzgum.zza, "zzf", "zzg", "zzh"});
        }
        return (byte) 1;
    }
}
