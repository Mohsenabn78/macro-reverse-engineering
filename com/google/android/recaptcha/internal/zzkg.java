package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzkg extends zzgo implements zzhz {
    private static final zzkg zzb;
    private int zzd;
    private zzfw zze;
    private int zzf;

    static {
        zzkg zzkgVar = new zzkg();
        zzb = zzkgVar;
        zzgo.zzC(zzkg.class, zzkgVar);
    }

    private zzkg() {
    }

    public static zzkf zzf() {
        return (zzkf) zzb.zzp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzkg zzkgVar, zzfw zzfwVar) {
        zzfwVar.getClass();
        zzkgVar.zze = zzfwVar;
        zzkgVar.zzd |= 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
                    return new zzkf(null);
                }
                return new zzkg();
            }
            return zzgo.zzz(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0004", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
