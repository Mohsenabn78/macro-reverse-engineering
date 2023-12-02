package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzmj extends zzgo implements zzhz {
    private static final zzmj zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private zzlx zzh;
    private int zzi;
    private zzlu zzj;

    static {
        zzmj zzmjVar = new zzmj();
        zzb = zzmjVar;
        zzgo.zzC(zzmj.class, zzmjVar);
    }

    private zzmj() {
    }

    public static /* synthetic */ void zzG(zzmj zzmjVar, int i4) {
        if (i4 != 1) {
            zzmjVar.zzd = i4 - 2;
            return;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static /* synthetic */ void zzH(zzmj zzmjVar, int i4) {
        if (i4 != 1) {
            zzmjVar.zzf = i4 - 2;
            return;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static zzmi zzf() {
        return (zzmi) zzb.zzp();
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
                    return new zzmi(null);
                }
                return new zzmj();
            }
            return zzgo.zzz(zzb, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\f\u0002\u000b\u0003\f\u0004\f\u0005\t\u0006\u000b\u0007\t", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        return (byte) 1;
    }

    public final int zzj() {
        int i4;
        switch (this.zzf) {
            case 0:
                i4 = 2;
                break;
            case 1:
                i4 = 3;
                break;
            case 2:
                i4 = 4;
                break;
            case 3:
                i4 = 5;
                break;
            case 4:
                i4 = 6;
                break;
            case 5:
                i4 = 7;
                break;
            case 6:
                i4 = 8;
                break;
            case 7:
                i4 = 9;
                break;
            case 8:
                i4 = 10;
                break;
            case 9:
                i4 = 11;
                break;
            case 10:
                i4 = 12;
                break;
            case 11:
                i4 = 13;
                break;
            case 12:
                i4 = 14;
                break;
            case 13:
                i4 = 15;
                break;
            case 14:
                i4 = 16;
                break;
            case 15:
                i4 = 17;
                break;
            case 16:
                i4 = 18;
                break;
            case 17:
                i4 = 19;
                break;
            case 18:
                i4 = 20;
                break;
            case 19:
                i4 = 21;
                break;
            case 20:
                i4 = 22;
                break;
            case 21:
                i4 = 23;
                break;
            case 22:
                i4 = 24;
                break;
            case 23:
                i4 = 25;
                break;
            case 24:
                i4 = 26;
                break;
            case 25:
                i4 = 27;
                break;
            case 26:
                i4 = 28;
                break;
            case 27:
                i4 = 29;
                break;
            case 28:
                i4 = 30;
                break;
            case 29:
                i4 = 31;
                break;
            case 30:
                i4 = 32;
                break;
            case 31:
                i4 = 33;
                break;
            case 32:
                i4 = 34;
                break;
            case 33:
                i4 = 35;
                break;
            case 34:
                i4 = 36;
                break;
            case 35:
                i4 = 37;
                break;
            case 36:
                i4 = 38;
                break;
            case 37:
                i4 = 39;
                break;
            case 38:
                i4 = 40;
                break;
            case 39:
                i4 = 41;
                break;
            case 40:
                i4 = 42;
                break;
            case 41:
                i4 = 43;
                break;
            case 42:
                i4 = 44;
                break;
            case 43:
                i4 = 45;
                break;
            case 44:
                i4 = 46;
                break;
            case 45:
                i4 = 47;
                break;
            case 46:
                i4 = 48;
                break;
            default:
                i4 = 0;
                break;
        }
        if (i4 == 0) {
            return 1;
        }
        return i4;
    }

    public final int zzk() {
        int i4;
        switch (this.zzd) {
            case 0:
                i4 = 2;
                break;
            case 1:
                i4 = 3;
                break;
            case 2:
                i4 = 4;
                break;
            case 3:
                i4 = 5;
                break;
            case 4:
                i4 = 6;
                break;
            case 5:
                i4 = 7;
                break;
            case 6:
                i4 = 8;
                break;
            case 7:
                i4 = 9;
                break;
            case 8:
                i4 = 10;
                break;
            case 9:
                i4 = 11;
                break;
            case 10:
                i4 = 12;
                break;
            default:
                i4 = 0;
                break;
        }
        if (i4 == 0) {
            return 1;
        }
        return i4;
    }
}
