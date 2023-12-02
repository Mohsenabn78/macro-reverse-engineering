package com.airbnb.lottie.parser.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* loaded from: classes2.dex */
public abstract class JsonReader implements Closeable {

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f1822g = new String[128];

    /* renamed from: a  reason: collision with root package name */
    int f1823a;

    /* renamed from: b  reason: collision with root package name */
    int[] f1824b = new int[32];

    /* renamed from: c  reason: collision with root package name */
    String[] f1825c = new String[32];

    /* renamed from: d  reason: collision with root package name */
    int[] f1826d = new int[32];

    /* renamed from: e  reason: collision with root package name */
    boolean f1827e;

    /* renamed from: f  reason: collision with root package name */
    boolean f1828f;

    /* loaded from: classes2.dex */
    public static final class Options {

        /* renamed from: a  reason: collision with root package name */
        final String[] f1829a;

        /* renamed from: b  reason: collision with root package name */
        final okio.Options f1830b;

        private Options(String[] strArr, okio.Options options) {
            this.f1829a = strArr;
            this.f1830b = options;
        }

        public static Options of(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i4 = 0; i4 < strArr.length; i4++) {
                    JsonReader.d(buffer, strArr[i4]);
                    buffer.readByte();
                    byteStringArr[i4] = buffer.readByteString();
                }
                return new Options((String[]) strArr.clone(), okio.Options.of(byteStringArr));
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static {
        for (int i4 = 0; i4 <= 31; i4++) {
            f1822g[i4] = String.format("\\u%04x", Integer.valueOf(i4));
        }
        String[] strArr = f1822g;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void d(okio.BufferedSink r7, java.lang.String r8) throws java.io.IOException {
        /*
            java.lang.String[] r0 = com.airbnb.lottie.parser.moshi.JsonReader.f1822g
            r1 = 34
            r7.writeByte(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = 0
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.writeUtf8(r8, r4, r3)
        L2e:
            r7.writeUtf8(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.writeUtf8(r8, r4, r2)
        L3b:
            r7.writeByte(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonReader.d(okio.BufferedSink, java.lang.String):void");
    }

    public static JsonReader of(BufferedSource bufferedSource) {
        return new d(bufferedSource);
    }

    public abstract void beginArray() throws IOException;

    public abstract void beginObject() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(int i4) {
        int i5 = this.f1823a;
        int[] iArr = this.f1824b;
        if (i5 == iArr.length) {
            if (i5 != 256) {
                this.f1824b = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f1825c;
                this.f1825c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f1826d;
                this.f1826d = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new a("Nesting too deep at " + getPath());
            }
        }
        int[] iArr3 = this.f1824b;
        int i6 = this.f1823a;
        this.f1823a = i6 + 1;
        iArr3[i6] = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final b e(String str) throws b {
        throw new b(str + " at path " + getPath());
    }

    public abstract void endArray() throws IOException;

    public abstract void endObject() throws IOException;

    public final String getPath() {
        return c.a(this.f1823a, this.f1824b, this.f1825c, this.f1826d);
    }

    public abstract boolean hasNext() throws IOException;

    public abstract boolean nextBoolean() throws IOException;

    public abstract double nextDouble() throws IOException;

    public abstract int nextInt() throws IOException;

    public abstract String nextName() throws IOException;

    public abstract String nextString() throws IOException;

    public abstract Token peek() throws IOException;

    public abstract int selectName(Options options) throws IOException;

    public abstract void skipName() throws IOException;

    public abstract void skipValue() throws IOException;
}
