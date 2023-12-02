package com.google.api.client.googleapis.batch;

import com.google.api.client.http.BackOffPolicy;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.MultipartContent;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.cli.HelpFormatter;

/* loaded from: classes5.dex */
public final class BatchRequest {

    /* renamed from: b  reason: collision with root package name */
    private final HttpRequestFactory f25603b;

    /* renamed from: a  reason: collision with root package name */
    private GenericUrl f25602a = new GenericUrl("https://www.googleapis.com/batch");

    /* renamed from: c  reason: collision with root package name */
    List<RequestInfo<?, ?>> f25604c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private Sleeper f25605d = Sleeper.DEFAULT;

    /* loaded from: classes5.dex */
    class BatchInterceptor implements HttpExecuteInterceptor {

        /* renamed from: a  reason: collision with root package name */
        private HttpExecuteInterceptor f25606a;

        BatchInterceptor(HttpExecuteInterceptor httpExecuteInterceptor) {
            this.f25606a = httpExecuteInterceptor;
        }

        @Override // com.google.api.client.http.HttpExecuteInterceptor
        public void intercept(HttpRequest httpRequest) throws IOException {
            HttpExecuteInterceptor httpExecuteInterceptor = this.f25606a;
            if (httpExecuteInterceptor != null) {
                httpExecuteInterceptor.intercept(httpRequest);
            }
            for (RequestInfo<?, ?> requestInfo : BatchRequest.this.f25604c) {
                HttpExecuteInterceptor interceptor = requestInfo.f25611d.getInterceptor();
                if (interceptor != null) {
                    interceptor.intercept(requestInfo.f25611d);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class RequestInfo<T, E> {

        /* renamed from: a  reason: collision with root package name */
        final BatchCallback<T, E> f25608a;

        /* renamed from: b  reason: collision with root package name */
        final Class<T> f25609b;

        /* renamed from: c  reason: collision with root package name */
        final Class<E> f25610c;

        /* renamed from: d  reason: collision with root package name */
        final HttpRequest f25611d;

        RequestInfo(BatchCallback<T, E> batchCallback, Class<T> cls, Class<E> cls2, HttpRequest httpRequest) {
            this.f25608a = batchCallback;
            this.f25609b = cls;
            this.f25610c = cls2;
            this.f25611d = httpRequest;
        }
    }

    public BatchRequest(HttpTransport httpTransport, HttpRequestInitializer httpRequestInitializer) {
        HttpRequestFactory createRequestFactory;
        if (httpRequestInitializer == null) {
            createRequestFactory = httpTransport.createRequestFactory();
        } else {
            createRequestFactory = httpTransport.createRequestFactory(httpRequestInitializer);
        }
        this.f25603b = createRequestFactory;
    }

    public void execute() throws IOException {
        boolean z3;
        String str;
        Preconditions.checkState(!this.f25604c.isEmpty());
        HttpRequest buildPostRequest = this.f25603b.buildPostRequest(this.f25602a, null);
        buildPostRequest.setInterceptor(new BatchInterceptor(buildPostRequest.getInterceptor()));
        int numberOfRetries = buildPostRequest.getNumberOfRetries();
        BackOffPolicy backOffPolicy = buildPostRequest.getBackOffPolicy();
        if (backOffPolicy != null) {
            backOffPolicy.reset();
        }
        do {
            if (numberOfRetries > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            MultipartContent multipartContent = new MultipartContent();
            multipartContent.getMediaType().setSubType("mixed");
            int i4 = 1;
            for (RequestInfo<?, ?> requestInfo : this.f25604c) {
                multipartContent.addPart(new MultipartContent.Part(new HttpHeaders().setAcceptEncoding(null).set("Content-ID", (Object) Integer.valueOf(i4)), new HttpRequestContent(requestInfo.f25611d)));
                i4++;
            }
            buildPostRequest.setContent(multipartContent);
            HttpResponse execute = buildPostRequest.execute();
            try {
                String valueOf = String.valueOf(execute.getMediaType().getParameter("boundary"));
                if (valueOf.length() != 0) {
                    str = HelpFormatter.DEFAULT_LONG_OPT_PREFIX.concat(valueOf);
                } else {
                    str = new String(HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
                }
                BatchUnparsedResponse batchUnparsedResponse = new BatchUnparsedResponse(execute.getContent(), str, this.f25604c, z3);
                while (batchUnparsedResponse.f25615d) {
                    batchUnparsedResponse.e();
                }
                execute.disconnect();
                List<RequestInfo<?, ?>> list = batchUnparsedResponse.f25616e;
                if (list.isEmpty()) {
                    break;
                }
                this.f25604c = list;
                if (batchUnparsedResponse.f25617f && backOffPolicy != null) {
                    long nextBackOffMillis = backOffPolicy.getNextBackOffMillis();
                    if (nextBackOffMillis != -1) {
                        try {
                            this.f25605d.sleep(nextBackOffMillis);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
                numberOfRetries--;
            } catch (Throwable th) {
                execute.disconnect();
                throw th;
            }
        } while (z3);
        this.f25604c.clear();
    }

    public GenericUrl getBatchUrl() {
        return this.f25602a;
    }

    public Sleeper getSleeper() {
        return this.f25605d;
    }

    public <T, E> BatchRequest queue(HttpRequest httpRequest, Class<T> cls, Class<E> cls2, BatchCallback<T, E> batchCallback) throws IOException {
        Preconditions.checkNotNull(httpRequest);
        Preconditions.checkNotNull(batchCallback);
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(cls2);
        this.f25604c.add(new RequestInfo<>(batchCallback, cls, cls2, httpRequest));
        return this;
    }

    public BatchRequest setBatchUrl(GenericUrl genericUrl) {
        this.f25602a = genericUrl;
        return this;
    }

    public BatchRequest setSleeper(Sleeper sleeper) {
        this.f25605d = (Sleeper) Preconditions.checkNotNull(sleeper);
        return this;
    }

    public int size() {
        return this.f25604c.size();
    }
}
