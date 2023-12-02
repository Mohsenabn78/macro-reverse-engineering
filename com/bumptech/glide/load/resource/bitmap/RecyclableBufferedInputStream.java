package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private volatile byte[] f17250a;

    /* renamed from: b  reason: collision with root package name */
    private int f17251b;

    /* renamed from: c  reason: collision with root package name */
    private int f17252c;

    /* renamed from: d  reason: collision with root package name */
    private int f17253d;

    /* renamed from: e  reason: collision with root package name */
    private int f17254e;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayPool f17255f;

    /* loaded from: classes3.dex */
    static class a extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        a(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) {
        this(inputStream, arrayPool, 65536);
    }

    private int b(InputStream inputStream, byte[] bArr) throws IOException {
        int i4 = this.f17253d;
        if (i4 != -1) {
            int i5 = this.f17254e - i4;
            int i6 = this.f17252c;
            if (i5 < i6) {
                if (i4 == 0 && i6 > bArr.length && this.f17251b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i6) {
                        i6 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f17255f.get(i6, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f17250a = bArr2;
                    this.f17255f.put(bArr);
                    bArr = bArr2;
                } else if (i4 > 0) {
                    System.arraycopy(bArr, i4, bArr, 0, bArr.length - i4);
                }
                int i7 = this.f17254e - this.f17253d;
                this.f17254e = i7;
                this.f17253d = 0;
                this.f17251b = 0;
                int read = inputStream.read(bArr, i7, bArr.length - i7);
                int i8 = this.f17254e;
                if (read > 0) {
                    i8 += read;
                }
                this.f17251b = i8;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f17253d = -1;
            this.f17254e = 0;
            this.f17251b = read2;
        }
        return read2;
    }

    private static IOException c() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f17250a != null && inputStream != null) {
        } else {
            throw c();
        }
        return (this.f17251b - this.f17254e) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f17250a != null) {
            this.f17255f.put(this.f17250a);
            this.f17250a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void fixMarkLimit() {
        this.f17252c = this.f17250a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i4) {
        this.f17252c = Math.max(this.f17252c, i4);
        this.f17253d = this.f17254e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f17250a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr != null && inputStream != null) {
            if (this.f17254e < this.f17251b || b(inputStream, bArr) != -1) {
                if (bArr != this.f17250a && (bArr = this.f17250a) == null) {
                    throw c();
                }
                int i4 = this.f17251b;
                int i5 = this.f17254e;
                if (i4 - i5 > 0) {
                    this.f17254e = i5 + 1;
                    return bArr[i5] & 255;
                }
                return -1;
            }
            return -1;
        }
        throw c();
    }

    public synchronized void release() {
        if (this.f17250a != null) {
            this.f17255f.put(this.f17250a);
            this.f17250a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f17250a != null) {
            int i4 = this.f17253d;
            if (-1 != i4) {
                this.f17254e = i4;
            } else {
                throw new a("Mark has been invalidated, pos: " + this.f17254e + " markLimit: " + this.f17252c);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j4) throws IOException {
        if (j4 < 1) {
            return 0L;
        }
        byte[] bArr = this.f17250a;
        if (bArr != null) {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                int i4 = this.f17251b;
                int i5 = this.f17254e;
                if (i4 - i5 >= j4) {
                    this.f17254e = (int) (i5 + j4);
                    return j4;
                }
                long j5 = i4 - i5;
                this.f17254e = i4;
                if (this.f17253d != -1 && j4 <= this.f17252c) {
                    if (b(inputStream, bArr) == -1) {
                        return j5;
                    }
                    int i6 = this.f17251b;
                    int i7 = this.f17254e;
                    if (i6 - i7 >= j4 - j5) {
                        this.f17254e = (int) ((i7 + j4) - j5);
                        return j4;
                    }
                    long j6 = (j5 + i6) - i7;
                    this.f17254e = i6;
                    return j6;
                }
                return j5 + inputStream.skip(j4 - j5);
            }
            throw c();
        }
        throw c();
    }

    @VisibleForTesting
    RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool, int i4) {
        super(inputStream);
        this.f17253d = -1;
        this.f17255f = arrayPool;
        this.f17250a = (byte[]) arrayPool.get(i4, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i4, int i5) throws IOException {
        int i6;
        int i7;
        byte[] bArr2 = this.f17250a;
        if (bArr2 == null) {
            throw c();
        }
        if (i5 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i8 = this.f17254e;
            int i9 = this.f17251b;
            if (i8 < i9) {
                int i10 = i9 - i8 >= i5 ? i5 : i9 - i8;
                System.arraycopy(bArr2, i8, bArr, i4, i10);
                this.f17254e += i10;
                if (i10 == i5 || inputStream.available() == 0) {
                    return i10;
                }
                i4 += i10;
                i6 = i5 - i10;
            } else {
                i6 = i5;
            }
            while (true) {
                if (this.f17253d == -1 && i6 >= bArr2.length) {
                    i7 = inputStream.read(bArr, i4, i6);
                    if (i7 == -1) {
                        return i6 != i5 ? i5 - i6 : -1;
                    }
                } else if (b(inputStream, bArr2) == -1) {
                    return i6 != i5 ? i5 - i6 : -1;
                } else {
                    if (bArr2 != this.f17250a && (bArr2 = this.f17250a) == null) {
                        throw c();
                    }
                    int i11 = this.f17251b;
                    int i12 = this.f17254e;
                    i7 = i11 - i12 >= i6 ? i6 : i11 - i12;
                    System.arraycopy(bArr2, i12, bArr, i4, i7);
                    this.f17254e += i7;
                }
                i6 -= i7;
                if (i6 == 0) {
                    return i5;
                }
                if (inputStream.available() == 0) {
                    return i5 - i6;
                }
                i4 += i7;
            }
        } else {
            throw c();
        }
    }
}
