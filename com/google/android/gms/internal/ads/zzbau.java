package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbau extends zzgpm implements zzgqx {
    private static final zzbau zzb;
    private int zzd;
    private boolean zze;
    private int zzf;

    static {
        zzbau zzbauVar = new zzbau();
        zzb = zzbauVar;
        zzgpm.zzaU(zzbau.class, zzbauVar);
    }

    private zzbau() {
    }

    public static zzbat zza() {
        return (zzbat) zzb.zzaA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzd(zzbau zzbauVar, boolean z3) {
        zzbauVar.zzd |= 1;
        zzbauVar.zze = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(zzbau zzbauVar, int i4) {
        zzbauVar.zzd |= 2;
        zzbauVar.zzf = i4;
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
                    return new zzbat(null);
                }
                return new zzbau();
            }
            return zzgpm.zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002င\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }

    public final boolean zzf() {
        return this.zze;
    }
}
