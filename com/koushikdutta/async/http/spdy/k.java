package com.koushikdutta.async.http.spdy;

import com.koushikdutta.async.BufferedDataSink;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataEmitterReader;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.http.spdy.FrameReader;
import com.koushikdutta.async.util.Charsets;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Locale;
import java.util.zip.Deflater;

/* compiled from: Spdy3.java */
/* loaded from: classes6.dex */
final class k implements n {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f35600a;

    static {
        try {
            f35600a = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(Charsets.UTF_8.name());
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }

    @Override // com.koushikdutta.async.http.spdy.n
    public c a(BufferedDataSink bufferedDataSink, boolean z3) {
        return new b(bufferedDataSink, z3);
    }

    @Override // com.koushikdutta.async.http.spdy.n
    public FrameReader b(DataEmitter dataEmitter, FrameReader.Handler handler, boolean z3) {
        return new a(dataEmitter, handler, z3);
    }

    /* compiled from: Spdy3.java */
    /* loaded from: classes6.dex */
    static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final BufferedDataSink f35621a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f35622b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f35623c;

        /* renamed from: d  reason: collision with root package name */
        private ByteBufferList f35624d = new ByteBufferList();

        /* renamed from: e  reason: collision with root package name */
        private final Deflater f35625e;

        /* renamed from: f  reason: collision with root package name */
        ByteBufferList f35626f;

        /* renamed from: g  reason: collision with root package name */
        ByteBufferList f35627g;

        b(BufferedDataSink bufferedDataSink, boolean z3) {
            Deflater deflater = new Deflater();
            this.f35625e = deflater;
            this.f35626f = new ByteBufferList();
            this.f35627g = new ByteBufferList();
            this.f35621a = bufferedDataSink;
            this.f35622b = z3;
            deflater.setDictionary(k.f35600a);
        }

        private ByteBufferList c(List<d> list) throws IOException {
            if (!this.f35627g.hasRemaining()) {
                ByteBuffer order = ByteBufferList.obtain(8192).order(ByteOrder.BIG_ENDIAN);
                order.putInt(list.size());
                int size = list.size();
                for (int i4 = 0; i4 < size; i4++) {
                    com.koushikdutta.async.http.spdy.a aVar = list.get(i4).f35541a;
                    order.putInt(aVar.g());
                    order.put(aVar.i());
                    com.koushikdutta.async.http.spdy.a aVar2 = list.get(i4).f35542b;
                    order.putInt(aVar2.g());
                    order.put(aVar2.i());
                    if (order.remaining() < order.capacity() / 2) {
                        ByteBuffer order2 = ByteBufferList.obtain(order.capacity() * 2).order(ByteOrder.BIG_ENDIAN);
                        order.flip();
                        order2.put(order);
                        ByteBufferList.reclaim(order);
                        order = order2;
                    }
                }
                order.flip();
                this.f35625e.setInput(order.array(), 0, order.remaining());
                while (!this.f35625e.needsInput()) {
                    ByteBuffer order3 = ByteBufferList.obtain(order.capacity()).order(ByteOrder.BIG_ENDIAN);
                    order3.limit(this.f35625e.deflate(order3.array(), 0, order3.capacity(), 2));
                    this.f35627g.add(order3);
                }
                ByteBufferList.reclaim(order);
                return this.f35627g;
            }
            throw new IllegalStateException();
        }

        @Override // com.koushikdutta.async.http.spdy.c
        public synchronized void a(j jVar) throws IOException {
            if (!this.f35623c) {
                int k4 = jVar.k();
                ByteBuffer order = ByteBufferList.obtain(256).order(ByteOrder.BIG_ENDIAN);
                order.putInt(-2147287036);
                order.putInt((((k4 * 8) + 4) & 16777215) | 0);
                order.putInt(k4);
                for (int i4 = 0; i4 <= 10; i4++) {
                    if (jVar.g(i4)) {
                        order.putInt(((jVar.b(i4) & 255) << 24) | (i4 & 16777215));
                        order.putInt(jVar.c(i4));
                    }
                }
                order.flip();
                this.f35621a.write(this.f35624d.addAll(order));
            } else {
                throw new IOException("closed");
            }
        }

        void b(int i4, int i5, ByteBufferList byteBufferList) throws IOException {
            if (!this.f35623c) {
                int remaining = byteBufferList.remaining();
                if (remaining <= 16777215) {
                    ByteBuffer order = ByteBufferList.obtain(256).order(ByteOrder.BIG_ENDIAN);
                    order.putInt(i4 & Integer.MAX_VALUE);
                    order.putInt(((i5 & 255) << 24) | (16777215 & remaining));
                    order.flip();
                    this.f35626f.add(order).add(byteBufferList);
                    this.f35621a.write(this.f35626f);
                    return;
                }
                throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + remaining);
            }
            throw new IOException("closed");
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            this.f35623c = true;
        }

