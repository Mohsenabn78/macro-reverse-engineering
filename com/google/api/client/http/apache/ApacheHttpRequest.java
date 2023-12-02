package com.google.api.client.http.apache;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* loaded from: classes5.dex */
final class ApacheHttpRequest extends LowLevelHttpRequest {

    /* renamed from: e  reason: collision with root package name */
    private final HttpClient f25857e;

    /* renamed from: f  reason: collision with root package name */
    private final HttpRequestBase f25858f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ApacheHttpRequest(HttpClient httpClient, HttpRequestBase httpRequestBase) {
        this.f25857e = httpClient;
        this.f25858f = httpRequestBase;
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public void addHeader(String str, String str2) {
        this.f25858f.addHeader(str, str2);
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public LowLevelHttpResponse execute() throws IOException {
        if (getStreamingContent() != null) {
            HttpRequestBase httpRequestBase = this.f25858f;
            Preconditions.checkArgument(httpRequestBase instanceof HttpEntityEnclosingRequest, "Apache HTTP client does not support %s requests with content.", httpRequestBase.getRequestLine().getMethod());
            ContentEntity contentEntity = new ContentEntity(getContentLength(), getStreamingContent());
            contentEntity.setContentEncoding(getContentEncoding());
            contentEntity.setContentType(getContentType());
            ((HttpEntityEnclosingRequest) this.f25858f).setEntity(contentEntity);
        }
        HttpRequestBase httpRequestBase2 = this.f25858f;
        return new ApacheHttpResponse(httpRequestBase2, this.f25857e.execute(httpRequestBase2));
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public void setTimeout(int i4, int i5) throws IOException {
        HttpParams params = this.f25858f.getParams();
        ConnManagerParams.setTimeout(params, i4);
        HttpConnectionParams.setConnectionTimeout(params, i4);
        HttpConnectionParams.setSoTimeout(params, i5);
    }
}
