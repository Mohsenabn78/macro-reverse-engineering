package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzua  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzua extends zzahd implements zzaij {
    private static final zzua zzb;
    private String zzd = "";

    static {
        zzua zzuaVar = new zzua();
        zzb = zzuaVar;
        zzahd.zzH(zzua.class, zzuaVar);
    }

    private zzua() {
    }

    public static zzua zzb() {
        return zzb;
    }

    public static zzua zzc(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzua) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    public final String zzd() {
        return this.zzd;
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
                    return new zztz(null);
                }
                return new zzua();
            }
            return zzahd.zzE(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzd"});
        }
        return (byte) 1;
    }
}
