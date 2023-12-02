package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpa */
/* loaded from: classes4.dex */
public final class zzpa extends zzahd implements zzaij {
    private static final zzpa zzb;
    private int zzd;
    private int zze;
    private zzpd zzf;

    static {
        zzpa zzpaVar = new zzpa();
        zzb = zzpaVar;
        zzahd.zzH(zzpa.class, zzpaVar);
    }

    private zzpa() {
    }

    public static zzoz zzb() {
        return (zzoz) zzb.zzt();
    }

    public static zzpa zzd(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzpa) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    public static /* synthetic */ void zzg(zzpa zzpaVar, zzpd zzpdVar) {
        zzpdVar.getClass();
        zzpaVar.zzf = zzpdVar;
        zzpaVar.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzpd zze() {
        zzpd zzpdVar = this.zzf;
        if (zzpdVar == null) {
            return zzpd.zzd();
        }
        return zzpdVar;
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
                    return new zzoz(null);
                }
                return new zzpa();
            }
            return zzahd.zzE(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
