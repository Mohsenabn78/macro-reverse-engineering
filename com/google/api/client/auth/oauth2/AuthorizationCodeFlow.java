package com.google.api.client.auth.oauth2;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Joiner;
import com.google.api.client.util.Lists;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Strings;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.DataStoreFactory;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes5.dex */
public class AuthorizationCodeFlow {

    /* renamed from: a  reason: collision with root package name */
    private final Credential.AccessMethod f25467a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpTransport f25468b;

    /* renamed from: c  reason: collision with root package name */
    private final JsonFactory f25469c;

    /* renamed from: d  reason: collision with root package name */
    private final String f25470d;

    /* renamed from: e  reason: collision with root package name */
    private final HttpExecuteInterceptor f25471e;

    /* renamed from: f  reason: collision with root package name */
    private final String f25472f;

    /* renamed from: g  reason: collision with root package name */
    private final String f25473g;
    @Beta
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    private final CredentialStore f25474h;
    @Beta

    /* renamed from: i  reason: collision with root package name */
    private final DataStore<StoredCredential> f25475i;

    /* renamed from: j  reason: collision with root package name */
    private final HttpRequestInitializer f25476j;

    /* renamed from: k  reason: collision with root package name */
    private final Clock f25477k;

    /* renamed from: l  reason: collision with root package name */
    private final Collection<String> f25478l;

    /* renamed from: m  reason: collision with root package name */
    private final CredentialCreatedListener f25479m;

    /* renamed from: n  reason: collision with root package name */
    private final Collection<CredentialRefreshListener> f25480n;

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        Credential.AccessMethod f25481a;

        /* renamed from: b  reason: collision with root package name */
        HttpTransport f25482b;

        /* renamed from: c  reason: collision with root package name */
        JsonFactory f25483c;

        /* renamed from: d  reason: collision with root package name */
        GenericUrl f25484d;

        /* renamed from: e  reason: collision with root package name */
        HttpExecuteInterceptor f25485e;

        /* renamed from: f  reason: collision with root package name */
        String f25486f;

        /* renamed from: g  reason: collision with root package name */
        String f25487g;
        @Beta
        @Deprecated

        /* renamed from: h  reason: collision with root package name */
        CredentialStore f25488h;
        @Beta

        /* renamed from: i  reason: collision with root package name */
        DataStore<StoredCredential> f25489i;

        /* renamed from: j  reason: collision with root package name */
        HttpRequestInitializer f25490j;

        /* renamed from: m  reason: collision with root package name */
        CredentialCreatedListener f25493m;

        /* renamed from: k  reason: collision with root package name */
        Collection<String> f25491k = Lists.newArrayList();

        /* renamed from: l  reason: collision with root package name */
        Clock f25492l = Clock.SYSTEM;

        /* renamed from: n  reason: collision with root package name */
        Collection<CredentialRefreshListener> f25494n = Lists.newArrayList();

