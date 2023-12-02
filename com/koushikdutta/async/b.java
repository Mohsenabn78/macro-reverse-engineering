package com.koushikdutta.async;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/* compiled from: DatagramChannelWrapper.java */
/* loaded from: classes6.dex */
class b extends a {

    /* renamed from: b  reason: collision with root package name */
    DatagramChannel f34850b;

    /* renamed from: c  reason: collision with root package name */
    InetSocketAddress f34851c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DatagramChannel datagramChannel) throws IOException {
        super(datagramChannel);
        this.f34850b = datagramChannel;
    }

    @Override // com.koushikdutta.async.a
    public int b() {
        return this.f34850b.socket().getLocalPort();
    }

    @Override // com.koushikdutta.async.a
    public Object c() {
        return this.f34850b.socket();
    }

    @Override // com.koushikdutta.async.a
    public boolean d() {
        return true;
    }

    @Override // com.koushikdutta.async.a
    public SelectionKey e(Selector selector) throws ClosedChannelException {
        return f(selector, 1);
    }

    @Override // com.koushikdutta.async.a
    public SelectionKey f(Selector selector, int i4) throws ClosedChannelException {
        return this.f34850b.register(selector, i4);
    }

    @Override // com.koushikdutta.async.a
    public int h(ByteBuffer[] byteBufferArr) throws IOException {
        return (int) this.f34850b.write(byteBufferArr);
    }

    public void i() throws IOException {
        this.f34850b.disconnect();
    }

    @Override // com.koushikdutta.async.a
    public boolean isConnected() {
        return this.f34850b.isConnected();
    }

    public InetSocketAddress j() {
        return this.f34851c;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        if (!isConnected()) {
            int position = byteBuffer.position();
            InetSocketAddress inetSocketAddress = (InetSocketAddress) this.f34850b.receive(byteBuffer);
            this.f34851c = inetSocketAddress;
            if (inetSocketAddress == null) {
                return -1;
            }
            return byteBuffer.position() - position;
        }
        this.f34851c = null;
        return this.f34850b.read(byteBuffer);
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr) throws IOException {
        return this.f34850b.read(byteBufferArr);
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr, int i4, int i5) throws IOException {
        return this.f34850b.read(byteBufferArr, i4, i5);
    }

    @Override // com.koushikdutta.async.a
    public void g() {
    }
}
