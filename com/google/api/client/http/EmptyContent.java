package com.google.api.client.http;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public class EmptyContent implements HttpContent {
    @Override // com.google.api.client.http.HttpContent
    public long getLength() throws IOException {
        return 0L;
    }

    @Override // com.google.api.client.http.HttpContent
    public String getType() {
        return null;
    }

    @Override // com.google.api.client.http.HttpContent
    public boolean retrySupported() {
        return true;
    }

    @Override // com.google.api.client.http.HttpContent, com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.flush();
    }
}
