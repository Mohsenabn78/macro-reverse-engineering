package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
class MultiReader extends Reader {

    /* renamed from: a  reason: collision with root package name */
    private final Iterator<? extends CharSource> f28032a;
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    private Reader f28033b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiReader(Iterator<? extends CharSource> it) throws IOException {
        this.f28032a = it;
        b();
    }

    private void b() throws IOException {
        close();
        if (this.f28032a.hasNext()) {
            this.f28033b = this.f28032a.next().openStream();
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Reader reader = this.f28033b;
        if (reader != null) {
            try {
                reader.close();
            } finally {
                this.f28033b = null;
            }
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i4, int i5) throws IOException {
        Preconditions.checkNotNull(cArr);
        Reader reader = this.f28033b;
        if (reader == null) {
            return -1;
        }
        int read = reader.read(cArr, i4, i5);
        if (read == -1) {
            b();
            return read(cArr, i4, i5);
        }
        return read;
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        Reader reader = this.f28033b;
        if (reader != null && reader.ready()) {
            return true;
        }
        return false;
    }

    @Override // java.io.Reader
    public long skip(long j4) throws IOException {
        boolean z3;
        int i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        if (i4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "n is negative");
        if (i4 > 0) {
            while (true) {
                Reader reader = this.f28033b;
                if (reader == null) {
                    break;
                }
                long skip = reader.skip(j4);
                if (skip > 0) {
                    return skip;
                }
                b();
            }
        }
        return 0L;
    }
}
