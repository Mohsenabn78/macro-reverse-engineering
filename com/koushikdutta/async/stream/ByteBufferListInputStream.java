package com.koushikdutta.async.stream;

import com.koushikdutta.async.ByteBufferList;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class ByteBufferListInputStream extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    ByteBufferList f35643a;

    public ByteBufferListInputStream(ByteBufferList byteBufferList) {
        this.f35643a = byteBufferList;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f35643a.remaining() <= 0) {
            return -1;
        }
        return this.f35643a.get();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i4, int i5) throws IOException {
        if (this.f35643a.remaining() <= 0) {
            return -1;
        }
        int min = Math.min(i5, this.f35643a.remaining());
        this.f35643a.get(bArr, i4, min);
        return min;
    }
}
