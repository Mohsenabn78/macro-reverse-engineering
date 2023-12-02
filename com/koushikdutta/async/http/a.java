package com.koushikdutta.async.http;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.FilteredDataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AsyncHttpResponseImpl.java */
/* loaded from: classes6.dex */
public abstract class a extends FilteredDataEmitter implements AsyncSocket, AsyncHttpResponse, AsyncHttpClientMiddleware.ResponseHead {

    /* renamed from: i  reason: collision with root package name */
    private AsyncHttpRequest f35089i;

    /* renamed from: j  reason: collision with root package name */
    private AsyncSocket f35090j;

    /* renamed from: k  reason: collision with root package name */
    protected Headers f35091k;

    /* renamed from: m  reason: collision with root package name */
    int f35093m;

    /* renamed from: n  reason: collision with root package name */
    String f35094n;

    /* renamed from: o  reason: collision with root package name */
    String f35095o;

    /* renamed from: q  reason: collision with root package name */
    DataSink f35097q;

    /* renamed from: h  reason: collision with root package name */
    private CompletedCallback f35088h = new b();

    /* renamed from: l  reason: collision with root package name */
    boolean f35092l = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f35096p = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AsyncHttpResponseImpl.java */
    /* renamed from: com.koushikdutta.async.http.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0188a implements CompletedCallback {
        C0188a() {
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            a.this.f(exc);
        }
    }

    /* compiled from: AsyncHttpResponseImpl.java */
    /* loaded from: classes6.dex */
    class b implements CompletedCallback {
        b() {
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            if (exc != null) {
                a aVar = a.this;
                if (!aVar.f35092l) {
                    aVar.a(new ConnectionClosedException("connection closed before response completed.", exc));
                    return;
                }
            }
            a.this.a(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AsyncHttpResponseImpl.java */
    /* loaded from: classes6.dex */
    public class c extends DataCallback.NullDataCallback {
        c() {
        }

        @Override // com.koushikdutta.async.callback.DataCallback.NullDataCallback, com.koushikdutta.async.callback.DataCallback
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            super.onDataAvailable(dataEmitter, byteBufferList);
            a.this.f35090j.close();
        }
    }

    public a(AsyncHttpRequest asyncHttpRequest) {
        this.f35089i = asyncHttpRequest;
    }

    private void c() {
        if (!this.f35096p) {
            return;
        }
        this.f35096p = false;
    }

    private void h() {
        this.f35090j.setDataCallback(new c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.koushikdutta.async.DataEmitterBase
    public void a(Exception exc) {
        super.a(exc);
        h();
        this.f35090j.setWriteableCallback(null);
        this.f35090j.setClosedCallback(null);
        this.f35090j.setEndCallback(null);
        this.f35092l = true;
    }

    @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.DataEmitterBase, com.koushikdutta.async.DataEmitter
    public String charset() {
        String string;
        Multimap parseSemicolonDelimited = Multimap.parseSemicolonDelimited(headers().get("Content-Type"));
        if (parseSemicolonDelimited != null && (string = parseSemicolonDelimited.getString("charset")) != null && Charset.isSupported(string)) {
            return string;
        }
        return null;
    }

    @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.DataEmitter
    public void close() {
        super.close();
        h();
    }

    @Override // com.koushikdutta.async.http.AsyncHttpResponse, com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public int code() {
        return this.f35093m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        AsyncHttpRequestBody body = this.f35089i.getBody();
        if (body != null) {
            body.write(this.f35089i, this, new C0188a());
        } else {
            f(null);
        }
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public DataEmitter emitter() {
        return getDataEmitter();
    }

    @Override // com.koushikdutta.async.DataSink
    public void end() {
        throw new AssertionError("end called?");
    }

    protected abstract void f(Exception exc);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(AsyncSocket asyncSocket) {
        this.f35090j = asyncSocket;
        if (asyncSocket == null) {
            return;
        }
        asyncSocket.setEndCallback(this.f35088h);
    }

    @Override // com.koushikdutta.async.DataSink
    public CompletedCallback getClosedCallback() {
        return this.f35097q.getClosedCallback();
    }

    @Override // com.koushikdutta.async.http.AsyncHttpResponse
    public AsyncHttpRequest getRequest() {
        return this.f35089i;
    }

    @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.DataEmitter, com.koushikdutta.async.DataSink
    public AsyncServer getServer() {
        return this.f35090j.getServer();
    }

    @Override // com.koushikdutta.async.DataSink
    public WritableCallback getWriteableCallback() {
        return this.f35097q.getWriteableCallback();
    }

    @Override // com.koushikdutta.async.http.AsyncHttpResponse, com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public Headers headers() {
        return this.f35091k;
    }

    @Override // com.koushikdutta.async.DataSink
    public boolean isOpen() {
        return this.f35097q.isOpen();
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public AsyncHttpClientMiddleware.ResponseHead message(String str) {
        this.f35095o = str;
        return this;
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public AsyncHttpClientMiddleware.ResponseHead protocol(String str) {
        this.f35094n = str;
        return this;
    }

    @Override // com.koushikdutta.async.DataSink
    public void setClosedCallback(CompletedCallback completedCallback) {
        this.f35097q.setClosedCallback(completedCallback);
    }

    @Override // com.koushikdutta.async.DataSink
    public void setWriteableCallback(WritableCallback writableCallback) {
        this.f35097q.setWriteableCallback(writableCallback);
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public DataSink sink() {
        return this.f35097q;
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public AsyncSocket socket() {
        return this.f35090j;
    }

    public String toString() {
        Headers headers = this.f35091k;
        if (headers == null) {
            return super.toString();
        }
        return headers.toPrefixString(this.f35094n + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f35093m + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f35095o);
    }

    @Override // com.koushikdutta.async.DataSink
    public void write(ByteBufferList byteBufferList) {
        c();
        this.f35097q.write(byteBufferList);
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public AsyncHttpClientMiddleware.ResponseHead code(int i4) {
        this.f35093m = i4;
        return this;
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public AsyncHttpClientMiddleware.ResponseHead emitter(DataEmitter dataEmitter) {
        setDataEmitter(dataEmitter);
        return this;
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public AsyncHttpClientMiddleware.ResponseHead headers(Headers headers) {
        this.f35091k = headers;
        return this;
    }

    @Override // com.koushikdutta.async.http.AsyncHttpResponse, com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public String message() {
        return this.f35095o;
    }

    @Override // com.koushikdutta.async.http.AsyncHttpResponse, com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public String protocol() {
        return this.f35094n;
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public AsyncHttpClientMiddleware.ResponseHead sink(DataSink dataSink) {
        this.f35097q = dataSink;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
    }
}
