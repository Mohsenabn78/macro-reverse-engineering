package com.google.api.client.googleapis.testing.compute;

import com.google.api.client.googleapis.auth.oauth2.OAuth2Utils;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
/* loaded from: classes5.dex */
public class MockMetadataServerTransport extends MockHttpTransport {

    /* renamed from: h  reason: collision with root package name */
    private static final String f25739h;

    /* renamed from: i  reason: collision with root package name */
    private static final String f25740i;

    /* renamed from: j  reason: collision with root package name */
    static final JsonFactory f25741j;

    /* renamed from: f  reason: collision with root package name */
    String f25742f;

    /* renamed from: g  reason: collision with root package name */
    Integer f25743g;

    static {
        String metadataServerUrl = OAuth2Utils.getMetadataServerUrl();
        f25739h = metadataServerUrl;
        f25740i = String.valueOf(metadataServerUrl).concat("/computeMetadata/v1/instance/service-accounts/default/token");
        f25741j = new JacksonFactory();
    }

    public MockMetadataServerTransport(String str) {
        this.f25742f = str;
    }

    @Override // com.google.api.client.testing.http.MockHttpTransport, com.google.api.client.http.HttpTransport
    public LowLevelHttpRequest buildRequest(String str, String str2) throws IOException {
        if (str2.equals(f25740i)) {
            return new MockLowLevelHttpRequest(str2) { // from class: com.google.api.client.googleapis.testing.compute.MockMetadataServerTransport.1
                @Override // com.google.api.client.testing.http.MockLowLevelHttpRequest, com.google.api.client.http.LowLevelHttpRequest
                public LowLevelHttpResponse execute() throws IOException {
                    if (MockMetadataServerTransport.this.f25743g != null) {
                        return new MockLowLevelHttpResponse().setStatusCode(MockMetadataServerTransport.this.f25743g.intValue()).setContent("Token Fetch Error");
                    }
                    if ("Google".equals(getFirstHeaderValue("Metadata-Flavor"))) {
                        GenericJson genericJson = new GenericJson();
                        genericJson.setFactory(MockMetadataServerTransport.f25741j);
                        genericJson.put("access_token", (Object) MockMetadataServerTransport.this.f25742f);
                        genericJson.put("expires_in", (Object) 3600000);
                        genericJson.put("token_type", (Object) "Bearer");
                        return new MockLowLevelHttpResponse().setContentType(Json.MEDIA_TYPE).setContent(genericJson.toPrettyString());
                    }
                    throw new IOException("Metadata request header not found.");
                }
            };
        }
        if (str2.equals(f25739h)) {
            return new MockLowLevelHttpRequest(str2) { // from class: com.google.api.client.googleapis.testing.compute.MockMetadataServerTransport.2
                @Override // com.google.api.client.testing.http.MockLowLevelHttpRequest, com.google.api.client.http.LowLevelHttpRequest
                public LowLevelHttpResponse execute() {
                    MockLowLevelHttpResponse mockLowLevelHttpResponse = new MockLowLevelHttpResponse();
                    mockLowLevelHttpResponse.addHeader("Metadata-Flavor", "Google");
                    return mockLowLevelHttpResponse;
                }
            };
        }
        return super.buildRequest(str, str2);
    }

    public void setTokenRequestStatusCode(Integer num) {
        this.f25743g = num;
    }
}
