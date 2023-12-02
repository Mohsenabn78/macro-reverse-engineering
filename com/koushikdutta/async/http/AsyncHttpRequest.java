package com.koushikdutta.async.http;

import android.net.Uri;
import android.util.Log;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.koushikdutta.async.AsyncSSLException;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import java.util.Locale;
import net.bytebuddy.description.type.TypeDescription;
import org.apache.http.HttpVersion;

/* loaded from: classes6.dex */
public class AsyncHttpRequest {
    public static final int DEFAULT_TIMEOUT = 30000;

    /* renamed from: a  reason: collision with root package name */
    private String f34961a;

    /* renamed from: b  reason: collision with root package name */
    Uri f34962b;

    /* renamed from: c  reason: collision with root package name */
    private Headers f34963c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f34964d;

    /* renamed from: e  reason: collision with root package name */
    private AsyncHttpRequestBody f34965e;

    /* renamed from: f  reason: collision with root package name */
    int f34966f;

    /* renamed from: g  reason: collision with root package name */
    String f34967g;

    /* renamed from: h  reason: collision with root package name */
    int f34968h;

    /* renamed from: i  reason: collision with root package name */
    String f34969i;

    /* renamed from: j  reason: collision with root package name */
    int f34970j;

    /* renamed from: k  reason: collision with root package name */
    long f34971k;

    /* loaded from: classes6.dex */
    class a implements RequestLine {
        a() {
        }

        @Override // com.koushikdutta.async.http.RequestLine
        public String getMethod() {
            return AsyncHttpRequest.this.f34961a;
        }

        @Override // com.koushikdutta.async.http.RequestLine
        public ProtocolVersion getProtocolVersion() {
            return new ProtocolVersion(HttpVersion.HTTP, 1, 1);
        }

        @Override // com.koushikdutta.async.http.RequestLine
        public String getUri() {
            return AsyncHttpRequest.this.getUri().toString();
        }

        public String toString() {
            AsyncHttpRequest asyncHttpRequest = AsyncHttpRequest.this;
            if (asyncHttpRequest.f34967g != null) {
                return String.format(Locale.ENGLISH, "%s %s HTTP/1.1", asyncHttpRequest.f34961a, AsyncHttpRequest.this.getUri());
            }
            String encodedPath = asyncHttpRequest.getUri().getEncodedPath();
            if (encodedPath == null || encodedPath.length() == 0) {
                encodedPath = RemoteSettings.FORWARD_SLASH_STRING;
            }
            String encodedQuery = AsyncHttpRequest.this.getUri().getEncodedQuery();
            if (encodedQuery != null && encodedQuery.length() != 0) {
                encodedPath = encodedPath + TypeDescription.Generic.OfWildcardType.SYMBOL + encodedQuery;
            }
            return String.format(Locale.ENGLISH, "%s %s HTTP/1.1", AsyncHttpRequest.this.f34961a, encodedPath);
        }
    }

    public AsyncHttpRequest(Uri uri, String str) {
        this(uri, str, null);
    }

    protected static String b() {
        String property = System.getProperty("http.agent");
        if (property == null) {
            return "Java" + System.getProperty("java.version");
        }
        return property;
    }

    private String c(String str) {
        long j4 = 0;
        if (this.f34971k != 0) {
            j4 = System.currentTimeMillis() - this.f34971k;
        }
        return String.format(Locale.ENGLISH, "(%d ms) %s: %s", Long.valueOf(j4), getUri(), str);
    }

