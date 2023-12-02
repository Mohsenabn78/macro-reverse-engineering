package com.koushikdutta.async.http.server;

import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;
import com.koushikdutta.async.LineEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.HttpUtil;
import com.koushikdutta.async.http.Protocol;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import java.util.regex.Matcher;

/* loaded from: classes6.dex */
public abstract class AsyncHttpServerRequestImpl extends FilteredDataEmitter implements AsyncHttpServerRequest, CompletedCallback {

    /* renamed from: h  reason: collision with root package name */
    private String f35332h;

    /* renamed from: j  reason: collision with root package name */
    AsyncSocket f35334j;

    /* renamed from: k  reason: collision with root package name */
    Matcher f35335k;

    /* renamed from: n  reason: collision with root package name */
    String f35338n;

    /* renamed from: o  reason: collision with root package name */
    AsyncHttpRequestBody f35339o;

    /* renamed from: i  reason: collision with root package name */
    private Headers f35333i = new Headers();

    /* renamed from: l  reason: collision with root package name */
    private CompletedCallback f35336l = new a();

    /* renamed from: m  reason: collision with root package name */
    LineEmitter.StringCallback f35337m = new b();

    /* loaded from: classes6.dex */
    class a implements CompletedCallback {
        a() {
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            AsyncHttpServerRequestImpl.this.onCompleted(exc);
        }
    }

    /* loaded from: classes6.dex */
    class b implements LineEmitter.StringCallback {
        b() {
        }

        @Override // com.koushikdutta.async.LineEmitter.StringCallback
        public void onStringAvailable(String str) {
            try {
                if (AsyncHttpServerRequestImpl.this.f35332h == null) {
                    AsyncHttpServerRequestImpl.this.f35332h = str;
                    if (!AsyncHttpServerRequestImpl.this.f35332h.contains("HTTP/")) {
                        AsyncHttpServerRequestImpl.this.g();
                        AsyncHttpServerRequestImpl.this.f35334j.setDataCallback(null);
                    }
                } else if (!"\r".equals(str)) {
                    AsyncHttpServerRequestImpl.this.f35333i.addLine(str);
                } else {
                    AsyncHttpServerRequestImpl asyncHttpServerRequestImpl = AsyncHttpServerRequestImpl.this;
                    DataEmitter bodyDecoder = HttpUtil.getBodyDecoder(asyncHttpServerRequestImpl.f35334j, Protocol.HTTP_1_1, asyncHttpServerRequestImpl.f35333i, true);
                    AsyncHttpServerRequestImpl asyncHttpServerRequestImpl2 = AsyncHttpServerRequestImpl.this;
                    asyncHttpServerRequestImpl2.f35339o = HttpUtil.getBody(bodyDecoder, asyncHttpServerRequestImpl2.f35336l, AsyncHttpServerRequestImpl.this.f35333i);
                    AsyncHttpServerRequestImpl asyncHttpServerRequestImpl3 = AsyncHttpServerRequestImpl.this;
                    if (asyncHttpServerRequestImpl3.f35339o == null) {
                        asyncHttpServerRequestImpl3.f35339o = asyncHttpServerRequestImpl3.h(asyncHttpServerRequestImpl3.f35333i);
                        AsyncHttpServerRequestImpl asyncHttpServerRequestImpl4 = AsyncHttpServerRequestImpl.this;
                        if (asyncHttpServerRequestImpl4.f35339o == null) {
                            asyncHttpServerRequestImpl4.f35339o = new UnknownRequestBody(asyncHttpServerRequestImpl4.f35333i.get("Content-Type"));
                        }
                    }
                    AsyncHttpServerRequestImpl asyncHttpServerRequestImpl5 = AsyncHttpServerRequestImpl.this;
                    asyncHttpServerRequestImpl5.f35339o.parse(bodyDecoder, asyncHttpServerRequestImpl5.f35336l);
                    AsyncHttpServerRequestImpl.this.f();
                }
            } catch (Exception e4) {
                AsyncHttpServerRequestImpl.this.onCompleted(e4);
            }
        }
    }

    protected abstract void f();

    protected void g() {
        System.out.println("not http!");
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequest
    public AsyncHttpRequestBody getBody() {
        return this.f35339o;
    }

    @Override // com.koushikdutta.async.DataEmitterBase, com.koushikdutta.async.DataEmitter
    public DataCallback getDataCallback() {
        return this.f35334j.getDataCallback();
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequest
    public Headers getHeaders() {
        return this.f35333i;
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequest
    public Matcher getMatcher() {
        return this.f35335k;
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequest
    public String getMethod() {
        return this.f35338n;
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequest
    public AsyncSocket getSocket() {
        return this.f35334j;
    }

    public String getStatusLine() {
        return this.f35332h;
    }

    protected AsyncHttpRequestBody h(Headers headers) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(AsyncSocket asyncSocket) {
        this.f35334j = asyncSocket;
        LineEmitter lineEmitter = new LineEmitter();
        this.f35334j.setDataCallback(lineEmitter);
        lineEmitter.setLineCallback(this.f35337m);
        this.f35334j.setEndCallback(new CompletedCallback.NullCompletedCallback());
    }

    @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.DataEmitter
    public boolean isChunked() {
        return this.f35334j.isChunked();
    }

    @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.DataEmitter
    public boolean isPaused() {
        return this.f35334j.isPaused();
    }

    public void onCompleted(Exception exc) {
        a(exc);
    }

    @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.DataEmitter
    public void pause() {
        this.f35334j.pause();
    }

    @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.DataEmitter
    public void resume() {
        this.f35334j.resume();
    }

    @Override // com.koushikdutta.async.DataEmitterBase, com.koushikdutta.async.DataEmitter
    public void setDataCallback(DataCallback dataCallback) {
        this.f35334j.setDataCallback(dataCallback);
    }

    public String toString() {
        Headers headers = this.f35333i;
        if (headers == null) {
            return super.toString();
        }
        return headers.toPrefixString(this.f35332h);
    }
}
