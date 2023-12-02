package com.fasterxml.jackson.core.base;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.json.JsonReadContext;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes3.dex */
public abstract class ParserBase extends ParserMinimalBase {
    static final BigInteger E;
    static final BigInteger F;
    static final BigInteger G;
    static final BigInteger H;
    static final BigDecimal I;
    static final BigDecimal J;
    static final BigDecimal K;
    static final BigDecimal L;
    protected boolean A;
    protected int B;
    protected int C;
    protected int D;

    /* renamed from: d  reason: collision with root package name */
    protected final IOContext f17673d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f17674e;

    /* renamed from: n  reason: collision with root package name */
    protected JsonReadContext f17683n;

    /* renamed from: o  reason: collision with root package name */
    protected JsonToken f17684o;

    /* renamed from: p  reason: collision with root package name */
    protected final TextBuffer f17685p;

    /* renamed from: t  reason: collision with root package name */
    protected byte[] f17689t;

    /* renamed from: v  reason: collision with root package name */
    protected int f17691v;

    /* renamed from: w  reason: collision with root package name */
    protected long f17692w;

    /* renamed from: x  reason: collision with root package name */
    protected double f17693x;

    /* renamed from: y  reason: collision with root package name */
    protected BigInteger f17694y;

    /* renamed from: z  reason: collision with root package name */
    protected BigDecimal f17695z;

    /* renamed from: f  reason: collision with root package name */
    protected int f17675f = 0;

    /* renamed from: g  reason: collision with root package name */
    protected int f17676g = 0;

    /* renamed from: h  reason: collision with root package name */
    protected long f17677h = 0;

    /* renamed from: i  reason: collision with root package name */
    protected int f17678i = 1;

    /* renamed from: j  reason: collision with root package name */
    protected int f17679j = 0;

    /* renamed from: k  reason: collision with root package name */
    protected long f17680k = 0;

    /* renamed from: l  reason: collision with root package name */
    protected int f17681l = 1;

    /* renamed from: m  reason: collision with root package name */
    protected int f17682m = 0;

    /* renamed from: q  reason: collision with root package name */
    protected char[] f17686q = null;

    /* renamed from: r  reason: collision with root package name */
    protected boolean f17687r = false;

    /* renamed from: s  reason: collision with root package name */
    protected ByteArrayBuilder f17688s = null;

    /* renamed from: u  reason: collision with root package name */
    protected int f17690u = 0;

