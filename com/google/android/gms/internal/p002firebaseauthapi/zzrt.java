package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrt  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzrt extends zzahd implements zzaij {
    private static final zzrt zzb;
    private int zzd;
    private int zze;
    private zzafy zzf = zzafy.zzb;

    static {
        zzrt zzrtVar = new zzrt();
        zzb = zzrtVar;
        zzahd.zzH(zzrt.class, zzrtVar);
    }

    private zzrt() {
    }

    public static zzrs zza() {
        return (zzrs) zzb.zzt();
    }

    public static zzrt zzc() {
        return zzb;
    }

    public final zzafy zzd() {
        return this.zzf;
    }

    public final int zzf() {
        int i4 = this.zzd;
        int i5 = 2;
        if (i4 != 0) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        if (i4 != 5) {
                            i5 = 0;
                        } else {
                            i5 = 7;
                        }
                    } else {
                        i5 = 6;
                    }
                } else {
                    i5 = 5;
                }
            } else {
                i5 = 4;
            }
        }
        if (i5 == 0) {
            return 1;
        }
        return i5;
    }

    public final int zzg() {
        int zzb2 = zzsa.zzb(this.zze);
        if (zzb2 == 0) {
            return 1;
        }
        return zzb2;
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
                    return new zzrs(null);
                }
                return new zzrt();
            }
            return zzahd.zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
