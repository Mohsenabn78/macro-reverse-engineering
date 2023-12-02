package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzayd extends zzgpm implements zzgqx {
    private static final zzayd zzb;
    private int zzd;
    private String zze = "";
    private zzgpv zzf = zzgpm.zzaN();
    private int zzg = 1000;
    private int zzh = 1000;
    private int zzi = 1000;

    static {
        zzayd zzaydVar = new zzayd();
        zzb = zzaydVar;
        zzgpm.zzaU(zzayd.class, zzaydVar);
    }

    private zzayd() {
    }

    public static zzayd zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zzayd zzaydVar, String str) {
        str.getClass();
        zzaydVar.zzd |= 1;
        zzaydVar.zze = str;
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
                    return new zzayc(null);
                }
                return new zzayd();
            }
            zzgpq zzgpqVar = zzaym.zza;
            return zzgpm.zzaR(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003᠌\u0001\u0004᠌\u0002\u0005᠌\u0003", new Object[]{"zzd", "zze", "zzf", zzaxz.class, "zzg", zzgpqVar, "zzh", zzgpqVar, "zzi", zzgpqVar});
        }
        return (byte) 1;
    }
}
