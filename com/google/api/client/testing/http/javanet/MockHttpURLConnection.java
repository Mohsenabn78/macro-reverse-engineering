package com.google.api.client.testing.http.javanet;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Beta
/* loaded from: classes5.dex */
public class MockHttpURLConnection extends HttpURLConnection {

    /* renamed from: a  reason: collision with root package name */
    private boolean f26039a;

    /* renamed from: b  reason: collision with root package name */
    private OutputStream f26040b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f26041c;

    /* renamed from: d  reason: collision with root package name */
    private InputStream f26042d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, List<String>> f26043e;
    @Deprecated
    public static final byte[] INPUT_BUF = new byte[1];
    @Deprecated
    public static final byte[] ERROR_BUF = new byte[5];

    public MockHttpURLConnection(URL url) {
        super(url);
        this.f26040b = new ByteArrayOutputStream(0);
        this.f26041c = null;
        this.f26042d = null;
        this.f26043e = new LinkedHashMap();
    }

    public MockHttpURLConnection addHeader(String str, String str2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        if (this.f26043e.containsKey(str)) {
            this.f26043e.get(str).add(str2);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            this.f26043e.put(str, arrayList);
        }
        return this;
    }

    public final boolean doOutputCalled() {
        return this.f26039a;
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return this.f26042d;
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String str) {
        List<String> list = this.f26043e.get(str);
        if (list == null) {
            return null;
        }
        return list.get(0);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        return this.f26043e;
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        if (((HttpURLConnection) this).responseCode < 400) {
            return this.f26041c;
        }
        throw new IOException();
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        OutputStream outputStream = this.f26040b;
        if (outputStream != null) {
            return outputStream;
        }
        return super.getOutputStream();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        return ((HttpURLConnection) this).responseCode;
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z3) {
        this.f26039a = true;
    }

    public MockHttpURLConnection setErrorStream(InputStream inputStream) {
        Preconditions.checkNotNull(inputStream);
        if (this.f26042d == null) {
            this.f26042d = inputStream;
        }
        return this;
    }

    public MockHttpURLConnection setInputStream(InputStream inputStream) {
        Preconditions.checkNotNull(inputStream);
        if (this.f26041c == null) {
            this.f26041c = inputStream;
        }
        return this;
    }

    public MockHttpURLConnection setOutputStream(OutputStream outputStream) {
        this.f26040b = outputStream;
        return this;
    }

    public MockHttpURLConnection setResponseCode(int i4) {
        boolean z3;
        if (i4 >= -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        ((HttpURLConnection) this).responseCode = i4;
        return this;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
    }
}
