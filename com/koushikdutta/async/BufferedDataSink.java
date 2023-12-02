package com.koushikdutta.async;

import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.WritableCallback;

/* loaded from: classes6.dex */
public class BufferedDataSink implements DataSink {

    /* renamed from: a  reason: collision with root package name */
    DataSink f34749a;

    /* renamed from: b  reason: collision with root package name */
    boolean f34750b;

    /* renamed from: d  reason: collision with root package name */
    WritableCallback f34752d;

    /* renamed from: f  reason: collision with root package name */
    boolean f34754f;

    /* renamed from: c  reason: collision with root package name */
    ByteBufferList f34751c = new ByteBufferList();

    /* renamed from: e  reason: collision with root package name */
    int f34753e = Integer.MAX_VALUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements WritableCallback {
        a() {
        }

        @Override // com.koushikdutta.async.callback.WritableCallback
        public void onWriteable() {
            BufferedDataSink.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ByteBufferList f34756a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f34757b;

        b(ByteBufferList byteBufferList, boolean z3) {
            this.f34756a = byteBufferList;
            this.f34757b = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            BufferedDataSink.this.b(this.f34756a, this.f34757b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BufferedDataSink.this.end();
        }
    }

    public BufferedDataSink(DataSink dataSink) {
        setDataSink(dataSink);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        WritableCallback writableCallback;
        if (this.f34750b) {
            return;
        }
        if (this.f34751c.hasRemaining()) {
            this.f34749a.write(this.f34751c);
            if (this.f34751c.remaining() == 0 && this.f34754f) {
                this.f34749a.end();
            }
        }
        if (!this.f34751c.hasRemaining() && (writableCallback = this.f34752d) != null) {
            writableCallback.onWriteable();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ByteBufferList byteBufferList, boolean z3) {
        if (getServer().getAffinity() != Thread.currentThread()) {
            getServer().run(new b(byteBufferList, z3));
            return;
        }
        if (!isBuffering()) {
            this.f34749a.write(byteBufferList);
        }
        if (byteBufferList.remaining() > 0) {
            int min = Math.min(byteBufferList.remaining(), this.f34753e);
            if (z3) {
                min = byteBufferList.remaining();
            }
            if (min > 0) {
                byteBufferList.get(this.f34751c, min);
            }
        }
    }

    @Override // com.koushikdutta.async.DataSink
    public void end() {
        if (getServer().getAffinity() != Thread.currentThread()) {
            getServer().run(new c());
        } else if (this.f34751c.hasRemaining()) {
            this.f34754f = true;
        } else {
            this.f34749a.end();
        }
    }

    public void forceBuffering(boolean z3) {
        this.f34750b = z3;
        if (!z3) {
            c();
        }
    }

    @Override // com.koushikdutta.async.DataSink
    public CompletedCallback getClosedCallback() {
        return this.f34749a.getClosedCallback();
    }

    public DataSink getDataSink() {
        return this.f34749a;
    }

    public int getMaxBuffer() {
        return this.f34753e;
    }

    @Override // com.koushikdutta.async.DataSink
    public AsyncServer getServer() {
        return this.f34749a.getServer();
    }

    @Override // com.koushikdutta.async.DataSink
    public WritableCallback getWriteableCallback() {
        return this.f34752d;
    }

    public boolean isBuffering() {
        if (!this.f34751c.hasRemaining() && !this.f34750b) {
            return false;
        }
        return true;
    }

    @Override // com.koushikdutta.async.DataSink
    public boolean isOpen() {
        return this.f34749a.isOpen();
    }

    public int remaining() {
        return this.f34751c.remaining();
    }

    @Override // com.koushikdutta.async.DataSink
    public void setClosedCallback(CompletedCallback completedCallback) {
        this.f34749a.setClosedCallback(completedCallback);
    }

    public void setDataSink(DataSink dataSink) {
        this.f34749a = dataSink;
        dataSink.setWriteableCallback(new a());
    }

    public void setMaxBuffer(int i4) {
        this.f34753e = i4;
    }

    @Override // com.koushikdutta.async.DataSink
    public void setWriteableCallback(WritableCallback writableCallback) {
        this.f34752d = writableCallback;
    }

    @Override // com.koushikdutta.async.DataSink
    public void write(ByteBufferList byteBufferList) {
        b(byteBufferList, false);
    }
}
