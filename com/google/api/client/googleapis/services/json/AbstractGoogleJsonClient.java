package com.google.api.client.googleapis.services.json;

import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;

/* loaded from: classes5.dex */
public abstract class AbstractGoogleJsonClient extends AbstractGoogleClient {

    /* loaded from: classes5.dex */
    public static abstract class Builder extends AbstractGoogleClient.Builder {
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Builder(com.google.api.client.http.HttpTransport r7, com.google.api.client.json.JsonFactory r8, java.lang.String r9, java.lang.String r10, com.google.api.client.http.HttpRequestInitializer r11, boolean r12) {
            /*
                r6 = this;
                com.google.api.client.json.JsonObjectParser$Builder r0 = new com.google.api.client.json.JsonObjectParser$Builder
                r0.<init>(r8)
                if (r12 == 0) goto L14
                java.lang.String r8 = "data"
                java.lang.String r12 = "error"
                java.lang.String[] r8 = new java.lang.String[]{r8, r12}
                java.util.List r8 = java.util.Arrays.asList(r8)
                goto L18
            L14:
                java.util.Set r8 = java.util.Collections.emptySet()
            L18:
                com.google.api.client.json.JsonObjectParser$Builder r8 = r0.setWrapperKeys(r8)
                com.google.api.client.json.JsonObjectParser r4 = r8.build()
                r0 = r6
                r1 = r7
                r2 = r9
                r3 = r10
                r5 = r11
                r0.<init>(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder.<init>(com.google.api.client.http.HttpTransport, com.google.api.client.json.JsonFactory, java.lang.String, java.lang.String, com.google.api.client.http.HttpRequestInitializer, boolean):void");
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public abstract AbstractGoogleJsonClient build();

        public final JsonFactory getJsonFactory() {
            return getObjectParser().getJsonFactory();
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public final JsonObjectParser getObjectParser() {
            return (JsonObjectParser) super.getObjectParser();
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setApplicationName(String str) {
            return (Builder) super.setApplicationName(str);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
            return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setRootUrl(String str) {
            return (Builder) super.setRootUrl(str);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setServicePath(String str) {
            return (Builder) super.setServicePath(str);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setSuppressAllChecks(boolean z3) {
            return (Builder) super.setSuppressAllChecks(z3);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setSuppressPatternChecks(boolean z3) {
            return (Builder) super.setSuppressPatternChecks(z3);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setSuppressRequiredParameterChecks(boolean z3) {
            return (Builder) super.setSuppressRequiredParameterChecks(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractGoogleJsonClient(Builder builder) {
        super(builder);
    }

    public final JsonFactory getJsonFactory() {
        return getObjectParser().getJsonFactory();
    }

    @Override // com.google.api.client.googleapis.services.AbstractGoogleClient
    public JsonObjectParser getObjectParser() {
        return (JsonObjectParser) super.getObjectParser();
    }
}
