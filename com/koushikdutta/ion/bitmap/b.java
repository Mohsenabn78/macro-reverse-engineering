package com.koushikdutta.ion.bitmap;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: MarkableInputStream.java */
/* loaded from: classes6.dex */
final class b extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f35815a;

    /* renamed from: b  reason: collision with root package name */
    private long f35816b;

    /* renamed from: c  reason: collision with root package name */
    private long f35817c;

    /* renamed from: d  reason: collision with root package name */
    private long f35818d;

    /* renamed from: e  reason: collision with root package name */
    private long f35819e = -1;

    public b(InputStream inputStream) {
        this.f35815a = inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream);
    }

    private void d(long j4) {
        try {
            long j5 = this.f35817c;
            long j6 = this.f35816b;
            if (j5 < j6 && j6 <= this.f35818d) {
                this.f35815a.reset();
                this.f35815a.mark((int) (j4 - this.f35817c));
                e(this.f35817c, this.f35816b);
            } else {
                this.f35817c = j6;
                this.f35815a.mark((int) (j4 - j6));
            }
            this.f35818d = j4;
        } catch (IOException e4) {
            throw new IllegalStateException("Unable to mark: " + e4);
        }
    }

    private void e(long j4, long j5) throws IOException {
        while (j4 < j5) {
            long skip = this.f35815a.skip(j5 - j4);
            if (skip == 0) {
                if (read() != -1) {
                    skip = 1;
                } else {
                    return;
                }
            }
            j4 += skip;
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f35815a.available();
    }

    public void b(long j4) throws IOException {
        if (this.f35816b <= this.f35818d && j4 >= this.f35817c) {
            this.f35815a.reset();
            e(this.f35817c, j4);
            this.f35816b = j4;
            return;
        }
        throw new IOException("Cannot reset");
    }

    public long c(int i4) {
        long j4 = this.f35816b + i4;
        if (this.f35818d < j4) {
            d(j4);
        }
        return this.f35816b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f35815a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i4) {
        this.f35819e = c(i4);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f35815a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int read = this.f35815a.read();
        if (read != -1) {
            this.f35816b++;
        }
        return read;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        b(this.f35819e);
    }

    @Override // java.io.InputStream
    public long skip(long j4) throws IOException {
        long skip = this.f35815a.skip(j4);
        this.f35816b += skip;
        return skip;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int read = this.f35815a.read(bArr);
        if (read != -1) {
            this.f35816b += read;
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i4, int i5) throws IOException {
        int read = this.f35815a.read(bArr, i4, i5);
        if (read != -1) {
            this.f35816b += read;
        }
        return read;
    }
}
