package com.google.api.client.testing.util;

import com.google.api.client.util.Beta;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Beta
/* loaded from: classes5.dex */
public class TestableByteArrayInputStream extends ByteArrayInputStream {

    /* renamed from: a  reason: collision with root package name */
    private boolean f26057a;

    public TestableByteArrayInputStream(byte[] bArr) {
        super(bArr);
    }

    @Override // java.io.ByteArrayInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f26057a = true;
    }

    public final byte[] getBuffer() {
        return ((ByteArrayInputStream) this).buf;
    }

    public final boolean isClosed() {
        return this.f26057a;
    }

    public TestableByteArrayInputStream(byte[] bArr, int i4, int i5) {
        super(bArr);
    }
}
