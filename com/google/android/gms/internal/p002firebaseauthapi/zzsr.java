package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsr  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzsr extends zzahd implements zzaij {
    private static final zzsr zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzsr zzsrVar = new zzsr();
        zzb = zzsrVar;
        zzahd.zzH(zzsr.class, zzsrVar);
    }

    private zzsr() {
    }

    public static zzsq zza() {
        return (zzsq) zzb.zzt();
    }

    public static zzsr zzc() {
        return zzb;
    }

    public final int zzd() {
        int i4 = this.zzf;
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

    public final int zze() {
        int i4 = this.zze;
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

    public final int zzf() {
        int i4 = this.zzd;
        int i5 = 2;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            i5 = 0;
                        } else {
                            i5 = 6;
                        }
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

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahd
    protected final Object zzj(int i4, Object obj, Object obj2) {
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
                    return new zzsq(null);
                }
                return new zzsr();
            }
            return zzahd.zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
