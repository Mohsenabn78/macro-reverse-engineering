package com.koushikdutta.async.http;

import android.net.Uri;

/* loaded from: classes6.dex */
public class AsyncHttpPut extends AsyncHttpRequest {
    public static final String METHOD = "PUT";

    public AsyncHttpPut(String str) {
        this(Uri.parse(str));
    }

    public AsyncHttpPut(Uri uri) {
        super(uri, "PUT");
    }
}
