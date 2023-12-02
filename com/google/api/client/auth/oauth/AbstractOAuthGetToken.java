package com.google.api.client.auth.oauth;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedParser;
import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
/* loaded from: classes5.dex */
public abstract class AbstractOAuthGetToken extends GenericUrl {
    public String consumerKey;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f25464j;
    public OAuthSigner signer;
    public HttpTransport transport;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractOAuthGetToken(String str) {
        super(str);
    }

    public OAuthParameters createParameters() {
        OAuthParameters oAuthParameters = new OAuthParameters();
        oAuthParameters.consumerKey = this.consumerKey;
        oAuthParameters.signer = this.signer;
        return oAuthParameters;
    }

    public final OAuthCredentialsResponse execute() throws IOException {
        String str;
        HttpRequestFactory createRequestFactory = this.transport.createRequestFactory();
        if (this.f25464j) {
            str = "POST";
        } else {
            str = "GET";
        }
        HttpRequest buildRequest = createRequestFactory.buildRequest(str, this, null);
        createParameters().intercept(buildRequest);
        HttpResponse execute = buildRequest.execute();
        execute.setContentLoggingLimit(0);
        OAuthCredentialsResponse oAuthCredentialsResponse = new OAuthCredentialsResponse();
        UrlEncodedParser.parse(execute.parseAsString(), oAuthCredentialsResponse);
        return oAuthCredentialsResponse;
    }
}
