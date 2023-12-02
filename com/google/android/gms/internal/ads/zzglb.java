package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzglb extends zzgpm implements zzgqx {
    private static final zzglb zzb;
    private String zzd = "";
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzglb zzglbVar = new zzglb();
        zzb = zzglbVar;
        zzgpm.zzaU(zzglb.class, zzglbVar);
    }

    private zzglb() {
    }

    public static zzgla zza() {
        return (zzgla) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzglb zzglbVar, String str) {
        str.getClass();
        zzglbVar.zzd = str;
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
                    return new zzgla(null);
                }
                return new zzglb();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }
}
