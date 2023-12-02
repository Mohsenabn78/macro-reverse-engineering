package com.airbnb.lottie.parser.moshi;

import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.apache.http.message.BasicHeaderValueFormatter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JsonUtf8Reader.java */
/* loaded from: classes2.dex */
public final class d extends JsonReader {

    /* renamed from: n  reason: collision with root package name */
    private static final ByteString f1832n = ByteString.encodeUtf8("'\\");

    /* renamed from: o  reason: collision with root package name */
    private static final ByteString f1833o = ByteString.encodeUtf8(BasicHeaderValueFormatter.UNSAFE_CHARS);

    /* renamed from: p  reason: collision with root package name */
    private static final ByteString f1834p = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");

    /* renamed from: q  reason: collision with root package name */
    private static final ByteString f1835q = ByteString.encodeUtf8("\n\r");

    /* renamed from: r  reason: collision with root package name */
    private static final ByteString f1836r = ByteString.encodeUtf8("*/");

    /* renamed from: h  reason: collision with root package name */
    private final BufferedSource f1837h;

    /* renamed from: i  reason: collision with root package name */
    private final Buffer f1838i;

    /* renamed from: j  reason: collision with root package name */
    private int f1839j = 0;

    /* renamed from: k  reason: collision with root package name */
    private long f1840k;

