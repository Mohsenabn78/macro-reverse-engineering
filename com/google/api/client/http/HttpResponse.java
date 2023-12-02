package com.google.api.client.http;

import com.google.api.client.util.Charsets;
import com.google.api.client.util.IOUtils;
import com.google.api.client.util.LoggingInputStream;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

/* loaded from: classes5.dex */
public final class HttpResponse {

    /* renamed from: a  reason: collision with root package name */
    private InputStream f25816a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25817b;

    /* renamed from: c  reason: collision with root package name */
    private final String f25818c;

    /* renamed from: d  reason: collision with root package name */
    private final HttpMediaType f25819d;

    /* renamed from: e  reason: collision with root package name */
    LowLevelHttpResponse f25820e;

    /* renamed from: f  reason: collision with root package name */
    private final int f25821f;

    /* renamed from: g  reason: collision with root package name */
    private final String f25822g;

    /* renamed from: h  reason: collision with root package name */
    private final HttpRequest f25823h;

    /* renamed from: i  reason: collision with root package name */
    private int f25824i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f25825j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f25826k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpResponse(HttpRequest httpRequest, LowLevelHttpResponse lowLevelHttpResponse) throws IOException {
        StringBuilder sb;
        StringBuilder sb2;
        this.f25823h = httpRequest;
        this.f25824i = httpRequest.getContentLoggingLimit();
        this.f25825j = httpRequest.isLoggingEnabled();
        this.f25820e = lowLevelHttpResponse;
        this.f25817b = lowLevelHttpResponse.getContentEncoding();
        int statusCode = lowLevelHttpResponse.getStatusCode();
        boolean z3 = false;
        statusCode = statusCode < 0 ? 0 : statusCode;
        this.f25821f = statusCode;
        String reasonPhrase = lowLevelHttpResponse.getReasonPhrase();
        this.f25822g = reasonPhrase;
        Logger logger = HttpTransport.f25833a;
        if (this.f25825j && logger.isLoggable(Level.CONFIG)) {
            z3 = true;
        }
        if (z3) {
            sb = new StringBuilder();
            sb.append("-------------- RESPONSE --------------");
            String str = StringUtils.LINE_SEPARATOR;
            sb.append(str);
            String statusLine = lowLevelHttpResponse.getStatusLine();
            if (statusLine != null) {
                sb.append(statusLine);
            } else {
                sb.append(statusCode);
                if (reasonPhrase != null) {
                    sb.append(' ');
                    sb.append(reasonPhrase);
                }
            }
            sb.append(str);
        } else {
            sb = null;
        }
        HttpHeaders responseHeaders = httpRequest.getResponseHeaders();
        if (z3) {
            sb2 = sb;
        } else {
            sb2 = null;
        }
        responseHeaders.fromHttpResponse(lowLevelHttpResponse, sb2);
        String contentType = lowLevelHttpResponse.getContentType();
        contentType = contentType == null ? httpRequest.getResponseHeaders().getContentType() : contentType;
        this.f25818c = contentType;
        this.f25819d = contentType != null ? new HttpMediaType(contentType) : null;
        if (z3) {
            logger.config(sb.toString());
        }
    }

    private boolean a() throws IOException {
        int statusCode = getStatusCode();
        if (!getRequest().getRequestMethod().equals("HEAD") && statusCode / 100 != 1 && statusCode != 204 && statusCode != 304) {
            return true;
        }
        ignore();
        return false;
    }

    public void disconnect() throws IOException {
        ignore();
        this.f25820e.disconnect();
    }

    public void download(OutputStream outputStream) throws IOException {
        IOUtils.copy(getContent(), outputStream);
    }

    public InputStream getContent() throws IOException {
        if (!this.f25826k) {
            InputStream content = this.f25820e.getContent();
            if (content != null) {
                try {
                    String str = this.f25817b;
                    if (str != null && str.contains("gzip")) {
                        content = new GZIPInputStream(content);
                    }
                    Logger logger = HttpTransport.f25833a;
                    if (this.f25825j) {
                        Level level = Level.CONFIG;
                        if (logger.isLoggable(level)) {
                            content = new LoggingInputStream(content, logger, level, this.f25824i);
                        }
                    }
                    this.f25816a = content;
                } catch (EOFException unused) {
                    content.close();
                } catch (Throwable th) {
                    content.close();
                    throw th;
                }
            }
            this.f25826k = true;
        }
        return this.f25816a;
    }

    public Charset getContentCharset() {
        HttpMediaType httpMediaType = this.f25819d;
        if (httpMediaType != null && httpMediaType.getCharsetParameter() != null) {
            return this.f25819d.getCharsetParameter();
        }
        return Charsets.ISO_8859_1;
    }

    public String getContentEncoding() {
        return this.f25817b;
    }

    public int getContentLoggingLimit() {
        return this.f25824i;
    }

    public String getContentType() {
        return this.f25818c;
    }

    public HttpHeaders getHeaders() {
        return this.f25823h.getResponseHeaders();
    }

    public HttpMediaType getMediaType() {
        return this.f25819d;
    }

    public HttpRequest getRequest() {
        return this.f25823h;
    }

    public int getStatusCode() {
        return this.f25821f;
    }

    public String getStatusMessage() {
        return this.f25822g;
    }

    public HttpTransport getTransport() {
        return this.f25823h.getTransport();
    }

    public void ignore() throws IOException {
        InputStream content = getContent();
        if (content != null) {
            content.close();
        }
    }

    public boolean isLoggingEnabled() {
        return this.f25825j;
    }

    public boolean isSuccessStatusCode() {
        return HttpStatusCodes.isSuccess(this.f25821f);
    }

    public <T> T parseAs(Class<T> cls) throws IOException {
        if (a()) {
            return (T) this.f25823h.getParser().parseAndClose(getContent(), getContentCharset(), (Class<Object>) cls);
        }
        return null;
    }

    public String parseAsString() throws IOException {
        InputStream content = getContent();
        if (content == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.copy(content, byteArrayOutputStream);
        return byteArrayOutputStream.toString(getContentCharset().name());
    }

    public HttpResponse setContentLoggingLimit(int i4) {
        boolean z3;
        if (i4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "The content logging limit must be non-negative.");
        this.f25824i = i4;
        return this;
    }

    public HttpResponse setLoggingEnabled(boolean z3) {
        this.f25825j = z3;
        return this;
    }

    public Object parseAs(Type type) throws IOException {
        if (a()) {
            return this.f25823h.getParser().parseAndClose(getContent(), getContentCharset(), type);
        }
        return null;
    }
}
