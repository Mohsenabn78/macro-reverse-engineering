package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import com.google.api.client.repackaged.com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes5.dex */
public final class Strings {
    private Strings() {
    }

    @VisibleForTesting
    static boolean a(CharSequence charSequence, int i4) {
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
        if (a(charSequence, i5) || a(charSequence2, i5)) {
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
        if (a(charSequence, (charSequence.length() - i4) - 1) || a(charSequence2, (charSequence2.length() - i4) - 1)) {
            i4--;
        }
        return charSequence.subSequence(charSequence.length() - i4, charSequence.length()).toString();
    }

    @Nullable
    public static String emptyToNull(@Nullable String str) {
        if (isNullOrEmpty(str)) {
            return null;
        }
        return str;
    }

    public static boolean isNullOrEmpty(@Nullable String str) {
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }

    public static String nullToEmpty(@Nullable String str) {
        if (str == null) {
            return "";
        }
        return str;
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
        boolean z3;
        Preconditions.checkNotNull(str);
        if (i4 <= 1) {
            if (i4 >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "invalid count: %s", Integer.valueOf(i4));
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
