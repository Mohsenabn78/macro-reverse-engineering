package com.google.api.client.testing.http;

import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.util.TestableByteArrayInputStream;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Beta
/* loaded from: classes5.dex */
public class MockLowLevelHttpResponse extends LowLevelHttpResponse {

    /* renamed from: a  reason: collision with root package name */
    private InputStream f26028a;

    /* renamed from: b  reason: collision with root package name */
    private String f26029b;

    /* renamed from: d  reason: collision with root package name */
    private String f26031d;

    /* renamed from: g  reason: collision with root package name */
    private String f26034g;

    /* renamed from: i  reason: collision with root package name */
    private boolean f26036i;

    /* renamed from: c  reason: collision with root package name */
    private int f26030c = 200;

    /* renamed from: e  reason: collision with root package name */
    private List<String> f26032e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private List<String> f26033f = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private long f26035h = -1;

    /* JADX WARN: Multi-variable type inference failed */
    public MockLowLevelHttpResponse addHeader(String str, String str2) {
        this.f26032e.add(Preconditions.checkNotNull(str));
        this.f26033f.add(Preconditions.checkNotNull(str2));
        return this;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public void disconnect() throws IOException {
        this.f26036i = true;
        super.disconnect();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public InputStream getContent() throws IOException {
        return this.f26028a;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String getContentEncoding() {
        return this.f26034g;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public long getContentLength() {
        return this.f26035h;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public final String getContentType() {
        return this.f26029b;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public int getHeaderCount() {
        return this.f26032e.size();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String getHeaderName(int i4) {
        return this.f26032e.get(i4);
    }

    public final List<String> getHeaderNames() {
        return this.f26032e;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String getHeaderValue(int i4) {
        return this.f26033f.get(i4);
    }

    public final List<String> getHeaderValues() {
        return this.f26033f;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String getReasonPhrase() {
        return this.f26031d;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public int getStatusCode() {
        return this.f26030c;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String getStatusLine() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f26030c);
        String str = this.f26031d;
        if (str != null) {
            sb.append(str);
        }
        return sb.toString();
    }

    public boolean isDisconnected() {
        return this.f26036i;
    }

    public MockLowLevelHttpResponse setContent(String str) {
        return str == null ? setZeroContent() : setContent(StringUtils.getBytesUtf8(str));
    }

    public MockLowLevelHttpResponse setContentEncoding(String str) {
        this.f26034g = str;
        return this;
    }

    public MockLowLevelHttpResponse setContentLength(long j4) {
        boolean z3;
        this.f26035h = j4;
        if (j4 >= -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        return this;
    }

    public MockLowLevelHttpResponse setContentType(String str) {
        this.f26029b = str;
        return this;
    }

    public MockLowLevelHttpResponse setHeaderNames(List<String> list) {
        this.f26032e = (List) Preconditions.checkNotNull(list);
        return this;
    }

    public MockLowLevelHttpResponse setHeaderValues(List<String> list) {
        this.f26033f = (List) Preconditions.checkNotNull(list);
        return this;
    }

    public MockLowLevelHttpResponse setReasonPhrase(String str) {
        this.f26031d = str;
        return this;
    }

    public MockLowLevelHttpResponse setStatusCode(int i4) {
        this.f26030c = i4;
        return this;
    }

    public MockLowLevelHttpResponse setZeroContent() {
        this.f26028a = null;
        setContentLength(0L);
        return this;
    }

    public MockLowLevelHttpResponse setContent(byte[] bArr) {
        if (bArr == null) {
            return setZeroContent();
        }
        this.f26028a = new TestableByteArrayInputStream(bArr);
        setContentLength(bArr.length);
        return this;
    }

    public MockLowLevelHttpResponse setContent(InputStream inputStream) {
        this.f26028a = inputStream;
        return this;
    }
}
