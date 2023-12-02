package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzud  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzud extends zzahd implements zzaij {
    private static final zzud zzb;
    private int zzd;
    private int zze;
    private zzug zzf;

    static {
        zzud zzudVar = new zzud();
        zzb = zzudVar;
        zzahd.zzH(zzud.class, zzudVar);
    }

    private zzud() {
    }

    public static zzuc zzb() {
        return (zzuc) zzb.zzt();
    }

    public static zzud zzd(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzud) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(zzud zzudVar, zzug zzugVar) {
        zzugVar.getClass();
        zzudVar.zzf = zzugVar;
        zzudVar.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzug zze() {
        zzug zzugVar = this.zzf;
        if (zzugVar == null) {
            return zzug.zzc();
        }
        return zzugVar;
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
                    return new zzuc(null);
                }
                return new zzud();
            }
            return zzahd.zzE(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
