package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqn */
/* loaded from: classes4.dex */
public final class zzqn extends zzahd implements zzaij {
    private static final zzqn zzb;
    private int zzd;
    private int zze;

    static {
        zzqn zzqnVar = new zzqn();
        zzb = zzqnVar;
        zzahd.zzH(zzqn.class, zzqnVar);
    }

    private zzqn() {
    }

    public static zzqm zzc() {
        return (zzqm) zzb.zzt();
    }

    public static zzqn zze(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzqn) zzahd.zzx(zzb, zzafyVar, zzagqVar);
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
                    return new zzqm(null);
                }
                return new zzqn();
            }
            return zzahd.zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzd"});
        }
        return (byte) 1;
    }
}
