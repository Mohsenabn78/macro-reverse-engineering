package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.MergedStream;
import com.fasterxml.jackson.core.io.UTF32Reader;
import com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* loaded from: classes3.dex */
public final class ByteSourceJsonBootstrapper {

    /* renamed from: a  reason: collision with root package name */
    protected final IOContext f17778a;

    /* renamed from: b  reason: collision with root package name */
    protected final InputStream f17779b;

    /* renamed from: c  reason: collision with root package name */
    protected final byte[] f17780c;

    /* renamed from: d  reason: collision with root package name */
    private int f17781d;

    /* renamed from: e  reason: collision with root package name */
    private int f17782e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f17783f;

    /* renamed from: g  reason: collision with root package name */
    protected int f17784g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f17785h;

    /* renamed from: i  reason: collision with root package name */
    protected int f17786i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17787a;

        static {
            int[] iArr = new int[JsonEncoding.values().length];
            f17787a = iArr;
            try {
                iArr[JsonEncoding.UTF32_BE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17787a[JsonEncoding.UTF32_LE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17787a[JsonEncoding.UTF16_BE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17787a[JsonEncoding.UTF16_LE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17787a[JsonEncoding.UTF8.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public ByteSourceJsonBootstrapper(IOContext iOContext, InputStream inputStream) {
        this.f17785h = true;
        this.f17786i = 0;
        this.f17778a = iOContext;
        this.f17779b = inputStream;
        this.f17780c = iOContext.allocReadIOBuffer();
        this.f17781d = 0;
        this.f17782e = 0;
        this.f17784g = 0;
        this.f17783f = true;
    }

    private boolean a(int i4) {
        if ((65280 & i4) == 0) {
            this.f17785h = true;
        } else if ((i4 & 255) != 0) {
            return false;
        } else {
            this.f17785h = false;
        }
        this.f17786i = 2;
        return true;
    }

    private boolean b(int i4) throws IOException {
        if ((i4 >> 8) == 0) {
            this.f17785h = true;
        } else if ((16777215 & i4) == 0) {
            this.f17785h = false;
        } else if (((-16711681) & i4) == 0) {
            e("3412");
        } else if ((i4 & (-65281)) != 0) {
            return false;
        } else {
            e("2143");
        }
        this.f17786i = 4;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean d(int r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = -16842752(0xfffffffffeff0000, float:-1.6947657E38)
            r1 = 65534(0xfffe, float:9.1833E-41)
            r2 = 65279(0xfeff, float:9.1475E-41)
            r3 = 0
            r4 = 1
            if (r7 == r0) goto L30
            r0 = -131072(0xfffffffffffe0000, float:NaN)
            r5 = 4
            if (r7 == r0) goto L26
            if (r7 == r2) goto L1c
            if (r7 == r1) goto L16
            goto L35
        L16:
            java.lang.String r0 = "2143"
            r6.e(r0)
            goto L30
        L1c:
            r6.f17785h = r4
            int r7 = r6.f17781d
            int r7 = r7 + r5
            r6.f17781d = r7
            r6.f17786i = r5
            return r4
        L26:
            int r7 = r6.f17781d
            int r7 = r7 + r5
            r6.f17781d = r7
            r6.f17786i = r5
            r6.f17785h = r3
            return r4
        L30:
            java.lang.String r0 = "3412"
            r6.e(r0)
        L35:
            int r0 = r7 >>> 16
            r5 = 2
            if (r0 != r2) goto L44
            int r7 = r6.f17781d
            int r7 = r7 + r5
            r6.f17781d = r7
            r6.f17786i = r5
            r6.f17785h = r4
            return r4
        L44:
            if (r0 != r1) goto L50
            int r7 = r6.f17781d
            int r7 = r7 + r5
            r6.f17781d = r7
            r6.f17786i = r5
            r6.f17785h = r3
            return r4
        L50:
            int r7 = r7 >>> 8
            r0 = 15711167(0xefbbbf, float:2.2016034E-38)
            if (r7 != r0) goto L62
            int r7 = r6.f17781d
            int r7 = r7 + 3
            r6.f17781d = r7
            r6.f17786i = r4
            r6.f17785h = r4
            return r4
        L62:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper.d(int):boolean");
    }

    private void e(String str) throws IOException {
        throw new CharConversionException("Unsupported UCS-4 endianness (" + str + ") detected");
    }

    private static int f(InputAccessor inputAccessor) throws IOException {
        if (!inputAccessor.hasMoreBytes()) {
            return -1;
        }
        return g(inputAccessor, inputAccessor.nextByte());
    }

    private static int g(InputAccessor inputAccessor, byte b4) throws IOException {
        while (true) {
            int i4 = b4 & 255;
            if (i4 != 32 && i4 != 13 && i4 != 10 && i4 != 9) {
                return i4;
            }
            if (!inputAccessor.hasMoreBytes()) {
                return -1;
            }
            b4 = inputAccessor.nextByte();
        }
    }

    private static MatchStrength h(InputAccessor inputAccessor, String str, MatchStrength matchStrength) throws IOException {
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            if (!inputAccessor.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (inputAccessor.nextByte() != str.charAt(i4)) {
                return MatchStrength.NO_MATCH;
            }
        }
        return matchStrength;
    }

    public static MatchStrength hasJSONFormat(InputAccessor inputAccessor) throws IOException {
        if (!inputAccessor.hasMoreBytes()) {
            return MatchStrength.INCONCLUSIVE;
        }
        byte nextByte = inputAccessor.nextByte();
        if (nextByte == -17) {
            if (!inputAccessor.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (inputAccessor.nextByte() != -69) {
                return MatchStrength.NO_MATCH;
            }
            if (!inputAccessor.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (inputAccessor.nextByte() != -65) {
                return MatchStrength.NO_MATCH;
            }
            if (!inputAccessor.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            nextByte = inputAccessor.nextByte();
        }
        int g4 = g(inputAccessor, nextByte);
        if (g4 < 0) {
            return MatchStrength.INCONCLUSIVE;
        }
        if (g4 == 123) {
            int f4 = f(inputAccessor);
            if (f4 < 0) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (f4 != 34 && f4 != 125) {
                return MatchStrength.NO_MATCH;
            }
            return MatchStrength.SOLID_MATCH;
        } else if (g4 == 91) {
            int f5 = f(inputAccessor);
            if (f5 < 0) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (f5 != 93 && f5 != 91) {
                return MatchStrength.SOLID_MATCH;
            }
            return MatchStrength.SOLID_MATCH;
        } else {
            MatchStrength matchStrength = MatchStrength.WEAK_MATCH;
            if (g4 == 34) {
                return matchStrength;
            }
            if (g4 <= 57 && g4 >= 48) {
                return matchStrength;
            }
            if (g4 == 45) {
                int f6 = f(inputAccessor);
                if (f6 < 0) {
                    return MatchStrength.INCONCLUSIVE;
                }
                if (f6 > 57 || f6 < 48) {
                    return MatchStrength.NO_MATCH;
                }
                return matchStrength;
            } else if (g4 == 110) {
                return h(inputAccessor, "ull", matchStrength);
            } else {
                if (g4 == 116) {
                    return h(inputAccessor, "rue", matchStrength);
                }
                if (g4 == 102) {
                    return h(inputAccessor, "alse", matchStrength);
                }
                return MatchStrength.NO_MATCH;
            }
        }
    }

    protected boolean c(int i4) throws IOException {
        int read;
        int i5 = this.f17782e - this.f17781d;
        while (i5 < i4) {
            InputStream inputStream = this.f17779b;
            if (inputStream == null) {
                read = -1;
            } else {
                byte[] bArr = this.f17780c;
                int i6 = this.f17782e;
                read = inputStream.read(bArr, i6, bArr.length - i6);
            }
            if (read < 1) {
                return false;
            }
            this.f17782e += read;
            i5 += read;
        }
        return true;
    }

    public JsonParser constructParser(int i4, ObjectCodec objectCodec, BytesToNameCanonicalizer bytesToNameCanonicalizer, CharsToNameCanonicalizer charsToNameCanonicalizer, boolean z3, boolean z4) throws IOException, JsonParseException {
        if (detectEncoding() == JsonEncoding.UTF8 && z3) {
            return new UTF8StreamJsonParser(this.f17778a, i4, this.f17779b, objectCodec, bytesToNameCanonicalizer.makeChild(z3, z4), this.f17780c, this.f17781d, this.f17782e, this.f17783f);
        }
        return new ReaderBasedJsonParser(this.f17778a, i4, constructReader(), objectCodec, charsToNameCanonicalizer.makeChild(z3, z4));
    }

    public Reader constructReader() throws IOException {
        JsonEncoding encoding = this.f17778a.getEncoding();
        int i4 = a.f17787a[encoding.ordinal()];
        if (i4 != 1 && i4 != 2) {
            if (i4 != 3 && i4 != 4 && i4 != 5) {
                throw new RuntimeException("Internal error");
            }
            InputStream inputStream = this.f17779b;
            if (inputStream == null) {
                inputStream = new ByteArrayInputStream(this.f17780c, this.f17781d, this.f17782e);
            } else if (this.f17781d < this.f17782e) {
                inputStream = new MergedStream(this.f17778a, inputStream, this.f17780c, this.f17781d, this.f17782e);
            }
            return new InputStreamReader(inputStream, encoding.getJavaName());
        }
        IOContext iOContext = this.f17778a;
        return new UTF32Reader(iOContext, this.f17779b, this.f17780c, this.f17781d, this.f17782e, iOContext.getEncoding().isBigEndian());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003f, code lost:
        if (a(r1 >>> 16) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005c, code lost:
        if (a((r1[r5 + 1] & 255) | ((r1[r5] & 255) << 8)) != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.fasterxml.jackson.core.JsonEncoding detectEncoding() throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r8 = this;
            r0 = 4
            boolean r1 = r8.c(r0)
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L42
            byte[] r1 = r8.f17780c
            int r5 = r8.f17781d
            r6 = r1[r5]
            int r6 = r6 << 24
            int r7 = r5 + 1
            r7 = r1[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 << 16
            r6 = r6 | r7
            int r7 = r5 + 2
            r7 = r1[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 << 8
            r6 = r6 | r7
            int r5 = r5 + 3
            r1 = r1[r5]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r1 | r6
            boolean r5 = r8.d(r1)
            if (r5 == 0) goto L32
            goto L5e
        L32:
            boolean r5 = r8.b(r1)
            if (r5 == 0) goto L39
            goto L5e
        L39:
            int r1 = r1 >>> 16
            boolean r1 = r8.a(r1)
            if (r1 == 0) goto L5f
            goto L5e
        L42:
            boolean r1 = r8.c(r2)
            if (r1 == 0) goto L5f
            byte[] r1 = r8.f17780c
            int r5 = r8.f17781d
            r6 = r1[r5]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << 8
            int r5 = r5 + r3
            r1 = r1[r5]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r1 | r6
            boolean r1 = r8.a(r1)
            if (r1 == 0) goto L5f
        L5e:
            r4 = 1
        L5f:
            if (r4 != 0) goto L64
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF8
            goto L8a
        L64:
            int r1 = r8.f17786i
            if (r1 == r3) goto L88
            if (r1 == r2) goto L7e
            if (r1 != r0) goto L76
            boolean r0 = r8.f17785h
            if (r0 == 0) goto L73
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF32_BE
            goto L8a
        L73:
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF32_LE
            goto L8a
        L76:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Internal error"
            r0.<init>(r1)
            throw r0
        L7e:
            boolean r0 = r8.f17785h
            if (r0 == 0) goto L85
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF16_BE
            goto L8a
        L85:
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF16_LE
            goto L8a
        L88:
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF8
        L8a:
            com.fasterxml.jackson.core.io.IOContext r1 = r8.f17778a
            r1.setEncoding(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper.detectEncoding():com.fasterxml.jackson.core.JsonEncoding");
    }

    public ByteSourceJsonBootstrapper(IOContext iOContext, byte[] bArr, int i4, int i5) {
        this.f17785h = true;
        this.f17786i = 0;
        this.f17778a = iOContext;
        this.f17779b = null;
        this.f17780c = bArr;
        this.f17781d = i4;
        this.f17782e = i5 + i4;
        this.f17784g = -i4;
        this.f17783f = false;
    }
}
