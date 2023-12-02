package com.koushikdutta.ion.mock;

import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.ion.HeadersResponse;
import com.koushikdutta.ion.Response;
import com.koushikdutta.ion.ResponseServedFrom;
import com.koushikdutta.ion.future.ResponseFuture;

/* loaded from: classes6.dex */
public class MockResponseFuture<T> extends SimpleFuture<T> implements ResponseFuture<T> {

    /* renamed from: i  reason: collision with root package name */
    private AsyncHttpRequest f36089i;

    /* loaded from: classes6.dex */
    class a implements FutureCallback<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SimpleFuture f36090a;

        a(SimpleFuture simpleFuture) {
            this.f36090a = simpleFuture;
        }

        @Override // com.koushikdutta.async.future.FutureCallback
        public void onCompleted(Exception exc, T t3) {
            this.f36090a.setComplete((SimpleFuture) MockResponseFuture.this.m(exc, t3));
        }
    }

    public MockResponseFuture(AsyncHttpRequest asyncHttpRequest) {
        this.f36089i = asyncHttpRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Response<T> m(Exception exc, T t3) {
        return new Response<>(this.f36089i, ResponseServedFrom.LOADED_FROM_NETWORK, l(), exc, t3);
    }

    protected Headers k() {
        return new Headers();
    }

    protected HeadersResponse l() {
        return new HeadersResponse(200, "OK", k());
    }

    @Override // com.koushikdutta.ion.future.ResponseFuture
    public Future<Response<T>> withResponse() {
        SimpleFuture simpleFuture = new SimpleFuture();
        setCallback((FutureCallback) new a(simpleFuture));
        simpleFuture.setParent((Cancellable) this);
        return simpleFuture;
    }
}
