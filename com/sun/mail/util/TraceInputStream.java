package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;

/* loaded from: classes6.dex */
public class TraceInputStream extends FilterInputStream {
    private boolean quote;
    private boolean trace;
    private OutputStream traceOut;

    public TraceInputStream(InputStream inputStream, MailLogger mailLogger) {
        super(inputStream);
        this.trace = false;
        this.quote = false;
        this.trace = mailLogger.isLoggable(Level.FINEST);
        this.traceOut = new LogOutputStream(mailLogger);
    }

    private final void writeByte(int i4) throws IOException {
        int i5 = i4 & 255;
        if (i5 > 127) {
            this.traceOut.write(77);
            this.traceOut.write(45);
            i5 &= 127;
        }
        if (i5 == 13) {
            this.traceOut.write(92);
            this.traceOut.write(114);
        } else if (i5 == 10) {
            this.traceOut.write(92);
            this.traceOut.write(110);
            this.traceOut.write(10);
        } else if (i5 == 9) {
            this.traceOut.write(92);
            this.traceOut.write(116);
        } else if (i5 < 32) {
            this.traceOut.write(94);
            this.traceOut.write(i5 + 64);
        } else {
            this.traceOut.write(i5);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = ((FilterInputStream) this).in.read();
        if (this.trace && read != -1) {
            if (this.quote) {
                writeByte(read);
            } else {
                this.traceOut.write(read);
            }
        }
        return read;
    }

    public void setQuote(boolean z3) {
        this.quote = z3;
    }

    public void setTrace(boolean z3) {
        this.trace = z3;
    }

    public TraceInputStream(InputStream inputStream, OutputStream outputStream) {
        super(inputStream);
        this.trace = false;
        this.quote = false;
        this.traceOut = outputStream;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i4, int i5) throws IOException {
        int read = ((FilterInputStream) this).in.read(bArr, i4, i5);
        if (this.trace && read != -1) {
            if (this.quote) {
                for (int i6 = 0; i6 < read; i6++) {
                    writeByte(bArr[i4 + i6]);
                }
            } else {
                this.traceOut.write(bArr, i4, read);
            }
        }
        return read;
    }
}
