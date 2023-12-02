package com.google.api.client.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public final class ByteStreams {
    private ByteStreams() {
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(outputStream);
        byte[] bArr = new byte[4096];
        long j4 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j4;
            }
            outputStream.write(bArr, 0, read);
            j4 += read;
        }
    }

    public static InputStream limit(InputStream inputStream, long j4) {
        return new LimitedInputStream(inputStream, j4);
    }

    public static int read(InputStream inputStream, byte[] bArr, int i4, int i5) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(bArr);
        if (i5 >= 0) {
            int i6 = 0;
            while (i6 < i5) {
                int read = inputStream.read(bArr, i4 + i6, i5 - i6);
                if (read == -1) {
                    break;
                }
                i6 += read;
            }
            return i6;
        }
        throw new IndexOutOfBoundsException("len is negative");
    }

    /* loaded from: classes5.dex */
    private static final class LimitedInputStream extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        private long f26076a;

        /* renamed from: b  reason: collision with root package name */
        private long f26077b;

        LimitedInputStream(InputStream inputStream, long j4) {
            super(inputStream);
            boolean z3;
            this.f26077b = -1L;
            Preconditions.checkNotNull(inputStream);
            if (j4 >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "limit must be non-negative");
            this.f26076a = j4;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return (int) Math.min(((FilterInputStream) this).in.available(), this.f26076a);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i4) {
            ((FilterInputStream) this).in.mark(i4);
            this.f26077b = this.f26076a;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.f26076a == 0) {
                return -1;
            }
            int read = ((FilterInputStream) this).in.read();
            if (read != -1) {
                this.f26076a--;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            if (((FilterInputStream) this).in.markSupported()) {
                if (this.f26077b != -1) {
                    ((FilterInputStream) this).in.reset();
                    this.f26076a = this.f26077b;
                } else {
                    throw new IOException("Mark not set");
                }
            } else {
                throw new IOException("Mark not supported");
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j4) throws IOException {
            long skip = ((FilterInputStream) this).in.skip(Math.min(j4, this.f26076a));
            this.f26076a -= skip;
            return skip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i4, int i5) throws IOException {
            long j4 = this.f26076a;
            if (j4 == 0) {
                return -1;
            }
            int read = ((FilterInputStream) this).in.read(bArr, i4, (int) Math.min(i5, j4));
            if (read != -1) {
                this.f26076a -= read;
            }
            return read;
        }
    }
}
