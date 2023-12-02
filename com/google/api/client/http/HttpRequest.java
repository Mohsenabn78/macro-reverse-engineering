package com.google.api.client.http;

import com.google.api.client.util.Beta;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* loaded from: classes5.dex */
public final class HttpRequest {
    public static final int DEFAULT_NUMBER_OF_RETRIES = 10;
    public static final String USER_AGENT_SUFFIX = "Google-HTTP-Java-Client/1.23.0 (gzip)";
    public static final String VERSION = "1.23.0";

    /* renamed from: a  reason: collision with root package name */
    private HttpExecuteInterceptor f25789a;

    /* renamed from: h  reason: collision with root package name */
    private HttpContent f25796h;

    /* renamed from: i  reason: collision with root package name */
    private final HttpTransport f25797i;

    /* renamed from: j  reason: collision with root package name */
    private String f25798j;

    /* renamed from: k  reason: collision with root package name */
    private GenericUrl f25799k;

    /* renamed from: n  reason: collision with root package name */
    private HttpUnsuccessfulResponseHandler f25802n;
    @Beta

    /* renamed from: o  reason: collision with root package name */
    private HttpIOExceptionHandler f25803o;

    /* renamed from: p  reason: collision with root package name */
    private HttpResponseInterceptor f25804p;

    /* renamed from: q  reason: collision with root package name */
    private ObjectParser f25805q;

    /* renamed from: r  reason: collision with root package name */
    private HttpEncoding f25806r;
    @Beta
    @Deprecated

    /* renamed from: s  reason: collision with root package name */
    private BackOffPolicy f25807s;

    /* renamed from: w  reason: collision with root package name */
    private boolean f25811w;

    /* renamed from: b  reason: collision with root package name */
    private HttpHeaders f25790b = new HttpHeaders();

    /* renamed from: c  reason: collision with root package name */
    private HttpHeaders f25791c = new HttpHeaders();

    /* renamed from: d  reason: collision with root package name */
    private int f25792d = 10;

    /* renamed from: e  reason: collision with root package name */
    private int f25793e = 16384;

    /* renamed from: f  reason: collision with root package name */
    private boolean f25794f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f25795g = true;

    /* renamed from: l  reason: collision with root package name */
    private int f25800l = 20000;

    /* renamed from: m  reason: collision with root package name */
    private int f25801m = 20000;

    /* renamed from: t  reason: collision with root package name */
    private boolean f25808t = true;

    /* renamed from: u  reason: collision with root package name */
    private boolean f25809u = true;
    @Beta
    @Deprecated

    /* renamed from: v  reason: collision with root package name */
    private boolean f25810v = false;

