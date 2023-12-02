package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsx  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzsx extends zzahd implements zzaij {
    private static final zzsx zzb;
    private int zzd;
    private int zze;
    private zzsr zzf;
    private zzafy zzg = zzafy.zzb;

    static {
        zzsx zzsxVar = new zzsx();
        zzb = zzsxVar;
        zzahd.zzH(zzsx.class, zzsxVar);
    }

    private zzsx() {
    }

    public static zzsw zzc() {
        return (zzsw) zzb.zzt();
    }

    public static zzsx zze() {
        return zzb;
    }

    public static zzsx zzf(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzsx) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzsx zzsxVar, zzsr zzsrVar) {
        zzsrVar.getClass();
        zzsxVar.zzf = zzsrVar;
        zzsxVar.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzsr zzb() {
        zzsr zzsrVar = this.zzf;
        if (zzsrVar == null) {
            return zzsr.zzc();
        }
        return zzsrVar;
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
                    return new zzsw(null);
                }
                return new zzsx();
            }
            return zzahd.zzE(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }

    public final boolean zzl() {
        if ((this.zzd & 1) != 0) {
            return true;
        }
        return false;
    }
}
