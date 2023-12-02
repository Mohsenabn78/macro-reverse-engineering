package com.google.api.client.http.apache;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StreamingContent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.AbstractHttpEntity;

/* loaded from: classes5.dex */
final class ContentEntity extends AbstractHttpEntity {

    /* renamed from: a  reason: collision with root package name */
    private final long f25866a;

    /* renamed from: b  reason: collision with root package name */
    private final StreamingContent f25867b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContentEntity(long j4, StreamingContent streamingContent) {
        this.f25866a = j4;
        this.f25867b = (StreamingContent) Preconditions.checkNotNull(streamingContent);
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.f25866a;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return true;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        if (this.f25866a != 0) {
            this.f25867b.writeTo(outputStream);
        }
    }
}
