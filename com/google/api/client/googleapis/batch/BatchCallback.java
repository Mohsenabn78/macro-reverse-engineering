package com.google.api.client.googleapis.batch;

import com.google.api.client.http.HttpHeaders;
import java.io.IOException;

/* loaded from: classes5.dex */
public interface BatchCallback<T, E> {
    void onFailure(E e4, HttpHeaders httpHeaders) throws IOException;

    void onSuccess(T t3, HttpHeaders httpHeaders) throws IOException;
}
