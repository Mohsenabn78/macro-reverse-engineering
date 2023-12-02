package com.fasterxml.jackson.core;

import com.google.common.base.Ascii;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.text.Typography;

/* loaded from: classes3.dex */
public final class Base64Variant implements Serializable {
    public static final int BASE64_VALUE_INVALID = -1;
    public static final int BASE64_VALUE_PADDING = -2;
    private static final long serialVersionUID = 1;
    protected final String _name;

    /* renamed from: a  reason: collision with root package name */
    private final transient int[] f17641a;

    /* renamed from: b  reason: collision with root package name */
    private final transient char[] f17642b;

    /* renamed from: c  reason: collision with root package name */
    private final transient byte[] f17643c;

    /* renamed from: d  reason: collision with root package name */
    protected final transient boolean f17644d;

    /* renamed from: e  reason: collision with root package name */
    protected final transient char f17645e;

    /* renamed from: f  reason: collision with root package name */
    protected final transient int f17646f;

    public Base64Variant(String str, String str2, boolean z3, char c4, int i4) {
        int[] iArr = new int[128];
        this.f17641a = iArr;
        char[] cArr = new char[64];
        this.f17642b = cArr;
        this.f17643c = new byte[64];
        this._name = str;
        this.f17644d = z3;
        this.f17645e = c4;
        this.f17646f = i4;
        int length = str2.length();
        if (length == 64) {
            str2.getChars(0, length, cArr, 0);
            Arrays.fill(iArr, -1);
            for (int i5 = 0; i5 < length; i5++) {
                char c5 = this.f17642b[i5];
                this.f17643c[i5] = (byte) c5;
                this.f17641a[c5] = i5;
            }
            if (z3) {
                this.f17641a[c4] = -2;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + length + ")");
    }

    public int decodeBase64Byte(byte b4) {
        if (b4 <= Byte.MAX_VALUE) {
            return this.f17641a[b4];
        }
        return -1;
    }

    public int decodeBase64Char(char c4) {
        if (c4 <= 127) {
            return this.f17641a[c4];
        }
        return -1;
    }

    public String encode(byte[] bArr) {
        return encode(bArr, false);
    }

    public byte encodeBase64BitsAsByte(int i4) {
        return this.f17643c[i4];
    }

    public char encodeBase64BitsAsChar(int i4) {
        return this.f17642b[i4];
    }

    public int encodeBase64Chunk(int i4, char[] cArr, int i5) {
        int i6 = i5 + 1;
        char[] cArr2 = this.f17642b;
        cArr[i5] = cArr2[(i4 >> 18) & 63];
        int i7 = i6 + 1;
        cArr[i6] = cArr2[(i4 >> 12) & 63];
        int i8 = i7 + 1;
        cArr[i7] = cArr2[(i4 >> 6) & 63];
        int i9 = i8 + 1;
        cArr[i8] = cArr2[i4 & 63];
        return i9;
    }

    public int encodeBase64Partial(int i4, int i5, char[] cArr, int i6) {
        int i7 = i6 + 1;
        char[] cArr2 = this.f17642b;
        cArr[i6] = cArr2[(i4 >> 18) & 63];
        int i8 = i7 + 1;
        cArr[i7] = cArr2[(i4 >> 12) & 63];
        if (this.f17644d) {
            int i9 = i8 + 1;
            cArr[i8] = i5 == 2 ? cArr2[(i4 >> 6) & 63] : this.f17645e;
            int i10 = i9 + 1;
            cArr[i9] = this.f17645e;
            return i10;
        } else if (i5 == 2) {
            int i11 = i8 + 1;
            cArr[i8] = cArr2[(i4 >> 6) & 63];
            return i11;
        } else {
            return i8;
        }
    }

    public int getMaxLineLength() {
        return this.f17646f;
    }

    public String getName() {
        return this._name;
    }

    public byte getPaddingByte() {
        return (byte) this.f17645e;
    }

    public char getPaddingChar() {
        return this.f17645e;
    }

    protected Object readResolve() {
        return Base64Variants.valueOf(this._name);
    }

    public String toString() {
        return this._name;
    }

    public boolean usesPadding() {
        return this.f17644d;
    }

    public boolean usesPaddingChar(char c4) {
        return c4 == this.f17645e;
    }

    public int decodeBase64Char(int i4) {
        if (i4 <= 127) {
            return this.f17641a[i4];
        }
        return -1;
    }

    public String encode(byte[] bArr, boolean z3) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder((length >> 2) + length + (length >> 3));
        if (z3) {
            sb.append(Typography.quote);
        }
        int maxLineLength = getMaxLineLength() >> 2;
        int i4 = length - 3;
        int i5 = 0;
        while (i5 <= i4) {
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            encodeBase64Chunk(sb, (((bArr[i5] << 8) | (bArr[i6] & 255)) << 8) | (bArr[i7] & 255));
            maxLineLength--;
            if (maxLineLength <= 0) {
                sb.append('\\');
                sb.append('n');
                maxLineLength = getMaxLineLength() >> 2;
            }
            i5 = i8;
        }
        int i9 = length - i5;
        if (i9 > 0) {
            int i10 = i5 + 1;
            int i11 = bArr[i5] << Ascii.DLE;
            if (i9 == 2) {
                i11 |= (bArr[i10] & 255) << 8;
            }
            encodeBase64Partial(sb, i11, i9);
        }
        if (z3) {
            sb.append(Typography.quote);
        }
        return sb.toString();
    }

