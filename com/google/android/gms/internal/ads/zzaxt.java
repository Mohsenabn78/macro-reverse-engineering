package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaxt extends zzgpm implements zzgqx {
    private static final zzaxt zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    static {
        zzaxt zzaxtVar = new zzaxt();
        zzb = zzaxtVar;
        zzgpm.zzaU(zzaxt.class, zzaxtVar);
    }

    private zzaxt() {
    }

    public static zzaxs zza() {
        return (zzaxs) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzaxt zzaxtVar, boolean z3) {
        zzaxtVar.zzd |= 1;
        zzaxtVar.zze = z3;
    }

    public static /* synthetic */ void zze(zzaxt zzaxtVar, boolean z3) {
        zzaxtVar.zzd |= 2;
        zzaxtVar.zzf = z3;
    }

    public static /* synthetic */ void zzf(zzaxt zzaxtVar, int i4) {
        zzaxtVar.zzd |= 4;
        zzaxtVar.zzg = i4;
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
                    return new zzaxs(null);
                }
                return new zzaxt();
            }
            return zzgpm.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဋ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }
}
