package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzul */
/* loaded from: classes4.dex */
public final class zzul extends zzahd implements zzaij {
    private static final zzul zzb;
    private String zzd = "";
    private zzahi zze = zzahd.zzA();

    static {
        zzul zzulVar = new zzul();
        zzb = zzulVar;
        zzahd.zzH(zzul.class, zzulVar);
    }

    private zzul() {
    }

    public static zzul zzb() {
        return zzb;
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
                    return new zzuk(null);
                }
                return new zzul();
            }
            return zzahd.zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzd", "zze", zztk.class});
        }
        return (byte) 1;
    }
}
