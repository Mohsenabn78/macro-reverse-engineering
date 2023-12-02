package com.google.api.client.googleapis.testing.auth.oauth2;

import com.google.api.client.googleapis.auth.oauth2.GoogleOAuthConstants;
import com.google.api.client.googleapis.testing.TestUtils;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Beta
/* loaded from: classes5.dex */
public class MockTokenServerTransport extends MockHttpTransport {

    /* renamed from: j  reason: collision with root package name */
    static final JsonFactory f25733j = new JacksonFactory();

    /* renamed from: f  reason: collision with root package name */
    final String f25734f;

    /* renamed from: g  reason: collision with root package name */
    Map<String, String> f25735g;

    /* renamed from: h  reason: collision with root package name */
    Map<String, String> f25736h;

    /* renamed from: i  reason: collision with root package name */
    Map<String, String> f25737i;

    public MockTokenServerTransport() {
        this(GoogleOAuthConstants.TOKEN_SERVER_URL);
    }

    public void addClient(String str, String str2) {
        this.f25736h.put(str, str2);
    }

    public void addRefreshToken(String str, String str2) {
        this.f25737i.put(str, str2);
    }

    public void addServiceAccount(String str, String str2) {
        this.f25735g.put(str, str2);
    }

    @Override // com.google.api.client.testing.http.MockHttpTransport, com.google.api.client.http.HttpTransport
    public LowLevelHttpRequest buildRequest(String str, String str2) throws IOException {
        if (str2.equals(this.f25734f)) {
            return new MockLowLevelHttpRequest(str2) { // from class: com.google.api.client.googleapis.testing.auth.oauth2.MockTokenServerTransport.1
                @Override // com.google.api.client.testing.http.MockLowLevelHttpRequest, com.google.api.client.http.LowLevelHttpRequest
                public LowLevelHttpResponse execute() throws IOException {
                    String str3;
                    Map<String, String> parseQuery = TestUtils.parseQuery(getContentAsString());
                    String str4 = parseQuery.get("client_id");
                    if (str4 != null) {
                        if (MockTokenServerTransport.this.f25736h.containsKey(str4)) {
                            String str5 = parseQuery.get("client_secret");
                            String str6 = MockTokenServerTransport.this.f25736h.get(str4);
                            if (str5 != null && str5.equals(str6)) {
                                String str7 = parseQuery.get("refresh_token");
                                if (MockTokenServerTransport.this.f25737i.containsKey(str7)) {
                                    str3 = MockTokenServerTransport.this.f25737i.get(str7);
                                } else {
                                    throw new IOException("Refresh Token not found.");
                                }
                            } else {
                                throw new IOException("Client secret not found.");
                            }
                        } else {
                            throw new IOException("Client ID not found.");
                        }
                    } else if (parseQuery.containsKey("grant_type")) {
                        if ("urn:ietf:params:oauth:grant-type:jwt-bearer".equals(parseQuery.get("grant_type"))) {
                            JsonWebSignature parse = JsonWebSignature.parse(MockTokenServerTransport.f25733j, parseQuery.get("assertion"));
                            String issuer = parse.getPayload().getIssuer();
                            if (MockTokenServerTransport.this.f25735g.containsKey(issuer)) {
                                String str8 = MockTokenServerTransport.this.f25735g.get(issuer);
                                String str9 = (String) parse.getPayload().get("scope");
                                if (str9 != null && str9.length() != 0) {
                                    str3 = str8;
                                } else {
                                    throw new IOException("Scopes not found.");
                                }
                            } else {
                                throw new IOException("Service Account Email not found as issuer.");
                            }
                        } else {
                            throw new IOException("Unexpected Grant Type.");
                        }
                    } else {
                        throw new IOException("Unknown token type.");
                    }
                    GenericJson genericJson = new GenericJson();
                    genericJson.setFactory(MockTokenServerTransport.f25733j);
                    genericJson.put("access_token", (Object) str3);
                    genericJson.put("expires_in", (Object) 3600000);
                    genericJson.put("token_type", (Object) "Bearer");
                    return new MockLowLevelHttpResponse().setContentType(Json.MEDIA_TYPE).setContent(genericJson.toPrettyString());
                }
            };
        }
        return super.buildRequest(str, str2);
    }

    public MockTokenServerTransport(String str) {
        this.f25735g = new HashMap();
        this.f25736h = new HashMap();
        this.f25737i = new HashMap();
        this.f25734f = str;
    }
}
