package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@Deprecated
/* loaded from: classes4.dex */
public final class zzglt extends zzgpm implements zzgqx {
    private static final zzglt zzb;
    private String zzd = "";
    private zzgpv zze = zzgpm.zzaN();

    static {
        zzglt zzgltVar = new zzglt();
        zzb = zzgltVar;
        zzgpm.zzaU(zzglt.class, zzgltVar);
    }

    private zzglt() {
    }

    public static zzglt zzc() {
        return zzb;
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
                    return new zzgls(null);
                }
                return new zzglt();
            }
            return zzgpm.zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzd", "zze", zzgks.class});
        }
        return (byte) 1;
    }
}
