package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaxr extends zzgpm implements zzgqx {
    private static final zzaxr zzb;
    private int zzd;
    private boolean zze;
    private int zzf;

    static {
        zzaxr zzaxrVar = new zzaxr();
        zzb = zzaxrVar;
        zzgpm.zzaU(zzaxr.class, zzaxrVar);
    }

    private zzaxr() {
    }

    public static zzaxq zza() {
        return (zzaxq) zzb.zzaA();
    }

    public static zzaxr zzd() {
        return zzb;
    }

    public static /* synthetic */ void zze(zzaxr zzaxrVar, boolean z3) {
        zzaxrVar.zzd |= 1;
        zzaxrVar.zze = z3;
    }

    public static /* synthetic */ void zzf(zzaxr zzaxrVar, int i4) {
        zzaxrVar.zzd |= 2;
        zzaxrVar.zzf = i4;
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
                    return new zzaxq(null);
                }
                return new zzaxr();
            }
            return zzgpm.zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဋ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
