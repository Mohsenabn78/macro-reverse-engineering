package com.google.api.client.util;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes5.dex */
final class ByteCountingOutputStream extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    long f26075a;

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i4, int i5) throws IOException {
        this.f26075a += i5;
    }

    @Override // java.io.OutputStream
    public void write(int i4) throws IOException {
        this.f26075a++;
    }
}
