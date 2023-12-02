package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.Objects;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
final class CharSequenceReader extends Reader {
    @CheckForNull

    /* renamed from: a  reason: collision with root package name */
    private CharSequence f27981a;

    /* renamed from: b  reason: collision with root package name */
    private int f27982b;

    /* renamed from: c  reason: collision with root package name */
    private int f27983c;

    public CharSequenceReader(CharSequence charSequence) {
        this.f27981a = (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    private void b() throws IOException {
        if (this.f27981a != null) {
            return;
        }
        throw new IOException("reader closed");
    }

    private boolean c() {
        if (d() > 0) {
            return true;
        }
        return false;
    }

    private int d() {
        Objects.requireNonNull(this.f27981a);
        return this.f27981a.length() - this.f27982b;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f27981a = null;
    }

    @Override // java.io.Reader
    public synchronized void mark(int i4) throws IOException {
        boolean z3;
        if (i4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "readAheadLimit (%s) may not be negative", i4);
        b();
        this.f27983c = this.f27982b;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader, java.lang.Readable
    public synchronized int read(CharBuffer charBuffer) throws IOException {
        Preconditions.checkNotNull(charBuffer);
        b();
        Objects.requireNonNull(this.f27981a);
        if (c()) {
            int min = Math.min(charBuffer.remaining(), d());
            for (int i4 = 0; i4 < min; i4++) {
                CharSequence charSequence = this.f27981a;
                int i5 = this.f27982b;
                this.f27982b = i5 + 1;
                charBuffer.put(charSequence.charAt(i5));
            }
            return min;
        }
        return -1;
    }

    @Override // java.io.Reader
    public synchronized boolean ready() throws IOException {
        b();
        return true;
    }

    @Override // java.io.Reader
    public synchronized void reset() throws IOException {
        b();
        this.f27982b = this.f27983c;
    }

    @Override // java.io.Reader
    public synchronized long skip(long j4) throws IOException {
        boolean z3;
        int min;
        if (j4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "n (%s) may not be negative", j4);
        b();
        min = (int) Math.min(d(), j4);
        this.f27982b += min;
        return min;
    }

    @Override // java.io.Reader
    public synchronized int read() throws IOException {
        char c4;
        b();
        Objects.requireNonNull(this.f27981a);
        if (c()) {
            CharSequence charSequence = this.f27981a;
            int i4 = this.f27982b;
            this.f27982b = i4 + 1;
            c4 = charSequence.charAt(i4);
        } else {
            c4 = 65535;
        }
        return c4;
    }

    @Override // java.io.Reader
    public synchronized int read(char[] cArr, int i4, int i5) throws IOException {
        Preconditions.checkPositionIndexes(i4, i4 + i5, cArr.length);
        b();
        Objects.requireNonNull(this.f27981a);
        if (c()) {
            int min = Math.min(i5, d());
            for (int i6 = 0; i6 < min; i6++) {
                CharSequence charSequence = this.f27981a;
                int i7 = this.f27982b;
                this.f27982b = i7 + 1;
                cArr[i4 + i6] = charSequence.charAt(i7);
            }
            return min;
        }
        return -1;
    }
}
