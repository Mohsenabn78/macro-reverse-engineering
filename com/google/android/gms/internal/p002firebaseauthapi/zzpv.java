package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpv  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzpv extends zzahd implements zzaij {
    private static final zzpv zzb;
    private int zzd;
    private int zze;
    private zzqb zzf;
    private zzafy zzg = zzafy.zzb;

    static {
        zzpv zzpvVar = new zzpv();
        zzb = zzpvVar;
        zzahd.zzH(zzpv.class, zzpvVar);
    }

    private zzpv() {
    }

    public static zzpu zzb() {
        return (zzpu) zzb.zzt();
    }

    public static zzpv zzd(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzpv) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzpv zzpvVar, zzqb zzqbVar) {
        zzqbVar.getClass();
        zzpvVar.zzf = zzqbVar;
        zzpvVar.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzqb zze() {
        zzqb zzqbVar = this.zzf;
        if (zzqbVar == null) {
            return zzqb.zzd();
        }
        return zzqbVar;
    }

    public final zzafy zzf() {
        return this.zzg;
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
                    return new zzpu(null);
                }
                return new zzpv();
            }
            return zzahd.zzE(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }
}
