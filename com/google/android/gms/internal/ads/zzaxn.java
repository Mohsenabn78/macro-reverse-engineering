package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaxn extends zzgpm implements zzgqx {
    private static final zzaxn zzb;
    private int zzd;
    private int zze;
    private zzaxr zzf;
    private zzaxt zzg;

    static {
        zzaxn zzaxnVar = new zzaxn();
        zzb = zzaxnVar;
        zzgpm.zzaU(zzaxn.class, zzaxnVar);
    }

    private zzaxn() {
    }

    public static zzaxm zza() {
        return (zzaxm) zzb.zzaA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzd(zzaxn zzaxnVar, zzaxr zzaxrVar) {
        zzaxrVar.getClass();
        zzaxnVar.zzf = zzaxrVar;
        zzaxnVar.zzd |= 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(zzaxn zzaxnVar, zzaxt zzaxtVar) {
        zzaxtVar.getClass();
        zzaxnVar.zzg = zzaxtVar;
        zzaxnVar.zzd |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzf(zzaxn zzaxnVar, int i4) {
        zzaxnVar.zze = 1;
        zzaxnVar.zzd = 1 | zzaxnVar.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgpm
    protected final Object zzb(int i4, Object obj, Object obj2) {
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
                    return new zzaxm(null);
                }
                return new zzaxn();
            }
            return zzgpm.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzaxp.zza, "zzf", "zzg"});
        }
        return (byte) 1;
    }
}
