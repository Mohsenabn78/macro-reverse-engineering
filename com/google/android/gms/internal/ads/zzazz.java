package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzazz extends zzgpm implements zzgqx {
    private static final zzazz zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzazz zzazzVar = new zzazz();
        zzb = zzazzVar;
        zzgpm.zzaU(zzazz.class, zzazzVar);
    }

    private zzazz() {
    }

    public static zzazy zza() {
        return (zzazy) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzazz zzazzVar, int i4) {
        zzazzVar.zzd |= 1;
        zzazzVar.zze = i4;
    }

    public static /* synthetic */ void zze(zzazz zzazzVar, int i4) {
        zzazzVar.zzd |= 2;
        zzazzVar.zzf = i4;
    }

    public static /* synthetic */ void zzf(zzazz zzazzVar, int i4) {
        zzazzVar.zzd |= 4;
        zzazzVar.zzg = i4;
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
                    return new zzazy(null);
                }
                return new zzazz();
            }
            return zzgpm.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }
}
