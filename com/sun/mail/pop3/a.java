package com.sun.mail.pop3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppendStream.java */
/* loaded from: classes6.dex */
public class a extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final f f37914a;

    /* renamed from: b  reason: collision with root package name */
    private RandomAccessFile f37915b;

    /* renamed from: c  reason: collision with root package name */
    private final long f37916c;

    /* renamed from: d  reason: collision with root package name */
    private long f37917d;

    public a(f fVar) throws IOException {
        this.f37914a = fVar;
        RandomAccessFile c4 = fVar.c();
        this.f37915b = c4;
        long length = c4.length();
        this.f37916c = length;
        this.f37915b.seek(length);
    }

    public synchronized InputStream b() throws IOException {
        return this.f37914a.newStream(this.f37916c, this.f37917d);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f37917d = this.f37914a.d();
        this.f37915b = null;
    }

    @Override // java.io.OutputStream
    public void write(int i4) throws IOException {
        this.f37915b.write(i4);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.f37915b.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i4, int i5) throws IOException {
        this.f37915b.write(bArr, i4, i5);
    }
}
