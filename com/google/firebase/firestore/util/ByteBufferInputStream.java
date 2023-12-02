package com.google.firebase.firestore.util;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public class ByteBufferInputStream extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    ByteBuffer f31268a;

    public ByteBufferInputStream(ByteBuffer byteBuffer) {
        this.f31268a = byteBuffer;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f31268a.remaining();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f31268a.hasRemaining()) {
            return this.f31268a.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr, int i4, int i5) throws IOException {
        if (this.f31268a.hasRemaining()) {
            int min = Math.min(i5, this.f31268a.remaining());
            this.f31268a.get(bArr, i4, min);
            return min;
        }
        return -1;
    }
}
