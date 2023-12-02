package com.koushikdutta.async;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/* compiled from: SocketChannelWrapper.java */
/* loaded from: classes6.dex */
class d extends a {

    /* renamed from: b  reason: collision with root package name */
    SocketChannel f34853b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SocketChannel socketChannel) throws IOException {
        super(socketChannel);
        this.f34853b = socketChannel;
    }

    @Override // com.koushikdutta.async.a
    public int b() {
        return this.f34853b.socket().getLocalPort();
    }

    @Override // com.koushikdutta.async.a
    public Object c() {
        return this.f34853b.socket();
    }

    @Override // com.koushikdutta.async.a
    public SelectionKey e(Selector selector) throws ClosedChannelException {
        return f(selector, 8);
    }

    @Override // com.koushikdutta.async.a
    public void g() {
        try {
            this.f34853b.socket().shutdownOutput();
        } catch (Exception unused) {
        }
    }

    @Override // com.koushikdutta.async.a
    public int h(ByteBuffer[] byteBufferArr) throws IOException {
        return (int) this.f34853b.write(byteBufferArr);
    }

    @Override // com.koushikdutta.async.a
    public boolean isConnected() {
        return this.f34853b.isConnected();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        return this.f34853b.read(byteBuffer);
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr) throws IOException {
        return this.f34853b.read(byteBufferArr);
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr, int i4, int i5) throws IOException {
        return this.f34853b.read(byteBufferArr, i4, i5);
    }
}
