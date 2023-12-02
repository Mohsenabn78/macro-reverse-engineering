package com.koushikdutta.async.http.cache;

/* loaded from: classes6.dex */
final class HeaderParser {

    /* loaded from: classes6.dex */
    public interface CacheControlHandler {
        void handle(String str, String str2);
    }

    public static void a(String str, CacheControlHandler cacheControlHandler) {
        int c4;
        String trim;
        if (str == null) {
            return;
        }
        int i4 = 0;
        while (i4 < str.length()) {
            int c5 = c(str, i4, "=,");
            String trim2 = str.substring(i4, c5).trim();
            if (c5 != str.length() && str.charAt(c5) != ',') {
                int d4 = d(str, c5 + 1);
                if (d4 < str.length() && str.charAt(d4) == '\"') {
                    int i5 = d4 + 1;
                    int c6 = c(str, i5, "\"");
                    trim = str.substring(i5, c6);
                    c4 = c6 + 1;
                } else {
                    c4 = c(str, d4, ",");
                    trim = str.substring(d4, c4).trim();
                }
                cacheControlHandler.handle(trim2, trim);
                i4 = c4;
            } else {
                cacheControlHandler.handle(trim2, null);
                i4 = c5 + 1;
            }
        }
    }

    public static int b(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private static int c(String str, int i4, String str2) {
        while (i4 < str.length() && str2.indexOf(str.charAt(i4)) == -1) {
            i4++;
        }
        return i4;
    }

    private static int d(String str, int i4) {
        char charAt;
        while (i4 < str.length() && ((charAt = str.charAt(i4)) == ' ' || charAt == '\t')) {
            i4++;
        }
        return i4;
    }
}
