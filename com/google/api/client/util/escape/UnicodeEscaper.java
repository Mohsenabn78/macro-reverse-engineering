package com.google.api.client.util.escape;

/* loaded from: classes5.dex */
public abstract class UnicodeEscaper extends Escaper {
    protected static int a(CharSequence charSequence, int i4, int i5) {
        if (i4 < i5) {
            int i6 = i4 + 1;
            char charAt = charSequence.charAt(i4);
            if (charAt >= 55296 && charAt <= 57343) {
                if (charAt <= 56319) {
                    if (i6 == i5) {
                        return -charAt;
                    }
                    char charAt2 = charSequence.charAt(i6);
                    if (Character.isLowSurrogate(charAt2)) {
                        return Character.toCodePoint(charAt, charAt2);
                    }
                    StringBuilder sb = new StringBuilder(83);
                    sb.append("Expected low surrogate but got char '");
                    sb.append(charAt2);
                    sb.append("' with value ");
                    sb.append((int) charAt2);
                    sb.append(" at index ");
                    sb.append(i6);
                    throw new IllegalArgumentException(sb.toString());
                }
                StringBuilder sb2 = new StringBuilder(82);
                sb2.append("Unexpected low surrogate character '");
                sb2.append(charAt);
                sb2.append("' with value ");
                sb2.append((int) charAt);
                sb2.append(" at index ");
                sb2.append(i6 - 1);
                throw new IllegalArgumentException(sb2.toString());
            }
            return charAt;
        }
        throw new IndexOutOfBoundsException("Index exceeds specified range");
    }

    private static char[] d(char[] cArr, int i4, int i5) {
        char[] cArr2 = new char[i5];
        if (i4 > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i4);
        }
        return cArr2;
    }

    protected abstract char[] b(int i4);

    /* JADX INFO: Access modifiers changed from: protected */
    public final String c(String str, int i4) {
        int i5;
        int length = str.length();
        char[] a4 = Platform.a();
        int i6 = 0;
        int i7 = 0;
        while (i4 < length) {
            int a5 = a(str, i4, length);
            if (a5 >= 0) {
                char[] b4 = b(a5);
                if (Character.isSupplementaryCodePoint(a5)) {
                    i5 = 2;
                } else {
                    i5 = 1;
                }
                int i8 = i5 + i4;
                if (b4 != null) {
                    int i9 = i4 - i6;
                    int i10 = i7 + i9;
                    int length2 = b4.length + i10;
                    if (a4.length < length2) {
                        a4 = d(a4, i7, ((length2 + length) - i4) + 32);
                    }
                    if (i9 > 0) {
                        str.getChars(i6, i4, a4, i7);
                        i7 = i10;
                    }
                    if (b4.length > 0) {
                        System.arraycopy(b4, 0, a4, i7, b4.length);
                        i7 += b4.length;
                    }
                    i6 = i8;
                }
                i4 = e(str, i8, length);
            } else {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
        }
        int i11 = length - i6;
        if (i11 > 0) {
            int i12 = i11 + i7;
            if (a4.length < i12) {
                a4 = d(a4, i7, i12);
            }
            str.getChars(i6, length, a4, i7);
            i7 = i12;
        }
        return new String(a4, 0, i7);
    }

    protected abstract int e(CharSequence charSequence, int i4, int i5);

    @Override // com.google.api.client.util.escape.Escaper
    public abstract String escape(String str);
}
