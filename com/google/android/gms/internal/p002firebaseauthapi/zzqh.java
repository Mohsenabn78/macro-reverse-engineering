package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqh */
/* loaded from: classes4.dex */
public final class zzqh extends zzahd implements zzaij {
    private static final zzqh zzb;
    private int zzd;
    private int zze;

    static {
        zzqh zzqhVar = new zzqh();
        zzb = zzqhVar;
        zzahd.zzH(zzqh.class, zzqhVar);
    }

    private zzqh() {
    }

    public static zzqg zzc() {
        return (zzqg) zzb.zzt();
    }

    public static zzqh zze(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzqh) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    public final int zza() {
        return this.zzd;
    }

    public final int zzb() {
        return this.zze;
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
                    return new zzqg(null);
                }
                return new zzqh();
            }
            return zzahd.zzE(zzb, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzd", "zze"});
        }
        return (byte) 1;
    }
}
