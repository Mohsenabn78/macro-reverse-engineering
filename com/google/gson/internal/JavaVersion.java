package com.google.gson.internal;

/* loaded from: classes5.dex */
public final class JavaVersion {

    /* renamed from: a  reason: collision with root package name */
    private static final int f32639a = a();

    private JavaVersion() {
    }

    private static int a() {
        return c(System.getProperty("java.version"));
    }

    private static int b(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i4 = 0; i4 < str.length(); i4++) {
                char charAt = str.charAt(i4);
                if (!Character.isDigit(charAt)) {
                    break;
                }
                sb.append(charAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    static int c(String str) {
        int d4 = d(str);
        if (d4 == -1) {
            d4 = b(str);
        }
        if (d4 == -1) {
            return 6;
        }
        return d4;
    }

    private static int d(String str) {
        try {
            String[] split = str.split("[._]");
            int parseInt = Integer.parseInt(split[0]);
            if (parseInt == 1 && split.length > 1) {
                return Integer.parseInt(split[1]);
            }
            return parseInt;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int getMajorJavaVersion() {
        return f32639a;
    }

    public static boolean isJava9OrLater() {
        if (f32639a >= 9) {
            return true;
        }
        return false;
    }
}
