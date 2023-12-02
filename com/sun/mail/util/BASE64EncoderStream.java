package com.sun.mail.util;

import com.google.common.base.Ascii;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.io.encoding.Base64;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* loaded from: classes6.dex */
public class BASE64EncoderStream extends FilterOutputStream {
    private static byte[] newline = {Ascii.CR, 10};
    private static final char[] pem_array = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, 'n', 'o', 'p', 'q', Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', SignatureVisitor.EXTENDS, '/'};
    private byte[] buffer;
    private int bufsize;
    private int bytesPerLine;
    private int count;
    private int lineLimit;
    private boolean noCRLF;
    private byte[] outbuf;

    public BASE64EncoderStream(OutputStream outputStream, int i4) {
        super(outputStream);
        this.bufsize = 0;
        this.count = 0;
        this.noCRLF = false;
        this.buffer = new byte[3];
        if (i4 == Integer.MAX_VALUE || i4 < 4) {
            this.noCRLF = true;
            i4 = 76;
        }
        int i5 = (i4 / 4) * 4;
        this.bytesPerLine = i5;
        this.lineLimit = (i5 / 4) * 3;
        if (this.noCRLF) {
            this.outbuf = new byte[i5];
            return;
        }
        byte[] bArr = new byte[i5 + 2];
        this.outbuf = bArr;
        bArr[i5] = Ascii.CR;
        bArr[i5 + 1] = 10;
    }

    private void encode() throws IOException {
        int encodedSize = encodedSize(this.bufsize);
        ((FilterOutputStream) this).out.write(encode(this.buffer, 0, this.bufsize, this.outbuf), 0, encodedSize);
        int i4 = this.count + encodedSize;
        this.count = i4;
        if (i4 >= this.bytesPerLine) {
            if (!this.noCRLF) {
                ((FilterOutputStream) this).out.write(newline);
            }
            this.count = 0;
        }
    }

    private static int encodedSize(int i4) {
        return ((i4 + 2) / 3) * 4;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        flush();
        if (this.count > 0 && !this.noCRLF) {
            ((FilterOutputStream) this).out.write(newline);
            ((FilterOutputStream) this).out.flush();
        }
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.bufsize > 0) {
            encode();
            this.bufsize = 0;
        }
        ((FilterOutputStream) this).out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i4, int i5) throws IOException {
        int i6 = i5 + i4;
        while (this.bufsize != 0 && i4 < i6) {
            write(bArr[i4]);
            i4++;
        }
        int i7 = ((this.bytesPerLine - this.count) / 4) * 3;
        int i8 = i4 + i7;
        if (i8 <= i6) {
            int encodedSize = encodedSize(i7);
            if (!this.noCRLF) {
                byte[] bArr2 = this.outbuf;
                int i9 = encodedSize + 1;
                bArr2[encodedSize] = Ascii.CR;
                encodedSize = i9 + 1;
                bArr2[i9] = 10;
            }
            ((FilterOutputStream) this).out.write(encode(bArr, i4, i7, this.outbuf), 0, encodedSize);
            this.count = 0;
            i4 = i8;
        }
        while (true) {
            int i10 = this.lineLimit;
            if (i4 + i10 > i6) {
                break;
            }
            ((FilterOutputStream) this).out.write(encode(bArr, i4, i10, this.outbuf));
            i4 += this.lineLimit;
        }
        if (i4 + 3 <= i6) {
            int i11 = ((i6 - i4) / 3) * 3;
            int encodedSize2 = encodedSize(i11);
            ((FilterOutputStream) this).out.write(encode(bArr, i4, i11, this.outbuf), 0, encodedSize2);
            i4 += i11;
            this.count += encodedSize2;
        }
        while (i4 < i6) {
            write(bArr[i4]);
            i4++;
        }
    }

    public static byte[] encode(byte[] bArr) {
        return bArr.length == 0 ? bArr : encode(bArr, 0, bArr.length, null);
    }

    private static byte[] encode(byte[] bArr, int i4, int i5, byte[] bArr2) {
        if (bArr2 == null) {
            bArr2 = new byte[encodedSize(i5)];
        }
        int i6 = 0;
        while (i5 >= 3) {
            int i7 = i4 + 1;
            int i8 = i7 + 1;
            int i9 = ((((bArr[i4] & 255) << 8) | (bArr[i7] & 255)) << 8) | (bArr[i8] & 255);
            char[] cArr = pem_array;
            bArr2[i6 + 3] = (byte) cArr[i9 & 63];
            int i10 = i9 >> 6;
            bArr2[i6 + 2] = (byte) cArr[i10 & 63];
            int i11 = i10 >> 6;
            bArr2[i6 + 1] = (byte) cArr[i11 & 63];
            bArr2[i6 + 0] = (byte) cArr[(i11 >> 6) & 63];
            i5 -= 3;
            i6 += 4;
            i4 = i8 + 1;
        }
        if (i5 == 1) {
            int i12 = (bArr[i4] & 255) << 4;
            bArr2[i6 + 3] = Base64.padSymbol;
            bArr2[i6 + 2] = Base64.padSymbol;
            char[] cArr2 = pem_array;
            bArr2[i6 + 1] = (byte) cArr2[i12 & 63];
            bArr2[i6 + 0] = (byte) cArr2[(i12 >> 6) & 63];
        } else if (i5 == 2) {
            int i13 = ((bArr[i4 + 1] & 255) | ((bArr[i4] & 255) << 8)) << 2;
            bArr2[i6 + 3] = Base64.padSymbol;
            char[] cArr3 = pem_array;
            bArr2[i6 + 2] = (byte) cArr3[i13 & 63];
            int i14 = i13 >> 6;
            bArr2[i6 + 1] = (byte) cArr3[i14 & 63];
            bArr2[i6 + 0] = (byte) cArr3[(i14 >> 6) & 63];
        }
        return bArr2;
    }

    public BASE64EncoderStream(OutputStream outputStream) {
        this(outputStream, 76);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(int i4) throws IOException {
        byte[] bArr = this.buffer;
        int i5 = this.bufsize;
        int i6 = i5 + 1;
        this.bufsize = i6;
        bArr[i5] = (byte) i4;
        if (i6 == 3) {
            encode();
            this.bufsize = 0;
        }
    }
}
