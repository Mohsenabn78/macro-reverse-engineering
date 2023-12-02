package com.fasterxml.jackson.core.json;

import com.android.dx.io.Opcodes;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import okio.Utf8;

/* loaded from: classes3.dex */
public class UTF8JsonGenerator extends JsonGeneratorImpl {

    /* renamed from: u  reason: collision with root package name */
    static final byte[] f17803u = CharTypes.copyHexBytes();

    /* renamed from: v  reason: collision with root package name */
    private static final byte[] f17804v = {110, 117, 108, 108};

    /* renamed from: w  reason: collision with root package name */
    private static final byte[] f17805w = {116, 114, 117, 101};

    /* renamed from: x  reason: collision with root package name */
    private static final byte[] f17806x = {102, 97, 108, 115, 101};

    /* renamed from: m  reason: collision with root package name */
    protected final OutputStream f17807m;

    /* renamed from: n  reason: collision with root package name */
    protected byte[] f17808n;

    /* renamed from: o  reason: collision with root package name */
    protected int f17809o;

    /* renamed from: p  reason: collision with root package name */
    protected final int f17810p;

    /* renamed from: q  reason: collision with root package name */
    protected final int f17811q;

    /* renamed from: r  reason: collision with root package name */
    protected char[] f17812r;

    /* renamed from: s  reason: collision with root package name */
    protected final int f17813s;

    /* renamed from: t  reason: collision with root package name */
    protected boolean f17814t;

