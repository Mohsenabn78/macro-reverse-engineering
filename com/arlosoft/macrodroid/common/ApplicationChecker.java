package com.arlosoft.macrodroid.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.UserHandle;
import android.provider.Settings;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.receivers.SpotifyReceiver;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class ApplicationChecker {
    @Nullable
    private static String a(String str) {
        try {
            return MacroDroidApplication.getInstance().getPackageManager().getPackageInfo(str, 1).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        } catch (Exception e4) {
            SystemLog.logError("Could not get appVersion for: " + str + " :" + e4.toString());
            return null;
        }
    }

    @Nullable
    private static int b(String str) {
        try {
            return MacroDroidApplication.getInstance().getPackageManager().getPackageInfo(str, 1).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        } catch (Exception e4) {
            SystemLog.logError("Could not get getAppVersionCode for: " + str + " :" + e4.toString());
            return 0;
        }
    }

    private static ComponentName c(Context context) {
        try {
            Method declaredMethod = UserHandle.class.getDeclaredMethod("myUserId", new Class[0]);
            declaredMethod.setAccessible(true);
            Integer num = (Integer) declaredMethod.invoke(null, new Object[0]);
            if (num != null) {
                Object newInstance = Class.forName("com.android.internal.app.AssistUtils").getConstructor(Context.class).newInstance(context);
                Method declaredMethod2 = newInstance.getClass().getDeclaredMethod("getAssistComponentForUser", Integer.TYPE);
                declaredMethod2.setAccessible(true);
                return (ComponentName) declaredMethod2.invoke(newInstance, num);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return null;
    }

    public static int getMacroDroidHelperVersionCode() {
        return b("com.arlosoft.macrodroid.helper");
    }

    @Nullable
    public static String getMacroDroidHelperVersionName() {
        return a("com.arlosoft.macrodroid.helper");
    }

    public static boolean isAppInstalled(String str) {
        try {
            MacroDroidApplication.getInstance().getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    public static boolean isBusyBoxInstalled() {
        return isAppInstalled("stericson.busybox");
    }

    public static boolean isMacroDroidAssistDefault(Context context) {
        if (Settings.getIgnoreDefaultAssistWarning(context)) {
            return true;
        }
        ComponentName c4 = c(context);
        if (c4 != null && c4.getPackageName().equals(context.getPackageName())) {
            return true;
        }
        String string = Settings.Secure.getString(context.getContentResolver(), "assistant");
        if (string != null && string.startsWith(context.getPackageName())) {
            return true;
        }
        return false;
    }

    public static boolean isMacroDroidHelperInstalled() {
        if (!isAppInstalled("com.arlosoft.macrodroid.settingshelper") && !isAppInstalled("com.arlosoft.macrodroid.helper")) {
            return false;
        }
        return true;
    }

    public static boolean isMacroDroidNewHelperInstalled() {
        return isAppInstalled("com.arlosoft.macrodroid.helper");
    }

    public static boolean isPebbleInstalled() {
        if (!isAppInstalled("com.getpebble.android") && !isAppInstalled("com.getpebble.android.basalt")) {
            return false;
        }
        return true;
    }

    public static boolean isPebbleTimeInstalled() {
        return isAppInstalled("com.getpebble.android.basalt");
    }

    public static boolean isPlayStoreInstalled() {
        return isAppInstalled("com.android.vending");
    }

    public static boolean isSecureSettingsInstalled() {
        return isAppInstalled("com.intangibleobject.securesettings.plugin");
    }

    public static boolean isSpotifyInstalled() {
        return isAppInstalled(SpotifyReceiver.BroadcastTypes.SPOTIFY_PACKAGE);
    }
}
