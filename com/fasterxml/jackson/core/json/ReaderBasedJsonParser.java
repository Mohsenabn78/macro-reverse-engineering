package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* loaded from: classes3.dex */
public final class ReaderBasedJsonParser extends ParserBase {
    protected Reader M;
    protected char[] N;
    protected ObjectCodec O;
    protected final CharsToNameCanonicalizer P;
    protected final int Q;
    protected boolean R;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17802a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f17802a = iArr;
            try {
                iArr[JsonToken.FIELD_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17802a[JsonToken.VALUE_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17802a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17802a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17802a[JsonToken.VALUE_TRUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17802a[JsonToken.VALUE_FALSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ReaderBasedJsonParser(IOContext iOContext, int i4, Reader reader, ObjectCodec objectCodec, CharsToNameCanonicalizer charsToNameCanonicalizer) {
        super(iOContext, i4);
        this.R = false;
        this.M = reader;
        this.N = iOContext.allocTokenBuffer();
        this.O = objectCodec;
        this.P = charsToNameCanonicalizer;
        this.Q = charsToNameCanonicalizer.hashSeed();
    }

    private JsonToken c0() {
        this.f17687r = false;
        JsonToken jsonToken = this.f17684o;
        this.f17684o = null;
        if (jsonToken == JsonToken.START_ARRAY) {
            this.f17683n = this.f17683n.createChildArrayContext(this.f17681l, this.f17682m);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this.f17683n = this.f17683n.createChildObjectContext(this.f17681l, this.f17682m);
        }
        this.f17696b = jsonToken;
        return jsonToken;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0083 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String f0(int r5, int r6, int r7) throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r4 = this;
            com.fasterxml.jackson.core.util.TextBuffer r0 = r4.f17685p
            char[] r1 = r4.N
            int r2 = r4.f17675f
            int r2 = r2 - r5
            r0.resetWithShared(r1, r5, r2)
            com.fasterxml.jackson.core.util.TextBuffer r5 = r4.f17685p
            char[] r5 = r5.getCurrentSegment()
            com.fasterxml.jackson.core.util.TextBuffer r0 = r4.f17685p
            int r0 = r0.getCurrentSegmentSize()
        L16:
            int r1 = r4.f17675f
            int r2 = r4.f17676g
            if (r1 < r2) goto L3c
            boolean r1 = r4.H()
            if (r1 != 0) goto L3c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = ": was expecting closing '"
            r1.append(r2)
            char r2 = (char) r7
            r1.append(r2)
            java.lang.String r2 = "' for name"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r4.m(r1)
        L3c:
            char[] r1 = r4.N
            int r2 = r4.f17675f
            int r3 = r2 + 1
            r4.f17675f = r3
            char r1 = r1[r2]
            r2 = 92
            if (r1 > r2) goto L78
            if (r1 != r2) goto L51
            char r2 = r4.w()
            goto L79
        L51:
            if (r1 > r7) goto L78
            if (r1 != r7) goto L6f
            com.fasterxml.jackson.core.util.TextBuffer r5 = r4.f17685p
            r5.setCurrentLength(r0)
            com.fasterxml.jackson.core.util.TextBuffer r5 = r4.f17685p
            char[] r7 = r5.getTextBuffer()
            int r0 = r5.getTextOffset()
            int r5 = r5.size()
            com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer r1 = r4.P
            java.lang.String r5 = r1.findSymbol(r7, r0, r5, r6)
            return r5
        L6f:
            r2 = 32
            if (r1 >= r2) goto L78
            java.lang.String r2 = "name"
            r4.r(r1, r2)
        L78:
            r2 = r1
        L79:
            int r6 = r6 * 33
            int r6 = r6 + r1
            int r1 = r0 + 1
            r5[r0] = r2
            int r0 = r5.length
            if (r1 < r0) goto L8b
            com.fasterxml.jackson.core.util.TextBuffer r5 = r4.f17685p
            char[] r5 = r5.finishCurrentSegment()
            r0 = 0
            goto L16
        L8b:
            r0 = r1
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser.f0(int, int, int):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0069 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String g0(int r5, int r6, int[] r7) throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r4 = this;
            com.fasterxml.jackson.core.util.TextBuffer r0 = r4.f17685p
            char[] r1 = r4.N
            int r2 = r4.f17675f
            int r2 = r2 - r5
            r0.resetWithShared(r1, r5, r2)
            com.fasterxml.jackson.core.util.TextBuffer r5 = r4.f17685p
            char[] r5 = r5.getCurrentSegment()
            com.fasterxml.jackson.core.util.TextBuffer r0 = r4.f17685p
            int r0 = r0.getCurrentSegmentSize()
            int r1 = r7.length
        L17:
            int r2 = r4.f17675f
            int r3 = r4.f17676g
            if (r2 < r3) goto L24
            boolean r2 = r4.H()
            if (r2 != 0) goto L24
            goto L37
        L24:
            char[] r2 = r4.N
            int r3 = r4.f17675f
            char r2 = r2[r3]
            if (r2 > r1) goto L31
            r3 = r7[r2]
            if (r3 == 0) goto L51
            goto L37
        L31:
            boolean r3 = java.lang.Character.isJavaIdentifierPart(r2)
            if (r3 != 0) goto L51
        L37:
            com.fasterxml.jackson.core.util.TextBuffer r5 = r4.f17685p
            r5.setCurrentLength(r0)
            com.fasterxml.jackson.core.util.TextBuffer r5 = r4.f17685p
            char[] r7 = r5.getTextBuffer()
            int r0 = r5.getTextOffset()
            int r5 = r5.size()
            com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer r1 = r4.P
            java.lang.String r5 = r1.findSymbol(r7, r0, r5, r6)
            return r5
        L51:
            int r3 = r4.f17675f
            int r3 = r3 + 1
            r4.f17675f = r3
            int r6 = r6 * 33
            int r6 = r6 + r2
            int r3 = r0 + 1
            r5[r0] = r2
            int r0 = r5.length
            if (r3 < r0) goto L69
            com.fasterxml.jackson.core.util.TextBuffer r5 = r4.f17685p
            char[] r5 = r5.finishCurrentSegment()
            r0 = 0
            goto L17
        L69:
            r0 = r3
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser.g0(int, int, int[]):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
        m(" in a comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j0() throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r3 = this;
        L0:
            int r0 = r3.f17675f
            int r1 = r3.f17676g
            if (r0 < r1) goto Lc
            boolean r0 = r3.H()
            if (r0 == 0) goto L26
        Lc:
            char[] r0 = r3.N
            int r1 = r3.f17675f
            int r2 = r1 + 1
            r3.f17675f = r2
            char r0 = r0[r1]
            r1 = 42
            if (r0 > r1) goto L0
            if (r0 != r1) goto L3b
            int r0 = r3.f17676g
            if (r2 < r0) goto L2c
            boolean r0 = r3.H()
            if (r0 != 0) goto L2c
        L26:
            java.lang.String r0 = " in a comment"
            r3.m(r0)
            return
        L2c:
            char[] r0 = r3.N
            int r1 = r3.f17675f
            char r0 = r0[r1]
            r2 = 47
            if (r0 != r2) goto L0
            int r1 = r1 + 1
            r3.f17675f = r1
            return
        L3b:
            r1 = 32
            if (r0 >= r1) goto L0
            r1 = 10
            if (r0 != r1) goto L47
            r3.n0()
            goto L0
        L47:
            r1 = 13
            if (r0 != r1) goto L4f
            r3.k0()
            goto L0
        L4f:
            r1 = 9
            if (r0 == r1) goto L0
            r3.q(r0)
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser.j0():void");
    }

    private void l0() throws IOException, JsonParseException {
        if (!isEnabled(JsonParser.Feature.ALLOW_COMMENTS)) {
            o(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.f17675f >= this.f17676g && !H()) {
            m(" in a comment");
        }
        char[] cArr = this.N;
        int i4 = this.f17675f;
        this.f17675f = i4 + 1;
        char c4 = cArr[i4];
        if (c4 == '/') {
            m0();
        } else if (c4 == '*') {
            j0();
        } else {
            o(c4, "was expecting either '*' or '/' for a comment");
        }
    }

    private void m0() throws IOException, JsonParseException {
        while (true) {
            if (this.f17675f < this.f17676g || H()) {
                char[] cArr = this.N;
                int i4 = this.f17675f;
                this.f17675f = i4 + 1;
                char c4 = cArr[i4];
                if (c4 < ' ') {
                    if (c4 == '\n') {
                        n0();
                        return;
                    } else if (c4 == '\r') {
                        k0();
                        return;
                    } else if (c4 != '\t') {
                        q(c4);
                    }
                }
            } else {
                return;
            }
        }
    }

    private int p0() throws IOException, JsonParseException {
        while (true) {
            if (this.f17675f >= this.f17676g && !H()) {
                throw b("Unexpected end-of-input within/between " + this.f17683n.getTypeDesc() + " entries");
            }
            char[] cArr = this.N;
            int i4 = this.f17675f;
            this.f17675f = i4 + 1;
            char c4 = cArr[i4];
            if (c4 > ' ') {
                if (c4 != '/') {
                    return c4;
                }
                l0();
            } else if (c4 != ' ') {
                if (c4 == '\n') {
                    n0();
                } else if (c4 == '\r') {
                    k0();
                } else if (c4 != '\t') {
                    q(c4);
                }
            }
        }
    }

    private int q0() throws IOException, JsonParseException {
        while (true) {
            if (this.f17675f >= this.f17676g && !H()) {
                g();
                return -1;
            }
            char[] cArr = this.N;
            int i4 = this.f17675f;
            this.f17675f = i4 + 1;
            char c4 = cArr[i4];
            if (c4 > ' ') {
                if (c4 == '/') {
                    l0();
                } else {
                    return c4;
                }
            } else if (c4 != ' ') {
                if (c4 == '\n') {
                    n0();
                } else if (c4 == '\r') {
                    k0();
                } else if (c4 != '\t') {
                    q(c4);
                }
            }
        }
    }

    private char r0() throws IOException, JsonParseException {
        char c4;
        if ((this.f17675f >= this.f17676g && !H()) || (c4 = this.N[this.f17675f]) < '0' || c4 > '9') {
            return '0';
        }
        if (!isEnabled(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            L("Leading zeroes not allowed");
        }
        this.f17675f++;
        if (c4 == '0') {
            do {
                if (this.f17675f >= this.f17676g && !H()) {
                    break;
                }
                char[] cArr = this.N;
                int i4 = this.f17675f;
                c4 = cArr[i4];
                if (c4 < '0' || c4 > '9') {
                    return '0';
                }
                this.f17675f = i4 + 1;
            } while (c4 == '0');
        }
        return c4;
    }

    private JsonToken u0(boolean z3) throws IOException, JsonParseException {
        int i4;
        char s02;
        boolean z4;
        int i5;
        char s03;
        int i6;
        char[] emptyAndGetCurrentSegment = this.f17685p.emptyAndGetCurrentSegment();
        int i7 = 0;
        if (z3) {
            emptyAndGetCurrentSegment[0] = SignatureVisitor.SUPER;
            i4 = 1;
        } else {
            i4 = 0;
        }
        int i8 = this.f17675f;
        if (i8 < this.f17676g) {
            char[] cArr = this.N;
            this.f17675f = i8 + 1;
            s02 = cArr[i8];
        } else {
            s02 = s0("No digit following minus sign");
        }
        if (s02 == '0') {
            s02 = r0();
        }
        int i9 = 0;
        while (s02 >= '0' && s02 <= '9') {
            i9++;
            if (i4 >= emptyAndGetCurrentSegment.length) {
                emptyAndGetCurrentSegment = this.f17685p.finishCurrentSegment();
                i4 = 0;
            }
            int i10 = i4 + 1;
            emptyAndGetCurrentSegment[i4] = s02;
            if (this.f17675f >= this.f17676g && !H()) {
                i4 = i10;
                s02 = 0;
                z4 = true;
                break;
            }
            char[] cArr2 = this.N;
            int i11 = this.f17675f;
            this.f17675f = i11 + 1;
            s02 = cArr2[i11];
            i4 = i10;
        }
        z4 = false;
        if (i9 == 0) {
            L("Missing integer part (next char " + ParserMinimalBase.f(s02) + ")");
        }
        if (s02 == '.') {
            emptyAndGetCurrentSegment[i4] = s02;
            i4++;
            i5 = 0;
            while (true) {
                if (this.f17675f >= this.f17676g && !H()) {
                    z4 = true;
                    break;
                }
                char[] cArr3 = this.N;
                int i12 = this.f17675f;
                this.f17675f = i12 + 1;
                s02 = cArr3[i12];
                if (s02 < '0' || s02 > '9') {
                    break;
                }
                i5++;
                if (i4 >= emptyAndGetCurrentSegment.length) {
                    emptyAndGetCurrentSegment = this.f17685p.finishCurrentSegment();
                    i4 = 0;
                }
                emptyAndGetCurrentSegment[i4] = s02;
                i4++;
            }
            if (i5 == 0) {
                O(s02, "Decimal point not followed by a digit");
            }
        } else {
            i5 = 0;
        }
        if (s02 == 'e' || s02 == 'E') {
            if (i4 >= emptyAndGetCurrentSegment.length) {
                emptyAndGetCurrentSegment = this.f17685p.finishCurrentSegment();
                i4 = 0;
            }
            int i13 = i4 + 1;
            emptyAndGetCurrentSegment[i4] = s02;
            int i14 = this.f17675f;
            if (i14 < this.f17676g) {
                char[] cArr4 = this.N;
                this.f17675f = i14 + 1;
                s03 = cArr4[i14];
            } else {
                s03 = s0("expected a digit for number exponent");
            }
            if (s03 == '-' || s03 == '+') {
                if (i13 >= emptyAndGetCurrentSegment.length) {
                    emptyAndGetCurrentSegment = this.f17685p.finishCurrentSegment();
                    i13 = 0;
                }
                int i15 = i13 + 1;
                emptyAndGetCurrentSegment[i13] = s03;
                int i16 = this.f17675f;
                if (i16 < this.f17676g) {
                    char[] cArr5 = this.N;
                    this.f17675f = i16 + 1;
                    s03 = cArr5[i16];
                } else {
                    s03 = s0("expected a digit for number exponent");
                }
                i13 = i15;
            }
            int i17 = 0;
            while (s03 <= '9' && s03 >= '0') {
                i17++;
                if (i13 >= emptyAndGetCurrentSegment.length) {
                    emptyAndGetCurrentSegment = this.f17685p.finishCurrentSegment();
                    i13 = 0;
                }
                i6 = i13 + 1;
                emptyAndGetCurrentSegment[i13] = s03;
                if (this.f17675f >= this.f17676g && !H()) {
                    i7 = i17;
                    z4 = true;
                    break;
                }
                char[] cArr6 = this.N;
                int i18 = this.f17675f;
                this.f17675f = i18 + 1;
                s03 = cArr6[i18];
                i13 = i6;
            }
            i7 = i17;
            i6 = i13;
            if (i7 == 0) {
                O(s03, "Exponent indicator not followed by a digit");
            }
            i4 = i6;
        }
        if (!z4) {
            this.f17675f--;
        }
        this.f17685p.setCurrentLength(i4);
        return P(z3, i9, i5, i7);
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected void A() throws IOException {
        super.A();
        char[] cArr = this.N;
        if (cArr != null) {
            this.N = null;
            this.f17673d.releaseTokenBuffer(cArr);
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected boolean H() throws IOException {
        long j4 = this.f17677h;
        int i4 = this.f17676g;
        this.f17677h = j4 + i4;
        this.f17679j -= i4;
        Reader reader = this.M;
        if (reader != null) {
            char[] cArr = this.N;
            int read = reader.read(cArr, 0, cArr.length);
            if (read > 0) {
                this.f17675f = 0;
                this.f17676g = read;
                return true;
            }
            t();
            if (read == 0) {
                throw new IOException("Reader returned 0 characters when trying to read " + this.f17676g);
            }
        }
        return false;
    }

    protected byte[] T(Base64Variant base64Variant) throws IOException, JsonParseException {
        ByteArrayBuilder _getByteArrayBuilder = _getByteArrayBuilder();
        while (true) {
            if (this.f17675f >= this.f17676g) {
                I();
            }
            char[] cArr = this.N;
            int i4 = this.f17675f;
            this.f17675f = i4 + 1;
            char c4 = cArr[i4];
            if (c4 > ' ') {
                int decodeBase64Char = base64Variant.decodeBase64Char(c4);
                if (decodeBase64Char < 0) {
                    if (c4 == '\"') {
                        return _getByteArrayBuilder.toByteArray();
                    }
                    decodeBase64Char = u(base64Variant, c4, 0);
                    if (decodeBase64Char < 0) {
                        continue;
                    }
                }
                if (this.f17675f >= this.f17676g) {
                    I();
                }
                char[] cArr2 = this.N;
                int i5 = this.f17675f;
                this.f17675f = i5 + 1;
                char c5 = cArr2[i5];
                int decodeBase64Char2 = base64Variant.decodeBase64Char(c5);
                if (decodeBase64Char2 < 0) {
                    decodeBase64Char2 = u(base64Variant, c5, 1);
                }
                int i6 = (decodeBase64Char << 6) | decodeBase64Char2;
                if (this.f17675f >= this.f17676g) {
                    I();
                }
                char[] cArr3 = this.N;
                int i7 = this.f17675f;
                this.f17675f = i7 + 1;
                char c6 = cArr3[i7];
                int decodeBase64Char3 = base64Variant.decodeBase64Char(c6);
                if (decodeBase64Char3 < 0) {
                    if (decodeBase64Char3 != -2) {
                        if (c6 == '\"' && !base64Variant.usesPadding()) {
                            _getByteArrayBuilder.append(i6 >> 4);
                            return _getByteArrayBuilder.toByteArray();
                        }
                        decodeBase64Char3 = u(base64Variant, c6, 2);
                    }
                    if (decodeBase64Char3 == -2) {
                        if (this.f17675f >= this.f17676g) {
                            I();
                        }
                        char[] cArr4 = this.N;
                        int i8 = this.f17675f;
                        this.f17675f = i8 + 1;
                        char c7 = cArr4[i8];
                        if (base64Variant.usesPaddingChar(c7)) {
                            _getByteArrayBuilder.append(i6 >> 4);
                        } else {
                            throw K(base64Variant, c7, 3, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                        }
                    }
                }
                int i9 = (i6 << 6) | decodeBase64Char3;
                if (this.f17675f >= this.f17676g) {
                    I();
                }
                char[] cArr5 = this.N;
                int i10 = this.f17675f;
                this.f17675f = i10 + 1;
                char c8 = cArr5[i10];
                int decodeBase64Char4 = base64Variant.decodeBase64Char(c8);
                if (decodeBase64Char4 < 0) {
                    if (decodeBase64Char4 != -2) {
                        if (c8 == '\"' && !base64Variant.usesPadding()) {
                            _getByteArrayBuilder.appendTwoBytes(i9 >> 2);
                            return _getByteArrayBuilder.toByteArray();
                        }
                        decodeBase64Char4 = u(base64Variant, c8, 3);
                    }
                    if (decodeBase64Char4 == -2) {
                        _getByteArrayBuilder.appendTwoBytes(i9 >> 2);
                    }
                }
                _getByteArrayBuilder.appendThreeBytes((i9 << 6) | decodeBase64Char4);
            }
        }
    }

    protected void U() throws IOException, JsonParseException {
        int i4 = this.f17675f;
        int i5 = this.f17676g;
        if (i4 < i5) {
            int[] inputCodeLatin1 = CharTypes.getInputCodeLatin1();
            int length = inputCodeLatin1.length;
            while (true) {
                char[] cArr = this.N;
                char c4 = cArr[i4];
                if (c4 < length && inputCodeLatin1[c4] != 0) {
                    if (c4 == '\"') {
                        TextBuffer textBuffer = this.f17685p;
                        int i6 = this.f17675f;
                        textBuffer.resetWithShared(cArr, i6, i4 - i6);
                        this.f17675f = i4 + 1;
                        return;
                    }
                } else {
                    i4++;
                    if (i4 >= i5) {
                        break;
                    }
                }
            }
        }
        TextBuffer textBuffer2 = this.f17685p;
        char[] cArr2 = this.N;
        int i7 = this.f17675f;
        textBuffer2.resetWithCopy(cArr2, i7, i4 - i7);
        this.f17675f = i4;
        V();
    }

    protected void V() throws IOException, JsonParseException {
        char[] currentSegment = this.f17685p.getCurrentSegment();
        int currentSegmentSize = this.f17685p.getCurrentSegmentSize();
        while (true) {
            if (this.f17675f >= this.f17676g && !H()) {
                m(": was expecting closing quote for a string value");
            }
            char[] cArr = this.N;
            int i4 = this.f17675f;
            this.f17675f = i4 + 1;
            char c4 = cArr[i4];
            if (c4 <= '\\') {
                if (c4 == '\\') {
                    c4 = w();
                } else if (c4 <= '\"') {
                    if (c4 == '\"') {
                        this.f17685p.setCurrentLength(currentSegmentSize);
                        return;
                    } else if (c4 < ' ') {
                        r(c4, "string value");
                    }
                }
            }
            if (currentSegmentSize >= currentSegment.length) {
                currentSegment = this.f17685p.finishCurrentSegment();
                currentSegmentSize = 0;
            }
            currentSegment[currentSegmentSize] = c4;
            currentSegmentSize++;
        }
    }

    protected String W(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        int i4 = a.f17802a[jsonToken.ordinal()];
        if (i4 != 1) {
            if (i4 != 2 && i4 != 3 && i4 != 4) {
                return jsonToken.asString();
            }
            return this.f17685p.contentsAsString();
        }
        return this.f17683n.getCurrentName();
    }

    protected JsonToken X() throws IOException, JsonParseException {
        char[] emptyAndGetCurrentSegment = this.f17685p.emptyAndGetCurrentSegment();
        int currentSegmentSize = this.f17685p.getCurrentSegmentSize();
        while (true) {
            if (this.f17675f >= this.f17676g && !H()) {
                m(": was expecting closing quote for a string value");
            }
            char[] cArr = this.N;
            int i4 = this.f17675f;
            this.f17675f = i4 + 1;
            char c4 = cArr[i4];
            if (c4 <= '\\') {
                if (c4 == '\\') {
                    c4 = w();
                } else if (c4 <= '\'') {
                    if (c4 == '\'') {
                        this.f17685p.setCurrentLength(currentSegmentSize);
                        return JsonToken.VALUE_STRING;
                    } else if (c4 < ' ') {
                        r(c4, "string value");
                    }
                }
            }
            if (currentSegmentSize >= emptyAndGetCurrentSegment.length) {
                emptyAndGetCurrentSegment = this.f17685p.finishCurrentSegment();
                currentSegmentSize = 0;
            }
            emptyAndGetCurrentSegment[currentSegmentSize] = c4;
            currentSegmentSize++;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r9v0 ??, r9v1 ??, r9v5 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    protected com.fasterxml.jackson.core.JsonToken Y(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r9v0 ??, r9v1 ??, r9v5 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r9v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:227)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:222)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:167)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:372)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */

    protected JsonToken Z(int i4) throws IOException, JsonParseException {
        if (i4 != 39) {
            if (i4 != 43) {
                if (i4 == 78) {
                    b0("NaN", 1);
                    if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                        return Q("NaN", Double.NaN);
                    }
                    j("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                }
            } else {
                if (this.f17675f >= this.f17676g && !H()) {
                    n();
                }
                char[] cArr = this.N;
                int i5 = this.f17675f;
                this.f17675f = i5 + 1;
                return Y(cArr[i5], false);
            }
        } else if (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return X();
        }
        o(i4, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }

    protected String a0(int i4) throws IOException, JsonParseException {
        boolean isJavaIdentifierPart;
        if (i4 == 39 && isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return d0();
        }
        if (!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            o(i4, "was expecting double-quote to start field name");
        }
        int[] inputCodeLatin1JsNames = CharTypes.getInputCodeLatin1JsNames();
        int length = inputCodeLatin1JsNames.length;
        if (i4 < length) {
            if (inputCodeLatin1JsNames[i4] == 0 && (i4 < 48 || i4 > 57)) {
                isJavaIdentifierPart = true;
            } else {
                isJavaIdentifierPart = false;
            }
        } else {
            isJavaIdentifierPart = Character.isJavaIdentifierPart((char) i4);
        }
        if (!isJavaIdentifierPart) {
            o(i4, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int i5 = this.f17675f;
        int i6 = this.Q;
        int i7 = this.f17676g;
        if (i5 < i7) {
            do {
                char[] cArr = this.N;
                char c4 = cArr[i5];
                if (c4 < length) {
                    if (inputCodeLatin1JsNames[c4] != 0) {
                        int i8 = this.f17675f - 1;
                        this.f17675f = i5;
                        return this.P.findSymbol(cArr, i8, i5 - i8, i6);
                    }
                } else if (!Character.isJavaIdentifierPart(c4)) {
                    int i9 = this.f17675f - 1;
                    this.f17675f = i5;
                    return this.P.findSymbol(this.N, i9, i5 - i9, i6);
                }
                i6 = (i6 * 33) + c4;
                i5++;
            } while (i5 < i7);
            this.f17675f = i5;
            return g0(this.f17675f - 1, i6, inputCodeLatin1JsNames);
        }
        this.f17675f = i5;
        return g0(this.f17675f - 1, i6, inputCodeLatin1JsNames);
    }

    protected void b0(String str, int i4) throws IOException, JsonParseException {
        int i5;
        char c4;
        int length = str.length();
        do {
            if (this.f17675f >= this.f17676g && !H()) {
                n();
            }
            if (this.N[this.f17675f] != str.charAt(i4)) {
                i0(str.substring(0, i4), "'null', 'true', 'false' or NaN");
            }
            i5 = this.f17675f + 1;
            this.f17675f = i5;
            i4++;
        } while (i4 < length);
        if ((i5 < this.f17676g || H()) && (c4 = this.N[this.f17675f]) >= '0' && c4 != ']' && c4 != '}' && Character.isJavaIdentifierPart(c4)) {
            i0(str.substring(0, i4), "'null', 'true', 'false' or NaN");
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.P.release();
    }

    protected String d0() throws IOException, JsonParseException {
        int i4 = this.f17675f;
        int i5 = this.Q;
        int i6 = this.f17676g;
        if (i4 < i6) {
            int[] inputCodeLatin1 = CharTypes.getInputCodeLatin1();
            int length = inputCodeLatin1.length;
            do {
                char[] cArr = this.N;
                char c4 = cArr[i4];
                if (c4 == '\'') {
                    int i7 = this.f17675f;
                    this.f17675f = i4 + 1;
                    return this.P.findSymbol(cArr, i7, i4 - i7, i5);
                } else if (c4 < length && inputCodeLatin1[c4] != 0) {
                    break;
                } else {
                    i5 = (i5 * 33) + c4;
                    i4++;
                }
            } while (i4 < i6);
        }
        int i8 = this.f17675f;
        this.f17675f = i4;
        return f0(i8, i5, 39);
    }

    protected String e0(int i4) throws IOException, JsonParseException {
        if (i4 != 34) {
            return a0(i4);
        }
        int i5 = this.f17675f;
        int i6 = this.Q;
        int i7 = this.f17676g;
        if (i5 < i7) {
            int[] inputCodeLatin1 = CharTypes.getInputCodeLatin1();
            int length = inputCodeLatin1.length;
            while (true) {
                char[] cArr = this.N;
                char c4 = cArr[i5];
                if (c4 < length && inputCodeLatin1[c4] != 0) {
                    if (c4 == '\"') {
                        int i8 = this.f17675f;
                        this.f17675f = i5 + 1;
                        return this.P.findSymbol(cArr, i8, i5 - i8, i6);
                    }
                } else {
                    i6 = (i6 * 33) + c4;
                    i5++;
                    if (i5 >= i7) {
                        break;
                    }
                }
            }
        }
        int i9 = this.f17675f;
        this.f17675f = i5;
        return f0(i9, i6, 34);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public byte[] getBinaryValue(Base64Variant base64Variant) throws IOException, JsonParseException {
        JsonToken jsonToken = this.f17696b;
        if (jsonToken != JsonToken.VALUE_STRING && (jsonToken != JsonToken.VALUE_EMBEDDED_OBJECT || this.f17689t == null)) {
            j("Current token (" + this.f17696b + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this.R) {
            try {
                this.f17689t = T(base64Variant);
                this.R = false;
            } catch (IllegalArgumentException e4) {
                throw b("Failed to decode VALUE_STRING as base64 (" + base64Variant + "): " + e4.getMessage());
            }
        } else if (this.f17689t == null) {
            ByteArrayBuilder _getByteArrayBuilder = _getByteArrayBuilder();
            e(getText(), _getByteArrayBuilder, base64Variant);
            this.f17689t = _getByteArrayBuilder.toByteArray();
        }
        return this.f17689t;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public ObjectCodec getCodec() {
        return this.O;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getEmbeddedObject() throws IOException, JsonParseException {
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getInputSource() {
        return this.M;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getText() throws IOException, JsonParseException {
        JsonToken jsonToken = this.f17696b;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (this.R) {
                this.R = false;
                U();
            }
            return this.f17685p.contentsAsString();
        }
        return W(jsonToken);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public char[] getTextCharacters() throws IOException, JsonParseException {
        JsonToken jsonToken = this.f17696b;
        if (jsonToken != null) {
            int i4 = a.f17802a[jsonToken.ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3 && i4 != 4) {
                        return this.f17696b.asCharArray();
                    }
                } else if (this.R) {
                    this.R = false;
                    U();
                }
                return this.f17685p.getTextBuffer();
            }
            if (!this.f17687r) {
                String currentName = this.f17683n.getCurrentName();
                int length = currentName.length();
                char[] cArr = this.f17686q;
                if (cArr == null) {
                    this.f17686q = this.f17673d.allocNameCopyBuffer(length);
                } else if (cArr.length < length) {
                    this.f17686q = new char[length];
                }
                currentName.getChars(0, length, this.f17686q, 0);
                this.f17687r = true;
            }
            return this.f17686q;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public int getTextLength() throws IOException, JsonParseException {
        JsonToken jsonToken = this.f17696b;
        if (jsonToken == null) {
            return 0;
        }
        int i4 = a.f17802a[jsonToken.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3 && i4 != 4) {
                    return this.f17696b.asCharArray().length;
                }
            } else if (this.R) {
                this.R = false;
                U();
            }
            return this.f17685p.size();
        }
        return this.f17683n.getCurrentName().length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
        if (r0 != 4) goto L15;
     */
    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getTextOffset() throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r3 = this;
            com.fasterxml.jackson.core.JsonToken r0 = r3.f17696b
            r1 = 0
            if (r0 == 0) goto L27
            int[] r2 = com.fasterxml.jackson.core.json.ReaderBasedJsonParser.a.f17802a
            int r0 = r0.ordinal()
            r0 = r2[r0]
            r2 = 2
            if (r0 == r2) goto L17
            r2 = 3
            if (r0 == r2) goto L20
            r2 = 4
            if (r0 == r2) goto L20
            goto L27
        L17:
            boolean r0 = r3.R
            if (r0 == 0) goto L20
            r3.R = r1
            r3.U()
        L20:
            com.fasterxml.jackson.core.util.TextBuffer r0 = r3.f17685p
            int r0 = r0.getTextOffset()
            return r0
        L27:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser.getTextOffset():int");
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String getValueAsString() throws IOException, JsonParseException {
        if (this.f17696b == JsonToken.VALUE_STRING) {
            if (this.R) {
                this.R = false;
                U();
            }
            return this.f17685p.contentsAsString();
        }
        return super.getValueAsString(null);
    }

    protected int h0(Base64Variant base64Variant, OutputStream outputStream, byte[] bArr) throws IOException, JsonParseException {
        int i4;
        int length = bArr.length - 3;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (this.f17675f >= this.f17676g) {
                I();
            }
            char[] cArr = this.N;
            int i7 = this.f17675f;
            this.f17675f = i7 + 1;
            char c4 = cArr[i7];
            if (c4 > ' ') {
                int decodeBase64Char = base64Variant.decodeBase64Char(c4);
                if (decodeBase64Char < 0) {
                    if (c4 == '\"') {
                        break;
                    }
                    decodeBase64Char = u(base64Variant, c4, 0);
                    if (decodeBase64Char < 0) {
                        continue;
                    }
                }
                if (i5 > length) {
                    i6 += i5;
                    outputStream.write(bArr, 0, i5);
                    i5 = 0;
                }
                if (this.f17675f >= this.f17676g) {
                    I();
                }
                char[] cArr2 = this.N;
                int i8 = this.f17675f;
                this.f17675f = i8 + 1;
                char c5 = cArr2[i8];
                int decodeBase64Char2 = base64Variant.decodeBase64Char(c5);
                if (decodeBase64Char2 < 0) {
                    decodeBase64Char2 = u(base64Variant, c5, 1);
                }
                int i9 = (decodeBase64Char << 6) | decodeBase64Char2;
                if (this.f17675f >= this.f17676g) {
                    I();
                }
                char[] cArr3 = this.N;
                int i10 = this.f17675f;
                this.f17675f = i10 + 1;
                char c6 = cArr3[i10];
                int decodeBase64Char3 = base64Variant.decodeBase64Char(c6);
                if (decodeBase64Char3 < 0) {
                    if (decodeBase64Char3 != -2) {
                        if (c6 == '\"' && !base64Variant.usesPadding()) {
                            bArr[i5] = (byte) (i9 >> 4);
                            i5++;
                            break;
                        }
                        decodeBase64Char3 = u(base64Variant, c6, 2);
                    }
                    if (decodeBase64Char3 == -2) {
                        if (this.f17675f >= this.f17676g) {
                            I();
                        }
                        char[] cArr4 = this.N;
                        int i11 = this.f17675f;
                        this.f17675f = i11 + 1;
                        char c7 = cArr4[i11];
                        if (base64Variant.usesPaddingChar(c7)) {
                            i4 = i5 + 1;
                            bArr[i5] = (byte) (i9 >> 4);
                            i5 = i4;
                        } else {
                            throw K(base64Variant, c7, 3, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                        }
                    }
                }
                int i12 = (i9 << 6) | decodeBase64Char3;
                if (this.f17675f >= this.f17676g) {
                    I();
                }
                char[] cArr5 = this.N;
                int i13 = this.f17675f;
                this.f17675f = i13 + 1;
                char c8 = cArr5[i13];
                int decodeBase64Char4 = base64Variant.decodeBase64Char(c8);
                if (decodeBase64Char4 < 0) {
                    if (decodeBase64Char4 != -2) {
                        if (c8 == '\"' && !base64Variant.usesPadding()) {
                            int i14 = i12 >> 2;
                            int i15 = i5 + 1;
                            bArr[i5] = (byte) (i14 >> 8);
                            i5 = i15 + 1;
                            bArr[i15] = (byte) i14;
                            break;
                        }
                        decodeBase64Char4 = u(base64Variant, c8, 3);
                    }
                    if (decodeBase64Char4 == -2) {
                        int i16 = i12 >> 2;
                        int i17 = i5 + 1;
                        bArr[i5] = (byte) (i16 >> 8);
                        i5 = i17 + 1;
                        bArr[i17] = (byte) i16;
                    }
                }
                int i18 = (i12 << 6) | decodeBase64Char4;
                int i19 = i5 + 1;
                bArr[i5] = (byte) (i18 >> 16);
                int i20 = i19 + 1;
                bArr[i19] = (byte) (i18 >> 8);
                i4 = i20 + 1;
                bArr[i20] = (byte) i18;
                i5 = i4;
            }
        }
        this.R = false;
        if (i5 > 0) {
            int i21 = i6 + i5;
            outputStream.write(bArr, 0, i5);
            return i21;
        }
        return i6;
    }

    protected void i0(String str, String str2) throws IOException, JsonParseException {
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            if (this.f17675f >= this.f17676g && !H()) {
                break;
            }
            char c4 = this.N[this.f17675f];
            if (!Character.isJavaIdentifierPart(c4)) {
                break;
            }
            this.f17675f++;
            sb.append(c4);
        }
        j("Unrecognized token '" + sb.toString() + "': was expecting ");
    }

    protected void k0() throws IOException {
        if (this.f17675f < this.f17676g || H()) {
            char[] cArr = this.N;
            int i4 = this.f17675f;
            if (cArr[i4] == '\n') {
                this.f17675f = i4 + 1;
            }
        }
        this.f17678i++;
        this.f17679j = this.f17675f;
    }

    protected void n0() throws IOException {
        this.f17678i++;
        this.f17679j = this.f17675f;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Boolean nextBooleanValue() throws IOException, JsonParseException {
        if (this.f17696b == JsonToken.FIELD_NAME) {
            this.f17687r = false;
            JsonToken jsonToken = this.f17684o;
            this.f17684o = null;
            this.f17696b = jsonToken;
            if (jsonToken == JsonToken.VALUE_TRUE) {
                return Boolean.TRUE;
            }
            if (jsonToken == JsonToken.VALUE_FALSE) {
                return Boolean.FALSE;
            }
            if (jsonToken == JsonToken.START_ARRAY) {
                this.f17683n = this.f17683n.createChildArrayContext(this.f17681l, this.f17682m);
            } else if (jsonToken == JsonToken.START_OBJECT) {
                this.f17683n = this.f17683n.createChildObjectContext(this.f17681l, this.f17682m);
            }
            return null;
        }
        int i4 = a.f17802a[nextToken().ordinal()];
        if (i4 != 5) {
            if (i4 != 6) {
                return null;
            }
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int nextIntValue(int i4) throws IOException, JsonParseException {
        if (this.f17696b == JsonToken.FIELD_NAME) {
            this.f17687r = false;
            JsonToken jsonToken = this.f17684o;
            this.f17684o = null;
            this.f17696b = jsonToken;
            if (jsonToken == JsonToken.VALUE_NUMBER_INT) {
                return getIntValue();
            }
            if (jsonToken == JsonToken.START_ARRAY) {
                this.f17683n = this.f17683n.createChildArrayContext(this.f17681l, this.f17682m);
            } else if (jsonToken == JsonToken.START_OBJECT) {
                this.f17683n = this.f17683n.createChildObjectContext(this.f17681l, this.f17682m);
            }
            return i4;
        } else if (nextToken() == JsonToken.VALUE_NUMBER_INT) {
            return getIntValue();
        } else {
            return i4;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long nextLongValue(long j4) throws IOException, JsonParseException {
        if (this.f17696b == JsonToken.FIELD_NAME) {
            this.f17687r = false;
            JsonToken jsonToken = this.f17684o;
            this.f17684o = null;
            this.f17696b = jsonToken;
            if (jsonToken == JsonToken.VALUE_NUMBER_INT) {
                return getLongValue();
            }
            if (jsonToken == JsonToken.START_ARRAY) {
                this.f17683n = this.f17683n.createChildArrayContext(this.f17681l, this.f17682m);
            } else if (jsonToken == JsonToken.START_OBJECT) {
                this.f17683n = this.f17683n.createChildObjectContext(this.f17681l, this.f17682m);
            }
            return j4;
        } else if (nextToken() == JsonToken.VALUE_NUMBER_INT) {
            return getLongValue();
        } else {
            return j4;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String nextTextValue() throws IOException, JsonParseException {
        if (this.f17696b == JsonToken.FIELD_NAME) {
            this.f17687r = false;
            JsonToken jsonToken = this.f17684o;
            this.f17684o = null;
            this.f17696b = jsonToken;
            if (jsonToken == JsonToken.VALUE_STRING) {
                if (this.R) {
                    this.R = false;
                    U();
                }
                return this.f17685p.contentsAsString();
            }
            if (jsonToken == JsonToken.START_ARRAY) {
                this.f17683n = this.f17683n.createChildArrayContext(this.f17681l, this.f17682m);
            } else if (jsonToken == JsonToken.START_OBJECT) {
                this.f17683n = this.f17683n.createChildObjectContext(this.f17681l, this.f17682m);
            }
            return null;
        } else if (nextToken() != JsonToken.VALUE_STRING) {
            return null;
        } else {
            return getText();
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public JsonToken nextToken() throws IOException, JsonParseException {
        JsonToken jsonToken;
        this.f17690u = 0;
        JsonToken jsonToken2 = this.f17696b;
        JsonToken jsonToken3 = JsonToken.FIELD_NAME;
        if (jsonToken2 == jsonToken3) {
            return c0();
        }
        if (this.R) {
            o0();
        }
        int q02 = q0();
        if (q02 < 0) {
            close();
            this.f17696b = null;
            return null;
        }
        long j4 = this.f17677h;
        int i4 = this.f17675f;
        this.f17680k = (j4 + i4) - 1;
        this.f17681l = this.f17678i;
        this.f17682m = (i4 - this.f17679j) - 1;
        this.f17689t = null;
        if (q02 == 93) {
            if (!this.f17683n.inArray()) {
                B(q02, '}');
            }
            this.f17683n = this.f17683n.getParent();
            JsonToken jsonToken4 = JsonToken.END_ARRAY;
            this.f17696b = jsonToken4;
            return jsonToken4;
        } else if (q02 == 125) {
            if (!this.f17683n.inObject()) {
                B(q02, ']');
            }
            this.f17683n = this.f17683n.getParent();
            JsonToken jsonToken5 = JsonToken.END_OBJECT;
            this.f17696b = jsonToken5;
            return jsonToken5;
        } else {
            if (this.f17683n.expectComma()) {
                if (q02 != 44) {
                    o(q02, "was expecting comma to separate " + this.f17683n.getTypeDesc() + " entries");
                }
                q02 = p0();
            }
            boolean inObject = this.f17683n.inObject();
            if (inObject) {
                this.f17683n.setCurrentName(e0(q02));
                this.f17696b = jsonToken3;
                int p02 = p0();
                if (p02 != 58) {
                    o(p02, "was expecting a colon to separate field name and value");
                }
                q02 = p0();
            }
            if (q02 != 34) {
                if (q02 != 45) {
                    if (q02 != 91) {
                        if (q02 != 93) {
                            if (q02 != 102) {
                                if (q02 != 110) {
                                    if (q02 != 116) {
                                        if (q02 != 123) {
                                            if (q02 != 125) {
                                                switch (q02) {
                                                    case 48:
                                                    case 49:
                                                    case 50:
                                                    case 51:
                                                    case 52:
                                                    case 53:
                                                    case 54:
                                                    case 55:
                                                    case 56:
                                                    case 57:
                                                        break;
                                                    default:
                                                        jsonToken = Z(q02);
                                                        break;
                                                }
                                            }
                                        } else {
                                            if (!inObject) {
                                                this.f17683n = this.f17683n.createChildObjectContext(this.f17681l, this.f17682m);
                                            }
                                            jsonToken = JsonToken.START_OBJECT;
                                        }
                                    }
                                    b0("true", 1);
                                    jsonToken = JsonToken.VALUE_TRUE;
                                } else {
                                    b0("null", 1);
                                    jsonToken = JsonToken.VALUE_NULL;
                                }
                            } else {
                                b0("false", 1);
                                jsonToken = JsonToken.VALUE_FALSE;
                            }
                        }
                        o(q02, "expected a value");
                        b0("true", 1);
                        jsonToken = JsonToken.VALUE_TRUE;
                    } else {
                        if (!inObject) {
                            this.f17683n = this.f17683n.createChildArrayContext(this.f17681l, this.f17682m);
                        }
                        jsonToken = JsonToken.START_ARRAY;
                    }
                }
                jsonToken = t0(q02);
            } else {
                this.R = true;
                jsonToken = JsonToken.VALUE_STRING;
            }
            if (inObject) {
                this.f17684o = jsonToken;
                return this.f17696b;
            }
            this.f17696b = jsonToken;
            return jsonToken;
        }
    }

    protected void o0() throws IOException, JsonParseException {
        this.R = false;
        int i4 = this.f17675f;
        int i5 = this.f17676g;
        char[] cArr = this.N;
        while (true) {
            if (i4 >= i5) {
                this.f17675f = i4;
                if (!H()) {
                    m(": was expecting closing quote for a string value");
                }
                i4 = this.f17675f;
                i5 = this.f17676g;
            }
            int i6 = i4 + 1;
            char c4 = cArr[i4];
            if (c4 <= '\\') {
                if (c4 == '\\') {
                    this.f17675f = i6;
                    w();
                    i4 = this.f17675f;
                    i5 = this.f17676g;
                } else if (c4 <= '\"') {
                    if (c4 == '\"') {
                        this.f17675f = i6;
                        return;
                    } else if (c4 < ' ') {
                        this.f17675f = i6;
                        r(c4, "string value");
                    }
                }
            }
            i4 = i6;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int readBinaryValue(Base64Variant base64Variant, OutputStream outputStream) throws IOException, JsonParseException {
        if (this.R && this.f17696b == JsonToken.VALUE_STRING) {
            byte[] allocBase64Buffer = this.f17673d.allocBase64Buffer();
            try {
                return h0(base64Variant, outputStream, allocBase64Buffer);
            } finally {
                this.f17673d.releaseBase64Buffer(allocBase64Buffer);
            }
        }
        byte[] binaryValue = getBinaryValue(base64Variant);
        outputStream.write(binaryValue);
        return binaryValue.length;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int releaseBuffered(Writer writer) throws IOException {
        int i4 = this.f17676g;
        int i5 = this.f17675f;
        int i6 = i4 - i5;
        if (i6 < 1) {
            return 0;
        }
        writer.write(this.N, i5, i6);
        return i6;
    }

    protected char s0(String str) throws IOException, JsonParseException {
        if (this.f17675f >= this.f17676g && !H()) {
            m(str);
        }
        char[] cArr = this.N;
        int i4 = this.f17675f;
        this.f17675f = i4 + 1;
        return cArr[i4];
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void setCodec(ObjectCodec objectCodec) {
        this.O = objectCodec;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected void t() throws IOException {
        if (this.M != null) {
            if (this.f17673d.isResourceManaged() || isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this.M.close();
            }
            this.M = null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r13v0 ??, r13v1 ??, r13v18 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    protected com.fasterxml.jackson.core.JsonToken t0(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r13v0 ??, r13v1 ??, r13v18 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r13v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:227)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:222)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:167)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:372)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return CoreVersion.instance.version();
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected char w() throws IOException, JsonParseException {
        if (this.f17675f >= this.f17676g && !H()) {
            m(" in character escape sequence");
        }
        char[] cArr = this.N;
        int i4 = this.f17675f;
        this.f17675f = i4 + 1;
        char c4 = cArr[i4];
        if (c4 != '\"' && c4 != '/' && c4 != '\\') {
            if (c4 != 'b') {
                if (c4 != 'f') {
                    if (c4 != 'n') {
                        if (c4 != 'r') {
                            if (c4 != 't') {
                                if (c4 != 'u') {
                                    return h(c4);
                                }
                                int i5 = 0;
                                for (int i6 = 0; i6 < 4; i6++) {
                                    if (this.f17675f >= this.f17676g && !H()) {
                                        m(" in character escape sequence");
                                    }
                                    char[] cArr2 = this.N;
                                    int i7 = this.f17675f;
                                    this.f17675f = i7 + 1;
                                    char c5 = cArr2[i7];
                                    int charToHex = CharTypes.charToHex(c5);
                                    if (charToHex < 0) {
                                        o(c5, "expected a hex-digit for character escape sequence");
                                    }
                                    i5 = (i5 << 4) | charToHex;
                                }
                                return (char) i5;
                            }
                            return '\t';
                        }
                        return '\r';
                    }
                    return '\n';
                }
                return '\f';
            }
            return '\b';
        }
        return c4;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getValueAsString(String str) throws IOException, JsonParseException {
        if (this.f17696b == JsonToken.VALUE_STRING) {
            if (this.R) {
                this.R = false;
                U();
            }
            return this.f17685p.contentsAsString();
        }
        return super.getValueAsString(str);
    }
}
