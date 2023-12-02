package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
public final class CountingInputStream extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private long f28000a;

    /* renamed from: b  reason: collision with root package name */
    private long f28001b;

    public CountingInputStream(InputStream inputStream) {
        super((InputStream) Preconditions.checkNotNull(inputStream));
        this.f28001b = -1L;
    }

    public long getCount() {
        return this.f28000a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i4) {
        ((FilterInputStream) this).in.mark(i4);
        this.f28001b = this.f28000a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = ((FilterInputStream) this).in.read();
        if (read != -1) {
            this.f28000a++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (((FilterInputStream) this).in.markSupported()) {
            if (this.f28001b != -1) {
                ((FilterInputStream) this).in.reset();
                this.f28000a = this.f28001b;
            } else {
                throw new IOException("Mark not set");
            }
        } else {
            throw new IOException("Mark not supported");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j4) throws IOException {
        long skip = ((FilterInputStream) this).in.skip(j4);
        this.f28000a += skip;
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i4, int i5) throws IOException {
        int read = ((FilterInputStream) this).in.read(bArr, i4, i5);
        if (read != -1) {
            this.f28000a += read;
        }
        return read;
    }
}
