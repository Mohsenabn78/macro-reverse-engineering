package com.koushikdutta.async;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class AsyncDatagramSocket extends AsyncNetworkSocket {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f34609a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f34610b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ByteBuffer f34611c;

        a(String str, int i4, ByteBuffer byteBuffer) {
            this.f34609a = str;
            this.f34610b = i4;
            this.f34611c = byteBuffer;
        }

        @Override // java.lang.Runnable
        public void run() {
            AsyncDatagramSocket.this.send(this.f34609a, this.f34610b, this.f34611c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InetSocketAddress f34613a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ByteBuffer f34614b;

        b(InetSocketAddress inetSocketAddress, ByteBuffer byteBuffer) {
            this.f34613a = inetSocketAddress;
            this.f34614b = byteBuffer;
        }

        @Override // java.lang.Runnable
        public void run() {
            AsyncDatagramSocket.this.send(this.f34613a, this.f34614b);
        }
    }

    public void connect(InetSocketAddress inetSocketAddress) throws IOException {
        this.f34616a = inetSocketAddress;
        ((com.koushikdutta.async.b) c()).f34850b.connect(inetSocketAddress);
    }

    public void disconnect() throws IOException {
        this.f34616a = null;
        ((com.koushikdutta.async.b) c()).i();
    }

    @Override // com.koushikdutta.async.AsyncNetworkSocket
    public InetSocketAddress getRemoteAddress() {
        if (isOpen()) {
            return super.getRemoteAddress();
        }
        return ((com.koushikdutta.async.b) c()).j();
    }

    public void send(String str, int i4, ByteBuffer byteBuffer) {
        if (getServer().getAffinity() != Thread.currentThread()) {
            getServer().run(new a(str, i4, byteBuffer));
            return;
        }
        try {
            ((com.koushikdutta.async.b) c()).f34850b.send(byteBuffer, new InetSocketAddress(str, i4));
        } catch (IOException unused) {
        }
    }

    public void send(InetSocketAddress inetSocketAddress, ByteBuffer byteBuffer) {
        if (getServer().getAffinity() != Thread.currentThread()) {
            getServer().run(new b(inetSocketAddress, byteBuffer));
            return;
        }
        try {
            ((com.koushikdutta.async.b) c()).f34850b.send(byteBuffer, new InetSocketAddress(inetSocketAddress.getHostName(), inetSocketAddress.getPort()));
        } catch (IOException unused) {
        }
    }
}
