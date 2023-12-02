package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzto  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzto extends zzahd implements zzaij {
    private static final zzto zzb;
    private int zzd;
    private zztc zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzto zztoVar = new zzto();
        zzb = zztoVar;
        zzahd.zzH(zzto.class, zztoVar);
    }

    private zzto() {
    }

    public static zztn zzc() {
        return (zztn) zzb.zzt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzf(zzto zztoVar, zztc zztcVar) {
        zztcVar.getClass();
        zztoVar.zze = zztcVar;
        zztoVar.zzd |= 1;
    }

    public final int zza() {
        return this.zzg;
    }

    public final zztc zzb() {
        zztc zztcVar = this.zze;
        if (zztcVar == null) {
            return zztc.zzd();
        }
        return zztcVar;
    }

    public final zzui zze() {
        zzui zzb2 = zzui.zzb(this.zzh);
        if (zzb2 == null) {
            return zzui.UNRECOGNIZED;
        }
        return zzb2;
    }

    public final boolean zzi() {
        if ((this.zzd & 1) != 0) {
            return true;
        }
        return false;
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
                    return new zztn(null);
                }
                return new zzto();
            }
            return zzahd.zzE(zzb, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        return (byte) 1;
    }

    public final int zzk() {
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
}
