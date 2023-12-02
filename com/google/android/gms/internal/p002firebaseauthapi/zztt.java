package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztt */
/* loaded from: classes4.dex */
public final class zztt extends zzahd implements zzaij {
    private static final zztt zzb;
    private String zzd = "";
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zztt zzttVar = new zztt();
        zzb = zzttVar;
        zzahd.zzH(zztt.class, zzttVar);
    }

    private zztt() {
    }

    public static zzts zzb() {
        return (zzts) zzb.zzt();
    }

    public static /* synthetic */ void zzd(zztt zzttVar, String str) {
        str.getClass();
        zzttVar.zzd = str;
    }

    public final int zza() {
        return this.zzf;
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
                    return new zzts(null);
                }
                return new zztt();
            }
            return zzahd.zzE(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }
}
