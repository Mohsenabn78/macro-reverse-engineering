package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzso */
/* loaded from: classes4.dex */
public final class zzso extends zzahd implements zzaij {
    private static final zzso zzb;
    private int zzd;
    private zzsr zze;

    static {
        zzso zzsoVar = new zzso();
        zzb = zzsoVar;
        zzahd.zzH(zzso.class, zzsoVar);
    }

    private zzso() {
    }

    public static zzsn zza() {
        return (zzsn) zzb.zzt();
    }

    public static zzso zzc(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzso) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    public static /* synthetic */ void zze(zzso zzsoVar, zzsr zzsrVar) {
        zzsrVar.getClass();
        zzsoVar.zze = zzsrVar;
        zzsoVar.zzd |= 1;
    }

    public final zzsr zzd() {
        zzsr zzsrVar = this.zze;
        if (zzsrVar == null) {
            return zzsr.zzc();
        }
        return zzsrVar;
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
                    return new zzsn(null);
                }
                return new zzso();
            }
            return zzahd.zzE(zzb, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzd", "zze"});
        }
        return (byte) 1;
    }
}
