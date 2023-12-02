package com.koushikdutta.async;

import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;

/* loaded from: classes6.dex */
public class BufferedDataEmitter implements DataEmitter {

    /* renamed from: a  reason: collision with root package name */
    DataEmitter f34741a;

    /* renamed from: c  reason: collision with root package name */
    Exception f34743c;

    /* renamed from: e  reason: collision with root package name */
    DataCallback f34745e;

    /* renamed from: f  reason: collision with root package name */
    CompletedCallback f34746f;

    /* renamed from: b  reason: collision with root package name */
    boolean f34742b = false;

    /* renamed from: d  reason: collision with root package name */
    ByteBufferList f34744d = new ByteBufferList();

    /* loaded from: classes6.dex */
    class a implements DataCallback {
        a() {
        }

        @Override // com.koushikdutta.async.callback.DataCallback
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            byteBufferList.get(BufferedDataEmitter.this.f34744d);
            BufferedDataEmitter.this.onDataAvailable();
        }
    }

    /* loaded from: classes6.dex */
    class b implements CompletedCallback {
        b() {
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            CompletedCallback completedCallback;
            BufferedDataEmitter bufferedDataEmitter = BufferedDataEmitter.this;
            bufferedDataEmitter.f34742b = true;
            bufferedDataEmitter.f34743c = exc;
            if (bufferedDataEmitter.f34744d.remaining() == 0 && (completedCallback = BufferedDataEmitter.this.f34746f) != null) {
                completedCallback.onCompleted(exc);
            }
        }
    }

    public BufferedDataEmitter(DataEmitter dataEmitter) {
        this.f34741a = dataEmitter;
        dataEmitter.setDataCallback(new a());
        this.f34741a.setEndCallback(new b());
    }

    @Override // com.koushikdutta.async.DataEmitter
    public String charset() {
        return this.f34741a.charset();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void close() {
        this.f34741a.close();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public DataCallback getDataCallback() {
        return this.f34745e;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public CompletedCallback getEndCallback() {
        return this.f34746f;
    }

    @Override // com.koushikdutta.async.DataEmitter, com.koushikdutta.async.DataSink
    public AsyncServer getServer() {
        return this.f34741a.getServer();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public boolean isChunked() {
        return false;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public boolean isPaused() {
        return this.f34741a.isPaused();
    }

    public void onDataAvailable() {
        CompletedCallback completedCallback;
        if (this.f34745e != null && !isPaused() && this.f34744d.remaining() > 0) {
            this.f34745e.onDataAvailable(this, this.f34744d);
        }
        if (this.f34742b && !this.f34744d.hasRemaining() && (completedCallback = this.f34746f) != null) {
            completedCallback.onCompleted(this.f34743c);
        }
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void pause() {
        this.f34741a.pause();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void resume() {
        this.f34741a.resume();
        onDataAvailable();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void setDataCallback(DataCallback dataCallback) {
        if (this.f34745e == null) {
            this.f34745e = dataCallback;
            return;
        }
        throw new RuntimeException("Buffered Data Emitter callback may only be set once");
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void setEndCallback(CompletedCallback completedCallback) {
        this.f34746f = completedCallback;
    }
}
