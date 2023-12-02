package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsg */
/* loaded from: classes4.dex */
public final class zzsg extends zzahd implements zzaij {
    private static final zzsg zzb;
    private int zzd;
    private zzsj zze;
    private int zzf;
    private int zzg;

    static {
        zzsg zzsgVar = new zzsg();
        zzb = zzsgVar;
        zzahd.zzH(zzsg.class, zzsgVar);
    }

    private zzsg() {
    }

    public static zzsf zzc() {
        return (zzsf) zzb.zzt();
    }

    public static zzsg zze() {
        return zzb;
    }

    public static zzsg zzf(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzsg) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    public static /* synthetic */ void zzh(zzsg zzsgVar, zzsj zzsjVar) {
        zzsjVar.getClass();
        zzsgVar.zze = zzsjVar;
        zzsgVar.zzd |= 1;
    }

    public final int zza() {
        return this.zzf;
    }

    public final int zzb() {
        return this.zzg;
    }

    public final zzsj zzg() {
        zzsj zzsjVar = this.zze;
        if (zzsjVar == null) {
            return zzsj.zzd();
        }
        return zzsjVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahd
    public final Object zzj(int i4, Object obj, Object obj2) {
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
                    return new zzsf(null);
                }
                return new zzsg();
            }
            return zzahd.zzE(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }
}
