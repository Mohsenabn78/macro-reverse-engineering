package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzlz extends zzgo implements zzhz {
    private static final zzlz zzb;
    private String zzd = "";
    private String zze = "";
    private int zzf;
    private int zzg;

    static {
        zzlz zzlzVar = new zzlz();
        zzb = zzlzVar;
        zzgo.zzC(zzlz.class, zzlzVar);
    }

    private zzlz() {
    }

    public static zzlz zzg(byte[] bArr) throws zzgy {
        return (zzlz) zzgo.zzu(zzb, bArr);
    }

    @Override // com.google.android.recaptcha.internal.zzgo
    public final Object zzh(int i4, Object obj, Object obj2) {
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
                    return new zzly(null);
                }
                return new zzlz();
            }
            return zzgo.zzz(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\f\u0004\f", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }

    public final zzmf zzi() {
        zzmf zzb2 = zzmf.zzb(this.zzf);
        if (zzb2 == null) {
            return zzmf.UNRECOGNIZED;
        }
        return zzb2;
    }

    public final String zzj() {
        return this.zzd;
    }

    public final String zzk() {
        return this.zze;
    }
}