        @Override // com.koushikdutta.async.http.spdy.c
        public synchronized void connectionPreface() {
        }

        @Override // com.koushikdutta.async.http.spdy.c
        public synchronized void data(boolean z3, int i4, ByteBufferList byteBufferList) throws IOException {
            int i5;
            if (z3) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            b(i4, i5, byteBufferList);
        }

        @Override // com.koushikdutta.async.http.spdy.c
        public synchronized void ping(boolean z3, int i4, int i5) throws IOException {
            boolean z4;
            boolean z5;
            if (!this.f35623c) {
                boolean z6 = this.f35622b;
                if ((i4 & 1) == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z6 != z4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z3 == z5) {
                    ByteBuffer order = ByteBufferList.obtain(256).order(ByteOrder.BIG_ENDIAN);
                    order.putInt(-2147287034);
                    order.putInt(4);
                    order.putInt(i4);
                    order.flip();
                    this.f35621a.write(this.f35624d.addAll(order));
                } else {
                    throw new IllegalArgumentException("payload != reply");
                }
            } else {
                throw new IOException("closed");
            }
        }

        @Override // com.koushikdutta.async.http.spdy.c
        public synchronized void rstStream(int i4, com.koushikdutta.async.http.spdy.b bVar) throws IOException {
            if (!this.f35623c) {
                if (bVar.spdyRstCode != -1) {
                    ByteBuffer order = ByteBufferList.obtain(256).order(ByteOrder.BIG_ENDIAN);
                    order.putInt(-2147287037);
                    order.putInt(8);
                    order.putInt(i4 & Integer.MAX_VALUE);
                    order.putInt(bVar.spdyRstCode);
                    order.flip();
                    this.f35621a.write(this.f35624d.addAll(order));
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                throw new IOException("closed");
            }
        }

        @Override // com.koushikdutta.async.http.spdy.c
        public synchronized void synStream(boolean z3, boolean z4, int i4, int i5, List<d> list) throws IOException {
            int i6;
            if (!this.f35623c) {
                ByteBufferList c4 = c(list);
                int remaining = c4.remaining() + 10;
                if (z4) {
                    i6 = 2;
                } else {
                    i6 = 0;
                }
                int i7 = (z3 ? 1 : 0) | i6;
                ByteBuffer order = ByteBufferList.obtain(256).order(ByteOrder.BIG_ENDIAN);
                order.putInt(-2147287039);
                order.putInt(((i7 & 255) << 24) | (remaining & 16777215));
                order.putInt(i4 & Integer.MAX_VALUE);
                order.putInt(Integer.MAX_VALUE & i5);
                order.putShort((short) 0);
                order.flip();
                this.f35621a.write(this.f35624d.add(order).add(c4));
            } else {
                throw new IOException("closed");
            }
        }

        @Override // com.koushikdutta.async.http.spdy.c
        public synchronized void windowUpdate(int i4, long j4) throws IOException {
            if (!this.f35623c) {
                if (j4 != 0 && j4 <= 2147483647L) {
                    ByteBuffer order = ByteBufferList.obtain(256).order(ByteOrder.BIG_ENDIAN);
                    order.putInt(-2147287031);
                    order.putInt(8);
                    order.putInt(i4);
                    order.putInt((int) j4);
                    order.flip();
                    this.f35621a.write(this.f35624d.addAll(order));
                } else {
                    throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + j4);
                }
            } else {
                throw new IOException("closed");
            }
        }

        @Override // com.koushikdutta.async.http.spdy.c
        public void ackSettings() {
        }

