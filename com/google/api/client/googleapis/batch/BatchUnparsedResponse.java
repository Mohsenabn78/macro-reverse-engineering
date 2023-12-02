package com.google.api.client.googleapis.batch;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.http.BackOffPolicy;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.HttpTesting;
import com.google.api.client.util.ByteStreams;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.cli.HelpFormatter;

/* loaded from: classes5.dex */
final class BatchUnparsedResponse {

    /* renamed from: a  reason: collision with root package name */
    private final String f25612a;

    /* renamed from: b  reason: collision with root package name */
    private final List<BatchRequest.RequestInfo<?, ?>> f25613b;

    /* renamed from: c  reason: collision with root package name */
    private final InputStream f25614c;

    /* renamed from: f  reason: collision with root package name */
    boolean f25617f;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f25619h;

    /* renamed from: d  reason: collision with root package name */
    boolean f25615d = true;

    /* renamed from: e  reason: collision with root package name */
    List<BatchRequest.RequestInfo<?, ?>> f25616e = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private int f25618g = 0;

    /* loaded from: classes5.dex */
    private static class FakeLowLevelHttpResponse extends LowLevelHttpResponse {

        /* renamed from: a  reason: collision with root package name */
        private InputStream f25625a;

        /* renamed from: b  reason: collision with root package name */
        private int f25626b;

        /* renamed from: c  reason: collision with root package name */
        private List<String> f25627c;

        /* renamed from: d  reason: collision with root package name */
        private List<String> f25628d;

        FakeLowLevelHttpResponse(InputStream inputStream, int i4, List<String> list, List<String> list2) {
            this.f25627c = new ArrayList();
            new ArrayList();
            this.f25625a = inputStream;
            this.f25626b = i4;
            this.f25627c = list;
            this.f25628d = list2;
        }

        @Override // com.google.api.client.http.LowLevelHttpResponse
        public InputStream getContent() {
            return this.f25625a;
        }

        @Override // com.google.api.client.http.LowLevelHttpResponse
        public String getContentEncoding() {
            return null;
        }

        @Override // com.google.api.client.http.LowLevelHttpResponse
        public long getContentLength() {
            return 0L;
        }

        @Override // com.google.api.client.http.LowLevelHttpResponse
        public String getContentType() {
            return null;
        }

        @Override // com.google.api.client.http.LowLevelHttpResponse
        public int getHeaderCount() {
            return this.f25627c.size();
        }

        @Override // com.google.api.client.http.LowLevelHttpResponse
        public String getHeaderName(int i4) {
            return this.f25627c.get(i4);
        }

        @Override // com.google.api.client.http.LowLevelHttpResponse
        public String getHeaderValue(int i4) {
            return this.f25628d.get(i4);
        }

        @Override // com.google.api.client.http.LowLevelHttpResponse
        public String getReasonPhrase() {
            return null;
        }

        @Override // com.google.api.client.http.LowLevelHttpResponse
        public int getStatusCode() {
            return this.f25626b;
        }

