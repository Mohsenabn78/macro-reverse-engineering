package com.fasterxml.jackson.core.io;

import com.google.android.gms.location.places.Place;
import com.google.common.base.Ascii;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class UTF32Reader extends a {

    /* renamed from: g  reason: collision with root package name */
    protected final boolean f17761g;

    /* renamed from: h  reason: collision with root package name */
    protected char f17762h;

    /* renamed from: i  reason: collision with root package name */
    protected int f17763i;

    /* renamed from: j  reason: collision with root package name */
    protected int f17764j;

    /* renamed from: k  reason: collision with root package name */
    protected final boolean f17765k;

    public UTF32Reader(IOContext iOContext, InputStream inputStream, byte[] bArr, int i4, int i5, boolean z3) {
        super(iOContext, inputStream, bArr, i4, i5);
        this.f17762h = (char) 0;
        this.f17763i = 0;
        this.f17764j = 0;
        this.f17761g = z3;
        this.f17765k = inputStream != null;
    }

    private boolean d(int i4) throws IOException {
        int read;
        int read2;
        this.f17764j += this.f17776e - i4;
        if (i4 > 0) {
            if (this.f17775d > 0) {
                for (int i5 = 0; i5 < i4; i5++) {
                    byte[] bArr = this.f17774c;
                    bArr[i5] = bArr[this.f17775d + i5];
                }
                this.f17775d = 0;
            }
            this.f17776e = i4;
        } else {
            this.f17775d = 0;
            InputStream inputStream = this.f17773b;
            if (inputStream == null) {
                read = -1;
            } else {
                read = inputStream.read(this.f17774c);
            }
            if (read < 1) {
                this.f17776e = 0;
                if (read < 0) {
                    if (this.f17765k) {
                        freeBuffers();
                    }
                    return false;
                }
                c();
            }
            this.f17776e = read;
        }
        while (true) {
            int i6 = this.f17776e;
            if (i6 >= 4) {
                return true;
            }
            InputStream inputStream2 = this.f17773b;
            if (inputStream2 == null) {
                read2 = -1;
            } else {
                byte[] bArr2 = this.f17774c;
                read2 = inputStream2.read(bArr2, i6, bArr2.length - i6);
            }
            if (read2 < 1) {
                if (read2 < 0) {
                    if (this.f17765k) {
                        freeBuffers();
                    }
                    f(this.f17776e, 4);
                }
                c();
            }
            this.f17776e += read2;
        }
    }

    private void e(int i4, int i5, String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid UTF-32 character 0x");
        sb.append(Integer.toHexString(i4));
        sb.append(str);
        sb.append(" at char #");
        sb.append(this.f17763i + i5);
        sb.append(", byte #");
        sb.append((this.f17764j + this.f17775d) - 1);
        sb.append(")");
        throw new CharConversionException(sb.toString());
    }

    private void f(int i4, int i5) throws IOException {
        int i6 = this.f17763i;
        throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + i4 + ", needed " + i5 + ", at char #" + i6 + ", byte #" + (this.f17764j + i4) + ")");
    }

    @Override // com.fasterxml.jackson.core.io.a, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() throws IOException {
        super.close();
    }

    @Override // com.fasterxml.jackson.core.io.a, java.io.Reader
    public /* bridge */ /* synthetic */ int read() throws IOException {
        return super.read();
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i4, int i5) throws IOException {
        int i6;
        int i7;
        int i8;
        int i9;
        if (this.f17774c == null) {
            return -1;
        }
        if (i5 < 1) {
            return i5;
        }
        if (i4 < 0 || i4 + i5 > cArr.length) {
            b(cArr, i4, i5);
        }
        int i10 = i5 + i4;
        char c4 = this.f17762h;
        if (c4 != 0) {
            i6 = i4 + 1;
            cArr[i4] = c4;
            this.f17762h = (char) 0;
        } else {
            int i11 = this.f17776e - this.f17775d;
            if (i11 < 4 && !d(i11)) {
                return -1;
            }
            i6 = i4;
        }
        while (i6 < i10) {
            int i12 = this.f17775d;
            if (this.f17761g) {
                byte[] bArr = this.f17774c;
                i7 = (bArr[i12] << Ascii.CAN) | ((bArr[i12 + 1] & 255) << 16) | ((bArr[i12 + 2] & 255) << 8);
                i8 = bArr[i12 + 3] & 255;
            } else {
                byte[] bArr2 = this.f17774c;
                i7 = (bArr2[i12] & 255) | ((bArr2[i12 + 1] & 255) << 8) | ((bArr2[i12 + 2] & 255) << 16);
                i8 = bArr2[i12 + 3] << Ascii.CAN;
            }
            int i13 = i8 | i7;
            this.f17775d = i12 + 4;
            if (i13 > 65535) {
                if (i13 > 1114111) {
                    e(i13, i6 - i4, "(above " + Integer.toHexString(1114111) + ") ");
                }
                int i14 = i13 - 65536;
                i9 = i6 + 1;
                cArr[i6] = (char) ((i14 >> 10) + 55296);
                i13 = 56320 | (i14 & Place.TYPE_SUBLOCALITY_LEVEL_1);
                if (i9 >= i10) {
                    this.f17762h = (char) i13;
                    i6 = i9;
                    break;
                }
                i6 = i9;
            }
            i9 = i6 + 1;
            cArr[i6] = (char) i13;
            if (this.f17775d >= this.f17776e) {
                i6 = i9;
                break;
            }
            i6 = i9;
        }
        int i15 = i6 - i4;
        this.f17763i += i15;
        return i15;
    }
}
