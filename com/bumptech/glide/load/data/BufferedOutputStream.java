package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public final class BufferedOutputStream extends OutputStream {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final OutputStream f16749a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f16750b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayPool f16751c;

    /* renamed from: d  reason: collision with root package name */
    private int f16752d;

    public BufferedOutputStream(@NonNull OutputStream outputStream, @NonNull ArrayPool arrayPool) {
        this(outputStream, arrayPool, 65536);
    }

    private void b() throws IOException {
        int i4 = this.f16752d;
        if (i4 > 0) {
            this.f16749a.write(this.f16750b, 0, i4);
            this.f16752d = 0;
        }
    }

    private void c() throws IOException {
        if (this.f16752d == this.f16750b.length) {
            b();
        }
    }

    private void release() {
        byte[] bArr = this.f16750b;
        if (bArr != null) {
            this.f16751c.put(bArr);
            this.f16750b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f16749a.close();
            release();
        } catch (Throwable th) {
            this.f16749a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        b();
        this.f16749a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i4) throws IOException {
        byte[] bArr = this.f16750b;
        int i5 = this.f16752d;
        this.f16752d = i5 + 1;
        bArr[i5] = (byte) i4;
        c();
    }

    @VisibleForTesting
    BufferedOutputStream(@NonNull OutputStream outputStream, ArrayPool arrayPool, int i4) {
        this.f16749a = outputStream;
        this.f16751c = arrayPool;
        this.f16750b = (byte[]) arrayPool.get(i4, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i4, int i5) throws IOException {
        int i6 = 0;
        do {
            int i7 = i5 - i6;
            int i8 = i4 + i6;
            int i9 = this.f16752d;
            if (i9 == 0 && i7 >= this.f16750b.length) {
                this.f16749a.write(bArr, i8, i7);
                return;
            }
            int min = Math.min(i7, this.f16750b.length - i9);
            System.arraycopy(bArr, i8, this.f16750b, this.f16752d, min);
            this.f16752d += min;
            i6 += min;
            c();
        } while (i6 < i5);
    }
}
