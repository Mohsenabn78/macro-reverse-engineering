package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzfo extends zzgk {
    private static final zzfo zzd;
    private int zze;
    private boolean zzf;
    private byte zzh = 2;
    private zzgv zzg = zzii.zze();

    static {
        zzfo zzfoVar = new zzfo();
        zzd = zzfoVar;
        zzgo.zzC(zzfo.class, zzfoVar);
    }

    private zzfo() {
    }

    public static zzfo zzg() {
        return zzd;
    }

    @Override // com.google.android.recaptcha.internal.zzgo
    public final Object zzh(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 != 0) {
            byte b4 = 1;
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 4) {
                        if (i5 != 5) {
                            if (obj == null) {
                                b4 = 0;
                            }
                            this.zzh = b4;
                            return null;
                        }
                        return zzd;
                    }
                    return new zzfn(null);
                }
                return new zzfo();
            }
            return new zzij(zzd, "\u0001\u0002\u0000\u0001\u0001ϧ\u0002\u0000\u0001\u0001\u0001ဇ\u0000ϧЛ", new Object[]{"zze", "zzf", "zzg", zzfs.class});
        }
        return Byte.valueOf(this.zzh);
    }
}
