package com.google.api.client.auth.oauth2;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.DataStoreFactory;
import java.io.IOException;

@Beta
/* loaded from: classes5.dex */
public final class DataStoreCredentialRefreshListener implements CredentialRefreshListener {

    /* renamed from: a  reason: collision with root package name */
    private final DataStore<StoredCredential> f25521a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25522b;

    public DataStoreCredentialRefreshListener(String str, DataStoreFactory dataStoreFactory) throws IOException {
        this(str, StoredCredential.getDefaultDataStore(dataStoreFactory));
    }

    public DataStore<StoredCredential> getCredentialDataStore() {
        return this.f25521a;
    }

    public void makePersistent(Credential credential) throws IOException {
        this.f25521a.set(this.f25522b, new StoredCredential(credential));
    }

    @Override // com.google.api.client.auth.oauth2.CredentialRefreshListener
    public void onTokenErrorResponse(Credential credential, TokenErrorResponse tokenErrorResponse) throws IOException {
        makePersistent(credential);
    }

    @Override // com.google.api.client.auth.oauth2.CredentialRefreshListener
    public void onTokenResponse(Credential credential, TokenResponse tokenResponse) throws IOException {
        makePersistent(credential);
    }

    public DataStoreCredentialRefreshListener(String str, DataStore<StoredCredential> dataStore) {
        this.f25522b = (String) Preconditions.checkNotNull(str);
        this.f25521a = (DataStore) Preconditions.checkNotNull(dataStore);
    }
}
