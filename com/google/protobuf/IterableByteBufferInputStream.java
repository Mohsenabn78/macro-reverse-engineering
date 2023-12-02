package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class IterableByteBufferInputStream extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private Iterator<ByteBuffer> f33433a;

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f33434b;

    /* renamed from: c  reason: collision with root package name */
    private int f33435c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f33436d;

    /* renamed from: e  reason: collision with root package name */
    private int f33437e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f33438f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f33439g;

    /* renamed from: h  reason: collision with root package name */
    private int f33440h;

    /* renamed from: i  reason: collision with root package name */
    private long f33441i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IterableByteBufferInputStream(Iterable<ByteBuffer> iterable) {
        this.f33433a = iterable.iterator();
        for (ByteBuffer byteBuffer : iterable) {
            this.f33435c++;
        }
        this.f33436d = -1;
        if (!b()) {
            this.f33434b = Internal.EMPTY_BYTE_BUFFER;
            this.f33436d = 0;
            this.f33437e = 0;
            this.f33441i = 0L;
        }
    }

    private boolean b() {
        this.f33436d++;
        if (!this.f33433a.hasNext()) {
            return false;
        }
        ByteBuffer next = this.f33433a.next();
        this.f33434b = next;
        this.f33437e = next.position();
        if (this.f33434b.hasArray()) {
            this.f33438f = true;
            this.f33439g = this.f33434b.array();
            this.f33440h = this.f33434b.arrayOffset();
        } else {
            this.f33438f = false;
            this.f33441i = UnsafeUtil.k(this.f33434b);
            this.f33439g = null;
        }
        return true;
    }

    private void c(int i4) {
        int i5 = this.f33437e + i4;
        this.f33437e = i5;
        if (i5 == this.f33434b.limit()) {
            b();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f33436d == this.f33435c) {
            return -1;
        }
        if (this.f33438f) {
            int i4 = this.f33439g[this.f33437e + this.f33440h] & 255;
            c(1);
            return i4;
        }
        int x3 = UnsafeUtil.x(this.f33437e + this.f33441i) & 255;
        c(1);
        return x3;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i4, int i5) throws IOException {
        if (this.f33436d == this.f33435c) {
            return -1;
        }
        int limit = this.f33434b.limit();
        int i6 = this.f33437e;
        int i7 = limit - i6;
        if (i5 > i7) {
            i5 = i7;
        }
        if (this.f33438f) {
            System.arraycopy(this.f33439g, i6 + this.f33440h, bArr, i4, i5);
            c(i5);
        } else {
            int position = this.f33434b.position();
            this.f33434b.position(this.f33437e);
            this.f33434b.get(bArr, i4, i5);
            this.f33434b.position(position);
            c(i5);
        }
        return i5;
    }
}
