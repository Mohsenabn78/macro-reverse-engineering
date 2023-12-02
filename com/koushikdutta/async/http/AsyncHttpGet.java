package com.koushikdutta.async.http;

import android.net.Uri;

/* loaded from: classes6.dex */
public class AsyncHttpGet extends AsyncHttpRequest {
    public static final String METHOD = "GET";

    public AsyncHttpGet(String str) {
        super(Uri.parse(str), "GET");
    }

    public AsyncHttpGet(Uri uri) {
        super(uri, "GET");
    }
}
