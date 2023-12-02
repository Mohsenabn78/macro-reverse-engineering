package com.sun.mail.pop3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.mail.util.SharedFileInputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WritableSharedFile.java */
/* loaded from: classes6.dex */
public class f extends SharedFileInputStream {

    /* renamed from: a  reason: collision with root package name */
    private RandomAccessFile f37953a;

    /* renamed from: b  reason: collision with root package name */
    private a f37954b;

    public f(File file) throws IOException {
        super(file);
        try {
            this.f37953a = new RandomAccessFile(file, "rw");
        } catch (IOException unused) {
            super.close();
        }
    }

    public synchronized a b() throws IOException {
        a aVar;
        if (this.f37954b == null) {
            aVar = new a(this);
            this.f37954b = aVar;
        } else {
            throw new IOException("POP3 file cache only supports single threaded access");
        }
        return aVar;
    }

    public RandomAccessFile c() {
        return this.f37953a;
    }

    @Override // javax.mail.util.SharedFileInputStream, java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            super.close();
        } finally {
            this.f37953a.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long d() throws IOException {
        long length;
        length = this.in.length();
        this.datalen = length;
        this.f37954b = null;
        return length;
    }
}
