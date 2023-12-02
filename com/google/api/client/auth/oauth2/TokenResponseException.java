package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpResponseException;

/* loaded from: classes5.dex */
public class TokenResponseException extends HttpResponseException {
    private static final long serialVersionUID = 4020689092957439244L;

    /* renamed from: b  reason: collision with root package name */
    private final transient TokenErrorResponse f25531b;

    TokenResponseException(HttpResponseException.Builder builder, TokenErrorResponse tokenErrorResponse) {
        super(builder);
        this.f25531b = tokenErrorResponse;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.google.api.client.auth.oauth2.TokenErrorResponse] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v9, types: [com.google.api.client.auth.oauth2.TokenErrorResponse, com.google.api.client.json.GenericJson] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.api.client.auth.oauth2.TokenResponseException from(com.google.api.client.json.JsonFactory r6, com.google.api.client.http.HttpResponse r7) {
        /*
            com.google.api.client.http.HttpResponseException$Builder r0 = new com.google.api.client.http.HttpResponseException$Builder
            int r1 = r7.getStatusCode()
            java.lang.String r2 = r7.getStatusMessage()
            com.google.api.client.http.HttpHeaders r3 = r7.getHeaders()
            r0.<init>(r1, r2, r3)
            com.google.api.client.util.Preconditions.checkNotNull(r6)
            java.lang.String r1 = r7.getContentType()
            r2 = 0
            boolean r3 = r7.isSuccessStatusCode()     // Catch: java.io.IOException -> L55
            if (r3 != 0) goto L4d
            if (r1 == 0) goto L4d
            java.io.InputStream r3 = r7.getContent()     // Catch: java.io.IOException -> L55
            if (r3 == 0) goto L4d
            java.lang.String r3 = "application/json; charset=UTF-8"
            boolean r1 = com.google.api.client.http.HttpMediaType.equalsIgnoreParameters(r3, r1)     // Catch: java.io.IOException -> L55
            if (r1 == 0) goto L4d
            com.google.api.client.json.JsonObjectParser r1 = new com.google.api.client.json.JsonObjectParser     // Catch: java.io.IOException -> L55
            r1.<init>(r6)     // Catch: java.io.IOException -> L55
            java.io.InputStream r6 = r7.getContent()     // Catch: java.io.IOException -> L55
            java.nio.charset.Charset r3 = r7.getContentCharset()     // Catch: java.io.IOException -> L55
            java.lang.Class<com.google.api.client.auth.oauth2.TokenErrorResponse> r4 = com.google.api.client.auth.oauth2.TokenErrorResponse.class
            java.lang.Object r6 = r1.parseAndClose(r6, r3, r4)     // Catch: java.io.IOException -> L55
            com.google.api.client.auth.oauth2.TokenErrorResponse r6 = (com.google.api.client.auth.oauth2.TokenErrorResponse) r6     // Catch: java.io.IOException -> L55
            java.lang.String r1 = r6.toPrettyString()     // Catch: java.io.IOException -> L4b
            r2 = r6
            r6 = r1
            goto L51
        L4b:
            r1 = move-exception
            goto L57
        L4d:
            java.lang.String r6 = r7.parseAsString()     // Catch: java.io.IOException -> L55
        L51:
            r5 = r2
            r2 = r6
            r6 = r5
            goto L5a
        L55:
            r1 = move-exception
            r6 = r2
        L57:
            r1.printStackTrace()
        L5a:
            java.lang.StringBuilder r7 = com.google.api.client.http.HttpResponseException.computeMessageBuffer(r7)
            boolean r1 = com.google.api.client.util.Strings.isNullOrEmpty(r2)
            if (r1 != 0) goto L6f
            java.lang.String r1 = com.google.api.client.util.StringUtils.LINE_SEPARATOR
            r7.append(r1)
            r7.append(r2)
            r0.setContent(r2)
        L6f:
            java.lang.String r7 = r7.toString()
            r0.setMessage(r7)
            com.google.api.client.auth.oauth2.TokenResponseException r7 = new com.google.api.client.auth.oauth2.TokenResponseException
            r7.<init>(r0, r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.auth.oauth2.TokenResponseException.from(com.google.api.client.json.JsonFactory, com.google.api.client.http.HttpResponse):com.google.api.client.auth.oauth2.TokenResponseException");
    }

    public final TokenErrorResponse getDetails() {
        return this.f25531b;
    }
}
