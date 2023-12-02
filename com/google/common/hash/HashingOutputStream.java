package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class HashingOutputStream extends FilterOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final Hasher f27856a;

    public HashingOutputStream(HashFunction hashFunction, OutputStream outputStream) {
        super((OutputStream) Preconditions.checkNotNull(outputStream));
        this.f27856a = (Hasher) Preconditions.checkNotNull(hashFunction.newHasher());
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    public HashCode hash() {
        return this.f27856a.hash();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i4) throws IOException {
        this.f27856a.putByte((byte) i4);
        ((FilterOutputStream) this).out.write(i4);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i4, int i5) throws IOException {
        this.f27856a.putBytes(bArr, i4, i5);
        ((FilterOutputStream) this).out.write(bArr, i4, i5);
    }
}
