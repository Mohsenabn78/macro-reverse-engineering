package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrq  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzrq extends zzahd implements zzaij {
    private static final zzrq zzb;
    private int zzd;
    private int zze;
    private zzrk zzf;
    private zzafy zzg;
    private zzafy zzh;

    static {
        zzrq zzrqVar = new zzrq();
        zzb = zzrqVar;
        zzahd.zzH(zzrq.class, zzrqVar);
    }

    private zzrq() {
        zzafy zzafyVar = zzafy.zzb;
        this.zzg = zzafyVar;
        this.zzh = zzafyVar;
    }

    public static zzrp zzc() {
        return (zzrp) zzb.zzt();
    }

    public static zzrq zze() {
        return zzb;
    }

    public static zzrq zzf(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzrq) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzk(zzrq zzrqVar, zzrk zzrkVar) {
        zzrkVar.getClass();
        zzrqVar.zzf = zzrkVar;
        zzrqVar.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzrk zzb() {
        zzrk zzrkVar = this.zzf;
        if (zzrkVar == null) {
            return zzrk.zzd();
        }
        return zzrkVar;
    }

    public final zzafy zzg() {
        return this.zzg;
    }

    public final zzafy zzh() {
        return this.zzh;
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
                    return new zzrp(null);
                }
                return new zzrq();
            }
            return zzahd.zzE(zzb, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n\u0004\n", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        return (byte) 1;
    }
}
