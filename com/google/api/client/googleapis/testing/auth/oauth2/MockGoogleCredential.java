package com.google.api.client.googleapis.testing.auth.oauth2;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import java.io.IOException;

@Beta
/* loaded from: classes5.dex */
public class MockGoogleCredential extends GoogleCredential {
    public static final String ACCESS_TOKEN = "access_xyz";
    public static final String REFRESH_TOKEN = "refresh123";

    /* renamed from: u  reason: collision with root package name */
    private static final String f25732u = String.format("{\"access_token\": \"%s\", \"expires_in\":  %s, \"refresh_token\": \"%s\", \"token_type\": \"%s\"}", ACCESS_TOKEN, "3600", REFRESH_TOKEN, "Bearer");

    public MockGoogleCredential(Builder builder) {
        super(builder);
    }

    public static MockHttpTransport newMockHttpTransportWithSampleTokenResponse() {
        return new MockHttpTransport.Builder().setLowLevelHttpRequest(new MockLowLevelHttpRequest().setResponse(new MockLowLevelHttpResponse().setContentType(Json.MEDIA_TYPE).setContent(f25732u))).build();
    }

    @Beta
    /* loaded from: classes5.dex */
    public static class Builder extends GoogleCredential.Builder {
        @Override // com.google.api.client.googleapis.auth.oauth2.GoogleCredential.Builder, com.google.api.client.auth.oauth2.Credential.Builder
        public MockGoogleCredential build() {
            if (getTransport() == null) {
                setTransport((HttpTransport) new MockHttpTransport.Builder().build());
            }
            if (getClientAuthentication() == null) {
                setClientAuthentication((HttpExecuteInterceptor) new MockClientAuthentication());
            }
            if (getJsonFactory() == null) {
                setJsonFactory((JsonFactory) new JacksonFactory());
            }
            return new MockGoogleCredential(this);
        }

        @Override // com.google.api.client.googleapis.auth.oauth2.GoogleCredential.Builder, com.google.api.client.auth.oauth2.Credential.Builder
        public Builder setClientAuthentication(HttpExecuteInterceptor httpExecuteInterceptor) {
            return (Builder) super.setClientAuthentication(httpExecuteInterceptor);
        }

        @Override // com.google.api.client.googleapis.auth.oauth2.GoogleCredential.Builder, com.google.api.client.auth.oauth2.Credential.Builder
        public Builder setClock(Clock clock) {
            return (Builder) super.setClock(clock);
        }

        @Override // com.google.api.client.googleapis.auth.oauth2.GoogleCredential.Builder, com.google.api.client.auth.oauth2.Credential.Builder
        public Builder setJsonFactory(JsonFactory jsonFactory) {
            return (Builder) super.setJsonFactory(jsonFactory);
        }

        @Override // com.google.api.client.googleapis.auth.oauth2.GoogleCredential.Builder, com.google.api.client.auth.oauth2.Credential.Builder
        public Builder setTransport(HttpTransport httpTransport) {
            return (Builder) super.setTransport(httpTransport);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Beta
    /* loaded from: classes5.dex */
    public static class MockClientAuthentication implements HttpExecuteInterceptor {
        private MockClientAuthentication() {
        }

        @Override // com.google.api.client.http.HttpExecuteInterceptor
        public void intercept(HttpRequest httpRequest) throws IOException {
        }
    }
}
