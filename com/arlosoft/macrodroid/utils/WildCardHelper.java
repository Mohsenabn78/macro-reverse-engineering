package com.arlosoft.macrodroid.utils;

import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import net.bytebuddy.description.type.TypeDescription;

/* loaded from: classes3.dex */
public class WildCardHelper {

    /* renamed from: a  reason: collision with root package name */
    private static Pattern f16091a = Pattern.compile("[{}()\\[\\].+^$\\\\|]");

    private static String a(String str) {
        return f16091a.matcher(str).replaceAll("\\\\$0");
    }

    private static boolean b(String str, String str2) {
        try {
            return str.matches(str2);
        } catch (PatternSyntaxException e4) {
            SystemLog.logErrorDontTrigger("Error with regex, you may need to escape a special character (for example if matching the + character then you should write \\+) : " + e4);
            return false;
        }
    }

    public static String getContainsPattern(String str, boolean z3) {
        if (z3) {
            str = str.toLowerCase();
        }
        String a4 = a(str);
        return "(?s)".concat(".*") + a4.replace("*", ".*").replace("..*", ".*").replace(TypeDescription.Generic.OfWildcardType.SYMBOL, ".").concat(".*");
    }

    public static String getPattern(String str, boolean z3) {
        if (z3) {
            str = str.toLowerCase();
        }
        return "(?s)".concat(a(str).replace("*", ".*").replace("..*", ".*").replace(TypeDescription.Generic.OfWildcardType.SYMBOL, "."));
    }

    public static String getRegexContainsPattern(String str, boolean z3) {
        return getRegexContainsPattern(str, z3, false);
    }

    public static String getRegexPattern(String str, boolean z3) {
        return getRegexPattern(str, z3, false);
    }

    public static boolean matches(String str, String str2, boolean z3) {
        return matches(str, str2, z3, true);
    }

    public static String getRegexContainsPattern(String str, boolean z3, boolean z4) {
        if (z3) {
            return "(?s)".concat(str);
        }
        return getContainsPattern(str, z4);
    }

    public static String getRegexPattern(String str, boolean z3, boolean z4) {
        if (z3) {
            return "(?s)".concat(str);
        }
        return getPattern(str, z4);
    }

    public static boolean matches(String str, String str2, boolean z3, boolean z4) {
        if (!z3) {
            if (z4) {
                str = str.toLowerCase();
            }
            return b(str, str2);
        }
        try {
            return Pattern.compile(str2).matcher(str).find();
        } catch (PatternSyntaxException e4) {
            SystemLog.logErrorDontTrigger("Error with regex, you may need to escape a special character (for example if matching the + character then you should write \\+) : " + e4);
            return false;
        }
    }
}
