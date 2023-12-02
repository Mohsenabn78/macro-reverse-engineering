package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Lists;
import com.google.api.client.util.Objects;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes5.dex */
public class Credential implements HttpExecuteInterceptor, HttpRequestInitializer, HttpUnsuccessfulResponseHandler {

    /* renamed from: m  reason: collision with root package name */
    static final Logger f25498m = Logger.getLogger(Credential.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final Lock f25499a;

    /* renamed from: b  reason: collision with root package name */
    private final AccessMethod f25500b;

    /* renamed from: c  reason: collision with root package name */
    private final Clock f25501c;

    /* renamed from: d  reason: collision with root package name */
    private String f25502d;

    /* renamed from: e  reason: collision with root package name */
    private Long f25503e;

    /* renamed from: f  reason: collision with root package name */
    private String f25504f;

    /* renamed from: g  reason: collision with root package name */
    private final HttpTransport f25505g;

    /* renamed from: h  reason: collision with root package name */
    private final HttpExecuteInterceptor f25506h;

    /* renamed from: i  reason: collision with root package name */
    private final JsonFactory f25507i;

    /* renamed from: j  reason: collision with root package name */
    private final String f25508j;

    /* renamed from: k  reason: collision with root package name */
    private final Collection<CredentialRefreshListener> f25509k;

    /* renamed from: l  reason: collision with root package name */
    private final HttpRequestInitializer f25510l;

    /* loaded from: classes5.dex */
    public interface AccessMethod {
        String getAccessTokenFromRequest(HttpRequest httpRequest);

        void intercept(HttpRequest httpRequest, String str) throws IOException;
    }

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        final AccessMethod f25511a;

        /* renamed from: b  reason: collision with root package name */
        HttpTransport f25512b;

        /* renamed from: c  reason: collision with root package name */
        JsonFactory f25513c;

        /* renamed from: d  reason: collision with root package name */
        GenericUrl f25514d;

        /* renamed from: f  reason: collision with root package name */
        HttpExecuteInterceptor f25516f;

        /* renamed from: g  reason: collision with root package name */
        HttpRequestInitializer f25517g;

        /* renamed from: e  reason: collision with root package name */
        Clock f25515e = Clock.SYSTEM;

        /* renamed from: h  reason: collision with root package name */
        Collection<CredentialRefreshListener> f25518h = Lists.newArrayList();

        public Builder(AccessMethod accessMethod) {
            this.f25511a = (AccessMethod) Preconditions.checkNotNull(accessMethod);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder addRefreshListener(CredentialRefreshListener credentialRefreshListener) {
            this.f25518h.add(Preconditions.checkNotNull(credentialRefreshListener));
            return this;
        }

        public Credential build() {
            return new Credential(this);
        }

        public final HttpExecuteInterceptor getClientAuthentication() {
            return this.f25516f;
        }

        public final Clock getClock() {
            return this.f25515e;
        }

        public final JsonFactory getJsonFactory() {
            return this.f25513c;
        }

        public final AccessMethod getMethod() {
            return this.f25511a;
        }

        public final Collection<CredentialRefreshListener> getRefreshListeners() {
            return this.f25518h;
        }

        public final HttpRequestInitializer getRequestInitializer() {
            return this.f25517g;
        }

        public final GenericUrl getTokenServerUrl() {
            return this.f25514d;
        }

        public final HttpTransport getTransport() {
            return this.f25512b;
        }

        public Builder setClientAuthentication(HttpExecuteInterceptor httpExecuteInterceptor) {
            this.f25516f = httpExecuteInterceptor;
            return this;
        }

        public Builder setClock(Clock clock) {
            this.f25515e = (Clock) Preconditions.checkNotNull(clock);
            return this;
        }

        public Builder setJsonFactory(JsonFactory jsonFactory) {
            this.f25513c = jsonFactory;
            return this;
        }

        public Builder setRefreshListeners(Collection<CredentialRefreshListener> collection) {
            this.f25518h = (Collection) Preconditions.checkNotNull(collection);
            return this;
        }

        public Builder setRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
            this.f25517g = httpRequestInitializer;
            return this;
        }

        public Builder setTokenServerEncodedUrl(String str) {
            GenericUrl genericUrl;
            if (str == null) {
                genericUrl = null;
            } else {
                genericUrl = new GenericUrl(str);
            }
            this.f25514d = genericUrl;
            return this;
        }

        public Builder setTokenServerUrl(GenericUrl genericUrl) {
            this.f25514d = genericUrl;
            return this;
        }

        public Builder setTransport(HttpTransport httpTransport) {
            this.f25512b = httpTransport;
            return this;
        }
    }

