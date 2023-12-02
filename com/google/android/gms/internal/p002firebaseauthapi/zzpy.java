package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpy */
/* loaded from: classes4.dex */
public final class zzpy extends zzahd implements zzaij {
    private static final zzpy zzb;
    private int zzd;
    private zzqb zze;
    private int zzf;

    static {
        zzpy zzpyVar = new zzpy();
        zzb = zzpyVar;
        zzahd.zzH(zzpy.class, zzpyVar);
    }

    private zzpy() {
    }

    public static zzpx zzb() {
        return (zzpx) zzb.zzt();
    }

    public static zzpy zzd(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzpy) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    public static /* synthetic */ void zzf(zzpy zzpyVar, zzqb zzqbVar) {
        zzqbVar.getClass();
        zzpyVar.zze = zzqbVar;
        zzpyVar.zzd |= 1;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzqb zze() {
        zzqb zzqbVar = this.zze;
        if (zzqbVar == null) {
            return zzqb.zzd();
        }
        return zzqbVar;
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
                    return new zzpx(null);
                }
                return new zzpy();
            }
            return zzahd.zzE(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
