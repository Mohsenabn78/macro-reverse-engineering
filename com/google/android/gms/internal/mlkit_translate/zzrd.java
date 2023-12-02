package com.google.android.gms.internal.mlkit_translate;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzrd {
    private static final int[] zzc = {0, 0, 1, 2, 4, 8, 16};
    @VisibleForTesting
    public static final zzra zzb = new Object() { // from class: com.google.android.gms.internal.mlkit_translate.zzra
    };
    @VisibleForTesting
    public static final Random zza = new SecureRandom();

    public static boolean zza(zzrc zzrcVar) throws InterruptedException {
        int[] iArr = zzc;
        for (int i4 = 0; i4 < 7; i4++) {
            int i5 = iArr[i4];
            if (i5 > 0) {
                int i6 = i5 * 60000;
                Thread.sleep((i6 / 2) + zza.nextInt(i6));
            }
            try {
            } catch (zzrb e4) {
                e = e4;
                Log.e("MLK ExponentialBackoff", "retryWithRandomizedExponentialBackoff: ".concat(String.valueOf(e.getMessage())), e);
            } catch (IOException e5) {
                e = e5;
                Log.e("MLK ExponentialBackoff", "retryWithRandomizedExponentialBackoff: ".concat(String.valueOf(e.getMessage())), e);
            } catch (InterruptedException e6) {
                Log.i("MLK ExponentialBackoff", "retryWithRandomizedExponentialBackoff: interrupted");
                throw e6;
            }
            if (zzrcVar.zza()) {
                return true;
            }
        }
        return false;
    }
}
