package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfgi extends zzgpm implements zzgqx {
    private static final zzfgi zzb;
    private zzfge zzd;

    static {
        zzfgi zzfgiVar = new zzfgi();
        zzb = zzfgiVar;
        zzgpm.zzaU(zzfgi.class, zzfgiVar);
    }

    private zzfgi() {
    }

    public static zzfgh zza() {
        return (zzfgh) zzb.zzaA();
    }

    public static /* synthetic */ zzfgi zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zzfgi zzfgiVar, zzfge zzfgeVar) {
        zzfgeVar.getClass();
        zzfgiVar.zzd = zzfgeVar;
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
                    return new zzfgh(null);
                }
                return new zzfgi();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0001\u0000\u0000\u0006\u0006\u0001\u0000\u0000\u0000\u0006\t", new Object[]{"zzd"});
        }
        return (byte) 1;
    }
}
