package com.google.api.client.googleapis.services;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.api.client.googleapis.MethodOverride;
import com.google.api.client.googleapis.batch.BatchCallback;
import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GZipEncoding;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpResponseInterceptor;
import com.google.api.client.http.UriTemplate;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public abstract class AbstractGoogleClientRequest<T> extends GenericData {
    public static final String USER_AGENT_SUFFIX = "Google-API-Java-Client";

    /* renamed from: c  reason: collision with root package name */
    private final AbstractGoogleClient f25714c;

    /* renamed from: d  reason: collision with root package name */
    private final String f25715d;

    /* renamed from: e  reason: collision with root package name */
    private final String f25716e;

    /* renamed from: f  reason: collision with root package name */
    private final HttpContent f25717f;

    /* renamed from: h  reason: collision with root package name */
    private HttpHeaders f25719h;

    /* renamed from: j  reason: collision with root package name */
    private String f25721j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f25722k;

    /* renamed from: l  reason: collision with root package name */
    private Class<T> f25723l;

    /* renamed from: m  reason: collision with root package name */
    private MediaHttpUploader f25724m;

    /* renamed from: n  reason: collision with root package name */
    private MediaHttpDownloader f25725n;

    /* renamed from: g  reason: collision with root package name */
    private HttpHeaders f25718g = new HttpHeaders();

    /* renamed from: i  reason: collision with root package name */
    private int f25720i = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractGoogleClientRequest(AbstractGoogleClient abstractGoogleClient, String str, String str2, HttpContent httpContent, Class<T> cls) {
        this.f25723l = (Class) Preconditions.checkNotNull(cls);
        this.f25714c = (AbstractGoogleClient) Preconditions.checkNotNull(abstractGoogleClient);
        this.f25715d = (String) Preconditions.checkNotNull(str);
        this.f25716e = (String) Preconditions.checkNotNull(str2);
        this.f25717f = httpContent;
        String applicationName = abstractGoogleClient.getApplicationName();
        if (applicationName != null) {
            HttpHeaders httpHeaders = this.f25718g;
            StringBuilder sb = new StringBuilder(applicationName.length() + 1 + USER_AGENT_SUFFIX.length());
            sb.append(applicationName);
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(USER_AGENT_SUFFIX);
            httpHeaders.setUserAgent(sb.toString());
            return;
        }
        this.f25718g.setUserAgent(USER_AGENT_SUFFIX);
    }

    private HttpRequest a(boolean z3) throws IOException {
        boolean z4;
        String str;
        boolean z5 = true;
        if (this.f25724m == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkArgument(z4);
        if (z3 && !this.f25715d.equals("GET")) {
            z5 = false;
        }
        Preconditions.checkArgument(z5);
        if (z3) {
            str = "HEAD";
        } else {
            str = this.f25715d;
        }
        final HttpRequest buildRequest = getAbstractGoogleClient().getRequestFactory().buildRequest(str, buildHttpRequestUrl(), this.f25717f);
        new MethodOverride().intercept(buildRequest);
        buildRequest.setParser(getAbstractGoogleClient().getObjectParser());
        if (this.f25717f == null && (this.f25715d.equals("POST") || this.f25715d.equals("PUT") || this.f25715d.equals(HttpMethods.PATCH))) {
            buildRequest.setContent(new EmptyContent());
        }
        buildRequest.getHeaders().putAll(this.f25718g);
        if (!this.f25722k) {
            buildRequest.setEncoding(new GZipEncoding());
        }
        final HttpResponseInterceptor responseInterceptor = buildRequest.getResponseInterceptor();
        buildRequest.setResponseInterceptor(new HttpResponseInterceptor() { // from class: com.google.api.client.googleapis.services.AbstractGoogleClientRequest.1
            @Override // com.google.api.client.http.HttpResponseInterceptor
            public void interceptResponse(HttpResponse httpResponse) throws IOException {
                HttpResponseInterceptor httpResponseInterceptor = responseInterceptor;
                if (httpResponseInterceptor != null) {
                    httpResponseInterceptor.interceptResponse(httpResponse);
                }
                if (!httpResponse.isSuccessStatusCode() && buildRequest.getThrowExceptionOnExecuteError()) {
                    throw AbstractGoogleClientRequest.this.f(httpResponse);
                }
            }
        });
        return buildRequest;
    }

    private HttpResponse d(boolean z3) throws IOException {
        HttpResponse upload;
        if (this.f25724m == null) {
            upload = a(z3).execute();
        } else {
            GenericUrl buildHttpRequestUrl = buildHttpRequestUrl();
            boolean throwExceptionOnExecuteError = getAbstractGoogleClient().getRequestFactory().buildRequest(this.f25715d, buildHttpRequestUrl, this.f25717f).getThrowExceptionOnExecuteError();
            upload = this.f25724m.setInitiationHeaders(this.f25718g).setDisableGZipContent(this.f25722k).upload(buildHttpRequestUrl);
            upload.getRequest().setParser(getAbstractGoogleClient().getObjectParser());
            if (throwExceptionOnExecuteError && !upload.isSuccessStatusCode()) {
                throw f(upload);
            }
        }
        this.f25719h = upload.getHeaders();
        this.f25720i = upload.getStatusCode();
        this.f25721j = upload.getStatusMessage();
        return upload;
    }

    public HttpRequest buildHttpRequest() throws IOException {
        return a(false);
    }

    public GenericUrl buildHttpRequestUrl() {
        return new GenericUrl(UriTemplate.expand(this.f25714c.getBaseUrl(), this.f25716e, this, true));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpRequest buildHttpRequestUsingHead() throws IOException {
        return a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(Object obj, String str) {
        boolean z3;
        if (!this.f25714c.getSuppressRequiredParameterChecks() && obj == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        Preconditions.checkArgument(z3, "Required parameter %s must be specified", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e(AbstractInputStreamContent abstractInputStreamContent) {
        HttpRequestFactory requestFactory = this.f25714c.getRequestFactory();
        MediaHttpUploader mediaHttpUploader = new MediaHttpUploader(abstractInputStreamContent, requestFactory.getTransport(), requestFactory.getInitializer());
        this.f25724m = mediaHttpUploader;
        mediaHttpUploader.setInitiationRequestMethod(this.f25715d);
        HttpContent httpContent = this.f25717f;
        if (httpContent != null) {
            this.f25724m.setMetadata(httpContent);
        }
    }

    public T execute() throws IOException {
        return (T) executeUnparsed().parseAs((Class<Object>) this.f25723l);
    }

    public void executeAndDownloadTo(OutputStream outputStream) throws IOException {
        executeUnparsed().download(outputStream);
    }

    public InputStream executeAsInputStream() throws IOException {
        return executeUnparsed().getContent();
    }

    public HttpResponse executeUnparsed() throws IOException {
        return d(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpResponse executeUsingHead() throws IOException {
        boolean z3;
        if (this.f25724m == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        HttpResponse d4 = d(true);
        d4.ignore();
        return d4;
    }

    protected IOException f(HttpResponse httpResponse) {
        return new HttpResponseException(httpResponse);
    }

    public AbstractGoogleClient getAbstractGoogleClient() {
        return this.f25714c;
    }

    public final boolean getDisableGZipContent() {
        return this.f25722k;
    }

    public final HttpContent getHttpContent() {
        return this.f25717f;
    }

    public final HttpHeaders getLastResponseHeaders() {
        return this.f25719h;
    }

    public final int getLastStatusCode() {
        return this.f25720i;
    }

    public final String getLastStatusMessage() {
        return this.f25721j;
    }

    public final MediaHttpDownloader getMediaHttpDownloader() {
        return this.f25725n;
    }

    public final MediaHttpUploader getMediaHttpUploader() {
        return this.f25724m;
    }

    public final HttpHeaders getRequestHeaders() {
        return this.f25718g;
    }

    public final String getRequestMethod() {
        return this.f25715d;
    }

    public final Class<T> getResponseClass() {
        return this.f25723l;
    }

    public final String getUriTemplate() {
        return this.f25716e;
    }

    public final <E> void queue(BatchRequest batchRequest, Class<E> cls, BatchCallback<T, E> batchCallback) throws IOException {
        boolean z3;
        if (this.f25724m == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Batching media requests is not supported");
        batchRequest.queue(buildHttpRequest(), getResponseClass(), cls, batchCallback);
    }

    public AbstractGoogleClientRequest<T> setDisableGZipContent(boolean z3) {
        this.f25722k = z3;
        return this;
    }

    public AbstractGoogleClientRequest<T> setRequestHeaders(HttpHeaders httpHeaders) {
        this.f25718g = httpHeaders;
        return this;
    }

    @Override // com.google.api.client.util.GenericData
    public AbstractGoogleClientRequest<T> set(String str, Object obj) {
        return (AbstractGoogleClientRequest) super.set(str, obj);
    }
}
