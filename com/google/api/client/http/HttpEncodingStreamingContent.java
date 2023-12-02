package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public final class HttpEncodingStreamingContent implements StreamingContent {

    /* renamed from: a  reason: collision with root package name */
    private final StreamingContent f25773a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpEncoding f25774b;

    public HttpEncodingStreamingContent(StreamingContent streamingContent, HttpEncoding httpEncoding) {
        this.f25773a = (StreamingContent) Preconditions.checkNotNull(streamingContent);
        this.f25774b = (HttpEncoding) Preconditions.checkNotNull(httpEncoding);
    }

    public StreamingContent getContent() {
        return this.f25773a;
    }

    public HttpEncoding getEncoding() {
        return this.f25774b;
    }

    @Override // com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) throws IOException {
        this.f25774b.encode(this.f25773a, outputStream);
    }
}
