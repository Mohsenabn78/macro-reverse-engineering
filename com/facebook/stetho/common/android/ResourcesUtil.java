package com.facebook.stetho.common.android;

import android.content.res.Resources;
import com.facebook.stetho.common.LogUtil;
import com.google.firebase.sessions.settings.RemoteSettings;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class ResourcesUtil {
    private ResourcesUtil() {
    }

    private static String getFallbackIdString(int i4) {
        return "#" + Integer.toHexString(i4);
    }

    public static String getIdString(@Nullable Resources resources, int i4) throws Resources.NotFoundException {
        String str;
        String str2;
        if (resources == null) {
            return getFallbackIdString(i4);
        }
        if (getResourcePackageId(i4) != 127) {
            str = resources.getResourcePackageName(i4);
            str2 = ":";
        } else {
            str = "";
            str2 = "";
        }
        String resourceTypeName = resources.getResourceTypeName(i4);
        String resourceEntryName = resources.getResourceEntryName(i4);
        StringBuilder sb = new StringBuilder(str.length() + 1 + str2.length() + resourceTypeName.length() + 1 + resourceEntryName.length());
        sb.append("@");
        sb.append(str);
        sb.append(str2);
        sb.append(resourceTypeName);
        sb.append(RemoteSettings.FORWARD_SLASH_STRING);
        sb.append(resourceEntryName);
        return sb.toString();
    }

    @Nonnull
    public static String getIdStringQuietly(Object obj, @Nullable Resources resources, int i4) {
        try {
            return getIdString(resources, i4);
        } catch (Resources.NotFoundException unused) {
            String fallbackIdString = getFallbackIdString(i4);
            LogUtil.w("Unknown identifier encountered on " + obj + ": " + fallbackIdString);
            return fallbackIdString;
        }
    }

    private static int getResourcePackageId(int i4) {
        return (i4 >>> 24) & 255;
    }
}
