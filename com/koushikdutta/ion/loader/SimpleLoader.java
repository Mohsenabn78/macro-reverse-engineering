package com.koushikdutta.ion.loader;

import android.content.Context;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Loader;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.future.ResponseFuture;
import java.lang.reflect.Type;

/* loaded from: classes6.dex */
public class SimpleLoader implements Loader {
    @Override // com.koushikdutta.ion.Loader
    public Future<DataEmitter> load(Ion ion, AsyncHttpRequest asyncHttpRequest, FutureCallback<Loader.LoaderEmitter> futureCallback) {
        return null;
    }

    @Override // com.koushikdutta.ion.Loader
    public Future<BitmapInfo> loadBitmap(Context context, Ion ion, String str, String str2, int i4, int i5, boolean z3) {
        return null;
    }

    @Override // com.koushikdutta.ion.Loader
    public Future<AsyncHttpRequest> resolve(Context context, Ion ion, AsyncHttpRequest asyncHttpRequest) {
        return null;
    }

    @Override // com.koushikdutta.ion.Loader
    public <T> ResponseFuture<T> load(Ion ion, AsyncHttpRequest asyncHttpRequest, Type type) {
        return null;
    }
}
