package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzox */
/* loaded from: classes4.dex */
public final class zzox extends zzahd implements zzaij {
    private static final zzox zzb;
    private int zzd;
    private int zze;
    private zzafy zzf = zzafy.zzb;
    private zzpd zzg;

    static {
        zzox zzoxVar = new zzox();
        zzb = zzoxVar;
        zzahd.zzH(zzox.class, zzoxVar);
    }

    private zzox() {
    }

    public static zzow zzb() {
        return (zzow) zzb.zzt();
    }

    public static zzox zzd(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzox) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    public static /* synthetic */ void zzi(zzox zzoxVar, zzpd zzpdVar) {
        zzpdVar.getClass();
        zzoxVar.zzg = zzpdVar;
        zzoxVar.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzpd zze() {
        zzpd zzpdVar = this.zzg;
        if (zzpdVar == null) {
            return zzpd.zzd();
        }
        return zzpdVar;
    }

    public final zzafy zzf() {
        return this.zzf;
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
                    return new zzow(null);
                }
                return new zzox();
            }
            return zzahd.zzE(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }
}
