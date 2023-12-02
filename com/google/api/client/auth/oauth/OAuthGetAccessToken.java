package com.google.api.client.auth.oauth;

import com.google.api.client.util.Beta;

@Beta
/* loaded from: classes5.dex */
public class OAuthGetAccessToken extends AbstractOAuthGetToken {
    public String temporaryToken;
    public String verifier;

    public OAuthGetAccessToken(String str) {
        super(str);
    }

    @Override // com.google.api.client.auth.oauth.AbstractOAuthGetToken
    public OAuthParameters createParameters() {
        OAuthParameters createParameters = super.createParameters();
        createParameters.token = this.temporaryToken;
        createParameters.verifier = this.verifier;
        return createParameters;
    }
}
