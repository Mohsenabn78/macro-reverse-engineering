package com.fasterxml.jackson.core.io;

import com.android.dx.io.Opcodes;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class CharTypes {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f17715a;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f17716b;

    /* renamed from: c  reason: collision with root package name */
    static final int[] f17717c;

    /* renamed from: d  reason: collision with root package name */
    static final int[] f17718d;

    /* renamed from: e  reason: collision with root package name */
    static final int[] f17719e;

    /* renamed from: f  reason: collision with root package name */
    static final int[] f17720f;

    /* renamed from: g  reason: collision with root package name */
    static final int[] f17721g;

    /* renamed from: h  reason: collision with root package name */
    static final int[] f17722h;

    /* renamed from: i  reason: collision with root package name */
    static final int[] f17723i;

    static {
        int i4;
        char[] charArray = "0123456789ABCDEF".toCharArray();
        f17715a = charArray;
        int length = charArray.length;
        f17716b = new byte[length];
        for (int i5 = 0; i5 < length; i5++) {
            f17716b[i5] = (byte) f17715a[i5];
        }
        int[] iArr = new int[256];
        for (int i6 = 0; i6 < 32; i6++) {
            iArr[i6] = -1;
        }
        iArr[34] = 1;
        iArr[92] = 1;
        f17717c = iArr;
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        for (int i7 = 128; i7 < 256; i7++) {
            if ((i7 & Opcodes.SHL_INT_LIT8) == 192) {
                i4 = 2;
            } else if ((i7 & 240) == 224) {
                i4 = 3;
            } else if ((i7 & 248) == 240) {
                i4 = 4;
            } else {
                i4 = -1;
            }
            iArr2[i7] = i4;
        }
        f17718d = iArr2;
        int[] iArr3 = new int[256];
        Arrays.fill(iArr3, -1);
        for (int i8 = 33; i8 < 256; i8++) {
            if (Character.isJavaIdentifierPart((char) i8)) {
                iArr3[i8] = 0;
            }
        }
        iArr3[64] = 0;
        iArr3[35] = 0;
        iArr3[42] = 0;
        iArr3[45] = 0;
        iArr3[43] = 0;
        f17719e = iArr3;
        int[] iArr4 = new int[256];
        System.arraycopy(iArr3, 0, iArr4, 0, iArr3.length);
        Arrays.fill(iArr4, 128, 128, 0);
        f17720f = iArr4;
        int[] iArr5 = new int[256];
        f17721g = iArr5;
        System.arraycopy(f17718d, 128, iArr5, 128, 128);
        Arrays.fill(iArr5, 0, 32, -1);
        iArr5[9] = 0;
        iArr5[10] = 10;
        iArr5[13] = 13;
        iArr5[42] = 42;
        int[] iArr6 = new int[128];
        for (int i9 = 0; i9 < 32; i9++) {
            iArr6[i9] = -1;
        }
        iArr6[34] = 34;
        iArr6[92] = 92;
        iArr6[8] = 98;
        iArr6[9] = 116;
        iArr6[12] = 102;
        iArr6[10] = 110;
        iArr6[13] = 114;
        f17722h = iArr6;
        int[] iArr7 = new int[128];
        f17723i = iArr7;
        Arrays.fill(iArr7, -1);
        for (int i10 = 0; i10 < 10; i10++) {
            f17723i[i10 + 48] = i10;
        }
        for (int i11 = 0; i11 < 6; i11++) {
            int[] iArr8 = f17723i;
            int i12 = i11 + 10;
            iArr8[i11 + 97] = i12;
            iArr8[i11 + 65] = i12;
        }
    }

    public static void appendQuoted(StringBuilder sb, String str) {
        int[] iArr = f17722h;
        int length = iArr.length;
        int length2 = str.length();
        for (int i4 = 0; i4 < length2; i4++) {
            char charAt = str.charAt(i4);
            if (charAt < length && iArr[charAt] != 0) {
                sb.append('\\');
                int i5 = iArr[charAt];
                if (i5 < 0) {
                    sb.append('u');
                    sb.append('0');
                    sb.append('0');
                    int i6 = -(i5 + 1);
                    char[] cArr = f17715a;
                    sb.append(cArr[i6 >> 4]);
                    sb.append(cArr[i6 & 15]);
                } else {
                    sb.append((char) i5);
                }
            } else {
                sb.append(charAt);
            }
        }
    }

    public static int charToHex(int i4) {
        if (i4 > 127) {
            return -1;
        }
        return f17723i[i4];
    }

    public static byte[] copyHexBytes() {
        return (byte[]) f17716b.clone();
    }

    public static char[] copyHexChars() {
        return (char[]) f17715a.clone();
    }

    public static int[] get7BitOutputEscapes() {
        return f17722h;
    }

    public static int[] getInputCodeComment() {
        return f17721g;
    }

    public static int[] getInputCodeLatin1() {
        return f17717c;
    }

    public static int[] getInputCodeLatin1JsNames() {
        return f17719e;
    }

    public static int[] getInputCodeUtf8() {
        return f17718d;
    }

    public static int[] getInputCodeUtf8JsNames() {
        return f17720f;
    }
}
