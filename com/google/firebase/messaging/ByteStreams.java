package com.google.firebase.messaging;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/* loaded from: classes5.dex */
final class ByteStreams {
    private ByteStreams() {
    }

    private static byte[] a(Queue<byte[]> queue, int i4) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] remove = queue.remove();
        if (remove.length == i4) {
            return remove;
        }
        int length = i4 - remove.length;
        byte[] copyOf = Arrays.copyOf(remove, i4);
        while (length > 0) {
            byte[] remove2 = queue.remove();
            int min = Math.min(length, remove2.length);
            System.arraycopy(remove2, 0, copyOf, i4 - length, min);
            length -= min;
        }
        return copyOf;
    }

    public static InputStream b(InputStream inputStream, long j4) {
        return new LimitedInputStream(inputStream, j4);
    }

    private static int c(long j4) {
        if (j4 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j4 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j4;
    }

    public static byte[] d(InputStream inputStream) throws IOException {
        return e(inputStream, new ArrayDeque(20), 0);
    }

    private static byte[] e(InputStream inputStream, Queue<byte[]> queue, int i4) throws IOException {
        int i5;
        int min = Math.min(8192, Math.max(128, Integer.highestOneBit(i4) * 2));
        while (i4 < 2147483639) {
            int min2 = Math.min(min, 2147483639 - i4);
            byte[] bArr = new byte[min2];
            queue.add(bArr);
            int i6 = 0;
            while (i6 < min2) {
                int read = inputStream.read(bArr, i6, min2 - i6);
                if (read == -1) {
                    return a(queue, i4);
                }
                i6 += read;
                i4 += read;
            }
            long j4 = min;
            if (min < 4096) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            min = c(j4 * i5);
        }
        if (inputStream.read() == -1) {
            return a(queue, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    /* loaded from: classes5.dex */
    private static final class LimitedInputStream extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        private long f31624a;

        /* renamed from: b  reason: collision with root package name */
        private long f31625b;

        LimitedInputStream(InputStream inputStream, long j4) {
            super(inputStream);
            this.f31625b = -1L;
            this.f31624a = j4;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return (int) Math.min(((FilterInputStream) this).in.available(), this.f31624a);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i4) {
            ((FilterInputStream) this).in.mark(i4);
            this.f31625b = this.f31624a;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.f31624a == 0) {
                return -1;
            }
            int read = ((FilterInputStream) this).in.read();
            if (read != -1) {
                this.f31624a--;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            if (((FilterInputStream) this).in.markSupported()) {
                if (this.f31625b != -1) {
                    ((FilterInputStream) this).in.reset();
                    this.f31624a = this.f31625b;
                } else {
                    throw new IOException("Mark not set");
                }
            } else {
                throw new IOException("Mark not supported");
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j4) throws IOException {
            long skip = ((FilterInputStream) this).in.skip(Math.min(j4, this.f31624a));
            this.f31624a -= skip;
            return skip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i4, int i5) throws IOException {
            long j4 = this.f31624a;
            if (j4 == 0) {
                return -1;
            }
            int read = ((FilterInputStream) this).in.read(bArr, i4, (int) Math.min(i5, j4));
            if (read != -1) {
                this.f31624a -= read;
            }
            return read;
        }
    }
}