    /* renamed from: x  reason: collision with root package name */
    private Sleeper f25812x = Sleeper.DEFAULT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpRequest(HttpTransport httpTransport, String str) {
        this.f25797i = httpTransport;
        setRequestMethod(str);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(29:(1:9)|10|(1:12)|13|(1:167)(1:17)|(2:19|(22:21|(1:23)|24|(2:26|(1:28)(1:29))|30|(1:32)|33|(1:164)(1:37)|38|(7:40|(1:42)|43|(1:45)(3:158|(1:160)(1:162)|161)|(6:47|(4:49|(1:51)(1:155)|52|(4:54|(4:56|(1:58)(1:62)|59|(1:61))|63|(1:65)))(1:156)|154|(0)|63|(0))(1:157)|(1:67)|68)(1:163)|(2:70|(3:72|(1:74)|75))|(1:153)(1:78)|79|80|81|82|83|(3:111|112|(7:114|(1:116)(1:136)|(3:118|(1:(3:126|127|(2:129|130)))|120)|133|(1:135)|88|(2:91|(4:93|(1:95)|96|(1:108)(3:100|101|102))(1:109))(1:90)))|(1:86)(1:110)|87|88|(0)(0)))(1:166)|165|24|(0)|30|(0)|33|(1:35)|164|38|(0)(0)|(0)|(0)|153|79|80|81|82|83|(0)|(0)(0)|87|88|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0235, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0238, code lost:
        if (r1.f25810v != false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0245, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0246, code lost:
        r7.log(java.util.logging.Level.WARNING, "exception thrown while executing request", (java.lang.Throwable) r0);
        r3 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02cd A[LOOP:0: B:10:0x0022->B:167:0x02cd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0250 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01e6  */
    /* JADX WARN: Type inference failed for: r3v18, types: [com.google.api.client.util.LoggingStreamingContent] */
    /* JADX WARN: Type inference failed for: r4v15, types: [com.google.api.client.http.HttpEncodingStreamingContent, com.google.api.client.util.StreamingContent] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.api.client.http.HttpResponse execute() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 721
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.http.HttpRequest.execute():com.google.api.client.http.HttpResponse");
    }

    @Beta
    public Future<HttpResponse> executeAsync(Executor executor) {
        FutureTask futureTask = new FutureTask(new Callable<HttpResponse>() { // from class: com.google.api.client.http.HttpRequest.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public HttpResponse call() throws Exception {
                return HttpRequest.this.execute();
            }
        });
        executor.execute(futureTask);
        return futureTask;
    }

    @Beta
    @Deprecated
    public BackOffPolicy getBackOffPolicy() {
        return this.f25807s;
    }

    public int getConnectTimeout() {
        return this.f25800l;
    }

    public HttpContent getContent() {
        return this.f25796h;
    }

    public int getContentLoggingLimit() {
        return this.f25793e;
    }

    public HttpEncoding getEncoding() {
        return this.f25806r;
    }

    public boolean getFollowRedirects() {
        return this.f25808t;
    }

    public HttpHeaders getHeaders() {
        return this.f25790b;
    }

    @Beta
    public HttpIOExceptionHandler getIOExceptionHandler() {
        return this.f25803o;
    }

    public HttpExecuteInterceptor getInterceptor() {
        return this.f25789a;
    }

    public int getNumberOfRetries() {
        return this.f25792d;
    }

    public final ObjectParser getParser() {
        return this.f25805q;
    }

    public int getReadTimeout() {
        return this.f25801m;
    }

    public String getRequestMethod() {
        return this.f25798j;
    }

    public HttpHeaders getResponseHeaders() {
        return this.f25791c;
    }

    public HttpResponseInterceptor getResponseInterceptor() {
        return this.f25804p;
    }

    @Beta
    @Deprecated
    public boolean getRetryOnExecuteIOException() {
        return this.f25810v;
    }

    public Sleeper getSleeper() {
        return this.f25812x;
    }

    public boolean getSuppressUserAgentSuffix() {
        return this.f25811w;
    }

    public boolean getThrowExceptionOnExecuteError() {
        return this.f25809u;
    }

    public HttpTransport getTransport() {
        return this.f25797i;
    }

    public HttpUnsuccessfulResponseHandler getUnsuccessfulResponseHandler() {
        return this.f25802n;
    }

    public GenericUrl getUrl() {
        return this.f25799k;
    }

    public boolean handleRedirect(int i4, HttpHeaders httpHeaders) {
        String location = httpHeaders.getLocation();
        if (getFollowRedirects() && HttpStatusCodes.isRedirect(i4) && location != null) {
            setUrl(new GenericUrl(this.f25799k.toURL(location)));
            if (i4 == 303) {
                setRequestMethod("GET");
                setContent(null);
            }
            this.f25790b.setAuthorization((String) null);
            this.f25790b.setIfMatch(null);
            this.f25790b.setIfNoneMatch(null);
            this.f25790b.setIfModifiedSince(null);
            this.f25790b.setIfUnmodifiedSince(null);
            this.f25790b.setIfRange(null);
            return true;
        }
        return false;
    }

    public boolean isCurlLoggingEnabled() {
        return this.f25795g;
    }

    public boolean isLoggingEnabled() {
        return this.f25794f;
    }

    @Beta
    @Deprecated
    public HttpRequest setBackOffPolicy(BackOffPolicy backOffPolicy) {
        this.f25807s = backOffPolicy;
        return this;
    }

    public HttpRequest setConnectTimeout(int i4) {
        boolean z3;
        if (i4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        this.f25800l = i4;
        return this;
    }

    public HttpRequest setContent(HttpContent httpContent) {
        this.f25796h = httpContent;
        return this;
    }

    public HttpRequest setContentLoggingLimit(int i4) {
        boolean z3;
        if (i4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "The content logging limit must be non-negative.");
        this.f25793e = i4;
        return this;
    }

    public HttpRequest setCurlLoggingEnabled(boolean z3) {
        this.f25795g = z3;
        return this;
    }

    public HttpRequest setEncoding(HttpEncoding httpEncoding) {
        this.f25806r = httpEncoding;
        return this;
    }

    public HttpRequest setFollowRedirects(boolean z3) {
        this.f25808t = z3;
        return this;
    }

    public HttpRequest setHeaders(HttpHeaders httpHeaders) {
        this.f25790b = (HttpHeaders) Preconditions.checkNotNull(httpHeaders);
        return this;
    }

    @Beta
    public HttpRequest setIOExceptionHandler(HttpIOExceptionHandler httpIOExceptionHandler) {
        this.f25803o = httpIOExceptionHandler;
        return this;
    }

    public HttpRequest setInterceptor(HttpExecuteInterceptor httpExecuteInterceptor) {
        this.f25789a = httpExecuteInterceptor;
        return this;
    }

    public HttpRequest setLoggingEnabled(boolean z3) {
        this.f25794f = z3;
        return this;
    }

    public HttpRequest setNumberOfRetries(int i4) {
        boolean z3;
        if (i4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        this.f25792d = i4;
        return this;
    }

    public HttpRequest setParser(ObjectParser objectParser) {
        this.f25805q = objectParser;
        return this;
    }

    public HttpRequest setReadTimeout(int i4) {
        boolean z3;
        if (i4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        this.f25801m = i4;
        return this;
    }

    public HttpRequest setRequestMethod(String str) {
        boolean z3;
        if (str != null && !HttpMediaType.b(str)) {
            z3 = false;
        } else {
            z3 = true;
        }
        Preconditions.checkArgument(z3);
        this.f25798j = str;
        return this;
    }

    public HttpRequest setResponseHeaders(HttpHeaders httpHeaders) {
        this.f25791c = (HttpHeaders) Preconditions.checkNotNull(httpHeaders);
        return this;
    }

    public HttpRequest setResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor) {
        this.f25804p = httpResponseInterceptor;
        return this;
    }

    @Beta
    @Deprecated
    public HttpRequest setRetryOnExecuteIOException(boolean z3) {
        this.f25810v = z3;
        return this;
    }

    public HttpRequest setSleeper(Sleeper sleeper) {
        this.f25812x = (Sleeper) Preconditions.checkNotNull(sleeper);
        return this;
    }

    public HttpRequest setSuppressUserAgentSuffix(boolean z3) {
        this.f25811w = z3;
        return this;
    }

    public HttpRequest setThrowExceptionOnExecuteError(boolean z3) {
        this.f25809u = z3;
        return this;
    }

    public HttpRequest setUnsuccessfulResponseHandler(HttpUnsuccessfulResponseHandler httpUnsuccessfulResponseHandler) {
        this.f25802n = httpUnsuccessfulResponseHandler;
        return this;
    }

    public HttpRequest setUrl(GenericUrl genericUrl) {
        this.f25799k = (GenericUrl) Preconditions.checkNotNull(genericUrl);
        return this;
    }

    @Beta
    public Future<HttpResponse> executeAsync() {
        return executeAsync(Executors.newSingleThreadExecutor());
    }
}
