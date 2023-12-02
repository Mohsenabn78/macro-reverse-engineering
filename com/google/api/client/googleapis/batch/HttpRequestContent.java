package com.google.api.client.googleapis.batch;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.api.client.http.AbstractHttpContent;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/* loaded from: classes5.dex */
class HttpRequestContent extends AbstractHttpContent {

    /* renamed from: c  reason: collision with root package name */
    private final HttpRequest f25633c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpRequestContent(HttpRequest httpRequest) {
        super("application/http");
        this.f25633c = httpRequest;
    }

    @Override // com.google.api.client.http.HttpContent, com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, b());
        outputStreamWriter.write(this.f25633c.getRequestMethod());
        outputStreamWriter.write(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        outputStreamWriter.write(this.f25633c.getUrl().build());
        outputStreamWriter.write(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        outputStreamWriter.write("HTTP/1.1");
        outputStreamWriter.write("\r\n");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.fromHttpHeaders(this.f25633c.getHeaders());
        httpHeaders.setAcceptEncoding(null).setUserAgent(null).setContentEncoding(null).setContentType(null).setContentLength(null);
        HttpContent content = this.f25633c.getContent();
        if (content != null) {
            httpHeaders.setContentType(content.getType());
            long length = content.getLength();
            if (length != -1) {
                httpHeaders.setContentLength(Long.valueOf(length));
            }
        }
        HttpHeaders.serializeHeadersForMultipartRequests(httpHeaders, null, null, outputStreamWriter);
        outputStreamWriter.write("\r\n");
        outputStreamWriter.flush();
        if (content != null) {
            content.writeTo(outputStream);
        }
    }
}
