package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzur */
/* loaded from: classes4.dex */
public final class zzur extends zzahd implements zzaij {
    private static final zzur zzb;
    private int zzd;

    static {
        zzur zzurVar = new zzur();
        zzb = zzurVar;
        zzahd.zzH(zzur.class, zzurVar);
    }

    private zzur() {
    }

    public static zzur zzc() {
        return zzb;
    }

    public static zzur zzd(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzur) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    public final int zza() {
        return this.zzd;
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
                    return new zzuq(null);
                }
                return new zzur();
            }
            return zzahd.zzE(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzd"});
        }
        return (byte) 1;
    }
}
