package com.google.android.gms.internal.ads;

import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import dev.skomlach.biometric.compat.engine.internal.iris.samsung.SamsungIrisUnlockModule;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzabq {
    private static final String[] zza = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    private static final int[] zzb = {44100, 48000, 32000};
    private static final int[] zzc = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};
    private static final int[] zzd = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};
    private static final int[] zze = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};
    private static final int[] zzf = {32000, SamsungIrisUnlockModule.IRIS_ONE_EYE, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};
    private static final int[] zzg = {ConnectionsStatusCodes.STATUS_NETWORK_NOT_CONNECTED, 16000, 24000, 32000, SamsungIrisUnlockModule.IRIS_ONE_EYE, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    public static int zzb(int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (!zzm(i4) || (i5 = (i4 >>> 19) & 3) == 1 || (i6 = (i4 >>> 17) & 3) == 0 || (i7 = (i4 >>> 12) & 15) == 0 || i7 == 15 || (i8 = (i4 >>> 10) & 3) == 3) {
            return -1;
        }
        int i11 = zzb[i8];
        if (i5 == 2) {
            i11 /= 2;
        } else if (i5 == 0) {
            i11 /= 4;
        }
        int i12 = (i4 >>> 9) & 1;
        if (i6 == 3) {
            if (i5 == 3) {
                i10 = zzc[i7 - 1];
            } else {
                i10 = zzd[i7 - 1];
            }
            return (((i10 * 12) / i11) + i12) * 4;
        }
        if (i5 == 3) {
            if (i6 == 2) {
                i9 = zze[i7 - 1];
            } else {
                i9 = zzf[i7 - 1];
            }
        } else {
            i9 = zzg[i7 - 1];
        }
        int i13 = 144;
        if (i5 == 3) {
            return ((i9 * 144) / i11) + i12;
        }
        if (i6 == 1) {
            i13 = 72;
        }
        return ((i13 * i9) / i11) + i12;
    }

    public static int zzc(int i4) {
        int i5;
        int i6;
        if (!zzm(i4) || (i5 = (i4 >>> 19) & 3) == 1 || (i6 = (i4 >>> 17) & 3) == 0) {
            return -1;
        }
        int i7 = i4 >>> 12;
        int i8 = (i4 >>> 10) & 3;
        int i9 = i7 & 15;
        if (i9 == 0 || i9 == 15 || i8 == 3) {
            return -1;
        }
        return zzl(i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzl(int i4, int i5) {
        if (i5 != 1) {
            if (i5 == 2) {
                return 1152;
            }
            return 384;
        } else if (i4 == 3) {
            return 1152;
        } else {
            return 576;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzm(int i4) {
        if ((i4 & (-2097152)) == -2097152) {
            return true;
        }
        return false;
    }
}
