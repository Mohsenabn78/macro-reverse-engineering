package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzkm extends zzgo implements zzhz {
    private static final zzkm zzb;
    private int zzf;
    private int zzi;
    private String zzd = "";
    private String zze = "";
    private String zzg = "";
    private String zzh = "";

    static {
        zzkm zzkmVar = new zzkm();
        zzb = zzkmVar;
        zzgo.zzC(zzkm.class, zzkmVar);
    }

    private zzkm() {
    }

    public static /* synthetic */ void zzG(zzkm zzkmVar, String str) {
        str.getClass();
        zzkmVar.zzd = str;
    }

    public static zzkl zzg() {
        return (zzkl) zzb.zzp();
    }

    public static zzkm zzj() {
        return zzb;
    }

    public final int zzf() {
        return this.zzf;
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
                    return new zzkl(null);
                }
                return new zzkm();
            }
            return zzgo.zzz(zzb, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003Ȉ\u0004\u0004\u0005Ȉ\u0006Ȉ", new Object[]{"zzd", "zzf", "zzh", "zzi", "zze", "zzg"});
        }
        return (byte) 1;
    }

    public final String zzk() {
        return this.zzd;
    }
}
