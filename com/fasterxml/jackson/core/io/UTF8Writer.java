package com.fasterxml.jackson.core.io;

import com.android.dx.io.Opcodes;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import okio.Utf8;

/* loaded from: classes3.dex */
public final class UTF8Writer extends Writer {

    /* renamed from: a  reason: collision with root package name */
    protected final IOContext f17766a;

    /* renamed from: b  reason: collision with root package name */
    OutputStream f17767b;

    /* renamed from: c  reason: collision with root package name */
    byte[] f17768c;

    /* renamed from: d  reason: collision with root package name */
    final int f17769d;

    /* renamed from: e  reason: collision with root package name */
    int f17770e;

    /* renamed from: f  reason: collision with root package name */
    int f17771f = 0;

    public UTF8Writer(IOContext iOContext, OutputStream outputStream) {
        this.f17766a = iOContext;
        this.f17767b = outputStream;
        byte[] allocWriteEncodingBuffer = iOContext.allocWriteEncodingBuffer();
        this.f17768c = allocWriteEncodingBuffer;
        this.f17769d = allocWriteEncodingBuffer.length - 4;
        this.f17770e = 0;
    }

    private int b(int i4) throws IOException {
        int i5 = this.f17771f;
        this.f17771f = 0;
        if (i4 >= 56320 && i4 <= 57343) {
            return ((i5 - 55296) << 10) + 65536 + (i4 - Utf8.LOG_SURROGATE_HEADER);
        }
        throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(i5) + ", second 0x" + Integer.toHexString(i4) + "; illegal combination");
    }

    private void c(int i4) throws IOException {
        if (i4 <= 1114111) {
            if (i4 >= 55296) {
                if (i4 <= 56319) {
                    throw new IOException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(i4) + ")");
                }
                throw new IOException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(i4) + ")");
            }
            throw new IOException("Illegal character point (0x" + Integer.toHexString(i4) + ") to output");
        }
        throw new IOException("Illegal character point (0x" + Integer.toHexString(i4) + ") to output; max is 0x10FFFF as per RFC 4627");
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        OutputStream outputStream = this.f17767b;
        if (outputStream != null) {
            int i4 = this.f17770e;
            if (i4 > 0) {
                outputStream.write(this.f17768c, 0, i4);
                this.f17770e = 0;
            }
            OutputStream outputStream2 = this.f17767b;
            this.f17767b = null;
            byte[] bArr = this.f17768c;
            if (bArr != null) {
                this.f17768c = null;
                this.f17766a.releaseWriteEncodingBuffer(bArr);
            }
            outputStream2.close();
            int i5 = this.f17771f;
            this.f17771f = 0;
            if (i5 > 0) {
                c(i5);
            }
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        OutputStream outputStream = this.f17767b;
        if (outputStream != null) {
            int i4 = this.f17770e;
            if (i4 > 0) {
                outputStream.write(this.f17768c, 0, i4);
                this.f17770e = 0;
            }
            this.f17767b.flush();
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        write(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c4) throws IOException {
        write(c4);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0025, code lost:
        continue;
     */
    @Override // java.io.Writer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(char[] r8, int r9, int r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.UTF8Writer.write(char[], int, int):void");
    }

    @Override // java.io.Writer
    public void write(int i4) throws IOException {
        int i5;
        if (this.f17771f > 0) {
            i4 = b(i4);
        } else if (i4 >= 55296 && i4 <= 57343) {
            if (i4 > 56319) {
                c(i4);
            }
            this.f17771f = i4;
            return;
        }
        int i6 = this.f17770e;
        if (i6 >= this.f17769d) {
            this.f17767b.write(this.f17768c, 0, i6);
            this.f17770e = 0;
        }
        if (i4 < 128) {
            byte[] bArr = this.f17768c;
            int i7 = this.f17770e;
            this.f17770e = i7 + 1;
            bArr[i7] = (byte) i4;
            return;
        }
        int i8 = this.f17770e;
        if (i4 < 2048) {
            byte[] bArr2 = this.f17768c;
            int i9 = i8 + 1;
            bArr2[i8] = (byte) ((i4 >> 6) | 192);
            i5 = i9 + 1;
            bArr2[i9] = (byte) ((i4 & 63) | 128);
        } else if (i4 <= 65535) {
            byte[] bArr3 = this.f17768c;
            int i10 = i8 + 1;
            bArr3[i8] = (byte) ((i4 >> 12) | Opcodes.SHL_INT_LIT8);
            int i11 = i10 + 1;
            bArr3[i10] = (byte) (((i4 >> 6) & 63) | 128);
            bArr3[i11] = (byte) ((i4 & 63) | 128);
            i5 = i11 + 1;
        } else {
            if (i4 > 1114111) {
                c(i4);
            }
            byte[] bArr4 = this.f17768c;
            int i12 = i8 + 1;
            bArr4[i8] = (byte) ((i4 >> 18) | 240);
            int i13 = i12 + 1;
            bArr4[i12] = (byte) (((i4 >> 12) & 63) | 128);
            int i14 = i13 + 1;
            bArr4[i13] = (byte) (((i4 >> 6) & 63) | 128);
            i5 = i14 + 1;
            bArr4[i14] = (byte) ((i4 & 63) | 128);
        }
        this.f17770e = i5;
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0029, code lost:
        continue;
     */
    @Override // java.io.Writer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(java.lang.String r8, int r9, int r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.UTF8Writer.write(java.lang.String, int, int):void");
    }
}
