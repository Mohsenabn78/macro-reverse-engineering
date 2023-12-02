package com.google.android.recaptcha.internal;

import android.content.Context;
import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzu {
    @NotNull
    public static final zzu zza = new zzu();
    @ChecksSdkIntAtLeast(extension = 0)
    @NotNull
    private static final String zzb = String.valueOf(Build.VERSION.SDK_INT);
    @NotNull
    private static final GoogleApiAvailabilityLight zzc = GoogleApiAvailabilityLight.getInstance();

    private zzu() {
    }

    @NotNull
    public static final String zza(@NotNull Context context) {
        int isGooglePlayServicesAvailable = zzc.isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable != 1 && isGooglePlayServicesAvailable != 3 && isGooglePlayServicesAvailable != 9) {
            return "ANDROID_ONPLAY";
        }
        return "ANDROID_OFFPLAY";
    }

    @NotNull
    public static final String zzb() {
        return zzb;
    }
}
