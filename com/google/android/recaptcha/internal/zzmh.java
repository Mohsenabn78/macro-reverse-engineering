package com.google.android.recaptcha.internal;

import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzmh extends zzgo implements zzhz {
    private static final zzmh zzb;
    private zzgv zzd = zzgo.zzw();

    static {
        zzmh zzmhVar = new zzmh();
        zzb = zzmhVar;
        zzgo.zzC(zzmh.class, zzmhVar);
    }

    private zzmh() {
    }

    public static zzmh zzg(byte[] bArr) throws zzgy {
        return (zzmh) zzgo.zzu(zzb, bArr);
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
                    return new zzmg(null);
                }
                return new zzmh();
            }
            return zzgo.zzz(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzmv.class});
        }
        return (byte) 1;
    }

    public final List zzi() {
        return this.zzd;
    }
}
