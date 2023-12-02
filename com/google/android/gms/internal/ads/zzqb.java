package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import dev.skomlach.biometric.compat.engine.internal.iris.samsung.SamsungIrisUnlockModule;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzqb implements zzpm {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzqb(zzqa zzqaVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int zza(int i4, int i5, int i6) {
        return zzfuk.zza(((i4 * i5) * i6) / AnimationKt.MillisToNanos);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int zzb(int i4) {
        switch (i4) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return SamsungIrisUnlockModule.IRIS_ONE_EYE;
            case 10:
                return AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 13:
            case 19:
            default:
                throw new IllegalArgumentException();
            case 14:
                return 3062500;
            case 15:
                return ConnectionsStatusCodes.STATUS_NETWORK_NOT_CONNECTED;
            case 16:
                return 256000;
            case 17:
                return 336000;
            case 20:
                return 63750;
        }
    }
}
