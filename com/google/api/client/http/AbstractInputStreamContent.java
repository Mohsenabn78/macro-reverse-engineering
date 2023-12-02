package com.google.api.client.http;

import com.google.api.client.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public abstract class AbstractInputStreamContent implements HttpContent {

    /* renamed from: a  reason: collision with root package name */
    private String f25750a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f25751b = true;

    public AbstractInputStreamContent(String str) {
        setType(str);
    }

    public final boolean getCloseInputStream() {
        return this.f25751b;
    }

    public abstract InputStream getInputStream() throws IOException;

    @Override // com.google.api.client.http.HttpContent
    public String getType() {
        return this.f25750a;
    }

    public AbstractInputStreamContent setCloseInputStream(boolean z3) {
        this.f25751b = z3;
        return this;
    }

    public AbstractInputStreamContent setType(String str) {
        this.f25750a = str;
        return this;
    }

    @Override // com.google.api.client.http.HttpContent, com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        IOUtils.copy(getInputStream(), outputStream, this.f25751b);
        outputStream.flush();
    }
}
