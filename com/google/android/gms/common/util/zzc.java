package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
final class zzc {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f20755a = Pattern.compile("\\\\u[0-9a-fA-F]{4}");

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = f20755a.matcher(str);
            int i4 = 0;
            StringBuilder sb = null;
            while (matcher.find()) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                int start = matcher.start();
                int i5 = start;
                while (i5 >= 0 && str.charAt(i5) == '\\') {
                    i5--;
                }
                if ((start - i5) % 2 != 0) {
                    int parseInt = Integer.parseInt(matcher.group().substring(2), 16);
                    sb.append((CharSequence) str, i4, matcher.start());
                    if (parseInt == 92) {
                        sb.append("\\\\");
                    } else {
                        sb.append(Character.toChars(parseInt));
                    }
                    i4 = matcher.end();
                }
            }
            if (sb == null) {
                return str;
            }
            if (i4 < matcher.regionEnd()) {
                sb.append((CharSequence) str, i4, matcher.regionEnd());
            }
            return sb.toString();
        }
        return str;
    }
}
