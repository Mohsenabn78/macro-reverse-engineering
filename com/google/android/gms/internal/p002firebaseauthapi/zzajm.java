package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajm  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzajm extends zzahd implements zzaij {
    private static final zzajm zzb;
    private long zzd;
    private int zze;

    static {
        zzajm zzajmVar = new zzajm();
        zzb = zzajmVar;
        zzahd.zzH(zzajm.class, zzajmVar);
    }

    private zzajm() {
    }

    public static zzajl zzc() {
        return (zzajl) zzb.zzt();
    }

    public final int zza() {
        return this.zze;
    }

    public final long zzb() {
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
                    return new zzajl(null);
                }
                return new zzajm();
            }
            return new zzais(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzd", "zze"});
        }
        return (byte) 1;
    }
}