    public static void setDefaultHeaders(Headers headers, Uri uri) {
        if (uri != null) {
            String host = uri.getHost();
            if (uri.getPort() != -1) {
                host = host + ":" + uri.getPort();
            }
            if (host != null) {
                headers.set("Host", host);
            }
        }
        headers.set("User-Agent", b());
        headers.set(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate");
        headers.set("Connection", "keep-alive");
        headers.set(HttpHeaders.ACCEPT, "*/*");
    }

    public AsyncHttpRequest addHeader(String str, String str2) {
        getHeaders().add(str, str2);
        return this;
    }

    public void disableProxy() {
        this.f34967g = null;
        this.f34968h = -1;
    }

    public void enableProxy(String str, int i4) {
        this.f34967g = str;
        this.f34968h = i4;
    }

    public AsyncHttpRequestBody getBody() {
        return this.f34965e;
    }

    public boolean getFollowRedirect() {
        return this.f34964d;
    }

    public Headers getHeaders() {
        return this.f34963c;
    }

    public int getLogLevel() {
        return this.f34970j;
    }

    public String getLogTag() {
        return this.f34969i;
    }

    public String getMethod() {
        return this.f34961a;
    }

    public String getProxyHost() {
        return this.f34967g;
    }

    public int getProxyPort() {
        return this.f34968h;
    }

    public RequestLine getRequestLine() {
        return new a();
    }

    public int getTimeout() {
        return this.f34966f;
    }

    public Uri getUri() {
        return this.f34962b;
    }

    public void logd(String str) {
        if (this.f34969i != null && this.f34970j <= 3) {
            c(str);
        }
    }

    public void loge(String str) {
        String str2 = this.f34969i;
        if (str2 != null && this.f34970j <= 6) {
            Log.e(str2, c(str));
        }
    }

    public void logi(String str) {
        String str2 = this.f34969i;
        if (str2 == null || this.f34970j > 4) {
            return;
        }
        Log.i(str2, c(str));
    }

    public void logv(String str) {
        if (this.f34969i == null || this.f34970j > 2) {
            return;
        }
        c(str);
    }

    public void logw(String str) {
        String str2 = this.f34969i;
        if (str2 == null || this.f34970j > 5) {
            return;
        }
        Log.w(str2, c(str));
    }

    public void setBody(AsyncHttpRequestBody asyncHttpRequestBody) {
        this.f34965e = asyncHttpRequestBody;
    }

    public AsyncHttpRequest setFollowRedirect(boolean z3) {
        this.f34964d = z3;
        return this;
    }

    public AsyncHttpRequest setHeader(String str, String str2) {
        getHeaders().set(str, str2);
        return this;
    }

    public void setLogging(String str, int i4) {
        this.f34969i = str;
        this.f34970j = i4;
    }

    public AsyncHttpRequest setMethod(String str) {
        if (getClass() == AsyncHttpRequest.class) {
            this.f34961a = str;
            return this;
        }
        throw new UnsupportedOperationException("can't change method on a subclass of AsyncHttpRequest");
    }

    public AsyncHttpRequest setTimeout(int i4) {
        this.f34966f = i4;
        return this;
    }

    public String toString() {
        Headers headers = this.f34963c;
        if (headers == null) {
            return super.toString();
        }
        return headers.toPrefixString(this.f34962b.toString());
    }

    public AsyncHttpRequest(Uri uri, String str, Headers headers) {
        this.f34963c = new Headers();
        this.f34964d = true;
        this.f34966f = 30000;
        this.f34968h = -1;
        this.f34961a = str;
        this.f34962b = uri;
        if (headers == null) {
            this.f34963c = new Headers();
        } else {
            this.f34963c = headers;
        }
        if (headers == null) {
            setDefaultHeaders(this.f34963c, uri);
        }
    }

    public void logd(String str, Exception exc) {
        if (this.f34969i != null && this.f34970j <= 3) {
            c(str);
            exc.getMessage();
        }
    }

    public void loge(String str, Exception exc) {
        String str2 = this.f34969i;
        if (str2 != null && this.f34970j <= 6) {
            Log.e(str2, c(str));
            Log.e(this.f34969i, exc.getMessage(), exc);
        }
    }

    public void onHandshakeException(AsyncSSLException asyncSSLException) {
    }
}
