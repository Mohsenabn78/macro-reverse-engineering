package com.koushikdutta.ion.loader;

import android.net.Uri;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.Headers;

/* loaded from: classes6.dex */
public interface AsyncHttpRequestFactory {
    AsyncHttpRequest createAsyncHttpRequest(Uri uri, String str, Headers headers);
}
