package com.google.api.client.auth.oauth2;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.IOException;

@Beta
@Deprecated
/* loaded from: classes5.dex */
public final class CredentialStoreRefreshListener implements CredentialRefreshListener {

    /* renamed from: a  reason: collision with root package name */
    private final CredentialStore f25519a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25520b;

    public CredentialStoreRefreshListener(String str, CredentialStore credentialStore) {
        this.f25520b = (String) Preconditions.checkNotNull(str);
        this.f25519a = (CredentialStore) Preconditions.checkNotNull(credentialStore);
    }

    public CredentialStore getCredentialStore() {
        return this.f25519a;
    }

    public void makePersistent(Credential credential) throws IOException {
        this.f25519a.store(this.f25520b, credential);
    }

    @Override // com.google.api.client.auth.oauth2.CredentialRefreshListener
    public void onTokenErrorResponse(Credential credential, TokenErrorResponse tokenErrorResponse) throws IOException {
        makePersistent(credential);
    }

    @Override // com.google.api.client.auth.oauth2.CredentialRefreshListener
    public void onTokenResponse(Credential credential, TokenResponse tokenResponse) throws IOException {
        makePersistent(credential);
    }
}
