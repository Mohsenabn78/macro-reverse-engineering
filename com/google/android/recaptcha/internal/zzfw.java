package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzfw extends zzgo implements zzhz {
    private static final zzfw zzb;
    private long zzd;
    private int zze;

    static {
        zzfw zzfwVar = new zzfw();
        zzb = zzfwVar;
        zzgo.zzC(zzfw.class, zzfwVar);
    }

    private zzfw() {
    }

    public static zzfv zzi() {
        return (zzfv) zzb.zzp();
    }

    public final int zzf() {
        return this.zze;
    }

    public final long zzg() {
        return this.zzd;
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
                    return new zzfv(null);
                }
                return new zzfw();
            }
            return new zzij(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzd", "zze"});
        }
        return (byte) 1;
    }
}
