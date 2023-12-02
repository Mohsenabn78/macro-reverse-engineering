package com.sun.mail.util;

import java.util.Properties;
import javax.mail.Session;

/* loaded from: classes6.dex */
public class PropUtil {
    private PropUtil() {
    }

    private static boolean getBoolean(Object obj, boolean z3) {
        if (obj == null) {
            return z3;
        }
        if (obj instanceof String) {
            if (z3) {
                return !((String) obj).equalsIgnoreCase("false");
            }
            return ((String) obj).equalsIgnoreCase("true");
        } else if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        } else {
            return z3;
        }
    }

    public static boolean getBooleanProperty(Properties properties, String str, boolean z3) {
        return getBoolean(getProp(properties, str), z3);
    }

    @Deprecated
    public static boolean getBooleanSessionProperty(Session session, String str, boolean z3) {
        return getBoolean(getProp(session.getProperties(), str), z3);
    }

    public static boolean getBooleanSystemProperty(String str, boolean z3) {
        try {
            try {
                return getBoolean(getProp(System.getProperties(), str), z3);
            } catch (SecurityException unused) {
                String property = System.getProperty(str);
                if (property == null) {
                    return z3;
                }
                if (z3) {
                    return !property.equalsIgnoreCase("false");
                }
                return property.equalsIgnoreCase("true");
            }
        } catch (SecurityException unused2) {
            return z3;
        }
    }

    private static int getInt(Object obj, int i4) {
        if (obj == null) {
            return i4;
        }
        if (obj instanceof String) {
            try {
                String str = (String) obj;
                if (str.startsWith("0x")) {
                    return Integer.parseInt(str.substring(2), 16);
                }
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
            }
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return i4;
    }

    public static int getIntProperty(Properties properties, String str, int i4) {
        return getInt(getProp(properties, str), i4);
    }

    @Deprecated
    public static int getIntSessionProperty(Session session, String str, int i4) {
        return getInt(getProp(session.getProperties(), str), i4);
    }

    private static Object getProp(Properties properties, String str) {
        Object obj = properties.get(str);
        if (obj != null) {
            return obj;
        }
        return properties.getProperty(str);
    }
}
