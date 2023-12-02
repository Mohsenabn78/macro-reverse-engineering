package com.koushikdutta.ion.loader;

import android.text.TextUtils;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.HttpUtil;
import com.koushikdutta.async.http.cache.ResponseCacheMiddleware;
import com.koushikdutta.async.http.callback.HttpConnectCallback;
import com.koushikdutta.ion.HeadersResponse;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Loader;
import com.koushikdutta.ion.ResponseServedFrom;

/* loaded from: classes6.dex */
public class HttpLoader extends SimpleLoader {

    /* loaded from: classes6.dex */
    class a implements HttpConnectCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FutureCallback f36038a;

        a(FutureCallback futureCallback) {
            this.f36038a = futureCallback;
        }

        @Override // com.koushikdutta.async.http.callback.HttpConnectCallback
        public void onConnectCompleted(Exception exc, AsyncHttpResponse asyncHttpResponse) {
            long j4;
            ResponseServedFrom responseServedFrom;
            HeadersResponse headersResponse;
            AsyncHttpRequest asyncHttpRequest;
            ResponseServedFrom responseServedFrom2 = ResponseServedFrom.LOADED_FROM_NETWORK;
            if (asyncHttpResponse != null) {
                AsyncHttpRequest request = asyncHttpResponse.getRequest();
                HeadersResponse headersResponse2 = new HeadersResponse(asyncHttpResponse.code(), asyncHttpResponse.message(), asyncHttpResponse.headers());
                j4 = HttpUtil.contentLength(headersResponse2.getHeaders());
                String str = asyncHttpResponse.headers().get(ResponseCacheMiddleware.SERVED_FROM);
                if (TextUtils.equals(str, ResponseCacheMiddleware.CACHE)) {
                    responseServedFrom2 = ResponseServedFrom.LOADED_FROM_CACHE;
                } else if (TextUtils.equals(str, ResponseCacheMiddleware.CONDITIONAL_CACHE)) {
                    responseServedFrom2 = ResponseServedFrom.LOADED_FROM_CONDITIONAL_CACHE;
                }
                responseServedFrom = responseServedFrom2;
                asyncHttpRequest = request;
                headersResponse = headersResponse2;
            } else {
                j4 = -1;
                responseServedFrom = responseServedFrom2;
                headersResponse = null;
                asyncHttpRequest = null;
            }
            this.f36038a.onCompleted(exc, new Loader.LoaderEmitter(asyncHttpResponse, j4, responseServedFrom, headersResponse, asyncHttpRequest));
        }
    }

    @Override // com.koushikdutta.ion.loader.SimpleLoader, com.koushikdutta.ion.Loader
    public Future<DataEmitter> load(Ion ion, AsyncHttpRequest asyncHttpRequest, FutureCallback<Loader.LoaderEmitter> futureCallback) {
        if (!asyncHttpRequest.getUri().getScheme().startsWith("http")) {
            return null;
        }
        return ion.getHttpClient().execute(asyncHttpRequest, new a(futureCallback));
    }
}
