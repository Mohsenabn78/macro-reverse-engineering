package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaxl extends zzgpm implements zzgqx {
    private static final zzaxl zzb;
    private int zzd;
    private int zze;
    private zzayb zzg;
    private zzayd zzh;
    private zzayf zzj;
    private zzazp zzk;
    private zzazf zzl;
    private zzayt zzm;
    private zzayv zzn;
    private int zzf = 1000;
    private zzgpv zzi = zzgpm.zzaN();
    private zzgpv zzo = zzgpm.zzaN();

    static {
        zzaxl zzaxlVar = new zzaxl();
        zzb = zzaxlVar;
        zzgpm.zzaU(zzaxl.class, zzaxlVar);
    }

    private zzaxl() {
    }

    public static zzaxl zzc() {
        return zzb;
    }

    public static /* synthetic */ void zze(zzaxl zzaxlVar, zzaxj zzaxjVar) {
        zzaxlVar.zze = zzaxjVar.zza();
        zzaxlVar.zzd |= 1;
    }

    public static /* synthetic */ void zzf(zzaxl zzaxlVar, zzayd zzaydVar) {
        zzaydVar.getClass();
        zzaxlVar.zzh = zzaydVar;
        zzaxlVar.zzd |= 8;
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
                    return new zzaxk(null);
                }
                return new zzaxl();
            }
            return zzgpm.zzaR(zzb, "\u0001\u000b\u0000\u0001\u0007\u0011\u000b\u0000\u0002\u0000\u0007᠌\u0000\b᠌\u0001\tဉ\u0002\nဉ\u0003\u000b\u001b\fဉ\u0004\rဉ\u0005\u000eဉ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011\u001b", new Object[]{"zzd", "zze", zzaxi.zza, "zzf", zzaym.zza, "zzg", "zzh", "zzi", zzaxz.class, "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", zzbab.class});
        }
        return (byte) 1;
    }

    public final zzayd zzd() {
        zzayd zzaydVar = this.zzh;
        if (zzaydVar == null) {
            return zzayd.zzc();
        }
        return zzaydVar;
    }
}
