package com.koushikdutta.ion;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;

/* compiled from: RequestBodyUploadObserver.java */
/* loaded from: classes6.dex */
class o implements AsyncHttpRequestBody {

    /* renamed from: a  reason: collision with root package name */
    AsyncHttpRequestBody f36093a;

    /* renamed from: b  reason: collision with root package name */
    ProgressCallback f36094b;

    /* compiled from: RequestBodyUploadObserver.java */
    /* loaded from: classes6.dex */
    class a implements DataSink {

        /* renamed from: a  reason: collision with root package name */
        int f36095a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DataSink f36096b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f36097c;

        a(DataSink dataSink, int i4) {
            this.f36096b = dataSink;
            this.f36097c = i4;
        }

        @Override // com.koushikdutta.async.DataSink
        public void end() {
            this.f36096b.end();
        }

        @Override // com.koushikdutta.async.DataSink
        public CompletedCallback getClosedCallback() {
            return this.f36096b.getClosedCallback();
        }

        @Override // com.koushikdutta.async.DataSink
        public AsyncServer getServer() {
            return this.f36096b.getServer();
        }

        @Override // com.koushikdutta.async.DataSink
        public WritableCallback getWriteableCallback() {
            return this.f36096b.getWriteableCallback();
        }

        @Override // com.koushikdutta.async.DataSink
        public boolean isOpen() {
            return this.f36096b.isOpen();
        }

        @Override // com.koushikdutta.async.DataSink
        public void setClosedCallback(CompletedCallback completedCallback) {
            this.f36096b.setClosedCallback(completedCallback);
        }

        @Override // com.koushikdutta.async.DataSink
        public void setWriteableCallback(WritableCallback writableCallback) {
            this.f36096b.setWriteableCallback(writableCallback);
        }

        @Override // com.koushikdutta.async.DataSink
        public void write(ByteBufferList byteBufferList) {
            int remaining = byteBufferList.remaining();
            this.f36096b.write(byteBufferList);
            int remaining2 = this.f36095a + (remaining - byteBufferList.remaining());
            this.f36095a = remaining2;
            o.this.f36094b.onProgress(remaining2, this.f36097c);
        }
    }

    public o(AsyncHttpRequestBody asyncHttpRequestBody, ProgressCallback progressCallback) {
        this.f36093a = asyncHttpRequestBody;
        this.f36094b = progressCallback;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public Object get() {
        return this.f36093a.get();
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public String getContentType() {
        return this.f36093a.getContentType();
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public int length() {
        return this.f36093a.length();
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void parse(DataEmitter dataEmitter, CompletedCallback completedCallback) {
        this.f36093a.parse(dataEmitter, completedCallback);
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public boolean readFullyOnRequest() {
        return this.f36093a.readFullyOnRequest();
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        this.f36093a.write(asyncHttpRequest, new a(dataSink, this.f36093a.length()), completedCallback);
    }
}
