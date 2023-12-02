package crashguard.android.library;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import com.facebook.stetho.dumpapp.Framer;
import java.net.NetworkInterface;

/* loaded from: classes6.dex */
final class n0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Intent intent) {
        Bundle extras = intent.getExtras();
        extras.getBoolean(new String(new byte[]{109, 97, 115, 115, Framer.STDIN_REQUEST_FRAME_PREFIX, 115, 116, 111, 114, 97, 103, 101}));
        extras.getBoolean("adb");
        extras.getBoolean("rndis");
        extras.getBoolean("mtp");
        extras.getBoolean("ptp");
        extras.getBoolean(new String(new byte[]{97, 117, 100, 105, 111, Framer.STDIN_REQUEST_FRAME_PREFIX, 115, 111, 117, 114, 99, 101}));
        extras.getBoolean("accessory");
        try {
            NetworkInterface.getByName("eth0");
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() {
        String property = System.getProperty("ro.boot.qemu");
        if (property != null && property.equals("1")) {
            return true;
        }
        if (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) {
            return true;
        }
        String str = Build.FINGERPRINT;
        if (str.startsWith("generic") || str.startsWith("unknown")) {
            return true;
        }
        String str2 = Build.HARDWARE;
        if (str2.contains("goldfish") || str2.contains("ranchu")) {
            return true;
        }
        String str3 = Build.MODEL;
        if (str3.contains(new String(new byte[]{103, 111, 111, 103, 108, 101, Framer.STDIN_REQUEST_FRAME_PREFIX, 115, 100, 107})) || str3.contains("Emulator") || str3.contains(new String(new byte[]{65, 110, 100, 114, 111, 105, 100, 32, 83, 68, 75, 32, 98, 117, 105, 108, 116, 32, 102, 111, 114, 32, Framer.EXIT_FRAME_PREFIX, 56, 54})) || Build.MANUFACTURER.contains("Genymotion")) {
            return true;
        }
        String str4 = Build.PRODUCT;
        if (str4.contains(new String(new byte[]{115, 100, 107, Framer.STDIN_REQUEST_FRAME_PREFIX, 103, 111, 111, 103, 108, 101})) || str4.contains(new String(new byte[]{103, 111, 111, 103, 108, 101, Framer.STDIN_REQUEST_FRAME_PREFIX, 115, 100, 107})) || str4.contains("sdk") || str4.contains(new String(new byte[]{115, 100, 107, Framer.STDIN_REQUEST_FRAME_PREFIX, Framer.EXIT_FRAME_PREFIX, 56, 54})) || str4.contains(new String(new byte[]{115, 100, 107, Framer.STDIN_REQUEST_FRAME_PREFIX, 103, 112, 104, 111, 110, 101, 54, 52, Framer.STDIN_REQUEST_FRAME_PREFIX, 97, 114, 109, 54, 52})) || str4.contains(new String(new byte[]{118, 98, 111, Framer.EXIT_FRAME_PREFIX, 56, 54, 112})) || str4.contains("emulator") || str4.contains("simulator")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(Context context) {
        if (c(context) || Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) == 1) {
            return true;
        }
        return false;
    }
}
