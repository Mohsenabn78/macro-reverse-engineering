package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
final class MultiInputStream extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private Iterator<? extends ByteSource> f28030a;
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    private InputStream f28031b;

    public MultiInputStream(Iterator<? extends ByteSource> it) throws IOException {
        this.f28030a = (Iterator) Preconditions.checkNotNull(it);
        b();
    }

    private void b() throws IOException {
        close();
        if (this.f28030a.hasNext()) {
            this.f28031b = this.f28030a.next().openStream();
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream inputStream = this.f28031b;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.f28031b;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f28031b = null;
            }
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        while (true) {
            InputStream inputStream = this.f28031b;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            b();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j4) throws IOException {
        InputStream inputStream = this.f28031b;
        if (inputStream == null || j4 <= 0) {
            return 0L;
        }
        long skip = inputStream.skip(j4);
        if (skip != 0) {
            return skip;
        }
        if (read() == -1) {
            return 0L;
        }
        return this.f28031b.skip(j4 - 1) + 1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i4, int i5) throws IOException {
        Preconditions.checkNotNull(bArr);
        while (true) {
            InputStream inputStream = this.f28031b;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read(bArr, i4, i5);
            if (read != -1) {
                return read;
            }
            b();
        }
    }
}
