package com.koushikdutta.async.http.spdy;

import com.koushikdutta.async.BufferedDataSink;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataEmitterReader;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.http.spdy.FrameReader;
import com.koushikdutta.async.http.spdy.f;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Http20Draft13.java */
/* loaded from: classes6.dex */
public final class g implements n {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f35558a = Logger.getLogger(g.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final com.koushikdutta.async.http.spdy.a f35559b = com.koushikdutta.async.http.spdy.a.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Http20Draft13.java */
    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final String[] f35560a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f35561b = new String[64];

        /* renamed from: c  reason: collision with root package name */
        private static final String[] f35562c = new String[256];

        static {
            String[] strArr;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                String[] strArr2 = f35562c;
                if (i5 >= strArr2.length) {
                    break;
                }
                strArr2[i5] = String.format(Locale.ENGLISH, "%8s", Integer.toBinaryString(i5)).replace(' ', '0');
                i5++;
            }
            String[] strArr3 = f35561b;
            strArr3[0] = "";
            strArr3[1] = "END_STREAM";
            strArr3[2] = "END_SEGMENT";
            strArr3[3] = "END_STREAM|END_SEGMENT";
            int[] iArr = {1, 2, 3};
            strArr3[8] = "PADDED";
            for (int i6 = 0; i6 < 3; i6++) {
                int i7 = iArr[i6];
                f35561b[i7 | 8] = strArr[i7] + "|PADDED";
            }
            String[] strArr4 = f35561b;
            strArr4[4] = "END_HEADERS";
            strArr4[32] = "PRIORITY";
            strArr4[36] = "END_HEADERS|PRIORITY";
            int[] iArr2 = {4, 32, 36};
            for (int i8 = 0; i8 < 3; i8++) {
                int i9 = iArr2[i8];
                for (int i10 = 0; i10 < 3; i10++) {
                    int i11 = iArr[i10];
                    String[] strArr5 = f35561b;
                    int i12 = i11 | i9;
                    strArr5[i12] = strArr5[i11] + '|' + strArr5[i9];
                    strArr5[i12 | 8] = strArr5[i11] + '|' + strArr5[i9] + "|PADDED";
                }
            }
            while (true) {
                String[] strArr6 = f35561b;
                if (i4 < strArr6.length) {
                    if (strArr6[i4] == null) {
                        strArr6[i4] = f35562c[i4];
                    }
                    i4++;
                } else {
                    return;
                }
            }
        }

        static String a(byte b4, byte b5) {
            String str;
            if (b5 == 0) {
                return "";
            }
            if (b4 != 2 && b4 != 3) {
                if (b4 != 4 && b4 != 6) {
                    if (b4 != 7 && b4 != 8) {
                        String[] strArr = f35561b;
                        if (b5 < strArr.length) {
                            str = strArr[b5];
                        } else {
                            str = f35562c[b5];
                        }
                        if (b4 == 5 && (b5 & 4) != 0) {
                            return str.replace("HEADERS", "PUSH_PROMISE");
                        }
                        if (b4 == 0 && (b5 & 32) != 0) {
                            return str.replace("PRIORITY", "COMPRESSED");
                        }
                        return str;
                    }
                } else if (b5 == 1) {
                    return "ACK";
                } else {
                    return f35562c[b5];
                }
            }
            return f35562c[b5];
        }

