package com.koushikdutta.async;

import com.koushikdutta.async.DataTrackingEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.wrapper.DataEmitterWrapper;

/* loaded from: classes6.dex */
public class FilteredDataEmitter extends DataEmitterBase implements DataCallback, DataEmitterWrapper, DataTrackingEmitter {

    /* renamed from: d  reason: collision with root package name */
    private DataEmitter f34782d;

    /* renamed from: e  reason: collision with root package name */
    private DataTrackingEmitter.DataTracker f34783e;

    /* renamed from: f  reason: collision with root package name */
    private int f34784f;

    /* renamed from: g  reason: collision with root package name */
    boolean f34785g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements CompletedCallback {
        a() {
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            FilteredDataEmitter.this.a(exc);
        }
    }

    @Override // com.koushikdutta.async.DataEmitterBase, com.koushikdutta.async.DataEmitter
    public String charset() {
        DataEmitter dataEmitter = this.f34782d;
        if (dataEmitter == null) {
            return null;
        }
        return dataEmitter.charset();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void close() {
        this.f34785g = true;
        DataEmitter dataEmitter = this.f34782d;
        if (dataEmitter != null) {
            dataEmitter.close();
        }
    }

    @Override // com.koushikdutta.async.DataTrackingEmitter
    public int getBytesRead() {
        return this.f34784f;
    }

    @Override // com.koushikdutta.async.wrapper.DataEmitterWrapper
    public DataEmitter getDataEmitter() {
        return this.f34782d;
    }

    @Override // com.koushikdutta.async.DataTrackingEmitter
    public DataTrackingEmitter.DataTracker getDataTracker() {
        return this.f34783e;
    }

    @Override // com.koushikdutta.async.DataEmitter, com.koushikdutta.async.DataSink
    public AsyncServer getServer() {
        return this.f34782d.getServer();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public boolean isChunked() {
        return this.f34782d.isChunked();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public boolean isPaused() {
        return this.f34782d.isPaused();
    }

    @Override // com.koushikdutta.async.callback.DataCallback
    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        if (this.f34785g) {
            byteBufferList.recycle();
            return;
        }
        if (byteBufferList != null) {
            this.f34784f += byteBufferList.remaining();
        }
        Util.emitAllData(this, byteBufferList);
        if (byteBufferList != null) {
            this.f34784f -= byteBufferList.remaining();
        }
        DataTrackingEmitter.DataTracker dataTracker = this.f34783e;
        if (dataTracker != null && byteBufferList != null) {
            dataTracker.onData(this.f34784f);
        }
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void pause() {
        this.f34782d.pause();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void resume() {
        this.f34782d.resume();
    }

    @Override // com.koushikdutta.async.DataTrackingEmitter
    public void setDataEmitter(DataEmitter dataEmitter) {
        DataEmitter dataEmitter2 = this.f34782d;
        if (dataEmitter2 != null) {
            dataEmitter2.setDataCallback(null);
        }
        this.f34782d = dataEmitter;
        dataEmitter.setDataCallback(this);
        this.f34782d.setEndCallback(new a());
    }

    @Override // com.koushikdutta.async.DataTrackingEmitter
    public void setDataTracker(DataTrackingEmitter.DataTracker dataTracker) {
        this.f34783e = dataTracker;
    }
}
