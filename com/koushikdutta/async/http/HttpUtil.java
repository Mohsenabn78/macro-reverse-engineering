package com.koushikdutta.async.http;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import com.koushikdutta.async.http.body.JSONObjectBody;
import com.koushikdutta.async.http.body.MultipartFormDataBody;
import com.koushikdutta.async.http.body.StringBody;
import com.koushikdutta.async.http.body.UrlEncodedFormBody;

/* loaded from: classes6.dex */
public class HttpUtil {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a extends FilteredDataEmitter {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.koushikdutta.async.http.HttpUtil$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class RunnableC0187a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Exception f35038b;

            RunnableC0187a(Exception exc) {
                this.f35038b = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a(this.f35038b);
            }
        }

        private a() {
        }

        public static a c(AsyncServer asyncServer, Exception exc) {
            a aVar = new a();
            asyncServer.post(new RunnableC0187a(exc));
            return aVar;
        }
    }

    public static int contentLength(Headers headers) {
        String str = headers.get("Content-Length");
        if (str == null) {
            return -1;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static AsyncHttpRequestBody getBody(DataEmitter dataEmitter, CompletedCallback completedCallback, Headers headers) {
        String str = headers.get("Content-Type");
        if (str != null) {
            String[] split = str.split(";");
            for (int i4 = 0; i4 < split.length; i4++) {
                split[i4] = split[i4].trim();
            }
            for (String str2 : split) {
                if ("application/x-www-form-urlencoded".equals(str2)) {
                    return new UrlEncodedFormBody();
                }
                if ("application/json".equals(str2)) {
                    return new JSONObjectBody();
                }
                if ("text/plain".equals(str2)) {
                    return new StringBody();
                }
                if ("multipart/form-data".equals(str2)) {
                    return new MultipartFormDataBody(split);
                }
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.koushikdutta.async.DataEmitter getBodyDecoder(com.koushikdutta.async.DataEmitter r6, com.koushikdutta.async.http.Protocol r7, com.koushikdutta.async.http.Headers r8, boolean r9) {
        /*
            r0 = -1
            java.lang.String r2 = "Content-Length"
            java.lang.String r2 = r8.get(r2)     // Catch: java.lang.Exception -> Ld
            long r2 = java.lang.Long.parseLong(r2)     // Catch: java.lang.Exception -> Ld
            goto Lf
        Ld:
            r2 = r0
        Lf:
            r4 = 0
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L44
            r0 = 0
            int r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r7 >= 0) goto L2d
            com.koushikdutta.async.AsyncServer r7 = r6.getServer()
            com.koushikdutta.async.http.BodyDecoderException r8 = new com.koushikdutta.async.http.BodyDecoderException
            java.lang.String r9 = "not using chunked encoding, and no content-length found."
            r8.<init>(r9)
            com.koushikdutta.async.http.HttpUtil$a r7 = com.koushikdutta.async.http.HttpUtil.a.c(r7, r8)
            r7.setDataEmitter(r6)
            return r7
        L2d:
            if (r7 != 0) goto L3b
            com.koushikdutta.async.AsyncServer r7 = r6.getServer()
            com.koushikdutta.async.http.HttpUtil$a r7 = com.koushikdutta.async.http.HttpUtil.a.c(r7, r4)
            r7.setDataEmitter(r6)
            return r7
        L3b:
            com.koushikdutta.async.http.filter.ContentLengthFilter r7 = new com.koushikdutta.async.http.filter.ContentLengthFilter
            r7.<init>(r2)
            r7.setDataEmitter(r6)
            goto L5a
        L44:
            java.lang.String r0 = "Transfer-Encoding"
            java.lang.String r0 = r8.get(r0)
            java.lang.String r1 = "chunked"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L5c
            com.koushikdutta.async.http.filter.ChunkedInputFilter r7 = new com.koushikdutta.async.http.filter.ChunkedInputFilter
            r7.<init>()
            r7.setDataEmitter(r6)
        L5a:
            r6 = r7
            goto L7c
        L5c:
            if (r9 != 0) goto L62
            com.koushikdutta.async.http.Protocol r9 = com.koushikdutta.async.http.Protocol.HTTP_1_1
            if (r7 != r9) goto L7c
        L62:
            java.lang.String r7 = "Connection"
            java.lang.String r7 = r8.get(r7)
            java.lang.String r9 = "close"
            boolean r7 = r9.equalsIgnoreCase(r7)
            if (r7 != 0) goto L7c
            com.koushikdutta.async.AsyncServer r7 = r6.getServer()
            com.koushikdutta.async.http.HttpUtil$a r7 = com.koushikdutta.async.http.HttpUtil.a.c(r7, r4)
            r7.setDataEmitter(r6)
            return r7
        L7c:
            java.lang.String r7 = "Content-Encoding"
            java.lang.String r9 = r8.get(r7)
            java.lang.String r0 = "gzip"
            boolean r9 = r0.equals(r9)
            if (r9 == 0) goto L94
            com.koushikdutta.async.http.filter.GZIPInputFilter r7 = new com.koushikdutta.async.http.filter.GZIPInputFilter
            r7.<init>()
            r7.setDataEmitter(r6)
        L92:
            r6 = r7
            goto La9
        L94:
            java.lang.String r9 = "deflate"
            java.lang.String r7 = r8.get(r7)
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto La9
            com.koushikdutta.async.http.filter.InflaterInputFilter r7 = new com.koushikdutta.async.http.filter.InflaterInputFilter
            r7.<init>()
            r7.setDataEmitter(r6)
            goto L92
        La9:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.http.HttpUtil.getBodyDecoder(com.koushikdutta.async.DataEmitter, com.koushikdutta.async.http.Protocol, com.koushikdutta.async.http.Headers, boolean):com.koushikdutta.async.DataEmitter");
    }

    public static boolean isKeepAlive(Protocol protocol, Headers headers) {
        String str = headers.get("Connection");
        if (str == null) {
            return protocol == Protocol.HTTP_1_1;
        }
        return "keep-alive".equalsIgnoreCase(str);
    }

    public static boolean isKeepAlive(String str, Headers headers) {
        String str2 = headers.get("Connection");
        if (str2 == null) {
            return Protocol.get(str) == Protocol.HTTP_1_1;
        }
        return "keep-alive".equalsIgnoreCase(str2);
    }
}
