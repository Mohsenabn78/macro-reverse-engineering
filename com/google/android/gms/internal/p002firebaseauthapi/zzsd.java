package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsd  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzsd extends zzahd implements zzaij {
    private static final zzsd zzb;
    private int zzd;
    private int zze;
    private zzsj zzf;
    private zzafy zzg = zzafy.zzb;

    static {
        zzsd zzsdVar = new zzsd();
        zzb = zzsdVar;
        zzahd.zzH(zzsd.class, zzsdVar);
    }

    private zzsd() {
    }

    public static zzsc zzb() {
        return (zzsc) zzb.zzt();
    }

    public static zzsd zzd() {
        return zzb;
    }

    public static zzsd zze(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzsd) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzsd zzsdVar, zzsj zzsjVar) {
        zzsjVar.getClass();
        zzsdVar.zzf = zzsjVar;
        zzsdVar.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzsj zzf() {
        zzsj zzsjVar = this.zzf;
        if (zzsjVar == null) {
            return zzsj.zzd();
        }
        return zzsjVar;
    }

    public final zzafy zzg() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
                    return new zzsc(null);
                }
                return new zzsd();
            }
            return zzahd.zzE(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }
}