    public Credential(AccessMethod accessMethod) {
        this(new Builder(accessMethod));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TokenResponse a() throws IOException {
        if (this.f25504f == null) {
            return null;
        }
        return new RefreshTokenRequest(this.f25505g, this.f25507i, new GenericUrl(this.f25508j), this.f25504f).setClientAuthentication(this.f25506h).setRequestInitializer(this.f25510l).execute();
    }

    public final String getAccessToken() {
        this.f25499a.lock();
        try {
            return this.f25502d;
        } finally {
            this.f25499a.unlock();
        }
    }

    public final HttpExecuteInterceptor getClientAuthentication() {
        return this.f25506h;
    }

    public final Clock getClock() {
        return this.f25501c;
    }

    public final Long getExpirationTimeMilliseconds() {
        this.f25499a.lock();
        try {
            return this.f25503e;
        } finally {
            this.f25499a.unlock();
        }
    }

    public final Long getExpiresInSeconds() {
        this.f25499a.lock();
        try {
            Long l4 = this.f25503e;
            if (l4 == null) {
                this.f25499a.unlock();
                return null;
            }
            return Long.valueOf((l4.longValue() - this.f25501c.currentTimeMillis()) / 1000);
        } finally {
            this.f25499a.unlock();
        }
    }

    public final JsonFactory getJsonFactory() {
        return this.f25507i;
    }

    public final AccessMethod getMethod() {
        return this.f25500b;
    }

    public final Collection<CredentialRefreshListener> getRefreshListeners() {
        return this.f25509k;
    }

    public final String getRefreshToken() {
        this.f25499a.lock();
        try {
            return this.f25504f;
        } finally {
            this.f25499a.unlock();
        }
    }

    public final HttpRequestInitializer getRequestInitializer() {
        return this.f25510l;
    }

    public final String getTokenServerEncodedUrl() {
        return this.f25508j;
    }

    public final HttpTransport getTransport() {
        return this.f25505g;
    }

    @Override // com.google.api.client.http.HttpUnsuccessfulResponseHandler
    public boolean handleResponse(HttpRequest httpRequest, HttpResponse httpResponse, boolean z3) {
        boolean z4;
        boolean z5;
        List<String> authenticateAsList = httpResponse.getHeaders().getAuthenticateAsList();
        boolean z6 = true;
        if (authenticateAsList != null) {
            for (String str : authenticateAsList) {
                if (str.startsWith("Bearer ")) {
                    z4 = BearerToken.f25495a.matcher(str).find();
                    z5 = true;
                    break;
                }
            }
        }
        z4 = false;
        z5 = false;
        if (!z5) {
            if (httpResponse.getStatusCode() == 401) {
                z4 = true;
            } else {
                z4 = false;
            }
        }
        if (z4) {
            try {
                this.f25499a.lock();
                if (Objects.equal(this.f25502d, this.f25500b.getAccessTokenFromRequest(httpRequest)) && !refreshToken()) {
                    z6 = false;
                }
                this.f25499a.unlock();
                return z6;
            } catch (IOException e4) {
                f25498m.log(Level.SEVERE, "unable to refresh token", (Throwable) e4);
            }
        }
        return false;
    }

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void initialize(HttpRequest httpRequest) throws IOException {
        httpRequest.setInterceptor(this);
        httpRequest.setUnsuccessfulResponseHandler(this);
    }

    @Override // com.google.api.client.http.HttpExecuteInterceptor
    public void intercept(HttpRequest httpRequest) throws IOException {
        this.f25499a.lock();
        try {
            Long expiresInSeconds = getExpiresInSeconds();
            if (this.f25502d == null || (expiresInSeconds != null && expiresInSeconds.longValue() <= 60)) {
                refreshToken();
                if (this.f25502d == null) {
                    return;
                }
            }
            this.f25500b.intercept(httpRequest, this.f25502d);
        } finally {
            this.f25499a.unlock();
        }
    }

    public final boolean refreshToken() throws IOException {
        this.f25499a.lock();
        boolean z3 = true;
        try {
            try {
                TokenResponse a4 = a();
                if (a4 != null) {
                    setFromTokenResponse(a4);
                    for (CredentialRefreshListener credentialRefreshListener : this.f25509k) {
                        credentialRefreshListener.onTokenResponse(this, a4);
                    }
                    return true;
                }
            } catch (TokenResponseException e4) {
                if (400 > e4.getStatusCode() || e4.getStatusCode() >= 500) {
                    z3 = false;
                }
                if (e4.getDetails() != null && z3) {
                    setAccessToken(null);
                    setExpiresInSeconds(null);
                }
                for (CredentialRefreshListener credentialRefreshListener2 : this.f25509k) {
                    credentialRefreshListener2.onTokenErrorResponse(this, e4.getDetails());
                }
                if (z3) {
                    throw e4;
                }
            }
            return false;
        } finally {
            this.f25499a.unlock();
        }
    }

    public Credential setAccessToken(String str) {
        this.f25499a.lock();
        try {
            this.f25502d = str;
            return this;
        } finally {
            this.f25499a.unlock();
        }
    }

    public Credential setExpirationTimeMilliseconds(Long l4) {
        this.f25499a.lock();
        try {
            this.f25503e = l4;
            return this;
        } finally {
            this.f25499a.unlock();
        }
    }

    public Credential setExpiresInSeconds(Long l4) {
        Long valueOf;
        if (l4 == null) {
            valueOf = null;
        } else {
            valueOf = Long.valueOf(this.f25501c.currentTimeMillis() + (l4.longValue() * 1000));
        }
        return setExpirationTimeMilliseconds(valueOf);
    }

    public Credential setFromTokenResponse(TokenResponse tokenResponse) {
        setAccessToken(tokenResponse.getAccessToken());
        if (tokenResponse.getRefreshToken() != null) {
            setRefreshToken(tokenResponse.getRefreshToken());
        }
        setExpiresInSeconds(tokenResponse.getExpiresInSeconds());
        return this;
    }

    public Credential setRefreshToken(String str) {
        boolean z3;
        this.f25499a.lock();
        if (str != null) {
            try {
                if (this.f25507i != null && this.f25505g != null && this.f25506h != null && this.f25508j != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkArgument(z3, "Please use the Builder and call setJsonFactory, setTransport, setClientAuthentication and setTokenServerUrl/setTokenServerEncodedUrl");
            } finally {
                this.f25499a.unlock();
            }
        }
        this.f25504f = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Credential(Builder builder) {
        this.f25499a = new ReentrantLock();
        this.f25500b = (AccessMethod) Preconditions.checkNotNull(builder.f25511a);
        this.f25505g = builder.f25512b;
        this.f25507i = builder.f25513c;
        GenericUrl genericUrl = builder.f25514d;
        this.f25508j = genericUrl == null ? null : genericUrl.build();
        this.f25506h = builder.f25516f;
        this.f25510l = builder.f25517g;
        this.f25509k = Collections.unmodifiableCollection(builder.f25518h);
        this.f25501c = (Clock) Preconditions.checkNotNull(builder.f25515e);
    }
}
