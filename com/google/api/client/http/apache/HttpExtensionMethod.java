package com.google.api.client.http.apache;

import com.google.api.client.util.Preconditions;
import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

/* loaded from: classes5.dex */
final class HttpExtensionMethod extends HttpEntityEnclosingRequestBase {

    /* renamed from: a  reason: collision with root package name */
    private final String f25868a;

    public HttpExtensionMethod(String str, String str2) {
        this.f25868a = (String) Preconditions.checkNotNull(str);
        setURI(URI.create(str2));
    }

    @Override // org.apache.http.client.methods.HttpRequestBase, org.apache.http.client.methods.HttpUriRequest
    public String getMethod() {
        return this.f25868a;
    }
}
