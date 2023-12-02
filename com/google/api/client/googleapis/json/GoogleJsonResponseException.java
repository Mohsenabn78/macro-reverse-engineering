package com.google.api.client.googleapis.json;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Preconditions;
import java.io.IOException;

/* loaded from: classes5.dex */
public class GoogleJsonResponseException extends HttpResponseException {
    private static final long serialVersionUID = 409811126989994864L;

    /* renamed from: b  reason: collision with root package name */
    private final transient GoogleJsonError f25645b;

    public GoogleJsonResponseException(HttpResponseException.Builder builder, GoogleJsonError googleJsonError) {
        super(builder);
        this.f25645b = googleJsonError;
    }

    public static HttpResponse execute(JsonFactory jsonFactory, HttpRequest httpRequest) throws GoogleJsonResponseException, IOException {
        Preconditions.checkNotNull(jsonFactory);
        boolean throwExceptionOnExecuteError = httpRequest.getThrowExceptionOnExecuteError();
        if (throwExceptionOnExecuteError) {
            httpRequest.setThrowExceptionOnExecuteError(false);
        }
        HttpResponse execute = httpRequest.execute();
        httpRequest.setThrowExceptionOnExecuteError(throwExceptionOnExecuteError);
        if (throwExceptionOnExecuteError && !execute.isSuccessStatusCode()) {
            throw from(jsonFactory, execute);
        }
        return execute;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009c A[Catch: IOException -> 0x0087, TryCatch #1 {IOException -> 0x0087, blocks: (B:48:0x0098, B:50:0x009f, B:49:0x009c, B:39:0x0083, B:43:0x008d), top: B:61:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.api.client.googleapis.json.GoogleJsonResponseException from(com.google.api.client.json.JsonFactory r5, com.google.api.client.http.HttpResponse r6) {
        /*
            com.google.api.client.http.HttpResponseException$Builder r0 = new com.google.api.client.http.HttpResponseException$Builder
            int r1 = r6.getStatusCode()
            java.lang.String r2 = r6.getStatusMessage()
            com.google.api.client.http.HttpHeaders r3 = r6.getHeaders()
            r0.<init>(r1, r2, r3)
            com.google.api.client.util.Preconditions.checkNotNull(r5)
            r1 = 0
            boolean r2 = r6.isSuccessStatusCode()     // Catch: java.io.IOException -> La5
            if (r2 != 0) goto La0
            java.lang.String r2 = "application/json; charset=UTF-8"
            java.lang.String r3 = r6.getContentType()     // Catch: java.io.IOException -> La5
            boolean r2 = com.google.api.client.http.HttpMediaType.equalsIgnoreParameters(r2, r3)     // Catch: java.io.IOException -> La5
            if (r2 == 0) goto La0
            java.io.InputStream r2 = r6.getContent()     // Catch: java.io.IOException -> La5
            if (r2 == 0) goto La0
            java.io.InputStream r2 = r6.getContent()     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L7b
            com.google.api.client.json.JsonParser r5 = r5.createJsonParser(r2)     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L7b
            com.google.api.client.json.JsonToken r2 = r5.getCurrentToken()     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L74
            if (r2 != 0) goto L3f
            com.google.api.client.json.JsonToken r2 = r5.nextToken()     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L74
        L3f:
            if (r2 == 0) goto L68
            java.lang.String r2 = "error"
            r5.skipToKey(r2)     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L74
            com.google.api.client.json.JsonToken r2 = r5.getCurrentToken()     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L74
            com.google.api.client.json.JsonToken r3 = com.google.api.client.json.JsonToken.END_OBJECT     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L74
            if (r2 == r3) goto L68
            java.lang.Class<com.google.api.client.googleapis.json.GoogleJsonError> r2 = com.google.api.client.googleapis.json.GoogleJsonError.class
            java.lang.Object r2 = r5.parseAndClose(r2)     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L74
            com.google.api.client.googleapis.json.GoogleJsonError r2 = (com.google.api.client.googleapis.json.GoogleJsonError) r2     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L74
            java.lang.String r1 = r2.toPrettyString()     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L63
            r4 = r2
            r2 = r1
            r1 = r4
            goto L69
        L5e:
            r3 = move-exception
            r4 = r3
            r3 = r2
            r2 = r4
            goto L94
        L63:
            r3 = move-exception
            r4 = r3
            r3 = r2
            r2 = r4
            goto L7e
        L68:
            r2 = r1
        L69:
            if (r1 != 0) goto Laa
            r5.close()     // Catch: java.io.IOException -> L6f
            goto Laa
        L6f:
            r5 = move-exception
            goto La7
        L71:
            r2 = move-exception
            r3 = r1
            goto L94
        L74:
            r2 = move-exception
            r3 = r1
            goto L7e
        L77:
            r2 = move-exception
            r5 = r1
            r3 = r5
            goto L94
        L7b:
            r2 = move-exception
            r5 = r1
            r3 = r5
        L7e:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L93
            if (r5 != 0) goto L8b
            r6.ignore()     // Catch: java.io.IOException -> L87
            goto L90
        L87:
            r5 = move-exception
            r2 = r1
            r1 = r3
            goto La7
        L8b:
            if (r3 != 0) goto L90
            r5.close()     // Catch: java.io.IOException -> L87
        L90:
            r2 = r1
            r1 = r3
            goto Laa
        L93:
            r2 = move-exception
        L94:
            if (r5 == 0) goto L9c
            if (r3 != 0) goto L9f
            r5.close()     // Catch: java.io.IOException -> L87
            goto L9f
        L9c:
            r6.ignore()     // Catch: java.io.IOException -> L87
        L9f:
            throw r2     // Catch: java.io.IOException -> L87
        La0:
            java.lang.String r2 = r6.parseAsString()     // Catch: java.io.IOException -> La5
            goto Laa
        La5:
            r5 = move-exception
            r2 = r1
        La7:
            r5.printStackTrace()
        Laa:
            java.lang.StringBuilder r5 = com.google.api.client.http.HttpResponseException.computeMessageBuffer(r6)
            boolean r6 = com.google.api.client.util.Strings.isNullOrEmpty(r2)
            if (r6 != 0) goto Lbf
            java.lang.String r6 = com.google.api.client.util.StringUtils.LINE_SEPARATOR
            r5.append(r6)
            r5.append(r2)
            r0.setContent(r2)
        Lbf:
            java.lang.String r5 = r5.toString()
            r0.setMessage(r5)
            com.google.api.client.googleapis.json.GoogleJsonResponseException r5 = new com.google.api.client.googleapis.json.GoogleJsonResponseException
            r5.<init>(r0, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.googleapis.json.GoogleJsonResponseException.from(com.google.api.client.json.JsonFactory, com.google.api.client.http.HttpResponse):com.google.api.client.googleapis.json.GoogleJsonResponseException");
    }

    public final GoogleJsonError getDetails() {
        return this.f25645b;
    }
}
