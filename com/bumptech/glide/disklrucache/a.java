package com.bumptech.glide.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader.java */
/* loaded from: classes3.dex */
class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f16678a;

    /* renamed from: b  reason: collision with root package name */
    private final Charset f16679b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f16680c;

    /* renamed from: d  reason: collision with root package name */
    private int f16681d;

    /* renamed from: e  reason: collision with root package name */
    private int f16682e;

    /* compiled from: StrictLineReader.java */
    /* renamed from: com.bumptech.glide.disklrucache.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0132a extends ByteArrayOutputStream {
        C0132a(int i4) {
            super(i4);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i4 = ((ByteArrayOutputStream) this).count;
            if (i4 > 0 && ((ByteArrayOutputStream) this).buf[i4 - 1] == 13) {
                i4--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i4, a.this.f16679b.name());
            } catch (UnsupportedEncodingException e4) {
                throw new AssertionError(e4);
            }
        }
    }

    public a(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() throws IOException {
        InputStream inputStream = this.f16678a;
        byte[] bArr = this.f16680c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f16681d = 0;
            this.f16682e = read;
            return;
        }
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f16678a) {
            if (this.f16680c != null) {
                this.f16680c = null;
                this.f16678a.close();
            }
        }
    }

    public boolean d() {
        if (this.f16682e == -1) {
            return true;
        }
        return false;
    }

    public String e() throws IOException {
        int i4;
        byte[] bArr;
        int i5;
        synchronized (this.f16678a) {
            if (this.f16680c != null) {
                if (this.f16681d >= this.f16682e) {
                    c();
                }
                for (int i6 = this.f16681d; i6 != this.f16682e; i6++) {
                    byte[] bArr2 = this.f16680c;
                    if (bArr2[i6] == 10) {
                        int i7 = this.f16681d;
                        if (i6 != i7) {
                            i5 = i6 - 1;
                            if (bArr2[i5] == 13) {
                                String str = new String(bArr2, i7, i5 - i7, this.f16679b.name());
                                this.f16681d = i6 + 1;
                                return str;
                            }
                        }
                        i5 = i6;
                        String str2 = new String(bArr2, i7, i5 - i7, this.f16679b.name());
                        this.f16681d = i6 + 1;
                        return str2;
                    }
                }
                C0132a c0132a = new C0132a((this.f16682e - this.f16681d) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f16680c;
                    int i8 = this.f16681d;
                    c0132a.write(bArr3, i8, this.f16682e - i8);
                    this.f16682e = -1;
                    c();
                    i4 = this.f16681d;
                    while (i4 != this.f16682e) {
                        bArr = this.f16680c;
                        if (bArr[i4] == 10) {
                            break loop1;
                        }
                        i4++;
                    }
                }
                int i9 = this.f16681d;
                if (i4 != i9) {
                    c0132a.write(bArr, i9, i4 - i9);
                }
                this.f16681d = i4 + 1;
                return c0132a.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public a(InputStream inputStream, int i4, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i4 >= 0) {
            if (charset.equals(b.f16684a)) {
                this.f16678a = inputStream;
                this.f16679b = charset;
                this.f16680c = new byte[i4];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
