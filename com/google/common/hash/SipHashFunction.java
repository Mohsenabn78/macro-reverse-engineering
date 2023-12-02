package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import javax.annotation.CheckForNull;

@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class SipHashFunction extends AbstractHashFunction implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    static final HashFunction f27889a = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* renamed from: c  reason: collision with root package name */
    private final int f27890c;

    /* renamed from: d  reason: collision with root package name */
    private final int f27891d;

    /* renamed from: k0  reason: collision with root package name */
    private final long f27892k0;

    /* renamed from: k1  reason: collision with root package name */
    private final long f27893k1;

    /* loaded from: classes5.dex */
    private static final class SipHasher extends AbstractStreamingHasher {

        /* renamed from: d  reason: collision with root package name */
        private final int f27894d;

        /* renamed from: e  reason: collision with root package name */
        private final int f27895e;

        /* renamed from: f  reason: collision with root package name */
        private long f27896f;

        /* renamed from: g  reason: collision with root package name */
        private long f27897g;

        /* renamed from: h  reason: collision with root package name */
        private long f27898h;

        /* renamed from: i  reason: collision with root package name */
        private long f27899i;

        /* renamed from: j  reason: collision with root package name */
        private long f27900j;

        /* renamed from: k  reason: collision with root package name */
        private long f27901k;

        SipHasher(int i4, int i5, long j4, long j5) {
            super(8);
            this.f27900j = 0L;
            this.f27901k = 0L;
            this.f27894d = i4;
            this.f27895e = i5;
            this.f27896f = 8317987319222330741L ^ j4;
            this.f27897g = 7237128888997146477L ^ j5;
            this.f27898h = 7816392313619706465L ^ j4;
            this.f27899i = 8387220255154660723L ^ j5;
        }

        private void g(long j4) {
            this.f27899i ^= j4;
            h(this.f27894d);
            this.f27896f = j4 ^ this.f27896f;
        }

        private void h(int i4) {
            for (int i5 = 0; i5 < i4; i5++) {
                long j4 = this.f27896f;
                long j5 = this.f27897g;
                this.f27896f = j4 + j5;
                this.f27898h += this.f27899i;
                this.f27897g = Long.rotateLeft(j5, 13);
                long rotateLeft = Long.rotateLeft(this.f27899i, 16);
                long j6 = this.f27897g;
                long j7 = this.f27896f;
                this.f27897g = j6 ^ j7;
                this.f27899i = rotateLeft ^ this.f27898h;
                long rotateLeft2 = Long.rotateLeft(j7, 32);
                long j8 = this.f27898h;
                long j9 = this.f27897g;
                this.f27898h = j8 + j9;
                this.f27896f = rotateLeft2 + this.f27899i;
                this.f27897g = Long.rotateLeft(j9, 17);
                long rotateLeft3 = Long.rotateLeft(this.f27899i, 21);
                long j10 = this.f27897g;
                long j11 = this.f27898h;
                this.f27897g = j10 ^ j11;
                this.f27899i = rotateLeft3 ^ this.f27896f;
                this.f27898h = Long.rotateLeft(j11, 32);
            }
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected HashCode a() {
            long j4 = this.f27901k ^ (this.f27900j << 56);
            this.f27901k = j4;
            g(j4);
            this.f27898h ^= 255;
            h(this.f27895e);
            return HashCode.fromLong(((this.f27896f ^ this.f27897g) ^ this.f27898h) ^ this.f27899i);
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void d(ByteBuffer byteBuffer) {
            this.f27900j += 8;
            g(byteBuffer.getLong());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void e(ByteBuffer byteBuffer) {
            this.f27900j += byteBuffer.remaining();
            int i4 = 0;
            while (byteBuffer.hasRemaining()) {
                this.f27901k ^= (byteBuffer.get() & 255) << i4;
                i4 += 8;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SipHashFunction(int i4, int i5, long j4, long j5) {
        boolean z3;
        if (i4 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "The number of SipRound iterations (c=%s) during Compression must be positive.", i4);
        Preconditions.checkArgument(i5 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i5);
        this.f27890c = i4;
        this.f27891d = i5;
        this.f27892k0 = j4;
        this.f27893k1 = j5;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof SipHashFunction)) {
            return false;
        }
        SipHashFunction sipHashFunction = (SipHashFunction) obj;
        if (this.f27890c != sipHashFunction.f27890c || this.f27891d != sipHashFunction.f27891d || this.f27892k0 != sipHashFunction.f27892k0 || this.f27893k1 != sipHashFunction.f27893k1) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (int) ((((SipHashFunction.class.hashCode() ^ this.f27890c) ^ this.f27891d) ^ this.f27892k0) ^ this.f27893k1);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new SipHasher(this.f27890c, this.f27891d, this.f27892k0, this.f27893k1);
    }

    public String toString() {
        return "Hashing.sipHash" + this.f27890c + "" + this.f27891d + "(" + this.f27892k0 + ", " + this.f27893k1 + ")";
    }
}
