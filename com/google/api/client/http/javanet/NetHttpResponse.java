package com.google.api.client.http.javanet;

import com.google.api.client.http.LowLevelHttpResponse;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class NetHttpResponse extends LowLevelHttpResponse {

    /* renamed from: a  reason: collision with root package name */
    private final HttpURLConnection f25872a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25873b;

    /* renamed from: c  reason: collision with root package name */
    private final String f25874c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<String> f25875d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<String> f25876e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NetHttpResponse(HttpURLConnection httpURLConnection) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f25875d = arrayList;
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.f25876e = arrayList2;
        this.f25872a = httpURLConnection;
        int responseCode = httpURLConnection.getResponseCode();
        this.f25873b = responseCode == -1 ? 0 : responseCode;
        this.f25874c = httpURLConnection.getResponseMessage();
        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
            String key = entry.getKey();
            if (key != null) {
                for (String str : entry.getValue()) {
                    if (str != null) {
                        arrayList.add(key);
                        arrayList2.add(str);
                    }
                }
            }
        }
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public void disconnect() {
        this.f25872a.disconnect();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public InputStream getContent() throws IOException {
        InputStream errorStream;
        try {
            errorStream = this.f25872a.getInputStream();
        } catch (IOException unused) {
            errorStream = this.f25872a.getErrorStream();
        }
        if (errorStream == null) {
            return null;
        }
        return new SizeValidatingInputStream(errorStream);
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String getContentEncoding() {
        return this.f25872a.getContentEncoding();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public long getContentLength() {
        String headerField = this.f25872a.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String getContentType() {
        return this.f25872a.getHeaderField("Content-Type");
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public int getHeaderCount() {
        return this.f25875d.size();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String getHeaderName(int i4) {
        return this.f25875d.get(i4);
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String getHeaderValue(int i4) {
        return this.f25876e.get(i4);
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String getReasonPhrase() {
        return this.f25874c;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public int getStatusCode() {
        return this.f25873b;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String getStatusLine() {
        String headerField = this.f25872a.getHeaderField(0);
        if (headerField == null || !headerField.startsWith("HTTP/1.")) {
            return null;
        }
        return headerField;
    }

    /* loaded from: classes5.dex */
    private final class SizeValidatingInputStream extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        private long f25877a;

        public SizeValidatingInputStream(InputStream inputStream) {
            super(inputStream);
            this.f25877a = 0L;
        }

        private void b() throws IOException {
            long contentLength = NetHttpResponse.this.getContentLength();
            if (contentLength == -1) {
                return;
            }
            long j4 = this.f25877a;
            if (j4 != 0 && j4 < contentLength) {
                long j5 = this.f25877a;
                StringBuilder sb = new StringBuilder(102);
                sb.append("Connection closed prematurely: bytesRead = ");
                sb.append(j5);
                sb.append(", Content-Length = ");
                sb.append(contentLength);
                throw new IOException(sb.toString());
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i4, int i5) throws IOException {
            int read = ((FilterInputStream) this).in.read(bArr, i4, i5);
            if (read == -1) {
                b();
            } else {
                this.f25877a += read;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = ((FilterInputStream) this).in.read();
            if (read == -1) {
                b();
            } else {
                this.f25877a++;
            }
            return read;
        }
    }
}
