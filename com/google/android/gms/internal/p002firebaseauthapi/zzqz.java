package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqz */
/* loaded from: classes4.dex */
public final class zzqz extends zzahd implements zzaij {
    private static final zzqz zzb;

    static {
        zzqz zzqzVar = new zzqz();
        zzb = zzqzVar;
        zzahd.zzH(zzqz.class, zzqzVar);
    }

    private zzqz() {
    }

    public static zzqz zzb() {
        return zzb;
    }

    public static zzqz zzc(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzqz) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

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
                    return new zzqy(null);
                }
                return new zzqz();
            }
            return zzahd.zzE(zzb, "\u0000\u0000", null);
        }
        return (byte) 1;
    }
}
