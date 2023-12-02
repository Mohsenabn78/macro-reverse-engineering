package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpp */
/* loaded from: classes4.dex */
public final class zzpp extends zzahd implements zzaij {
    private static final zzpp zzb;
    private int zzd;
    private zzps zze;
    private int zzf;

    static {
        zzpp zzppVar = new zzpp();
        zzb = zzppVar;
        zzahd.zzH(zzpp.class, zzppVar);
    }

    private zzpp() {
    }

    public static zzpo zzb() {
        return (zzpo) zzb.zzt();
    }

    public static zzpp zzd() {
        return zzb;
    }

    public static zzpp zze(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzpp) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    public static /* synthetic */ void zzg(zzpp zzppVar, zzps zzpsVar) {
        zzpsVar.getClass();
        zzppVar.zze = zzpsVar;
        zzppVar.zzd |= 1;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzps zzf() {
        zzps zzpsVar = this.zze;
        if (zzpsVar == null) {
            return zzps.zzd();
        }
        return zzpsVar;
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
                    return new zzpo(null);
                }
                return new zzpp();
            }
            return zzahd.zzE(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
