package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes6.dex */
public class QPEncoderStream extends FilterOutputStream {
    private static final char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private int bytesPerLine;
    private int count;
    private boolean gotCR;
    private boolean gotSpace;

    public QPEncoderStream(OutputStream outputStream, int i4) {
        super(outputStream);
        this.count = 0;
        this.gotSpace = false;
        this.gotCR = false;
        this.bytesPerLine = i4 - 1;
    }

    private void outputCRLF() throws IOException {
        ((FilterOutputStream) this).out.write(13);
        ((FilterOutputStream) this).out.write(10);
        this.count = 0;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.gotSpace) {
            output(32, true);
            this.gotSpace = false;
        }
        ((FilterOutputStream) this).out.flush();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void output(int i4, boolean z3) throws IOException {
        if (z3) {
            int i5 = this.count + 3;
            this.count = i5;
            if (i5 > this.bytesPerLine) {
                ((FilterOutputStream) this).out.write(61);
                ((FilterOutputStream) this).out.write(13);
                ((FilterOutputStream) this).out.write(10);
                this.count = 3;
            }
            ((FilterOutputStream) this).out.write(61);
            OutputStream outputStream = ((FilterOutputStream) this).out;
            char[] cArr = hex;
            outputStream.write(cArr[i4 >> 4]);
            ((FilterOutputStream) this).out.write(cArr[i4 & 15]);
            return;
        }
        int i6 = this.count + 1;
        this.count = i6;
        if (i6 > this.bytesPerLine) {
            ((FilterOutputStream) this).out.write(61);
            ((FilterOutputStream) this).out.write(13);
            ((FilterOutputStream) this).out.write(10);
            this.count = 1;
        }
        ((FilterOutputStream) this).out.write(i4);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i4, int i5) throws IOException {
        for (int i6 = 0; i6 < i5; i6++) {
            write(bArr[i4 + i6]);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i4) throws IOException {
        int i5 = i4 & 255;
        if (this.gotSpace) {
            if (i5 != 13 && i5 != 10) {
                output(32, false);
            } else {
                output(32, true);
            }
            this.gotSpace = false;
        }
        if (i5 == 13) {
            this.gotCR = true;
            outputCRLF();
            return;
        }
        if (i5 == 10) {
            if (!this.gotCR) {
                outputCRLF();
            }
        } else if (i5 == 32) {
            this.gotSpace = true;
        } else if (i5 >= 32 && i5 < 127 && i5 != 61) {
            output(i5, false);
        } else {
            output(i5, true);
        }
        this.gotCR = false;
    }

    public QPEncoderStream(OutputStream outputStream) {
        this(outputStream, 76);
    }
}