        static String b(boolean z3, int i4, int i5, byte b4, byte b5) {
            String format;
            String str;
            String[] strArr = f35560a;
            if (b4 < strArr.length) {
                format = strArr[b4];
            } else {
                format = String.format(Locale.ENGLISH, "0x%02x", Byte.valueOf(b4));
            }
            String a4 = a(b4, b5);
            Locale locale = Locale.ENGLISH;
            Object[] objArr = new Object[5];
            if (z3) {
                str = "<<";
            } else {
                str = ">>";
            }
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i4);
            objArr[2] = Integer.valueOf(i5);
            objArr[3] = format;
            objArr[4] = a4;
            return String.format(locale, "%s 0x%08x %5d %-13s %s", objArr);
        }
    }

    /* compiled from: Http20Draft13.java */
    /* loaded from: classes6.dex */
    static final class b implements FrameReader {

        /* renamed from: a  reason: collision with root package name */
        private final DataEmitter f35563a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f35564b;

        /* renamed from: c  reason: collision with root package name */
        private final FrameReader.Handler f35565c;

        /* renamed from: e  reason: collision with root package name */
        final f.a f35567e;

        /* renamed from: f  reason: collision with root package name */
        int f35568f;

        /* renamed from: g  reason: collision with root package name */
        int f35569g;

        /* renamed from: h  reason: collision with root package name */
        byte f35570h;

        /* renamed from: i  reason: collision with root package name */
        byte f35571i;

        /* renamed from: j  reason: collision with root package name */
        short f35572j;

        /* renamed from: k  reason: collision with root package name */
        int f35573k;

        /* renamed from: n  reason: collision with root package name */
        byte f35576n;

        /* renamed from: o  reason: collision with root package name */
        int f35577o;

        /* renamed from: p  reason: collision with root package name */
        int f35578p;

        /* renamed from: l  reason: collision with root package name */
        private final DataCallback f35574l = new a();

        /* renamed from: m  reason: collision with root package name */
        private final DataCallback f35575m = new C0199b();

        /* renamed from: d  reason: collision with root package name */
        private final DataEmitterReader f35566d = new DataEmitterReader();

        /* compiled from: Http20Draft13.java */
        /* loaded from: classes6.dex */
        class a implements DataCallback {
            a() {
            }

            @Override // com.koushikdutta.async.callback.DataCallback
            public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                byteBufferList.order(ByteOrder.BIG_ENDIAN);
                b.this.f35568f = byteBufferList.getInt();
                b.this.f35569g = byteBufferList.getInt();
                b bVar = b.this;
                int i4 = bVar.f35568f;
                bVar.f35572j = (short) ((1073676288 & i4) >> 16);
                bVar.f35571i = (byte) ((65280 & i4) >> 8);
                bVar.f35570h = (byte) (i4 & 255);
                bVar.f35573k = bVar.f35569g & Integer.MAX_VALUE;
                if (g.f35558a.isLoggable(Level.FINE)) {
                    Logger logger = g.f35558a;
                    b bVar2 = b.this;
                    logger.fine(a.b(true, bVar2.f35573k, bVar2.f35572j, bVar2.f35571i, bVar2.f35570h));
                }
                DataEmitterReader dataEmitterReader = b.this.f35566d;
                b bVar3 = b.this;
                dataEmitterReader.read(bVar3.f35572j, bVar3.f35575m);
            }
        }

        /* compiled from: Http20Draft13.java */
        /* renamed from: com.koushikdutta.async.http.spdy.g$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class C0199b implements DataCallback {
            C0199b() {
            }

            @Override // com.koushikdutta.async.callback.DataCallback
            public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                try {
                    b bVar = b.this;
                    switch (bVar.f35571i) {
                        case 0:
                            bVar.q(byteBufferList, bVar.f35572j, bVar.f35570h, bVar.f35573k);
                            break;
                        case 1:
                            bVar.t(byteBufferList, bVar.f35572j, bVar.f35570h, bVar.f35573k);
                            break;
                        case 2:
                            bVar.w(byteBufferList, bVar.f35572j, bVar.f35570h, bVar.f35573k);
                            break;
                        case 3:
                            bVar.y(byteBufferList, bVar.f35572j, bVar.f35570h, bVar.f35573k);
                            break;
                        case 4:
                            bVar.z(byteBufferList, bVar.f35572j, bVar.f35570h, bVar.f35573k);
                            break;
                        case 5:
                            bVar.x(byteBufferList, bVar.f35572j, bVar.f35570h, bVar.f35573k);
                            break;
                        case 6:
                            bVar.u(byteBufferList, bVar.f35572j, bVar.f35570h, bVar.f35573k);
                            break;
                        case 7:
                            bVar.r(byteBufferList, bVar.f35572j, bVar.f35570h, bVar.f35573k);
                            break;
                        case 8:
                            bVar.A(byteBufferList, bVar.f35572j, bVar.f35570h, bVar.f35573k);
                            break;
                        case 9:
                            bVar.p(byteBufferList, bVar.f35572j, bVar.f35570h, bVar.f35573k);
                            break;
                        default:
                            byteBufferList.recycle();
                            break;
                    }
                    b.this.o();
                } catch (IOException e4) {
                    b.this.f35565c.error(e4);
                }
            }
        }

        b(DataEmitter dataEmitter, FrameReader.Handler handler, int i4, boolean z3) {
            this.f35563a = dataEmitter;
            this.f35564b = z3;
            this.f35567e = new f.a(i4);
            this.f35565c = handler;
            o();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void A(ByteBufferList byteBufferList, short s3, byte b4, int i4) throws IOException {
            if (s3 == 4) {
                long j4 = byteBufferList.getInt() & 2147483647L;
                if (j4 != 0) {
                    this.f35565c.windowUpdate(i4, j4);
                    return;
                }
                throw g.i("windowSizeIncrement was 0", Long.valueOf(j4));
            }
            throw g.i("TYPE_WINDOW_UPDATE length !=4: %s", Short.valueOf(s3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o() {
            this.f35563a.setDataCallback(this.f35566d);
            this.f35566d.read(8, this.f35574l);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(ByteBufferList byteBufferList, short s3, byte b4, int i4) throws IOException {
            if (i4 == this.f35577o) {
                s(byteBufferList, s3, (short) 0, b4, i4);
                return;
            }
            throw new IOException("continuation stream id mismatch");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q(ByteBufferList byteBufferList, short s3, byte b4, int i4) throws IOException {
            boolean z3;
            short s4 = 0;
            boolean z4 = true;
            if ((b4 & 1) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if ((b4 & 32) == 0) {
                z4 = false;
            }
            if (!z4) {
                if ((b4 & 8) != 0) {
                    s4 = (short) (byteBufferList.get() & 255);
                }
                g.j(s3, b4, s4);
                this.f35565c.data(z3, i4, byteBufferList);
                byteBufferList.skip(s4);
                return;
            }
            throw g.i("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(ByteBufferList byteBufferList, short s3, byte b4, int i4) throws IOException {
            if (s3 >= 8) {
                if (i4 == 0) {
                    int i5 = byteBufferList.getInt();
                    int i6 = byteBufferList.getInt();
                    int i7 = s3 - 8;
                    com.koushikdutta.async.http.spdy.b a4 = com.koushikdutta.async.http.spdy.b.a(i6);
                    if (a4 != null) {
                        com.koushikdutta.async.http.spdy.a aVar = com.koushikdutta.async.http.spdy.a.f35513d;
                        if (i7 > 0) {
                            aVar = com.koushikdutta.async.http.spdy.a.e(byteBufferList.getBytes(i7));
                        }
                        this.f35565c.goAway(i5, a4, aVar);
                        return;
                    }
                    throw g.i("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i6));
                }
                throw g.i("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
            throw g.i("TYPE_GOAWAY length < 8: %s", Short.valueOf(s3));
        }

        private void s(ByteBufferList byteBufferList, short s3, short s4, byte b4, int i4) throws IOException {
            boolean z3;
            byteBufferList.skip(s4);
            this.f35567e.u(byteBufferList);
            this.f35567e.n();
            this.f35567e.d();
            if ((b4 & 4) != 0) {
                byte b5 = this.f35576n;
                if (b5 == 1) {
                    if ((b4 & 1) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    this.f35565c.headers(false, z3, i4, -1, this.f35567e.f(), HeadersMode.HTTP_20_HEADERS);
                    return;
                } else if (b5 == 5) {
                    this.f35565c.pushPromise(i4, this.f35578p, this.f35567e.f());
                    return;
                } else {
                    throw new AssertionError("unknown header type");
                }
            }
            this.f35577o = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(ByteBufferList byteBufferList, short s3, byte b4, int i4) throws IOException {
            short s4;
            if (i4 != 0) {
                if ((b4 & 8) != 0) {
                    s4 = (short) (byteBufferList.get() & 255);
                } else {
                    s4 = 0;
                }
                if ((b4 & 32) != 0) {
                    v(byteBufferList, i4);
                    s3 = (short) (s3 - 5);
                }
                short j4 = g.j(s3, b4, s4);
                this.f35576n = this.f35571i;
                s(byteBufferList, j4, s4, b4, i4);
                return;
            }
            throw g.i("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(ByteBufferList byteBufferList, short s3, byte b4, int i4) throws IOException {
            boolean z3 = false;
            if (s3 == 8) {
                if (i4 == 0) {
                    int i5 = byteBufferList.getInt();
                    int i6 = byteBufferList.getInt();
                    if ((b4 & 1) != 0) {
                        z3 = true;
                    }
                    this.f35565c.ping(z3, i5, i6);
                    return;
                }
                throw g.i("TYPE_PING streamId != 0", new Object[0]);
            }
            throw g.i("TYPE_PING length != 8: %s", Short.valueOf(s3));
        }

        private void v(ByteBufferList byteBufferList, int i4) throws IOException {
            boolean z3;
            int i5 = byteBufferList.getInt();
            if ((Integer.MIN_VALUE & i5) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f35565c.priority(i4, i5 & Integer.MAX_VALUE, (byteBufferList.get() & 255) + 1, z3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w(ByteBufferList byteBufferList, short s3, byte b4, int i4) throws IOException {
            if (s3 == 5) {
                if (i4 != 0) {
                    v(byteBufferList, i4);
                    return;
                }
                throw g.i("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
            throw g.i("TYPE_PRIORITY length: %d != 5", Short.valueOf(s3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x(ByteBufferList byteBufferList, short s3, byte b4, int i4) throws IOException {
            short s4;
            if (i4 != 0) {
                if ((b4 & 8) != 0) {
                    s4 = (short) (byteBufferList.get() & 255);
                } else {
                    s4 = 0;
                }
                this.f35578p = byteBufferList.getInt() & Integer.MAX_VALUE;
                short j4 = g.j((short) (s3 - 4), b4, s4);
                this.f35576n = (byte) 5;
                s(byteBufferList, j4, s4, b4, i4);
                return;
            }
            throw g.i("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y(ByteBufferList byteBufferList, short s3, byte b4, int i4) throws IOException {
            if (s3 == 4) {
                if (i4 != 0) {
                    int i5 = byteBufferList.getInt();
                    com.koushikdutta.async.http.spdy.b a4 = com.koushikdutta.async.http.spdy.b.a(i5);
                    if (a4 != null) {
                        this.f35565c.rstStream(i4, a4);
                        return;
                    }
                    throw g.i("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i5));
                }
                throw g.i("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
            throw g.i("TYPE_RST_STREAM length: %d != 4", Short.valueOf(s3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z(ByteBufferList byteBufferList, short s3, byte b4, int i4) throws IOException {
            if (i4 == 0) {
                if ((b4 & 1) != 0) {
                    if (s3 == 0) {
                        this.f35565c.ackSettings();
                        return;
                    }
                    throw g.i("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                } else if (s3 % 6 == 0) {
                    j jVar = new j();
                    for (int i5 = 0; i5 < s3; i5 += 6) {
                        short s4 = byteBufferList.getShort();
                        int i6 = byteBufferList.getInt();
                        if (s4 != 1) {
                            if (s4 != 2) {
                                if (s4 != 3) {
                                    if (s4 != 4) {
                                        if (s4 != 5) {
                                            throw g.i("PROTOCOL_ERROR invalid settings id: %s", Short.valueOf(s4));
                                        }
                                    } else if (i6 >= 0) {
                                        s4 = 7;
                                    } else {
                                        throw g.i("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                                    }
                                } else {
                                    s4 = 4;
                                }
                            } else if (i6 != 0 && i6 != 1) {
                                throw g.i("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                            }
                        }
                        jVar.j(s4, 0, i6);
                    }
                    this.f35565c.settings(false, jVar);
                    if (jVar.d() >= 0) {
                        this.f35567e.k(jVar.d());
                        return;
                    }
                    return;
                } else {
                    throw g.i("TYPE_SETTINGS length %% 6 != 0: %s", Short.valueOf(s3));
                }
            }
            throw g.i("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
    }

    /* compiled from: Http20Draft13.java */
    /* loaded from: classes6.dex */
    static final class c implements com.koushikdutta.async.http.spdy.c {

        /* renamed from: a  reason: collision with root package name */
        private final BufferedDataSink f35581a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f35582b;

        /* renamed from: d  reason: collision with root package name */
        private boolean f35584d;

        /* renamed from: e  reason: collision with root package name */
        private final ByteBufferList f35585e = new ByteBufferList();

        /* renamed from: c  reason: collision with root package name */
        private final f.b f35583c = new f.b();

        c(BufferedDataSink bufferedDataSink, boolean z3) {
            this.f35581a = bufferedDataSink;
            this.f35582b = z3;
        }

        private void e(ByteBufferList byteBufferList, int i4) throws IOException {
            byte b4;
            while (byteBufferList.hasRemaining()) {
                int min = Math.min(16383, byteBufferList.remaining());
                if (byteBufferList.remaining() - min == 0) {
                    b4 = 4;
                } else {
                    b4 = 0;
                }
                c(i4, min, (byte) 9, b4);
                byteBufferList.get(this.f35585e, min);
                this.f35581a.write(this.f35585e);
            }
        }

        @Override // com.koushikdutta.async.http.spdy.c
        public synchronized void a(j jVar) throws IOException {
            int i4;
            if (!this.f35584d) {
                c(0, jVar.k() * 6, (byte) 4, (byte) 0);
                ByteBuffer order = ByteBufferList.obtain(8192).order(ByteOrder.BIG_ENDIAN);
                for (int i5 = 0; i5 < 10; i5++) {
                    if (jVar.g(i5)) {
                        if (i5 == 4) {
                            i4 = 3;
                        } else if (i5 == 7) {
                            i4 = 4;
                        } else {
                            i4 = i5;
                        }
                        order.putShort((short) i4);
                        order.putInt(jVar.c(i5));
                    }
                }
                order.flip();
                this.f35581a.write(this.f35585e.add(order));
            } else {
                throw new IOException("closed");
            }
        }

        @Override // com.koushikdutta.async.http.spdy.c
        public synchronized void ackSettings() throws IOException {
            if (!this.f35584d) {
                c(0, 0, (byte) 4, (byte) 1);
            } else {
                throw new IOException("closed");
            }
        }

        void b(int i4, byte b4, ByteBufferList byteBufferList) throws IOException {
            c(i4, byteBufferList.remaining(), (byte) 0, b4);
            this.f35581a.write(byteBufferList);
        }

        void c(int i4, int i5, byte b4, byte b5) throws IOException {
            if (g.f35558a.isLoggable(Level.FINE)) {
                g.f35558a.fine(a.b(false, i4, i5, b4, b5));
            }
            if (i5 <= 16383) {
                if ((Integer.MIN_VALUE & i4) == 0) {
                    ByteBuffer order = ByteBufferList.obtain(256).order(ByteOrder.BIG_ENDIAN);
                    order.putInt(((i5 & 16383) << 16) | ((b4 & 255) << 8) | (b5 & 255));
                    order.putInt(i4 & Integer.MAX_VALUE);
                    order.flip();
                    this.f35581a.write(this.f35585e.add(order));
                    return;
                }
                throw g.h("reserved bit set: %s", Integer.valueOf(i4));
            }
            throw g.h("FRAME_SIZE_ERROR length > %d: %d", 16383, Integer.valueOf(i5));
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            this.f35584d = true;
        }

        @Override // com.koushikdutta.async.http.spdy.c
        public synchronized void connectionPreface() throws IOException {
            if (!this.f35584d) {
                if (!this.f35582b) {
                    return;
                }
                if (g.f35558a.isLoggable(Level.FINE)) {
                    g.f35558a.fine(String.format(Locale.ENGLISH, ">> CONNECTION %s", g.f35559b.c()));
                }
                this.f35581a.write(new ByteBufferList(g.f35559b.i()));
                return;
            }
            throw new IOException("closed");
        }

        void d(boolean z3, int i4, List<d> list) throws IOException {
            byte b4;
            if (!this.f35584d) {
                ByteBufferList b5 = this.f35583c.b(list);
                long remaining = b5.remaining();
                int min = (int) Math.min(16383L, remaining);
                int i5 = (remaining > min ? 1 : (remaining == min ? 0 : -1));
                if (i5 == 0) {
                    b4 = 4;
                } else {
                    b4 = 0;
                }
                if (z3) {
                    b4 = (byte) (b4 | 1);
                }
                c(i4, min, (byte) 1, b4);
                b5.get(this.f35585e, min);
                this.f35581a.write(this.f35585e);
                if (i5 > 0) {
                    e(b5, i4);
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }

        @Override // com.koushikdutta.async.http.spdy.c
        public synchronized void data(boolean z3, int i4, ByteBufferList byteBufferList) throws IOException {
            byte b4;
            if (!this.f35584d) {
                if (z3) {
                    b4 = (byte) 1;
                } else {
                    b4 = 0;
                }
                b(i4, b4, byteBufferList);
            } else {
                throw new IOException("closed");
            }
        }

        @Override // com.koushikdutta.async.http.spdy.c
        public synchronized void ping(boolean z3, int i4, int i5) throws IOException {
            byte b4;
            if (!this.f35584d) {
                if (z3) {
                    b4 = 1;
                } else {
                    b4 = 0;
                }
                c(0, 8, (byte) 6, b4);
                ByteBuffer order = ByteBufferList.obtain(256).order(ByteOrder.BIG_ENDIAN);
                order.putInt(i4);
                order.putInt(i5);
                order.flip();
                this.f35581a.write(this.f35585e.add(order));
            } else {
                throw new IOException("closed");
            }
        }

        @Override // com.koushikdutta.async.http.spdy.c
        public synchronized void pushPromise(int i4, int i5, List<d> list) throws IOException {
            byte b4;
            if (!this.f35584d) {
                ByteBufferList b5 = this.f35583c.b(list);
                long remaining = b5.remaining();
                int min = (int) Math.min(16379L, remaining);
                int i6 = (remaining > min ? 1 : (remaining == min ? 0 : -1));
                if (i6 == 0) {
                    b4 = 4;
                } else {
                    b4 = 0;
                }
                c(i4, min + 4, (byte) 5, b4);
                ByteBuffer order = ByteBufferList.obtain(8192).order(ByteOrder.BIG_ENDIAN);
                order.putInt(i5 & Integer.MAX_VALUE);
                order.flip();
                this.f35585e.add(order);
                b5.get(this.f35585e, min);
                this.f35581a.write(this.f35585e);
                if (i6 > 0) {
                    e(b5, i4);
                }
            } else {
                throw new IOException("closed");
            }
        }

        @Override // com.koushikdutta.async.http.spdy.c
        public synchronized void rstStream(int i4, com.koushikdutta.async.http.spdy.b bVar) throws IOException {
            if (!this.f35584d) {
                if (bVar.spdyRstCode != -1) {
                    c(i4, 4, (byte) 3, (byte) 0);
                    ByteBuffer order = ByteBufferList.obtain(8192).order(ByteOrder.BIG_ENDIAN);
                    order.putInt(bVar.httpCode);
                    order.flip();
                    this.f35581a.write(this.f35585e.add(order));
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                throw new IOException("closed");
            }
        }

        @Override // com.koushikdutta.async.http.spdy.c
        public synchronized void synStream(boolean z3, boolean z4, int i4, int i5, List<d> list) throws IOException {
            try {
                if (!z4) {
                    if (!this.f35584d) {
                        d(z3, i4, list);
                    } else {
                        throw new IOException("closed");
                    }
                } else {
                    throw new UnsupportedOperationException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // com.koushikdutta.async.http.spdy.c
        public synchronized void windowUpdate(int i4, long j4) throws IOException {
            if (!this.f35584d) {
                if (j4 != 0 && j4 <= 2147483647L) {
                    c(i4, 4, (byte) 8, (byte) 0);
                    ByteBuffer order = ByteBufferList.obtain(256).order(ByteOrder.BIG_ENDIAN);
                    order.putInt((int) j4);
                    order.flip();
                    this.f35581a.write(this.f35585e.add(order));
                } else {
                    throw g.h("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j4));
                }
            } else {
                throw new IOException("closed");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IllegalArgumentException h(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(Locale.ENGLISH, str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IOException i(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(Locale.ENGLISH, str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static short j(short s3, byte b4, short s4) throws IOException {
        if ((b4 & 8) != 0) {
            s3 = (short) (s3 - 1);
        }
        if (s4 <= s3) {
            return (short) (s3 - s4);
        }
        throw i("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s4), Short.valueOf(s3));
    }

    @Override // com.koushikdutta.async.http.spdy.n
    public com.koushikdutta.async.http.spdy.c a(BufferedDataSink bufferedDataSink, boolean z3) {
        return new c(bufferedDataSink, z3);
    }

    @Override // com.koushikdutta.async.http.spdy.n
    public FrameReader b(DataEmitter dataEmitter, FrameReader.Handler handler, boolean z3) {
        return new b(dataEmitter, handler, 4096, z3);
    }
}