    public boolean usesPaddingChar(int i4) {
        return i4 == this.f17645e;
    }

    public void encodeBase64Chunk(StringBuilder sb, int i4) {
        sb.append(this.f17642b[(i4 >> 18) & 63]);
        sb.append(this.f17642b[(i4 >> 12) & 63]);
        sb.append(this.f17642b[(i4 >> 6) & 63]);
        sb.append(this.f17642b[i4 & 63]);
    }

    public void encodeBase64Partial(StringBuilder sb, int i4, int i5) {
        sb.append(this.f17642b[(i4 >> 18) & 63]);
        sb.append(this.f17642b[(i4 >> 12) & 63]);
        if (this.f17644d) {
            sb.append(i5 == 2 ? this.f17642b[(i4 >> 6) & 63] : this.f17645e);
            sb.append(this.f17645e);
        } else if (i5 == 2) {
            sb.append(this.f17642b[(i4 >> 6) & 63]);
        }
    }

    public int encodeBase64Chunk(int i4, byte[] bArr, int i5) {
        int i6 = i5 + 1;
        byte[] bArr2 = this.f17643c;
        bArr[i5] = bArr2[(i4 >> 18) & 63];
        int i7 = i6 + 1;
        bArr[i6] = bArr2[(i4 >> 12) & 63];
        int i8 = i7 + 1;
        bArr[i7] = bArr2[(i4 >> 6) & 63];
        int i9 = i8 + 1;
        bArr[i8] = bArr2[i4 & 63];
        return i9;
    }

    public int encodeBase64Partial(int i4, int i5, byte[] bArr, int i6) {
        int i7 = i6 + 1;
        byte[] bArr2 = this.f17643c;
        bArr[i6] = bArr2[(i4 >> 18) & 63];
        int i8 = i7 + 1;
        bArr[i7] = bArr2[(i4 >> 12) & 63];
        if (!this.f17644d) {
            if (i5 == 2) {
                int i9 = i8 + 1;
                bArr[i8] = bArr2[(i4 >> 6) & 63];
                return i9;
            }
            return i8;
        }
        byte b4 = (byte) this.f17645e;
        int i10 = i8 + 1;
        bArr[i8] = i5 == 2 ? bArr2[(i4 >> 6) & 63] : b4;
        int i11 = i10 + 1;
        bArr[i10] = b4;
        return i11;
    }

    public Base64Variant(Base64Variant base64Variant, String str, int i4) {
        this(base64Variant, str, base64Variant.f17644d, base64Variant.f17645e, i4);
    }

    public Base64Variant(Base64Variant base64Variant, String str, boolean z3, char c4, int i4) {
        int[] iArr = new int[128];
        this.f17641a = iArr;
        char[] cArr = new char[64];
        this.f17642b = cArr;
        byte[] bArr = new byte[64];
        this.f17643c = bArr;
        this._name = str;
        byte[] bArr2 = base64Variant.f17643c;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        char[] cArr2 = base64Variant.f17642b;
        System.arraycopy(cArr2, 0, cArr, 0, cArr2.length);
        int[] iArr2 = base64Variant.f17641a;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.f17644d = z3;
        this.f17645e = c4;
        this.f17646f = i4;
    }
}
