package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
abstract class AbstractStreamingHasher extends AbstractHasher {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f27814a;

    /* renamed from: b  reason: collision with root package name */
    private final int f27815b;

    /* renamed from: c  reason: collision with root package name */
    private final int f27816c;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractStreamingHasher(int i4) {
        this(i4, i4);
    }

    private void b() {
        Java8Compatibility.b(this.f27814a);
        while (this.f27814a.remaining() >= this.f27816c) {
            d(this.f27814a);
        }
        this.f27814a.compact();
    }

    private void c() {
        if (this.f27814a.remaining() < 8) {
            b();
        }
    }

    @CanIgnoreReturnValue
    private Hasher f(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.f27814a.remaining()) {
            this.f27814a.put(byteBuffer);
            c();
            return this;
        }
        int position = this.f27815b - this.f27814a.position();
        for (int i4 = 0; i4 < position; i4++) {
            this.f27814a.put(byteBuffer.get());
        }
        b();
        while (byteBuffer.remaining() >= this.f27816c) {
            d(byteBuffer);
        }
        this.f27814a.put(byteBuffer);
        return this;
    }

    protected abstract HashCode a();

    protected abstract void d(ByteBuffer byteBuffer);

    protected void e(ByteBuffer byteBuffer) {
        Java8Compatibility.d(byteBuffer, byteBuffer.limit());
        Java8Compatibility.c(byteBuffer, this.f27816c + 7);
        while (true) {
            int position = byteBuffer.position();
            int i4 = this.f27816c;
            if (position < i4) {
                byteBuffer.putLong(0L);
            } else {
                Java8Compatibility.c(byteBuffer, i4);
                Java8Compatibility.b(byteBuffer);
                d(byteBuffer);
                return;
            }
        }
    }

    @Override // com.google.common.hash.Hasher
    public final HashCode hash() {
        b();
        Java8Compatibility.b(this.f27814a);
        if (this.f27814a.remaining() > 0) {
            e(this.f27814a);
            ByteBuffer byteBuffer = this.f27814a;
            Java8Compatibility.d(byteBuffer, byteBuffer.limit());
        }
        return a();
    }

    protected AbstractStreamingHasher(int i4, int i5) {
        Preconditions.checkArgument(i5 % i4 == 0);
        this.f27814a = ByteBuffer.allocate(i5 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f27815b = i5;
        this.f27816c = i4;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    public final Hasher putByte(byte b4) {
        this.f27814a.put(b4);
        c();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    public final Hasher putChar(char c4) {
        this.f27814a.putChar(c4);
        c();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    public final Hasher putInt(int i4) {
        this.f27814a.putInt(i4);
        c();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    public final Hasher putLong(long j4) {
        this.f27814a.putLong(j4);
        c();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    public final Hasher putShort(short s3) {
        this.f27814a.putShort(s3);
        c();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    public final Hasher putBytes(byte[] bArr, int i4, int i5) {
        return f(ByteBuffer.wrap(bArr, i4, i5).order(ByteOrder.LITTLE_ENDIAN));
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    public final Hasher putBytes(ByteBuffer byteBuffer) {
        ByteOrder order = byteBuffer.order();
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            return f(byteBuffer);
        } finally {
            byteBuffer.order(order);
        }
    }
}
