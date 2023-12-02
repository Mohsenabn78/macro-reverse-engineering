package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class MergedStream extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    protected final IOContext f17740a;

    /* renamed from: b  reason: collision with root package name */
    final InputStream f17741b;

    /* renamed from: c  reason: collision with root package name */
    byte[] f17742c;

    /* renamed from: d  reason: collision with root package name */
    int f17743d;

    /* renamed from: e  reason: collision with root package name */
    final int f17744e;

    public MergedStream(IOContext iOContext, InputStream inputStream, byte[] bArr, int i4, int i5) {
        this.f17740a = iOContext;
        this.f17741b = inputStream;
        this.f17742c = bArr;
        this.f17743d = i4;
        this.f17744e = i5;
    }

    private void b() {
        byte[] bArr = this.f17742c;
        if (bArr != null) {
            this.f17742c = null;
            IOContext iOContext = this.f17740a;
            if (iOContext != null) {
                iOContext.releaseReadIOBuffer(bArr);
            }
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.f17742c != null) {
            return this.f17744e - this.f17743d;
        }
        return this.f17741b.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        b();
        this.f17741b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i4) {
        if (this.f17742c == null) {
            this.f17741b.mark(i4);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        if (this.f17742c == null && this.f17741b.markSupported()) {
            return true;
        }
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = this.f17742c;
        if (bArr != null) {
            int i4 = this.f17743d;
            int i5 = i4 + 1;
            this.f17743d = i5;
            int i6 = bArr[i4] & 255;
            if (i5 >= this.f17744e) {
                b();
            }
            return i6;
        }
        return this.f17741b.read();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        if (this.f17742c == null) {
            this.f17741b.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j4) throws IOException {
        long j5;
        if (this.f17742c != null) {
            int i4 = this.f17744e;
            int i5 = this.f17743d;
            long j6 = i4 - i5;
            if (j6 > j4) {
                this.f17743d = i5 + ((int) j4);
                return j4;
            }
            b();
            j5 = j6 + 0;
            j4 -= j6;
        } else {
            j5 = 0;
        }
        if (j4 > 0) {
            return j5 + this.f17741b.skip(j4);
        }
        return j5;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i4, int i5) throws IOException {
        byte[] bArr2 = this.f17742c;
        if (bArr2 != null) {
            int i6 = this.f17744e;
            int i7 = this.f17743d;
            int i8 = i6 - i7;
            if (i5 > i8) {
                i5 = i8;
            }
            System.arraycopy(bArr2, i7, bArr, i4, i5);
            int i9 = this.f17743d + i5;
            this.f17743d = i9;
            if (i9 >= this.f17744e) {
                b();
            }
            return i5;
        }
        return this.f17741b.read(bArr, i4, i5);
    }
}
