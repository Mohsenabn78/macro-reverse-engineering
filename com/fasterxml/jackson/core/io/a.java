package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* compiled from: BaseReader.java */
/* loaded from: classes3.dex */
abstract class a extends Reader {

    /* renamed from: a  reason: collision with root package name */
    protected final IOContext f17772a;

    /* renamed from: b  reason: collision with root package name */
    protected InputStream f17773b;

    /* renamed from: c  reason: collision with root package name */
    protected byte[] f17774c;

    /* renamed from: d  reason: collision with root package name */
    protected int f17775d;

    /* renamed from: e  reason: collision with root package name */
    protected int f17776e;

    /* renamed from: f  reason: collision with root package name */
    protected char[] f17777f = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IOContext iOContext, InputStream inputStream, byte[] bArr, int i4, int i5) {
        this.f17772a = iOContext;
        this.f17773b = inputStream;
        this.f17774c = bArr;
        this.f17775d = i4;
        this.f17776e = i5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(char[] cArr, int i4, int i5) throws IOException {
        throw new ArrayIndexOutOfBoundsException("read(buf," + i4 + "," + i5 + "), cbuf[" + cArr.length + "]");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.f17773b;
        if (inputStream != null) {
            this.f17773b = null;
            freeBuffers();
            inputStream.close();
        }
    }

    public final void freeBuffers() {
        byte[] bArr = this.f17774c;
        if (bArr != null) {
            this.f17774c = null;
            this.f17772a.releaseReadIOBuffer(bArr);
        }
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        if (this.f17777f == null) {
            this.f17777f = new char[1];
        }
        if (read(this.f17777f, 0, 1) < 1) {
            return -1;
        }
        return this.f17777f[0];
    }
}
