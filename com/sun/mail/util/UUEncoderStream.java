package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import okio.Utf8;

/* loaded from: classes6.dex */
public class UUEncoderStream extends FilterOutputStream {
    private byte[] buffer;
    private int bufsize;
    private int mode;
    private String name;
    private boolean wrotePrefix;
    private boolean wroteSuffix;

    public UUEncoderStream(OutputStream outputStream) {
        this(outputStream, "encoder.buf", 420);
    }

    private void encode() throws IOException {
        int i4;
        byte b4;
        ((FilterOutputStream) this).out.write((this.bufsize & 63) + 32);
        int i5 = 0;
        while (true) {
            int i6 = this.bufsize;
            if (i5 < i6) {
                byte[] bArr = this.buffer;
                int i7 = i5 + 1;
                byte b5 = bArr[i5];
                byte b6 = 1;
                if (i7 < i6) {
                    int i8 = i7 + 1;
                    byte b7 = bArr[i7];
                    if (i8 < i6) {
                        i4 = i8 + 1;
                        b4 = bArr[i8];
                        b6 = b7;
                        int i9 = ((b5 << 4) & 48) | ((b6 >>> 4) & 15);
                        int i10 = ((b6 << 2) & 60) | ((b4 >>> 6) & 3);
                        int i11 = b4 & Utf8.REPLACEMENT_BYTE;
                        ((FilterOutputStream) this).out.write(((b5 >>> 2) & 63) + 32);
                        ((FilterOutputStream) this).out.write(i9 + 32);
                        ((FilterOutputStream) this).out.write(i10 + 32);
                        ((FilterOutputStream) this).out.write(i11 + 32);
                        i5 = i4;
                    } else {
                        b6 = b7;
                        i4 = i8;
                    }
                } else {
                    i4 = i7;
                }
                b4 = 1;
                int i92 = ((b5 << 4) & 48) | ((b6 >>> 4) & 15);
                int i102 = ((b6 << 2) & 60) | ((b4 >>> 6) & 3);
                int i112 = b4 & Utf8.REPLACEMENT_BYTE;
                ((FilterOutputStream) this).out.write(((b5 >>> 2) & 63) + 32);
                ((FilterOutputStream) this).out.write(i92 + 32);
                ((FilterOutputStream) this).out.write(i102 + 32);
                ((FilterOutputStream) this).out.write(i112 + 32);
                i5 = i4;
            } else {
                ((FilterOutputStream) this).out.write(10);
                return;
            }
        }
    }

    private void writePrefix() throws IOException {
        if (!this.wrotePrefix) {
            PrintStream printStream = new PrintStream(((FilterOutputStream) this).out, false, "utf-8");
            printStream.format("begin %o %s%n", Integer.valueOf(this.mode), this.name);
            printStream.flush();
            this.wrotePrefix = true;
        }
    }

    private void writeSuffix() throws IOException {
        if (!this.wroteSuffix) {
            PrintStream printStream = new PrintStream(((FilterOutputStream) this).out, false, "us-ascii");
            printStream.println(" \nend");
            printStream.flush();
            this.wroteSuffix = true;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.bufsize > 0) {
            writePrefix();
            encode();
            this.bufsize = 0;
        }
        writeSuffix();
        ((FilterOutputStream) this).out.flush();
    }

    public void setNameMode(String str, int i4) {
        this.name = str;
        this.mode = i4;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i4, int i5) throws IOException {
        for (int i6 = 0; i6 < i5; i6++) {
            write(bArr[i4 + i6]);
        }
    }

    public UUEncoderStream(OutputStream outputStream, String str) {
        this(outputStream, str, 420);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public UUEncoderStream(OutputStream outputStream, String str, int i4) {
        super(outputStream);
        this.bufsize = 0;
        this.wrotePrefix = false;
        this.wroteSuffix = false;
        this.name = str;
        this.mode = i4;
        this.buffer = new byte[45];
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i4) throws IOException {
        byte[] bArr = this.buffer;
        int i5 = this.bufsize;
        int i6 = i5 + 1;
        this.bufsize = i6;
        bArr[i5] = (byte) i4;
        if (i6 == 45) {
            writePrefix();
            encode();
            this.bufsize = 0;
        }
    }
}
