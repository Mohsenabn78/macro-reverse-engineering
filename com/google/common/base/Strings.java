package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Strings {
    private Strings() {
    }

    private static String a(@CheckForNull Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e4) {
            String str = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str, (Throwable) e4);
            return "<" + str + " threw " + e4.getClass().getName() + ">";
        }
    }

    @VisibleForTesting
    static boolean b(CharSequence charSequence, int i4) {
        if (i4 >= 0 && i4 <= charSequence.length() - 2 && Character.isHighSurrogate(charSequence.charAt(i4)) && Character.isLowSurrogate(charSequence.charAt(i4 + 1))) {
            return true;
        }
        return false;
    }

    public static String commonPrefix(CharSequence charSequence, CharSequence charSequence2) {
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(charSequence2);
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i4 = 0;
        while (i4 < min && charSequence.charAt(i4) == charSequence2.charAt(i4)) {
            i4++;
        }
        int i5 = i4 - 1;
        if (b(charSequence, i5) || b(charSequence2, i5)) {
            i4--;
        }
        return charSequence.subSequence(0, i4).toString();
    }

    public static String commonSuffix(CharSequence charSequence, CharSequence charSequence2) {
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(charSequence2);
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i4 = 0;
        while (i4 < min && charSequence.charAt((charSequence.length() - i4) - 1) == charSequence2.charAt((charSequence2.length() - i4) - 1)) {
            i4++;
        }
        if (b(charSequence, (charSequence.length() - i4) - 1) || b(charSequence2, (charSequence2.length() - i4) - 1)) {
            i4--;
        }
        return charSequence.subSequence(charSequence.length() - i4, charSequence.length()).toString();
    }

    @CheckForNull
    public static String emptyToNull(@CheckForNull String str) {
        return Platform.b(str);
    }

    public static boolean isNullOrEmpty(@CheckForNull String str) {
        return Platform.h(str);
    }

    public static String lenientFormat(@CheckForNull String str, @CheckForNull Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i4 = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i5 = 0; i5 < objArr.length; i5++) {
                objArr[i5] = a(objArr[i5]);
            }
        }
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i6 = 0;
        while (i4 < objArr.length && (indexOf = valueOf.indexOf("%s", i6)) != -1) {
            sb.append((CharSequence) valueOf, i6, indexOf);
            sb.append(objArr[i4]);
            i6 = indexOf + 2;
            i4++;
        }
        sb.append((CharSequence) valueOf, i6, valueOf.length());
        if (i4 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i4]);
            for (int i7 = i4 + 1; i7 < objArr.length; i7++) {
                sb.append(", ");
                sb.append(objArr[i7]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static String nullToEmpty(@CheckForNull String str) {
        return Platform.f(str);
    }

    public static String padEnd(String str, int i4, char c4) {
        Preconditions.checkNotNull(str);
        if (str.length() >= i4) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i4);
        sb.append(str);
        for (int length = str.length(); length < i4; length++) {
            sb.append(c4);
        }
        return sb.toString();
    }

    public static String padStart(String str, int i4, char c4) {
        Preconditions.checkNotNull(str);
        if (str.length() >= i4) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i4);
        for (int length = str.length(); length < i4; length++) {
            sb.append(c4);
        }
        sb.append(str);
        return sb.toString();
    }

    public static String repeat(String str, int i4) {
        Preconditions.checkNotNull(str);
        boolean z3 = false;
        if (i4 <= 1) {
            if (i4 >= 0) {
                z3 = true;
            }
            Preconditions.checkArgument(z3, "invalid count: %s", i4);
            if (i4 == 0) {
                return "";
            }
            return str;
        }
        int length = str.length();
        long j4 = length * i4;
        int i5 = (int) j4;
        if (i5 == j4) {
            char[] cArr = new char[i5];
            str.getChars(0, length, cArr, 0);
            while (true) {
                int i6 = i5 - length;
                if (length < i6) {
                    System.arraycopy(cArr, 0, cArr, length, length);
                    length <<= 1;
                } else {
                    System.arraycopy(cArr, 0, cArr, length, i6);
                    return new String(cArr);
                }
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("Required array size too large: " + j4);
        }
    }
}
