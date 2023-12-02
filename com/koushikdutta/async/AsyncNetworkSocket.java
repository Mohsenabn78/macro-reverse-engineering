package com.koushikdutta.async;

import android.util.Log;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.util.Allocator;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/* loaded from: classes6.dex */
public class AsyncNetworkSocket implements AsyncSocket {

    /* renamed from: a  reason: collision with root package name */
    InetSocketAddress f34616a;

    /* renamed from: b  reason: collision with root package name */
    private com.koushikdutta.async.a f34617b;

    /* renamed from: c  reason: collision with root package name */
    private SelectionKey f34618c;

    /* renamed from: d  reason: collision with root package name */
    private AsyncServer f34619d;

    /* renamed from: f  reason: collision with root package name */
    Allocator f34621f;

    /* renamed from: g  reason: collision with root package name */
    boolean f34622g;

    /* renamed from: h  reason: collision with root package name */
    WritableCallback f34623h;

    /* renamed from: i  reason: collision with root package name */
    DataCallback f34624i;

    /* renamed from: j  reason: collision with root package name */
    CompletedCallback f34625j;

    /* renamed from: k  reason: collision with root package name */
    boolean f34626k;

    /* renamed from: l  reason: collision with root package name */
    Exception f34627l;

    /* renamed from: m  reason: collision with root package name */
    private CompletedCallback f34628m;

    /* renamed from: e  reason: collision with root package name */
    private ByteBufferList f34620e = new ByteBufferList();

    /* renamed from: n  reason: collision with root package name */
    boolean f34629n = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ByteBufferList f34630a;

        a(ByteBufferList byteBufferList) {
            this.f34630a = byteBufferList;
        }

        @Override // java.lang.Runnable
        public void run() {
            AsyncNetworkSocket.this.write(this.f34630a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AsyncNetworkSocket.this.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AsyncNetworkSocket.this.resume();
        }
    }

    private void d(int i4) throws IOException {
        if (this.f34618c.isValid()) {
            if (i4 > 0) {
                SelectionKey selectionKey = this.f34618c;
                selectionKey.interestOps(selectionKey.interestOps() | 4);
                return;
            }
            SelectionKey selectionKey2 = this.f34618c;
            selectionKey2.interestOps(selectionKey2.interestOps() & (-5));
            return;
        }
        throw new IOException(new CancelledKeyException());
    }

