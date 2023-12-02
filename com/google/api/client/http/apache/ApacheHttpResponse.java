package com.google.api.client.http.apache;

import com.google.api.client.http.LowLevelHttpResponse;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpRequestBase;

/* loaded from: classes5.dex */
final class ApacheHttpResponse extends LowLevelHttpResponse {

    /* renamed from: a  reason: collision with root package name */
    private final HttpRequestBase f25859a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpResponse f25860b;

    /* renamed from: c  reason: collision with root package name */
    private final Header[] f25861c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ApacheHttpResponse(HttpRequestBase httpRequestBase, HttpResponse httpResponse) {
        this.f25859a = httpRequestBase;
        this.f25860b = httpResponse;
        this.f25861c = httpResponse.getAllHeaders();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public void disconnect() {
        this.f25859a.abort();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public InputStream getContent() throws IOException {
        HttpEntity entity = this.f25860b.getEntity();
        if (entity == null) {
            return null;
        }
        return entity.getContent();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String getContentEncoding() {
        Header contentEncoding;
        HttpEntity entity = this.f25860b.getEntity();
        if (entity != null && (contentEncoding = entity.getContentEncoding()) != null) {
            return contentEncoding.getValue();
        }
        return null;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public long getContentLength() {
        HttpEntity entity = this.f25860b.getEntity();
        if (entity == null) {
            return -1L;
        }
        return entity.getContentLength();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String getContentType() {
        Header contentType;
        HttpEntity entity = this.f25860b.getEntity();
        if (entity != null && (contentType = entity.getContentType()) != null) {
            return contentType.getValue();
        }
        return null;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public int getHeaderCount() {
        return this.f25861c.length;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String getHeaderName(int i4) {
        return this.f25861c[i4].getName();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String getHeaderValue(int i4) {
        return this.f25861c[i4].getValue();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String getReasonPhrase() {
        StatusLine statusLine = this.f25860b.getStatusLine();
        if (statusLine == null) {
            return null;
        }
        return statusLine.getReasonPhrase();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public int getStatusCode() {
        StatusLine statusLine = this.f25860b.getStatusLine();
        if (statusLine == null) {
            return 0;
        }
        return statusLine.getStatusCode();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String getStatusLine() {
        StatusLine statusLine = this.f25860b.getStatusLine();
        if (statusLine == null) {
            return null;
        }
        return statusLine.toString();
    }
}
