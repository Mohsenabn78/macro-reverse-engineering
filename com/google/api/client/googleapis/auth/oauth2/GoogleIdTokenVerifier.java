package com.google.api.client.googleapis.auth.oauth2;

import com.google.android.gms.auth.api.credentials.IdentityProviders;
import com.google.api.client.auth.openidconnect.IdToken;
import com.google.api.client.auth.openidconnect.IdTokenVerifier;
import com.google.api.client.googleapis.auth.oauth2.GooglePublicKeysManager;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Beta
/* loaded from: classes5.dex */
public class GoogleIdTokenVerifier extends IdTokenVerifier {

    /* renamed from: e  reason: collision with root package name */
    private final GooglePublicKeysManager f25585e;

    @Beta
    /* loaded from: classes5.dex */
    public static class Builder extends IdTokenVerifier.Builder {

        /* renamed from: e  reason: collision with root package name */
        GooglePublicKeysManager f25586e;

        public Builder(HttpTransport httpTransport, JsonFactory jsonFactory) {
            this(new GooglePublicKeysManager(httpTransport, jsonFactory));
        }

        public final JsonFactory getJsonFactory() {
            return this.f25586e.getJsonFactory();
        }

        public final GooglePublicKeysManager getPublicCerts() {
            return this.f25586e;
        }

        @Deprecated
        public final String getPublicCertsEncodedUrl() {
            return this.f25586e.getPublicCertsEncodedUrl();
        }

        public final HttpTransport getTransport() {
            return this.f25586e.getTransport();
        }

        @Override // com.google.api.client.auth.openidconnect.IdTokenVerifier.Builder
        public /* bridge */ /* synthetic */ IdTokenVerifier.Builder setAudience(Collection collection) {
            return setAudience((Collection<String>) collection);
        }

        @Override // com.google.api.client.auth.openidconnect.IdTokenVerifier.Builder
        public /* bridge */ /* synthetic */ IdTokenVerifier.Builder setIssuers(Collection collection) {
            return setIssuers((Collection<String>) collection);
        }

        @Deprecated
        public Builder setPublicCertsEncodedUrl(String str) {
            this.f25586e = new GooglePublicKeysManager.Builder(getTransport(), getJsonFactory()).setPublicCertsEncodedUrl(str).setClock(this.f25586e.getClock()).build();
            return this;
        }

        public Builder(GooglePublicKeysManager googlePublicKeysManager) {
            this.f25586e = (GooglePublicKeysManager) Preconditions.checkNotNull(googlePublicKeysManager);
            setIssuers((Collection<String>) Arrays.asList("accounts.google.com", IdentityProviders.GOOGLE));
        }

        @Override // com.google.api.client.auth.openidconnect.IdTokenVerifier.Builder
        public GoogleIdTokenVerifier build() {
            return new GoogleIdTokenVerifier(this);
        }

        @Override // com.google.api.client.auth.openidconnect.IdTokenVerifier.Builder
        public Builder setAcceptableTimeSkewSeconds(long j4) {
            return (Builder) super.setAcceptableTimeSkewSeconds(j4);
        }

        @Override // com.google.api.client.auth.openidconnect.IdTokenVerifier.Builder
        public Builder setAudience(Collection<String> collection) {
            return (Builder) super.setAudience(collection);
        }

        @Override // com.google.api.client.auth.openidconnect.IdTokenVerifier.Builder
        public Builder setClock(Clock clock) {
            return (Builder) super.setClock(clock);
        }

        @Override // com.google.api.client.auth.openidconnect.IdTokenVerifier.Builder
        public Builder setIssuer(String str) {
            return (Builder) super.setIssuer(str);
        }

        @Override // com.google.api.client.auth.openidconnect.IdTokenVerifier.Builder
        public Builder setIssuers(Collection<String> collection) {
            return (Builder) super.setIssuers(collection);
        }
    }

    public GoogleIdTokenVerifier(HttpTransport httpTransport, JsonFactory jsonFactory) {
        this(new Builder(httpTransport, jsonFactory));
    }

    @Deprecated
    public final long getExpirationTimeMilliseconds() {
        return this.f25585e.getExpirationTimeMilliseconds();
    }

    public final JsonFactory getJsonFactory() {
        return this.f25585e.getJsonFactory();
    }

    @Deprecated
    public final String getPublicCertsEncodedUrl() {
        return this.f25585e.getPublicCertsEncodedUrl();
    }

    @Deprecated
    public final List<PublicKey> getPublicKeys() throws GeneralSecurityException, IOException {
        return this.f25585e.getPublicKeys();
    }

    public final GooglePublicKeysManager getPublicKeysManager() {
        return this.f25585e;
    }

    public final HttpTransport getTransport() {
        return this.f25585e.getTransport();
    }

    @Deprecated
    public GoogleIdTokenVerifier loadPublicCerts() throws GeneralSecurityException, IOException {
        this.f25585e.refresh();
        return this;
    }

    public boolean verify(GoogleIdToken googleIdToken) throws GeneralSecurityException, IOException {
        if (super.verify((IdToken) googleIdToken)) {
            for (PublicKey publicKey : this.f25585e.getPublicKeys()) {
                if (googleIdToken.verifySignature(publicKey)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public GoogleIdTokenVerifier(GooglePublicKeysManager googlePublicKeysManager) {
        this(new Builder(googlePublicKeysManager));
    }

    protected GoogleIdTokenVerifier(Builder builder) {
        super(builder);
        this.f25585e = builder.f25586e;
    }

    public GoogleIdToken verify(String str) throws GeneralSecurityException, IOException {
        GoogleIdToken parse = GoogleIdToken.parse(getJsonFactory(), str);
        if (verify(parse)) {
            return parse;
        }
        return null;
    }
}