    public UTF8JsonGenerator(IOContext iOContext, int i4, ObjectCodec objectCodec, OutputStream outputStream) {
        super(iOContext, i4, objectCodec);
        this.f17809o = 0;
        this.f17807m = outputStream;
        this.f17814t = true;
        byte[] allocWriteEncodingBuffer = iOContext.allocWriteEncodingBuffer();
        this.f17808n = allocWriteEncodingBuffer;
        int length = allocWriteEncodingBuffer.length;
        this.f17810p = length;
        this.f17811q = length >> 3;
        char[] allocConcatBuffer = iOContext.allocConcatBuffer();
        this.f17812r = allocConcatBuffer;
        this.f17813s = allocConcatBuffer.length;
        if (isEnabled(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
            setHighestNonEscapedChar(127);
        }
    }

    private void A(char[] cArr, int i4, int i5) throws IOException, JsonGenerationException {
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr = this.f17808n;
        int i6 = this.f17809o;
        this.f17809o = i6 + 1;
        bArr[i6] = 34;
        M(this.f17812r, 0, i5);
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr2 = this.f17808n;
        int i7 = this.f17809o;
        this.f17809o = i7 + 1;
        bArr2[i7] = 34;
    }

    private void B() throws IOException {
        if (this.f17809o + 4 >= this.f17810p) {
            h();
        }
        System.arraycopy(f17804v, 0, this.f17808n, this.f17809o, 4);
        this.f17809o += 4;
    }

    private void E(int i4) throws IOException {
        if (this.f17809o + 13 >= this.f17810p) {
            h();
        }
        byte[] bArr = this.f17808n;
        int i5 = this.f17809o;
        int i6 = i5 + 1;
        this.f17809o = i6;
        bArr[i5] = 34;
        int outputInt = NumberOutput.outputInt(i4, bArr, i6);
        byte[] bArr2 = this.f17808n;
        this.f17809o = outputInt + 1;
        bArr2[outputInt] = 34;
    }

    private void F(long j4) throws IOException {
        if (this.f17809o + 23 >= this.f17810p) {
            h();
        }
        byte[] bArr = this.f17808n;
        int i4 = this.f17809o;
        int i5 = i4 + 1;
        this.f17809o = i5;
        bArr[i4] = 34;
        int outputLong = NumberOutput.outputLong(j4, bArr, i5);
        byte[] bArr2 = this.f17808n;
        this.f17809o = outputLong + 1;
        bArr2[outputLong] = 34;
    }

    private void G(Object obj) throws IOException {
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr = this.f17808n;
        int i4 = this.f17809o;
        this.f17809o = i4 + 1;
        bArr[i4] = 34;
        writeRaw(obj.toString());
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr2 = this.f17808n;
        int i5 = this.f17809o;
        this.f17809o = i5 + 1;
        bArr2[i5] = 34;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r9 >= 2048) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
        r4 = r7.f17809o;
        r5 = r4 + 1;
        r1[r4] = (byte) ((r9 >> 6) | 192);
        r7.f17809o = r5 + 1;
        r1[r5] = (byte) ((r9 & '?') | 128);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
        k(r9, r8, r2, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
        r9 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
        if ((r7.f17809o + 3) < r7.f17810p) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
        h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r2 = r9 + 1;
        r9 = r8[r9];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void H(char[] r8, int r9, int r10) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
            r7 = this;
            int r0 = r7.f17810p
            byte[] r1 = r7.f17808n
        L4:
            if (r9 >= r10) goto L4e
        L6:
            char r2 = r8[r9]
            r3 = 128(0x80, float:1.794E-43)
            if (r2 < r3) goto L3a
            int r2 = r7.f17809o
            int r2 = r2 + 3
            int r4 = r7.f17810p
            if (r2 < r4) goto L17
            r7.h()
        L17:
            int r2 = r9 + 1
            char r9 = r8[r9]
            r4 = 2048(0x800, float:2.87E-42)
            if (r9 >= r4) goto L35
            int r4 = r7.f17809o
            int r5 = r4 + 1
            int r6 = r9 >> 6
            r6 = r6 | 192(0xc0, float:2.69E-43)
            byte r6 = (byte) r6
            r1[r4] = r6
            int r4 = r5 + 1
            r7.f17809o = r4
            r9 = r9 & 63
            r9 = r9 | r3
            byte r9 = (byte) r9
            r1[r5] = r9
            goto L38
        L35:
            r7.k(r9, r8, r2, r10)
        L38:
            r9 = r2
            goto L4
        L3a:
            int r3 = r7.f17809o
            if (r3 < r0) goto L41
            r7.h()
        L41:
            int r3 = r7.f17809o
            int r4 = r3 + 1
            r7.f17809o = r4
            byte r2 = (byte) r2
            r1[r3] = r2
            int r9 = r9 + 1
            if (r9 < r10) goto L6
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8JsonGenerator.H(char[], int, int):void");
    }

    private final void I(char[] cArr, int i4, int i5) throws IOException, JsonGenerationException {
        int i6 = i5 + i4;
        int i7 = this.f17809o;
        byte[] bArr = this.f17808n;
        int[] iArr = this.f17790h;
        while (i4 < i6) {
            char c4 = cArr[i4];
            if (c4 > 127 || iArr[c4] != 0) {
                break;
            }
            bArr[i7] = (byte) c4;
            i4++;
            i7++;
        }
        this.f17809o = i7;
        if (i4 < i6) {
            if (this.f17792j != null) {
                v(cArr, i4, i6);
            } else if (this.f17791i == 0) {
                J(cArr, i4, i6);
            } else {
                K(cArr, i4, i6);
            }
        }
    }

    private final void J(char[] cArr, int i4, int i5) throws IOException, JsonGenerationException {
        if (this.f17809o + ((i5 - i4) * 6) > this.f17810p) {
            h();
        }
        int i6 = this.f17809o;
        byte[] bArr = this.f17808n;
        int[] iArr = this.f17790h;
        while (i4 < i5) {
            int i7 = i4 + 1;
            char c4 = cArr[i4];
            if (c4 <= 127) {
                int i8 = iArr[c4];
                if (i8 == 0) {
                    bArr[i6] = (byte) c4;
                    i4 = i7;
                    i6++;
                } else if (i8 > 0) {
                    int i9 = i6 + 1;
                    bArr[i6] = 92;
                    i6 = i9 + 1;
                    bArr[i9] = (byte) i8;
                } else {
                    i6 = y(c4, i6);
                }
            } else if (c4 <= 2047) {
                int i10 = i6 + 1;
                bArr[i6] = (byte) ((c4 >> 6) | 192);
                i6 = i10 + 1;
                bArr[i10] = (byte) ((c4 & '?') | 128);
            } else {
                i6 = j(c4, i6);
            }
            i4 = i7;
        }
        this.f17809o = i6;
    }

    private final void K(char[] cArr, int i4, int i5) throws IOException, JsonGenerationException {
        if (this.f17809o + ((i5 - i4) * 6) > this.f17810p) {
            h();
        }
        int i6 = this.f17809o;
        byte[] bArr = this.f17808n;
        int[] iArr = this.f17790h;
        int i7 = this.f17791i;
        while (i4 < i5) {
            int i8 = i4 + 1;
            char c4 = cArr[i4];
            if (c4 <= 127) {
                int i9 = iArr[c4];
                if (i9 == 0) {
                    bArr[i6] = (byte) c4;
                    i4 = i8;
                    i6++;
                } else if (i9 > 0) {
                    int i10 = i6 + 1;
                    bArr[i6] = 92;
                    i6 = i10 + 1;
                    bArr[i10] = (byte) i9;
                } else {
                    i6 = y(c4, i6);
                }
            } else if (c4 > i7) {
                i6 = y(c4, i6);
            } else if (c4 <= 2047) {
                int i11 = i6 + 1;
                bArr[i6] = (byte) ((c4 >> 6) | 192);
                i6 = i11 + 1;
                bArr[i11] = (byte) ((c4 & '?') | 128);
            } else {
                i6 = j(c4, i6);
            }
            i4 = i8;
        }
        this.f17809o = i6;
    }

    private final void L(String str) throws IOException, JsonGenerationException {
        int length = str.length();
        char[] cArr = this.f17812r;
        int i4 = 0;
        while (length > 0) {
            int min = Math.min(this.f17811q, length);
            int i5 = i4 + min;
            str.getChars(i4, i5, cArr, 0);
            if (this.f17809o + min > this.f17810p) {
                h();
            }
            I(cArr, 0, min);
            length -= min;
            i4 = i5;
        }
    }

    private final void M(char[] cArr, int i4, int i5) throws IOException, JsonGenerationException {
        do {
            int min = Math.min(this.f17811q, i5);
            if (this.f17809o + min > this.f17810p) {
                h();
            }
            I(cArr, i4, min);
            i4 += min;
            i5 -= min;
        } while (i5 > 0);
    }

    private void N(byte[] bArr, int i4, int i5) throws IOException, JsonGenerationException {
        int[] iArr = this.f17790h;
        int i6 = i4 + i5;
        int i7 = i4;
        while (i7 < i6) {
            int i8 = i7 + 1;
            byte b4 = bArr[i7];
            if (b4 >= 0 && iArr[b4] != 0) {
                O(bArr, i4, i5);
                return;
            }
            i7 = i8;
        }
        if (this.f17809o + i5 > this.f17810p) {
            h();
        }
        System.arraycopy(bArr, i4, this.f17808n, this.f17809o, i5);
        this.f17809o += i5;
    }

    private void O(byte[] bArr, int i4, int i5) throws IOException, JsonGenerationException {
        int i6;
        int i7 = this.f17809o;
        if ((i5 * 6) + i7 > this.f17810p) {
            h();
            i7 = this.f17809o;
        }
        byte[] bArr2 = this.f17808n;
        int[] iArr = this.f17790h;
        int i8 = i5 + i4;
        while (i4 < i8) {
            int i9 = i4 + 1;
            byte b4 = bArr[i4];
            if (b4 >= 0 && (i6 = iArr[b4]) != 0) {
                if (i6 > 0) {
                    int i10 = i7 + 1;
                    bArr2[i7] = 92;
                    i7 = i10 + 1;
                    bArr2[i10] = (byte) i6;
                } else {
                    i7 = y(b4, i7);
                }
                i4 = i9;
            } else {
                bArr2[i7] = b4;
                i4 = i9;
                i7++;
            }
        }
        this.f17809o = i7;
    }

    private void P(byte[] bArr, int i4, int i5) throws IOException, JsonGenerationException {
        do {
            int min = Math.min(this.f17811q, i5);
            N(bArr, i4, min);
            i4 += min;
            i5 -= min;
        } while (i5 > 0);
    }

    private int i(byte[] bArr, int i4, int i5, byte[] bArr2, int i6) throws IOException, JsonGenerationException {
        int length = bArr2.length;
        if (i4 + length > i5) {
            this.f17809o = i4;
            h();
            int i7 = this.f17809o;
            if (length > bArr.length) {
                this.f17807m.write(bArr2, 0, length);
                return i7;
            }
            System.arraycopy(bArr2, 0, bArr, i7, length);
            i4 = i7 + length;
        }
        if ((i6 * 6) + i4 > i5) {
            h();
            return this.f17809o;
        }
        return i4;
    }

    private int j(int i4, int i5) throws IOException {
        byte[] bArr = this.f17808n;
        if (i4 >= 55296 && i4 <= 57343) {
            int i6 = i5 + 1;
            bArr[i5] = 92;
            int i7 = i6 + 1;
            bArr[i6] = 117;
            int i8 = i7 + 1;
            byte[] bArr2 = f17803u;
            bArr[i7] = bArr2[(i4 >> 12) & 15];
            int i9 = i8 + 1;
            bArr[i8] = bArr2[(i4 >> 8) & 15];
            int i10 = i9 + 1;
            bArr[i9] = bArr2[(i4 >> 4) & 15];
            int i11 = i10 + 1;
            bArr[i10] = bArr2[i4 & 15];
            return i11;
        }
        int i12 = i5 + 1;
        bArr[i5] = (byte) ((i4 >> 12) | Opcodes.SHL_INT_LIT8);
        int i13 = i12 + 1;
        bArr[i12] = (byte) (((i4 >> 6) & 63) | 128);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i4 & 63) | 128);
        return i14;
    }

    private int k(int i4, char[] cArr, int i5, int i6) throws IOException {
        if (i4 >= 55296 && i4 <= 57343) {
            if (i5 >= i6) {
                c("Split surrogate on writeRaw() input (last character)");
            }
            l(i4, cArr[i5]);
            return i5 + 1;
        }
        byte[] bArr = this.f17808n;
        int i7 = this.f17809o;
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((i4 >> 12) | Opcodes.SHL_INT_LIT8);
        int i9 = i8 + 1;
        bArr[i8] = (byte) (((i4 >> 6) & 63) | 128);
        this.f17809o = i9 + 1;
        bArr[i9] = (byte) ((i4 & 63) | 128);
        return i5;
    }

    private int m(InputStream inputStream, byte[] bArr, int i4, int i5, int i6) throws IOException {
        int i7 = 0;
        while (i4 < i5) {
            bArr[i7] = bArr[i4];
            i7++;
            i4++;
        }
        int min = Math.min(i6, bArr.length);
        do {
            int read = inputStream.read(bArr, i7, min - i7);
            if (read < 0) {
                return i7;
            }
            i7 += read;
        } while (i7 < 3);
        return i7;
    }

    private final void s(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.f17809o + length > this.f17810p) {
            h();
            if (length > 512) {
                this.f17807m.write(bArr, 0, length);
                return;
            }
        }
        System.arraycopy(bArr, 0, this.f17808n, this.f17809o, length);
        this.f17809o += length;
    }

    private final void t(byte[] bArr, int i4, int i5) throws IOException {
        if (this.f17809o + i5 > this.f17810p) {
            h();
            if (i5 > 512) {
                this.f17807m.write(bArr, i4, i5);
                return;
            }
        }
        System.arraycopy(bArr, i4, this.f17808n, this.f17809o, i5);
        this.f17809o += i5;
    }

    private int u(byte[] bArr, int i4, SerializableString serializableString, int i5) throws IOException, JsonGenerationException {
        byte[] asUnquotedUTF8 = serializableString.asUnquotedUTF8();
        int length = asUnquotedUTF8.length;
        if (length > 6) {
            return i(bArr, i4, this.f17810p, asUnquotedUTF8, i5);
        }
        System.arraycopy(asUnquotedUTF8, 0, bArr, i4, length);
        return i4 + length;
    }

    private void v(char[] cArr, int i4, int i5) throws IOException, JsonGenerationException {
        if (this.f17809o + ((i5 - i4) * 6) > this.f17810p) {
            h();
        }
        int i6 = this.f17809o;
        byte[] bArr = this.f17808n;
        int[] iArr = this.f17790h;
        int i7 = this.f17791i;
        if (i7 <= 0) {
            i7 = 65535;
        }
        CharacterEscapes characterEscapes = this.f17792j;
        while (i4 < i5) {
            int i8 = i4 + 1;
            char c4 = cArr[i4];
            if (c4 <= 127) {
                int i9 = iArr[c4];
                if (i9 == 0) {
                    bArr[i6] = (byte) c4;
                    i4 = i8;
                    i6++;
                } else if (i9 > 0) {
                    int i10 = i6 + 1;
                    bArr[i6] = 92;
                    i6 = i10 + 1;
                    bArr[i10] = (byte) i9;
                } else if (i9 == -2) {
                    SerializableString escapeSequence = characterEscapes.getEscapeSequence(c4);
                    if (escapeSequence == null) {
                        c("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(c4) + ", although was supposed to have one");
                    }
                    i6 = u(bArr, i6, escapeSequence, i5 - i8);
                } else {
                    i6 = y(c4, i6);
                }
            } else if (c4 > i7) {
                i6 = y(c4, i6);
            } else {
                SerializableString escapeSequence2 = characterEscapes.getEscapeSequence(c4);
                if (escapeSequence2 != null) {
                    i6 = u(bArr, i6, escapeSequence2, i5 - i8);
                } else if (c4 <= 2047) {
                    int i11 = i6 + 1;
                    bArr[i6] = (byte) ((c4 >> 6) | 192);
                    i6 = i11 + 1;
                    bArr[i11] = (byte) ((c4 & '?') | 128);
                } else {
                    i6 = j(c4, i6);
                }
            }
            i4 = i8;
        }
        this.f17809o = i6;
    }

    private int y(int i4, int i5) throws IOException {
        int i6;
        byte[] bArr = this.f17808n;
        int i7 = i5 + 1;
        bArr[i5] = 92;
        int i8 = i7 + 1;
        bArr[i7] = 117;
        if (i4 > 255) {
            int i9 = 255 & (i4 >> 8);
            int i10 = i8 + 1;
            byte[] bArr2 = f17803u;
            bArr[i8] = bArr2[i9 >> 4];
            i6 = i10 + 1;
            bArr[i10] = bArr2[i9 & 15];
            i4 &= 255;
        } else {
            int i11 = i8 + 1;
            bArr[i8] = 48;
            i6 = i11 + 1;
            bArr[i11] = 48;
        }
        int i12 = i6 + 1;
        byte[] bArr3 = f17803u;
        bArr[i6] = bArr3[i4 >> 4];
        int i13 = i12 + 1;
        bArr[i12] = bArr3[i4 & 15];
        return i13;
    }

    private void z(String str) throws IOException, JsonGenerationException {
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr = this.f17808n;
        int i4 = this.f17809o;
        this.f17809o = i4 + 1;
        bArr[i4] = 34;
        L(str);
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr2 = this.f17808n;
        int i5 = this.f17809o;
        this.f17809o = i5 + 1;
        bArr2[i5] = 34;
    }

    protected final void C(SerializableString serializableString, boolean z3) throws IOException, JsonGenerationException {
        if (z3) {
            this.f17656a.writeObjectEntrySeparator(this);
        } else {
            this.f17656a.beforeObjectEntries(this);
        }
        boolean isEnabled = isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES);
        if (isEnabled) {
            if (this.f17809o >= this.f17810p) {
                h();
            }
            byte[] bArr = this.f17808n;
            int i4 = this.f17809o;
            this.f17809o = i4 + 1;
            bArr[i4] = 34;
        }
        s(serializableString.asQuotedUTF8());
        if (isEnabled) {
            if (this.f17809o >= this.f17810p) {
                h();
            }
            byte[] bArr2 = this.f17808n;
            int i5 = this.f17809o;
            this.f17809o = i5 + 1;
            bArr2[i5] = 34;
        }
    }

    protected final void D(String str, boolean z3) throws IOException, JsonGenerationException {
        if (z3) {
            this.f17656a.writeObjectEntrySeparator(this);
        } else {
            this.f17656a.beforeObjectEntries(this);
        }
        if (isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            if (this.f17809o >= this.f17810p) {
                h();
            }
            byte[] bArr = this.f17808n;
            int i4 = this.f17809o;
            this.f17809o = i4 + 1;
            bArr[i4] = 34;
            int length = str.length();
            if (length <= this.f17813s) {
                str.getChars(0, length, this.f17812r, 0);
                if (length <= this.f17811q) {
                    if (this.f17809o + length > this.f17810p) {
                        h();
                    }
                    I(this.f17812r, 0, length);
                } else {
                    M(this.f17812r, 0, length);
                }
            } else {
                L(str);
            }
            if (this.f17809o >= this.f17810p) {
                h();
            }
            byte[] bArr2 = this.f17808n;
            int i5 = this.f17809o;
            this.f17809o = i5 + 1;
            bArr2[i5] = 34;
            return;
        }
        L(str);
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (this.f17808n != null && isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                JsonWriteContext outputContext = getOutputContext();
                if (outputContext.inArray()) {
                    writeEndArray();
                } else if (!outputContext.inObject()) {
                    break;
                } else {
                    writeEndObject();
                }
            }
        }
        h();
        if (this.f17807m != null) {
            if (!this.f17789g.isResourceManaged() && !isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
                if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
                    this.f17807m.flush();
                }
            } else {
                this.f17807m.close();
            }
        }
        n();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    protected final void e(String str) throws IOException, JsonGenerationException {
        byte b4;
        SerializableString serializableString;
        int writeValue = this.f17669e.writeValue();
        if (writeValue == 5) {
            c("Can not " + str + ", expecting field name");
        }
        if (this.f17656a == null) {
            if (writeValue != 1) {
                if (writeValue != 2) {
                    if (writeValue == 3 && (serializableString = this.f17793k) != null) {
                        byte[] asUnquotedUTF8 = serializableString.asUnquotedUTF8();
                        if (asUnquotedUTF8.length > 0) {
                            s(asUnquotedUTF8);
                            return;
                        }
                        return;
                    }
                    return;
                }
                b4 = 58;
            } else {
                b4 = 44;
            }
            if (this.f17809o >= this.f17810p) {
                h();
            }
            byte[] bArr = this.f17808n;
            int i4 = this.f17809o;
            bArr[i4] = b4;
            this.f17809o = i4 + 1;
            return;
        }
        o(str, writeValue);
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public final void flush() throws IOException {
        h();
        if (this.f17807m != null && isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            this.f17807m.flush();
        }
    }

    protected final int g(int i4, int i5) throws IOException {
        if (i5 < 56320 || i5 > 57343) {
            c("Incomplete surrogate pair: first char 0x" + Integer.toHexString(i4) + ", second 0x" + Integer.toHexString(i5));
        }
        return ((i4 - 55296) << 10) + 65536 + (i5 - Utf8.LOG_SURROGATE_HEADER);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public Object getOutputTarget() {
        return this.f17807m;
    }

    protected final void h() throws IOException {
        int i4 = this.f17809o;
        if (i4 > 0) {
            this.f17809o = 0;
            this.f17807m.write(this.f17808n, 0, i4);
        }
    }

    protected final void l(int i4, int i5) throws IOException {
        int g4 = g(i4, i5);
        if (this.f17809o + 4 > this.f17810p) {
            h();
        }
        byte[] bArr = this.f17808n;
        int i6 = this.f17809o;
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((g4 >> 18) | 240);
        int i8 = i7 + 1;
        bArr[i7] = (byte) (((g4 >> 12) & 63) | 128);
        int i9 = i8 + 1;
        bArr[i8] = (byte) (((g4 >> 6) & 63) | 128);
        this.f17809o = i9 + 1;
        bArr[i9] = (byte) ((g4 & 63) | 128);
    }

    protected void n() {
        byte[] bArr = this.f17808n;
        if (bArr != null && this.f17814t) {
            this.f17808n = null;
            this.f17789g.releaseWriteEncodingBuffer(bArr);
        }
        char[] cArr = this.f17812r;
        if (cArr != null) {
            this.f17812r = null;
            this.f17789g.releaseConcatBuffer(cArr);
        }
    }

    protected final void o(String str, int i4) throws IOException, JsonGenerationException {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        b();
                        return;
                    } else {
                        this.f17656a.writeRootValueSeparator(this);
                        return;
                    }
                }
                this.f17656a.writeObjectFieldValueSeparator(this);
                return;
            }
            this.f17656a.writeArrayValueSeparator(this);
        } else if (this.f17669e.inArray()) {
            this.f17656a.beforeArrayValues(this);
        } else if (this.f17669e.inObject()) {
            this.f17656a.beforeObjectEntries(this);
        }
    }

    protected int p(Base64Variant base64Variant, InputStream inputStream, byte[] bArr) throws IOException, JsonGenerationException {
        int i4 = this.f17810p - 6;
        int i5 = 2;
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        int i6 = -3;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i7 > i6) {
                i8 = m(inputStream, bArr, i7, i8, bArr.length);
                if (i8 < 3) {
                    break;
                }
                i6 = i8 - 3;
                i7 = 0;
            }
            if (this.f17809o > i4) {
                h();
            }
            int i10 = i7 + 1;
            int i11 = i10 + 1;
            i7 = i11 + 1;
            i9 += 3;
            int encodeBase64Chunk = base64Variant.encodeBase64Chunk((((bArr[i10] & 255) | (bArr[i7] << 8)) << 8) | (bArr[i11] & 255), this.f17808n, this.f17809o);
            this.f17809o = encodeBase64Chunk;
            maxLineLength--;
            if (maxLineLength <= 0) {
                byte[] bArr2 = this.f17808n;
                int i12 = encodeBase64Chunk + 1;
                bArr2[encodeBase64Chunk] = 92;
                this.f17809o = i12 + 1;
                bArr2[i12] = 110;
                maxLineLength = base64Variant.getMaxLineLength() >> 2;
            }
        }
        if (i8 > 0) {
            if (this.f17809o > i4) {
                h();
            }
            int i13 = bArr[0] << Ascii.DLE;
            if (1 < i8) {
                i13 |= (bArr[1] & 255) << 8;
            } else {
                i5 = 1;
            }
            int i14 = i9 + i5;
            this.f17809o = base64Variant.encodeBase64Partial(i13, i5, this.f17808n, this.f17809o);
            return i14;
        }
        return i9;
    }

    protected int q(Base64Variant base64Variant, InputStream inputStream, byte[] bArr, int i4) throws IOException, JsonGenerationException {
        int m4;
        int i5 = this.f17810p - 6;
        int i6 = 2;
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        int i7 = -3;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i4 <= 2) {
                break;
            }
            if (i8 > i7) {
                i9 = m(inputStream, bArr, i8, i9, i4);
                if (i9 < 3) {
                    i8 = 0;
                    break;
                }
                i7 = i9 - 3;
                i8 = 0;
            }
            if (this.f17809o > i5) {
                h();
            }
            int i10 = i8 + 1;
            int i11 = i10 + 1;
            i8 = i11 + 1;
            i4 -= 3;
            int encodeBase64Chunk = base64Variant.encodeBase64Chunk((((bArr[i10] & 255) | (bArr[i8] << 8)) << 8) | (bArr[i11] & 255), this.f17808n, this.f17809o);
            this.f17809o = encodeBase64Chunk;
            maxLineLength--;
            if (maxLineLength <= 0) {
                byte[] bArr2 = this.f17808n;
                int i12 = encodeBase64Chunk + 1;
                bArr2[encodeBase64Chunk] = 92;
                this.f17809o = i12 + 1;
                bArr2[i12] = 110;
                maxLineLength = base64Variant.getMaxLineLength() >> 2;
            }
        }
        if (i4 > 0 && (m4 = m(inputStream, bArr, i8, i9, i4)) > 0) {
            if (this.f17809o > i5) {
                h();
            }
            int i13 = bArr[0] << Ascii.DLE;
            if (1 < m4) {
                i13 |= (bArr[1] & 255) << 8;
            } else {
                i6 = 1;
            }
            this.f17809o = base64Variant.encodeBase64Partial(i13, i6, this.f17808n, this.f17809o);
            return i4 - i6;
        }
        return i4;
    }

    protected void r(Base64Variant base64Variant, byte[] bArr, int i4, int i5) throws IOException, JsonGenerationException {
        int i6 = i5 - 3;
        int i7 = this.f17810p - 6;
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        while (i4 <= i6) {
            if (this.f17809o > i7) {
                h();
            }
            int i8 = i4 + 1;
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            int encodeBase64Chunk = base64Variant.encodeBase64Chunk((((bArr[i4] << 8) | (bArr[i8] & 255)) << 8) | (bArr[i9] & 255), this.f17808n, this.f17809o);
            this.f17809o = encodeBase64Chunk;
            maxLineLength--;
            if (maxLineLength <= 0) {
                byte[] bArr2 = this.f17808n;
                int i11 = encodeBase64Chunk + 1;
                bArr2[encodeBase64Chunk] = 92;
                this.f17809o = i11 + 1;
                bArr2[i11] = 110;
                maxLineLength = base64Variant.getMaxLineLength() >> 2;
            }
            i4 = i10;
        }
        int i12 = i5 - i4;
        if (i12 > 0) {
            if (this.f17809o > i7) {
                h();
            }
            int i13 = i4 + 1;
            int i14 = bArr[i4] << Ascii.DLE;
            if (i12 == 2) {
                i14 |= (bArr[i13] & 255) << 8;
            }
            this.f17809o = base64Variant.encodeBase64Partial(i14, i12, this.f17808n, this.f17809o);
        }
    }

    protected final void w(SerializableString serializableString) throws IOException, JsonGenerationException {
        if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            int appendQuotedUTF8 = serializableString.appendQuotedUTF8(this.f17808n, this.f17809o);
            if (appendQuotedUTF8 < 0) {
                s(serializableString.asQuotedUTF8());
                return;
            } else {
                this.f17809o += appendQuotedUTF8;
                return;
            }
        }
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr = this.f17808n;
        int i4 = this.f17809o;
        int i5 = i4 + 1;
        this.f17809o = i5;
        bArr[i4] = 34;
        int appendQuotedUTF82 = serializableString.appendQuotedUTF8(bArr, i5);
        if (appendQuotedUTF82 < 0) {
            s(serializableString.asQuotedUTF8());
        } else {
            this.f17809o += appendQuotedUTF82;
        }
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr2 = this.f17808n;
        int i6 = this.f17809o;
        this.f17809o = i6 + 1;
        bArr2[i6] = 34;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i4, int i5) throws IOException, JsonGenerationException {
        e("write binary value");
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr2 = this.f17808n;
        int i6 = this.f17809o;
        this.f17809o = i6 + 1;
        bArr2[i6] = 34;
        r(base64Variant, bArr, i4, i5 + i4);
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr3 = this.f17808n;
        int i7 = this.f17809o;
        this.f17809o = i7 + 1;
        bArr3[i7] = 34;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBoolean(boolean z3) throws IOException, JsonGenerationException {
        byte[] bArr;
        e("write boolean value");
        if (this.f17809o + 5 >= this.f17810p) {
            h();
        }
        if (z3) {
            bArr = f17805w;
        } else {
            bArr = f17806x;
        }
        int length = bArr.length;
        System.arraycopy(bArr, 0, this.f17808n, this.f17809o, length);
        this.f17809o += length;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeEndArray() throws IOException, JsonGenerationException {
        if (!this.f17669e.inArray()) {
            c("Current context not an ARRAY but " + this.f17669e.getTypeDesc());
        }
        PrettyPrinter prettyPrinter = this.f17656a;
        if (prettyPrinter != null) {
            prettyPrinter.writeEndArray(this, this.f17669e.getEntryCount());
        } else {
            if (this.f17809o >= this.f17810p) {
                h();
            }
            byte[] bArr = this.f17808n;
            int i4 = this.f17809o;
            this.f17809o = i4 + 1;
            bArr[i4] = 93;
        }
        this.f17669e = this.f17669e.getParent();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeEndObject() throws IOException, JsonGenerationException {
        if (!this.f17669e.inObject()) {
            c("Current context not an object but " + this.f17669e.getTypeDesc());
        }
        PrettyPrinter prettyPrinter = this.f17656a;
        if (prettyPrinter != null) {
            prettyPrinter.writeEndObject(this, this.f17669e.getEntryCount());
        } else {
            if (this.f17809o >= this.f17810p) {
                h();
            }
            byte[] bArr = this.f17808n;
            int i4 = this.f17809o;
            this.f17809o = i4 + 1;
            bArr[i4] = 125;
        }
        this.f17669e = this.f17669e.getParent();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeFieldName(String str) throws IOException, JsonGenerationException {
        int writeFieldName = this.f17669e.writeFieldName(str);
        if (writeFieldName == 4) {
            c("Can not write a field name, expecting a value");
        }
        if (this.f17656a != null) {
            D(str, writeFieldName == 1);
            return;
        }
        if (writeFieldName == 1) {
            if (this.f17809o >= this.f17810p) {
                h();
            }
            byte[] bArr = this.f17808n;
            int i4 = this.f17809o;
            this.f17809o = i4 + 1;
            bArr[i4] = 44;
        }
        x(str);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNull() throws IOException, JsonGenerationException {
        e("write null value");
        B();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(int i4) throws IOException, JsonGenerationException {
        e("write number");
        if (this.f17809o + 11 >= this.f17810p) {
            h();
        }
        if (this.f17668d) {
            E(i4);
        } else {
            this.f17809o = NumberOutput.outputInt(i4, this.f17808n, this.f17809o);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str) throws IOException, JsonGenerationException {
        int length = str.length();
        int i4 = 0;
        while (length > 0) {
            char[] cArr = this.f17812r;
            int length2 = cArr.length;
            if (length < length2) {
                length2 = length;
            }
            int i5 = i4 + length2;
            str.getChars(i4, i5, cArr, 0);
            writeRaw(cArr, 0, length2);
            length -= length2;
            i4 = i5;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRawUTF8String(byte[] bArr, int i4, int i5) throws IOException, JsonGenerationException {
        e("write text value");
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr2 = this.f17808n;
        int i6 = this.f17809o;
        this.f17809o = i6 + 1;
        bArr2[i6] = 34;
        t(bArr, i4, i5);
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr3 = this.f17808n;
        int i7 = this.f17809o;
        this.f17809o = i7 + 1;
        bArr3[i7] = 34;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeStartArray() throws IOException, JsonGenerationException {
        e("start an array");
        this.f17669e = this.f17669e.createChildArrayContext();
        PrettyPrinter prettyPrinter = this.f17656a;
        if (prettyPrinter != null) {
            prettyPrinter.writeStartArray(this);
            return;
        }
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr = this.f17808n;
        int i4 = this.f17809o;
        this.f17809o = i4 + 1;
        bArr[i4] = 91;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeStartObject() throws IOException, JsonGenerationException {
        e("start an object");
        this.f17669e = this.f17669e.createChildObjectContext();
        PrettyPrinter prettyPrinter = this.f17656a;
        if (prettyPrinter != null) {
            prettyPrinter.writeStartObject(this);
            return;
        }
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr = this.f17808n;
        int i4 = this.f17809o;
        this.f17809o = i4 + 1;
        bArr[i4] = 123;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(String str) throws IOException, JsonGenerationException {
        e("write text value");
        if (str == null) {
            B();
            return;
        }
        int length = str.length();
        if (length > this.f17813s) {
            z(str);
            return;
        }
        str.getChars(0, length, this.f17812r, 0);
        if (length > this.f17811q) {
            A(this.f17812r, 0, length);
            return;
        }
        if (this.f17809o + length >= this.f17810p) {
            h();
        }
        byte[] bArr = this.f17808n;
        int i4 = this.f17809o;
        this.f17809o = i4 + 1;
        bArr[i4] = 34;
        I(this.f17812r, 0, length);
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr2 = this.f17808n;
        int i5 = this.f17809o;
        this.f17809o = i5 + 1;
        bArr2[i5] = 34;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeUTF8String(byte[] bArr, int i4, int i5) throws IOException, JsonGenerationException {
        e("write text value");
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr2 = this.f17808n;
        int i6 = this.f17809o;
        this.f17809o = i6 + 1;
        bArr2[i6] = 34;
        if (i5 <= this.f17811q) {
            N(bArr, i4, i5);
        } else {
            P(bArr, i4, i5);
        }
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr3 = this.f17808n;
        int i7 = this.f17809o;
        this.f17809o = i7 + 1;
        bArr3[i7] = 34;
    }

    protected final void x(String str) throws IOException, JsonGenerationException {
        if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            L(str);
            return;
        }
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr = this.f17808n;
        int i4 = this.f17809o;
        this.f17809o = i4 + 1;
        bArr[i4] = 34;
        int length = str.length();
        if (length <= this.f17813s) {
            str.getChars(0, length, this.f17812r, 0);
            if (length <= this.f17811q) {
                if (this.f17809o + length > this.f17810p) {
                    h();
                }
                I(this.f17812r, 0, length);
            } else {
                M(this.f17812r, 0, length);
            }
        } else {
            L(str);
        }
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr2 = this.f17808n;
        int i5 = this.f17809o;
        this.f17809o = i5 + 1;
        bArr2[i5] = 34;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str, int i4, int i5) throws IOException, JsonGenerationException {
        while (i5 > 0) {
            char[] cArr = this.f17812r;
            int length = cArr.length;
            if (i5 < length) {
                length = i5;
            }
            int i6 = i4 + length;
            str.getChars(i4, i6, cArr, 0);
            writeRaw(cArr, 0, length);
            i5 -= length;
            i4 = i6;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(long j4) throws IOException, JsonGenerationException {
        e("write number");
        if (this.f17668d) {
            F(j4);
            return;
        }
        if (this.f17809o + 21 >= this.f17810p) {
            h();
        }
        this.f17809o = NumberOutput.outputLong(j4, this.f17808n, this.f17809o);
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public int writeBinary(Base64Variant base64Variant, InputStream inputStream, int i4) throws IOException, JsonGenerationException {
        e("write binary value");
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr = this.f17808n;
        int i5 = this.f17809o;
        this.f17809o = i5 + 1;
        bArr[i5] = 34;
        byte[] allocBase64Buffer = this.f17789g.allocBase64Buffer();
        try {
            if (i4 < 0) {
                i4 = p(base64Variant, inputStream, allocBase64Buffer);
            } else {
                int q4 = q(base64Variant, inputStream, allocBase64Buffer, i4);
                if (q4 > 0) {
                    c("Too few bytes available: missing " + q4 + " bytes (out of " + i4 + ")");
                }
            }
            this.f17789g.releaseBase64Buffer(allocBase64Buffer);
            if (this.f17809o >= this.f17810p) {
                h();
            }
            byte[] bArr2 = this.f17808n;
            int i6 = this.f17809o;
            this.f17809o = i6 + 1;
            bArr2[i6] = 34;
            return i4;
        } catch (Throwable th) {
            this.f17789g.releaseBase64Buffer(allocBase64Buffer);
            throw th;
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public final void writeFieldName(SerializableString serializableString) throws IOException, JsonGenerationException {
        int writeFieldName = this.f17669e.writeFieldName(serializableString.getValue());
        if (writeFieldName == 4) {
            c("Can not write a field name, expecting a value");
        }
        if (this.f17656a != null) {
            C(serializableString, writeFieldName == 1);
            return;
        }
        if (writeFieldName == 1) {
            if (this.f17809o >= this.f17810p) {
                h();
            }
            byte[] bArr = this.f17808n;
            int i4 = this.f17809o;
            this.f17809o = i4 + 1;
            bArr[i4] = 44;
        }
        w(serializableString);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(SerializableString serializableString) throws IOException, JsonGenerationException {
        byte[] asUnquotedUTF8 = serializableString.asUnquotedUTF8();
        if (asUnquotedUTF8.length > 0) {
            s(asUnquotedUTF8);
        }
    }

    public UTF8JsonGenerator(IOContext iOContext, int i4, ObjectCodec objectCodec, OutputStream outputStream, byte[] bArr, int i5, boolean z3) {
        super(iOContext, i4, objectCodec);
        this.f17807m = outputStream;
        this.f17814t = z3;
        this.f17809o = i5;
        this.f17808n = bArr;
        int length = bArr.length;
        this.f17810p = length;
        this.f17811q = length >> 3;
        char[] allocConcatBuffer = iOContext.allocConcatBuffer();
        this.f17812r = allocConcatBuffer;
        this.f17813s = allocConcatBuffer.length;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigInteger bigInteger) throws IOException, JsonGenerationException {
        e("write number");
        if (bigInteger == null) {
            B();
        } else if (this.f17668d) {
            G(bigInteger);
        } else {
            writeRaw(bigInteger.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
        if (r0 >= 2048) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:
        r1 = r5.f17808n;
        r2 = r5.f17809o;
        r3 = r2 + 1;
        r1[r2] = (byte) ((r0 >> 6) | 192);
        r5.f17809o = r3 + 1;
        r1[r3] = (byte) ((r0 & '?') | 128);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
        k(r0, r6, r7, r8);
     */
    @Override // com.fasterxml.jackson.core.JsonGenerator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void writeRaw(char[] r6, int r7, int r8) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
            r5 = this;
            int r0 = r8 + r8
            int r0 = r0 + r8
            int r1 = r5.f17809o
            int r1 = r1 + r0
            int r2 = r5.f17810p
            if (r1 <= r2) goto L13
            if (r2 >= r0) goto L10
            r5.H(r6, r7, r8)
            return
        L10:
            r5.h()
        L13:
            int r8 = r8 + r7
        L14:
            if (r7 >= r8) goto L4e
        L16:
            char r0 = r6[r7]
            r1 = 127(0x7f, float:1.78E-43)
            if (r0 <= r1) goto L3f
            int r7 = r7 + 1
            r1 = 2048(0x800, float:2.87E-42)
            if (r0 >= r1) goto L3b
            byte[] r1 = r5.f17808n
            int r2 = r5.f17809o
            int r3 = r2 + 1
            int r4 = r0 >> 6
            r4 = r4 | 192(0xc0, float:2.69E-43)
            byte r4 = (byte) r4
            r1[r2] = r4
            int r2 = r3 + 1
            r5.f17809o = r2
            r0 = r0 & 63
            r0 = r0 | 128(0x80, float:1.794E-43)
            byte r0 = (byte) r0
            r1[r3] = r0
            goto L14
        L3b:
            r5.k(r0, r6, r7, r8)
            goto L14
        L3f:
            byte[] r1 = r5.f17808n
            int r2 = r5.f17809o
            int r3 = r2 + 1
            r5.f17809o = r3
            byte r0 = (byte) r0
            r1[r2] = r0
            int r7 = r7 + 1
            if (r7 < r8) goto L16
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8JsonGenerator.writeRaw(char[], int, int):void");
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(char[] cArr, int i4, int i5) throws IOException, JsonGenerationException {
        e("write text value");
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr = this.f17808n;
        int i6 = this.f17809o;
        int i7 = i6 + 1;
        this.f17809o = i7;
        bArr[i6] = 34;
        if (i5 <= this.f17811q) {
            if (i7 + i5 > this.f17810p) {
                h();
            }
            I(cArr, i4, i5);
        } else {
            M(cArr, i4, i5);
        }
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr2 = this.f17808n;
        int i8 = this.f17809o;
        this.f17809o = i8 + 1;
        bArr2[i8] = 34;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(double d4) throws IOException, JsonGenerationException {
        if (!this.f17668d && ((!Double.isNaN(d4) && !Double.isInfinite(d4)) || !isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            e("write number");
            writeRaw(String.valueOf(d4));
            return;
        }
        writeString(String.valueOf(d4));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char c4) throws IOException, JsonGenerationException {
        if (this.f17809o + 3 >= this.f17810p) {
            h();
        }
        byte[] bArr = this.f17808n;
        if (c4 <= 127) {
            int i4 = this.f17809o;
            this.f17809o = i4 + 1;
            bArr[i4] = (byte) c4;
        } else if (c4 < 2048) {
            int i5 = this.f17809o;
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((c4 >> 6) | 192);
            this.f17809o = i6 + 1;
            bArr[i6] = (byte) ((c4 & '?') | 128);
        } else {
            k(c4, null, 0, 0);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(float f4) throws IOException, JsonGenerationException {
        if (!this.f17668d && ((!Float.isNaN(f4) && !Float.isInfinite(f4)) || !isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            e("write number");
            writeRaw(String.valueOf(f4));
            return;
        }
        writeString(String.valueOf(f4));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigDecimal bigDecimal) throws IOException, JsonGenerationException {
        e("write number");
        if (bigDecimal == null) {
            B();
        } else if (this.f17668d) {
            G(bigDecimal);
        } else {
            writeRaw(bigDecimal.toString());
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public final void writeString(SerializableString serializableString) throws IOException, JsonGenerationException {
        e("write text value");
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr = this.f17808n;
        int i4 = this.f17809o;
        int i5 = i4 + 1;
        this.f17809o = i5;
        bArr[i4] = 34;
        int appendQuotedUTF8 = serializableString.appendQuotedUTF8(bArr, i5);
        if (appendQuotedUTF8 < 0) {
            s(serializableString.asQuotedUTF8());
        } else {
            this.f17809o += appendQuotedUTF8;
        }
        if (this.f17809o >= this.f17810p) {
            h();
        }
        byte[] bArr2 = this.f17808n;
        int i6 = this.f17809o;
        this.f17809o = i6 + 1;
        bArr2[i6] = 34;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(String str) throws IOException, JsonGenerationException {
        e("write number");
        if (this.f17668d) {
            G(str);
        } else {
            writeRaw(str);
        }
    }
}
