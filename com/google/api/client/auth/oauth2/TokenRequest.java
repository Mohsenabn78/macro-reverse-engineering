package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Joiner;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Collection;

/* loaded from: classes5.dex */
public class TokenRequest extends GenericData {

    /* renamed from: c  reason: collision with root package name */
    HttpRequestInitializer f25523c;

    /* renamed from: d  reason: collision with root package name */
    HttpExecuteInterceptor f25524d;

    /* renamed from: e  reason: collision with root package name */
    private final HttpTransport f25525e;

    /* renamed from: f  reason: collision with root package name */
    private final JsonFactory f25526f;

    /* renamed from: g  reason: collision with root package name */
    private GenericUrl f25527g;
    @Key("grant_type")
    private String grantType;
    @Key("scope")
    private String scopes;

    public TokenRequest(HttpTransport httpTransport, JsonFactory jsonFactory, GenericUrl genericUrl, String str) {
        this.f25525e = (HttpTransport) Preconditions.checkNotNull(httpTransport);
        this.f25526f = (JsonFactory) Preconditions.checkNotNull(jsonFactory);
        setTokenServerUrl(genericUrl);
        setGrantType(str);
    }

    public TokenResponse execute() throws IOException {
        return (TokenResponse) executeUnparsed().parseAs((Class<Object>) TokenResponse.class);
    }

    public final HttpResponse executeUnparsed() throws IOException {
        HttpRequest buildPostRequest = this.f25525e.createRequestFactory(new HttpRequestInitializer() { // from class: com.google.api.client.auth.oauth2.TokenRequest.1
            @Override // com.google.api.client.http.HttpRequestInitializer
            public void initialize(HttpRequest httpRequest) throws IOException {
                HttpRequestInitializer httpRequestInitializer = TokenRequest.this.f25523c;
                if (httpRequestInitializer != null) {
                    httpRequestInitializer.initialize(httpRequest);
                }
                final HttpExecuteInterceptor interceptor = httpRequest.getInterceptor();
                httpRequest.setInterceptor(new HttpExecuteInterceptor() { // from class: com.google.api.client.auth.oauth2.TokenRequest.1.1
                    @Override // com.google.api.client.http.HttpExecuteInterceptor
                    public void intercept(HttpRequest httpRequest2) throws IOException {
                        HttpExecuteInterceptor httpExecuteInterceptor = interceptor;
                        if (httpExecuteInterceptor != null) {
                            httpExecuteInterceptor.intercept(httpRequest2);
                        }
                        HttpExecuteInterceptor httpExecuteInterceptor2 = TokenRequest.this.f25524d;
                        if (httpExecuteInterceptor2 != null) {
                            httpExecuteInterceptor2.intercept(httpRequest2);
                        }
                    }
                });
            }
        }).buildPostRequest(this.f25527g, new UrlEncodedContent(this));
        buildPostRequest.setParser(new JsonObjectParser(this.f25526f));
        buildPostRequest.setThrowExceptionOnExecuteError(false);
        HttpResponse execute = buildPostRequest.execute();
        if (execute.isSuccessStatusCode()) {
            return execute;
        }
        throw TokenResponseException.from(this.f25526f, execute);
    }

    public final HttpExecuteInterceptor getClientAuthentication() {
        return this.f25524d;
    }

    public final String getGrantType() {
        return this.grantType;
    }

    public final JsonFactory getJsonFactory() {
        return this.f25526f;
    }

    public final HttpRequestInitializer getRequestInitializer() {
        return this.f25523c;
    }

    public final String getScopes() {
        return this.scopes;
    }

    public final GenericUrl getTokenServerUrl() {
        return this.f25527g;
    }

    public final HttpTransport getTransport() {
        return this.f25525e;
    }

    public TokenRequest setClientAuthentication(HttpExecuteInterceptor httpExecuteInterceptor) {
        this.f25524d = httpExecuteInterceptor;
        return this;
    }

    public TokenRequest setGrantType(String str) {
        this.grantType = (String) Preconditions.checkNotNull(str);
        return this;
    }

    public TokenRequest setRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
        this.f25523c = httpRequestInitializer;
        return this;
    }

    public TokenRequest setScopes(Collection<String> collection) {
        String join;
        if (collection == null) {
            join = null;
        } else {
            join = Joiner.on(' ').join(collection);
        }
        this.scopes = join;
        return this;
    }

    public TokenRequest setTokenServerUrl(GenericUrl genericUrl) {
        boolean z3;
        this.f25527g = genericUrl;
        if (genericUrl.getFragment() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        return this;
    }

    @Override // com.google.api.client.util.GenericData
    public TokenRequest set(String str, Object obj) {
        return (TokenRequest) super.set(str, obj);
    }
}
