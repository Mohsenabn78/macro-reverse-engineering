package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztc  reason: invalid package */
/* loaded from: classes4.dex */
public final class zztc extends zzahd implements zzaij {
    private static final zztc zzb;
    private String zzd = "";
    private zzafy zze = zzafy.zzb;
    private int zzf;

    static {
        zztc zztcVar = new zztc();
        zzb = zztcVar;
        zzahd.zzH(zztc.class, zztcVar);
    }

    private zztc() {
    }

    public static zzsz zza() {
        return (zzsz) zzb.zzt();
    }

    public static zztc zzd() {
        return zzb;
    }

    public final zztb zzb() {
        zztb zztbVar;
        int i4 = this.zzf;
        zztb zztbVar2 = zztb.UNKNOWN_KEYMATERIAL;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            zztbVar = null;
                        } else {
                            zztbVar = zztb.REMOTE;
                        }
                    } else {
                        zztbVar = zztb.ASYMMETRIC_PUBLIC;
                    }
                } else {
                    zztbVar = zztb.ASYMMETRIC_PRIVATE;
                }
            } else {
                zztbVar = zztb.SYMMETRIC;
            }
        } else {
            zztbVar = zztb.UNKNOWN_KEYMATERIAL;
        }
        if (zztbVar == null) {
            return zztb.UNRECOGNIZED;
        }
        return zztbVar;
    }

    public final zzafy zze() {
        return this.zze;
    }

    public final String zzf() {
        return this.zzd;
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
                    return new zzsz(null);
                }
                return new zztc();
            }
            return zzahd.zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
