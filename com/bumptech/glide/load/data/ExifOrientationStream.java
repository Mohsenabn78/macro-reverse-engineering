package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.facebook.stetho.dumpapp.Framer;
import com.google.common.base.Ascii;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class ExifOrientationStream extends FilterInputStream {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f16756c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f16757d;

    /* renamed from: e  reason: collision with root package name */
    private static final int f16758e;

    /* renamed from: a  reason: collision with root package name */
    private final byte f16759a;

    /* renamed from: b  reason: collision with root package name */
    private int f16760b;

    static {
        byte[] bArr = {-1, -31, 0, Ascii.FS, 69, Framer.EXIT_FRAME_PREFIX, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, Ascii.DC2, 0, 2, 0, 0, 0, 1, 0};
        f16756c = bArr;
        int length = bArr.length;
        f16757d = length;
        f16758e = length + 2;
    }

    public ExifOrientationStream(InputStream inputStream, int i4) {
        super(inputStream);
        if (i4 >= -1 && i4 <= 8) {
            this.f16759a = (byte) i4;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i4);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i4) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read;
        int i4;
        int i5 = this.f16760b;
        if (i5 < 2 || i5 > (i4 = f16758e)) {
            read = super.read();
        } else if (i5 == i4) {
            read = this.f16759a;
        } else {
            read = f16756c[i5 - 2] & 255;
        }
        if (read != -1) {
            this.f16760b++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j4) throws IOException {
        long skip = super.skip(j4);
        if (skip > 0) {
            this.f16760b = (int) (this.f16760b + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i4, int i5) throws IOException {
        int i6;
        int i7 = this.f16760b;
        int i8 = f16758e;
        if (i7 > i8) {
            i6 = super.read(bArr, i4, i5);
        } else if (i7 == i8) {
            bArr[i4] = this.f16759a;
            i6 = 1;
        } else if (i7 < 2) {
            i6 = super.read(bArr, i4, 2 - i7);
        } else {
            int min = Math.min(i8 - i7, i5);
            System.arraycopy(f16756c, this.f16760b - 2, bArr, i4, min);
            i6 = min;
        }
        if (i6 > 0) {
            this.f16760b += i6;
        }
        return i6;
    }
}
