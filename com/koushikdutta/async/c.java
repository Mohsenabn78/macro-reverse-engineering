package com.koushikdutta.async;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/* compiled from: ServerSocketChannelWrapper.java */
/* loaded from: classes6.dex */
class c extends a {

    /* renamed from: b  reason: collision with root package name */
    ServerSocketChannel f34852b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ServerSocketChannel serverSocketChannel) throws IOException {
        super(serverSocketChannel);
        this.f34852b = serverSocketChannel;
    }

    @Override // com.koushikdutta.async.a
    public int b() {
        return this.f34852b.socket().getLocalPort();
    }

    @Override // com.koushikdutta.async.a
    public Object c() {
        return this.f34852b.socket();
    }

    @Override // com.koushikdutta.async.a
    public SelectionKey e(Selector selector) throws ClosedChannelException {
        return this.f34852b.register(selector, 16);
    }

    @Override // com.koushikdutta.async.a
    public int h(ByteBuffer[] byteBufferArr) throws IOException {
        throw new IOException("Can't write ServerSocketChannel");
    }

    @Override // com.koushikdutta.async.a
    public boolean isConnected() {
        return false;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        throw new IOException("Can't read ServerSocketChannel");
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr) throws IOException {
        throw new IOException("Can't read ServerSocketChannel");
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr, int i4, int i5) throws IOException {
        throw new IOException("Can't read ServerSocketChannel");
    }

    @Override // com.koushikdutta.async.a
    public void g() {
    }
}
