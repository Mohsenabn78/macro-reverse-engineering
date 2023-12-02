package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.ClientParametersAuthentication;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.CredentialRefreshListener;
import com.google.api.client.auth.oauth2.TokenRequest;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.util.Utils;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.json.webtoken.JsonWebToken;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Joiner;
import com.google.api.client.util.PemReader;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.SecurityUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes5.dex */
public class GoogleCredential extends Credential {
    @Beta

    /* renamed from: t  reason: collision with root package name */
    private static DefaultCredentialProvider f25572t = new DefaultCredentialProvider();

    /* renamed from: n  reason: collision with root package name */
    private String f25573n;

    /* renamed from: o  reason: collision with root package name */
    private String f25574o;

    /* renamed from: p  reason: collision with root package name */
    private Collection<String> f25575p;

    /* renamed from: q  reason: collision with root package name */
    private PrivateKey f25576q;

    /* renamed from: r  reason: collision with root package name */
    private String f25577r;

    /* renamed from: s  reason: collision with root package name */
    private String f25578s;

    /* loaded from: classes5.dex */
    public static class Builder extends Credential.Builder {

        /* renamed from: i  reason: collision with root package name */
        String f25579i;

        /* renamed from: j  reason: collision with root package name */
        Collection<String> f25580j;

        /* renamed from: k  reason: collision with root package name */
        PrivateKey f25581k;

        /* renamed from: l  reason: collision with root package name */
        String f25582l;

        /* renamed from: m  reason: collision with root package name */
        String f25583m;

        /* renamed from: n  reason: collision with root package name */
        String f25584n;

        public Builder() {
            super(BearerToken.authorizationHeaderAccessMethod());
            setTokenServerEncodedUrl(GoogleOAuthConstants.TOKEN_SERVER_URL);
        }

        public final String getServiceAccountId() {
            return this.f25579i;
        }

        public final PrivateKey getServiceAccountPrivateKey() {
            return this.f25581k;
        }

        @Beta
        public final String getServiceAccountPrivateKeyId() {
            return this.f25582l;
        }

        public final String getServiceAccountProjectId() {
            return this.f25583m;
        }

        public final Collection<String> getServiceAccountScopes() {
            return this.f25580j;
        }

        public final String getServiceAccountUser() {
            return this.f25584n;
        }

        public Builder setClientSecrets(String str, String str2) {
            setClientAuthentication((HttpExecuteInterceptor) new ClientParametersAuthentication(str, str2));
            return this;
        }

        @Override // com.google.api.client.auth.oauth2.Credential.Builder
        public /* bridge */ /* synthetic */ Credential.Builder setRefreshListeners(Collection collection) {
            return setRefreshListeners((Collection<CredentialRefreshListener>) collection);
        }

        public Builder setServiceAccountId(String str) {
            this.f25579i = str;
            return this;
        }

        public Builder setServiceAccountPrivateKey(PrivateKey privateKey) {
            this.f25581k = privateKey;
            return this;
        }

        public Builder setServiceAccountPrivateKeyFromP12File(File file) throws GeneralSecurityException, IOException {
            this.f25581k = SecurityUtils.loadPrivateKeyFromKeyStore(SecurityUtils.getPkcs12KeyStore(), new FileInputStream(file), "notasecret", "privatekey", "notasecret");
            return this;
        }

        @Beta
        public Builder setServiceAccountPrivateKeyFromPemFile(File file) throws GeneralSecurityException, IOException {
            this.f25581k = SecurityUtils.getRsaKeyFactory().generatePrivate(new PKCS8EncodedKeySpec(PemReader.readFirstSectionAndClose(new FileReader(file), "PRIVATE KEY").getBase64DecodedBytes()));
            return this;
        }

        @Beta
        public Builder setServiceAccountPrivateKeyId(String str) {
            this.f25582l = str;
            return this;
        }

        public Builder setServiceAccountProjectId(String str) {
            this.f25583m = str;
            return this;
        }

