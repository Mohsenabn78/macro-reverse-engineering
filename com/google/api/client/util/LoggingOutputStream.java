package com.google.api.client.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes5.dex */
public class LoggingOutputStream extends FilterOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final LoggingByteArrayOutputStream f26135a;

    public LoggingOutputStream(OutputStream outputStream, Logger logger, Level level, int i4) {
        super(outputStream);
        this.f26135a = new LoggingByteArrayOutputStream(logger, level, i4);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f26135a.close();
        super.close();
    }

    public final LoggingByteArrayOutputStream getLogStream() {
        return this.f26135a;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i4) throws IOException {
        ((FilterOutputStream) this).out.write(i4);
        this.f26135a.write(i4);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i4, int i5) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i4, i5);
        this.f26135a.write(bArr, i4, i5);
    }
}
