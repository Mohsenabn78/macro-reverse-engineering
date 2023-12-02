package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class MarkEnforcingInputStream extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private int f17581a;

    public MarkEnforcingInputStream(@NonNull InputStream inputStream) {
        super(inputStream);
        this.f17581a = Integer.MIN_VALUE;
    }

    private long b(long j4) {
        int i4 = this.f17581a;
        if (i4 == 0) {
            return -1L;
        }
        if (i4 != Integer.MIN_VALUE && j4 > i4) {
            return i4;
        }
        return j4;
    }

    private void c(long j4) {
        int i4 = this.f17581a;
        if (i4 != Integer.MIN_VALUE && j4 != -1) {
            this.f17581a = (int) (i4 - j4);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i4 = this.f17581a;
        if (i4 == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i4, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i4) {
        super.mark(i4);
        this.f17581a = i4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (b(1L) == -1) {
            return -1;
        }
        int read = super.read();
        c(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.f17581a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j4) throws IOException {
        long b4 = b(j4);
        if (b4 == -1) {
            return 0L;
        }
        long skip = super.skip(b4);
        c(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i4, int i5) throws IOException {
        int b4 = (int) b(i5);
        if (b4 == -1) {
            return -1;
        }
        int read = super.read(bArr, i4, b4);
        c(read);
        return read;
    }
}
