package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzkd extends zzgo implements zzhz {
    private static final zzkd zzb;
    private zzgv zzd = zzgo.zzw();
    private zzfw zze;

    static {
        zzkd zzkdVar = new zzkd();
        zzb = zzkdVar;
        zzgo.zzC(zzkd.class, zzkdVar);
    }

    private zzkd() {
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
                    return new zzkc(null);
                }
                return new zzkd();
            }
            return zzgo.zzz(zzb, "\u0000\u0002\u0000\u0000\f\r\u0002\u0000\u0001\u0000\f\u001b\r\t", new Object[]{"zzd", zzlm.class, "zze"});
        }
        return (byte) 1;
    }
}
