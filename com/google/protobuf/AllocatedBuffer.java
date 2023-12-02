package com.google.protobuf;

import java.nio.ByteBuffer;

@CheckReturnValue
/* loaded from: classes6.dex */
abstract class AllocatedBuffer {
    AllocatedBuffer() {
    }

    public static AllocatedBuffer i(final ByteBuffer byteBuffer) {
        Internal.b(byteBuffer, "buffer");
        return new AllocatedBuffer() { // from class: com.google.protobuf.AllocatedBuffer.1
            @Override // com.google.protobuf.AllocatedBuffer
            public byte[] a() {
                return byteBuffer.array();
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public int b() {
                return byteBuffer.arrayOffset();
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public boolean c() {
                return byteBuffer.hasArray();
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public boolean d() {
                return true;
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public int e() {
                return byteBuffer.limit();
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public ByteBuffer f() {
                return byteBuffer;
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public int g() {
                return byteBuffer.position();
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public AllocatedBuffer h(int i4) {
                byteBuffer.position(i4);
                return this;
            }
        };
    }

    public static AllocatedBuffer j(byte[] bArr) {
        return l(bArr, 0, bArr.length);
    }

    public static AllocatedBuffer k(byte[] bArr, int i4, int i5) {
        if (i4 >= 0 && i5 >= 0 && i4 + i5 <= bArr.length) {
            return l(bArr, i4, i5);
        }
        throw new IndexOutOfBoundsException(String.format("bytes.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i4), Integer.valueOf(i5)));
    }

    private static AllocatedBuffer l(final byte[] bArr, final int i4, final int i5) {
        return new AllocatedBuffer() { // from class: com.google.protobuf.AllocatedBuffer.2

            /* renamed from: a  reason: collision with root package name */
            private int f33146a;

            @Override // com.google.protobuf.AllocatedBuffer
            public byte[] a() {
                return bArr;
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public int b() {
                return i4;
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public boolean c() {
                return true;
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public boolean d() {
                return false;
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public int e() {
                return i5;
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public ByteBuffer f() {
                throw new UnsupportedOperationException();
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public int g() {
                return this.f33146a;
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public AllocatedBuffer h(int i6) {
                if (i6 >= 0 && i6 <= i5) {
                    this.f33146a = i6;
                    return this;
                }
                throw new IllegalArgumentException("Invalid position: " + i6);
            }
        };
    }

    public abstract byte[] a();

    public abstract int b();

    public abstract boolean c();

    public abstract boolean d();

    public abstract int e();

    public abstract ByteBuffer f();

    public abstract int g();

    @CanIgnoreReturnValue
    public abstract AllocatedBuffer h(int i4);
}
