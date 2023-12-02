package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqe  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzqe extends zzahd implements zzaij {
    private static final zzqe zzb;
    private int zzd;
    private zzafy zze = zzafy.zzb;

    static {
        zzqe zzqeVar = new zzqe();
        zzb = zzqeVar;
        zzahd.zzH(zzqe.class, zzqeVar);
    }

    private zzqe() {
    }

    public static zzqd zzb() {
        return (zzqd) zzb.zzt();
    }

    public static zzqe zzd(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzqe) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzafy zze() {
        return this.zze;
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
                    return new zzqd(null);
                }
                return new zzqe();
            }
            return zzahd.zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzd", "zze"});
        }
        return (byte) 1;
    }
}
