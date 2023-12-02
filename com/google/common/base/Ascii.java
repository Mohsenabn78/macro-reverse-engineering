package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Ascii {
    public static final byte ACK = 6;
    public static final byte BEL = 7;
    public static final byte BS = 8;
    public static final byte CAN = 24;
    public static final byte CR = 13;
    public static final byte DC1 = 17;
    public static final byte DC2 = 18;
    public static final byte DC3 = 19;
    public static final byte DC4 = 20;
    public static final byte DEL = Byte.MAX_VALUE;
    public static final byte DLE = 16;
    public static final byte EM = 25;
    public static final byte ENQ = 5;
    public static final byte EOT = 4;
    public static final byte ESC = 27;
    public static final byte ETB = 23;
    public static final byte ETX = 3;
    public static final byte FF = 12;
    public static final byte FS = 28;
    public static final byte GS = 29;
    public static final byte HT = 9;
    public static final byte LF = 10;
    public static final char MAX = 127;
    public static final char MIN = 0;
    public static final byte NAK = 21;
    public static final byte NL = 10;
    public static final byte NUL = 0;
    public static final byte RS = 30;
    public static final byte SI = 15;
    public static final byte SO = 14;
    public static final byte SOH = 1;
    public static final byte SP = 32;
    public static final byte SPACE = 32;
    public static final byte STX = 2;
    public static final byte SUB = 26;
    public static final byte SYN = 22;
    public static final byte US = 31;
    public static final byte VT = 11;
    public static final byte XOFF = 19;
    public static final byte XON = 17;

    private Ascii() {
    }

    private static int a(char c4) {
        return (char) ((c4 | ' ') - 97);
    }

    public static boolean equalsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        int a4;
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = charSequence.charAt(i4);
            char charAt2 = charSequence2.charAt(i4);
            if (charAt != charAt2 && ((a4 = a(charAt)) >= 26 || a4 != a(charAt2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLowerCase(char c4) {
        if (c4 >= 'a' && c4 <= 'z') {
            return true;
        }
        return false;
    }

    public static boolean isUpperCase(char c4) {
        if (c4 >= 'A' && c4 <= 'Z') {
            return true;
        }
        return false;
    }

    public static String toLowerCase(String str) {
        int length = str.length();
        int i4 = 0;
        while (i4 < length) {
            if (isUpperCase(str.charAt(i4))) {
                char[] charArray = str.toCharArray();
                while (i4 < length) {
                    char c4 = charArray[i4];
                    if (isUpperCase(c4)) {
                        charArray[i4] = (char) (c4 ^ ' ');
                    }
                    i4++;
                }
                return String.valueOf(charArray);
            }
            i4++;
        }
        return str;
    }

    public static String toUpperCase(String str) {
        int length = str.length();
        int i4 = 0;
        while (i4 < length) {
            if (isLowerCase(str.charAt(i4))) {
                char[] charArray = str.toCharArray();
                while (i4 < length) {
                    char c4 = charArray[i4];
                    if (isLowerCase(c4)) {
                        charArray[i4] = (char) (c4 ^ ' ');
                    }
                    i4++;
                }
                return String.valueOf(charArray);
            }
            i4++;
        }
        return str;
    }

    public static String truncate(CharSequence charSequence, int i4, String str) {
        boolean z3;
        Preconditions.checkNotNull(charSequence);
        int length = i4 - str.length();
        if (length >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "maxLength (%s) must be >= length of the truncation indicator (%s)", i4, str.length());
        int length2 = charSequence.length();
        String str2 = charSequence;
        if (length2 <= i4) {
            String charSequence2 = charSequence.toString();
            int length3 = charSequence2.length();
            str2 = charSequence2;
            if (length3 <= i4) {
                return charSequence2;
            }
        }
        StringBuilder sb = new StringBuilder(i4);
        sb.append((CharSequence) str2, 0, length);
        sb.append(str);
        return sb.toString();
    }

    public static String toLowerCase(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return toLowerCase((String) charSequence);
        }
        int length = charSequence.length();
        char[] cArr = new char[length];
        for (int i4 = 0; i4 < length; i4++) {
            cArr[i4] = toLowerCase(charSequence.charAt(i4));
        }
        return String.valueOf(cArr);
    }

    public static String toUpperCase(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return toUpperCase((String) charSequence);
        }
        int length = charSequence.length();
        char[] cArr = new char[length];
        for (int i4 = 0; i4 < length; i4++) {
            cArr[i4] = toUpperCase(charSequence.charAt(i4));
        }
        return String.valueOf(cArr);
    }

    public static char toLowerCase(char c4) {
        return isUpperCase(c4) ? (char) (c4 ^ ' ') : c4;
    }

    public static char toUpperCase(char c4) {
        return isLowerCase(c4) ? (char) (c4 ^ ' ') : c4;
    }
}
