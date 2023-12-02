package com.koushikdutta.ion.future;

import com.koushikdutta.async.future.Future;
import com.koushikdutta.ion.Response;

/* loaded from: classes6.dex */
public interface ResponseFuture<T> extends Future<T> {
    Future<Response<T>> withResponse();
}
