package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrn */
/* loaded from: classes4.dex */
public final class zzrn extends zzahd implements zzaij {
    private static final zzrn zzb;
    private int zzd;
    private int zze;
    private zzrq zzf;
    private zzafy zzg = zzafy.zzb;

    static {
        zzrn zzrnVar = new zzrn();
        zzb = zzrnVar;
        zzahd.zzH(zzrn.class, zzrnVar);
    }

    private zzrn() {
    }

    public static zzrm zzb() {
        return (zzrm) zzb.zzt();
    }

    public static zzrn zzd(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzrn) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    public static /* synthetic */ void zzh(zzrn zzrnVar, zzrq zzrqVar) {
        zzrqVar.getClass();
        zzrnVar.zzf = zzrqVar;
        zzrnVar.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzrq zze() {
        zzrq zzrqVar = this.zzf;
        if (zzrqVar == null) {
            return zzrq.zze();
        }
        return zzrqVar;
    }

    public final zzafy zzf() {
        return this.zzg;
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
                    return new zzrm(null);
                }
                return new zzrn();
            }
            return zzahd.zzE(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }
}
