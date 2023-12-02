package com.facebook.stetho.server;

import com.facebook.stetho.common.LogUtil;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* loaded from: classes3.dex */
public class CompositeInputStream extends InputStream {
    private int mCurrentIndex;
    private final InputStream[] mStreams;

    public CompositeInputStream(InputStream[] inputStreamArr) {
        if (inputStreamArr != null && inputStreamArr.length >= 2) {
            this.mStreams = inputStreamArr;
            this.mCurrentIndex = 0;
            return;
        }
        throw new IllegalArgumentException("Streams must be non-null and have more than 1 entry");
    }

    private void closeAll(int i4) throws IOException {
        IOException iOException = null;
        int i5 = 0;
        while (true) {
            InputStream[] inputStreamArr = this.mStreams;
            if (i5 < inputStreamArr.length) {
                try {
                    inputStreamArr[i5].close();
                } catch (IOException e4) {
                    e = e4;
                    if (i5 != i4 && iOException != null) {
                        e = iOException;
                    }
                    if (iOException != null && iOException != e) {
                        LogUtil.w(iOException, "Suppressing exception");
                    }
                    iOException = e;
                }
                i5++;
            } else {
                return;
            }
        }
    }

    private boolean tryMoveToNextStream() {
        int i4 = this.mCurrentIndex;
        if (i4 + 1 < this.mStreams.length) {
            this.mCurrentIndex = i4 + 1;
            return true;
        }
        return false;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.mStreams[this.mCurrentIndex].available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        closeAll(this.mCurrentIndex);
    }

    @Override // java.io.InputStream
    public void mark(int i4) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public long skip(long j4) throws IOException {
        int read = read(new byte[(int) j4]);
        if (read >= 0) {
            return read;
        }
        return -1L;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i4, int i5) throws IOException {
        int read;
        do {
            read = this.mStreams[this.mCurrentIndex].read(bArr, i4, i5);
            if (read != -1) {
                break;
            }
        } while (tryMoveToNextStream());
        return read;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int read;
        do {
            read = this.mStreams[this.mCurrentIndex].read();
            if (read != -1) {
                break;
            }
        } while (tryMoveToNextStream());
        return read;
    }
}
