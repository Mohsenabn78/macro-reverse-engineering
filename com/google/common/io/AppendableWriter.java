package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
class AppendableWriter extends Writer {

    /* renamed from: a  reason: collision with root package name */
    private final Appendable f27915a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f27916b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppendableWriter(Appendable appendable) {
        this.f27915a = (Appendable) Preconditions.checkNotNull(appendable);
    }

    private void b() throws IOException {
        if (!this.f27916b) {
            return;
        }
        throw new IOException("Cannot write to a closed writer.");
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f27916b = true;
        Appendable appendable = this.f27915a;
        if (appendable instanceof Closeable) {
            ((Closeable) appendable).close();
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        b();
        Appendable appendable = this.f27915a;
        if (appendable instanceof Flushable) {
            ((Flushable) appendable).flush();
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i4, int i5) throws IOException {
        b();
        this.f27915a.append(new String(cArr, i4, i5));
    }

    @Override // java.io.Writer
    public void write(int i4) throws IOException {
        b();
        this.f27915a.append((char) i4);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c4) throws IOException {
        b();
        this.f27915a.append(c4);
        return this;
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        Preconditions.checkNotNull(str);
        b();
        this.f27915a.append(str);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(@CheckForNull CharSequence charSequence) throws IOException {
        b();
        this.f27915a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(@CheckForNull CharSequence charSequence, int i4, int i5) throws IOException {
        b();
        this.f27915a.append(charSequence, i4, i5);
        return this;
    }

    @Override // java.io.Writer
    public void write(String str, int i4, int i5) throws IOException {
        Preconditions.checkNotNull(str);
        b();
        this.f27915a.append(str, i4, i5 + i4);
    }
}
