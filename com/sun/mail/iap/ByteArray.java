package com.sun.mail.iap;

import java.io.ByteArrayInputStream;

/* loaded from: classes6.dex */
public class ByteArray {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f37594a;

    /* renamed from: b  reason: collision with root package name */
    private int f37595b;

    /* renamed from: c  reason: collision with root package name */
    private int f37596c;

    public ByteArray(byte[] bArr, int i4, int i5) {
        this.f37594a = bArr;
        this.f37595b = i4;
        this.f37596c = i5;
    }

    public byte[] getBytes() {
        return this.f37594a;
    }

    public int getCount() {
        return this.f37596c;
    }

    public byte[] getNewBytes() {
        int i4 = this.f37596c;
        byte[] bArr = new byte[i4];
        System.arraycopy(this.f37594a, this.f37595b, bArr, 0, i4);
        return bArr;
    }

    public int getStart() {
        return this.f37595b;
    }

    public void grow(int i4) {
        byte[] bArr = this.f37594a;
        byte[] bArr2 = new byte[bArr.length + i4];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        this.f37594a = bArr2;
    }

    public void setCount(int i4) {
        this.f37596c = i4;
    }

    public ByteArrayInputStream toByteArrayInputStream() {
        return new ByteArrayInputStream(this.f37594a, this.f37595b, this.f37596c);
    }

    public ByteArray(int i4) {
        this(new byte[i4], 0, i4);
    }
}
