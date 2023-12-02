package com.google.api.client.util;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes5.dex */
public class LoggingByteArrayOutputStream extends ByteArrayOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private int f26129a;

    /* renamed from: b  reason: collision with root package name */
    private final int f26130b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f26131c;

    /* renamed from: d  reason: collision with root package name */
    private final Level f26132d;

    /* renamed from: e  reason: collision with root package name */
    private final Logger f26133e;

    public LoggingByteArrayOutputStream(Logger logger, Level level, int i4) {
        boolean z3;
        this.f26133e = (Logger) Preconditions.checkNotNull(logger);
        this.f26132d = (Level) Preconditions.checkNotNull(level);
        if (i4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        this.f26130b = i4;
    }

    private static void b(StringBuilder sb, int i4) {
        if (i4 == 1) {
            sb.append("1 byte");
            return;
        }
        sb.append(NumberFormat.getInstance().format(i4));
        sb.append(" bytes");
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (!this.f26131c) {
            if (this.f26129a != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Total: ");
                b(sb, this.f26129a);
                int i4 = ((ByteArrayOutputStream) this).count;
                if (i4 != 0 && i4 < this.f26129a) {
                    sb.append(" (logging first ");
                    b(sb, ((ByteArrayOutputStream) this).count);
                    sb.append(")");
                }
                this.f26133e.config(sb.toString());
                if (((ByteArrayOutputStream) this).count != 0) {
                    this.f26133e.log(this.f26132d, toString("UTF-8").replaceAll("[\\x00-\\x09\\x0B\\x0C\\x0E-\\x1F\\x7F]", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR));
                }
            }
            this.f26131c = true;
        }
    }

    public final synchronized int getBytesWritten() {
        return this.f26129a;
    }

    public final int getMaximumBytesToLog() {
        return this.f26130b;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i4) {
        Preconditions.checkArgument(!this.f26131c);
        this.f26129a++;
        if (((ByteArrayOutputStream) this).count < this.f26130b) {
            super.write(i4);
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i4, int i5) {
        Preconditions.checkArgument(!this.f26131c);
        this.f26129a += i5;
        int i6 = ((ByteArrayOutputStream) this).count;
        int i7 = this.f26130b;
        if (i6 < i7) {
            int i8 = i6 + i5;
            if (i8 > i7) {
                i5 += i7 - i8;
            }
            super.write(bArr, i4, i5);
        }
    }
}
