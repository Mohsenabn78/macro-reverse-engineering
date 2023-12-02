package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztx  reason: invalid package */
/* loaded from: classes4.dex */
public final class zztx extends zzahd implements zzaij {
    private static final zztx zzb;
    private int zzd;
    private int zze;
    private zzua zzf;

    static {
        zztx zztxVar = new zztx();
        zzb = zztxVar;
        zzahd.zzH(zztx.class, zztxVar);
    }

    private zztx() {
    }

    public static zztw zzb() {
        return (zztw) zzb.zzt();
    }

    public static zztx zzd(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zztx) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(zztx zztxVar, zzua zzuaVar) {
        zzuaVar.getClass();
        zztxVar.zzf = zzuaVar;
        zztxVar.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzua zze() {
        zzua zzuaVar = this.zzf;
        if (zzuaVar == null) {
            return zzua.zzb();
        }
        return zzuaVar;
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
                    return new zztw(null);
                }
                return new zztx();
            }
            return zzahd.zzE(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