        public Builder setServiceAccountScopes(Collection<String> collection) {
            this.f25580j = collection;
            return this;
        }

        public Builder setServiceAccountUser(String str) {
            this.f25584n = str;
            return this;
        }

        @Override // com.google.api.client.auth.oauth2.Credential.Builder
        public Builder addRefreshListener(CredentialRefreshListener credentialRefreshListener) {
            return (Builder) super.addRefreshListener(credentialRefreshListener);
        }

        @Override // com.google.api.client.auth.oauth2.Credential.Builder
        public GoogleCredential build() {
            return new GoogleCredential(this);
        }

        @Override // com.google.api.client.auth.oauth2.Credential.Builder
        public Builder setClientAuthentication(HttpExecuteInterceptor httpExecuteInterceptor) {
            return (Builder) super.setClientAuthentication(httpExecuteInterceptor);
        }

        public Builder setClientSecrets(GoogleClientSecrets googleClientSecrets) {
            GoogleClientSecrets.Details details = googleClientSecrets.getDetails();
            setClientAuthentication((HttpExecuteInterceptor) new ClientParametersAuthentication(details.getClientId(), details.getClientSecret()));
            return this;
        }

        @Override // com.google.api.client.auth.oauth2.Credential.Builder
        public Builder setClock(Clock clock) {
            return (Builder) super.setClock(clock);
        }

        @Override // com.google.api.client.auth.oauth2.Credential.Builder
        public Builder setJsonFactory(JsonFactory jsonFactory) {
            return (Builder) super.setJsonFactory(jsonFactory);
        }

        @Override // com.google.api.client.auth.oauth2.Credential.Builder
        public Builder setRefreshListeners(Collection<CredentialRefreshListener> collection) {
            return (Builder) super.setRefreshListeners(collection);
        }

        @Override // com.google.api.client.auth.oauth2.Credential.Builder
        public Builder setRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
            return (Builder) super.setRequestInitializer(httpRequestInitializer);
        }

        @Override // com.google.api.client.auth.oauth2.Credential.Builder
        public Builder setTokenServerEncodedUrl(String str) {
            return (Builder) super.setTokenServerEncodedUrl(str);
        }

        @Override // com.google.api.client.auth.oauth2.Credential.Builder
        public Builder setTokenServerUrl(GenericUrl genericUrl) {
            return (Builder) super.setTokenServerUrl(genericUrl);
        }

