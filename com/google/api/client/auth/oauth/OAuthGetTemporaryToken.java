package com.google.api.client.auth.oauth;

import com.google.api.client.util.Beta;

@Beta
/* loaded from: classes5.dex */
public class OAuthGetTemporaryToken extends AbstractOAuthGetToken {
    public String callback;

    public OAuthGetTemporaryToken(String str) {
        super(str);
    }

    @Override // com.google.api.client.auth.oauth.AbstractOAuthGetToken
    public OAuthParameters createParameters() {
        OAuthParameters createParameters = super.createParameters();
        createParameters.callback = this.callback;
        return createParameters;
    }
}
