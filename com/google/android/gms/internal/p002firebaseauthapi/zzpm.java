package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpm  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzpm extends zzahd implements zzaij {
    private static final zzpm zzb;
    private int zzd;
    private int zze;
    private zzps zzf;
    private zzafy zzg = zzafy.zzb;

    static {
        zzpm zzpmVar = new zzpm();
        zzb = zzpmVar;
        zzahd.zzH(zzpm.class, zzpmVar);
    }

    private zzpm() {
    }

    public static zzpl zzb() {
        return (zzpl) zzb.zzt();
    }

    public static zzpm zzd() {
        return zzb;
    }

    public static zzpm zze(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzpm) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzpm zzpmVar, zzps zzpsVar) {
        zzpsVar.getClass();
        zzpmVar.zzf = zzpsVar;
        zzpmVar.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzps zzf() {
        zzps zzpsVar = this.zzf;
        if (zzpsVar == null) {
            return zzps.zzd();
        }
        return zzpsVar;
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
                    return new zzpl(null);
                }
                return new zzpm();
            }
            return zzahd.zzE(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }
}
