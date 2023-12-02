package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzkx extends zzgo implements zzhz {
    private static final zzkx zzb;
    private Object zze;
    private int zzf;
    private long zzk;
    private zzfw zzl;
    private int zzm;
    private zzkm zzn;
    private zzlj zzo;
    private zzjd zzq;
    private zzfw zzs;
    private int zzd = 0;
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzp = "";
    private zzgv zzr = zzgo.zzw();

    static {
        zzkx zzkxVar = new zzkx();
        zzb = zzkxVar;
        zzgo.zzC(zzkx.class, zzkxVar);
    }

    private zzkx() {
    }

    public static zzkx zzG(byte[] bArr) throws zzgy {
        return (zzkx) zzgo.zzu(zzb, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzJ(zzkx zzkxVar, String str) {
        str.getClass();
        zzkxVar.zzi = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzM(zzkx zzkxVar, zzlj zzljVar) {
        zzljVar.getClass();
        zzkxVar.zzo = zzljVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzP(zzkx zzkxVar, zzkg zzkgVar) {
        zzkgVar.getClass();
        zzkxVar.zze = zzkgVar;
        zzkxVar.zzd = 15;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzQ(zzkx zzkxVar, String str) {
        str.getClass();
        zzkxVar.zzg = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzR(zzkx zzkxVar, String str) {
        str.getClass();
        zzkxVar.zzh = str;
    }

    public static zzku zzi() {
        return (zzku) zzb.zzp();
    }

    public final String zzH() {
        return this.zzh;
    }

    public final String zzI() {
        return this.zzi;
    }

    public final boolean zzS() {
        if (this.zzn != null) {
            return true;
        }
        return false;
    }

    public final int zzT() {
        int i4 = this.zzm;
        int i5 = 2;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    i5 = 0;
                } else {
                    i5 = 4;
                }
            } else {
                i5 = 3;
            }
        }
        if (i5 == 0) {
            return 1;
        }
        return i5;
    }

    @Deprecated
    public final long zzf() {
        return this.zzk;
    }

    public final zzkm zzg() {
        zzkm zzkmVar = this.zzn;
        if (zzkmVar == null) {
            return zzkm.zzj();
        }
        return zzkmVar;
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
                    return new zzku(null);
                }
                return new zzkx();
            }
            return zzgo.zzz(zzb, "\u0000\u0010\u0001\u0000\u0001\u0010\u0010\u0000\u0001\u0000\u0001\f\u0002Ȉ\u0003\u0003\u0004\f\u0005\t\u0006\t\u0007Ȉ\bȈ\tȈ\n\t\u000b\t\f\u001b\r\t\u000eȈ\u000f<\u0000\u0010<\u0000", new Object[]{"zze", "zzd", "zzf", "zzh", "zzk", "zzm", "zzn", "zzo", "zzp", "zzi", "zzj", "zzl", "zzq", "zzr", zzlm.class, "zzs", "zzg", zzkg.class, zzkd.class});
        }
        return (byte) 1;
    }

    public final zzkw zzj() {
        zzkw zzkwVar;
        int i4 = this.zzf;
        zzkw zzkwVar2 = zzkw.UNKNOWN;
        switch (i4) {
            case 0:
                zzkwVar = zzkw.UNKNOWN;
                break;
            case 1:
                zzkwVar = zzkw.INIT_NATIVE;
                break;
            case 2:
                zzkwVar = zzkw.INIT_NETWORK;
                break;
            case 3:
                zzkwVar = zzkw.INIT_JS;
                break;
            case 4:
                zzkwVar = zzkw.INIT_TOTAL;
                break;
            case 5:
                zzkwVar = zzkw.EXECUTE_NATIVE;
                break;
            case 6:
                zzkwVar = zzkw.EXECUTE_JS;
                break;
            case 7:
                zzkwVar = zzkw.EXECUTE_TOTAL;
                break;
            case 8:
                zzkwVar = zzkw.CHALLENGE_ACCOUNT_NATIVE;
                break;
            case 9:
                zzkwVar = zzkw.CHALLENGE_ACCOUNT_JS;
                break;
            case 10:
                zzkwVar = zzkw.CHALLENGE_ACCOUNT_TOTAL;
                break;
            case 11:
                zzkwVar = zzkw.VERIFY_PIN_NATIVE;
                break;
            case 12:
                zzkwVar = zzkw.VERIFY_PIN_JS;
                break;
            case 13:
                zzkwVar = zzkw.VERIFY_PIN_TOTAL;
                break;
            case 14:
                zzkwVar = zzkw.RUN_PROGRAM;
                break;
            case 15:
                zzkwVar = zzkw.FETCH_ALLOWLIST;
                break;
            case 16:
                zzkwVar = zzkw.JS_LOAD;
                break;
            default:
                zzkwVar = null;
                break;
        }
        if (zzkwVar == null) {
            return zzkw.UNRECOGNIZED;
        }
        return zzkwVar;
    }
}