    static {
        BigInteger valueOf = BigInteger.valueOf(-2147483648L);
        E = valueOf;
        BigInteger valueOf2 = BigInteger.valueOf(2147483647L);
        F = valueOf2;
        BigInteger valueOf3 = BigInteger.valueOf(Long.MIN_VALUE);
        G = valueOf3;
        BigInteger valueOf4 = BigInteger.valueOf(Long.MAX_VALUE);
        H = valueOf4;
        I = new BigDecimal(valueOf3);
        J = new BigDecimal(valueOf4);
        K = new BigDecimal(valueOf);
        L = new BigDecimal(valueOf2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ParserBase(IOContext iOContext, int i4) {
        this.f17658a = i4;
        this.f17673d = iOContext;
        this.f17685p = iOContext.constructTextBuffer();
        this.f17683n = JsonReadContext.createRootContext();
    }

    private void y(int i4) throws IOException, JsonParseException {
        try {
            if (i4 == 16) {
                this.f17695z = this.f17685p.contentsAsDecimal();
                this.f17690u = 16;
            } else {
                this.f17693x = this.f17685p.contentsAsDouble();
                this.f17690u = 8;
            }
        } catch (NumberFormatException e4) {
            s("Malformed numeric value '" + this.f17685p.contentsAsString() + "'", e4);
        }
    }

    private void z(int i4, char[] cArr, int i5, int i6) throws IOException, JsonParseException {
        String contentsAsString = this.f17685p.contentsAsString();
        try {
            if (NumberInput.inLongRange(cArr, i5, i6, this.A)) {
                this.f17692w = Long.parseLong(contentsAsString);
                this.f17690u = 2;
            } else {
                this.f17694y = new BigInteger(contentsAsString);
                this.f17690u = 4;
            }
        } catch (NumberFormatException e4) {
            s("Malformed numeric value '" + contentsAsString + "'", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A() throws IOException {
        this.f17685p.releaseBuffers();
        char[] cArr = this.f17686q;
        if (cArr != null) {
            this.f17686q = null;
            this.f17673d.releaseNameCopyBuffer(cArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(int i4, char c4) throws JsonParseException {
        j("Unexpected close marker '" + ((char) i4) + "': expected '" + c4 + "' (for " + this.f17683n.getTypeDesc() + " starting at " + ("" + this.f17683n.getStartLocation(this.f17673d.getSourceReference())) + ")");
    }

    protected void C() throws IOException, JsonParseException {
        int i4 = this.f17690u;
        if ((i4 & 8) != 0) {
            this.f17695z = new BigDecimal(getText());
        } else if ((i4 & 4) != 0) {
            this.f17695z = new BigDecimal(this.f17694y);
        } else if ((i4 & 2) != 0) {
            this.f17695z = BigDecimal.valueOf(this.f17692w);
        } else if ((i4 & 1) != 0) {
            this.f17695z = BigDecimal.valueOf(this.f17691v);
        } else {
            p();
        }
        this.f17690u |= 16;
    }

    protected void D() throws IOException, JsonParseException {
        int i4 = this.f17690u;
        if ((i4 & 16) != 0) {
            this.f17694y = this.f17695z.toBigInteger();
        } else if ((i4 & 2) != 0) {
            this.f17694y = BigInteger.valueOf(this.f17692w);
        } else if ((i4 & 1) != 0) {
            this.f17694y = BigInteger.valueOf(this.f17691v);
        } else if ((i4 & 8) != 0) {
            this.f17694y = BigDecimal.valueOf(this.f17693x).toBigInteger();
        } else {
            p();
        }
        this.f17690u |= 4;
    }

    protected void E() throws IOException, JsonParseException {
        int i4 = this.f17690u;
        if ((i4 & 16) != 0) {
            this.f17693x = this.f17695z.doubleValue();
        } else if ((i4 & 4) != 0) {
            this.f17693x = this.f17694y.doubleValue();
        } else if ((i4 & 2) != 0) {
            this.f17693x = this.f17692w;
        } else if ((i4 & 1) != 0) {
            this.f17693x = this.f17691v;
        } else {
            p();
        }
        this.f17690u |= 8;
    }

    protected void F() throws IOException, JsonParseException {
        int i4 = this.f17690u;
        if ((i4 & 2) != 0) {
            long j4 = this.f17692w;
            int i5 = (int) j4;
            if (i5 != j4) {
                j("Numeric value (" + getText() + ") out of range of int");
            }
            this.f17691v = i5;
        } else if ((i4 & 4) != 0) {
            if (E.compareTo(this.f17694y) > 0 || F.compareTo(this.f17694y) < 0) {
                M();
            }
            this.f17691v = this.f17694y.intValue();
        } else if ((i4 & 8) != 0) {
            double d4 = this.f17693x;
            if (d4 < -2.147483648E9d || d4 > 2.147483647E9d) {
                M();
            }
            this.f17691v = (int) this.f17693x;
        } else if ((i4 & 16) != 0) {
            if (K.compareTo(this.f17695z) > 0 || L.compareTo(this.f17695z) < 0) {
                M();
            }
            this.f17691v = this.f17695z.intValue();
        } else {
            p();
        }
        this.f17690u |= 1;
    }

    protected void G() throws IOException, JsonParseException {
        int i4 = this.f17690u;
        if ((i4 & 1) != 0) {
            this.f17692w = this.f17691v;
        } else if ((i4 & 4) != 0) {
            if (G.compareTo(this.f17694y) > 0 || H.compareTo(this.f17694y) < 0) {
                N();
            }
            this.f17692w = this.f17694y.longValue();
        } else if ((i4 & 8) != 0) {
            double d4 = this.f17693x;
            if (d4 < -9.223372036854776E18d || d4 > 9.223372036854776E18d) {
                N();
            }
            this.f17692w = (long) this.f17693x;
        } else if ((i4 & 16) != 0) {
            if (I.compareTo(this.f17695z) > 0 || J.compareTo(this.f17695z) < 0) {
                N();
            }
            this.f17692w = this.f17695z.longValue();
        } else {
            p();
        }
        this.f17690u |= 2;
    }

    protected abstract boolean H() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void I() throws IOException {
        if (!H()) {
            l();
        }
    }

    protected IllegalArgumentException J(Base64Variant base64Variant, int i4, int i5) throws IllegalArgumentException {
        return K(base64Variant, i4, i5, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IllegalArgumentException K(Base64Variant base64Variant, int i4, int i5, String str) throws IllegalArgumentException {
        String str2;
        if (i4 <= 32) {
            str2 = "Illegal white space character (code 0x" + Integer.toHexString(i4) + ") as character #" + (i5 + 1) + " of 4-char base64 unit: can only used between units";
        } else if (base64Variant.usesPaddingChar(i4)) {
            str2 = "Unexpected padding character ('" + base64Variant.getPaddingChar() + "') as character #" + (i5 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (Character.isDefined(i4) && !Character.isISOControl(i4)) {
            str2 = "Illegal character '" + ((char) i4) + "' (code 0x" + Integer.toHexString(i4) + ") in base64 content";
        } else {
            str2 = "Illegal character (code 0x" + Integer.toHexString(i4) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        return new IllegalArgumentException(str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(String str) throws JsonParseException {
        j("Invalid numeric value: " + str);
    }

    protected void M() throws IOException, JsonParseException {
        j("Numeric value (" + getText() + ") out of range of int (-2147483648 - 2147483647)");
    }

    protected void N() throws IOException, JsonParseException {
        j("Numeric value (" + getText() + ") out of range of long (-9223372036854775808 - 9223372036854775807)");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O(int i4, String str) throws JsonParseException {
        String str2 = "Unexpected character (" + ParserMinimalBase.f(i4) + ") in numeric value";
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        j(str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken P(boolean z3, int i4, int i5, int i6) {
        if (i5 < 1 && i6 < 1) {
            return S(z3, i4);
        }
        return R(z3, i4, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken Q(String str, double d4) {
        this.f17685p.resetWithString(str);
        this.f17693x = d4;
        this.f17690u = 8;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken R(boolean z3, int i4, int i5, int i6) {
        this.A = z3;
        this.B = i4;
        this.C = i5;
        this.D = i6;
        this.f17690u = 0;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JsonToken S(boolean z3, int i4) {
        this.A = z3;
        this.B = i4;
        this.C = 0;
        this.D = 0;
        this.f17690u = 0;
        return JsonToken.VALUE_NUMBER_INT;
    }

    public ByteArrayBuilder _getByteArrayBuilder() {
        ByteArrayBuilder byteArrayBuilder = this.f17688s;
        if (byteArrayBuilder == null) {
            this.f17688s = new ByteArrayBuilder();
        } else {
            byteArrayBuilder.reset();
        }
        return this.f17688s;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f17674e) {
            this.f17674e = true;
            try {
                t();
            } finally {
                A();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase
    public void g() throws JsonParseException {
        if (!this.f17683n.inRoot()) {
            m(": expected close marker for " + this.f17683n.getTypeDesc() + " (from " + this.f17683n.getStartLocation(this.f17673d.getSourceReference()) + ")");
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigInteger getBigIntegerValue() throws IOException, JsonParseException {
        int i4 = this.f17690u;
        if ((i4 & 4) == 0) {
            if (i4 == 0) {
                x(4);
            }
            if ((this.f17690u & 4) == 0) {
                D();
            }
        }
        return this.f17694y;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation getCurrentLocation() {
        return new JsonLocation(this.f17673d.getSourceReference(), (this.f17677h + this.f17675f) - 1, this.f17678i, (this.f17675f - this.f17679j) + 1);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getCurrentName() throws IOException, JsonParseException {
        JsonToken jsonToken = this.f17696b;
        if (jsonToken != JsonToken.START_OBJECT && jsonToken != JsonToken.START_ARRAY) {
            return this.f17683n.getCurrentName();
        }
        return this.f17683n.getParent().getCurrentName();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigDecimal getDecimalValue() throws IOException, JsonParseException {
        int i4 = this.f17690u;
        if ((i4 & 16) == 0) {
            if (i4 == 0) {
                x(16);
            }
            if ((this.f17690u & 16) == 0) {
                C();
            }
        }
        return this.f17695z;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public double getDoubleValue() throws IOException, JsonParseException {
        int i4 = this.f17690u;
        if ((i4 & 8) == 0) {
            if (i4 == 0) {
                x(8);
            }
            if ((this.f17690u & 8) == 0) {
                E();
            }
        }
        return this.f17693x;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public float getFloatValue() throws IOException, JsonParseException {
        return (float) getDoubleValue();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getIntValue() throws IOException, JsonParseException {
        int i4 = this.f17690u;
        if ((i4 & 1) == 0) {
            if (i4 == 0) {
                x(1);
            }
            if ((this.f17690u & 1) == 0) {
                F();
            }
        }
        return this.f17691v;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long getLongValue() throws IOException, JsonParseException {
        int i4 = this.f17690u;
        if ((i4 & 2) == 0) {
            if (i4 == 0) {
                x(2);
            }
            if ((this.f17690u & 2) == 0) {
                G();
            }
        }
        return this.f17692w;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser.NumberType getNumberType() throws IOException, JsonParseException {
        if (this.f17690u == 0) {
            x(0);
        }
        if (this.f17696b == JsonToken.VALUE_NUMBER_INT) {
            int i4 = this.f17690u;
            if ((i4 & 1) != 0) {
                return JsonParser.NumberType.INT;
            }
            if ((i4 & 2) != 0) {
                return JsonParser.NumberType.LONG;
            }
            return JsonParser.NumberType.BIG_INTEGER;
        } else if ((this.f17690u & 16) != 0) {
            return JsonParser.NumberType.BIG_DECIMAL;
        } else {
            return JsonParser.NumberType.DOUBLE;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Number getNumberValue() throws IOException, JsonParseException {
        if (this.f17690u == 0) {
            x(0);
        }
        if (this.f17696b == JsonToken.VALUE_NUMBER_INT) {
            int i4 = this.f17690u;
            if ((i4 & 1) != 0) {
                return Integer.valueOf(this.f17691v);
            }
            if ((i4 & 2) != 0) {
                return Long.valueOf(this.f17692w);
            }
            if ((i4 & 4) != 0) {
                return this.f17694y;
            }
            return this.f17695z;
        }
        int i5 = this.f17690u;
        if ((i5 & 16) != 0) {
            return this.f17695z;
        }
        if ((i5 & 8) == 0) {
            p();
        }
        return Double.valueOf(this.f17693x);
    }

    public long getTokenCharacterOffset() {
        return this.f17680k;
    }

    public int getTokenColumnNr() {
        int i4 = this.f17682m;
        if (i4 >= 0) {
            return i4 + 1;
        }
        return i4;
    }

    public int getTokenLineNr() {
        return this.f17681l;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation getTokenLocation() {
        return new JsonLocation(this.f17673d.getSourceReference(), getTokenCharacterOffset(), getTokenLineNr(), getTokenColumnNr());
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public boolean hasTextCharacters() {
        JsonToken jsonToken = this.f17696b;
        if (jsonToken == JsonToken.VALUE_STRING) {
            return true;
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            return this.f17687r;
        }
        return false;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public boolean isClosed() {
        return this.f17674e;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public void overrideCurrentName(String str) {
        JsonReadContext jsonReadContext = this.f17683n;
        JsonToken jsonToken = this.f17696b;
        if (jsonToken == JsonToken.START_OBJECT || jsonToken == JsonToken.START_ARRAY) {
            jsonReadContext = jsonReadContext.getParent();
        }
        jsonReadContext.setCurrentName(str);
    }

    protected abstract void t() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public final int u(Base64Variant base64Variant, char c4, int i4) throws IOException, JsonParseException {
        if (c4 == '\\') {
            char w3 = w();
            if (w3 <= ' ' && i4 == 0) {
                return -1;
            }
            int decodeBase64Char = base64Variant.decodeBase64Char(w3);
            if (decodeBase64Char >= 0) {
                return decodeBase64Char;
            }
            throw J(base64Variant, w3, i4);
        }
        throw J(base64Variant, c4, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int v(Base64Variant base64Variant, int i4, int i5) throws IOException, JsonParseException {
        if (i4 == 92) {
            char w3 = w();
            if (w3 <= ' ' && i5 == 0) {
                return -1;
            }
            int decodeBase64Char = base64Variant.decodeBase64Char((int) w3);
            if (decodeBase64Char >= 0) {
                return decodeBase64Char;
            }
            throw J(base64Variant, w3, i5);
        }
        throw J(base64Variant, i4, i5);
    }

    protected char w() throws IOException, JsonParseException {
        throw new UnsupportedOperationException();
    }

    protected void x(int i4) throws IOException, JsonParseException {
        JsonToken jsonToken = this.f17696b;
        if (jsonToken == JsonToken.VALUE_NUMBER_INT) {
            char[] textBuffer = this.f17685p.getTextBuffer();
            int textOffset = this.f17685p.getTextOffset();
            int i5 = this.B;
            if (this.A) {
                textOffset++;
            }
            if (i5 <= 9) {
                int parseInt = NumberInput.parseInt(textBuffer, textOffset, i5);
                if (this.A) {
                    parseInt = -parseInt;
                }
                this.f17691v = parseInt;
                this.f17690u = 1;
            } else if (i5 <= 18) {
                long parseLong = NumberInput.parseLong(textBuffer, textOffset, i5);
                boolean z3 = this.A;
                if (z3) {
                    parseLong = -parseLong;
                }
                if (i5 == 10) {
                    if (z3) {
                        if (parseLong >= -2147483648L) {
                            this.f17691v = (int) parseLong;
                            this.f17690u = 1;
                            return;
                        }
                    } else if (parseLong <= 2147483647L) {
                        this.f17691v = (int) parseLong;
                        this.f17690u = 1;
                        return;
                    }
                }
                this.f17692w = parseLong;
                this.f17690u = 2;
            } else {
                z(i4, textBuffer, textOffset, i5);
            }
        } else if (jsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
            y(i4);
        } else {
            j("Current token (" + this.f17696b + ") not numeric, can not use numeric value accessors");
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public JsonReadContext getParsingContext() {
        return this.f17683n;
    }
}
