package com.koushikdutta.async.http.server;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class BoundaryEmitter extends FilteredDataEmitter {

    /* renamed from: h  reason: collision with root package name */
    private byte[] f35364h;

    /* renamed from: i  reason: collision with root package name */
    int f35365i = 2;

    public String getBoundary() {
        byte[] bArr = this.f35364h;
        if (bArr == null) {
            return null;
        }
        return new String(bArr, 4, bArr.length - 4);
    }

    public String getBoundaryEnd() {
        return getBoundaryStart() + "--\r\n";
    }

    public String getBoundaryStart() {
        byte[] bArr = this.f35364h;
        return new String(bArr, 2, bArr.length - 2);
    }

    @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.callback.DataCallback
    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        if (this.f35365i > 0) {
            ByteBuffer obtain = ByteBufferList.obtain(this.f35364h.length);
            obtain.put(this.f35364h, 0, this.f35365i);
            obtain.flip();
            byteBufferList.addFirst(obtain);
            this.f35365i = 0;
        }
        int remaining = byteBufferList.remaining();
        byte[] bArr = new byte[remaining];
        byteBufferList.get(bArr);
        int i4 = 0;
        int i5 = 0;
        while (i4 < remaining) {
            int i6 = this.f35365i;
            if (i6 >= 0) {
                byte b4 = bArr[i4];
                byte[] bArr2 = this.f35364h;
                if (b4 == bArr2[i6]) {
                    int i7 = i6 + 1;
                    this.f35365i = i7;
                    if (i7 == bArr2.length) {
                        this.f35365i = -1;
                    }
                } else if (i6 > 0) {
                    i4 -= i6;
                    this.f35365i = 0;
                }
            } else if (i6 == -1) {
                byte b5 = bArr[i4];
                if (b5 == 13) {
                    this.f35365i = -4;
                    int length = (i4 - i5) - this.f35364h.length;
                    if (i5 != 0 || length != 0) {
                        ByteBuffer put = ByteBufferList.obtain(length).put(bArr, i5, length);
                        put.flip();
                        ByteBufferList byteBufferList2 = new ByteBufferList();
                        byteBufferList2.add(put);
                        super.onDataAvailable(this, byteBufferList2);
                    }
                    c();
                } else if (b5 == 45) {
                    this.f35365i = -2;
                } else {
                    a(new MimeEncodingException("Invalid multipart/form-data. Expected \r or -"));
                    return;
                }
            } else if (i6 == -2) {
                if (bArr[i4] == 45) {
                    this.f35365i = -3;
                } else {
                    a(new MimeEncodingException("Invalid multipart/form-data. Expected -"));
                    return;
                }
            } else if (i6 == -3) {
                if (bArr[i4] == 13) {
                    this.f35365i = -4;
                    int i8 = i4 - i5;
                    ByteBuffer put2 = ByteBufferList.obtain((i8 - this.f35364h.length) - 2).put(bArr, i5, (i8 - this.f35364h.length) - 2);
                    put2.flip();
                    ByteBufferList byteBufferList3 = new ByteBufferList();
                    byteBufferList3.add(put2);
                    super.onDataAvailable(this, byteBufferList3);
                    b();
                } else {
                    a(new MimeEncodingException("Invalid multipart/form-data. Expected \r"));
                    return;
                }
            } else if (i6 == -4) {
                if (bArr[i4] == 10) {
                    i5 = i4 + 1;
                    this.f35365i = 0;
                } else {
                    a(new MimeEncodingException("Invalid multipart/form-data. Expected \n"));
                }
            } else {
                a(new MimeEncodingException("Invalid multipart/form-data. Unknown state?"));
            }
            i4++;
        }
        if (i5 < remaining) {
            int max = (remaining - i5) - Math.max(this.f35365i, 0);
            ByteBuffer put3 = ByteBufferList.obtain(max).put(bArr, i5, max);
            put3.flip();
            ByteBufferList byteBufferList4 = new ByteBufferList();
            byteBufferList4.add(put3);
            super.onDataAvailable(this, byteBufferList4);
        }
    }

    public void setBoundary(String str) {
        this.f35364h = ("\r\n--" + str).getBytes();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
    }

    protected void c() {
    }
}
