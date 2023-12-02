package com.google.api.client.http.javanet;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/* loaded from: classes5.dex */
final class NetHttpRequest extends LowLevelHttpRequest {

    /* renamed from: e  reason: collision with root package name */
    private final HttpURLConnection f25871e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NetHttpRequest(HttpURLConnection httpURLConnection) {
        this.f25871e = httpURLConnection;
        httpURLConnection.setInstanceFollowRedirects(false);
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public void addHeader(String str, String str2) {
        this.f25871e.addRequestProperty(str, str2);
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public LowLevelHttpResponse execute() throws IOException {
        boolean z3;
        HttpURLConnection httpURLConnection = this.f25871e;
        if (getStreamingContent() != null) {
            String contentType = getContentType();
            if (contentType != null) {
                addHeader("Content-Type", contentType);
            }
            String contentEncoding = getContentEncoding();
            if (contentEncoding != null) {
                addHeader("Content-Encoding", contentEncoding);
            }
            long contentLength = getContentLength();
            int i4 = (contentLength > 0L ? 1 : (contentLength == 0L ? 0 : -1));
            if (i4 >= 0) {
                addHeader("Content-Length", Long.toString(contentLength));
            }
            String requestMethod = httpURLConnection.getRequestMethod();
            if (!"POST".equals(requestMethod) && !"PUT".equals(requestMethod)) {
                if (i4 == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkArgument(z3, "%s with non-zero content length is not supported", requestMethod);
            } else {
                httpURLConnection.setDoOutput(true);
                if (i4 >= 0 && contentLength <= 2147483647L) {
                    httpURLConnection.setFixedLengthStreamingMode((int) contentLength);
                } else {
                    httpURLConnection.setChunkedStreamingMode(0);
                }
                OutputStream outputStream = httpURLConnection.getOutputStream();
                try {
                    getStreamingContent().writeTo(outputStream);
                    try {
                    } catch (IOException e4) {
                        throw e4;
                    }
                } finally {
                    try {
                        outputStream.close();
                    } catch (IOException unused) {
                    }
                }
            }
        }
        try {
            httpURLConnection.connect();
            return new NetHttpResponse(httpURLConnection);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public void setTimeout(int i4, int i5) {
        this.f25871e.setReadTimeout(i5);
        this.f25871e.setConnectTimeout(i4);
    }
}
