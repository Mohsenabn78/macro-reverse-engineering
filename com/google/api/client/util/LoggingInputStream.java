package com.google.api.client.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes5.dex */
public class LoggingInputStream extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private final LoggingByteArrayOutputStream f26134a;

    public LoggingInputStream(InputStream inputStream, Logger logger, Level level, int i4) {
        super(inputStream);
        this.f26134a = new LoggingByteArrayOutputStream(logger, level, i4);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f26134a.close();
        super.close();
    }

    public final LoggingByteArrayOutputStream getLogStream() {
        return this.f26134a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = super.read();
        this.f26134a.write(read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i4, int i5) throws IOException {
        int read = super.read(bArr, i4, i5);
        if (read > 0) {
            this.f26134a.write(bArr, i4, read);
        }
        return read;
    }
}
