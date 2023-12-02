package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzkj extends zzgo implements zzhz {
    private static final zzgu zzb = new zzkh();
    private static final zzkj zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private zzgt zzk = zzgo.zzv();

    static {
        zzkj zzkjVar = new zzkj();
        zzd = zzkjVar;
        zzgo.zzC(zzkj.class, zzkjVar);
    }

    private zzkj() {
    }

    public static /* synthetic */ void zzG(zzkj zzkjVar, String str) {
        str.getClass();
        zzkjVar.zzf = str;
    }

    public static /* synthetic */ void zzI(zzkj zzkjVar, String str) {
        str.getClass();
        zzkjVar.zzh = str;
    }

    public static zzki zzf() {
        return (zzki) zzd.zzp();
    }

    public static /* synthetic */ void zzj(zzkj zzkjVar, String str) {
        str.getClass();
        zzkjVar.zzi = str;
    }

    public static /* synthetic */ void zzk(zzkj zzkjVar, String str) {
        str.getClass();
        zzkjVar.zzj = str;
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
                        return zzd;
                    }
                    return new zzki(null);
                }
                return new zzkj();
            }
            return zzgo.zzz(zzd, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007,", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        return (byte) 1;
    }
}