    /* renamed from: l  reason: collision with root package name */
    private int f1841l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private String f1842m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            this.f1837h = bufferedSource;
            this.f1838i = bufferedSource.buffer();
            c(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    private void f() throws IOException {
        if (this.f1827e) {
            return;
        }
        throw e("Use JsonReader.setLenient(true) to accept malformed JSON");
    }

    private int g() throws IOException {
        int[] iArr = this.f1824b;
        int i4 = this.f1823a;
        int i5 = iArr[i4 - 1];
        if (i5 == 1) {
            iArr[i4 - 1] = 2;
        } else if (i5 == 2) {
            int j4 = j(true);
            this.f1838i.readByte();
            if (j4 != 44) {
                if (j4 != 59) {
                    if (j4 == 93) {
                        this.f1839j = 4;
                        return 4;
                    }
                    throw e("Unterminated array");
                }
                f();
            }
        } else if (i5 != 3 && i5 != 5) {
            if (i5 == 4) {
                iArr[i4 - 1] = 5;
                int j5 = j(true);
                this.f1838i.readByte();
                if (j5 != 58) {
                    if (j5 == 61) {
                        f();
                        if (this.f1837h.request(1L) && this.f1838i.getByte(0L) == 62) {
                            this.f1838i.readByte();
                        }
                    } else {
                        throw e("Expected ':'");
                    }
                }
            } else if (i5 == 6) {
                iArr[i4 - 1] = 7;
            } else if (i5 == 7) {
                if (j(false) == -1) {
                    this.f1839j = 18;
                    return 18;
                }
                f();
            } else if (i5 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        } else {
            iArr[i4 - 1] = 4;
            if (i5 == 5) {
                int j6 = j(true);
                this.f1838i.readByte();
                if (j6 != 44) {
                    if (j6 != 59) {
                        if (j6 == 125) {
                            this.f1839j = 2;
                            return 2;
                        }
                        throw e("Unterminated object");
                    }
                    f();
                }
            }
            int j7 = j(true);
            if (j7 != 34) {
                if (j7 != 39) {
                    if (j7 != 125) {
                        f();
                        if (i((char) j7)) {
                            this.f1839j = 14;
                            return 14;
                        }
                        throw e("Expected name");
                    } else if (i5 != 5) {
                        this.f1838i.readByte();
                        this.f1839j = 2;
                        return 2;
                    } else {
                        throw e("Expected name");
                    }
                }
                this.f1838i.readByte();
                f();
                this.f1839j = 12;
                return 12;
            }
            this.f1838i.readByte();
            this.f1839j = 13;
            return 13;
        }
        int j8 = j(true);
        if (j8 != 34) {
            if (j8 != 39) {
                if (j8 != 44 && j8 != 59) {
                    if (j8 != 91) {
                        if (j8 != 93) {
                            if (j8 != 123) {
                                int m4 = m();
                                if (m4 != 0) {
                                    return m4;
                                }
                                int n4 = n();
                                if (n4 != 0) {
                                    return n4;
                                }
                                if (i(this.f1838i.getByte(0L))) {
                                    f();
                                    this.f1839j = 10;
                                    return 10;
                                }
                                throw e("Expected value");
                            }
                            this.f1838i.readByte();
                            this.f1839j = 1;
                            return 1;
                        } else if (i5 == 1) {
                            this.f1838i.readByte();
                            this.f1839j = 4;
                            return 4;
                        }
                    } else {
                        this.f1838i.readByte();
                        this.f1839j = 3;
                        return 3;
                    }
                }
                if (i5 != 1 && i5 != 2) {
                    throw e("Unexpected value");
                }
                f();
                this.f1839j = 7;
                return 7;
            }
            f();
            this.f1838i.readByte();
            this.f1839j = 8;
            return 8;
        }
        this.f1838i.readByte();
        this.f1839j = 9;
        return 9;
    }

    private int h(String str, JsonReader.Options options) {
        int length = options.f1829a.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (str.equals(options.f1829a[i4])) {
                this.f1839j = 0;
                this.f1825c[this.f1823a - 1] = str;
                return i4;
            }
        }
        return -1;
    }

    private boolean i(int i4) throws IOException {
        if (i4 != 9 && i4 != 10 && i4 != 12 && i4 != 13 && i4 != 32) {
            if (i4 != 35) {
                if (i4 != 44) {
                    if (i4 != 47 && i4 != 61) {
                        if (i4 != 123 && i4 != 125 && i4 != 58) {
                            if (i4 != 59) {
                                switch (i4) {
                                    case 91:
                                    case 93:
                                        return false;
                                    case 92:
                                        break;
                                    default:
                                        return true;
                                }
                            }
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
            f();
            return false;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
        r6.f1838i.skip(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        if (r1 != 47) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
        if (r6.f1837h.request(2) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
        f();
        r3 = r6.f1838i.getByte(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
        if (r3 == 42) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
        if (r3 == 47) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
        r6.f1838i.readByte();
        r6.f1838i.readByte();
        r();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        r6.f1838i.readByte();
        r6.f1838i.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
        if (q() == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
        throw e("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
        if (r1 != 35) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
        f();
        r();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int j(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            okio.BufferedSource r2 = r6.f1837h
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L82
            okio.Buffer r2 = r6.f1838i
            long r4 = (long) r1
            byte r1 = r2.getByte(r4)
            r2 = 10
            if (r1 == r2) goto L80
            r2 = 32
            if (r1 == r2) goto L80
            r2 = 13
            if (r1 == r2) goto L80
            r2 = 9
            if (r1 != r2) goto L25
            goto L80
        L25:
            okio.Buffer r2 = r6.f1838i
            int r3 = r3 + (-1)
            long r3 = (long) r3
            r2.skip(r3)
            r2 = 47
            if (r1 != r2) goto L74
            okio.BufferedSource r3 = r6.f1837h
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L3c
            return r1
        L3c:
            r6.f()
            okio.Buffer r3 = r6.f1838i
            r4 = 1
            byte r3 = r3.getByte(r4)
            r4 = 42
            if (r3 == r4) goto L5c
            if (r3 == r2) goto L4e
            return r1
        L4e:
            okio.Buffer r1 = r6.f1838i
            r1.readByte()
            okio.Buffer r1 = r6.f1838i
            r1.readByte()
            r6.r()
            goto L1
        L5c:
            okio.Buffer r1 = r6.f1838i
            r1.readByte()
            okio.Buffer r1 = r6.f1838i
            r1.readByte()
            boolean r1 = r6.q()
            if (r1 == 0) goto L6d
            goto L1
        L6d:
            java.lang.String r7 = "Unterminated comment"
            com.airbnb.lottie.parser.moshi.b r7 = r6.e(r7)
            throw r7
        L74:
            r2 = 35
            if (r1 != r2) goto L7f
            r6.f()
            r6.r()
            goto L1
        L7f:
            return r1
        L80:
            r1 = r3
            goto L2
        L82:
            if (r7 != 0) goto L86
            r7 = -1
            return r7
        L86:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.d.j(boolean):int");
    }

    private String k(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long indexOfElement = this.f1837h.indexOfElement(byteString);
            if (indexOfElement != -1) {
                if (this.f1838i.getByte(indexOfElement) == 92) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    sb.append(this.f1838i.readUtf8(indexOfElement));
                    this.f1838i.readByte();
                    sb.append(o());
                } else if (sb == null) {
                    String readUtf8 = this.f1838i.readUtf8(indexOfElement);
                    this.f1838i.readByte();
                    return readUtf8;
                } else {
                    sb.append(this.f1838i.readUtf8(indexOfElement));
                    this.f1838i.readByte();
                    return sb.toString();
                }
            } else {
                throw e("Unterminated string");
            }
        }
    }

    private String l() throws IOException {
        long indexOfElement = this.f1837h.indexOfElement(f1834p);
        if (indexOfElement != -1) {
            return this.f1838i.readUtf8(indexOfElement);
        }
        return this.f1838i.readUtf8();
    }

    private int m() throws IOException {
        String str;
        String str2;
        int i4;
        byte b4 = this.f1838i.getByte(0L);
        if (b4 != 116 && b4 != 84) {
            if (b4 != 102 && b4 != 70) {
                if (b4 != 110 && b4 != 78) {
                    return 0;
                }
                str = "null";
                str2 = "NULL";
                i4 = 7;
            } else {
                str = "false";
                str2 = "FALSE";
                i4 = 6;
            }
        } else {
            str = "true";
            str2 = "TRUE";
            i4 = 5;
        }
        int length = str.length();
        int i5 = 1;
        while (i5 < length) {
            int i6 = i5 + 1;
            if (!this.f1837h.request(i6)) {
                return 0;
            }
            byte b5 = this.f1838i.getByte(i5);
            if (b5 != str.charAt(i5) && b5 != str2.charAt(i5)) {
                return 0;
            }
            i5 = i6;
        }
        if (this.f1837h.request(length + 1) && i(this.f1838i.getByte(length))) {
            return 0;
        }
        this.f1838i.skip(length);
        this.f1839j = i4;
        return i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0081, code lost:
        if (i(r11) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0083, code lost:
        if (r6 != 2) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0085, code lost:
        if (r7 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
        if (r8 != Long.MIN_VALUE) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008d, code lost:
        if (r10 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0091, code lost:
        if (r8 != 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0093, code lost:
        if (r10 != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0095, code lost:
        if (r10 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0098, code lost:
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0099, code lost:
        r16.f1840k = r8;
        r16.f1838i.skip(r5);
        r16.f1839j = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a5, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a6, code lost:
        if (r6 == 2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a9, code lost:
        if (r6 == 4) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ac, code lost:
        if (r6 != 7) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00af, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b0, code lost:
        r16.f1841l = r5;
        r16.f1839j = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b6, code lost:
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b7, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int n() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.d.n():int");
    }

    private char o() throws IOException {
        int i4;
        int i5;
        if (this.f1837h.request(1L)) {
            byte readByte = this.f1838i.readByte();
            if (readByte != 10 && readByte != 34 && readByte != 39 && readByte != 47 && readByte != 92) {
                if (readByte != 98) {
                    if (readByte != 102) {
                        if (readByte == 110) {
                            return '\n';
                        }
                        if (readByte != 114) {
                            if (readByte != 116) {
                                if (readByte != 117) {
                                    if (this.f1827e) {
                                        return (char) readByte;
                                    }
                                    throw e("Invalid escape sequence: \\" + ((char) readByte));
                                } else if (this.f1837h.request(4L)) {
                                    char c4 = 0;
                                    for (int i6 = 0; i6 < 4; i6++) {
                                        byte b4 = this.f1838i.getByte(i6);
                                        char c5 = (char) (c4 << 4);
                                        if (b4 >= 48 && b4 <= 57) {
                                            i5 = b4 - 48;
                                        } else {
                                            if (b4 >= 97 && b4 <= 102) {
                                                i4 = b4 - 97;
                                            } else if (b4 < 65 || b4 > 70) {
                                                throw e("\\u" + this.f1838i.readUtf8(4L));
                                            } else {
                                                i4 = b4 - 65;
                                            }
                                            i5 = i4 + 10;
                                        }
                                        c4 = (char) (c5 + i5);
                                    }
                                    this.f1838i.skip(4L);
                                    return c4;
                                } else {
                                    throw new EOFException("Unterminated escape sequence at path " + getPath());
                                }
                            }
                            return '\t';
                        }
                        return '\r';
                    }
                    return '\f';
                }
                return '\b';
            }
            return (char) readByte;
        }
        throw e("Unterminated escape sequence");
    }

    private void p(ByteString byteString) throws IOException {
        while (true) {
            long indexOfElement = this.f1837h.indexOfElement(byteString);
            if (indexOfElement != -1) {
                if (this.f1838i.getByte(indexOfElement) == 92) {
                    this.f1838i.skip(indexOfElement + 1);
                    o();
                } else {
                    this.f1838i.skip(indexOfElement + 1);
                    return;
                }
            } else {
                throw e("Unterminated string");
            }
        }
    }

    private boolean q() throws IOException {
        boolean z3;
        long size;
        BufferedSource bufferedSource = this.f1837h;
        ByteString byteString = f1836r;
        long indexOf = bufferedSource.indexOf(byteString);
        if (indexOf != -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Buffer buffer = this.f1838i;
        if (z3) {
            size = indexOf + byteString.size();
        } else {
            size = buffer.size();
        }
        buffer.skip(size);
        return z3;
    }

    private void r() throws IOException {
        long size;
        long indexOfElement = this.f1837h.indexOfElement(f1835q);
        Buffer buffer = this.f1838i;
        if (indexOfElement != -1) {
            size = indexOfElement + 1;
        } else {
            size = buffer.size();
        }
        buffer.skip(size);
    }

    private void s() throws IOException {
        long indexOfElement = this.f1837h.indexOfElement(f1834p);
        Buffer buffer = this.f1838i;
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        buffer.skip(indexOfElement);
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void beginArray() throws IOException {
        int i4 = this.f1839j;
        if (i4 == 0) {
            i4 = g();
        }
        if (i4 == 3) {
            c(1);
            this.f1826d[this.f1823a - 1] = 0;
            this.f1839j = 0;
            return;
        }
        throw new a("Expected BEGIN_ARRAY but was " + peek() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void beginObject() throws IOException {
        int i4 = this.f1839j;
        if (i4 == 0) {
            i4 = g();
        }
        if (i4 == 1) {
            c(3);
            this.f1839j = 0;
            return;
        }
        throw new a("Expected BEGIN_OBJECT but was " + peek() + " at path " + getPath());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1839j = 0;
        this.f1824b[0] = 8;
        this.f1823a = 1;
        this.f1838i.clear();
        this.f1837h.close();
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void endArray() throws IOException {
        int i4 = this.f1839j;
        if (i4 == 0) {
            i4 = g();
        }
        if (i4 == 4) {
            int i5 = this.f1823a - 1;
            this.f1823a = i5;
            int[] iArr = this.f1826d;
            int i6 = i5 - 1;
            iArr[i6] = iArr[i6] + 1;
            this.f1839j = 0;
            return;
        }
        throw new a("Expected END_ARRAY but was " + peek() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void endObject() throws IOException {
        int i4 = this.f1839j;
        if (i4 == 0) {
            i4 = g();
        }
        if (i4 == 2) {
            int i5 = this.f1823a - 1;
            this.f1823a = i5;
            this.f1825c[i5] = null;
            int[] iArr = this.f1826d;
            int i6 = i5 - 1;
            iArr[i6] = iArr[i6] + 1;
            this.f1839j = 0;
            return;
        }
        throw new a("Expected END_OBJECT but was " + peek() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean hasNext() throws IOException {
        int i4 = this.f1839j;
        if (i4 == 0) {
            i4 = g();
        }
        if (i4 != 2 && i4 != 4 && i4 != 18) {
            return true;
        }
        return false;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean nextBoolean() throws IOException {
        int i4 = this.f1839j;
        if (i4 == 0) {
            i4 = g();
        }
        if (i4 == 5) {
            this.f1839j = 0;
            int[] iArr = this.f1826d;
            int i5 = this.f1823a - 1;
            iArr[i5] = iArr[i5] + 1;
            return true;
        } else if (i4 == 6) {
            this.f1839j = 0;
            int[] iArr2 = this.f1826d;
            int i6 = this.f1823a - 1;
            iArr2[i6] = iArr2[i6] + 1;
            return false;
        } else {
            throw new a("Expected a boolean but was " + peek() + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public double nextDouble() throws IOException {
        int i4 = this.f1839j;
        if (i4 == 0) {
            i4 = g();
        }
        if (i4 == 16) {
            this.f1839j = 0;
            int[] iArr = this.f1826d;
            int i5 = this.f1823a - 1;
            iArr[i5] = iArr[i5] + 1;
            return this.f1840k;
        }
        if (i4 == 17) {
            this.f1842m = this.f1838i.readUtf8(this.f1841l);
        } else if (i4 == 9) {
            this.f1842m = k(f1833o);
        } else if (i4 == 8) {
            this.f1842m = k(f1832n);
        } else if (i4 == 10) {
            this.f1842m = l();
        } else if (i4 != 11) {
            throw new a("Expected a double but was " + peek() + " at path " + getPath());
        }
        this.f1839j = 11;
        try {
            double parseDouble = Double.parseDouble(this.f1842m);
            if (!this.f1827e && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                throw new b("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
            }
            this.f1842m = null;
            this.f1839j = 0;
            int[] iArr2 = this.f1826d;
            int i6 = this.f1823a - 1;
            iArr2[i6] = iArr2[i6] + 1;
            return parseDouble;
        } catch (NumberFormatException unused) {
            throw new a("Expected a double but was " + this.f1842m + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int nextInt() throws IOException {
        String k4;
        int i4 = this.f1839j;
        if (i4 == 0) {
            i4 = g();
        }
        if (i4 == 16) {
            long j4 = this.f1840k;
            int i5 = (int) j4;
            if (j4 == i5) {
                this.f1839j = 0;
                int[] iArr = this.f1826d;
                int i6 = this.f1823a - 1;
                iArr[i6] = iArr[i6] + 1;
                return i5;
            }
            throw new a("Expected an int but was " + this.f1840k + " at path " + getPath());
        }
        if (i4 == 17) {
            this.f1842m = this.f1838i.readUtf8(this.f1841l);
        } else if (i4 != 9 && i4 != 8) {
            if (i4 != 11) {
                throw new a("Expected an int but was " + peek() + " at path " + getPath());
            }
        } else {
            if (i4 == 9) {
                k4 = k(f1833o);
            } else {
                k4 = k(f1832n);
            }
            this.f1842m = k4;
            try {
                int parseInt = Integer.parseInt(k4);
                this.f1839j = 0;
                int[] iArr2 = this.f1826d;
                int i7 = this.f1823a - 1;
                iArr2[i7] = iArr2[i7] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f1839j = 11;
        try {
            double parseDouble = Double.parseDouble(this.f1842m);
            int i8 = (int) parseDouble;
            if (i8 == parseDouble) {
                this.f1842m = null;
                this.f1839j = 0;
                int[] iArr3 = this.f1826d;
                int i9 = this.f1823a - 1;
                iArr3[i9] = iArr3[i9] + 1;
                return i8;
            }
            throw new a("Expected an int but was " + this.f1842m + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new a("Expected an int but was " + this.f1842m + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String nextName() throws IOException {
        String str;
        int i4 = this.f1839j;
        if (i4 == 0) {
            i4 = g();
        }
        if (i4 == 14) {
            str = l();
        } else if (i4 == 13) {
            str = k(f1833o);
        } else if (i4 == 12) {
            str = k(f1832n);
        } else if (i4 == 15) {
            str = this.f1842m;
        } else {
            throw new a("Expected a name but was " + peek() + " at path " + getPath());
        }
        this.f1839j = 0;
        this.f1825c[this.f1823a - 1] = str;
        return str;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String nextString() throws IOException {
        String readUtf8;
        int i4 = this.f1839j;
        if (i4 == 0) {
            i4 = g();
        }
        if (i4 == 10) {
            readUtf8 = l();
        } else if (i4 == 9) {
            readUtf8 = k(f1833o);
        } else if (i4 == 8) {
            readUtf8 = k(f1832n);
        } else if (i4 == 11) {
            readUtf8 = this.f1842m;
            this.f1842m = null;
        } else if (i4 == 16) {
            readUtf8 = Long.toString(this.f1840k);
        } else if (i4 == 17) {
            readUtf8 = this.f1838i.readUtf8(this.f1841l);
        } else {
            throw new a("Expected a string but was " + peek() + " at path " + getPath());
        }
        this.f1839j = 0;
        int[] iArr = this.f1826d;
        int i5 = this.f1823a - 1;
        iArr[i5] = iArr[i5] + 1;
        return readUtf8;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public JsonReader.Token peek() throws IOException {
        int i4 = this.f1839j;
        if (i4 == 0) {
            i4 = g();
        }
        switch (i4) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int selectName(JsonReader.Options options) throws IOException {
        int i4 = this.f1839j;
        if (i4 == 0) {
            i4 = g();
        }
        if (i4 < 12 || i4 > 15) {
            return -1;
        }
        if (i4 == 15) {
            return h(this.f1842m, options);
        }
        int select = this.f1837h.select(options.f1830b);
        if (select != -1) {
            this.f1839j = 0;
            this.f1825c[this.f1823a - 1] = options.f1829a[select];
            return select;
        }
        String str = this.f1825c[this.f1823a - 1];
        String nextName = nextName();
        int h4 = h(nextName, options);
        if (h4 == -1) {
            this.f1839j = 15;
            this.f1842m = nextName;
            this.f1825c[this.f1823a - 1] = str;
        }
        return h4;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void skipName() throws IOException {
        if (!this.f1828f) {
            int i4 = this.f1839j;
            if (i4 == 0) {
                i4 = g();
            }
            if (i4 == 14) {
                s();
            } else if (i4 == 13) {
                p(f1833o);
            } else if (i4 == 12) {
                p(f1832n);
            } else if (i4 != 15) {
                throw new a("Expected a name but was " + peek() + " at path " + getPath());
            }
            this.f1839j = 0;
            this.f1825c[this.f1823a - 1] = "null";
            return;
        }
        throw new a("Cannot skip unexpected " + peek() + " at " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void skipValue() throws IOException {
        if (!this.f1828f) {
            int i4 = 0;
            do {
                int i5 = this.f1839j;
                if (i5 == 0) {
                    i5 = g();
                }
                if (i5 == 3) {
                    c(1);
                } else if (i5 == 1) {
                    c(3);
                } else {
                    if (i5 == 4) {
                        i4--;
                        if (i4 >= 0) {
                            this.f1823a--;
                        } else {
                            throw new a("Expected a value but was " + peek() + " at path " + getPath());
                        }
                    } else if (i5 == 2) {
                        i4--;
                        if (i4 >= 0) {
                            this.f1823a--;
                        } else {
                            throw new a("Expected a value but was " + peek() + " at path " + getPath());
                        }
                    } else if (i5 != 14 && i5 != 10) {
                        if (i5 != 9 && i5 != 13) {
                            if (i5 != 8 && i5 != 12) {
                                if (i5 == 17) {
                                    this.f1838i.skip(this.f1841l);
                                } else if (i5 == 18) {
                                    throw new a("Expected a value but was " + peek() + " at path " + getPath());
                                }
                            } else {
                                p(f1832n);
                            }
                        } else {
                            p(f1833o);
                        }
                    } else {
                        s();
                    }
                    this.f1839j = 0;
                }
                i4++;
                this.f1839j = 0;
            } while (i4 != 0);
            int[] iArr = this.f1826d;
            int i6 = this.f1823a;
            int i7 = i6 - 1;
            iArr[i7] = iArr[i7] + 1;
            this.f1825c[i6 - 1] = "null";
            return;
        }
        throw new a("Cannot skip unexpected " + peek() + " at " + getPath());
    }

    public String toString() {
        return "JsonReader(" + this.f1837h + ")";
    }
}
