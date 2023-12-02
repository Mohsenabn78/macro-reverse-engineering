package com.koushikdutta.async.http.spdy;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.BufferedDataSink;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.http.Protocol;
import com.koushikdutta.async.http.spdy.FrameReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class AsyncSpdyConnection implements FrameReader.Handler {

    /* renamed from: a  reason: collision with root package name */
    AsyncSocket f35446a;

    /* renamed from: b  reason: collision with root package name */
    BufferedDataSink f35447b;

    /* renamed from: c  reason: collision with root package name */
    FrameReader f35448c;

    /* renamed from: d  reason: collision with root package name */
    c f35449d;

    /* renamed from: e  reason: collision with root package name */
    n f35450e;

    /* renamed from: g  reason: collision with root package name */
    Protocol f35452g;

    /* renamed from: i  reason: collision with root package name */
    int f35454i;

    /* renamed from: j  reason: collision with root package name */
    final j f35455j;

    /* renamed from: k  reason: collision with root package name */
    private int f35456k;

    /* renamed from: l  reason: collision with root package name */
    private int f35457l;

    /* renamed from: m  reason: collision with root package name */
    private int f35458m;

    /* renamed from: n  reason: collision with root package name */
    long f35459n;

    /* renamed from: o  reason: collision with root package name */
    j f35460o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f35461p;

    /* renamed from: q  reason: collision with root package name */
    private Map<Integer, i> f35462q;

    /* renamed from: r  reason: collision with root package name */
    boolean f35463r;

    /* renamed from: f  reason: collision with root package name */
    Hashtable<Integer, SpdySocket> f35451f = new Hashtable<>();

    /* renamed from: h  reason: collision with root package name */
    boolean f35453h = true;

    /* loaded from: classes6.dex */
    public class SpdySocket implements AsyncSocket {

        /* renamed from: a  reason: collision with root package name */
        long f35464a;

        /* renamed from: b  reason: collision with root package name */
        WritableCallback f35465b;

        /* renamed from: c  reason: collision with root package name */
        final int f35466c;

        /* renamed from: d  reason: collision with root package name */
        CompletedCallback f35467d;

        /* renamed from: e  reason: collision with root package name */
        CompletedCallback f35468e;

        /* renamed from: f  reason: collision with root package name */
        DataCallback f35469f;

        /* renamed from: j  reason: collision with root package name */
        int f35473j;

        /* renamed from: k  reason: collision with root package name */
        boolean f35474k;

        /* renamed from: g  reason: collision with root package name */
        ByteBufferList f35470g = new ByteBufferList();

        /* renamed from: h  reason: collision with root package name */
        SimpleFuture<List<d>> f35471h = new SimpleFuture<>();

        /* renamed from: i  reason: collision with root package name */
        boolean f35472i = true;

        /* renamed from: l  reason: collision with root package name */
        ByteBufferList f35475l = new ByteBufferList();

        public SpdySocket(int i4, boolean z3, boolean z4, List<d> list) {
            this.f35464a = AsyncSpdyConnection.this.f35460o.e(65536);
            this.f35466c = i4;
        }

        void a(int i4) {
            int i5 = this.f35473j + i4;
            this.f35473j = i5;
            if (i5 >= AsyncSpdyConnection.this.f35455j.e(65536) / 2) {
                try {
                    AsyncSpdyConnection.this.f35449d.windowUpdate(this.f35466c, this.f35473j);
                    this.f35473j = 0;
                } catch (IOException e4) {
                    throw new AssertionError(e4);
                }
            }
            AsyncSpdyConnection.this.e(i4);
        }

        public void addBytesToWriteWindow(long j4) {
            long j5 = this.f35464a;
            long j6 = j4 + j5;
            this.f35464a = j6;
            if (j6 > 0 && j5 <= 0) {
                Util.writable(this.f35465b);
            }
        }

        @Override // com.koushikdutta.async.DataEmitter
        public String charset() {
            return null;
        }

        @Override // com.koushikdutta.async.DataEmitter
        public void close() {
            this.f35472i = false;
        }

        @Override // com.koushikdutta.async.DataSink
        public void end() {
            try {
                AsyncSpdyConnection.this.f35449d.data(true, this.f35466c, this.f35475l);
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        }

        @Override // com.koushikdutta.async.DataSink
        public CompletedCallback getClosedCallback() {
            return this.f35467d;
        }

        public AsyncSpdyConnection getConnection() {
            return AsyncSpdyConnection.this;
        }

        @Override // com.koushikdutta.async.DataEmitter
        public DataCallback getDataCallback() {
            return this.f35469f;
        }

        @Override // com.koushikdutta.async.DataEmitter
        public CompletedCallback getEndCallback() {
            return this.f35468e;
        }

        @Override // com.koushikdutta.async.AsyncSocket, com.koushikdutta.async.DataEmitter, com.koushikdutta.async.DataSink
        public AsyncServer getServer() {
            return AsyncSpdyConnection.this.f35446a.getServer();
        }

        @Override // com.koushikdutta.async.DataSink
        public WritableCallback getWriteableCallback() {
            return this.f35465b;
        }

        public SimpleFuture<List<d>> headers() {
            return this.f35471h;
        }

        @Override // com.koushikdutta.async.DataEmitter
        public boolean isChunked() {
            return false;
        }

        public boolean isLocallyInitiated() {
            boolean z3;
            if ((this.f35466c & 1) == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (AsyncSpdyConnection.this.f35453h == z3) {
                return true;
            }
            return false;
        }

        @Override // com.koushikdutta.async.DataSink
        public boolean isOpen() {
            return this.f35472i;
        }

        @Override // com.koushikdutta.async.DataEmitter
        public boolean isPaused() {
            return this.f35474k;
        }

        @Override // com.koushikdutta.async.DataEmitter
        public void pause() {
            this.f35474k = true;
        }

        public void receiveHeaders(List<d> list, HeadersMode headersMode) {
            this.f35471h.setComplete((SimpleFuture<List<d>>) list);
        }

        @Override // com.koushikdutta.async.DataEmitter
        public void resume() {
            this.f35474k = false;
        }

        @Override // com.koushikdutta.async.DataSink
        public void setClosedCallback(CompletedCallback completedCallback) {
            this.f35467d = completedCallback;
        }

        @Override // com.koushikdutta.async.DataEmitter
        public void setDataCallback(DataCallback dataCallback) {
            this.f35469f = dataCallback;
        }

        @Override // com.koushikdutta.async.DataEmitter
        public void setEndCallback(CompletedCallback completedCallback) {
            this.f35468e = completedCallback;
        }

        @Override // com.koushikdutta.async.DataSink
        public void setWriteableCallback(WritableCallback writableCallback) {
            this.f35465b = writableCallback;
        }

        @Override // com.koushikdutta.async.DataSink
        public void write(ByteBufferList byteBufferList) {
            int min = Math.min(byteBufferList.remaining(), (int) Math.min(this.f35464a, AsyncSpdyConnection.this.f35459n));
            if (min == 0) {
                return;
            }
            if (min < byteBufferList.remaining()) {
                if (!this.f35475l.hasRemaining()) {
                    byteBufferList.get(this.f35475l, min);
                    byteBufferList = this.f35475l;
                } else {
                    throw new AssertionError("wtf");
                }
            }
            try {
                AsyncSpdyConnection.this.f35449d.data(false, this.f35466c, byteBufferList);
                this.f35464a -= min;
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        }
    }

    public AsyncSpdyConnection(AsyncSocket asyncSocket, Protocol protocol) {
        j jVar = new j();
        this.f35455j = jVar;
        this.f35460o = new j();
        this.f35461p = false;
        this.f35452g = protocol;
        this.f35446a = asyncSocket;
        this.f35447b = new BufferedDataSink(asyncSocket);
        if (protocol == Protocol.SPDY_3) {
            this.f35450e = new k();
        } else if (protocol == Protocol.HTTP_2) {
            this.f35450e = new g();
        }
        this.f35448c = this.f35450e.b(asyncSocket, this, true);
        this.f35449d = this.f35450e.a(this.f35447b, true);
        this.f35458m = 1;
        if (protocol == Protocol.HTTP_2) {
            this.f35458m = 1 + 2;
        }
        this.f35456k = 1;
        jVar.j(7, 0, 16777216);
    }

    private SpdySocket b(int i4, List<d> list, boolean z3, boolean z4) {
        boolean z5 = !z3;
        boolean z6 = !z4;
        if (this.f35463r) {
            return null;
        }
        int i5 = this.f35458m;
        this.f35458m = i5 + 2;
        SpdySocket spdySocket = new SpdySocket(i5, z5, z6, list);
        if (spdySocket.isOpen()) {
            this.f35451f.put(Integer.valueOf(i5), spdySocket);
        }
        try {
            if (i4 == 0) {
                this.f35449d.synStream(z5, z6, i5, i4, list);
            } else if (!this.f35453h) {
                this.f35449d.pushPromise(i4, i5, list);
            } else {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
            return spdySocket;
        } catch (IOException e4) {
            throw new AssertionError(e4);
        }
    }

    private boolean c(int i4) {
        if (this.f35452g == Protocol.HTTP_2 && i4 != 0 && (i4 & 1) == 0) {
            return true;
        }
        return false;
    }

    private synchronized i d(int i4) {
        i iVar;
        Map<Integer, i> map = this.f35462q;
        if (map != null) {
            iVar = map.remove(Integer.valueOf(i4));
        } else {
            iVar = null;
        }
        return iVar;
    }

    private void f(boolean z3, int i4, int i5, i iVar) throws IOException {
        if (iVar != null) {
            iVar.b();
        }
        this.f35449d.ping(z3, i4, i5);
    }

    void a(long j4) {
        this.f35459n += j4;
        for (SpdySocket spdySocket : this.f35451f.values()) {
            Util.writable(spdySocket);
        }
    }

    @Override // com.koushikdutta.async.http.spdy.FrameReader.Handler
    public void ackSettings() {
        try {
            this.f35449d.ackSettings();
        } catch (IOException e4) {
            throw new AssertionError(e4);
        }
    }

    @Override // com.koushikdutta.async.http.spdy.FrameReader.Handler
    public void data(boolean z3, int i4, ByteBufferList byteBufferList) {
        if (!c(i4)) {
            SpdySocket spdySocket = this.f35451f.get(Integer.valueOf(i4));
            if (spdySocket == null) {
                try {
                    this.f35449d.rstStream(i4, b.INVALID_STREAM);
                    byteBufferList.recycle();
                    return;
                } catch (IOException e4) {
                    throw new AssertionError(e4);
                }
            }
            int remaining = byteBufferList.remaining();
            byteBufferList.get(spdySocket.f35470g);
            spdySocket.a(remaining);
            Util.emitAllData(spdySocket, spdySocket.f35470g);
            if (z3) {
                this.f35451f.remove(Integer.valueOf(i4));
                spdySocket.close();
                Util.end(spdySocket, (Exception) null);
                return;
            }
            return;
        }
        throw new AssertionError("push");
    }

    void e(int i4) {
        int i5 = this.f35454i + i4;
        this.f35454i = i5;
        if (i5 >= this.f35455j.e(65536) / 2) {
            try {
                this.f35449d.windowUpdate(0, this.f35454i);
                this.f35454i = 0;
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        }
    }

    @Override // com.koushikdutta.async.http.spdy.FrameReader.Handler
    public void error(Exception exc) {
        this.f35446a.close();
        Iterator<Map.Entry<Integer, SpdySocket>> it = this.f35451f.entrySet().iterator();
        while (it.hasNext()) {
            Util.end(it.next().getValue(), exc);
            it.remove();
        }
    }

    @Override // com.koushikdutta.async.http.spdy.FrameReader.Handler
    public void goAway(int i4, b bVar, a aVar) {
        this.f35463r = true;
        Iterator<Map.Entry<Integer, SpdySocket>> it = this.f35451f.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, SpdySocket> next = it.next();
            if (next.getKey().intValue() > i4 && next.getValue().isLocallyInitiated()) {
                Util.end(next.getValue(), new IOException(b.REFUSED_STREAM.toString()));
                it.remove();
            }
        }
    }

    @Override // com.koushikdutta.async.http.spdy.FrameReader.Handler
    public void headers(boolean z3, boolean z4, int i4, int i5, List<d> list, HeadersMode headersMode) {
        if (!c(i4)) {
            if (this.f35463r) {
                return;
            }
            SpdySocket spdySocket = this.f35451f.get(Integer.valueOf(i4));
            if (spdySocket == null) {
                if (headersMode.failIfStreamAbsent()) {
                    try {
                        this.f35449d.rstStream(i4, b.INVALID_STREAM);
                        return;
                    } catch (IOException e4) {
                        throw new AssertionError(e4);
                    }
                } else if (i4 <= this.f35457l || i4 % 2 == this.f35458m % 2) {
                    return;
                } else {
                    throw new AssertionError("unexpected receive stream");
                }
            } else if (headersMode.failIfStreamPresent()) {
                try {
                    this.f35449d.rstStream(i4, b.INVALID_STREAM);
                    this.f35451f.remove(Integer.valueOf(i4));
                    return;
                } catch (IOException e5) {
                    throw new AssertionError(e5);
                }
            } else {
                spdySocket.receiveHeaders(list, headersMode);
                if (z4) {
                    this.f35451f.remove(Integer.valueOf(i4));
                    Util.end(spdySocket, (Exception) null);
                    return;
                }
                return;
            }
        }
        throw new AssertionError("push");
    }

    public SpdySocket newStream(List<d> list, boolean z3, boolean z4) {
        return b(0, list, z3, z4);
    }

    @Override // com.koushikdutta.async.http.spdy.FrameReader.Handler
    public void ping(boolean z3, int i4, int i5) {
        if (z3) {
            i d4 = d(i4);
            if (d4 != null) {
                d4.a();
                return;
            }
            return;
        }
        try {
            f(true, i4, i5, null);
        } catch (IOException e4) {
            throw new AssertionError(e4);
        }
    }

    @Override // com.koushikdutta.async.http.spdy.FrameReader.Handler
    public void pushPromise(int i4, int i5, List<d> list) {
        throw new AssertionError("pushPromise");
    }

    @Override // com.koushikdutta.async.http.spdy.FrameReader.Handler
    public void rstStream(int i4, b bVar) {
        if (!c(i4)) {
            SpdySocket remove = this.f35451f.remove(Integer.valueOf(i4));
            if (remove != null) {
                Util.end(remove, new IOException(bVar.toString()));
                return;
            }
            return;
        }
        throw new AssertionError("push");
    }

    public void sendConnectionPreface() throws IOException {
        this.f35449d.connectionPreface();
        this.f35449d.a(this.f35455j);
        int e4 = this.f35455j.e(65536);
        if (e4 != 65536) {
            this.f35449d.windowUpdate(0, e4 - 65536);
        }
    }

    @Override // com.koushikdutta.async.http.spdy.FrameReader.Handler
    public void settings(boolean z3, j jVar) {
        long j4;
        int e4 = this.f35460o.e(65536);
        if (z3) {
            this.f35460o.a();
        }
        this.f35460o.h(jVar);
        try {
            this.f35449d.ackSettings();
            int e5 = this.f35460o.e(65536);
            if (e5 != -1 && e5 != e4) {
                j4 = e5 - e4;
                if (!this.f35461p) {
                    a(j4);
                    this.f35461p = true;
                }
            } else {
                j4 = 0;
            }
            for (SpdySocket spdySocket : this.f35451f.values()) {
                spdySocket.addBytesToWriteWindow(j4);
            }
        } catch (IOException e6) {
            throw new AssertionError(e6);
        }
    }

    @Override // com.koushikdutta.async.http.spdy.FrameReader.Handler
    public void windowUpdate(int i4, long j4) {
        if (i4 == 0) {
            a(j4);
            return;
        }
        SpdySocket spdySocket = this.f35451f.get(Integer.valueOf(i4));
        if (spdySocket != null) {
            spdySocket.addBytesToWriteWindow(j4);
        }
    }

    @Override // com.koushikdutta.async.http.spdy.FrameReader.Handler
    public void priority(int i4, int i5, int i6, boolean z3) {
    }

    @Override // com.koushikdutta.async.http.spdy.FrameReader.Handler
    public void alternateService(int i4, String str, a aVar, String str2, int i5, long j4) {
    }
}
