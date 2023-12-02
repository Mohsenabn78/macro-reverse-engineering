package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpj */
/* loaded from: classes4.dex */
public final class zzpj extends zzahd implements zzaij {
    private static final zzpj zzb;
    private int zzd;
    private zzpp zze;
    private zzsg zzf;

    static {
        zzpj zzpjVar = new zzpj();
        zzb = zzpjVar;
        zzahd.zzH(zzpj.class, zzpjVar);
    }

    private zzpj() {
    }

    public static zzpi zza() {
        return (zzpi) zzb.zzt();
    }

    public static zzpj zzc(zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        return (zzpj) zzahd.zzx(zzb, zzafyVar, zzagqVar);
    }

    public static /* synthetic */ void zzf(zzpj zzpjVar, zzpp zzppVar) {
        zzppVar.getClass();
        zzpjVar.zze = zzppVar;
        zzpjVar.zzd |= 1;
    }

    public static /* synthetic */ void zzg(zzpj zzpjVar, zzsg zzsgVar) {
        zzsgVar.getClass();
        zzpjVar.zzf = zzsgVar;
        zzpjVar.zzd |= 2;
    }

    public final zzpp zzd() {
        zzpp zzppVar = this.zze;
        if (zzppVar == null) {
            return zzpp.zzd();
        }
        return zzppVar;
    }

    public final zzsg zze() {
        zzsg zzsgVar = this.zzf;
        if (zzsgVar == null) {
            return zzsg.zze();
        }
        return zzsgVar;
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
                    return new zzpi(null);
                }
                return new zzpj();
            }
            return zzahd.zzE(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
