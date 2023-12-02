package com.google.api.client.util.escape;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* loaded from: classes5.dex */
public class PercentEscaper extends UnicodeEscaper {
    public static final String SAFECHARS_URLENCODER = "-_.*";
    public static final String SAFEPATHCHARS_URLENCODER = "-_.!~*'()@:$&,;=";
    public static final String SAFEQUERYSTRINGCHARS_URLENCODER = "-_.!~*'()@:$,;/?:";
    public static final String SAFEUSERINFOCHARS_URLENCODER = "-_.!~*'():$&,;=";
    public static final String SAFE_PLUS_RESERVED_CHARS_URLENCODER = "-_.!~*'()@:$&,;=+/?";

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f26161c = {SignatureVisitor.EXTENDS};

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f26162d = "0123456789ABCDEF".toCharArray();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f26163a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean[] f26164b;

    public PercentEscaper(String str, boolean z3) {
        if (!str.matches(".*[0-9A-Za-z].*")) {
            if (z3 && str.contains(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)) {
                throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
            }
            if (!str.contains("%")) {
                this.f26163a = z3;
                this.f26164b = f(str);
                return;
            }
            throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
        }
        throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
    }

    private static boolean[] f(String str) {
        char[] charArray = str.toCharArray();
        int i4 = 122;
        for (char c4 : charArray) {
            i4 = Math.max((int) c4, i4);
        }
        boolean[] zArr = new boolean[i4 + 1];
        for (int i5 = 48; i5 <= 57; i5++) {
            zArr[i5] = true;
        }
        for (int i6 = 65; i6 <= 90; i6++) {
            zArr[i6] = true;
        }
        for (int i7 = 97; i7 <= 122; i7++) {
            zArr[i7] = true;
        }
        for (char c5 : charArray) {
            zArr[c5] = true;
        }
        return zArr;
    }

    @Override // com.google.api.client.util.escape.UnicodeEscaper
    protected char[] b(int i4) {
        boolean[] zArr = this.f26164b;
        if (i4 < zArr.length && zArr[i4]) {
            return null;
        }
        if (i4 == 32 && this.f26163a) {
            return f26161c;
        }
        if (i4 <= 127) {
            char[] cArr = f26162d;
            return new char[]{'%', cArr[i4 >>> 4], cArr[i4 & 15]};
        } else if (i4 <= 2047) {
            char[] cArr2 = f26162d;
            char[] cArr3 = {'%', cArr2[(r14 >>> 4) | 12], cArr2[r14 & 15], '%', cArr2[(r14 & 3) | 8], cArr2[i4 & 15]};
            int i5 = i4 >>> 4;
            int i6 = i5 >>> 2;
            return cArr3;
        } else if (i4 <= 65535) {
            char[] cArr4 = f26162d;
            char[] cArr5 = {'%', 'E', cArr4[r14 >>> 2], '%', cArr4[(r14 & 3) | 8], cArr4[r14 & 15], '%', cArr4[(r14 & 3) | 8], cArr4[i4 & 15]};
            int i7 = i4 >>> 4;
            int i8 = i7 >>> 2;
            int i9 = i8 >>> 4;
            return cArr5;
        } else if (i4 <= 1114111) {
            char[] cArr6 = f26162d;
            char[] cArr7 = {'%', 'F', cArr6[(r14 >>> 2) & 7], '%', cArr6[(r14 & 3) | 8], cArr6[r14 & 15], '%', cArr6[(r14 & 3) | 8], cArr6[r14 & 15], '%', cArr6[(r14 & 3) | 8], cArr6[i4 & 15]};
            int i10 = i4 >>> 4;
            int i11 = i10 >>> 2;
            int i12 = i11 >>> 4;
            int i13 = i12 >>> 2;
            int i14 = i13 >>> 4;
            return cArr7;
        } else {
            StringBuilder sb = new StringBuilder(43);
            sb.append("Invalid unicode character value ");
            sb.append(i4);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    @Override // com.google.api.client.util.escape.UnicodeEscaper
    protected int e(CharSequence charSequence, int i4, int i5) {
        while (i4 < i5) {
            char charAt = charSequence.charAt(i4);
            boolean[] zArr = this.f26164b;
            if (charAt >= zArr.length || !zArr[charAt]) {
                break;
            }
            i4++;
        }
        return i4;
    }

    @Override // com.google.api.client.util.escape.UnicodeEscaper, com.google.api.client.util.escape.Escaper
    public String escape(String str) {
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            boolean[] zArr = this.f26164b;
            if (charAt >= zArr.length || !zArr[charAt]) {
                return c(str, i4);
            }
        }
        return str;
    }
}