        public Builder(Credential.AccessMethod accessMethod, HttpTransport httpTransport, JsonFactory jsonFactory, GenericUrl genericUrl, HttpExecuteInterceptor httpExecuteInterceptor, String str, String str2) {
            setMethod(accessMethod);
            setTransport(httpTransport);
            setJsonFactory(jsonFactory);
            setTokenServerUrl(genericUrl);
            setClientAuthentication(httpExecuteInterceptor);
            setClientId(str);
            setAuthorizationServerEncodedUrl(str2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder addRefreshListener(CredentialRefreshListener credentialRefreshListener) {
            this.f25494n.add(Preconditions.checkNotNull(credentialRefreshListener));
            return this;
        }

        public AuthorizationCodeFlow build() {
            return new AuthorizationCodeFlow(this);
        }

        public final String getAuthorizationServerEncodedUrl() {
            return this.f25487g;
        }

        public final HttpExecuteInterceptor getClientAuthentication() {
            return this.f25485e;
        }

        public final String getClientId() {
            return this.f25486f;
        }

        public final Clock getClock() {
            return this.f25492l;
        }

        public final CredentialCreatedListener getCredentialCreatedListener() {
            return this.f25493m;
        }

        @Beta
        public final DataStore<StoredCredential> getCredentialDataStore() {
            return this.f25489i;
        }

        @Beta
        @Deprecated
        public final CredentialStore getCredentialStore() {
            return this.f25488h;
        }

        public final JsonFactory getJsonFactory() {
            return this.f25483c;
        }

        public final Credential.AccessMethod getMethod() {
            return this.f25481a;
        }

        public final Collection<CredentialRefreshListener> getRefreshListeners() {
            return this.f25494n;
        }

        public final HttpRequestInitializer getRequestInitializer() {
            return this.f25490j;
        }

        public final Collection<String> getScopes() {
            return this.f25491k;
        }

        public final GenericUrl getTokenServerUrl() {
            return this.f25484d;
        }

        public final HttpTransport getTransport() {
            return this.f25482b;
        }

        public Builder setAuthorizationServerEncodedUrl(String str) {
            this.f25487g = (String) Preconditions.checkNotNull(str);
            return this;
        }

        public Builder setClientAuthentication(HttpExecuteInterceptor httpExecuteInterceptor) {
            this.f25485e = httpExecuteInterceptor;
            return this;
        }

        public Builder setClientId(String str) {
            this.f25486f = (String) Preconditions.checkNotNull(str);
            return this;
        }

        public Builder setClock(Clock clock) {
            this.f25492l = (Clock) Preconditions.checkNotNull(clock);
            return this;
        }

        public Builder setCredentialCreatedListener(CredentialCreatedListener credentialCreatedListener) {
            this.f25493m = credentialCreatedListener;
            return this;
        }

        @Beta
        public Builder setCredentialDataStore(DataStore<StoredCredential> dataStore) {
            boolean z3;
            if (this.f25488h == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            this.f25489i = dataStore;
            return this;
        }

        @Beta
        @Deprecated
        public Builder setCredentialStore(CredentialStore credentialStore) {
            boolean z3;
            if (this.f25489i == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            this.f25488h = credentialStore;
            return this;
        }

        @Beta
        public Builder setDataStoreFactory(DataStoreFactory dataStoreFactory) throws IOException {
            return setCredentialDataStore(StoredCredential.getDefaultDataStore(dataStoreFactory));
        }

        public Builder setJsonFactory(JsonFactory jsonFactory) {
            this.f25483c = (JsonFactory) Preconditions.checkNotNull(jsonFactory);
            return this;
        }

        public Builder setMethod(Credential.AccessMethod accessMethod) {
            this.f25481a = (Credential.AccessMethod) Preconditions.checkNotNull(accessMethod);
            return this;
        }

        public Builder setRefreshListeners(Collection<CredentialRefreshListener> collection) {
            this.f25494n = (Collection) Preconditions.checkNotNull(collection);
            return this;
        }

        public Builder setRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
            this.f25490j = httpRequestInitializer;
            return this;
        }

        public Builder setScopes(Collection<String> collection) {
            this.f25491k = (Collection) Preconditions.checkNotNull(collection);
            return this;
        }

        public Builder setTokenServerUrl(GenericUrl genericUrl) {
            this.f25484d = (GenericUrl) Preconditions.checkNotNull(genericUrl);
            return this;
        }

        public Builder setTransport(HttpTransport httpTransport) {
            this.f25482b = (HttpTransport) Preconditions.checkNotNull(httpTransport);
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public interface CredentialCreatedListener {
        void onCredentialCreated(Credential credential, TokenResponse tokenResponse) throws IOException;
    }

    public AuthorizationCodeFlow(Credential.AccessMethod accessMethod, HttpTransport httpTransport, JsonFactory jsonFactory, GenericUrl genericUrl, HttpExecuteInterceptor httpExecuteInterceptor, String str, String str2) {
        this(new Builder(accessMethod, httpTransport, jsonFactory, genericUrl, httpExecuteInterceptor, str, str2));
    }

    private Credential a(String str) {
        Credential.Builder clock = new Credential.Builder(this.f25467a).setTransport(this.f25468b).setJsonFactory(this.f25469c).setTokenServerEncodedUrl(this.f25470d).setClientAuthentication(this.f25471e).setRequestInitializer(this.f25476j).setClock(this.f25477k);
        DataStore<StoredCredential> dataStore = this.f25475i;
        if (dataStore != null) {
            clock.addRefreshListener(new DataStoreCredentialRefreshListener(str, dataStore));
        } else {
            CredentialStore credentialStore = this.f25474h;
            if (credentialStore != null) {
                clock.addRefreshListener(new CredentialStoreRefreshListener(str, credentialStore));
            }
        }
        clock.getRefreshListeners().addAll(this.f25480n);
        return clock.build();
    }

    public Credential createAndStoreCredential(TokenResponse tokenResponse, String str) throws IOException {
        Credential fromTokenResponse = a(str).setFromTokenResponse(tokenResponse);
        CredentialStore credentialStore = this.f25474h;
        if (credentialStore != null) {
            credentialStore.store(str, fromTokenResponse);
        }
        DataStore<StoredCredential> dataStore = this.f25475i;
        if (dataStore != null) {
            dataStore.set(str, new StoredCredential(fromTokenResponse));
        }
        CredentialCreatedListener credentialCreatedListener = this.f25479m;
        if (credentialCreatedListener != null) {
            credentialCreatedListener.onCredentialCreated(fromTokenResponse, tokenResponse);
        }
        return fromTokenResponse;
    }

    public final String getAuthorizationServerEncodedUrl() {
        return this.f25473g;
    }

    public final HttpExecuteInterceptor getClientAuthentication() {
        return this.f25471e;
    }

    public final String getClientId() {
        return this.f25472f;
    }

    public final Clock getClock() {
        return this.f25477k;
    }

    @Beta
    public final DataStore<StoredCredential> getCredentialDataStore() {
        return this.f25475i;
    }

    @Beta
    @Deprecated
    public final CredentialStore getCredentialStore() {
        return this.f25474h;
    }

    public final JsonFactory getJsonFactory() {
        return this.f25469c;
    }

    public final Credential.AccessMethod getMethod() {
        return this.f25467a;
    }

    public final Collection<CredentialRefreshListener> getRefreshListeners() {
        return this.f25480n;
    }

    public final HttpRequestInitializer getRequestInitializer() {
        return this.f25476j;
    }

    public final Collection<String> getScopes() {
        return this.f25478l;
    }

    public final String getScopesAsString() {
        return Joiner.on(' ').join(this.f25478l);
    }

    public final String getTokenServerEncodedUrl() {
        return this.f25470d;
    }

    public final HttpTransport getTransport() {
        return this.f25468b;
    }

    public Credential loadCredential(String str) throws IOException {
        if (Strings.isNullOrEmpty(str)) {
            return null;
        }
        if (this.f25475i == null && this.f25474h == null) {
            return null;
        }
        Credential a4 = a(str);
        DataStore<StoredCredential> dataStore = this.f25475i;
        if (dataStore != null) {
            StoredCredential storedCredential = dataStore.get(str);
            if (storedCredential == null) {
                return null;
            }
            a4.setAccessToken(storedCredential.getAccessToken());
            a4.setRefreshToken(storedCredential.getRefreshToken());
            a4.setExpirationTimeMilliseconds(storedCredential.getExpirationTimeMilliseconds());
        } else if (!this.f25474h.load(str, a4)) {
            return null;
        }
        return a4;
    }

    public AuthorizationCodeRequestUrl newAuthorizationUrl() {
        return new AuthorizationCodeRequestUrl(this.f25473g, this.f25472f).setScopes(this.f25478l);
    }

    public AuthorizationCodeTokenRequest newTokenRequest(String str) {
        return new AuthorizationCodeTokenRequest(this.f25468b, this.f25469c, new GenericUrl(this.f25470d), str).setClientAuthentication(this.f25471e).setRequestInitializer(this.f25476j).setScopes(this.f25478l);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AuthorizationCodeFlow(Builder builder) {
        this.f25467a = (Credential.AccessMethod) Preconditions.checkNotNull(builder.f25481a);
        this.f25468b = (HttpTransport) Preconditions.checkNotNull(builder.f25482b);
        this.f25469c = (JsonFactory) Preconditions.checkNotNull(builder.f25483c);
        this.f25470d = ((GenericUrl) Preconditions.checkNotNull(builder.f25484d)).build();
        this.f25471e = builder.f25485e;
        this.f25472f = (String) Preconditions.checkNotNull(builder.f25486f);
        this.f25473g = (String) Preconditions.checkNotNull(builder.f25487g);
        this.f25476j = builder.f25490j;
        this.f25474h = builder.f25488h;
        this.f25475i = builder.f25489i;
        this.f25478l = Collections.unmodifiableCollection(builder.f25491k);
        this.f25477k = (Clock) Preconditions.checkNotNull(builder.f25492l);
        this.f25479m = builder.f25493m;
        this.f25480n = Collections.unmodifiableCollection(builder.f25494n);
    }
}
