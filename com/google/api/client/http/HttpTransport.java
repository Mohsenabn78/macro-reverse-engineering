package com.google.api.client.http;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

/* loaded from: classes5.dex */
public abstract class HttpTransport {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f25833a = Logger.getLogger(HttpTransport.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f25834b;

    static {
        String[] strArr = {"DELETE", "GET", "POST", "PUT"};
        f25834b = strArr;
        Arrays.sort(strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpRequest a() {
        return new HttpRequest(this, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract LowLevelHttpRequest buildRequest(String str, String str2) throws IOException;

    public final HttpRequestFactory createRequestFactory() {
        return createRequestFactory(null);
    }

    public boolean supportsMethod(String str) throws IOException {
        if (Arrays.binarySearch(f25834b, str) >= 0) {
            return true;
        }
        return false;
    }

    public final HttpRequestFactory createRequestFactory(HttpRequestInitializer httpRequestInitializer) {
        return new HttpRequestFactory(this, httpRequestInitializer);
    }

    public void shutdown() throws IOException {
    }
}
