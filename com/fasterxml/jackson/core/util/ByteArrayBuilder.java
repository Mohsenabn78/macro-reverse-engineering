package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.BufferRecycler;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public final class ByteArrayBuilder extends OutputStream {

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f17882f = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    private final BufferRecycler f17883a;

    /* renamed from: b  reason: collision with root package name */
    private final LinkedList<byte[]> f17884b;

    /* renamed from: c  reason: collision with root package name */
    private int f17885c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f17886d;

    /* renamed from: e  reason: collision with root package name */
    private int f17887e;

    public ByteArrayBuilder() {
        this((BufferRecycler) null);
    }

    private void b() {
        int length = this.f17885c + this.f17886d.length;
        this.f17885c = length;
        int max = Math.max(length >> 1, 1000);
        if (max > 262144) {
            max = 262144;
        }
        this.f17884b.add(this.f17886d);
        this.f17886d = new byte[max];
        this.f17887e = 0;
    }

    public void append(int i4) {
        if (this.f17887e >= this.f17886d.length) {
            b();
        }
        byte[] bArr = this.f17886d;
        int i5 = this.f17887e;
        this.f17887e = i5 + 1;
        bArr[i5] = (byte) i4;
    }

    public void appendThreeBytes(int i4) {
        int i5 = this.f17887e;
        int i6 = i5 + 2;
        byte[] bArr = this.f17886d;
        if (i6 < bArr.length) {
            int i7 = i5 + 1;
            bArr[i5] = (byte) (i4 >> 16);
            int i8 = i7 + 1;
            bArr[i7] = (byte) (i4 >> 8);
            this.f17887e = i8 + 1;
            bArr[i8] = (byte) i4;
            return;
        }
        append(i4 >> 16);
        append(i4 >> 8);
        append(i4);
    }

    public void appendTwoBytes(int i4) {
        int i5 = this.f17887e;
        int i6 = i5 + 1;
        byte[] bArr = this.f17886d;
        if (i6 < bArr.length) {
            int i7 = i5 + 1;
            bArr[i5] = (byte) (i4 >> 8);
            this.f17887e = i7 + 1;
            bArr[i7] = (byte) i4;
            return;
        }
        append(i4 >> 8);
        append(i4);
    }

    public byte[] completeAndCoalesce(int i4) {
        this.f17887e = i4;
        return toByteArray();
    }

    public byte[] finishCurrentSegment() {
        b();
        return this.f17886d;
    }

    public byte[] getCurrentSegment() {
        return this.f17886d;
    }

    public int getCurrentSegmentLength() {
        return this.f17887e;
    }

    public void release() {
        byte[] bArr;
        reset();
        BufferRecycler bufferRecycler = this.f17883a;
        if (bufferRecycler != null && (bArr = this.f17886d) != null) {
            bufferRecycler.releaseByteBuffer(BufferRecycler.ByteBufferType.WRITE_CONCAT_BUFFER, bArr);
            this.f17886d = null;
        }
    }

    public void reset() {
        this.f17885c = 0;
        this.f17887e = 0;
        if (!this.f17884b.isEmpty()) {
            this.f17884b.clear();
        }
    }

    public byte[] resetAndGetFirstSegment() {
        reset();
        return this.f17886d;
    }

    public void setCurrentSegmentLength(int i4) {
        this.f17887e = i4;
    }

    public byte[] toByteArray() {
        int i4 = this.f17885c + this.f17887e;
        if (i4 == 0) {
            return f17882f;
        }
        byte[] bArr = new byte[i4];
        Iterator<byte[]> it = this.f17884b.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            byte[] next = it.next();
            int length = next.length;
            System.arraycopy(next, 0, bArr, i5, length);
            i5 += length;
        }
        System.arraycopy(this.f17886d, 0, bArr, i5, this.f17887e);
        int i6 = i5 + this.f17887e;
        if (i6 == i4) {
            if (!this.f17884b.isEmpty()) {
                reset();
            }
            return bArr;
        }
        throw new RuntimeException("Internal error: total len assumed to be " + i4 + ", copied " + i6 + " bytes");
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public ByteArrayBuilder(BufferRecycler bufferRecycler) {
        this(bufferRecycler, 500);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i4, int i5) {
        while (true) {
            int min = Math.min(this.f17886d.length - this.f17887e, i5);
            if (min > 0) {
                System.arraycopy(bArr, i4, this.f17886d, this.f17887e, min);
                i4 += min;
                this.f17887e += min;
                i5 -= min;
            }
            if (i5 <= 0) {
                return;
            }
            b();
        }
    }

    public ByteArrayBuilder(int i4) {
        this(null, i4);
    }

    public ByteArrayBuilder(BufferRecycler bufferRecycler, int i4) {
        this.f17884b = new LinkedList<>();
        this.f17883a = bufferRecycler;
        if (bufferRecycler == null) {
            this.f17886d = new byte[i4];
        } else {
            this.f17886d = bufferRecycler.allocByteBuffer(BufferRecycler.ByteBufferType.WRITE_CONCAT_BUFFER);
        }
    }

    @Override // java.io.OutputStream
    public void write(int i4) {
        append(i4);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }
}
