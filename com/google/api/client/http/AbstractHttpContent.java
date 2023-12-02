package com.google.api.client.http;

import com.google.api.client.util.Charsets;
import com.google.api.client.util.IOUtils;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes5.dex */
public abstract class AbstractHttpContent implements HttpContent {

    /* renamed from: a  reason: collision with root package name */
    private HttpMediaType f25748a;

    /* renamed from: b  reason: collision with root package name */
    private long f25749b;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractHttpContent(String str) {
        this(str == null ? null : new HttpMediaType(str));
    }

    public static long computeLength(HttpContent httpContent) throws IOException {
        if (!httpContent.retrySupported()) {
            return -1L;
        }
        return IOUtils.computeLength(httpContent);
    }

    protected long a() throws IOException {
        return computeLength(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Charset b() {
        HttpMediaType httpMediaType = this.f25748a;
        if (httpMediaType != null && httpMediaType.getCharsetParameter() != null) {
            return this.f25748a.getCharsetParameter();
        }
        return Charsets.UTF_8;
    }

    @Override // com.google.api.client.http.HttpContent
    public long getLength() throws IOException {
        if (this.f25749b == -1) {
            this.f25749b = a();
        }
        return this.f25749b;
    }

    public final HttpMediaType getMediaType() {
        return this.f25748a;
    }

    @Override // com.google.api.client.http.HttpContent
    public String getType() {
        HttpMediaType httpMediaType = this.f25748a;
        if (httpMediaType == null) {
            return null;
        }
        return httpMediaType.build();
    }

    @Override // com.google.api.client.http.HttpContent
    public boolean retrySupported() {
        return true;
    }

    public AbstractHttpContent setMediaType(HttpMediaType httpMediaType) {
        this.f25748a = httpMediaType;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractHttpContent(HttpMediaType httpMediaType) {
        this.f25749b = -1L;
        this.f25748a = httpMediaType;
    }
}