    private void j() {
        if (this.f34620e.hasRemaining()) {
            Util.emitAllData(this, this.f34620e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(DatagramChannel datagramChannel) throws IOException {
        this.f34617b = new com.koushikdutta.async.b(datagramChannel);
        this.f34621f = new Allocator(8192);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(SocketChannel socketChannel, InetSocketAddress inetSocketAddress) throws IOException {
        this.f34616a = inetSocketAddress;
        this.f34621f = new Allocator();
        this.f34617b = new d(socketChannel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.koushikdutta.async.a c() {
        return this.f34617b;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public String charset() {
        return null;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void close() {
        closeInternal();
        f(null);
    }

    public void closeInternal() {
        this.f34618c.cancel();
        try {
            this.f34617b.close();
        } catch (IOException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        boolean z3;
        j();
        int i4 = 0;
        if (this.f34629n) {
            return 0;
        }
        try {
            ByteBuffer allocate = this.f34621f.allocate();
            long read = this.f34617b.read(allocate);
            int i5 = (read > 0L ? 1 : (read == 0L ? 0 : -1));
            if (i5 < 0) {
                closeInternal();
                z3 = true;
            } else {
                i4 = (int) (0 + read);
                z3 = false;
            }
            if (i5 > 0) {
                this.f34621f.track(read);
                allocate.flip();
                this.f34620e.add(allocate);
                Util.emitAllData(this, this.f34620e);
            } else {
                ByteBufferList.reclaim(allocate);
            }
            if (z3) {
                h(null);
                f(null);
            }
        } catch (Exception e4) {
            closeInternal();
            h(e4);
            f(e4);
        }
        return i4;
    }

    @Override // com.koushikdutta.async.DataSink
    public void end() {
        this.f34617b.g();
    }

    protected void f(Exception exc) {
        if (this.f34622g) {
            return;
        }
        this.f34622g = true;
        CompletedCallback completedCallback = this.f34625j;
        if (completedCallback != null) {
            completedCallback.onCompleted(exc);
            this.f34625j = null;
        }
    }

    void g(Exception exc) {
        if (this.f34626k) {
            return;
        }
        this.f34626k = true;
        CompletedCallback completedCallback = this.f34628m;
        if (completedCallback != null) {
            completedCallback.onCompleted(exc);
        } else if (exc != null) {
            Log.e(AsyncServer.LOGTAG, "Unhandled exception", exc);
        }
    }

    @Override // com.koushikdutta.async.DataSink
    public CompletedCallback getClosedCallback() {
        return this.f34625j;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public DataCallback getDataCallback() {
        return this.f34624i;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public CompletedCallback getEndCallback() {
        return this.f34628m;
    }

    public int getLocalPort() {
        return this.f34617b.b();
    }

    public InetSocketAddress getRemoteAddress() {
        return this.f34616a;
    }

    @Override // com.koushikdutta.async.AsyncSocket, com.koushikdutta.async.DataEmitter, com.koushikdutta.async.DataSink
    public AsyncServer getServer() {
        return this.f34619d;
    }

    public Object getSocket() {
        return c().c();
    }

    @Override // com.koushikdutta.async.DataSink
    public WritableCallback getWriteableCallback() {
        return this.f34623h;
    }

    void h(Exception exc) {
        if (this.f34620e.hasRemaining()) {
            this.f34627l = exc;
        } else {
            g(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(AsyncServer asyncServer, SelectionKey selectionKey) {
        this.f34619d = asyncServer;
        this.f34618c = selectionKey;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public boolean isChunked() {
        return this.f34617b.d();
    }

    @Override // com.koushikdutta.async.DataSink
    public boolean isOpen() {
        if (this.f34617b.isConnected() && this.f34618c.isValid()) {
            return true;
        }
        return false;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public boolean isPaused() {
        return this.f34629n;
    }

    public void onDataWritable() {
        if (!this.f34617b.d()) {
            SelectionKey selectionKey = this.f34618c;
            selectionKey.interestOps(selectionKey.interestOps() & (-5));
        }
        WritableCallback writableCallback = this.f34623h;
        if (writableCallback != null) {
            writableCallback.onWriteable();
        }
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void pause() {
        if (this.f34619d.getAffinity() != Thread.currentThread()) {
            this.f34619d.run(new b());
        } else if (this.f34629n) {
        } else {
            this.f34629n = true;
            try {
                SelectionKey selectionKey = this.f34618c;
                selectionKey.interestOps(selectionKey.interestOps() & (-2));
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void resume() {
        if (this.f34619d.getAffinity() != Thread.currentThread()) {
            this.f34619d.run(new c());
        } else if (!this.f34629n) {
        } else {
            this.f34629n = false;
            try {
                SelectionKey selectionKey = this.f34618c;
                selectionKey.interestOps(selectionKey.interestOps() | 1);
            } catch (Exception unused) {
            }
            j();
            if (!isOpen()) {
                h(this.f34627l);
            }
        }
    }

    @Override // com.koushikdutta.async.DataSink
    public void setClosedCallback(CompletedCallback completedCallback) {
        this.f34625j = completedCallback;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void setDataCallback(DataCallback dataCallback) {
        this.f34624i = dataCallback;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void setEndCallback(CompletedCallback completedCallback) {
        this.f34628m = completedCallback;
    }

    @Override // com.koushikdutta.async.DataSink
    public void setWriteableCallback(WritableCallback writableCallback) {
        this.f34623h = writableCallback;
    }

    @Override // com.koushikdutta.async.DataSink
    public void write(ByteBufferList byteBufferList) {
        if (this.f34619d.getAffinity() != Thread.currentThread()) {
            this.f34619d.run(new a(byteBufferList));
        } else if (!this.f34617b.isConnected()) {
        } else {
            try {
                int remaining = byteBufferList.remaining();
                ByteBuffer[] allArray = byteBufferList.getAllArray();
                this.f34617b.h(allArray);
                byteBufferList.addAll(allArray);
                d(byteBufferList.remaining());
                this.f34619d.m(remaining - byteBufferList.remaining());
            } catch (IOException e4) {
                closeInternal();
                h(e4);
                f(e4);
            }
        }
    }
}
