package com.google.api.client.testing.http;

import com.google.api.client.http.HttpMediaType;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Charsets;
import com.google.api.client.util.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

@Beta
/* loaded from: classes5.dex */
public class MockLowLevelHttpRequest extends LowLevelHttpRequest {

    /* renamed from: e  reason: collision with root package name */
    private String f26025e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, List<String>> f26026f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private MockLowLevelHttpResponse f26027g = new MockLowLevelHttpResponse();

    public MockLowLevelHttpRequest() {
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public void addHeader(String str, String str2) throws IOException {
        String lowerCase = str.toLowerCase();
        List<String> list = this.f26026f.get(lowerCase);
        if (list == null) {
            list = new ArrayList<>();
            this.f26026f.put(lowerCase, list);
        }
        list.add(str2);
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public LowLevelHttpResponse execute() throws IOException {
        return this.f26027g;
    }

    public String getContentAsString() throws IOException {
        HttpMediaType httpMediaType;
        Charset charset;
        if (getStreamingContent() == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        getStreamingContent().writeTo(byteArrayOutputStream);
        String contentEncoding = getContentEncoding();
        if (contentEncoding != null && contentEncoding.contains("gzip")) {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            byteArrayOutputStream = new ByteArrayOutputStream();
            IOUtils.copy(gZIPInputStream, byteArrayOutputStream);
        }
        String contentType = getContentType();
        if (contentType != null) {
            httpMediaType = new HttpMediaType(contentType);
        } else {
            httpMediaType = null;
        }
        if (httpMediaType != null && httpMediaType.getCharsetParameter() != null) {
            charset = httpMediaType.getCharsetParameter();
        } else {
            charset = Charsets.ISO_8859_1;
        }
        return byteArrayOutputStream.toString(charset.name());
    }

    public String getFirstHeaderValue(String str) {
        List<String> list = this.f26026f.get(str.toLowerCase());
        if (list == null) {
            return null;
        }
        return list.get(0);
    }

    public List<String> getHeaderValues(String str) {
        List<String> list = this.f26026f.get(str.toLowerCase());
        if (list == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(list);
    }

    public Map<String, List<String>> getHeaders() {
        return Collections.unmodifiableMap(this.f26026f);
    }

    public MockLowLevelHttpResponse getResponse() {
        return this.f26027g;
    }

    public String getUrl() {
        return this.f26025e;
    }

    public MockLowLevelHttpRequest setResponse(MockLowLevelHttpResponse mockLowLevelHttpResponse) {
        this.f26027g = mockLowLevelHttpResponse;
        return this;
    }

    public MockLowLevelHttpRequest setUrl(String str) {
        this.f26025e = str;
        return this;
    }

    public MockLowLevelHttpRequest(String str) {
        this.f26025e = str;
    }
}
