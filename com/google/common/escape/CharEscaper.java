package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class CharEscaper extends Escaper {
    private static char[] c(char[] cArr, int i4, int i5) {
        if (i5 >= 0) {
            char[] cArr2 = new char[i5];
            if (i4 > 0) {
                System.arraycopy(cArr, 0, cArr2, 0, i4);
            }
            return cArr2;
        }
        throw new AssertionError("Cannot increase internal buffer any further");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CheckForNull
    public abstract char[] a(char c4);

    /* JADX INFO: Access modifiers changed from: protected */
    public final String b(String str, int i4) {
        int length = str.length();
        char[] a4 = Platform.a();
        int length2 = a4.length;
        int i5 = 0;
        int i6 = 0;
        while (i4 < length) {
            char[] a5 = a(str.charAt(i4));
            if (a5 != null) {
                int length3 = a5.length;
                int i7 = i4 - i5;
                int i8 = i6 + i7;
                int i9 = i8 + length3;
                if (length2 < i9) {
                    length2 = ((length - i4) * 2) + i9;
                    a4 = c(a4, i6, length2);
                }
                if (i7 > 0) {
                    str.getChars(i5, i4, a4, i6);
                    i6 = i8;
                }
                if (length3 > 0) {
                    System.arraycopy(a5, 0, a4, i6, length3);
                    i6 += length3;
                }
                i5 = i4 + 1;
            }
            i4++;
        }
        int i10 = length - i5;
        if (i10 > 0) {
            int i11 = i10 + i6;
            if (length2 < i11) {
                a4 = c(a4, i6, i11);
            }
            str.getChars(i5, length, a4, i6);
            i6 = i11;
        }
        return new String(a4, 0, i6);
    }

    @Override // com.google.common.escape.Escaper
    public String escape(String str) {
        Preconditions.checkNotNull(str);
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            if (a(str.charAt(i4)) != null) {
                return b(str, i4);
            }
        }
        return str;
    }
}
