package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzlg extends zzgo implements zzhz {
    private static final zzlg zzb;
    private zzfw zzd;
    private zzjd zze;
    private zzfw zzf;
    private zzjd zzg;

    static {
        zzlg zzlgVar = new zzlg();
        zzb = zzlgVar;
        zzgo.zzC(zzlg.class, zzlgVar);
    }

    private zzlg() {
    }

    public static /* synthetic */ void zzG(zzlg zzlgVar, zzfw zzfwVar) {
        zzfwVar.getClass();
        zzlgVar.zzf = zzfwVar;
    }

    public static zzlf zzf() {
        return (zzlf) zzb.zzp();
    }

    public static /* synthetic */ void zzi(zzlg zzlgVar, zzfw zzfwVar) {
        zzfwVar.getClass();
        zzlgVar.zzd = zzfwVar;
    }

    public static /* synthetic */ void zzj(zzlg zzlgVar, zzjd zzjdVar) {
        zzjdVar.getClass();
        zzlgVar.zzg = zzjdVar;
    }

    public static /* synthetic */ void zzk(zzlg zzlgVar, zzjd zzjdVar) {
        zzjdVar.getClass();
        zzlgVar.zze = zzjdVar;
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
                    return new zzlf(null);
                }
                return new zzlg();
            }
            return zzgo.zzz(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\t\u0003\t\u0004\t", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }
}
