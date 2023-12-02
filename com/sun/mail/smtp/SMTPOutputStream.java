package com.sun.mail.smtp;

import com.sun.mail.util.CRLFOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes6.dex */
public class SMTPOutputStream extends CRLFOutputStream {
    public SMTPOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void ensureAtBOL() throws IOException {
        if (!this.atBOL) {
            super.writeln();
        }
    }

    @Override // com.sun.mail.util.CRLFOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i4) throws IOException {
        int i5 = this.lastb;
        if ((i5 == 10 || i5 == 13 || i5 == -1) && i4 == 46) {
            ((FilterOutputStream) this).out.write(46);
        }
        super.write(i4);
    }

    @Override // com.sun.mail.util.CRLFOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i4, int i5) throws IOException {
        int i6 = this.lastb;
        int i7 = i6;
        if (i6 == -1) {
            i7 = 10;
        }
        int i8 = i5 + i4;
        int i9 = i7;
        int i10 = i4;
        while (i4 < i8) {
            if ((i9 == 10 || i9 == 13) && bArr[i4] == 46) {
                super.write(bArr, i10, i4 - i10);
                ((FilterOutputStream) this).out.write(46);
                i10 = i4;
            }
            i9 = bArr[i4];
            i4++;
        }
        int i11 = i8 - i10;
        if (i11 > 0) {
            super.write(bArr, i10, i11);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
    }
}
