package com.sun.mail.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;

/* loaded from: classes6.dex */
public class LogOutputStream extends OutputStream {
    protected MailLogger logger;
    private int lastb = -1;
    private byte[] buf = new byte[80];
    private int pos = 0;
    protected Level level = Level.FINEST;

    public LogOutputStream(MailLogger mailLogger) {
        this.logger = mailLogger;
    }

    private void expandCapacity(int i4) {
        while (true) {
            int i5 = this.pos;
            int i6 = i5 + i4;
            byte[] bArr = this.buf;
            if (i6 > bArr.length) {
                byte[] bArr2 = new byte[bArr.length * 2];
                System.arraycopy(bArr, 0, bArr2, 0, i5);
                this.buf = bArr2;
            } else {
                return;
            }
        }
    }

    private void logBuf() {
        String str = new String(this.buf, 0, this.pos);
        this.pos = 0;
        log(str);
    }

    protected void log(String str) {
        this.logger.log(this.level, str);
    }

    @Override // java.io.OutputStream
    public void write(int i4) throws IOException {
        if (this.logger.isLoggable(this.level)) {
            if (i4 == 13) {
                logBuf();
            } else if (i4 == 10) {
                if (this.lastb != 13) {
                    logBuf();
                }
            } else {
                expandCapacity(1);
                byte[] bArr = this.buf;
                int i5 = this.pos;
                this.pos = i5 + 1;
                bArr[i5] = (byte) i4;
            }
            this.lastb = i4;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i4, int i5) throws IOException {
        if (this.logger.isLoggable(this.level)) {
            int i6 = i5 + i4;
            int i7 = i4;
            while (i4 < i6) {
                byte b4 = bArr[i4];
                if (b4 == 13) {
                    int i8 = i4 - i7;
                    expandCapacity(i8);
                    System.arraycopy(bArr, i7, this.buf, this.pos, i8);
                    this.pos += i8;
                    logBuf();
                } else if (b4 == 10) {
                    if (this.lastb != 13) {
                        int i9 = i4 - i7;
                        expandCapacity(i9);
                        System.arraycopy(bArr, i7, this.buf, this.pos, i9);
                        this.pos += i9;
                        logBuf();
                    }
                } else {
                    this.lastb = bArr[i4];
                    i4++;
                }
                i7 = i4 + 1;
                this.lastb = bArr[i4];
                i4++;
            }
            int i10 = i6 - i7;
            if (i10 > 0) {
                expandCapacity(i10);
                System.arraycopy(bArr, i7, this.buf, this.pos, i10);
                this.pos += i10;
            }
        }
    }
}
