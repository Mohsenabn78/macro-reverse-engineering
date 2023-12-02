package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpg */
/* loaded from: classes4.dex */
public final class zzpg extends zzahd implements zzaij {
    private static final zzpg zzb;
    private int zzd;
    private int zze;
    private zzpm zzf;
    private zzsd zzg;

    static {
        zzpg zzpgVar = new zzpg();
        zzb = zzpgVar;
        zzahd.zzH(zzpg.class, zzpgVar);
    }

    private zzpg() {
    }

    public static zzpf zzb() {
        return (zzpf) zzb.zzt();
    }

    public static zzpg zzd(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzpg) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    public static /* synthetic */ void zzh(zzpg zzpgVar, zzpm zzpmVar) {
        zzpmVar.getClass();
        zzpgVar.zzf = zzpmVar;
        zzpgVar.zzd |= 1;
    }

    public static /* synthetic */ void zzi(zzpg zzpgVar, zzsd zzsdVar) {
        zzsdVar.getClass();
        zzpgVar.zzg = zzsdVar;
        zzpgVar.zzd |= 2;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzpm zze() {
        zzpm zzpmVar = this.zzf;
        if (zzpmVar == null) {
            return zzpm.zzd();
        }
        return zzpmVar;
    }

    public final zzsd zzf() {
        zzsd zzsdVar = this.zzg;
        if (zzsdVar == null) {
            return zzsd.zzd();
        }
        return zzsdVar;
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
                    return new zzpf(null);
                }
                return new zzpg();
            }
            return zzahd.zzE(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }
}
