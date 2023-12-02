package com.google.common.net;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.escape.UnicodeEscaper;
import javax.annotation.CheckForNull;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class PercentEscaper extends UnicodeEscaper {

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f28133d = {SignatureVisitor.EXTENDS};

    /* renamed from: e  reason: collision with root package name */
    private static final char[] f28134e = "0123456789ABCDEF".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    private final boolean f28135b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean[] f28136c;

    public PercentEscaper(String str, boolean z3) {
        Preconditions.checkNotNull(str);
        if (!str.matches(".*[0-9A-Za-z].*")) {
            String str2 = str + "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            if (z3 && str2.contains(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)) {
                throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
            }
            this.f28135b = z3;
            this.f28136c = f(str2);
            return;
        }
        throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
    }

    private static boolean[] f(String str) {
        char[] charArray = str.toCharArray();
        int i4 = -1;
        for (char c4 : charArray) {
            i4 = Math.max((int) c4, i4);
        }
        boolean[] zArr = new boolean[i4 + 1];
        for (char c5 : charArray) {
            zArr[c5] = true;
        }
        return zArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.escape.UnicodeEscaper
    @CheckForNull
    public char[] b(int i4) {
        boolean[] zArr = this.f28136c;
        if (i4 < zArr.length && zArr[i4]) {
            return null;
        }
        if (i4 == 32 && this.f28135b) {
            return f28133d;
        }
        if (i4 <= 127) {
            char[] cArr = f28134e;
            return new char[]{'%', cArr[i4 >>> 4], cArr[i4 & 15]};
        } else if (i4 <= 2047) {
            char[] cArr2 = f28134e;
            char[] cArr3 = {'%', cArr2[(r14 >>> 4) | 12], cArr2[r14 & 15], '%', cArr2[(r14 & 3) | 8], cArr2[i4 & 15]};
            int i5 = i4 >>> 4;
            int i6 = i5 >>> 2;
            return cArr3;
        } else if (i4 <= 65535) {
            char[] cArr4 = f28134e;
            char[] cArr5 = {'%', 'E', cArr4[r14 >>> 2], '%', cArr4[(r14 & 3) | 8], cArr4[r14 & 15], '%', cArr4[(r14 & 3) | 8], cArr4[i4 & 15]};
            int i7 = i4 >>> 4;
            int i8 = i7 >>> 2;
            int i9 = i8 >>> 4;
            return cArr5;
        } else if (i4 <= 1114111) {
            char[] cArr6 = f28134e;
            char[] cArr7 = {'%', 'F', cArr6[(r14 >>> 2) & 7], '%', cArr6[(r14 & 3) | 8], cArr6[r14 & 15], '%', cArr6[(r14 & 3) | 8], cArr6[r14 & 15], '%', cArr6[(r14 & 3) | 8], cArr6[i4 & 15]};
            int i10 = i4 >>> 4;
            int i11 = i10 >>> 2;
            int i12 = i11 >>> 4;
            int i13 = i12 >>> 2;
            int i14 = i13 >>> 4;
            return cArr7;
        } else {
            throw new IllegalArgumentException("Invalid unicode character value " + i4);
        }
    }

    @Override // com.google.common.escape.UnicodeEscaper
    protected int e(CharSequence charSequence, int i4, int i5) {
        Preconditions.checkNotNull(charSequence);
        while (i4 < i5) {
            char charAt = charSequence.charAt(i4);
            boolean[] zArr = this.f28136c;
            if (charAt >= zArr.length || !zArr[charAt]) {
                break;
            }
            i4++;
        }
        return i4;
    }

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
    public String escape(String str) {
        Preconditions.checkNotNull(str);
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            boolean[] zArr = this.f28136c;
            if (charAt >= zArr.length || !zArr[charAt]) {
                return c(str, i4);
            }
        }
        return str;
    }
}
