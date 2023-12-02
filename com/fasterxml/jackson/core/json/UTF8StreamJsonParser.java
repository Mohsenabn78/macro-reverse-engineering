package com.fasterxml.jackson.core.json;

import com.android.dx.io.Opcodes;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;
import com.fasterxml.jackson.core.sym.Name;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.google.android.gms.location.places.Place;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import okio.Utf8;

/* loaded from: classes3.dex */
public final class UTF8StreamJsonParser extends ParserBase {
    private static final int[] U = CharTypes.getInputCodeUtf8();
    private static final int[] V = CharTypes.getInputCodeLatin1();
    protected ObjectCodec M;
    protected final BytesToNameCanonicalizer N;
    protected int[] O;
    protected boolean P;
    private int Q;
    protected InputStream R;
    protected byte[] S;
    protected boolean T;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17815a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f17815a = iArr;
            try {
                iArr[JsonToken.FIELD_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17815a[JsonToken.VALUE_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17815a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17815a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17815a[JsonToken.VALUE_TRUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17815a[JsonToken.VALUE_FALSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public UTF8StreamJsonParser(IOContext iOContext, int i4, InputStream inputStream, ObjectCodec objectCodec, BytesToNameCanonicalizer bytesToNameCanonicalizer, byte[] bArr, int i5, int i6, boolean z3) {
        super(iOContext, i4);
        this.O = new int[16];
        this.P = false;
        this.R = inputStream;
        this.M = objectCodec;
        this.N = bytesToNameCanonicalizer;
        this.S = bArr;
        this.f17675f = i5;
        this.f17676g = i6;
        this.T = z3;
    }

    private void C0(int i4) throws IOException, JsonParseException {
        if (this.f17675f >= this.f17676g) {
            I();
        }
        byte[] bArr = this.S;
        int i5 = this.f17675f;
        int i6 = i5 + 1;
        this.f17675f = i6;
        byte b4 = bArr[i5];
        if ((b4 & 192) != 128) {
            t0(b4 & 255, i6);
        }
    }

    private void D0(int i4) throws IOException, JsonParseException {
        if (this.f17675f >= this.f17676g) {
            I();
        }
        byte[] bArr = this.S;
        int i5 = this.f17675f;
        int i6 = i5 + 1;
        this.f17675f = i6;
        byte b4 = bArr[i5];
        if ((b4 & 192) != 128) {
            t0(b4 & 255, i6);
        }
        if (this.f17675f >= this.f17676g) {
            I();
        }
        byte[] bArr2 = this.S;
        int i7 = this.f17675f;
        int i8 = i7 + 1;
        this.f17675f = i8;
        byte b5 = bArr2[i7];
        if ((b5 & 192) != 128) {
            t0(b5 & 255, i8);
        }
    }

    private void E0(int i4) throws IOException, JsonParseException {
        if (this.f17675f >= this.f17676g) {
            I();
        }
        byte[] bArr = this.S;
        int i5 = this.f17675f;
        int i6 = i5 + 1;
        this.f17675f = i6;
        byte b4 = bArr[i5];
        if ((b4 & 192) != 128) {
            t0(b4 & 255, i6);
        }
        if (this.f17675f >= this.f17676g) {
            I();
        }
        byte[] bArr2 = this.S;
        int i7 = this.f17675f;
        int i8 = i7 + 1;
        this.f17675f = i8;
        byte b5 = bArr2[i7];
        if ((b5 & 192) != 128) {
            t0(b5 & 255, i8);
        }
        if (this.f17675f >= this.f17676g) {
            I();
        }
        byte[] bArr3 = this.S;
        int i9 = this.f17675f;
        int i10 = i9 + 1;
        this.f17675f = i10;
        byte b6 = bArr3[i9];
        if ((b6 & 192) != 128) {
            t0(b6 & 255, i10);
        }
    }

    private int F0() throws IOException, JsonParseException {
        while (true) {
            if (this.f17675f >= this.f17676g && !H()) {
                throw b("Unexpected end-of-input within/between " + this.f17683n.getTypeDesc() + " entries");
            }
            byte[] bArr = this.S;
            int i4 = this.f17675f;
            this.f17675f = i4 + 1;
            int i5 = bArr[i4] & 255;
            if (i5 > 32) {
                if (i5 != 47) {
                    return i5;
                }
                y0();
            } else if (i5 != 32) {
                if (i5 == 10) {
                    A0();
                } else if (i5 == 13) {
                    w0();
                } else if (i5 != 9) {
                    q(i5);
                }
            }
        }
    }

    private int G0() throws IOException, JsonParseException {
        while (true) {
            if (this.f17675f >= this.f17676g && !H()) {
                g();
                return -1;
            }
            byte[] bArr = this.S;
            int i4 = this.f17675f;
            this.f17675f = i4 + 1;
            int i5 = bArr[i4] & 255;
            if (i5 > 32) {
                if (i5 != 47) {
                    return i5;
                }
                y0();
            } else if (i5 != 32) {
                if (i5 == 10) {
                    A0();
                } else if (i5 == 13) {
                    w0();
                } else if (i5 != 9) {
                    q(i5);
                }
            }
        }
    }

    private int H0() throws IOException, JsonParseException {
        int i4;
        if ((this.f17675f >= this.f17676g && !H()) || (i4 = this.S[this.f17675f] & 255) < 48 || i4 > 57) {
            return 48;
        }
        if (!isEnabled(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            L("Leading zeroes not allowed");
        }
        this.f17675f++;
        if (i4 == 48) {
            do {
                if (this.f17675f >= this.f17676g && !H()) {
                    break;
                }
                byte[] bArr = this.S;
                int i5 = this.f17675f;
                i4 = bArr[i5] & 255;
                if (i4 < 48 || i4 > 57) {
                    return 48;
                }
                this.f17675f = i5 + 1;
            } while (i4 == 48);
        }
        return i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.fasterxml.jackson.core.sym.Name I0(int[] r18, int r19, int r20) throws com.fasterxml.jackson.core.JsonParseException {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser.I0(int[], int, int):com.fasterxml.jackson.core.sym.Name");
    }

    private Name J0(int i4, int i5) throws JsonParseException {
        Name findName = this.N.findName(i4);
        if (findName != null) {
            return findName;
        }
        int[] iArr = this.O;
        iArr[0] = i4;
        return I0(iArr, 1, i5);
    }

    private Name K0(int i4, int i5, int i6) throws JsonParseException {
        Name findName = this.N.findName(i4, i5);
        if (findName != null) {
            return findName;
        }
        int[] iArr = this.O;
        iArr[0] = i4;
        iArr[1] = i5;
        return I0(iArr, 2, i6);
    }

    private Name L0(int[] iArr, int i4, int i5, int i6) throws JsonParseException {
        if (i4 >= iArr.length) {
            iArr = growArrayBy(iArr, iArr.length);
            this.O = iArr;
        }
        int i7 = i4 + 1;
        iArr[i4] = i5;
        Name findName = this.N.findName(iArr, i7);
        if (findName == null) {
            return I0(iArr, i7, i6);
        }
        return findName;
    }

    private int M0() throws IOException, JsonParseException {
        if (this.f17675f >= this.f17676g) {
            I();
        }
        byte[] bArr = this.S;
        int i4 = this.f17675f;
        this.f17675f = i4 + 1;
        return bArr[i4] & 255;
    }

    private Name O0(int i4, int i5, int i6) throws IOException, JsonParseException {
        return N0(this.O, 0, i4, i5, i6);
    }

    private Name P0(int i4, int i5, int i6, int i7) throws IOException, JsonParseException {
        int[] iArr = this.O;
        iArr[0] = i4;
        return N0(iArr, 1, i5, i6, i7);
    }

    private int V(int i4) throws IOException, JsonParseException {
        if (this.f17675f >= this.f17676g) {
            I();
        }
        byte[] bArr = this.S;
        int i5 = this.f17675f;
        int i6 = i5 + 1;
        this.f17675f = i6;
        byte b4 = bArr[i5];
        if ((b4 & 192) != 128) {
            t0(b4 & 255, i6);
        }
        return ((i4 & 31) << 6) | (b4 & Utf8.REPLACEMENT_BYTE);
    }

    private int W(int i4) throws IOException, JsonParseException {
        if (this.f17675f >= this.f17676g) {
            I();
        }
        int i5 = i4 & 15;
        byte[] bArr = this.S;
        int i6 = this.f17675f;
        int i7 = i6 + 1;
        this.f17675f = i7;
        byte b4 = bArr[i6];
        if ((b4 & 192) != 128) {
            t0(b4 & 255, i7);
        }
        int i8 = (i5 << 6) | (b4 & Utf8.REPLACEMENT_BYTE);
        if (this.f17675f >= this.f17676g) {
            I();
        }
        byte[] bArr2 = this.S;
        int i9 = this.f17675f;
        int i10 = i9 + 1;
        this.f17675f = i10;
        byte b5 = bArr2[i9];
        if ((b5 & 192) != 128) {
            t0(b5 & 255, i10);
        }
        return (i8 << 6) | (b5 & Utf8.REPLACEMENT_BYTE);
    }

    private int X(int i4) throws IOException, JsonParseException {
        int i5 = i4 & 15;
        byte[] bArr = this.S;
        int i6 = this.f17675f;
        int i7 = i6 + 1;
        this.f17675f = i7;
        byte b4 = bArr[i6];
        if ((b4 & 192) != 128) {
            t0(b4 & 255, i7);
        }
        int i8 = (i5 << 6) | (b4 & Utf8.REPLACEMENT_BYTE);
        byte[] bArr2 = this.S;
        int i9 = this.f17675f;
        int i10 = i9 + 1;
        this.f17675f = i10;
        byte b5 = bArr2[i9];
        if ((b5 & 192) != 128) {
            t0(b5 & 255, i10);
        }
        return (i8 << 6) | (b5 & Utf8.REPLACEMENT_BYTE);
    }

    private int Y(int i4) throws IOException, JsonParseException {
        if (this.f17675f >= this.f17676g) {
            I();
        }
        byte[] bArr = this.S;
        int i5 = this.f17675f;
        int i6 = i5 + 1;
        this.f17675f = i6;
        byte b4 = bArr[i5];
        if ((b4 & 192) != 128) {
            t0(b4 & 255, i6);
        }
        int i7 = ((i4 & 7) << 6) | (b4 & Utf8.REPLACEMENT_BYTE);
        if (this.f17675f >= this.f17676g) {
            I();
        }
        byte[] bArr2 = this.S;
        int i8 = this.f17675f;
        int i9 = i8 + 1;
        this.f17675f = i9;
        byte b5 = bArr2[i8];
        if ((b5 & 192) != 128) {
            t0(b5 & 255, i9);
        }
        int i10 = (i7 << 6) | (b5 & Utf8.REPLACEMENT_BYTE);
        if (this.f17675f >= this.f17676g) {
            I();
        }
        byte[] bArr3 = this.S;
        int i11 = this.f17675f;
        int i12 = i11 + 1;
        this.f17675f = i12;
        byte b6 = bArr3[i11];
        if ((b6 & 192) != 128) {
            t0(b6 & 255, i12);
        }
        return ((i10 << 6) | (b6 & Utf8.REPLACEMENT_BYTE)) - 65536;
    }

    private void a0(char[] cArr, int i4) throws IOException, JsonParseException {
        int[] iArr = U;
        byte[] bArr = this.S;
        while (true) {
            int i5 = this.f17675f;
            if (i5 >= this.f17676g) {
                I();
                i5 = this.f17675f;
            }
            int i6 = 0;
            if (i4 >= cArr.length) {
                cArr = this.f17685p.finishCurrentSegment();
                i4 = 0;
            }
            int min = Math.min(this.f17676g, (cArr.length - i4) + i5);
            while (true) {
                if (i5 < min) {
                    int i7 = i5 + 1;
                    int i8 = bArr[i5] & 255;
                    int i9 = iArr[i8];
                    if (i9 != 0) {
                        this.f17675f = i7;
                        if (i8 == 34) {
                            this.f17685p.setCurrentLength(i4);
                            return;
                        }
                        if (i9 != 1) {
                            if (i9 != 2) {
                                if (i9 != 3) {
                                    if (i9 != 4) {
                                        if (i8 < 32) {
                                            r(i8, "string value");
                                        } else {
                                            q0(i8);
                                        }
                                    } else {
                                        int Y = Y(i8);
                                        int i10 = i4 + 1;
                                        cArr[i4] = (char) ((Y >> 10) | 55296);
                                        if (i10 >= cArr.length) {
                                            cArr = this.f17685p.finishCurrentSegment();
                                            i4 = 0;
                                        } else {
                                            i4 = i10;
                                        }
                                        i8 = (Y & Place.TYPE_SUBLOCALITY_LEVEL_1) | Utf8.LOG_SURROGATE_HEADER;
                                    }
                                } else {
                                    i8 = this.f17676g - i7 >= 2 ? X(i8) : W(i8);
                                }
                            } else {
                                i8 = V(i8);
                            }
                        } else {
                            i8 = w();
                        }
                        if (i4 >= cArr.length) {
                            cArr = this.f17685p.finishCurrentSegment();
                        } else {
                            i6 = i4;
                        }
                        i4 = i6 + 1;
                        cArr[i6] = (char) i8;
                    } else {
                        cArr[i4] = (char) i8;
                        i5 = i7;
                        i4++;
                    }
                } else {
                    this.f17675f = i5;
                    break;
                }
            }
        }
    }

    private boolean g0(int i4, SerializableString serializableString) throws IOException, JsonParseException {
        JsonToken S0;
        String name = m0(i4).getName();
        this.f17683n.setCurrentName(name);
        boolean equals = name.equals(serializableString.getValue());
        this.f17696b = JsonToken.FIELD_NAME;
        int F0 = F0();
        if (F0 != 58) {
            o(F0, "was expecting a colon to separate field name and value");
        }
        int F02 = F0();
        if (F02 == 34) {
            this.P = true;
            this.f17684o = JsonToken.VALUE_STRING;
            return equals;
        }
        if (F02 != 45) {
            if (F02 != 91) {
                if (F02 != 93) {
                    if (F02 != 102) {
                        if (F02 != 110) {
                            if (F02 != 116) {
                                if (F02 != 123) {
                                    if (F02 != 125) {
                                        switch (F02) {
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
                                                S0 = e0(F02);
                                                break;
                                        }
                                    }
                                } else {
                                    S0 = JsonToken.START_OBJECT;
                                }
                            }
                            i0("true", 1);
                            S0 = JsonToken.VALUE_TRUE;
                        } else {
                            i0("null", 1);
                            S0 = JsonToken.VALUE_NULL;
                        }
                    } else {
                        i0("false", 1);
                        S0 = JsonToken.VALUE_FALSE;
                    }
                }
                o(F02, "expected a value");
                i0("true", 1);
                S0 = JsonToken.VALUE_TRUE;
            } else {
                S0 = JsonToken.START_ARRAY;
            }
            this.f17684o = S0;
            return equals;
        }
        S0 = S0(F02);
        this.f17684o = S0;
        return equals;
    }

    public static int[] growArrayBy(int[] iArr, int i4) {
        if (iArr == null) {
            return new int[i4];
        }
        int length = iArr.length;
        int[] iArr2 = new int[i4 + length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h0() throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r8 = this;
            int r0 = r8.f17675f
            int r1 = r8.f17676g
            r2 = 123(0x7b, float:1.72E-43)
            r3 = 91
            r4 = 34
            r5 = 1
            if (r0 >= r1) goto L45
            byte[] r1 = r8.S
            r6 = r1[r0]
            r7 = 58
            if (r6 != r7) goto L45
            int r0 = r0 + r5
            int r6 = r0 + 1
            r8.f17675f = r6
            r0 = r1[r0]
            if (r0 != r4) goto L25
            r8.P = r5
            com.fasterxml.jackson.core.JsonToken r0 = com.fasterxml.jackson.core.JsonToken.VALUE_STRING
            r8.f17684o = r0
            return
        L25:
            if (r0 != r2) goto L2c
            com.fasterxml.jackson.core.JsonToken r0 = com.fasterxml.jackson.core.JsonToken.START_OBJECT
            r8.f17684o = r0
            return
        L2c:
            if (r0 != r3) goto L33
            com.fasterxml.jackson.core.JsonToken r0 = com.fasterxml.jackson.core.JsonToken.START_ARRAY
            r8.f17684o = r0
            return
        L33:
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 32
            if (r0 <= r1) goto L3d
            r1 = 47
            if (r0 != r1) goto L49
        L3d:
            int r6 = r6 - r5
            r8.f17675f = r6
            int r0 = r8.F0()
            goto L49
        L45:
            int r0 = r8.x0()
        L49:
            if (r0 == r4) goto La5
            r1 = 45
            if (r0 == r1) goto L9e
            if (r0 == r3) goto L99
            r1 = 93
            if (r0 == r1) goto L8a
            r1 = 102(0x66, float:1.43E-43)
            if (r0 == r1) goto L80
            r1 = 110(0x6e, float:1.54E-43)
            if (r0 == r1) goto L76
            r1 = 116(0x74, float:1.63E-43)
            if (r0 == r1) goto L8f
            if (r0 == r2) goto L71
            r1 = 125(0x7d, float:1.75E-43)
            if (r0 == r1) goto L8a
            switch(r0) {
                case 48: goto L9e;
                case 49: goto L9e;
                case 50: goto L9e;
                case 51: goto L9e;
                case 52: goto L9e;
                case 53: goto L9e;
                case 54: goto L9e;
                case 55: goto L9e;
                case 56: goto L9e;
                case 57: goto L9e;
                default: goto L6a;
            }
        L6a:
            com.fasterxml.jackson.core.JsonToken r0 = r8.e0(r0)
            r8.f17684o = r0
            return
        L71:
            com.fasterxml.jackson.core.JsonToken r0 = com.fasterxml.jackson.core.JsonToken.START_OBJECT
            r8.f17684o = r0
            return
        L76:
            java.lang.String r0 = "null"
            r8.i0(r0, r5)
            com.fasterxml.jackson.core.JsonToken r0 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL
            r8.f17684o = r0
            return
        L80:
            java.lang.String r0 = "false"
            r8.i0(r0, r5)
            com.fasterxml.jackson.core.JsonToken r0 = com.fasterxml.jackson.core.JsonToken.VALUE_FALSE
            r8.f17684o = r0
            return
        L8a:
            java.lang.String r1 = "expected a value"
            r8.o(r0, r1)
        L8f:
            java.lang.String r0 = "true"
            r8.i0(r0, r5)
            com.fasterxml.jackson.core.JsonToken r0 = com.fasterxml.jackson.core.JsonToken.VALUE_TRUE
            r8.f17684o = r0
            return
        L99:
            com.fasterxml.jackson.core.JsonToken r0 = com.fasterxml.jackson.core.JsonToken.START_ARRAY
            r8.f17684o = r0
            return
        L9e:
            com.fasterxml.jackson.core.JsonToken r0 = r8.S0(r0)
            r8.f17684o = r0
            return
        La5:
            r8.P = r5
            com.fasterxml.jackson.core.JsonToken r0 = com.fasterxml.jackson.core.JsonToken.VALUE_STRING
            r8.f17684o = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser.h0():void");
    }

    private JsonToken j0() {
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

    private JsonToken k0(int i4) throws IOException, JsonParseException {
        if (i4 == 34) {
            this.P = true;
            JsonToken jsonToken = JsonToken.VALUE_STRING;
            this.f17696b = jsonToken;
            return jsonToken;
        }
        if (i4 != 45) {
            if (i4 != 91) {
                if (i4 != 93) {
                    if (i4 != 102) {
                        if (i4 != 110) {
                            if (i4 != 116) {
                                if (i4 != 123) {
                                    if (i4 != 125) {
                                        switch (i4) {
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
                                                JsonToken e02 = e0(i4);
                                                this.f17696b = e02;
                                                return e02;
                                        }
                                    }
                                } else {
                                    this.f17683n = this.f17683n.createChildObjectContext(this.f17681l, this.f17682m);
                                    JsonToken jsonToken2 = JsonToken.START_OBJECT;
                                    this.f17696b = jsonToken2;
                                    return jsonToken2;
                                }
                            }
                            i0("true", 1);
                            JsonToken jsonToken3 = JsonToken.VALUE_TRUE;
                            this.f17696b = jsonToken3;
                            return jsonToken3;
                        }
                        i0("null", 1);
                        JsonToken jsonToken4 = JsonToken.VALUE_NULL;
                        this.f17696b = jsonToken4;
                        return jsonToken4;
                    }
                    i0("false", 1);
                    JsonToken jsonToken5 = JsonToken.VALUE_FALSE;
                    this.f17696b = jsonToken5;
                    return jsonToken5;
                }
                o(i4, "expected a value");
                i0("true", 1);
                JsonToken jsonToken32 = JsonToken.VALUE_TRUE;
                this.f17696b = jsonToken32;
                return jsonToken32;
            }
            this.f17683n = this.f17683n.createChildArrayContext(this.f17681l, this.f17682m);
            JsonToken jsonToken6 = JsonToken.START_ARRAY;
            this.f17696b = jsonToken6;
            return jsonToken6;
        }
        JsonToken S0 = S0(i4);
        this.f17696b = S0;
        return S0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
        r5 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.fasterxml.jackson.core.JsonToken n0(char[] r10, int r11, int r12, boolean r13, int r14) throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser.n0(char[], int, int, boolean, int):com.fasterxml.jackson.core.JsonToken");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
        if (r3 == 46) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
        if (r3 == 101) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
        if (r3 != 69) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
        r6.f17675f = r10 - 1;
        r6.f17685p.setCurrentLength(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
        return S(r9, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0063, code lost:
        return n0(r1, r2, r3, r9, r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.fasterxml.jackson.core.JsonToken o0(char[] r7, int r8, boolean r9, int r10) throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r6 = this;
            r1 = r7
            r2 = r8
            r5 = r10
        L3:
            int r7 = r6.f17675f
            int r8 = r6.f17676g
            if (r7 < r8) goto L19
            boolean r7 = r6.H()
            if (r7 != 0) goto L19
            com.fasterxml.jackson.core.util.TextBuffer r7 = r6.f17685p
            r7.setCurrentLength(r2)
            com.fasterxml.jackson.core.JsonToken r7 = r6.S(r9, r5)
            return r7
        L19:
            byte[] r7 = r6.S
            int r8 = r6.f17675f
            int r10 = r8 + 1
            r6.f17675f = r10
            r7 = r7[r8]
            r3 = r7 & 255(0xff, float:3.57E-43)
            r7 = 57
            if (r3 > r7) goto L42
            r7 = 48
            if (r3 >= r7) goto L2e
            goto L42
        L2e:
            int r7 = r1.length
            if (r2 < r7) goto L39
            com.fasterxml.jackson.core.util.TextBuffer r7 = r6.f17685p
            char[] r7 = r7.finishCurrentSegment()
            r2 = 0
            r1 = r7
        L39:
            int r7 = r2 + 1
            char r8 = (char) r3
            r1[r2] = r8
            int r5 = r5 + 1
            r2 = r7
            goto L3
        L42:
            r7 = 46
            if (r3 == r7) goto L5d
            r7 = 101(0x65, float:1.42E-43)
            if (r3 == r7) goto L5d
            r7 = 69
            if (r3 != r7) goto L4f
            goto L5d
        L4f:
            int r10 = r10 + (-1)
            r6.f17675f = r10
            com.fasterxml.jackson.core.util.TextBuffer r7 = r6.f17685p
            r7.setCurrentLength(r2)
            com.fasterxml.jackson.core.JsonToken r7 = r6.S(r9, r5)
            return r7
        L5d:
            r0 = r6
            r4 = r9
            com.fasterxml.jackson.core.JsonToken r7 = r0.n0(r1, r2, r3, r4, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser.o0(char[], int, boolean, int):com.fasterxml.jackson.core.JsonToken");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0043, code lost:
        m(" in a comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void v0() throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r5 = this;
            int[] r0 = com.fasterxml.jackson.core.io.CharTypes.getInputCodeComment()
        L4:
            int r1 = r5.f17675f
            int r2 = r5.f17676g
            if (r1 < r2) goto L10
            boolean r1 = r5.H()
            if (r1 == 0) goto L43
        L10:
            byte[] r1 = r5.S
            int r2 = r5.f17675f
            int r3 = r2 + 1
            r5.f17675f = r3
            r1 = r1[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = r0[r1]
            if (r2 == 0) goto L4
            r4 = 2
            if (r2 == r4) goto L68
            r4 = 3
            if (r2 == r4) goto L64
            r4 = 4
            if (r2 == r4) goto L60
            r4 = 10
            if (r2 == r4) goto L5c
            r4 = 13
            if (r2 == r4) goto L58
            r4 = 42
            if (r2 == r4) goto L39
            r5.q0(r1)
            goto L4
        L39:
            int r1 = r5.f17676g
            if (r3 < r1) goto L49
            boolean r1 = r5.H()
            if (r1 != 0) goto L49
        L43:
            java.lang.String r0 = " in a comment"
            r5.m(r0)
            return
        L49:
            byte[] r1 = r5.S
            int r2 = r5.f17675f
            r1 = r1[r2]
            r3 = 47
            if (r1 != r3) goto L4
            int r2 = r2 + 1
            r5.f17675f = r2
            return
        L58:
            r5.w0()
            goto L4
        L5c:
            r5.A0()
            goto L4
        L60:
            r5.E0(r1)
            goto L4
        L64:
            r5.D0(r1)
            goto L4
        L68:
            r5.C0(r1)
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser.v0():void");
    }

    private int x0() throws IOException, JsonParseException {
        int i4;
        if (this.f17675f >= this.f17676g) {
            I();
        }
        byte[] bArr = this.S;
        int i5 = this.f17675f;
        int i6 = i5 + 1;
        this.f17675f = i6;
        byte b4 = bArr[i5];
        if (b4 == 58) {
            if (i6 < this.f17676g && (i4 = bArr[i6] & 255) > 32 && i4 != 47) {
                this.f17675f = i6 + 1;
                return i4;
            }
        } else {
            int i7 = b4 & 255;
            while (true) {
                if (i7 != 9) {
                    if (i7 != 10) {
                        if (i7 != 13) {
                            if (i7 != 32) {
                                if (i7 != 47) {
                                    break;
                                }
                                y0();
                            }
                        } else {
                            w0();
                        }
                    } else {
                        A0();
                    }
                }
                if (this.f17675f >= this.f17676g) {
                    I();
                }
                byte[] bArr2 = this.S;
                int i8 = this.f17675f;
                this.f17675f = i8 + 1;
                i7 = bArr2[i8] & 255;
            }
            if (i7 < 32) {
                q(i7);
            }
            if (i7 != 58) {
                o(i7, "was expecting a colon to separate field name and value");
            }
        }
        while (true) {
            if (this.f17675f >= this.f17676g && !H()) {
                throw b("Unexpected end-of-input within/between " + this.f17683n.getTypeDesc() + " entries");
            }
            byte[] bArr3 = this.S;
            int i9 = this.f17675f;
            this.f17675f = i9 + 1;
            int i10 = bArr3[i9] & 255;
            if (i10 > 32) {
                if (i10 != 47) {
                    return i10;
                }
                y0();
            } else if (i10 != 32) {
                if (i10 == 10) {
                    A0();
                } else if (i10 == 13) {
                    w0();
                } else if (i10 != 9) {
                    q(i10);
                }
            }
        }
    }

    private void y0() throws IOException, JsonParseException {
        if (!isEnabled(JsonParser.Feature.ALLOW_COMMENTS)) {
            o(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.f17675f >= this.f17676g && !H()) {
            m(" in a comment");
        }
        byte[] bArr = this.S;
        int i4 = this.f17675f;
        this.f17675f = i4 + 1;
        int i5 = bArr[i4] & 255;
        if (i5 == 47) {
            z0();
        } else if (i5 == 42) {
            v0();
        } else {
            o(i5, "was expecting either '*' or '/' for a comment");
        }
    }

    private void z0() throws IOException, JsonParseException {
        int[] inputCodeComment = CharTypes.getInputCodeComment();
        while (true) {
            if (this.f17675f >= this.f17676g && !H()) {
                return;
            }
            byte[] bArr = this.S;
            int i4 = this.f17675f;
            this.f17675f = i4 + 1;
            int i5 = bArr[i4] & 255;
            int i6 = inputCodeComment[i5];
            if (i6 != 0) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        if (i6 != 4) {
                            if (i6 != 10) {
                                if (i6 != 13) {
                                    if (i6 != 42) {
                                        q0(i5);
                                    }
                                } else {
                                    w0();
                                    return;
                                }
                            } else {
                                A0();
                                return;
                            }
                        } else {
                            E0(i5);
                        }
                    } else {
                        D0(i5);
                    }
                } else {
                    C0(i5);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.base.ParserBase
    public void A() throws IOException {
        byte[] bArr;
        super.A();
        if (this.T && (bArr = this.S) != null) {
            this.S = null;
            this.f17673d.releaseReadIOBuffer(bArr);
        }
    }

    protected void A0() throws IOException {
        this.f17678i++;
        this.f17679j = this.f17675f;
    }

    protected void B0() throws IOException, JsonParseException {
        this.P = false;
        int[] iArr = U;
        byte[] bArr = this.S;
        while (true) {
            int i4 = this.f17675f;
            int i5 = this.f17676g;
            if (i4 >= i5) {
                I();
                i4 = this.f17675f;
                i5 = this.f17676g;
            }
            while (true) {
                if (i4 < i5) {
                    int i6 = i4 + 1;
                    int i7 = bArr[i4] & 255;
                    int i8 = iArr[i7];
                    if (i8 != 0) {
                        this.f17675f = i6;
                        if (i7 == 34) {
                            return;
                        }
                        if (i8 != 1) {
                            if (i8 != 2) {
                                if (i8 != 3) {
                                    if (i8 != 4) {
                                        if (i7 < 32) {
                                            r(i7, "string value");
                                        } else {
                                            q0(i7);
                                        }
                                    } else {
                                        E0(i7);
                                    }
                                } else {
                                    D0(i7);
                                }
                            } else {
                                C0(i7);
                            }
                        } else {
                            w();
                        }
                    } else {
                        i4 = i6;
                    }
                } else {
                    this.f17675f = i4;
                    break;
                }
            }
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected boolean H() throws IOException {
        long j4 = this.f17677h;
        int i4 = this.f17676g;
        this.f17677h = j4 + i4;
        this.f17679j -= i4;
        InputStream inputStream = this.R;
        if (inputStream != null) {
            byte[] bArr = this.S;
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read > 0) {
                this.f17675f = 0;
                this.f17676g = read;
                return true;
            }
            t();
            if (read == 0) {
                throw new IOException("InputStream.read() returned 0 characters when trying to read " + this.S.length + " bytes");
            }
        }
        return false;
    }

    protected Name N0(int[] iArr, int i4, int i5, int i6, int i7) throws IOException, JsonParseException {
        int[] iArr2 = V;
        while (true) {
            if (iArr2[i6] != 0) {
                if (i6 == 34) {
                    break;
                }
                if (i6 != 92) {
                    r(i6, "name");
                } else {
                    i6 = w();
                }
                if (i6 > 127) {
                    int i8 = 0;
                    if (i7 >= 4) {
                        if (i4 >= iArr.length) {
                            iArr = growArrayBy(iArr, iArr.length);
                            this.O = iArr;
                        }
                        iArr[i4] = i5;
                        i4++;
                        i5 = 0;
                        i7 = 0;
                    }
                    if (i6 < 2048) {
                        i5 = (i5 << 8) | (i6 >> 6) | 192;
                        i7++;
                    } else {
                        int i9 = (i5 << 8) | (i6 >> 12) | Opcodes.SHL_INT_LIT8;
                        int i10 = i7 + 1;
                        if (i10 >= 4) {
                            if (i4 >= iArr.length) {
                                iArr = growArrayBy(iArr, iArr.length);
                                this.O = iArr;
                            }
                            iArr[i4] = i9;
                            i4++;
                            i10 = 0;
                        } else {
                            i8 = i9;
                        }
                        i5 = (i8 << 8) | ((i6 >> 6) & 63) | 128;
                        i7 = i10 + 1;
                    }
                    i6 = (i6 & 63) | 128;
                }
            }
            if (i7 < 4) {
                i7++;
                i5 = (i5 << 8) | i6;
            } else {
                if (i4 >= iArr.length) {
                    iArr = growArrayBy(iArr, iArr.length);
                    this.O = iArr;
                }
                iArr[i4] = i5;
                i5 = i6;
                i4++;
                i7 = 1;
            }
            if (this.f17675f >= this.f17676g && !H()) {
                m(" in field name");
            }
            byte[] bArr = this.S;
            int i11 = this.f17675f;
            this.f17675f = i11 + 1;
            i6 = bArr[i11] & 255;
        }
        if (i7 > 0) {
            if (i4 >= iArr.length) {
                iArr = growArrayBy(iArr, iArr.length);
                this.O = iArr;
            }
            iArr[i4] = i5;
            i4++;
        }
        Name findName = this.N.findName(iArr, i4);
        if (findName == null) {
            return I0(iArr, i4, i7);
        }
        return findName;
    }

    protected Name Q0(int i4) throws IOException, JsonParseException {
        int[] iArr = V;
        int i5 = 2;
        while (true) {
            int i6 = this.f17676g;
            int i7 = this.f17675f;
            if (i6 - i7 < 4) {
                return N0(this.O, i5, 0, i4, 0);
            }
            byte[] bArr = this.S;
            int i8 = i7 + 1;
            this.f17675f = i8;
            int i9 = bArr[i7] & 255;
            if (iArr[i9] != 0) {
                if (i9 == 34) {
                    return L0(this.O, i5, i4, 1);
                }
                return N0(this.O, i5, i4, i9, 1);
            }
            int i10 = (i4 << 8) | i9;
            int i11 = i8 + 1;
            this.f17675f = i11;
            int i12 = bArr[i8] & 255;
            if (iArr[i12] != 0) {
                if (i12 == 34) {
                    return L0(this.O, i5, i10, 2);
                }
                return N0(this.O, i5, i10, i12, 2);
            }
            int i13 = (i10 << 8) | i12;
            int i14 = i11 + 1;
            this.f17675f = i14;
            int i15 = bArr[i11] & 255;
            if (iArr[i15] != 0) {
                if (i15 == 34) {
                    return L0(this.O, i5, i13, 3);
                }
                return N0(this.O, i5, i13, i15, 3);
            }
            int i16 = (i13 << 8) | i15;
            this.f17675f = i14 + 1;
            int i17 = bArr[i14] & 255;
            if (iArr[i17] != 0) {
                if (i17 == 34) {
                    return L0(this.O, i5, i16, 4);
                }
                return N0(this.O, i5, i16, i17, 4);
            }
            int[] iArr2 = this.O;
            if (i5 >= iArr2.length) {
                this.O = growArrayBy(iArr2, i5);
            }
            this.O[i5] = i16;
            i5++;
            i4 = i17;
        }
    }

    protected Name R0(int i4, int[] iArr) throws IOException, JsonParseException {
        byte[] bArr = this.S;
        int i5 = this.f17675f;
        int i6 = i5 + 1;
        this.f17675f = i6;
        int i7 = bArr[i5] & 255;
        if (iArr[i7] != 0) {
            if (i7 == 34) {
                return K0(this.Q, i4, 1);
            }
            return P0(this.Q, i4, i7, 1);
        }
        int i8 = (i4 << 8) | i7;
        int i9 = i6 + 1;
        this.f17675f = i9;
        int i10 = bArr[i6] & 255;
        if (iArr[i10] != 0) {
            if (i10 == 34) {
                return K0(this.Q, i8, 2);
            }
            return P0(this.Q, i8, i10, 2);
        }
        int i11 = (i8 << 8) | i10;
        int i12 = i9 + 1;
        this.f17675f = i12;
        int i13 = bArr[i9] & 255;
        if (iArr[i13] != 0) {
            if (i13 == 34) {
                return K0(this.Q, i11, 3);
            }
            return P0(this.Q, i11, i13, 3);
        }
        int i14 = (i11 << 8) | i13;
        this.f17675f = i12 + 1;
        int i15 = bArr[i12] & 255;
        if (iArr[i15] != 0) {
            if (i15 == 34) {
                return K0(this.Q, i14, 4);
            }
            return P0(this.Q, i14, i15, 4);
        }
        int[] iArr2 = this.O;
        iArr2[0] = this.Q;
        iArr2[1] = i14;
        return Q0(i15);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0070, code lost:
        if (r8 == 46) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0074, code lost:
        if (r8 == 101) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0078, code lost:
        if (r8 != 69) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007b, code lost:
        r10.f17675f = r9 - 1;
        r10.f17685p.setCurrentLength(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0087, code lost:
        return S(r5, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008f, code lost:
        return n0(r2, r3, r8, r5, r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.fasterxml.jackson.core.JsonToken S0(int r11) throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r10 = this;
            com.fasterxml.jackson.core.util.TextBuffer r0 = r10.f17685p
            char[] r2 = r0.emptyAndGetCurrentSegment()
            r0 = 1
            r1 = 0
            r3 = 45
            if (r11 != r3) goto Le
            r5 = 1
            goto Lf
        Le:
            r5 = 0
        Lf:
            r4 = 57
            r6 = 48
            if (r5 == 0) goto L38
            r2[r1] = r3
            int r11 = r10.f17675f
            int r1 = r10.f17676g
            if (r11 < r1) goto L20
            r10.I()
        L20:
            byte[] r11 = r10.S
            int r1 = r10.f17675f
            int r3 = r1 + 1
            r10.f17675f = r3
            r11 = r11[r1]
            r11 = r11 & 255(0xff, float:3.57E-43)
            if (r11 < r6) goto L33
            if (r11 <= r4) goto L31
            goto L33
        L31:
            r1 = 1
            goto L38
        L33:
            com.fasterxml.jackson.core.JsonToken r11 = r10.d0(r11, r0)
            return r11
        L38:
            if (r11 != r6) goto L3e
            int r11 = r10.H0()
        L3e:
            int r3 = r1 + 1
            char r11 = (char) r11
            r2[r1] = r11
            int r11 = r10.f17675f
            int r1 = r2.length
            int r11 = r11 + r1
            int r1 = r10.f17676g
            if (r11 <= r1) goto L4c
            r11 = r1
        L4c:
            r7 = 1
        L4d:
            int r1 = r10.f17675f
            if (r1 < r11) goto L56
            com.fasterxml.jackson.core.JsonToken r11 = r10.o0(r2, r3, r5, r7)
            return r11
        L56:
            byte[] r8 = r10.S
            int r9 = r1 + 1
            r10.f17675f = r9
            r1 = r8[r1]
            r8 = r1 & 255(0xff, float:3.57E-43)
            if (r8 < r6) goto L6e
            if (r8 <= r4) goto L65
            goto L6e
        L65:
            int r7 = r7 + 1
            int r1 = r3 + 1
            char r8 = (char) r8
            r2[r3] = r8
            r3 = r1
            goto L4d
        L6e:
            r11 = 46
            if (r8 == r11) goto L88
            r11 = 101(0x65, float:1.42E-43)
            if (r8 == r11) goto L88
            r11 = 69
            if (r8 != r11) goto L7b
            goto L88
        L7b:
            int r9 = r9 - r0
            r10.f17675f = r9
            com.fasterxml.jackson.core.util.TextBuffer r11 = r10.f17685p
            r11.setCurrentLength(r3)
            com.fasterxml.jackson.core.JsonToken r11 = r10.S(r5, r7)
            return r11
        L88:
            r1 = r10
            r4 = r8
            r6 = r7
            com.fasterxml.jackson.core.JsonToken r11 = r1.n0(r2, r3, r4, r5, r6)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser.S0(int):com.fasterxml.jackson.core.JsonToken");
    }

    protected byte[] T(Base64Variant base64Variant) throws IOException, JsonParseException {
        ByteArrayBuilder _getByteArrayBuilder = _getByteArrayBuilder();
        while (true) {
            if (this.f17675f >= this.f17676g) {
                I();
            }
            byte[] bArr = this.S;
            int i4 = this.f17675f;
            this.f17675f = i4 + 1;
            int i5 = bArr[i4] & 255;
            if (i5 > 32) {
                int decodeBase64Char = base64Variant.decodeBase64Char(i5);
                if (decodeBase64Char < 0) {
                    if (i5 == 34) {
                        return _getByteArrayBuilder.toByteArray();
                    }
                    decodeBase64Char = v(base64Variant, i5, 0);
                    if (decodeBase64Char < 0) {
                        continue;
                    }
                }
                if (this.f17675f >= this.f17676g) {
                    I();
                }
                byte[] bArr2 = this.S;
                int i6 = this.f17675f;
                this.f17675f = i6 + 1;
                int i7 = bArr2[i6] & 255;
                int decodeBase64Char2 = base64Variant.decodeBase64Char(i7);
                if (decodeBase64Char2 < 0) {
                    decodeBase64Char2 = v(base64Variant, i7, 1);
                }
                int i8 = (decodeBase64Char << 6) | decodeBase64Char2;
                if (this.f17675f >= this.f17676g) {
                    I();
                }
                byte[] bArr3 = this.S;
                int i9 = this.f17675f;
                this.f17675f = i9 + 1;
                int i10 = bArr3[i9] & 255;
                int decodeBase64Char3 = base64Variant.decodeBase64Char(i10);
                if (decodeBase64Char3 < 0) {
                    if (decodeBase64Char3 != -2) {
                        if (i10 == 34 && !base64Variant.usesPadding()) {
                            _getByteArrayBuilder.append(i8 >> 4);
                            return _getByteArrayBuilder.toByteArray();
                        }
                        decodeBase64Char3 = v(base64Variant, i10, 2);
                    }
                    if (decodeBase64Char3 == -2) {
                        if (this.f17675f >= this.f17676g) {
                            I();
                        }
                        byte[] bArr4 = this.S;
                        int i11 = this.f17675f;
                        this.f17675f = i11 + 1;
                        int i12 = bArr4[i11] & 255;
                        if (base64Variant.usesPaddingChar(i12)) {
                            _getByteArrayBuilder.append(i8 >> 4);
                        } else {
                            throw K(base64Variant, i12, 3, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                        }
                    }
                }
                int i13 = (i8 << 6) | decodeBase64Char3;
                if (this.f17675f >= this.f17676g) {
                    I();
                }
                byte[] bArr5 = this.S;
                int i14 = this.f17675f;
                this.f17675f = i14 + 1;
                int i15 = bArr5[i14] & 255;
                int decodeBase64Char4 = base64Variant.decodeBase64Char(i15);
                if (decodeBase64Char4 < 0) {
                    if (decodeBase64Char4 != -2) {
                        if (i15 == 34 && !base64Variant.usesPadding()) {
                            _getByteArrayBuilder.appendTwoBytes(i13 >> 2);
                            return _getByteArrayBuilder.toByteArray();
                        }
                        decodeBase64Char4 = v(base64Variant, i15, 3);
                    }
                    if (decodeBase64Char4 == -2) {
                        _getByteArrayBuilder.appendTwoBytes(i13 >> 2);
                    }
                }
                _getByteArrayBuilder.appendThreeBytes((i13 << 6) | decodeBase64Char4);
            }
        }
    }

    protected Name T0() throws IOException, JsonParseException {
        if (this.f17675f >= this.f17676g && !H()) {
            m(": was expecting closing '\"' for name");
        }
        byte[] bArr = this.S;
        int i4 = this.f17675f;
        this.f17675f = i4 + 1;
        int i5 = bArr[i4] & 255;
        if (i5 == 34) {
            return BytesToNameCanonicalizer.getEmptyName();
        }
        return N0(this.O, 0, 0, i5, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected int U(int r7) throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r6 = this;
            if (r7 >= 0) goto L64
            r0 = r7 & 224(0xe0, float:3.14E-43)
            r1 = 2
            r2 = 1
            r3 = 192(0xc0, float:2.69E-43)
            if (r0 != r3) goto Le
            r7 = r7 & 31
        Lc:
            r0 = 1
            goto L28
        Le:
            r0 = r7 & 240(0xf0, float:3.36E-43)
            r3 = 224(0xe0, float:3.14E-43)
            if (r0 != r3) goto L18
            r7 = r7 & 15
            r0 = 2
            goto L28
        L18:
            r0 = r7 & 248(0xf8, float:3.48E-43)
            r3 = 240(0xf0, float:3.36E-43)
            if (r0 != r3) goto L22
            r7 = r7 & 7
            r0 = 3
            goto L28
        L22:
            r0 = r7 & 255(0xff, float:3.57E-43)
            r6.r0(r0)
            goto Lc
        L28:
            int r3 = r6.M0()
            r4 = r3 & 192(0xc0, float:2.69E-43)
            r5 = 128(0x80, float:1.794E-43)
            if (r4 == r5) goto L37
            r4 = r3 & 255(0xff, float:3.57E-43)
            r6.s0(r4)
        L37:
            int r7 = r7 << 6
            r3 = r3 & 63
            r7 = r7 | r3
            if (r0 <= r2) goto L64
            int r2 = r6.M0()
            r3 = r2 & 192(0xc0, float:2.69E-43)
            if (r3 == r5) goto L4b
            r3 = r2 & 255(0xff, float:3.57E-43)
            r6.s0(r3)
        L4b:
            int r7 = r7 << 6
            r2 = r2 & 63
            r7 = r7 | r2
            if (r0 <= r1) goto L64
            int r0 = r6.M0()
            r1 = r0 & 192(0xc0, float:2.69E-43)
            if (r1 == r5) goto L5f
            r1 = r0 & 255(0xff, float:3.57E-43)
            r6.s0(r1)
        L5f:
            int r7 = r7 << 6
            r0 = r0 & 63
            r7 = r7 | r0
        L64:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser.U(int):int");
    }

    protected void Z() throws IOException, JsonParseException {
        int i4 = this.f17675f;
        if (i4 >= this.f17676g) {
            I();
            i4 = this.f17675f;
        }
        char[] emptyAndGetCurrentSegment = this.f17685p.emptyAndGetCurrentSegment();
        int[] iArr = U;
        int min = Math.min(this.f17676g, emptyAndGetCurrentSegment.length + i4);
        byte[] bArr = this.S;
        int i5 = 0;
        while (true) {
            if (i4 >= min) {
                break;
            }
            int i6 = bArr[i4] & 255;
            if (iArr[i6] != 0) {
                if (i6 == 34) {
                    this.f17675f = i4 + 1;
                    this.f17685p.setCurrentLength(i5);
                    return;
                }
            } else {
                i4++;
                emptyAndGetCurrentSegment[i5] = (char) i6;
                i5++;
            }
        }
        this.f17675f = i4;
        a0(emptyAndGetCurrentSegment, i5);
    }

    protected String b0(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        int i4 = a.f17815a[jsonToken.ordinal()];
        if (i4 != 1) {
            if (i4 != 2 && i4 != 3 && i4 != 4) {
                return jsonToken.asString();
            }
            return this.f17685p.contentsAsString();
        }
        return this.f17683n.getCurrentName();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
        if (r6 != 39) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
        r10.f17685p.setCurrentLength(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
        return com.fasterxml.jackson.core.JsonToken.VALUE_STRING;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004f, code lost:
        r5 = r1[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
        if (r5 == 1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
        if (r5 == 2) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
        if (r5 == 3) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005b, code lost:
        if (r5 == 4) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005f, code lost:
        if (r6 >= 32) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:
        r(r6, "string value");
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0066, code lost:
        q0(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006a, code lost:
        r5 = Y(r6);
        r6 = r4 + 1;
        r0[r4] = (char) ((r5 >> 10) | 55296);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007a, code lost:
        if (r6 < r0.length) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007c, code lost:
        r0 = r10.f17685p.finishCurrentSegment();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0084, code lost:
        r4 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0085, code lost:
        r6 = 56320 | (r5 & com.google.android.gms.location.places.Place.TYPE_SUBLOCALITY_LEVEL_1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008f, code lost:
        if ((r10.f17676g - r7) < 2) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0091, code lost:
        r6 = X(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0096, code lost:
        r6 = W(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009b, code lost:
        r6 = V(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a2, code lost:
        if (r6 == 34) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a4, code lost:
        r6 = w();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a9, code lost:
        if (r4 < r0.length) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ab, code lost:
        r0 = r10.f17685p.finishCurrentSegment();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b2, code lost:
        r0[r4] = (char) r6;
        r4 = r4 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.fasterxml.jackson.core.JsonToken c0() throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r10 = this;
            com.fasterxml.jackson.core.util.TextBuffer r0 = r10.f17685p
            char[] r0 = r0.emptyAndGetCurrentSegment()
            int[] r1 = com.fasterxml.jackson.core.json.UTF8StreamJsonParser.U
            byte[] r2 = r10.S
            r3 = 0
            r4 = 0
        Lc:
            int r5 = r10.f17675f
            int r6 = r10.f17676g
            if (r5 < r6) goto L15
            r10.I()
        L15:
            int r5 = r0.length
            if (r4 < r5) goto L1f
            com.fasterxml.jackson.core.util.TextBuffer r0 = r10.f17685p
            char[] r0 = r0.finishCurrentSegment()
            r4 = 0
        L1f:
            int r5 = r10.f17676g
            int r6 = r10.f17675f
            int r7 = r0.length
            int r7 = r7 - r4
            int r6 = r6 + r7
            if (r6 >= r5) goto L29
            r5 = r6
        L29:
            int r6 = r10.f17675f
            if (r6 >= r5) goto Lc
            int r7 = r6 + 1
            r10.f17675f = r7
            r6 = r2[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r8 = 39
            if (r6 == r8) goto L45
            r9 = r1[r6]
            if (r9 == 0) goto L3e
            goto L45
        L3e:
            int r7 = r4 + 1
            char r6 = (char) r6
            r0[r4] = r6
            r4 = r7
            goto L29
        L45:
            if (r6 != r8) goto L4f
            com.fasterxml.jackson.core.util.TextBuffer r0 = r10.f17685p
            r0.setCurrentLength(r4)
            com.fasterxml.jackson.core.JsonToken r0 = com.fasterxml.jackson.core.JsonToken.VALUE_STRING
            return r0
        L4f:
            r5 = r1[r6]
            r8 = 1
            if (r5 == r8) goto La0
            r8 = 2
            if (r5 == r8) goto L9b
            r9 = 3
            if (r5 == r9) goto L8c
            r7 = 4
            if (r5 == r7) goto L6a
            r5 = 32
            if (r6 >= r5) goto L66
            java.lang.String r5 = "string value"
            r10.r(r6, r5)
        L66:
            r10.q0(r6)
            goto La8
        L6a:
            int r5 = r10.Y(r6)
            int r6 = r4 + 1
            int r7 = r5 >> 10
            r8 = 55296(0xd800, float:7.7486E-41)
            r7 = r7 | r8
            char r7 = (char) r7
            r0[r4] = r7
            int r4 = r0.length
            if (r6 < r4) goto L84
            com.fasterxml.jackson.core.util.TextBuffer r0 = r10.f17685p
            char[] r0 = r0.finishCurrentSegment()
            r4 = 0
            goto L85
        L84:
            r4 = r6
        L85:
            r5 = r5 & 1023(0x3ff, float:1.434E-42)
            r6 = 56320(0xdc00, float:7.8921E-41)
            r6 = r6 | r5
            goto La8
        L8c:
            int r5 = r10.f17676g
            int r5 = r5 - r7
            if (r5 < r8) goto L96
            int r6 = r10.X(r6)
            goto La8
        L96:
            int r6 = r10.W(r6)
            goto La8
        L9b:
            int r6 = r10.V(r6)
            goto La8
        La0:
            r5 = 34
            if (r6 == r5) goto La8
            char r6 = r10.w()
        La8:
            int r5 = r0.length
            if (r4 < r5) goto Lb2
            com.fasterxml.jackson.core.util.TextBuffer r0 = r10.f17685p
            char[] r0 = r0.finishCurrentSegment()
            r4 = 0
        Lb2:
            int r5 = r4 + 1
            char r6 = (char) r6
            r0[r4] = r6
            r4 = r5
            goto Lc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser.c0():com.fasterxml.jackson.core.JsonToken");
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.N.release();
    }

    protected JsonToken d0(int i4, boolean z3) throws IOException, JsonParseException {
        String str;
        String str2;
        if (i4 == 73) {
            if (this.f17675f >= this.f17676g && !H()) {
                n();
            }
            byte[] bArr = this.S;
            int i5 = this.f17675f;
            this.f17675f = i5 + 1;
            i4 = bArr[i5];
            double d4 = Double.NEGATIVE_INFINITY;
            if (i4 == 78) {
                if (z3) {
                    str2 = "-INF";
                } else {
                    str2 = "+INF";
                }
                i0(str2, 3);
                if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    if (!z3) {
                        d4 = Double.POSITIVE_INFINITY;
                    }
                    return Q(str2, d4);
                }
                j("Non-standard token '" + str2 + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            } else if (i4 == 110) {
                if (z3) {
                    str = "-Infinity";
                } else {
                    str = "+Infinity";
                }
                i0(str, 3);
                if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    if (!z3) {
                        d4 = Double.POSITIVE_INFINITY;
                    }
                    return Q(str, d4);
                }
                j("Non-standard token '" + str + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            }
        }
        O(i4, "expected digit (0-9) to follow minus sign, for valid numeric value");
        return null;
    }

    protected JsonToken e0(int i4) throws IOException, JsonParseException {
        if (i4 != 39) {
            if (i4 != 43) {
                if (i4 == 78) {
                    i0("NaN", 1);
                    if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                        return Q("NaN", Double.NaN);
                    }
                    j("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                }
            } else {
                if (this.f17675f >= this.f17676g && !H()) {
                    n();
                }
                byte[] bArr = this.S;
                int i5 = this.f17675f;
                this.f17675f = i5 + 1;
                return d0(bArr[i5] & 255, false);
            }
        } else if (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return c0();
        }
        o(i4, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }

    protected Name f0(int i4) throws IOException, JsonParseException {
        if (i4 == 39 && isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return l0();
        }
        if (!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            o(i4, "was expecting double-quote to start field name");
        }
        int[] inputCodeUtf8JsNames = CharTypes.getInputCodeUtf8JsNames();
        if (inputCodeUtf8JsNames[i4] != 0) {
            o(i4, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int[] iArr = this.O;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i5 < 4) {
                i5++;
                i7 = i4 | (i7 << 8);
            } else {
                if (i6 >= iArr.length) {
                    iArr = growArrayBy(iArr, iArr.length);
                    this.O = iArr;
                }
                iArr[i6] = i7;
                i7 = i4;
                i6++;
                i5 = 1;
            }
            if (this.f17675f >= this.f17676g && !H()) {
                m(" in field name");
            }
            byte[] bArr = this.S;
            int i8 = this.f17675f;
            i4 = bArr[i8] & 255;
            if (inputCodeUtf8JsNames[i4] != 0) {
                break;
            }
            this.f17675f = i8 + 1;
        }
        if (i5 > 0) {
            if (i6 >= iArr.length) {
                int[] growArrayBy = growArrayBy(iArr, iArr.length);
                this.O = growArrayBy;
                iArr = growArrayBy;
            }
            iArr[i6] = i7;
            i6++;
        }
        Name findName = this.N.findName(iArr, i6);
        if (findName == null) {
            return I0(iArr, i6, i5);
        }
        return findName;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public byte[] getBinaryValue(Base64Variant base64Variant) throws IOException, JsonParseException {
        JsonToken jsonToken = this.f17696b;
        if (jsonToken != JsonToken.VALUE_STRING && (jsonToken != JsonToken.VALUE_EMBEDDED_OBJECT || this.f17689t == null)) {
            j("Current token (" + this.f17696b + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this.P) {
            try {
                this.f17689t = T(base64Variant);
                this.P = false;
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
        return this.M;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getEmbeddedObject() throws IOException, JsonParseException {
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getInputSource() {
        return this.R;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getText() throws IOException, JsonParseException {
        JsonToken jsonToken = this.f17696b;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (this.P) {
                this.P = false;
                Z();
            }
            return this.f17685p.contentsAsString();
        }
        return b0(jsonToken);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public char[] getTextCharacters() throws IOException, JsonParseException {
        JsonToken jsonToken = this.f17696b;
        if (jsonToken != null) {
            int i4 = a.f17815a[jsonToken.ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3 && i4 != 4) {
                        return this.f17696b.asCharArray();
                    }
                } else if (this.P) {
                    this.P = false;
                    Z();
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
        int i4 = a.f17815a[jsonToken.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3 && i4 != 4) {
                    return this.f17696b.asCharArray().length;
                }
            } else if (this.P) {
                this.P = false;
                Z();
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
            int[] r2 = com.fasterxml.jackson.core.json.UTF8StreamJsonParser.a.f17815a
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
            boolean r0 = r3.P
            if (r0 == 0) goto L20
            r3.P = r1
            r3.Z()
        L20:
            com.fasterxml.jackson.core.util.TextBuffer r0 = r3.f17685p
            int r0 = r0.getTextOffset()
            return r0
        L27:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser.getTextOffset():int");
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String getValueAsString() throws IOException, JsonParseException {
        if (this.f17696b == JsonToken.VALUE_STRING) {
            if (this.P) {
                this.P = false;
                Z();
            }
            return this.f17685p.contentsAsString();
        }
        return super.getValueAsString(null);
    }

    protected void i0(String str, int i4) throws IOException, JsonParseException {
        int i5;
        int i6;
        int length = str.length();
        do {
            if (this.f17675f >= this.f17676g && !H()) {
                m(" in a value");
            }
            if (this.S[this.f17675f] != str.charAt(i4)) {
                u0(str.substring(0, i4), "'null', 'true', 'false' or NaN");
            }
            i5 = this.f17675f + 1;
            this.f17675f = i5;
            i4++;
        } while (i4 < length);
        if ((i5 < this.f17676g || H()) && (i6 = this.S[this.f17675f] & 255) >= 48 && i6 != 93 && i6 != 125 && Character.isJavaIdentifierPart((char) U(i6))) {
            this.f17675f++;
            u0(str.substring(0, i4), "'null', 'true', 'false' or NaN");
        }
    }

    protected Name l0() throws IOException, JsonParseException {
        if (this.f17675f >= this.f17676g && !H()) {
            m(": was expecting closing ''' for name");
        }
        byte[] bArr = this.S;
        int i4 = this.f17675f;
        this.f17675f = i4 + 1;
        int i5 = bArr[i4] & 255;
        if (i5 == 39) {
            return BytesToNameCanonicalizer.getEmptyName();
        }
        int[] iArr = this.O;
        int[] iArr2 = V;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i5 != 39) {
            if (i5 != 34 && iArr2[i5] != 0) {
                if (i5 != 92) {
                    r(i5, "name");
                } else {
                    i5 = w();
                }
                if (i5 > 127) {
                    if (i6 >= 4) {
                        if (i7 >= iArr.length) {
                            iArr = growArrayBy(iArr, iArr.length);
                            this.O = iArr;
                        }
                        iArr[i7] = i8;
                        i7++;
                        i6 = 0;
                        i8 = 0;
                    }
                    if (i5 < 2048) {
                        i8 = (i8 << 8) | (i5 >> 6) | 192;
                        i6++;
                    } else {
                        int i9 = (i8 << 8) | (i5 >> 12) | Opcodes.SHL_INT_LIT8;
                        int i10 = i6 + 1;
                        if (i10 >= 4) {
                            if (i7 >= iArr.length) {
                                iArr = growArrayBy(iArr, iArr.length);
                                this.O = iArr;
                            }
                            iArr[i7] = i9;
                            i7++;
                            i10 = 0;
                            i9 = 0;
                        }
                        i8 = (i9 << 8) | ((i5 >> 6) & 63) | 128;
                        i6 = i10 + 1;
                    }
                    i5 = (i5 & 63) | 128;
                }
            }
            if (i6 < 4) {
                i6++;
                i8 = i5 | (i8 << 8);
            } else {
                if (i7 >= iArr.length) {
                    iArr = growArrayBy(iArr, iArr.length);
                    this.O = iArr;
                }
                iArr[i7] = i8;
                i8 = i5;
                i7++;
                i6 = 1;
            }
            if (this.f17675f >= this.f17676g && !H()) {
                m(" in field name");
            }
            byte[] bArr2 = this.S;
            int i11 = this.f17675f;
            this.f17675f = i11 + 1;
            i5 = bArr2[i11] & 255;
        }
        if (i6 > 0) {
            if (i7 >= iArr.length) {
                int[] growArrayBy = growArrayBy(iArr, iArr.length);
                this.O = growArrayBy;
                iArr = growArrayBy;
            }
            iArr[i7] = i8;
            i7++;
        }
        Name findName = this.N.findName(iArr, i7);
        if (findName == null) {
            return I0(iArr, i7, i6);
        }
        return findName;
    }

    protected Name m0(int i4) throws IOException, JsonParseException {
        if (i4 != 34) {
            return f0(i4);
        }
        int i5 = this.f17675f;
        if (i5 + 9 > this.f17676g) {
            return T0();
        }
        byte[] bArr = this.S;
        int[] iArr = V;
        int i6 = i5 + 1;
        this.f17675f = i6;
        int i7 = bArr[i5] & 255;
        if (iArr[i7] == 0) {
            int i8 = i6 + 1;
            this.f17675f = i8;
            int i9 = bArr[i6] & 255;
            if (iArr[i9] == 0) {
                int i10 = (i7 << 8) | i9;
                int i11 = i8 + 1;
                this.f17675f = i11;
                int i12 = bArr[i8] & 255;
                if (iArr[i12] == 0) {
                    int i13 = (i10 << 8) | i12;
                    int i14 = i11 + 1;
                    this.f17675f = i14;
                    int i15 = bArr[i11] & 255;
                    if (iArr[i15] == 0) {
                        int i16 = (i13 << 8) | i15;
                        this.f17675f = i14 + 1;
                        int i17 = bArr[i14] & 255;
                        if (iArr[i17] == 0) {
                            this.Q = i16;
                            return R0(i17, iArr);
                        } else if (i17 == 34) {
                            return J0(i16, 4);
                        } else {
                            return O0(i16, i17, 4);
                        }
                    } else if (i15 == 34) {
                        return J0(i13, 3);
                    } else {
                        return O0(i13, i15, 3);
                    }
                } else if (i12 == 34) {
                    return J0(i10, 2);
                } else {
                    return O0(i10, i12, 2);
                }
            } else if (i9 == 34) {
                return J0(i7, 1);
            } else {
                return O0(i7, i9, 1);
            }
        } else if (i7 == 34) {
            return BytesToNameCanonicalizer.getEmptyName();
        } else {
            return O0(0, i7, 0);
        }
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
        int i4 = a.f17815a[nextToken().ordinal()];
        if (i4 != 5) {
            if (i4 != 6) {
                return null;
            }
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean nextFieldName(SerializableString serializableString) throws IOException, JsonParseException {
        this.f17690u = 0;
        if (this.f17696b == JsonToken.FIELD_NAME) {
            j0();
            return false;
        }
        if (this.P) {
            B0();
        }
        int G0 = G0();
        if (G0 < 0) {
            close();
            this.f17696b = null;
            return false;
        }
        long j4 = this.f17677h;
        int i4 = this.f17675f;
        this.f17680k = (j4 + i4) - 1;
        this.f17681l = this.f17678i;
        this.f17682m = (i4 - this.f17679j) - 1;
        this.f17689t = null;
        if (G0 == 93) {
            if (!this.f17683n.inArray()) {
                B(G0, '}');
            }
            this.f17683n = this.f17683n.getParent();
            this.f17696b = JsonToken.END_ARRAY;
            return false;
        } else if (G0 == 125) {
            if (!this.f17683n.inObject()) {
                B(G0, ']');
            }
            this.f17683n = this.f17683n.getParent();
            this.f17696b = JsonToken.END_OBJECT;
            return false;
        } else {
            if (this.f17683n.expectComma()) {
                if (G0 != 44) {
                    o(G0, "was expecting comma to separate " + this.f17683n.getTypeDesc() + " entries");
                }
                G0 = F0();
            }
            if (!this.f17683n.inObject()) {
                k0(G0);
                return false;
            }
            if (G0 == 34) {
                byte[] asQuotedUTF8 = serializableString.asQuotedUTF8();
                int length = asQuotedUTF8.length;
                int i5 = this.f17675f;
                if (i5 + length < this.f17676g) {
                    int i6 = i5 + length;
                    if (this.S[i6] == 34) {
                        for (int i7 = 0; i7 != length; i7++) {
                            if (asQuotedUTF8[i7] == this.S[i5 + i7]) {
                            }
                        }
                        this.f17675f = i6 + 1;
                        this.f17683n.setCurrentName(serializableString.getValue());
                        this.f17696b = JsonToken.FIELD_NAME;
                        h0();
                        return true;
                    }
                }
            }
            return g0(G0, serializableString);
        }
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
                if (this.P) {
                    this.P = false;
                    Z();
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
        JsonToken S0;
        this.f17690u = 0;
        JsonToken jsonToken = this.f17696b;
        JsonToken jsonToken2 = JsonToken.FIELD_NAME;
        if (jsonToken == jsonToken2) {
            return j0();
        }
        if (this.P) {
            B0();
        }
        int G0 = G0();
        if (G0 < 0) {
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
        if (G0 == 93) {
            if (!this.f17683n.inArray()) {
                B(G0, '}');
            }
            this.f17683n = this.f17683n.getParent();
            JsonToken jsonToken3 = JsonToken.END_ARRAY;
            this.f17696b = jsonToken3;
            return jsonToken3;
        } else if (G0 == 125) {
            if (!this.f17683n.inObject()) {
                B(G0, ']');
            }
            this.f17683n = this.f17683n.getParent();
            JsonToken jsonToken4 = JsonToken.END_OBJECT;
            this.f17696b = jsonToken4;
            return jsonToken4;
        } else {
            if (this.f17683n.expectComma()) {
                if (G0 != 44) {
                    o(G0, "was expecting comma to separate " + this.f17683n.getTypeDesc() + " entries");
                }
                G0 = F0();
            }
            if (!this.f17683n.inObject()) {
                return k0(G0);
            }
            this.f17683n.setCurrentName(m0(G0).getName());
            this.f17696b = jsonToken2;
            int F0 = F0();
            if (F0 != 58) {
                o(F0, "was expecting a colon to separate field name and value");
            }
            int F02 = F0();
            if (F02 == 34) {
                this.P = true;
                this.f17684o = JsonToken.VALUE_STRING;
                return this.f17696b;
            }
            if (F02 != 45) {
                if (F02 != 91) {
                    if (F02 != 93) {
                        if (F02 != 102) {
                            if (F02 != 110) {
                                if (F02 != 116) {
                                    if (F02 != 123) {
                                        if (F02 != 125) {
                                            switch (F02) {
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
                                                    S0 = e0(F02);
                                                    break;
                                            }
                                        }
                                    } else {
                                        S0 = JsonToken.START_OBJECT;
                                    }
                                }
                                i0("true", 1);
                                S0 = JsonToken.VALUE_TRUE;
                            } else {
                                i0("null", 1);
                                S0 = JsonToken.VALUE_NULL;
                            }
                        } else {
                            i0("false", 1);
                            S0 = JsonToken.VALUE_FALSE;
                        }
                    }
                    o(F02, "expected a value");
                    i0("true", 1);
                    S0 = JsonToken.VALUE_TRUE;
                } else {
                    S0 = JsonToken.START_ARRAY;
                }
                this.f17684o = S0;
                return this.f17696b;
            }
            S0 = S0(F02);
            this.f17684o = S0;
            return this.f17696b;
        }
    }

    protected int p0(Base64Variant base64Variant, OutputStream outputStream, byte[] bArr) throws IOException, JsonParseException {
        int i4;
        int length = bArr.length - 3;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (this.f17675f >= this.f17676g) {
                I();
            }
            byte[] bArr2 = this.S;
            int i7 = this.f17675f;
            this.f17675f = i7 + 1;
            int i8 = bArr2[i7] & 255;
            if (i8 > 32) {
                int decodeBase64Char = base64Variant.decodeBase64Char(i8);
                if (decodeBase64Char < 0) {
                    if (i8 == 34) {
                        break;
                    }
                    decodeBase64Char = v(base64Variant, i8, 0);
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
                byte[] bArr3 = this.S;
                int i9 = this.f17675f;
                this.f17675f = i9 + 1;
                int i10 = bArr3[i9] & 255;
                int decodeBase64Char2 = base64Variant.decodeBase64Char(i10);
                if (decodeBase64Char2 < 0) {
                    decodeBase64Char2 = v(base64Variant, i10, 1);
                }
                int i11 = (decodeBase64Char << 6) | decodeBase64Char2;
                if (this.f17675f >= this.f17676g) {
                    I();
                }
                byte[] bArr4 = this.S;
                int i12 = this.f17675f;
                this.f17675f = i12 + 1;
                int i13 = bArr4[i12] & 255;
                int decodeBase64Char3 = base64Variant.decodeBase64Char(i13);
                if (decodeBase64Char3 < 0) {
                    if (decodeBase64Char3 != -2) {
                        if (i13 == 34 && !base64Variant.usesPadding()) {
                            bArr[i5] = (byte) (i11 >> 4);
                            i5++;
                            break;
                        }
                        decodeBase64Char3 = v(base64Variant, i13, 2);
                    }
                    if (decodeBase64Char3 == -2) {
                        if (this.f17675f >= this.f17676g) {
                            I();
                        }
                        byte[] bArr5 = this.S;
                        int i14 = this.f17675f;
                        this.f17675f = i14 + 1;
                        int i15 = bArr5[i14] & 255;
                        if (base64Variant.usesPaddingChar(i15)) {
                            i4 = i5 + 1;
                            bArr[i5] = (byte) (i11 >> 4);
                            i5 = i4;
                        } else {
                            throw K(base64Variant, i15, 3, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                        }
                    }
                }
                int i16 = (i11 << 6) | decodeBase64Char3;
                if (this.f17675f >= this.f17676g) {
                    I();
                }
                byte[] bArr6 = this.S;
                int i17 = this.f17675f;
                this.f17675f = i17 + 1;
                int i18 = bArr6[i17] & 255;
                int decodeBase64Char4 = base64Variant.decodeBase64Char(i18);
                if (decodeBase64Char4 < 0) {
                    if (decodeBase64Char4 != -2) {
                        if (i18 == 34 && !base64Variant.usesPadding()) {
                            int i19 = i16 >> 2;
                            int i20 = i5 + 1;
                            bArr[i5] = (byte) (i19 >> 8);
                            i5 = i20 + 1;
                            bArr[i20] = (byte) i19;
                            break;
                        }
                        decodeBase64Char4 = v(base64Variant, i18, 3);
                    }
                    if (decodeBase64Char4 == -2) {
                        int i21 = i16 >> 2;
                        int i22 = i5 + 1;
                        bArr[i5] = (byte) (i21 >> 8);
                        i5 = i22 + 1;
                        bArr[i22] = (byte) i21;
                    }
                }
                int i23 = (i16 << 6) | decodeBase64Char4;
                int i24 = i5 + 1;
                bArr[i5] = (byte) (i23 >> 16);
                int i25 = i24 + 1;
                bArr[i24] = (byte) (i23 >> 8);
                i4 = i25 + 1;
                bArr[i25] = (byte) i23;
                i5 = i4;
            }
        }
        this.P = false;
        if (i5 > 0) {
            int i26 = i6 + i5;
            outputStream.write(bArr, 0, i5);
            return i26;
        }
        return i6;
    }

    protected void q0(int i4) throws JsonParseException {
        if (i4 < 32) {
            q(i4);
        }
        r0(i4);
    }

    protected void r0(int i4) throws JsonParseException {
        j("Invalid UTF-8 start byte 0x" + Integer.toHexString(i4));
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int readBinaryValue(Base64Variant base64Variant, OutputStream outputStream) throws IOException, JsonParseException {
        if (this.P && this.f17696b == JsonToken.VALUE_STRING) {
            byte[] allocBase64Buffer = this.f17673d.allocBase64Buffer();
            try {
                return p0(base64Variant, outputStream, allocBase64Buffer);
            } finally {
                this.f17673d.releaseBase64Buffer(allocBase64Buffer);
            }
        }
        byte[] binaryValue = getBinaryValue(base64Variant);
        outputStream.write(binaryValue);
        return binaryValue.length;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int releaseBuffered(OutputStream outputStream) throws IOException {
        int i4 = this.f17676g;
        int i5 = this.f17675f;
        int i6 = i4 - i5;
        if (i6 < 1) {
            return 0;
        }
        outputStream.write(this.S, i5, i6);
        return i6;
    }

    protected void s0(int i4) throws JsonParseException {
        j("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i4));
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void setCodec(ObjectCodec objectCodec) {
        this.M = objectCodec;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected void t() throws IOException {
        if (this.R != null) {
            if (this.f17673d.isResourceManaged() || isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this.R.close();
            }
            this.R = null;
        }
    }

    protected void t0(int i4, int i5) throws JsonParseException {
        this.f17675f = i5;
        s0(i4);
    }

    protected void u0(String str, String str2) throws IOException, JsonParseException {
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            if (this.f17675f >= this.f17676g && !H()) {
                break;
            }
            byte[] bArr = this.S;
            int i4 = this.f17675f;
            this.f17675f = i4 + 1;
            char U2 = (char) U(bArr[i4]);
            if (!Character.isJavaIdentifierPart(U2)) {
                break;
            }
            sb.append(U2);
        }
        j("Unrecognized token '" + sb.toString() + "': was expecting " + str2);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return CoreVersion.instance.version();
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected char w() throws IOException, JsonParseException {
        if (this.f17675f >= this.f17676g && !H()) {
            m(" in character escape sequence");
        }
        byte[] bArr = this.S;
        int i4 = this.f17675f;
        this.f17675f = i4 + 1;
        byte b4 = bArr[i4];
        if (b4 != 34 && b4 != 47 && b4 != 92) {
            if (b4 != 98) {
                if (b4 != 102) {
                    if (b4 != 110) {
                        if (b4 != 114) {
                            if (b4 != 116) {
                                if (b4 != 117) {
                                    return h((char) U(b4));
                                }
                                int i5 = 0;
                                for (int i6 = 0; i6 < 4; i6++) {
                                    if (this.f17675f >= this.f17676g && !H()) {
                                        m(" in character escape sequence");
                                    }
                                    byte[] bArr2 = this.S;
                                    int i7 = this.f17675f;
                                    this.f17675f = i7 + 1;
                                    byte b5 = bArr2[i7];
                                    int charToHex = CharTypes.charToHex(b5);
                                    if (charToHex < 0) {
                                        o(b5, "expected a hex-digit for character escape sequence");
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
        return (char) b4;
    }

    protected void w0() throws IOException {
        if (this.f17675f < this.f17676g || H()) {
            byte[] bArr = this.S;
            int i4 = this.f17675f;
            if (bArr[i4] == 10) {
                this.f17675f = i4 + 1;
            }
        }
        this.f17678i++;
        this.f17679j = this.f17675f;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getValueAsString(String str) throws IOException, JsonParseException {
        if (this.f17696b == JsonToken.VALUE_STRING) {
            if (this.P) {
                this.P = false;
                Z();
            }
            return this.f17685p.contentsAsString();
        }
        return super.getValueAsString(str);
    }
}
