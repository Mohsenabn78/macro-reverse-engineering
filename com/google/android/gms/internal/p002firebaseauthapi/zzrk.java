package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrk  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzrk extends zzahd implements zzaij {
    private static final zzrk zzb;
    private int zzd;
    private zzrt zze;
    private zzre zzf;
    private int zzg;

    static {
        zzrk zzrkVar = new zzrk();
        zzb = zzrkVar;
        zzahd.zzH(zzrk.class, zzrkVar);
    }

    private zzrk() {
    }

    public static zzrj zzb() {
        return (zzrj) zzb.zzt();
    }

    public static zzrk zzd() {
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzf(zzrk zzrkVar, zzrt zzrtVar) {
        zzrtVar.getClass();
        zzrkVar.zze = zzrtVar;
        zzrkVar.zzd |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(zzrk zzrkVar, zzre zzreVar) {
        zzreVar.getClass();
        zzrkVar.zzf = zzreVar;
        zzrkVar.zzd |= 2;
    }

    public final zzre zza() {
        zzre zzreVar = this.zzf;
        if (zzreVar == null) {
            return zzre.zzc();
        }
        return zzreVar;
    }

    public final zzrt zze() {
        zzrt zzrtVar = this.zze;
        if (zzrtVar == null) {
            return zzrt.zzc();
        }
        return zzrtVar;
    }

    public final int zzh() {
        int i4 = this.zzg;
        int i5 = 2;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        i5 = 0;
                    } else {
                        i5 = 5;
                    }
                } else {
                    i5 = 4;
                }
            } else {
                i5 = 3;
            }
        }
        if (i5 == 0) {
            return 1;
        }
        return i5;
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
                    return new zzrj(null);
                }
                return new zzrk();
            }
            return zzahd.zzE(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\f", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }
}
