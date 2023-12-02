package com.evgenii.jsevaluator;

/* loaded from: classes3.dex */
public class JsFunctionCallFormatter {
    public static String paramToString(Object obj) {
        if (obj instanceof String) {
            return String.format("\"%s\"", ((String) obj).replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n"));
        }
        try {
            Double.parseDouble(obj.toString());
            return obj.toString();
        } catch (NumberFormatException unused) {
            return "";
        }
    }

    public static String toString(String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(paramToString(obj));
        }
        return String.format("%s(%s)", str, sb);
    }
}
