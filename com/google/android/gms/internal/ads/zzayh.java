package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzayh extends zzgpm implements zzgqx {
    private static final zzayh zzb;
    private int zzd;
    private zzazx zzf;
    private int zzg;
    private zzazz zzh;
    private int zzi;
    private String zze = "";
    private int zzj = 1000;
    private int zzk = 1000;
    private int zzl = 1000;

    static {
        zzayh zzayhVar = new zzayh();
        zzb = zzayhVar;
        zzgpm.zzaU(zzayh.class, zzayhVar);
    }

    private zzayh() {
    }

    public static zzayh zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zzayh zzayhVar, String str) {
        zzayhVar.zzd |= 1;
        zzayhVar.zze = str;
    }

    public static /* synthetic */ void zze(zzayh zzayhVar, zzazz zzazzVar) {
        zzazzVar.getClass();
        zzayhVar.zzh = zzazzVar;
        zzayhVar.zzd |= 8;
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
                    return new zzayg(null);
                }
                return new zzayh();
            }
            zzgpq zzgpqVar = zzaym.zza;
            return zzgpm.zzaR(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004ဉ\u0003\u0005င\u0004\u0006᠌\u0005\u0007᠌\u0006\b᠌\u0007", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzgpqVar, "zzk", zzgpqVar, "zzl", zzgpqVar});
        }
        return (byte) 1;
    }
}