        @Override // com.google.api.client.auth.oauth2.Credential.Builder
        public Builder setTransport(HttpTransport httpTransport) {
            return (Builder) super.setTransport(httpTransport);
        }
    }

    public GoogleCredential() {
        this(new Builder());
    }

    @Beta
    private static GoogleCredential b(GenericJson genericJson, HttpTransport httpTransport, JsonFactory jsonFactory) throws IOException {
        String str = (String) genericJson.get("client_id");
        String str2 = (String) genericJson.get("client_email");
        String str3 = (String) genericJson.get("private_key");
        String str4 = (String) genericJson.get("private_key_id");
        if (str != null && str2 != null && str3 != null && str4 != null) {
            Builder serviceAccountPrivateKeyId = new Builder().setTransport(httpTransport).setJsonFactory(jsonFactory).setServiceAccountId(str2).setServiceAccountScopes(Collections.emptyList()).setServiceAccountPrivateKey(d(str3)).setServiceAccountPrivateKeyId(str4);
            String str5 = (String) genericJson.get("token_uri");
            if (str5 != null) {
                serviceAccountPrivateKeyId.setTokenServerEncodedUrl(str5);
            }
            String str6 = (String) genericJson.get("project_id");
            if (str6 != null) {
                serviceAccountPrivateKeyId.setServiceAccountProjectId(str6);
            }
            return serviceAccountPrivateKeyId.build();
        }
        throw new IOException("Error reading service account credential from stream, expecting  'client_id', 'client_email', 'private_key' and 'private_key_id'.");
    }

    @Beta
    private static GoogleCredential c(GenericJson genericJson, HttpTransport httpTransport, JsonFactory jsonFactory) throws IOException {
        String str = (String) genericJson.get("client_id");
        String str2 = (String) genericJson.get("client_secret");
        String str3 = (String) genericJson.get("refresh_token");
        if (str != null && str2 != null && str3 != null) {
            GoogleCredential build = new Builder().setClientSecrets(str, str2).setTransport(httpTransport).setJsonFactory(jsonFactory).build();
            build.setRefreshToken(str3);
            build.refreshToken();
            return build;
        }
        throw new IOException("Error reading user credential from stream,  expecting 'client_id', 'client_secret' and 'refresh_token'.");
    }

    @Beta
    private static PrivateKey d(String str) throws IOException {
        PemReader.Section readFirstSectionAndClose = PemReader.readFirstSectionAndClose(new StringReader(str), "PRIVATE KEY");
        if (readFirstSectionAndClose != null) {
            try {
                return SecurityUtils.getRsaKeyFactory().generatePrivate(new PKCS8EncodedKeySpec(readFirstSectionAndClose.getBase64DecodedBytes()));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e4) {
                throw ((IOException) OAuth2Utils.a(new IOException("Unexpected exception reading PKCS data"), e4));
            }
        }
        throw new IOException("Invalid PKCS8 data.");
    }

    @Beta
    public static GoogleCredential fromStream(InputStream inputStream) throws IOException {
        return fromStream(inputStream, Utils.getDefaultTransport(), Utils.getDefaultJsonFactory());
    }

    @Beta
    public static GoogleCredential getApplicationDefault() throws IOException {
        return getApplicationDefault(Utils.getDefaultTransport(), Utils.getDefaultJsonFactory());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.api.client.auth.oauth2.Credential
    @Beta
    public TokenResponse a() throws IOException {
        if (this.f25576q == null) {
            return super.a();
        }
        JsonWebSignature.Header header = new JsonWebSignature.Header();
        header.setAlgorithm("RS256");
        header.setType("JWT");
        header.setKeyId(this.f25577r);
        JsonWebToken.Payload payload = new JsonWebToken.Payload();
        long currentTimeMillis = getClock().currentTimeMillis();
        payload.setIssuer(this.f25573n);
        payload.setAudience(getTokenServerEncodedUrl());
        long j4 = currentTimeMillis / 1000;
        payload.setIssuedAtTimeSeconds(Long.valueOf(j4));
        payload.setExpirationTimeSeconds(Long.valueOf(j4 + 3600));
        payload.setSubject(this.f25578s);
        payload.put("scope", (Object) Joiner.on(' ').join(this.f25575p));
        try {
            String signUsingRsaSha256 = JsonWebSignature.signUsingRsaSha256(this.f25576q, getJsonFactory(), header, payload);
            TokenRequest tokenRequest = new TokenRequest(getTransport(), getJsonFactory(), new GenericUrl(getTokenServerEncodedUrl()), "urn:ietf:params:oauth:grant-type:jwt-bearer");
            tokenRequest.put("assertion", (Object) signUsingRsaSha256);
            return tokenRequest.execute();
        } catch (GeneralSecurityException e4) {
            IOException iOException = new IOException();
            iOException.initCause(e4);
            throw iOException;
        }
    }

    @Beta
    public GoogleCredential createScoped(Collection<String> collection) {
        if (this.f25576q == null) {
            return this;
        }
        return new Builder().setServiceAccountPrivateKey(this.f25576q).setServiceAccountPrivateKeyId(this.f25577r).setServiceAccountId(this.f25573n).setServiceAccountProjectId(this.f25574o).setServiceAccountUser(this.f25578s).setServiceAccountScopes(collection).setTokenServerEncodedUrl(getTokenServerEncodedUrl()).setTransport(getTransport()).setJsonFactory(getJsonFactory()).setClock(getClock()).build();
    }

    @Beta
    public boolean createScopedRequired() {
        if (this.f25576q == null) {
            return false;
        }
        Collection<String> collection = this.f25575p;
        if (collection != null && !collection.isEmpty()) {
            return false;
        }
        return true;
    }

    public final String getServiceAccountId() {
        return this.f25573n;
    }

    public final PrivateKey getServiceAccountPrivateKey() {
        return this.f25576q;
    }

    @Beta
    public final String getServiceAccountPrivateKeyId() {
        return this.f25577r;
    }

    public final String getServiceAccountProjectId() {
        return this.f25574o;
    }

    public final Collection<String> getServiceAccountScopes() {
        return this.f25575p;
    }

    public final String getServiceAccountScopesAsString() {
        if (this.f25575p == null) {
            return null;
        }
        return Joiner.on(' ').join(this.f25575p);
    }

    public final String getServiceAccountUser() {
        return this.f25578s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GoogleCredential(Builder builder) {
        super(builder);
        if (builder.f25581k == null) {
            Preconditions.checkArgument(builder.f25579i == null && builder.f25580j == null && builder.f25584n == null);
            return;
        }
        this.f25573n = (String) Preconditions.checkNotNull(builder.f25579i);
        this.f25574o = builder.f25583m;
        Collection<String> collection = builder.f25580j;
        this.f25575p = collection == null ? Collections.emptyList() : Collections.unmodifiableCollection(collection);
        this.f25576q = builder.f25581k;
        this.f25577r = builder.f25582l;
        this.f25578s = builder.f25584n;
    }

    @Beta
    public static GoogleCredential fromStream(InputStream inputStream, HttpTransport httpTransport, JsonFactory jsonFactory) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(httpTransport);
        Preconditions.checkNotNull(jsonFactory);
        GenericJson genericJson = (GenericJson) new JsonObjectParser(jsonFactory).parseAndClose(inputStream, OAuth2Utils.f25599a, (Class<Object>) GenericJson.class);
        String str = (String) genericJson.get("type");
        if (str != null) {
            if ("authorized_user".equals(str)) {
                return c(genericJson, httpTransport, jsonFactory);
            }
            if ("service_account".equals(str)) {
                return b(genericJson, httpTransport, jsonFactory);
            }
            throw new IOException(String.format("Error reading credentials from stream, 'type' value '%s' not recognized. Expecting '%s' or '%s'.", str, "authorized_user", "service_account"));
        }
        throw new IOException("Error reading credentials from stream, 'type' field not specified.");
    }

    @Beta
    public static GoogleCredential getApplicationDefault(HttpTransport httpTransport, JsonFactory jsonFactory) throws IOException {
        Preconditions.checkNotNull(httpTransport);
        Preconditions.checkNotNull(jsonFactory);
        return f25572t.j(httpTransport, jsonFactory);
    }

    @Override // com.google.api.client.auth.oauth2.Credential
    public GoogleCredential setAccessToken(String str) {
        return (GoogleCredential) super.setAccessToken(str);
    }

    @Override // com.google.api.client.auth.oauth2.Credential
    public GoogleCredential setExpirationTimeMilliseconds(Long l4) {
        return (GoogleCredential) super.setExpirationTimeMilliseconds(l4);
    }

    @Override // com.google.api.client.auth.oauth2.Credential
    public GoogleCredential setExpiresInSeconds(Long l4) {
        return (GoogleCredential) super.setExpiresInSeconds(l4);
    }

    @Override // com.google.api.client.auth.oauth2.Credential
    public GoogleCredential setFromTokenResponse(TokenResponse tokenResponse) {
        return (GoogleCredential) super.setFromTokenResponse(tokenResponse);
    }

    @Override // com.google.api.client.auth.oauth2.Credential
    public GoogleCredential setRefreshToken(String str) {
        if (str != null) {
            Preconditions.checkArgument((getJsonFactory() == null || getTransport() == null || getClientAuthentication() == null) ? false : true, "Please use the Builder and call setJsonFactory, setTransport and setClientSecrets");
        }
        return (GoogleCredential) super.setRefreshToken(str);
    }
}
