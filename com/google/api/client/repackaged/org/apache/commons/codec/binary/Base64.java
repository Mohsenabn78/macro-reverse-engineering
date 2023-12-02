package com.google.api.client.repackaged.org.apache.commons.codec.binary;

import com.facebook.stetho.dumpapp.Framer;
import com.google.common.base.Ascii;
import java.math.BigInteger;
import okio.Utf8;
import org.objenesis.instantiator.util.ClassDefinitionUtils;

/* loaded from: classes5.dex */
public class Base64 extends BaseNCodec {

    /* renamed from: r  reason: collision with root package name */
    static final byte[] f25992r = {Ascii.CR, 10};

    /* renamed from: s  reason: collision with root package name */
    private static final byte[] f25993s = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, ClassDefinitionUtils.OPS_dup, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: t  reason: collision with root package name */
    private static final byte[] f25994t = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, ClassDefinitionUtils.OPS_dup, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_REQUEST_FRAME_PREFIX};

    /* renamed from: u  reason: collision with root package name */
    private static final byte[] f25995u = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, kotlin.io.encoding.Base64.padSymbol, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, 22, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, ClassDefinitionUtils.OPS_aload_0, 43, 44, Framer.STDIN_FRAME_PREFIX, 46, 47, 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51};

    /* renamed from: l  reason: collision with root package name */
    private final byte[] f25996l;

    /* renamed from: m  reason: collision with root package name */
    private final byte[] f25997m;

    /* renamed from: n  reason: collision with root package name */
    private final byte[] f25998n;

    /* renamed from: o  reason: collision with root package name */
    private final int f25999o;

    /* renamed from: p  reason: collision with root package name */
    private final int f26000p;

    /* renamed from: q  reason: collision with root package name */
    private int f26001q;

    public Base64() {
        this(0);
    }

    public static byte[] decodeBase64(String str) {
        return new Base64().decode(str);
    }

    public static BigInteger decodeInteger(byte[] bArr) {
        return new BigInteger(1, decodeBase64(bArr));
    }

    public static byte[] encodeBase64(byte[] bArr) {
        return encodeBase64(bArr, false);
    }

    public static byte[] encodeBase64Chunked(byte[] bArr) {
        return encodeBase64(bArr, true);
    }

    public static String encodeBase64String(byte[] bArr) {
        return StringUtils.newStringUtf8(encodeBase64(bArr, false));
    }

    public static byte[] encodeBase64URLSafe(byte[] bArr) {
        return encodeBase64(bArr, false, true);
    }

    public static String encodeBase64URLSafeString(byte[] bArr) {
        return StringUtils.newStringUtf8(encodeBase64(bArr, false, true));
    }

    public static byte[] encodeInteger(BigInteger bigInteger) {
        if (bigInteger != null) {
            return encodeBase64(l(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    public static boolean isArrayByteBase64(byte[] bArr) {
        return isBase64(bArr);
    }

    public static boolean isBase64(byte b4) {
        if (b4 != 61) {
            if (b4 >= 0) {
                byte[] bArr = f25995u;
                if (b4 >= bArr.length || bArr[b4] == -1) {
                }
            }
            return false;
        }
        return true;
    }

    static byte[] l(BigInteger bigInteger) {
        int bitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        int i4 = 1;
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == bitLength / 8) {
            return byteArray;
        }
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
        } else {
            i4 = 0;
        }
        int i5 = bitLength / 8;
        int i6 = i5 - length;
        byte[] bArr = new byte[i5];
        System.arraycopy(byteArray, i4, bArr, i6, length);
        return bArr;
    }

    @Override // com.google.api.client.repackaged.org.apache.commons.codec.binary.BaseNCodec
    void c(byte[] bArr, int i4, int i5) {
        byte b4;
        if (this.f26010i) {
            return;
        }
        if (i5 < 0) {
            this.f26010i = true;
        }
        int i6 = 0;
        while (true) {
            if (i6 >= i5) {
                break;
            }
            e(this.f25999o);
            int i7 = i4 + 1;
            byte b5 = bArr[i4];
            if (b5 == 61) {
                this.f26010i = true;
                break;
            }
            if (b5 >= 0) {
                byte[] bArr2 = f25995u;
                if (b5 < bArr2.length && (b4 = bArr2[b5]) >= 0) {
                    int i8 = (this.f26012k + 1) % 4;
                    this.f26012k = i8;
                    int i9 = (this.f26001q << 6) + b4;
                    this.f26001q = i9;
                    if (i8 == 0) {
                        byte[] bArr3 = this.f26007f;
                        int i10 = this.f26008g;
                        int i11 = i10 + 1;
                        bArr3[i10] = (byte) ((i9 >> 16) & 255);
                        int i12 = i11 + 1;
                        bArr3[i11] = (byte) ((i9 >> 8) & 255);
                        this.f26008g = i12 + 1;
                        bArr3[i12] = (byte) (i9 & 255);
                    }
                }
            }
            i6++;
            i4 = i7;
        }
        if (this.f26010i && this.f26012k != 0) {
            e(this.f25999o);
            int i13 = this.f26012k;
            if (i13 != 2) {
                if (i13 == 3) {
                    int i14 = this.f26001q >> 2;
                    this.f26001q = i14;
                    byte[] bArr4 = this.f26007f;
                    int i15 = this.f26008g;
                    int i16 = i15 + 1;
                    bArr4[i15] = (byte) ((i14 >> 8) & 255);
                    this.f26008g = i16 + 1;
                    bArr4[i16] = (byte) (i14 & 255);
                    return;
                }
                return;
            }
            int i17 = this.f26001q >> 4;
            this.f26001q = i17;
            byte[] bArr5 = this.f26007f;
            int i18 = this.f26008g;
            this.f26008g = i18 + 1;
            bArr5[i18] = (byte) (i17 & 255);
        }
    }

    @Override // com.google.api.client.repackaged.org.apache.commons.codec.binary.BaseNCodec
    void d(byte[] bArr, int i4, int i5) {
        if (this.f26010i) {
            return;
        }
        if (i5 < 0) {
            this.f26010i = true;
            if (this.f26012k == 0 && this.f26005d == 0) {
                return;
            }
            e(this.f26000p);
            int i6 = this.f26008g;
            int i7 = this.f26012k;
            if (i7 != 1) {
                if (i7 == 2) {
                    byte[] bArr2 = this.f26007f;
                    int i8 = i6 + 1;
                    byte[] bArr3 = this.f25996l;
                    int i9 = this.f26001q;
                    bArr2[i6] = bArr3[(i9 >> 10) & 63];
                    int i10 = i8 + 1;
                    bArr2[i8] = bArr3[(i9 >> 4) & 63];
                    int i11 = i10 + 1;
                    this.f26008g = i11;
                    bArr2[i10] = bArr3[(i9 << 2) & 63];
                    if (bArr3 == f25993s) {
                        this.f26008g = i11 + 1;
                        bArr2[i11] = kotlin.io.encoding.Base64.padSymbol;
                    }
                }
            } else {
                byte[] bArr4 = this.f26007f;
                int i12 = i6 + 1;
                byte[] bArr5 = this.f25996l;
                int i13 = this.f26001q;
                bArr4[i6] = bArr5[(i13 >> 2) & 63];
                int i14 = i12 + 1;
                this.f26008g = i14;
                bArr4[i12] = bArr5[(i13 << 4) & 63];
                if (bArr5 == f25993s) {
                    int i15 = i14 + 1;
                    bArr4[i14] = kotlin.io.encoding.Base64.padSymbol;
                    this.f26008g = i15 + 1;
                    bArr4[i15] = kotlin.io.encoding.Base64.padSymbol;
                }
            }
            int i16 = this.f26011j;
            int i17 = this.f26008g;
            int i18 = i16 + (i17 - i6);
            this.f26011j = i18;
            if (this.f26005d > 0 && i18 > 0) {
                byte[] bArr6 = this.f25998n;
                System.arraycopy(bArr6, 0, this.f26007f, i17, bArr6.length);
                this.f26008g += this.f25998n.length;
                return;
            }
            return;
        }
        int i19 = 0;
        while (i19 < i5) {
            e(this.f26000p);
            int i20 = (this.f26012k + 1) % 3;
            this.f26012k = i20;
            int i21 = i4 + 1;
            int i22 = bArr[i4];
            if (i22 < 0) {
                i22 += 256;
            }
            int i23 = (this.f26001q << 8) + i22;
            this.f26001q = i23;
            if (i20 == 0) {
                byte[] bArr7 = this.f26007f;
                int i24 = this.f26008g;
                int i25 = i24 + 1;
                byte[] bArr8 = this.f25996l;
                bArr7[i24] = bArr8[(i23 >> 18) & 63];
                int i26 = i25 + 1;
                bArr7[i25] = bArr8[(i23 >> 12) & 63];
                int i27 = i26 + 1;
                bArr7[i26] = bArr8[(i23 >> 6) & 63];
                int i28 = i27 + 1;
                this.f26008g = i28;
                bArr7[i27] = bArr8[i23 & 63];
                int i29 = this.f26011j + 4;
                this.f26011j = i29;
                int i30 = this.f26005d;
                if (i30 > 0 && i30 <= i29) {
                    byte[] bArr9 = this.f25998n;
                    System.arraycopy(bArr9, 0, bArr7, i28, bArr9.length);
                    this.f26008g += this.f25998n.length;
                    this.f26011j = 0;
                }
            }
            i19++;
            i4 = i21;
        }
    }

    @Override // com.google.api.client.repackaged.org.apache.commons.codec.binary.BaseNCodec
    protected boolean g(byte b4) {
        if (b4 >= 0) {
            byte[] bArr = this.f25997m;
            if (b4 < bArr.length && bArr[b4] != -1) {
                return true;
            }
        }
        return false;
    }

    public boolean isUrlSafe() {
        if (this.f25996l == f25994t) {
            return true;
        }
        return false;
    }

    public Base64(boolean z3) {
        this(76, f25992r, z3);
    }

    public static byte[] decodeBase64(byte[] bArr) {
        return new Base64().decode(bArr);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z3) {
        return encodeBase64(bArr, z3, false);
    }

    public static boolean isBase64(String str) {
        return isBase64(StringUtils.getBytesUtf8(str));
    }

    public Base64(int i4) {
        this(i4, f25992r);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z3, boolean z4) {
        return encodeBase64(bArr, z3, z4, Integer.MAX_VALUE);
    }

    public static boolean isBase64(byte[] bArr) {
        for (int i4 = 0; i4 < bArr.length; i4++) {
            if (!isBase64(bArr[i4]) && !BaseNCodec.h(bArr[i4])) {
                return false;
            }
        }
        return true;
    }

    public Base64(int i4, byte[] bArr) {
        this(i4, bArr, false);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z3, boolean z4, int i4) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Base64 base64 = z3 ? new Base64(z4) : new Base64(0, f25992r, z4);
        long encodedLength = base64.getEncodedLength(bArr);
        if (encodedLength <= i4) {
            return base64.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + encodedLength + ") than the specified maximum size of " + i4);
    }

    public Base64(int i4, byte[] bArr, boolean z3) {
        super(3, 4, i4, bArr == null ? 0 : bArr.length);
        this.f25997m = f25995u;
        if (bArr != null) {
            if (b(bArr)) {
                String newStringUtf8 = StringUtils.newStringUtf8(bArr);
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + newStringUtf8 + "]");
            } else if (i4 > 0) {
                this.f26000p = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.f25998n = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                this.f26000p = 4;
                this.f25998n = null;
            }
        } else {
            this.f26000p = 4;
            this.f25998n = null;
        }
        this.f25999o = this.f26000p - 1;
        this.f25996l = z3 ? f25994t : f25993s;
    }
}
