package com.google.common.hash;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import javax.annotation.CheckForNull;
import javax.mail.UIDFolder;

/* JADX INFO: Access modifiers changed from: package-private */
@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Murmur3_32HashFunction extends AbstractHashFunction implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    static final HashFunction f27881a = new Murmur3_32HashFunction(0, false);

    /* renamed from: b  reason: collision with root package name */
    static final HashFunction f27882b = new Murmur3_32HashFunction(0, true);

    /* renamed from: e  reason: collision with root package name */
    static final HashFunction f27883e = new Murmur3_32HashFunction(Hashing.f27845a, true);
    private static final long serialVersionUID = 0;
    private final int seed;
    private final boolean supplementaryPlaneFix;

    /* loaded from: classes5.dex */
    private static final class Murmur3_32Hasher extends AbstractHasher {

        /* renamed from: a  reason: collision with root package name */
        private int f27884a;

        /* renamed from: b  reason: collision with root package name */
        private long f27885b;

        /* renamed from: c  reason: collision with root package name */
        private int f27886c;

        /* renamed from: d  reason: collision with root package name */
        private int f27887d = 0;

        /* renamed from: e  reason: collision with root package name */
        private boolean f27888e = false;

        Murmur3_32Hasher(int i4) {
            this.f27884a = i4;
        }

        private void a(int i4, long j4) {
            long j5 = this.f27885b;
            long j6 = j4 & UIDFolder.MAXUID;
            int i5 = this.f27886c;
            long j7 = (j6 << i5) | j5;
            this.f27885b = j7;
            int i6 = i5 + (i4 * 8);
            this.f27886c = i6;
            this.f27887d += i4;
            if (i6 >= 32) {
                this.f27884a = Murmur3_32HashFunction.o(this.f27884a, Murmur3_32HashFunction.p((int) j7));
                this.f27885b >>>= 32;
                this.f27886c -= 32;
            }
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            Preconditions.checkState(!this.f27888e);
            this.f27888e = true;
            int p4 = this.f27884a ^ Murmur3_32HashFunction.p((int) this.f27885b);
            this.f27884a = p4;
            return Murmur3_32HashFunction.m(p4, this.f27887d);
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        @CanIgnoreReturnValue
        public Hasher putByte(byte b4) {
            a(1, b4 & 255);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        @CanIgnoreReturnValue
        public Hasher putChar(char c4) {
            a(2, c4);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        @CanIgnoreReturnValue
        public Hasher putInt(int i4) {
            a(4, i4);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        @CanIgnoreReturnValue
        public Hasher putLong(long j4) {
            a(4, (int) j4);
            a(4, j4 >>> 32);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        @CanIgnoreReturnValue
        public Hasher putString(CharSequence charSequence, Charset charset) {
            if (Charsets.UTF_8.equals(charset)) {
                int length = charSequence.length();
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 4;
                    if (i5 > length) {
                        break;
                    }
                    char charAt = charSequence.charAt(i4);
                    char charAt2 = charSequence.charAt(i4 + 1);
                    char charAt3 = charSequence.charAt(i4 + 2);
                    char charAt4 = charSequence.charAt(i4 + 3);
                    if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                        break;
                    }
                    a(4, (charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24));
                    i4 = i5;
                }
                while (i4 < length) {
                    char charAt5 = charSequence.charAt(i4);
                    if (charAt5 < 128) {
                        a(1, charAt5);
                    } else if (charAt5 < 2048) {
                        a(2, Murmur3_32HashFunction.j(charAt5));
                    } else if (charAt5 < 55296 || charAt5 > 57343) {
                        a(3, Murmur3_32HashFunction.i(charAt5));
                    } else {
                        int codePointAt = Character.codePointAt(charSequence, i4);
                        if (codePointAt != charAt5) {
                            i4++;
                            a(4, Murmur3_32HashFunction.l(codePointAt));
                        } else {
                            putBytes(charSequence.subSequence(i4, length).toString().getBytes(charset));
                            return this;
                        }
                    }
                    i4++;
                }
                return this;
            }
            return super.putString(charSequence, charset);
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        @CanIgnoreReturnValue
        public Hasher putBytes(byte[] bArr, int i4, int i5) {
            Preconditions.checkPositionIndexes(i4, i4 + i5, bArr.length);
            int i6 = 0;
            while (true) {
                int i7 = i6 + 4;
                if (i7 > i5) {
                    break;
                }
                a(4, Murmur3_32HashFunction.n(bArr, i6 + i4));
                i6 = i7;
            }
            while (i6 < i5) {
                putByte(bArr[i4 + i6]);
                i6++;
            }
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        @CanIgnoreReturnValue
        public Hasher putBytes(ByteBuffer byteBuffer) {
            ByteOrder order = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            while (byteBuffer.remaining() >= 4) {
                putInt(byteBuffer.getInt());
            }
            while (byteBuffer.hasRemaining()) {
                putByte(byteBuffer.get());
            }
            byteBuffer.order(order);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Murmur3_32HashFunction(int i4, boolean z3) {
        this.seed = i4;
        this.supplementaryPlaneFix = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long i(char c4) {
        return (c4 >>> '\f') | 224 | ((((c4 >>> 6) & 63) | 128) << 8) | (((c4 & '?') | 128) << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long j(char c4) {
        return (c4 >>> 6) | 192 | (((c4 & '?') | 128) << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long l(int i4) {
        return (i4 >>> 18) | 240 | ((((i4 >>> 12) & 63) | 128) << 8) | ((((i4 >>> 6) & 63) | 128) << 16) | (((i4 & 63) | 128) << 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashCode m(int i4, int i5) {
        int i6 = i4 ^ i5;
        int i7 = (i6 ^ (i6 >>> 16)) * (-2048144789);
        int i8 = (i7 ^ (i7 >>> 13)) * (-1028477387);
        return HashCode.fromInt(i8 ^ (i8 >>> 16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int n(byte[] bArr, int i4) {
        return Ints.fromBytes(bArr[i4 + 3], bArr[i4 + 2], bArr[i4 + 1], bArr[i4]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int o(int i4, int i5) {
        return (Integer.rotateLeft(i4 ^ i5, 13) * 5) - 430675100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int p(int i4) {
        return Integer.rotateLeft(i4 * (-862048943), 15) * 461845907;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 32;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Murmur3_32HashFunction)) {
            return false;
        }
        Murmur3_32HashFunction murmur3_32HashFunction = (Murmur3_32HashFunction) obj;
        if (this.seed != murmur3_32HashFunction.seed || this.supplementaryPlaneFix != murmur3_32HashFunction.supplementaryPlaneFix) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i4, int i5) {
        Preconditions.checkPositionIndexes(i4, i4 + i5, bArr.length);
        int i6 = this.seed;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = i8 + 4;
            if (i9 > i5) {
                break;
            }
            i6 = o(i6, p(n(bArr, i8 + i4)));
            i8 = i9;
        }
        int i10 = i8;
        int i11 = 0;
        while (i10 < i5) {
            i7 ^= UnsignedBytes.toInt(bArr[i4 + i10]) << i11;
            i10++;
            i11 += 8;
        }
        return m(p(i7) ^ i6, i5);
    }

    public int hashCode() {
        return Murmur3_32HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashInt(int i4) {
        return m(o(this.seed, p(i4)), 4);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashLong(long j4) {
        int i4 = (int) (j4 >>> 32);
        return m(o(o(this.seed, p((int) j4)), p(i4)), 8);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        if (Charsets.UTF_8.equals(charset)) {
            int length = charSequence.length();
            int i4 = this.seed;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                int i8 = i6 + 4;
                if (i8 > length) {
                    break;
                }
                char charAt = charSequence.charAt(i6);
                char charAt2 = charSequence.charAt(i6 + 1);
                char charAt3 = charSequence.charAt(i6 + 2);
                char charAt4 = charSequence.charAt(i6 + 3);
                if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                    break;
                }
                i4 = o(i4, p((charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24)));
                i7 += 4;
                i6 = i8;
            }
            long j4 = 0;
            while (i6 < length) {
                char charAt5 = charSequence.charAt(i6);
                if (charAt5 < 128) {
                    j4 |= charAt5 << i5;
                    i5 += 8;
                    i7++;
                } else if (charAt5 < 2048) {
                    j4 |= j(charAt5) << i5;
                    i5 += 16;
                    i7 += 2;
                } else if (charAt5 >= 55296 && charAt5 <= 57343) {
                    int codePointAt = Character.codePointAt(charSequence, i6);
                    if (codePointAt == charAt5) {
                        return hashBytes(charSequence.toString().getBytes(charset));
                    }
                    i6++;
                    j4 |= l(codePointAt) << i5;
                    if (this.supplementaryPlaneFix) {
                        i5 += 32;
                    }
                    i7 += 4;
                } else {
                    j4 |= i(charAt5) << i5;
                    i5 += 24;
                    i7 += 3;
                }
                if (i5 >= 32) {
                    i4 = o(i4, p((int) j4));
                    j4 >>>= 32;
                    i5 -= 32;
                }
                i6++;
            }
            return m(p((int) j4) ^ i4, i7);
        }
        return hashBytes(charSequence.toString().getBytes(charset));
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int i4 = this.seed;
        for (int i5 = 1; i5 < charSequence.length(); i5 += 2) {
            i4 = o(i4, p(charSequence.charAt(i5 - 1) | (charSequence.charAt(i5) << 16)));
        }
        if ((charSequence.length() & 1) == 1) {
            i4 ^= p(charSequence.charAt(charSequence.length() - 1));
        }
        return m(i4, charSequence.length() * 2);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new Murmur3_32Hasher(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_32(" + this.seed + ")";
    }
}
