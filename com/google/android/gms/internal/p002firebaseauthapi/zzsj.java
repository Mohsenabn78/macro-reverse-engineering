package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsj */
/* loaded from: classes4.dex */
public final class zzsj extends zzahd implements zzaij {
    private static final zzsj zzb;
    private int zzd;
    private int zze;

    static {
        zzsj zzsjVar = new zzsj();
        zzb = zzsjVar;
        zzahd.zzH(zzsj.class, zzsjVar);
    }

    private zzsj() {
    }

    public static zzsi zzb() {
        return (zzsi) zzb.zzt();
    }

    public static zzsj zzd() {
        return zzb;
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzf() {
        int zzb2 = zzsa.zzb(this.zzd);
        if (zzb2 == 0) {
            return 1;
        }
        return zzb2;
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
                    return new zzsi(null);
                }
                return new zzsj();
            }
            return zzahd.zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzd", "zze"});
        }
        return (byte) 1;
    }
}