        @Override // com.koushikdutta.async.http.spdy.c
        public void pushPromise(int i4, int i5, List<d> list) throws IOException {
        }
    }

    /* compiled from: Spdy3.java */
    /* loaded from: classes6.dex */
    static final class a implements FrameReader {

        /* renamed from: b  reason: collision with root package name */
        private final DataEmitter f35602b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f35603c;

        /* renamed from: d  reason: collision with root package name */
        private final FrameReader.Handler f35604d;

        /* renamed from: e  reason: collision with root package name */
        private final DataEmitterReader f35605e;

        /* renamed from: f  reason: collision with root package name */
        int f35606f;

        /* renamed from: g  reason: collision with root package name */
        int f35607g;

        /* renamed from: h  reason: collision with root package name */
        int f35608h;

        /* renamed from: i  reason: collision with root package name */
        int f35609i;

        /* renamed from: j  reason: collision with root package name */
        int f35610j;

        /* renamed from: k  reason: collision with root package name */
        boolean f35611k;

        /* renamed from: a  reason: collision with root package name */
        private final e f35601a = new e();

        /* renamed from: l  reason: collision with root package name */
        private final ByteBufferList f35612l = new ByteBufferList();

        /* renamed from: m  reason: collision with root package name */
        private final DataCallback f35613m = new b();

        /* renamed from: n  reason: collision with root package name */
        ByteBufferList f35614n = new ByteBufferList();

        /* renamed from: o  reason: collision with root package name */
        private final DataCallback f35615o = new c();

        /* renamed from: p  reason: collision with root package name */
        private final DataCallback f35616p = new d();

        /* compiled from: Spdy3.java */
        /* loaded from: classes6.dex */
        class b implements DataCallback {
            b() {
            }

            @Override // com.koushikdutta.async.callback.DataCallback
            public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                boolean z3;
                byteBufferList.order(ByteOrder.BIG_ENDIAN);
                a.this.f35606f = byteBufferList.getInt();
                a.this.f35607g = byteBufferList.getInt();
                a aVar = a.this;
                int i4 = aVar.f35606f;
                boolean z4 = false;
                if ((Integer.MIN_VALUE & i4) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                int i5 = aVar.f35607g;
                int i6 = ((-16777216) & i5) >>> 24;
                aVar.f35608h = i6;
                aVar.f35609i = i5 & 16777215;
                if (z3) {
                    DataEmitterReader dataEmitterReader = aVar.f35605e;
                    a aVar2 = a.this;
                    dataEmitterReader.read(aVar2.f35609i, aVar2.f35616p);
                    return;
                }
                aVar.f35610j = i4 & Integer.MAX_VALUE;
                if ((i6 & 1) != 0) {
                    z4 = true;
                }
                aVar.f35611k = z4;
                dataEmitter.setDataCallback(aVar.f35615o);
                a aVar3 = a.this;
                if (aVar3.f35609i == 0) {
                    aVar3.f35615o.onDataAvailable(dataEmitter, a.this.f35612l);
                }
            }
        }

        /* compiled from: Spdy3.java */
        /* loaded from: classes6.dex */
        class c implements DataCallback {
            c() {
            }

            @Override // com.koushikdutta.async.callback.DataCallback
            public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                boolean z3;
                int min = Math.min(byteBufferList.remaining(), a.this.f35609i);
                if (min < byteBufferList.remaining()) {
                    byteBufferList.get(a.this.f35614n, min);
                    byteBufferList = a.this.f35614n;
                }
                a aVar = a.this;
                aVar.f35609i -= min;
                FrameReader.Handler handler = aVar.f35604d;
                a aVar2 = a.this;
                if (aVar2.f35609i == 0 && aVar2.f35611k) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                handler.data(z3, aVar2.f35610j, byteBufferList);
                a aVar3 = a.this;
                if (aVar3.f35609i == 0) {
                    aVar3.p();
                }
            }
        }

        /* compiled from: Spdy3.java */
        /* loaded from: classes6.dex */
        class d implements DataCallback {
            d() {
            }

            @Override // com.koushikdutta.async.callback.DataCallback
            public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                byteBufferList.order(ByteOrder.BIG_ENDIAN);
                a aVar = a.this;
                int i4 = aVar.f35606f;
                int i5 = (2147418112 & i4) >>> 16;
                int i6 = i4 & 65535;
                try {
                    if (i5 == 3) {
                        switch (i6) {
                            case 1:
                                aVar.w(byteBufferList, aVar.f35608h, aVar.f35609i);
                                break;
                            case 2:
                                aVar.v(byteBufferList, aVar.f35608h, aVar.f35609i);
                                break;
                            case 3:
                                aVar.t(byteBufferList, aVar.f35608h, aVar.f35609i);
                                break;
                            case 4:
                                aVar.u(byteBufferList, aVar.f35608h, aVar.f35609i);
                                break;
                            case 5:
                            default:
                                byteBufferList.recycle();
                                break;
                            case 6:
                                aVar.s(byteBufferList, aVar.f35608h, aVar.f35609i);
                                break;
                            case 7:
                                aVar.q(byteBufferList, aVar.f35608h, aVar.f35609i);
                                break;
                            case 8:
                                aVar.r(byteBufferList, aVar.f35608h, aVar.f35609i);
                                break;
                            case 9:
                                aVar.x(byteBufferList, aVar.f35608h, aVar.f35609i);
                                break;
                        }
                        a.this.p();
                        return;
                    }
                    throw new ProtocolException("version != 3: " + i5);
                } catch (IOException e4) {
                    a.this.f35604d.error(e4);
                }
            }
        }

        a(DataEmitter dataEmitter, FrameReader.Handler handler, boolean z3) {
            this.f35602b = dataEmitter;
            this.f35604d = handler;
            this.f35603c = z3;
            dataEmitter.setEndCallback(new C0200a());
            this.f35605e = new DataEmitterReader();
            p();
        }

        private static IOException o(String str, Object... objArr) throws IOException {
            throw new IOException(String.format(Locale.ENGLISH, str, objArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p() {
            this.f35602b.setDataCallback(this.f35605e);
            this.f35605e.read(8, this.f35613m);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q(ByteBufferList byteBufferList, int i4, int i5) throws IOException {
            if (i5 == 8) {
                int i6 = byteBufferList.getInt() & Integer.MAX_VALUE;
                int i7 = byteBufferList.getInt();
                com.koushikdutta.async.http.spdy.b c4 = com.koushikdutta.async.http.spdy.b.c(i7);
                if (c4 != null) {
                    this.f35604d.goAway(i6, c4, com.koushikdutta.async.http.spdy.a.f35513d);
                    return;
                }
                throw o("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i7));
            }
            throw o("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i5));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(ByteBufferList byteBufferList, int i4, int i5) throws IOException {
            this.f35604d.headers(false, false, byteBufferList.getInt() & Integer.MAX_VALUE, -1, this.f35601a.b(byteBufferList, i5 - 4), HeadersMode.SPDY_HEADERS);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(ByteBufferList byteBufferList, int i4, int i5) throws IOException {
            boolean z3;
            boolean z4 = true;
            if (i5 == 4) {
                int i6 = byteBufferList.getInt();
                boolean z5 = this.f35603c;
                if ((i6 & 1) == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z5 != z3) {
                    z4 = false;
                }
                this.f35604d.ping(z4, i6, 0);
                return;
            }
            throw o("TYPE_PING length: %d != 4", Integer.valueOf(i5));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(ByteBufferList byteBufferList, int i4, int i5) throws IOException {
            if (i5 == 8) {
                int i6 = byteBufferList.getInt() & Integer.MAX_VALUE;
                int i7 = byteBufferList.getInt();
                com.koushikdutta.async.http.spdy.b b4 = com.koushikdutta.async.http.spdy.b.b(i7);
                if (b4 != null) {
                    this.f35604d.rstStream(i6, b4);
                    return;
                }
                throw o("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i7));
            }
            throw o("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i5));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(ByteBufferList byteBufferList, int i4, int i5) throws IOException {
            int i6 = byteBufferList.getInt();
            boolean z3 = false;
            if (i5 == (i6 * 8) + 4) {
                j jVar = new j();
                for (int i7 = 0; i7 < i6; i7++) {
                    int i8 = byteBufferList.getInt();
                    jVar.j(i8 & 16777215, ((-16777216) & i8) >>> 24, byteBufferList.getInt());
                }
                if ((i4 & 1) != 0) {
                    z3 = true;
                }
                this.f35604d.settings(z3, jVar);
                return;
            }
            throw o("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i5), Integer.valueOf(i6));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v(ByteBufferList byteBufferList, int i4, int i5) throws IOException {
            boolean z3;
            int i6 = byteBufferList.getInt() & Integer.MAX_VALUE;
            List<com.koushikdutta.async.http.spdy.d> b4 = this.f35601a.b(byteBufferList, i5 - 4);
            if ((i4 & 1) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f35604d.headers(false, z3, i6, -1, b4, HeadersMode.SPDY_REPLY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w(ByteBufferList byteBufferList, int i4, int i5) throws IOException {
            boolean z3;
            boolean z4;
            int i6 = byteBufferList.getInt() & Integer.MAX_VALUE;
            int i7 = byteBufferList.getInt() & Integer.MAX_VALUE;
            byteBufferList.getShort();
            List<com.koushikdutta.async.http.spdy.d> b4 = this.f35601a.b(byteBufferList, i5 - 10);
            if ((i4 & 1) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if ((i4 & 2) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f35604d.headers(z4, z3, i6, i7, b4, HeadersMode.SPDY_SYN_STREAM);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x(ByteBufferList byteBufferList, int i4, int i5) throws IOException {
            if (i5 == 8) {
                int i6 = byteBufferList.getInt() & Integer.MAX_VALUE;
                long j4 = byteBufferList.getInt() & Integer.MAX_VALUE;
                if (j4 != 0) {
                    this.f35604d.windowUpdate(i6, j4);
                    return;
                }
                throw o("windowSizeIncrement was 0", Long.valueOf(j4));
            }
            throw o("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i5));
        }

        /* compiled from: Spdy3.java */
        /* renamed from: com.koushikdutta.async.http.spdy.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class C0200a implements CompletedCallback {
            C0200a() {
            }

            @Override // com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception exc) {
            }
        }
    }
}
