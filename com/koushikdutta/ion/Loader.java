package com.koushikdutta.ion;

import android.content.Context;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.future.ResponseFuture;
import java.lang.reflect.Type;

/* loaded from: classes6.dex */
public interface Loader {

    /* loaded from: classes6.dex */
    public static class LoaderEmitter {

        /* renamed from: a  reason: collision with root package name */
        DataEmitter f35769a;

        /* renamed from: b  reason: collision with root package name */
        long f35770b;

        /* renamed from: c  reason: collision with root package name */
        ResponseServedFrom f35771c;

        /* renamed from: d  reason: collision with root package name */
        HeadersResponse f35772d;

        /* renamed from: e  reason: collision with root package name */
        AsyncHttpRequest f35773e;

        public LoaderEmitter(DataEmitter dataEmitter, long j4, ResponseServedFrom responseServedFrom, HeadersResponse headersResponse, AsyncHttpRequest asyncHttpRequest) {
            this.f35770b = j4;
            this.f35769a = dataEmitter;
            this.f35771c = responseServedFrom;
            this.f35772d = headersResponse;
            this.f35773e = asyncHttpRequest;
        }

        public DataEmitter getDataEmitter() {
            return this.f35769a;
        }

        public HeadersResponse getHeaders() {
            return this.f35772d;
        }

        public AsyncHttpRequest getRequest() {
            return this.f35773e;
        }

        public ResponseServedFrom getServedFrom() {
            return this.f35771c;
        }

        public long length() {
            return this.f35770b;
        }
    }

    Future<DataEmitter> load(Ion ion, AsyncHttpRequest asyncHttpRequest, FutureCallback<LoaderEmitter> futureCallback);

    <T> ResponseFuture<T> load(Ion ion, AsyncHttpRequest asyncHttpRequest, Type type);

    Future<BitmapInfo> loadBitmap(Context context, Ion ion, String str, String str2, int i4, int i5, boolean z3);

    Future<AsyncHttpRequest> resolve(Context context, Ion ion, AsyncHttpRequest asyncHttpRequest);
}
