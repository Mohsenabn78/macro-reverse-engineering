package com.koushikdutta.async.http.cache;

import com.koushikdutta.async.util.Charsets;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader.java */
/* loaded from: classes6.dex */
class f implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f35255a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f35256b;

    /* renamed from: c  reason: collision with root package name */
    private int f35257c;

    /* renamed from: d  reason: collision with root package name */
    private int f35258d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StrictLineReader.java */
    /* loaded from: classes6.dex */
    public class a extends ByteArrayOutputStream {
        a(int i4) {
            super(i4);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i4 = ((ByteArrayOutputStream) this).count;
            if (i4 > 0 && ((ByteArrayOutputStream) this).buf[i4 - 1] == 13) {
                i4--;
            }
            return new String(((ByteArrayOutputStream) this).buf, 0, i4);
        }
    }

    public f(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void b() throws IOException {
        InputStream inputStream = this.f35255a;
        byte[] bArr = this.f35256b;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f35257c = 0;
            this.f35258d = read;
            return;
        }
        throw new EOFException();
    }

    public String c() throws IOException {
        int i4;
        byte[] bArr;
        int i5;
        synchronized (this.f35255a) {
            if (this.f35256b != null) {
                if (this.f35257c >= this.f35258d) {
                    b();
                }
                for (int i6 = this.f35257c; i6 != this.f35258d; i6++) {
                    byte[] bArr2 = this.f35256b;
                    if (bArr2[i6] == 10) {
                        int i7 = this.f35257c;
                        if (i6 != i7) {
                            i5 = i6 - 1;
                            if (bArr2[i5] == 13) {
                                String str = new String(bArr2, i7, i5 - i7);
                                this.f35257c = i6 + 1;
                                return str;
                            }
                        }
                        i5 = i6;
                        String str2 = new String(bArr2, i7, i5 - i7);
                        this.f35257c = i6 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f35258d - this.f35257c) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f35256b;
                    int i8 = this.f35257c;
                    aVar.write(bArr3, i8, this.f35258d - i8);
                    this.f35258d = -1;
                    b();
                    i4 = this.f35257c;
                    while (i4 != this.f35258d) {
                        bArr = this.f35256b;
                        if (bArr[i4] == 10) {
                            break loop1;
                        }
                        i4++;
                    }
                }
                int i9 = this.f35257c;
                if (i4 != i9) {
                    aVar.write(bArr, i9, i4 - i9);
                }
                this.f35257c = i4 + 1;
                return aVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f35255a) {
            if (this.f35256b != null) {
                this.f35256b = null;
                this.f35255a.close();
            }
        }
    }

    public int readInt() throws IOException {
        String c4 = c();
        try {
            return Integer.parseInt(c4);
        } catch (NumberFormatException unused) {
            throw new IOException("expected an int but was \"" + c4 + "\"");
        }
    }

    public f(InputStream inputStream, int i4, Charset charset) {
        if (inputStream == null) {
            throw new NullPointerException("in == null");
        }
        if (charset == null) {
            throw new NullPointerException("charset == null");
        }
        if (i4 >= 0) {
            if (!charset.equals(Charsets.US_ASCII) && !charset.equals(Charsets.UTF_8)) {
                throw new IllegalArgumentException("Unsupported encoding");
            }
            this.f35255a = inputStream;
            this.f35256b = new byte[i4];
            return;
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
