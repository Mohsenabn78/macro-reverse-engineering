package com.google.android.gms.auth;

import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.common.internal.Preconditions;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* loaded from: classes4.dex */
public final class CookieUtil {
    private CookieUtil() {
    }

    private static boolean a(Boolean bool) {
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return false;
    }

    public static String getCookieUrl(String str, Boolean bool) {
        String str2;
        Preconditions.checkNotEmpty(str);
        if (a(bool)) {
            str2 = ProxyConfig.MATCH_HTTPS;
        } else {
            str2 = "http";
        }
        StringBuilder sb = new StringBuilder(str2.length() + 3 + String.valueOf(str).length());
        sb.append(str2);
        sb.append("://");
        sb.append(str);
        return sb.toString();
    }

    public static String getCookieValue(String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, Long l4) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(SignatureVisitor.INSTANCEOF);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        if (a(bool)) {
            sb.append(";HttpOnly");
        }
        if (a(bool2)) {
            sb.append(";Secure");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(";Domain=");
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(";Path=");
            sb.append(str4);
        }
        if (l4 != null && l4.longValue() > 0) {
            sb.append(";Max-Age=");
            sb.append(l4);
        }
        return sb.toString();
    }
}