        @Override // com.google.api.client.http.LowLevelHttpResponse
        public String getStatusLine() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class FakeResponseHttpTransport extends HttpTransport {

        /* renamed from: c  reason: collision with root package name */
        private int f25629c;

        /* renamed from: d  reason: collision with root package name */
        private InputStream f25630d;

        /* renamed from: e  reason: collision with root package name */
        private List<String> f25631e;

        /* renamed from: f  reason: collision with root package name */
        private List<String> f25632f;

        FakeResponseHttpTransport(int i4, InputStream inputStream, List<String> list, List<String> list2) {
            this.f25629c = i4;
            this.f25630d = inputStream;
            this.f25631e = list;
            this.f25632f = list2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.api.client.http.HttpTransport
        public LowLevelHttpRequest buildRequest(String str, String str2) {
            return new FakeLowLevelHttpRequest(this.f25630d, this.f25629c, this.f25631e, this.f25632f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BatchUnparsedResponse(InputStream inputStream, String str, List<BatchRequest.RequestInfo<?, ?>> list, boolean z3) throws IOException {
        this.f25612a = str;
        this.f25613b = list;
        this.f25619h = z3;
        this.f25614c = inputStream;
        a(f());
    }

    private void a(String str) throws IOException {
        if (str.equals(String.valueOf(this.f25612a).concat(HelpFormatter.DEFAULT_LONG_OPT_PREFIX))) {
            this.f25615d = false;
            this.f25614c.close();
        }
    }

    private HttpResponse b(int i4, InputStream inputStream, List<String> list, List<String> list2) throws IOException {
        HttpRequest buildPostRequest = new FakeResponseHttpTransport(i4, inputStream, list, list2).createRequestFactory().buildPostRequest(new GenericUrl(HttpTesting.SIMPLE_URL), null);
        buildPostRequest.setLoggingEnabled(false);
        buildPostRequest.setThrowExceptionOnExecuteError(false);
        return buildPostRequest.execute();
    }

    private <A, T, E> A c(Class<A> cls, HttpResponse httpResponse, BatchRequest.RequestInfo<T, E> requestInfo) throws IOException {
        if (cls == Void.class) {
            return null;
        }
        return (A) requestInfo.f25611d.getParser().parseAndClose(httpResponse.getContent(), httpResponse.getContentCharset(), (Class<Object>) cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T, E> void d(BatchRequest.RequestInfo<T, E> requestInfo, int i4, HttpResponse httpResponse) throws IOException {
        boolean z3;
        boolean z4;
        BatchCallback<T, E> batchCallback = requestInfo.f25608a;
        HttpHeaders headers = httpResponse.getHeaders();
        HttpUnsuccessfulResponseHandler unsuccessfulResponseHandler = requestInfo.f25611d.getUnsuccessfulResponseHandler();
        BackOffPolicy backOffPolicy = requestInfo.f25611d.getBackOffPolicy();
        boolean z5 = false;
        this.f25617f = false;
        if (HttpStatusCodes.isSuccess(i4)) {
            if (batchCallback == 0) {
                return;
            }
            batchCallback.onSuccess(c(requestInfo.f25609b, httpResponse, requestInfo), headers);
            return;
        }
        HttpContent content = requestInfo.f25611d.getContent();
        if (this.f25619h && (content == null || content.retrySupported())) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (unsuccessfulResponseHandler != null) {
            z4 = unsuccessfulResponseHandler.handleResponse(requestInfo.f25611d, httpResponse, z3);
        } else {
            z4 = false;
        }
        if (!z4) {
            if (requestInfo.f25611d.handleRedirect(httpResponse.getStatusCode(), httpResponse.getHeaders())) {
                z5 = true;
            } else if (z3 && backOffPolicy != null && backOffPolicy.isBackOffRequired(httpResponse.getStatusCode())) {
                this.f25617f = true;
            }
        }
        if (z3 && (z4 || this.f25617f || z5)) {
            this.f25616e.add(requestInfo);
        } else if (batchCallback == 0) {
        } else {
            batchCallback.onFailure(c(requestInfo.f25610c, httpResponse, requestInfo), headers);
        }
    }

    private String f() throws IOException {
        return i(g());
    }

    private String g() throws IOException {
        int read = this.f25614c.read();
        if (read == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (read != -1) {
            sb.append((char) read);
            if (read == 10) {
                break;
            }
            read = this.f25614c.read();
        }
        return sb.toString();
    }

    private static InputStream h(byte[] bArr) {
        int length = bArr.length;
        if (length > 0 && bArr[length - 1] == 10) {
            length--;
        }
        if (length > 0 && bArr[length - 1] == 13) {
            length--;
        }
        return new ByteArrayInputStream(bArr, 0, length);
    }

    private static String i(String str) {
        if (str.endsWith("\r\n")) {
            return str.substring(0, str.length() - 2);
        }
        if (str.endsWith("\n")) {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() throws IOException {
        String f4;
        String f5;
        InputStream inputStream;
        String g4;
        this.f25618g++;
        do {
            f4 = f();
            if (f4 == null) {
                break;
            }
        } while (!f4.equals(""));
        int parseInt = Integer.parseInt(f().split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)[1]);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long j4 = -1;
        while (true) {
            f5 = f();
            if (f5 == null || f5.equals("")) {
                break;
            }
            String[] split = f5.split(": ", 2);
            String str = split[0];
            String str2 = split[1];
            arrayList.add(str);
            arrayList2.add(str2);
            if ("Content-Length".equalsIgnoreCase(str.trim())) {
                j4 = Long.parseLong(str2);
            }
        }
        int i4 = (j4 > (-1L) ? 1 : (j4 == (-1L) ? 0 : -1));
        if (i4 == 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                g4 = g();
                if (g4 == null || g4.startsWith(this.f25612a)) {
                    break;
                }
                byteArrayOutputStream.write(g4.getBytes("ISO-8859-1"));
            }
            inputStream = h(byteArrayOutputStream.toByteArray());
            f5 = i(g4);
        } else {
            inputStream = new FilterInputStream(ByteStreams.limit(this.f25614c, j4)) { // from class: com.google.api.client.googleapis.batch.BatchUnparsedResponse.1
                @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }
            };
        }
        d(this.f25613b.get(this.f25618g - 1), parseInt, b(parseInt, inputStream, arrayList, arrayList2));
        while (true) {
            if (inputStream.skip(j4) <= 0 && inputStream.read() == -1) {
                break;
            }
        }
        if (i4 != 0) {
            f5 = f();
        }
        while (f5 != null && f5.length() == 0) {
            f5 = f();
        }
        a(f5);
    }

    /* loaded from: classes5.dex */
    private static class FakeLowLevelHttpRequest extends LowLevelHttpRequest {

        /* renamed from: e  reason: collision with root package name */
        private InputStream f25621e;

        /* renamed from: f  reason: collision with root package name */
        private int f25622f;

        /* renamed from: g  reason: collision with root package name */
        private List<String> f25623g;

        /* renamed from: h  reason: collision with root package name */
        private List<String> f25624h;

        FakeLowLevelHttpRequest(InputStream inputStream, int i4, List<String> list, List<String> list2) {
            this.f25621e = inputStream;
            this.f25622f = i4;
            this.f25623g = list;
            this.f25624h = list2;
        }

        @Override // com.google.api.client.http.LowLevelHttpRequest
        public LowLevelHttpResponse execute() {
            return new FakeLowLevelHttpResponse(this.f25621e, this.f25622f, this.f25623g, this.f25624h);
        }

        @Override // com.google.api.client.http.LowLevelHttpRequest
        public void addHeader(String str, String str2) {
        }
    }
}
