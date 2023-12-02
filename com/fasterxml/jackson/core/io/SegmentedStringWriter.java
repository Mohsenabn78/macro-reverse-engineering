package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.io.Writer;

/* loaded from: classes3.dex */
public final class SegmentedStringWriter extends Writer {

    /* renamed from: a  reason: collision with root package name */
    protected final TextBuffer f17759a;

    public SegmentedStringWriter(BufferRecycler bufferRecycler) {
        this.f17759a = new TextBuffer(bufferRecycler);
    }

    public String getAndClear() {
        String contentsAsString = this.f17759a.contentsAsString();
        this.f17759a.releaseBuffers();
        return contentsAsString;
    }

    @Override // java.io.Writer
    public void write(char[] cArr) {
        this.f17759a.append(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i4, int i5) {
        this.f17759a.append(cArr, i4, i5);
    }

    @Override // java.io.Writer
    public void write(int i4) {
        this.f17759a.append((char) i4);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c4) {
        write(c4);
        return this;
    }

    @Override // java.io.Writer
    public void write(String str) {
        this.f17759a.append(str, 0, str.length());
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        this.f17759a.append(charSequence2, 0, charSequence2.length());
        return this;
    }

    @Override // java.io.Writer
    public void write(String str, int i4, int i5) {
        this.f17759a.append(str, i4, i5);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i4, int i5) {
        String charSequence2 = charSequence.subSequence(i4, i5).toString();
        this.f17759a.append(charSequence2, 0, charSequence2.length());
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }
}
