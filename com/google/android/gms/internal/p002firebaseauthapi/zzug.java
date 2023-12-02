package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzug */
/* loaded from: classes4.dex */
public final class zzug extends zzahd implements zzaij {
    private static final zzug zzb;
    private int zzd;
    private String zze = "";
    private zzth zzf;

    static {
        zzug zzugVar = new zzug();
        zzb = zzugVar;
        zzahd.zzH(zzug.class, zzugVar);
    }

    private zzug() {
    }

    public static zzug zzc() {
        return zzb;
    }

    public static zzug zzd(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzug) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    public final zzth zza() {
        zzth zzthVar = this.zzf;
        if (zzthVar == null) {
            return zzth.zzc();
        }
        return zzthVar;
    }

    public final String zze() {
        return this.zze;
    }

    public final boolean zzf() {
        if ((this.zzd & 1) != 0) {
            return true;
        }
        return false;
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
                    return new zzuf(null);
                }
                return new zzug();
            }
            return zzahd.zzE(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
