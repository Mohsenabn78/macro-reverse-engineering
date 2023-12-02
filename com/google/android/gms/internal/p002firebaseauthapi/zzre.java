package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzre */
/* loaded from: classes4.dex */
public final class zzre extends zzahd implements zzaij {
    private static final zzre zzb;
    private int zzd;
    private zzth zze;

    static {
        zzre zzreVar = new zzre();
        zzb = zzreVar;
        zzahd.zzH(zzre.class, zzreVar);
    }

    private zzre() {
    }

    public static zzrd zza() {
        return (zzrd) zzb.zzt();
    }

    public static zzre zzc() {
        return zzb;
    }

    public static /* synthetic */ void zze(zzre zzreVar, zzth zzthVar) {
        zzthVar.getClass();
        zzreVar.zze = zzthVar;
        zzreVar.zzd |= 1;
    }

    public final zzth zzd() {
        zzth zzthVar = this.zze;
        if (zzthVar == null) {
            return zzth.zzc();
        }
        return zzthVar;
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
                    return new zzrd(null);
                }
                return new zzre();
            }
            return zzahd.zzE(zzb, "\u0000\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဉ\u0000", new Object[]{"zzd", "zze"});
        }
        return (byte) 1;
    }
}
