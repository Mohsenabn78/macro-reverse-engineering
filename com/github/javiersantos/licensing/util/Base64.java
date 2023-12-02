package com.github.javiersantos.licensing.util;

import android.annotation.SuppressLint;
import com.facebook.stetho.dumpapp.Framer;
import com.google.common.base.Ascii;
import okio.Utf8;
import org.objenesis.instantiator.util.ClassDefinitionUtils;

/* loaded from: classes3.dex */
public class Base64 {
    public static final boolean DECODE = false;
    public static final boolean ENCODE = true;

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f18403a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, ClassDefinitionUtils.OPS_dup, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f18404b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, ClassDefinitionUtils.OPS_dup, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_REQUEST_FRAME_PREFIX};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f18405c = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, kotlin.io.encoding.Base64.padSymbol, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, 22, Ascii.ETB, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, -9, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, ClassDefinitionUtils.OPS_aload_0, 43, 44, Framer.STDIN_FRAME_PREFIX, 46, 47, 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, -9, -9, -9, -9, -9};

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f18406d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, kotlin.io.encoding.Base64.padSymbol, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, 22, Ascii.ETB, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, Utf8.REPLACEMENT_BYTE, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, ClassDefinitionUtils.OPS_aload_0, 43, 44, Framer.STDIN_FRAME_PREFIX, 46, 47, 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, -9, -9, -9, -9, -9};

    private Base64() {
    }

    private static int a(byte[] bArr, int i4, byte[] bArr2, int i5, byte[] bArr3) {
        byte b4 = bArr[i4 + 2];
        if (b4 == 61) {
            bArr2[i5] = (byte) ((((bArr3[bArr[i4 + 1]] << Ascii.CAN) >>> 12) | ((bArr3[bArr[i4]] << Ascii.CAN) >>> 6)) >>> 16);
            return 1;
        }
        byte b5 = bArr[i4 + 3];
        if (b5 == 61) {
            int i6 = ((bArr3[bArr[i4 + 1]] << Ascii.CAN) >>> 12) | ((bArr3[bArr[i4]] << Ascii.CAN) >>> 6) | ((bArr3[b4] << Ascii.CAN) >>> 18);
            bArr2[i5] = (byte) (i6 >>> 16);
            bArr2[i5 + 1] = (byte) (i6 >>> 8);
            return 2;
        }
        int i7 = ((bArr3[bArr[i4 + 1]] << Ascii.CAN) >>> 12) | ((bArr3[bArr[i4]] << Ascii.CAN) >>> 6) | ((bArr3[b4] << Ascii.CAN) >>> 18) | ((bArr3[b5] << Ascii.CAN) >>> 24);
        bArr2[i5] = (byte) (i7 >> 16);
        bArr2[i5 + 1] = (byte) (i7 >> 8);
        bArr2[i5 + 2] = (byte) i7;
        return 3;
    }

    private static byte[] b(byte[] bArr, int i4, int i5, byte[] bArr2, int i6, byte[] bArr3) {
        int i7;
        int i8;
        int i9 = 0;
        if (i5 > 0) {
            i7 = (bArr[i4] << Ascii.CAN) >>> 8;
        } else {
            i7 = 0;
        }
        if (i5 > 1) {
            i8 = (bArr[i4 + 1] << Ascii.CAN) >>> 16;
        } else {
            i8 = 0;
        }
        int i10 = i7 | i8;
        if (i5 > 2) {
            i9 = (bArr[i4 + 2] << Ascii.CAN) >>> 24;
        }
        int i11 = i10 | i9;
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 3) {
                    return bArr2;
                }
                bArr2[i6] = bArr3[i11 >>> 18];
                bArr2[i6 + 1] = bArr3[(i11 >>> 12) & 63];
                bArr2[i6 + 2] = bArr3[(i11 >>> 6) & 63];
                bArr2[i6 + 3] = bArr3[i11 & 63];
                return bArr2;
            }
            bArr2[i6] = bArr3[i11 >>> 18];
            bArr2[i6 + 1] = bArr3[(i11 >>> 12) & 63];
            bArr2[i6 + 2] = bArr3[(i11 >>> 6) & 63];
            bArr2[i6 + 3] = kotlin.io.encoding.Base64.padSymbol;
            return bArr2;
        }
        bArr2[i6] = bArr3[i11 >>> 18];
        bArr2[i6 + 1] = bArr3[(i11 >>> 12) & 63];
        bArr2[i6 + 2] = kotlin.io.encoding.Base64.padSymbol;
        bArr2[i6 + 3] = kotlin.io.encoding.Base64.padSymbol;
        return bArr2;
    }

    public static byte[] decode(String str) throws Base64DecoderException {
        byte[] bytes = str.getBytes();
        return decode(bytes, 0, bytes.length);
    }

    public static byte[] decodeWebSafe(String str) throws Base64DecoderException {
        byte[] bytes = str.getBytes();
        return decodeWebSafe(bytes, 0, bytes.length);
    }

    public static String encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length, f18403a, true);
    }

    public static String encodeWebSafe(byte[] bArr, boolean z3) {
        return encode(bArr, 0, bArr.length, f18404b, z3);
    }

    public static String encode(byte[] bArr, int i4, int i5, byte[] bArr2, boolean z3) {
        byte[] encode = encode(bArr, i4, i5, bArr2, Integer.MAX_VALUE);
        int length = encode.length;
        while (!z3 && length > 0 && encode[length - 1] == 61) {
            length--;
        }
        return new String(encode, 0, length);
    }

    public static byte[] decode(byte[] bArr) throws Base64DecoderException {
        return decode(bArr, 0, bArr.length);
    }

    public static byte[] decodeWebSafe(byte[] bArr) throws Base64DecoderException {
        return decodeWebSafe(bArr, 0, bArr.length);
    }

    public static byte[] decode(byte[] bArr, int i4, int i5) throws Base64DecoderException {
        return decode(bArr, i4, i5, f18405c);
    }

    public static byte[] decodeWebSafe(byte[] bArr, int i4, int i5) throws Base64DecoderException {
        return decode(bArr, i4, i5, f18406d);
    }

    public static byte[] decode(byte[] bArr, int i4, int i5, byte[] bArr2) throws Base64DecoderException {
        byte[] bArr3 = new byte[((i5 * 3) / 4) + 2];
        byte[] bArr4 = new byte[4];
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (i6 >= i5) {
                break;
            }
            int i9 = i6 + i4;
            byte b4 = (byte) (bArr[i9] & Byte.MAX_VALUE);
            byte b5 = bArr2[b4];
            if (b5 < -5) {
                throw new Base64DecoderException("Bad Base64 input character at " + i6 + ": " + ((int) bArr[i9]) + "(decimal)");
            }
            if (b5 >= -1) {
                if (b4 == 61) {
                    int i10 = i5 - i6;
                    byte b6 = (byte) (bArr[(i5 - 1) + i4] & Byte.MAX_VALUE);
                    if (i7 == 0 || i7 == 1) {
                        throw new Base64DecoderException("invalid padding byte '=' at byte offset " + i6);
                    } else if ((i7 == 3 && i10 > 2) || (i7 == 4 && i10 > 1)) {
                        throw new Base64DecoderException("padding byte '=' falsely signals end of encoded value at offset " + i6);
                    } else if (b6 != 61 && b6 != 10) {
                        throw new Base64DecoderException("encoded value has invalid trailing byte");
                    }
                } else {
                    int i11 = i7 + 1;
                    bArr4[i7] = b4;
                    if (i11 == 4) {
                        i8 += a(bArr4, 0, bArr3, i8, bArr2);
                        i7 = 0;
                    } else {
                        i7 = i11;
                    }
                }
            }
            i6++;
        }
        if (i7 != 0) {
            if (i7 != 1) {
                bArr4[i7] = kotlin.io.encoding.Base64.padSymbol;
                i8 += a(bArr4, 0, bArr3, i8, bArr2);
            } else {
                throw new Base64DecoderException("single trailing character at offset " + (i5 - 1));
            }
        }
        byte[] bArr5 = new byte[i8];
        System.arraycopy(bArr3, 0, bArr5, 0, i8);
        return bArr5;
    }

    @SuppressLint({"Assert"})
    public static byte[] encode(byte[] bArr, int i4, int i5, byte[] bArr2, int i6) {
        int i7 = ((i5 + 2) / 3) * 4;
        byte[] bArr3 = new byte[i7 + (i7 / i6)];
        int i8 = i5 - 2;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i9 < i8) {
            int i12 = ((bArr[i9 + i4] << Ascii.CAN) >>> 8) | ((bArr[(i9 + 1) + i4] << Ascii.CAN) >>> 16) | ((bArr[(i9 + 2) + i4] << Ascii.CAN) >>> 24);
            bArr3[i10] = bArr2[i12 >>> 18];
            int i13 = i10 + 1;
            bArr3[i13] = bArr2[(i12 >>> 12) & 63];
            bArr3[i10 + 2] = bArr2[(i12 >>> 6) & 63];
            bArr3[i10 + 3] = bArr2[i12 & 63];
            i11 += 4;
            if (i11 == i6) {
                bArr3[i10 + 4] = 10;
                i10 = i13;
                i11 = 0;
            }
            i9 += 3;
            i10 += 4;
        }
        if (i9 < i5) {
            b(bArr, i9 + i4, i5 - i9, bArr3, i10, bArr2);
            if (i11 + 4 == i6) {
                bArr3[i10 + 4] = 10;
            }
        }
        return bArr3;
    }
}
