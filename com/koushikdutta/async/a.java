package com.koushikdutta.async;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelectableChannel;

/* compiled from: ChannelWrapper.java */
/* loaded from: classes6.dex */
abstract class a implements ReadableByteChannel, ScatteringByteChannel {

    /* renamed from: a  reason: collision with root package name */
    private AbstractSelectableChannel f34849a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbstractSelectableChannel abstractSelectableChannel) throws IOException {
        abstractSelectableChannel.configureBlocking(false);
        this.f34849a = abstractSelectableChannel;
    }

    public abstract int b();

    public abstract Object c();

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f34849a.close();
    }

    public boolean d() {
        return false;
    }

    public abstract SelectionKey e(Selector selector) throws ClosedChannelException;

    public SelectionKey f(Selector selector, int i4) throws ClosedChannelException {
        return this.f34849a.register(selector, i4);
    }

    public abstract void g();

    public abstract int h(ByteBuffer[] byteBufferArr) throws IOException;

    public abstract boolean isConnected();

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.f34849a.isOpen();
    }
}
