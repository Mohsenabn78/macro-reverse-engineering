package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrh */
/* loaded from: classes4.dex */
public final class zzrh extends zzahd implements zzaij {
    private static final zzrh zzb;
    private int zzd;
    private zzrk zze;

    static {
        zzrh zzrhVar = new zzrh();
        zzb = zzrhVar;
        zzahd.zzH(zzrh.class, zzrhVar);
    }

    private zzrh() {
    }

    public static zzrg zza() {
        return (zzrg) zzb.zzt();
    }

    public static zzrh zzc(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzrh) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    public static /* synthetic */ void zze(zzrh zzrhVar, zzrk zzrkVar) {
        zzrkVar.getClass();
        zzrhVar.zze = zzrkVar;
        zzrhVar.zzd |= 1;
    }

    public final zzrk zzd() {
        zzrk zzrkVar = this.zze;
        if (zzrkVar == null) {
            return zzrk.zzd();
        }
        return zzrkVar;
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
                    return new zzrg(null);
                }
                return new zzrh();
            }
            return zzahd.zzE(zzb, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzd", "zze"});
        }
        return (byte) 1;
    }
}
