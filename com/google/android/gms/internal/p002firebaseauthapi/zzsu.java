package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsu  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzsu extends zzahd implements zzaij {
    private static final zzsu zzb;
    private int zzd;
    private int zze;
    private zzsx zzf;
    private zzafy zzg = zzafy.zzb;

    static {
        zzsu zzsuVar = new zzsu();
        zzb = zzsuVar;
        zzahd.zzH(zzsu.class, zzsuVar);
    }

    private zzsu() {
    }

    public static zzst zzb() {
        return (zzst) zzb.zzt();
    }

    public static zzsu zzd(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzsu) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzsu zzsuVar, zzsx zzsxVar) {
        zzsxVar.getClass();
        zzsuVar.zzf = zzsxVar;
        zzsuVar.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzsx zze() {
        zzsx zzsxVar = this.zzf;
        if (zzsxVar == null) {
            return zzsx.zze();
        }
        return zzsxVar;
    }

    public final zzafy zzf() {
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
                    return new zzst(null);
                }
                return new zzsu();
            }
            return zzahd.zzE(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }

    public final boolean zzk() {
        if ((this.zzd & 1) != 0) {
            return true;
        }
        return false;
    }
}
