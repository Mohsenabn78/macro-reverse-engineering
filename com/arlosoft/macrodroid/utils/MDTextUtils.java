package com.arlosoft.macrodroid.utils;

import android.text.Html;
import android.text.Spanned;

/* loaded from: classes3.dex */
public class MDTextUtils {
    public static Spanned fromHtml(String str) {
        return Html.fromHtml(str);
    }

    public static Spanned fromHtmlEscaped(String str) {
        return Html.fromHtml(str.replace("<", "&lt"));
    }

    public static String truncateIfRequired(String str, int i4) {
        if (str != null && str.length() > i4) {
            return str.substring(0, i4) + "..";
        }
        return str;
    }

    public static String truncateListIfRequired(String str, int i4) {
        if (str == null) {
            return "";
        }
        if (str.startsWith("[") && str.endsWith("]")) {
            str = str.substring(1, str.length() - 1);
        }
        if (str != null && str.length() > i4) {
            return str.substring(0, i4) + "..";
        }
        return str;
    }

    public static String escaped(String str) {
        return str;
    }
}
