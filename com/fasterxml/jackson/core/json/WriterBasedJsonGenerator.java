package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.text.Typography;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.pool.TypePool;

/* loaded from: classes3.dex */
public final class WriterBasedJsonGenerator extends JsonGeneratorImpl {

    /* renamed from: t  reason: collision with root package name */
    protected static final char[] f17816t = CharTypes.copyHexChars();

    /* renamed from: m  reason: collision with root package name */
    protected final Writer f17817m;

    /* renamed from: n  reason: collision with root package name */
    protected char[] f17818n;

    /* renamed from: o  reason: collision with root package name */
    protected int f17819o;

    /* renamed from: p  reason: collision with root package name */
    protected int f17820p;

    /* renamed from: q  reason: collision with root package name */
    protected int f17821q;

    /* renamed from: r  reason: collision with root package name */
    protected char[] f17822r;

    /* renamed from: s  reason: collision with root package name */
    protected SerializableString f17823s;

    public WriterBasedJsonGenerator(IOContext iOContext, int i4, ObjectCodec objectCodec, Writer writer) {
        super(iOContext, i4, objectCodec);
        this.f17819o = 0;
        this.f17820p = 0;
        this.f17817m = writer;
        char[] allocConcatBuffer = iOContext.allocConcatBuffer();
        this.f17818n = allocConcatBuffer;
        this.f17821q = allocConcatBuffer.length;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0021 A[EDGE_INSN: B:26:0x0021->B:13:0x0021 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A(int r13, int r14) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
            r12 = this;
            int[] r0 = r12.f17790h
            int r1 = r0.length
            int r2 = r14 + 1
            int r1 = java.lang.Math.min(r1, r2)
            r2 = 0
            r3 = 0
            r4 = 0
        Lc:
            if (r2 >= r13) goto L3a
        Le:
            char[] r5 = r12.f17818n
            char r10 = r5[r2]
            if (r10 >= r1) goto L19
            r4 = r0[r10]
            if (r4 == 0) goto L1d
            goto L21
        L19:
            if (r10 <= r14) goto L1d
            r4 = -1
            goto L21
        L1d:
            int r2 = r2 + 1
            if (r2 < r13) goto Le
        L21:
            int r6 = r2 - r3
            if (r6 <= 0) goto L2d
            java.io.Writer r7 = r12.f17817m
            r7.write(r5, r3, r6)
            if (r2 < r13) goto L2d
            goto L3a
        L2d:
            int r2 = r2 + 1
            char[] r7 = r12.f17818n
            r6 = r12
            r8 = r2
            r9 = r13
            r11 = r4
            int r3 = r6.j(r7, r8, r9, r10, r11)
            goto Lc
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.WriterBasedJsonGenerator.A(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0035 A[EDGE_INSN: B:31:0x0035->B:19:0x0035 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void B(int r15) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
            r14 = this;
            int[] r0 = r14.f17790h
            int r1 = r14.f17791i
            r2 = 1
            if (r1 >= r2) goto La
            r1 = 65535(0xffff, float:9.1834E-41)
        La:
            int r2 = r0.length
            int r3 = r1 + 1
            int r2 = java.lang.Math.min(r2, r3)
            com.fasterxml.jackson.core.io.CharacterEscapes r3 = r14.f17792j
            r4 = 0
            r5 = 0
            r6 = 0
        L16:
            if (r4 >= r15) goto L50
        L18:
            char[] r7 = r14.f17818n
            char r12 = r7[r4]
            if (r12 >= r2) goto L23
            r6 = r0[r12]
            if (r6 == 0) goto L31
            goto L35
        L23:
            if (r12 <= r1) goto L27
            r6 = -1
            goto L35
        L27:
            com.fasterxml.jackson.core.SerializableString r7 = r3.getEscapeSequence(r12)
            r14.f17823s = r7
            if (r7 == 0) goto L31
            r6 = -2
            goto L35
        L31:
            int r4 = r4 + 1
            if (r4 < r15) goto L18
        L35:
            int r7 = r4 - r5
            if (r7 <= 0) goto L43
            java.io.Writer r8 = r14.f17817m
            char[] r9 = r14.f17818n
            r8.write(r9, r5, r7)
            if (r4 < r15) goto L43
            goto L50
        L43:
            int r4 = r4 + 1
            char[] r9 = r14.f17818n
            r8 = r14
            r10 = r4
            r11 = r15
            r13 = r6
            int r5 = r8.j(r9, r10, r11, r12, r13)
            goto L16
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.WriterBasedJsonGenerator.B(int):void");
    }

    private void C(String str) throws IOException, JsonGenerationException {
        int length = str.length();
        int i4 = this.f17821q;
        if (length > i4) {
            s(str);
            return;
        }
        if (this.f17820p + length > i4) {
            i();
        }
        str.getChars(0, length, this.f17818n, this.f17820p);
        if (this.f17792j != null) {
            H(length);
            return;
        }
        int i5 = this.f17791i;
        if (i5 != 0) {
            F(length, i5);
        } else {
            E(length);
        }
    }

    private void D(char[] cArr, int i4, int i5) throws IOException, JsonGenerationException {
        if (this.f17792j != null) {
            I(cArr, i4, i5);
            return;
        }
        int i6 = this.f17791i;
        if (i6 != 0) {
            G(cArr, i4, i5, i6);
            return;
        }
        int i7 = i5 + i4;
        int[] iArr = this.f17790h;
        int length = iArr.length;
        while (i4 < i7) {
            int i8 = i4;
            do {
                char c4 = cArr[i8];
                if (c4 < length && iArr[c4] != 0) {
                    break;
                }
                i8++;
            } while (i8 < i7);
            int i9 = i8 - i4;
            if (i9 < 32) {
                if (this.f17820p + i9 > this.f17821q) {
                    i();
                }
                if (i9 > 0) {
                    System.arraycopy(cArr, i4, this.f17818n, this.f17820p, i9);
                    this.f17820p += i9;
                }
            } else {
                i();
                this.f17817m.write(cArr, i4, i9);
            }
            if (i8 < i7) {
                i4 = i8 + 1;
                char c5 = cArr[i8];
                h(c5, iArr[c5]);
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
        if (r3 <= 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
        r6.f17817m.write(r2, r4, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
        r2 = r6.f17818n;
        r3 = r6.f17820p;
        r6.f17820p = r3 + 1;
        r2 = r2[r3];
        k(r2, r7[r2]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
        r4 = r6.f17819o;
        r3 = r3 - r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void E(int r7) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
            r6 = this;
            int r0 = r6.f17820p
            int r0 = r0 + r7
            int[] r7 = r6.f17790h
            int r1 = r7.length
        L6:
            int r2 = r6.f17820p
            if (r2 >= r0) goto L36
        La:
            char[] r2 = r6.f17818n
            int r3 = r6.f17820p
            char r4 = r2[r3]
            if (r4 >= r1) goto L30
            r4 = r7[r4]
            if (r4 == 0) goto L30
            int r4 = r6.f17819o
            int r3 = r3 - r4
            if (r3 <= 0) goto L20
            java.io.Writer r5 = r6.f17817m
            r5.write(r2, r4, r3)
        L20:
            char[] r2 = r6.f17818n
            int r3 = r6.f17820p
            int r4 = r3 + 1
            r6.f17820p = r4
            char r2 = r2[r3]
            r3 = r7[r2]
            r6.k(r2, r3)
            goto L6
        L30:
            int r3 = r3 + 1
            r6.f17820p = r3
            if (r3 < r0) goto La
        L36:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.WriterBasedJsonGenerator.E(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void F(int r9, int r10) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
            r8 = this;
            int r0 = r8.f17820p
            int r0 = r0 + r9
            int[] r9 = r8.f17790h
            int r1 = r9.length
            int r2 = r10 + 1
            int r1 = java.lang.Math.min(r1, r2)
        Lc:
            int r2 = r8.f17820p
            if (r2 >= r0) goto L3a
        L10:
            char[] r2 = r8.f17818n
            int r3 = r8.f17820p
            char r4 = r2[r3]
            if (r4 >= r1) goto L1d
            r5 = r9[r4]
            if (r5 == 0) goto L34
            goto L20
        L1d:
            if (r4 <= r10) goto L34
            r5 = -1
        L20:
            int r6 = r8.f17819o
            int r3 = r3 - r6
            if (r3 <= 0) goto L2a
            java.io.Writer r7 = r8.f17817m
            r7.write(r2, r6, r3)
        L2a:
            int r2 = r8.f17820p
            int r2 = r2 + 1
            r8.f17820p = r2
            r8.k(r4, r5)
            goto Lc
        L34:
            int r3 = r3 + 1
            r8.f17820p = r3
            if (r3 < r0) goto L10
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.WriterBasedJsonGenerator.F(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x001f A[EDGE_INSN: B:30:0x001f->B:14:0x001f ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void G(char[] r9, int r10, int r11, int r12) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
            r8 = this;
            int r11 = r11 + r10
            int[] r0 = r8.f17790h
            int r1 = r0.length
            int r2 = r12 + 1
            int r1 = java.lang.Math.min(r1, r2)
            r2 = 0
        Lb:
            if (r10 >= r11) goto L4f
            r3 = r10
        Le:
            char r4 = r9[r3]
            if (r4 >= r1) goto L17
            r2 = r0[r4]
            if (r2 == 0) goto L1b
            goto L1f
        L17:
            if (r4 <= r12) goto L1b
            r2 = -1
            goto L1f
        L1b:
            int r3 = r3 + 1
            if (r3 < r11) goto Le
        L1f:
            int r5 = r3 - r10
            r6 = 32
            if (r5 >= r6) goto L3e
            int r6 = r8.f17820p
            int r6 = r6 + r5
            int r7 = r8.f17821q
            if (r6 <= r7) goto L2f
            r8.i()
        L2f:
            if (r5 <= 0) goto L46
            char[] r6 = r8.f17818n
            int r7 = r8.f17820p
            java.lang.System.arraycopy(r9, r10, r6, r7, r5)
            int r10 = r8.f17820p
            int r10 = r10 + r5
            r8.f17820p = r10
            goto L46
        L3e:
            r8.i()
            java.io.Writer r6 = r8.f17817m
            r6.write(r9, r10, r5)
        L46:
            if (r3 < r11) goto L49
            goto L4f
        L49:
            int r10 = r3 + 1
            r8.h(r4, r2)
            goto Lb
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.WriterBasedJsonGenerator.G(char[], int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0052 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void H(int r12) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
            r11 = this;
            int r0 = r11.f17820p
            int r0 = r0 + r12
            int[] r12 = r11.f17790h
            int r1 = r11.f17791i
            r2 = 1
            if (r1 >= r2) goto Ld
            r1 = 65535(0xffff, float:9.1834E-41)
        Ld:
            int r3 = r12.length
            int r4 = r1 + 1
            int r3 = java.lang.Math.min(r3, r4)
            com.fasterxml.jackson.core.io.CharacterEscapes r4 = r11.f17792j
        L16:
            int r5 = r11.f17820p
            if (r5 >= r0) goto L52
        L1a:
            char[] r5 = r11.f17818n
            int r6 = r11.f17820p
            char r5 = r5[r6]
            if (r5 >= r3) goto L27
            r6 = r12[r5]
            if (r6 == 0) goto L4b
            goto L34
        L27:
            if (r5 <= r1) goto L2b
            r6 = -1
            goto L34
        L2b:
            com.fasterxml.jackson.core.SerializableString r6 = r4.getEscapeSequence(r5)
            r11.f17823s = r6
            if (r6 == 0) goto L4b
            r6 = -2
        L34:
            int r7 = r11.f17820p
            int r8 = r11.f17819o
            int r7 = r7 - r8
            if (r7 <= 0) goto L42
            java.io.Writer r9 = r11.f17817m
            char[] r10 = r11.f17818n
            r9.write(r10, r8, r7)
        L42:
            int r7 = r11.f17820p
            int r7 = r7 + r2
            r11.f17820p = r7
            r11.k(r5, r6)
            goto L16
        L4b:
            int r5 = r11.f17820p
            int r5 = r5 + r2
            r11.f17820p = r5
            if (r5 < r0) goto L1a
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.WriterBasedJsonGenerator.H(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0033 A[EDGE_INSN: B:34:0x0033->B:20:0x0033 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void I(char[] r11, int r12, int r13) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
            r10 = this;
            int r13 = r13 + r12
            int[] r0 = r10.f17790h
            int r1 = r10.f17791i
            r2 = 1
            if (r1 >= r2) goto Lb
            r1 = 65535(0xffff, float:9.1834E-41)
        Lb:
            int r2 = r0.length
            int r3 = r1 + 1
            int r2 = java.lang.Math.min(r2, r3)
            com.fasterxml.jackson.core.io.CharacterEscapes r3 = r10.f17792j
            r4 = 0
        L15:
            if (r12 >= r13) goto L63
            r5 = r12
        L18:
            char r6 = r11[r5]
            if (r6 >= r2) goto L21
            r4 = r0[r6]
            if (r4 == 0) goto L2f
            goto L33
        L21:
            if (r6 <= r1) goto L25
            r4 = -1
            goto L33
        L25:
            com.fasterxml.jackson.core.SerializableString r7 = r3.getEscapeSequence(r6)
            r10.f17823s = r7
            if (r7 == 0) goto L2f
            r4 = -2
            goto L33
        L2f:
            int r5 = r5 + 1
            if (r5 < r13) goto L18
        L33:
            int r7 = r5 - r12
            r8 = 32
            if (r7 >= r8) goto L52
            int r8 = r10.f17820p
            int r8 = r8 + r7
            int r9 = r10.f17821q
            if (r8 <= r9) goto L43
            r10.i()
        L43:
            if (r7 <= 0) goto L5a
            char[] r8 = r10.f17818n
            int r9 = r10.f17820p
            java.lang.System.arraycopy(r11, r12, r8, r9, r7)
            int r12 = r10.f17820p
            int r12 = r12 + r7
            r10.f17820p = r12
            goto L5a
        L52:
            r10.i()
            java.io.Writer r8 = r10.f17817m
            r8.write(r11, r12, r7)
        L5a:
            if (r5 < r13) goto L5d
            goto L63
        L5d:
            int r12 = r5 + 1
            r10.h(r6, r4)
            goto L15
        L63:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.WriterBasedJsonGenerator.I(char[], int, int):void");
    }

    private void J(String str) throws IOException, JsonGenerationException {
        int i4 = this.f17821q;
        int i5 = this.f17820p;
        int i6 = i4 - i5;
        str.getChars(0, i6, this.f17818n, i5);
        this.f17820p += i6;
        i();
        int length = str.length() - i6;
        while (true) {
            int i7 = this.f17821q;
            if (length > i7) {
                int i8 = i6 + i7;
                str.getChars(i6, i8, this.f17818n, 0);
                this.f17819o = 0;
                this.f17820p = i7;
                i();
                length -= i7;
                i6 = i8;
            } else {
                str.getChars(i6, i6 + length, this.f17818n, 0);
                this.f17819o = 0;
                this.f17820p = length;
                return;
            }
        }
    }

    private char[] g() {
        char[] cArr = {'\\', 0, '\\', 'u', '0', '0', 0, 0, '\\', 'u'};
        this.f17822r = cArr;
        return cArr;
    }

    private void h(char c4, int i4) throws IOException, JsonGenerationException {
        String value;
        int i5;
        if (i4 >= 0) {
            if (this.f17820p + 2 > this.f17821q) {
                i();
            }
            char[] cArr = this.f17818n;
            int i6 = this.f17820p;
            int i7 = i6 + 1;
            cArr[i6] = '\\';
            this.f17820p = i7 + 1;
            cArr[i7] = (char) i4;
        } else if (i4 != -2) {
            if (this.f17820p + 2 > this.f17821q) {
                i();
            }
            int i8 = this.f17820p;
            char[] cArr2 = this.f17818n;
            int i9 = i8 + 1;
            cArr2[i8] = '\\';
            int i10 = i9 + 1;
            cArr2[i9] = 'u';
            if (c4 > 255) {
                int i11 = 255 & (c4 >> '\b');
                int i12 = i10 + 1;
                char[] cArr3 = f17816t;
                cArr2[i10] = cArr3[i11 >> 4];
                i5 = i12 + 1;
                cArr2[i12] = cArr3[i11 & 15];
                c4 = (char) (c4 & 255);
            } else {
                int i13 = i10 + 1;
                cArr2[i10] = '0';
                i5 = i13 + 1;
                cArr2[i13] = '0';
            }
            int i14 = i5 + 1;
            char[] cArr4 = f17816t;
            cArr2[i5] = cArr4[c4 >> 4];
            cArr2[i14] = cArr4[c4 & 15];
            this.f17820p = i14;
        } else {
            SerializableString serializableString = this.f17823s;
            if (serializableString == null) {
                value = this.f17792j.getEscapeSequence(c4).getValue();
            } else {
                value = serializableString.getValue();
                this.f17823s = null;
            }
            int length = value.length();
            if (this.f17820p + length > this.f17821q) {
                i();
                if (length > this.f17821q) {
                    this.f17817m.write(value);
                    return;
                }
            }
            value.getChars(0, length, this.f17818n, this.f17820p);
            this.f17820p += length;
        }
    }

    private int j(char[] cArr, int i4, int i5, char c4, int i6) throws IOException, JsonGenerationException {
        String value;
        int i7;
        if (i6 >= 0) {
            if (i4 > 1 && i4 < i5) {
                int i8 = i4 - 2;
                cArr[i8] = '\\';
                cArr[i8 + 1] = (char) i6;
                return i8;
            }
            char[] cArr2 = this.f17822r;
            if (cArr2 == null) {
                cArr2 = g();
            }
            cArr2[1] = (char) i6;
            this.f17817m.write(cArr2, 0, 2);
            return i4;
        } else if (i6 != -2) {
            if (i4 > 5 && i4 < i5) {
                int i9 = i4 - 6;
                int i10 = i9 + 1;
                cArr[i9] = '\\';
                int i11 = i10 + 1;
                cArr[i10] = 'u';
                if (c4 > 255) {
                    int i12 = (c4 >> '\b') & 255;
                    int i13 = i11 + 1;
                    char[] cArr3 = f17816t;
                    cArr[i11] = cArr3[i12 >> 4];
                    i7 = i13 + 1;
                    cArr[i13] = cArr3[i12 & 15];
                    c4 = (char) (c4 & 255);
                } else {
                    int i14 = i11 + 1;
                    cArr[i11] = '0';
                    i7 = i14 + 1;
                    cArr[i14] = '0';
                }
                int i15 = i7 + 1;
                char[] cArr4 = f17816t;
                cArr[i7] = cArr4[c4 >> 4];
                cArr[i15] = cArr4[c4 & 15];
                return i15 - 5;
            }
            char[] cArr5 = this.f17822r;
            if (cArr5 == null) {
                cArr5 = g();
            }
            this.f17819o = this.f17820p;
            if (c4 > 255) {
                int i16 = (c4 >> '\b') & 255;
                int i17 = c4 & 255;
                char[] cArr6 = f17816t;
                cArr5[10] = cArr6[i16 >> 4];
                cArr5[11] = cArr6[i16 & 15];
                cArr5[12] = cArr6[i17 >> 4];
                cArr5[13] = cArr6[i17 & 15];
                this.f17817m.write(cArr5, 8, 6);
                return i4;
            }
            char[] cArr7 = f17816t;
            cArr5[6] = cArr7[c4 >> 4];
            cArr5[7] = cArr7[c4 & 15];
            this.f17817m.write(cArr5, 2, 6);
            return i4;
        } else {
            SerializableString serializableString = this.f17823s;
            if (serializableString == null) {
                value = this.f17792j.getEscapeSequence(c4).getValue();
            } else {
                value = serializableString.getValue();
                this.f17823s = null;
            }
            int length = value.length();
            if (i4 >= length && i4 < i5) {
                int i18 = i4 - length;
                value.getChars(0, length, cArr, i18);
                return i18;
            }
            this.f17817m.write(value);
            return i4;
        }
    }

    private void k(char c4, int i4) throws IOException, JsonGenerationException {
        String value;
        int i5;
        if (i4 >= 0) {
            int i6 = this.f17820p;
            if (i6 >= 2) {
                int i7 = i6 - 2;
                this.f17819o = i7;
                char[] cArr = this.f17818n;
                cArr[i7] = '\\';
                cArr[i7 + 1] = (char) i4;
                return;
            }
            char[] cArr2 = this.f17822r;
            if (cArr2 == null) {
                cArr2 = g();
            }
            this.f17819o = this.f17820p;
            cArr2[1] = (char) i4;
            this.f17817m.write(cArr2, 0, 2);
        } else if (i4 != -2) {
            int i8 = this.f17820p;
            if (i8 >= 6) {
                char[] cArr3 = this.f17818n;
                int i9 = i8 - 6;
                this.f17819o = i9;
                cArr3[i9] = '\\';
                int i10 = i9 + 1;
                cArr3[i10] = 'u';
                if (c4 > 255) {
                    int i11 = (c4 >> '\b') & 255;
                    int i12 = i10 + 1;
                    char[] cArr4 = f17816t;
                    cArr3[i12] = cArr4[i11 >> 4];
                    i5 = i12 + 1;
                    cArr3[i5] = cArr4[i11 & 15];
                    c4 = (char) (c4 & 255);
                } else {
                    int i13 = i10 + 1;
                    cArr3[i13] = '0';
                    i5 = i13 + 1;
                    cArr3[i5] = '0';
                }
                int i14 = i5 + 1;
                char[] cArr5 = f17816t;
                cArr3[i14] = cArr5[c4 >> 4];
                cArr3[i14 + 1] = cArr5[c4 & 15];
                return;
            }
            char[] cArr6 = this.f17822r;
            if (cArr6 == null) {
                cArr6 = g();
            }
            this.f17819o = this.f17820p;
            if (c4 > 255) {
                int i15 = (c4 >> '\b') & 255;
                int i16 = c4 & 255;
                char[] cArr7 = f17816t;
                cArr6[10] = cArr7[i15 >> 4];
                cArr6[11] = cArr7[i15 & 15];
                cArr6[12] = cArr7[i16 >> 4];
                cArr6[13] = cArr7[i16 & 15];
                this.f17817m.write(cArr6, 8, 6);
                return;
            }
            char[] cArr8 = f17816t;
            cArr6[6] = cArr8[c4 >> 4];
            cArr6[7] = cArr8[c4 & 15];
            this.f17817m.write(cArr6, 2, 6);
        } else {
            SerializableString serializableString = this.f17823s;
            if (serializableString == null) {
                value = this.f17792j.getEscapeSequence(c4).getValue();
            } else {
                value = serializableString.getValue();
                this.f17823s = null;
            }
            int length = value.length();
            int i17 = this.f17820p;
            if (i17 >= length) {
                int i18 = i17 - length;
                this.f17819o = i18;
                value.getChars(0, length, this.f17818n, i18);
                return;
            }
            this.f17819o = i17;
            this.f17817m.write(value);
        }
    }

    private int l(InputStream inputStream, byte[] bArr, int i4, int i5, int i6) throws IOException {
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

    private void s(String str) throws IOException, JsonGenerationException {
        i();
        int length = str.length();
        int i4 = 0;
        while (true) {
            int i5 = this.f17821q;
            if (i4 + i5 > length) {
                i5 = length - i4;
            }
            int i6 = i4 + i5;
            str.getChars(i4, i6, this.f17818n, 0);
            if (this.f17792j != null) {
                B(i5);
            } else {
                int i7 = this.f17791i;
                if (i7 != 0) {
                    A(i5, i7);
                } else {
                    z(i5);
                }
            }
            if (i6 >= length) {
                return;
            }
            i4 = i6;
        }
    }

    private void t() throws IOException {
        if (this.f17820p + 4 >= this.f17821q) {
            i();
        }
        int i4 = this.f17820p;
        char[] cArr = this.f17818n;
        cArr[i4] = 'n';
        int i5 = i4 + 1;
        cArr[i5] = 'u';
        int i6 = i5 + 1;
        cArr[i6] = 'l';
        int i7 = i6 + 1;
        cArr[i7] = 'l';
        this.f17820p = i7 + 1;
    }

    private void w(int i4) throws IOException {
        if (this.f17820p + 13 >= this.f17821q) {
            i();
        }
        char[] cArr = this.f17818n;
        int i5 = this.f17820p;
        int i6 = i5 + 1;
        this.f17820p = i6;
        cArr[i5] = Typography.quote;
        int outputInt = NumberOutput.outputInt(i4, cArr, i6);
        char[] cArr2 = this.f17818n;
        this.f17820p = outputInt + 1;
        cArr2[outputInt] = Typography.quote;
    }

    private void x(long j4) throws IOException {
        if (this.f17820p + 23 >= this.f17821q) {
            i();
        }
        char[] cArr = this.f17818n;
        int i4 = this.f17820p;
        int i5 = i4 + 1;
        this.f17820p = i5;
        cArr[i4] = Typography.quote;
        int outputLong = NumberOutput.outputLong(j4, cArr, i5);
        char[] cArr2 = this.f17818n;
        this.f17820p = outputLong + 1;
        cArr2[outputLong] = Typography.quote;
    }

    private void y(Object obj) throws IOException {
        if (this.f17820p >= this.f17821q) {
            i();
        }
        char[] cArr = this.f17818n;
        int i4 = this.f17820p;
        this.f17820p = i4 + 1;
        cArr[i4] = Typography.quote;
        writeRaw(obj.toString());
        if (this.f17820p >= this.f17821q) {
            i();
        }
        char[] cArr2 = this.f17818n;
        int i5 = this.f17820p;
        this.f17820p = i5 + 1;
        cArr2[i5] = Typography.quote;
    }

    private void z(int i4) throws IOException, JsonGenerationException {
        char[] cArr;
        char c4;
        int[] iArr = this.f17790h;
        int length = iArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            do {
                cArr = this.f17818n;
                c4 = cArr[i5];
                if (c4 < length && iArr[c4] != 0) {
                    break;
                }
                i5++;
            } while (i5 < i4);
            int i7 = i5 - i6;
            if (i7 > 0) {
                this.f17817m.write(cArr, i6, i7);
                if (i5 >= i4) {
                    return;
                }
            }
            i5++;
            i6 = j(this.f17818n, i5, i4, c4, iArr[c4]);
        }
    }

    public void _writeFieldName(SerializableString serializableString, boolean z3) throws IOException, JsonGenerationException {
        if (this.f17656a != null) {
            u(serializableString, z3);
            return;
        }
        if (this.f17820p + 1 >= this.f17821q) {
            i();
        }
        if (z3) {
            char[] cArr = this.f17818n;
            int i4 = this.f17820p;
            this.f17820p = i4 + 1;
            cArr[i4] = ',';
        }
        char[] asQuotedChars = serializableString.asQuotedChars();
        if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            writeRaw(asQuotedChars, 0, asQuotedChars.length);
            return;
        }
        char[] cArr2 = this.f17818n;
        int i5 = this.f17820p;
        int i6 = i5 + 1;
        this.f17820p = i6;
        cArr2[i5] = Typography.quote;
        int length = asQuotedChars.length;
        if (i6 + length + 1 >= this.f17821q) {
            writeRaw(asQuotedChars, 0, length);
            if (this.f17820p >= this.f17821q) {
                i();
            }
            char[] cArr3 = this.f17818n;
            int i7 = this.f17820p;
            this.f17820p = i7 + 1;
            cArr3[i7] = Typography.quote;
            return;
        }
        System.arraycopy(asQuotedChars, 0, cArr2, i6, length);
        int i8 = this.f17820p + length;
        char[] cArr4 = this.f17818n;
        this.f17820p = i8 + 1;
        cArr4[i8] = Typography.quote;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (this.f17818n != null && isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)) {
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
        i();
        if (this.f17817m != null) {
            if (!this.f17789g.isResourceManaged() && !isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
                if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
                    this.f17817m.flush();
                }
            } else {
                this.f17817m.close();
            }
        }
        m();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    protected void e(String str) throws IOException, JsonGenerationException {
        char c4;
        SerializableString serializableString;
        int writeValue = this.f17669e.writeValue();
        if (writeValue == 5) {
            c("Can not " + str + ", expecting field name");
        }
        if (this.f17656a == null) {
            if (writeValue != 1) {
                if (writeValue != 2) {
                    if (writeValue == 3 && (serializableString = this.f17793k) != null) {
                        writeRaw(serializableString.getValue());
                        return;
                    }
                    return;
                }
                c4 = ':';
            } else {
                c4 = ',';
            }
            if (this.f17820p >= this.f17821q) {
                i();
            }
            char[] cArr = this.f17818n;
            int i4 = this.f17820p;
            cArr[i4] = c4;
            this.f17820p = i4 + 1;
            return;
        }
        n(str, writeValue);
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public void flush() throws IOException {
        i();
        if (this.f17817m != null && isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            this.f17817m.flush();
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public Object getOutputTarget() {
        return this.f17817m;
    }

    protected void i() throws IOException {
        int i4 = this.f17820p;
        int i5 = this.f17819o;
        int i6 = i4 - i5;
        if (i6 > 0) {
            this.f17819o = 0;
            this.f17820p = 0;
            this.f17817m.write(this.f17818n, i5, i6);
        }
    }

    protected void m() {
        char[] cArr = this.f17818n;
        if (cArr != null) {
            this.f17818n = null;
            this.f17789g.releaseConcatBuffer(cArr);
        }
    }

    protected void n(String str, int i4) throws IOException, JsonGenerationException {
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

    protected int o(Base64Variant base64Variant, InputStream inputStream, byte[] bArr) throws IOException, JsonGenerationException {
        int i4 = this.f17821q - 6;
        int i5 = 2;
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        int i6 = -3;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i7 > i6) {
                i8 = l(inputStream, bArr, i7, i8, bArr.length);
                if (i8 < 3) {
                    break;
                }
                i6 = i8 - 3;
                i7 = 0;
            }
            if (this.f17820p > i4) {
                i();
            }
            int i10 = i7 + 1;
            int i11 = i10 + 1;
            i7 = i11 + 1;
            i9 += 3;
            int encodeBase64Chunk = base64Variant.encodeBase64Chunk((((bArr[i10] & 255) | (bArr[i7] << 8)) << 8) | (bArr[i11] & 255), this.f17818n, this.f17820p);
            this.f17820p = encodeBase64Chunk;
            maxLineLength--;
            if (maxLineLength <= 0) {
                char[] cArr = this.f17818n;
                int i12 = encodeBase64Chunk + 1;
                cArr[encodeBase64Chunk] = '\\';
                this.f17820p = i12 + 1;
                cArr[i12] = 'n';
                maxLineLength = base64Variant.getMaxLineLength() >> 2;
            }
        }
        if (i8 > 0) {
            if (this.f17820p > i4) {
                i();
            }
            int i13 = bArr[0] << Ascii.DLE;
            if (1 < i8) {
                i13 |= (bArr[1] & 255) << 8;
            } else {
                i5 = 1;
            }
            int i14 = i9 + i5;
            this.f17820p = base64Variant.encodeBase64Partial(i13, i5, this.f17818n, this.f17820p);
            return i14;
        }
        return i9;
    }

    protected int p(Base64Variant base64Variant, InputStream inputStream, byte[] bArr, int i4) throws IOException, JsonGenerationException {
        int l4;
        int i5 = this.f17821q - 6;
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
                i9 = l(inputStream, bArr, i8, i9, i4);
                if (i9 < 3) {
                    i8 = 0;
                    break;
                }
                i7 = i9 - 3;
                i8 = 0;
            }
            if (this.f17820p > i5) {
                i();
            }
            int i10 = i8 + 1;
            int i11 = i10 + 1;
            i8 = i11 + 1;
            i4 -= 3;
            int encodeBase64Chunk = base64Variant.encodeBase64Chunk((((bArr[i10] & 255) | (bArr[i8] << 8)) << 8) | (bArr[i11] & 255), this.f17818n, this.f17820p);
            this.f17820p = encodeBase64Chunk;
            maxLineLength--;
            if (maxLineLength <= 0) {
                char[] cArr = this.f17818n;
                int i12 = encodeBase64Chunk + 1;
                cArr[encodeBase64Chunk] = '\\';
                this.f17820p = i12 + 1;
                cArr[i12] = 'n';
                maxLineLength = base64Variant.getMaxLineLength() >> 2;
            }
        }
        if (i4 > 0 && (l4 = l(inputStream, bArr, i8, i9, i4)) > 0) {
            if (this.f17820p > i5) {
                i();
            }
            int i13 = bArr[0] << Ascii.DLE;
            if (1 < l4) {
                i13 |= (bArr[1] & 255) << 8;
            } else {
                i6 = 1;
            }
            this.f17820p = base64Variant.encodeBase64Partial(i13, i6, this.f17818n, this.f17820p);
            return i4 - i6;
        }
        return i4;
    }

    protected void q(Base64Variant base64Variant, byte[] bArr, int i4, int i5) throws IOException, JsonGenerationException {
        int i6 = i5 - 3;
        int i7 = this.f17821q - 6;
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        while (i4 <= i6) {
            if (this.f17820p > i7) {
                i();
            }
            int i8 = i4 + 1;
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            int encodeBase64Chunk = base64Variant.encodeBase64Chunk((((bArr[i4] << 8) | (bArr[i8] & 255)) << 8) | (bArr[i9] & 255), this.f17818n, this.f17820p);
            this.f17820p = encodeBase64Chunk;
            maxLineLength--;
            if (maxLineLength <= 0) {
                char[] cArr = this.f17818n;
                int i11 = encodeBase64Chunk + 1;
                cArr[encodeBase64Chunk] = '\\';
                this.f17820p = i11 + 1;
                cArr[i11] = 'n';
                maxLineLength = base64Variant.getMaxLineLength() >> 2;
            }
            i4 = i10;
        }
        int i12 = i5 - i4;
        if (i12 > 0) {
            if (this.f17820p > i7) {
                i();
            }
            int i13 = i4 + 1;
            int i14 = bArr[i4] << Ascii.DLE;
            if (i12 == 2) {
                i14 |= (bArr[i13] & 255) << 8;
            }
            this.f17820p = base64Variant.encodeBase64Partial(i14, i12, this.f17818n, this.f17820p);
        }
    }

    protected void r(String str, boolean z3) throws IOException, JsonGenerationException {
        if (this.f17656a != null) {
            v(str, z3);
            return;
        }
        if (this.f17820p + 1 >= this.f17821q) {
            i();
        }
        if (z3) {
            char[] cArr = this.f17818n;
            int i4 = this.f17820p;
            this.f17820p = i4 + 1;
            cArr[i4] = ',';
        }
        if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            C(str);
            return;
        }
        char[] cArr2 = this.f17818n;
        int i5 = this.f17820p;
        this.f17820p = i5 + 1;
        cArr2[i5] = Typography.quote;
        C(str);
        if (this.f17820p >= this.f17821q) {
            i();
        }
        char[] cArr3 = this.f17818n;
        int i6 = this.f17820p;
        this.f17820p = i6 + 1;
        cArr3[i6] = Typography.quote;
    }

    protected void u(SerializableString serializableString, boolean z3) throws IOException, JsonGenerationException {
        if (z3) {
            this.f17656a.writeObjectEntrySeparator(this);
        } else {
            this.f17656a.beforeObjectEntries(this);
        }
        char[] asQuotedChars = serializableString.asQuotedChars();
        if (isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            if (this.f17820p >= this.f17821q) {
                i();
            }
            char[] cArr = this.f17818n;
            int i4 = this.f17820p;
            this.f17820p = i4 + 1;
            cArr[i4] = Typography.quote;
            writeRaw(asQuotedChars, 0, asQuotedChars.length);
            if (this.f17820p >= this.f17821q) {
                i();
            }
            char[] cArr2 = this.f17818n;
            int i5 = this.f17820p;
            this.f17820p = i5 + 1;
            cArr2[i5] = Typography.quote;
            return;
        }
        writeRaw(asQuotedChars, 0, asQuotedChars.length);
    }

    protected void v(String str, boolean z3) throws IOException, JsonGenerationException {
        if (z3) {
            this.f17656a.writeObjectEntrySeparator(this);
        } else {
            this.f17656a.beforeObjectEntries(this);
        }
        if (isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            if (this.f17820p >= this.f17821q) {
                i();
            }
            char[] cArr = this.f17818n;
            int i4 = this.f17820p;
            this.f17820p = i4 + 1;
            cArr[i4] = Typography.quote;
            C(str);
            if (this.f17820p >= this.f17821q) {
                i();
            }
            char[] cArr2 = this.f17818n;
            int i5 = this.f17820p;
            this.f17820p = i5 + 1;
            cArr2[i5] = Typography.quote;
            return;
        }
        C(str);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i4, int i5) throws IOException, JsonGenerationException {
        e("write binary value");
        if (this.f17820p >= this.f17821q) {
            i();
        }
        char[] cArr = this.f17818n;
        int i6 = this.f17820p;
        this.f17820p = i6 + 1;
        cArr[i6] = Typography.quote;
        q(base64Variant, bArr, i4, i5 + i4);
        if (this.f17820p >= this.f17821q) {
            i();
        }
        char[] cArr2 = this.f17818n;
        int i7 = this.f17820p;
        this.f17820p = i7 + 1;
        cArr2[i7] = Typography.quote;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBoolean(boolean z3) throws IOException, JsonGenerationException {
        int i4;
        e("write boolean value");
        if (this.f17820p + 5 >= this.f17821q) {
            i();
        }
        int i5 = this.f17820p;
        char[] cArr = this.f17818n;
        if (z3) {
            cArr[i5] = Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL;
            int i6 = i5 + 1;
            cArr[i6] = Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL;
            int i7 = i6 + 1;
            cArr[i7] = 'u';
            i4 = i7 + 1;
            cArr[i4] = 'e';
        } else {
            cArr[i5] = 'f';
            int i8 = i5 + 1;
            cArr[i8] = 'a';
            int i9 = i8 + 1;
            cArr[i9] = 'l';
            int i10 = i9 + 1;
            cArr[i10] = Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL;
            i4 = i10 + 1;
            cArr[i4] = 'e';
        }
        this.f17820p = i4 + 1;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeEndArray() throws IOException, JsonGenerationException {
        if (!this.f17669e.inArray()) {
            c("Current context not an ARRAY but " + this.f17669e.getTypeDesc());
        }
        PrettyPrinter prettyPrinter = this.f17656a;
        if (prettyPrinter != null) {
            prettyPrinter.writeEndArray(this, this.f17669e.getEntryCount());
        } else {
            if (this.f17820p >= this.f17821q) {
                i();
            }
            char[] cArr = this.f17818n;
            int i4 = this.f17820p;
            this.f17820p = i4 + 1;
            cArr[i4] = ']';
        }
        this.f17669e = this.f17669e.getParent();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeEndObject() throws IOException, JsonGenerationException {
        if (!this.f17669e.inObject()) {
            c("Current context not an object but " + this.f17669e.getTypeDesc());
        }
        PrettyPrinter prettyPrinter = this.f17656a;
        if (prettyPrinter != null) {
            prettyPrinter.writeEndObject(this, this.f17669e.getEntryCount());
        } else {
            if (this.f17820p >= this.f17821q) {
                i();
            }
            char[] cArr = this.f17818n;
            int i4 = this.f17820p;
            this.f17820p = i4 + 1;
            cArr[i4] = '}';
        }
        this.f17669e = this.f17669e.getParent();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldName(String str) throws IOException, JsonGenerationException {
        int writeFieldName = this.f17669e.writeFieldName(str);
        if (writeFieldName == 4) {
            c("Can not write a field name, expecting a value");
        }
        r(str, writeFieldName == 1);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNull() throws IOException, JsonGenerationException {
        e("write null value");
        t();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(int i4) throws IOException, JsonGenerationException {
        e("write number");
        if (this.f17668d) {
            w(i4);
            return;
        }
        if (this.f17820p + 11 >= this.f17821q) {
            i();
        }
        this.f17820p = NumberOutput.outputInt(i4, this.f17818n, this.f17820p);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str) throws IOException, JsonGenerationException {
        int length = str.length();
        int i4 = this.f17821q - this.f17820p;
        if (i4 == 0) {
            i();
            i4 = this.f17821q - this.f17820p;
        }
        if (i4 >= length) {
            str.getChars(0, length, this.f17818n, this.f17820p);
            this.f17820p += length;
            return;
        }
        J(str);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRawUTF8String(byte[] bArr, int i4, int i5) throws IOException, JsonGenerationException {
        d();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartArray() throws IOException, JsonGenerationException {
        e("start an array");
        this.f17669e = this.f17669e.createChildArrayContext();
        PrettyPrinter prettyPrinter = this.f17656a;
        if (prettyPrinter != null) {
            prettyPrinter.writeStartArray(this);
            return;
        }
        if (this.f17820p >= this.f17821q) {
            i();
        }
        char[] cArr = this.f17818n;
        int i4 = this.f17820p;
        this.f17820p = i4 + 1;
        cArr[i4] = TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartObject() throws IOException, JsonGenerationException {
        e("start an object");
        this.f17669e = this.f17669e.createChildObjectContext();
        PrettyPrinter prettyPrinter = this.f17656a;
        if (prettyPrinter != null) {
            prettyPrinter.writeStartObject(this);
            return;
        }
        if (this.f17820p >= this.f17821q) {
            i();
        }
        char[] cArr = this.f17818n;
        int i4 = this.f17820p;
        this.f17820p = i4 + 1;
        cArr[i4] = '{';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(String str) throws IOException, JsonGenerationException {
        e("write text value");
        if (str == null) {
            t();
            return;
        }
        if (this.f17820p >= this.f17821q) {
            i();
        }
        char[] cArr = this.f17818n;
        int i4 = this.f17820p;
        this.f17820p = i4 + 1;
        cArr[i4] = Typography.quote;
        C(str);
        if (this.f17820p >= this.f17821q) {
            i();
        }
        char[] cArr2 = this.f17818n;
        int i5 = this.f17820p;
        this.f17820p = i5 + 1;
        cArr2[i5] = Typography.quote;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeUTF8String(byte[] bArr, int i4, int i5) throws IOException, JsonGenerationException {
        d();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldName(SerializableString serializableString) throws IOException, JsonGenerationException {
        int writeFieldName = this.f17669e.writeFieldName(serializableString.getValue());
        if (writeFieldName == 4) {
            c("Can not write a field name, expecting a value");
        }
        _writeFieldName(serializableString, writeFieldName == 1);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(long j4) throws IOException, JsonGenerationException {
        e("write number");
        if (this.f17668d) {
            x(j4);
            return;
        }
        if (this.f17820p + 21 >= this.f17821q) {
            i();
        }
        this.f17820p = NumberOutput.outputLong(j4, this.f17818n, this.f17820p);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str, int i4, int i5) throws IOException, JsonGenerationException {
        int i6 = this.f17821q - this.f17820p;
        if (i6 < i5) {
            i();
            i6 = this.f17821q - this.f17820p;
        }
        if (i6 >= i5) {
            str.getChars(i4, i4 + i5, this.f17818n, this.f17820p);
            this.f17820p += i5;
            return;
        }
        J(str.substring(i4, i5 + i4));
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public int writeBinary(Base64Variant base64Variant, InputStream inputStream, int i4) throws IOException, JsonGenerationException {
        e("write binary value");
        if (this.f17820p >= this.f17821q) {
            i();
        }
        char[] cArr = this.f17818n;
        int i5 = this.f17820p;
        this.f17820p = i5 + 1;
        cArr[i5] = Typography.quote;
        byte[] allocBase64Buffer = this.f17789g.allocBase64Buffer();
        try {
            if (i4 < 0) {
                i4 = o(base64Variant, inputStream, allocBase64Buffer);
            } else {
                int p4 = p(base64Variant, inputStream, allocBase64Buffer, i4);
                if (p4 > 0) {
                    c("Too few bytes available: missing " + p4 + " bytes (out of " + i4 + ")");
                }
            }
            this.f17789g.releaseBase64Buffer(allocBase64Buffer);
            if (this.f17820p >= this.f17821q) {
                i();
            }
            char[] cArr2 = this.f17818n;
            int i6 = this.f17820p;
            this.f17820p = i6 + 1;
            cArr2[i6] = Typography.quote;
            return i4;
        } catch (Throwable th) {
            this.f17789g.releaseBase64Buffer(allocBase64Buffer);
            throw th;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(char[] cArr, int i4, int i5) throws IOException, JsonGenerationException {
        e("write text value");
        if (this.f17820p >= this.f17821q) {
            i();
        }
        char[] cArr2 = this.f17818n;
        int i6 = this.f17820p;
        this.f17820p = i6 + 1;
        cArr2[i6] = Typography.quote;
        D(cArr, i4, i5);
        if (this.f17820p >= this.f17821q) {
            i();
        }
        char[] cArr3 = this.f17818n;
        int i7 = this.f17820p;
        this.f17820p = i7 + 1;
        cArr3[i7] = Typography.quote;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigInteger bigInteger) throws IOException, JsonGenerationException {
        e("write number");
        if (bigInteger == null) {
            t();
        } else if (this.f17668d) {
            y(bigInteger);
        } else {
            writeRaw(bigInteger.toString());
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(SerializableString serializableString) throws IOException, JsonGenerationException {
        writeRaw(serializableString.getValue());
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char[] cArr, int i4, int i5) throws IOException, JsonGenerationException {
        if (i5 < 32) {
            if (i5 > this.f17821q - this.f17820p) {
                i();
            }
            System.arraycopy(cArr, i4, this.f17818n, this.f17820p, i5);
            this.f17820p += i5;
            return;
        }
        i();
        this.f17817m.write(cArr, i4, i5);
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

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeString(SerializableString serializableString) throws IOException, JsonGenerationException {
        e("write text value");
        if (this.f17820p >= this.f17821q) {
            i();
        }
        char[] cArr = this.f17818n;
        int i4 = this.f17820p;
        this.f17820p = i4 + 1;
        cArr[i4] = Typography.quote;
        char[] asQuotedChars = serializableString.asQuotedChars();
        int length = asQuotedChars.length;
        if (length < 32) {
            if (length > this.f17821q - this.f17820p) {
                i();
            }
            System.arraycopy(asQuotedChars, 0, this.f17818n, this.f17820p, length);
            this.f17820p += length;
        } else {
            i();
            this.f17817m.write(asQuotedChars, 0, length);
        }
        if (this.f17820p >= this.f17821q) {
            i();
        }
        char[] cArr2 = this.f17818n;
        int i5 = this.f17820p;
        this.f17820p = i5 + 1;
        cArr2[i5] = Typography.quote;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char c4) throws IOException, JsonGenerationException {
        if (this.f17820p >= this.f17821q) {
            i();
        }
        char[] cArr = this.f17818n;
        int i4 = this.f17820p;
        this.f17820p = i4 + 1;
        cArr[i4] = c4;
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
            t();
        } else if (this.f17668d) {
            y(bigDecimal);
        } else {
            writeRaw(bigDecimal.toString());
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(String str) throws IOException, JsonGenerationException {
        e("write number");
        if (this.f17668d) {
            y(str);
        } else {
            writeRaw(str);
        }
    }
}
