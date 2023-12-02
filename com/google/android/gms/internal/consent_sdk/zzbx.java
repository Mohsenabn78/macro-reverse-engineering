package com.google.android.gms.internal.consent_sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.core.os.EnvironmentCompat;
import com.arlosoft.macrodroid.geofences.GeofenceInfo;
import com.google.firebase.firestore.BuildConfig;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
/* loaded from: classes4.dex */
public final class zzbx {
    @Nullable
    @GuardedBy("DeviceId.class")
    private static String zza;

    public static synchronized String zza(Context context) {
        String str;
        String string;
        synchronized (zzbx.class) {
            if (zza == null) {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver == null) {
                    string = null;
                } else {
                    string = Settings.Secure.getString(contentResolver, "android_id");
                }
                if (string == null || zzb()) {
                    string = BuildConfig.TARGET_BACKEND;
                }
                zza = zzc(string);
            }
            str = zza;
        }
        return str;
    }

    public static boolean zzb() {
        String str = Build.FINGERPRINT;
        if (!str.startsWith(GeofenceInfo.GEOFENCE_GENERIC_ID) && !str.startsWith(EnvironmentCompat.MEDIA_UNKNOWN)) {
            String str2 = Build.MODEL;
            if (!str2.contains("google_sdk") && !str2.contains("Emulator") && !str2.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion")) {
                if ((!Build.BRAND.startsWith(GeofenceInfo.GEOFENCE_GENERIC_ID) || !Build.DEVICE.startsWith(GeofenceInfo.GEOFENCE_GENERIC_ID)) && !"google_sdk".equals(Build.PRODUCT)) {
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private static String zzc(String str) {
        for (int i4 = 0; i4 < 3; i4++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                messageDigest.update(str.getBytes());
                return String.format("%032X", new BigInteger(1, messageDigest.digest()));
            } catch (ArithmeticException unused) {
                return "";
            } catch (NoSuchAlgorithmException unused2) {
            }
        }
        return "";
    }
}
