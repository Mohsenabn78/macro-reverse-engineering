package com.google.common.hash;

import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedInts;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class HashCode {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f27844a = "0123456789abcdef".toCharArray();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class BytesHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final byte[] bytes;

        BytesHashCode(byte[] bArr) {
            this.bytes = (byte[]) Preconditions.checkNotNull(bArr);
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            return (byte[]) this.bytes.clone();
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            boolean z3;
            byte[] bArr = this.bytes;
            if (bArr.length >= 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", bArr.length);
            byte[] bArr2 = this.bytes;
            return ((bArr2[3] & 255) << 24) | (bArr2[0] & 255) | ((bArr2[1] & 255) << 8) | ((bArr2[2] & 255) << 16);
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            boolean z3;
            byte[] bArr = this.bytes;
            if (bArr.length >= 8) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", bArr.length);
            return padToLong();
        }

        @Override // com.google.common.hash.HashCode
        boolean b(HashCode hashCode) {
            boolean z3;
            if (this.bytes.length != hashCode.e().length) {
                return false;
            }
            int i4 = 0;
            boolean z4 = true;
            while (true) {
                byte[] bArr = this.bytes;
                if (i4 < bArr.length) {
                    if (bArr[i4] == hashCode.e()[i4]) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z4 &= z3;
                    i4++;
                } else {
                    return z4;
                }
            }
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return this.bytes.length * 8;
        }

        @Override // com.google.common.hash.HashCode
        byte[] e() {
            return this.bytes;
        }

        @Override // com.google.common.hash.HashCode
        void f(byte[] bArr, int i4, int i5) {
            System.arraycopy(this.bytes, 0, bArr, i4, i5);
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            long j4 = this.bytes[0] & 255;
            for (int i4 = 1; i4 < Math.min(this.bytes.length, 8); i4++) {
                j4 |= (this.bytes[i4] & 255) << (i4 * 8);
            }
            return j4;
        }
    }

    /* loaded from: classes5.dex */
    private static final class IntHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final int hash;

        IntHashCode(int i4) {
            this.hash = i4;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            int i4 = this.hash;
            return new byte[]{(byte) i4, (byte) (i4 >> 8), (byte) (i4 >> 16), (byte) (i4 >> 24)};
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            return this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        }

        @Override // com.google.common.hash.HashCode
        boolean b(HashCode hashCode) {
            if (this.hash == hashCode.asInt()) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return 32;
        }

        @Override // com.google.common.hash.HashCode
        void f(byte[] bArr, int i4, int i5) {
            for (int i6 = 0; i6 < i5; i6++) {
                bArr[i4 + i6] = (byte) (this.hash >> (i6 * 8));
            }
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            return UnsignedInts.toLong(this.hash);
        }
    }

    /* loaded from: classes5.dex */
    private static final class LongHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final long hash;

        LongHashCode(long j4) {
            this.hash = j4;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            long j4 = this.hash;
            return new byte[]{(byte) j4, (byte) (j4 >> 8), (byte) (j4 >> 16), (byte) (j4 >> 24), (byte) (j4 >> 32), (byte) (j4 >> 40), (byte) (j4 >> 48), (byte) (j4 >> 56)};
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            return (int) this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            return this.hash;
        }

        @Override // com.google.common.hash.HashCode
        boolean b(HashCode hashCode) {
            if (this.hash == hashCode.asLong()) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return 64;
        }

        @Override // com.google.common.hash.HashCode
        void f(byte[] bArr, int i4, int i5) {
            for (int i6 = 0; i6 < i5; i6++) {
                bArr[i4 + i6] = (byte) (this.hash >> (i6 * 8));
            }
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            return this.hash;
        }
    }

    HashCode() {
    }

    private static int a(char c4) {
        if (c4 >= '0' && c4 <= '9') {
            return c4 - '0';
        }
        if (c4 >= 'a' && c4 <= 'f') {
            return (c4 - 'a') + 10;
        }
        throw new IllegalArgumentException("Illegal hexadecimal character: " + c4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HashCode c(byte[] bArr) {
        return new BytesHashCode(bArr);
    }

    public static HashCode fromBytes(byte[] bArr) {
        boolean z3 = true;
        if (bArr.length < 1) {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "A HashCode must contain at least 1 byte.");
        return c((byte[]) bArr.clone());
    }

    public static HashCode fromInt(int i4) {
        return new IntHashCode(i4);
    }

    public static HashCode fromLong(long j4) {
        return new LongHashCode(j4);
    }

    public static HashCode fromString(String str) {
        boolean z3;
        boolean z4 = true;
        if (str.length() >= 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "input string (%s) must have at least 2 characters", str);
        if (str.length() % 2 != 0) {
            z4 = false;
        }
        Preconditions.checkArgument(z4, "input string (%s) must have an even number of characters", str);
        byte[] bArr = new byte[str.length() / 2];
        for (int i4 = 0; i4 < str.length(); i4 += 2) {
            bArr[i4 / 2] = (byte) ((a(str.charAt(i4)) << 4) + a(str.charAt(i4 + 1)));
        }
        return c(bArr);
    }

    public abstract byte[] asBytes();

    public abstract int asInt();

    public abstract long asLong();

    abstract boolean b(HashCode hashCode);

    public abstract int bits();

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] e() {
        return asBytes();
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof HashCode)) {
            return false;
        }
        HashCode hashCode = (HashCode) obj;
        if (bits() != hashCode.bits() || !b(hashCode)) {
            return false;
        }
        return true;
    }

    abstract void f(byte[] bArr, int i4, int i5);

    public final int hashCode() {
        if (bits() >= 32) {
            return asInt();
        }
        byte[] e4 = e();
        int i4 = e4[0] & 255;
        for (int i5 = 1; i5 < e4.length; i5++) {
            i4 |= (e4[i5] & 255) << (i5 * 8);
        }
        return i4;
    }

    public abstract long padToLong();

    public final String toString() {
        byte[] e4 = e();
        StringBuilder sb = new StringBuilder(e4.length * 2);
        for (byte b4 : e4) {
            char[] cArr = f27844a;
            sb.append(cArr[(b4 >> 4) & 15]);
            sb.append(cArr[b4 & Ascii.SI]);
        }
        return sb.toString();
    }

    @CanIgnoreReturnValue
    public int writeBytesTo(byte[] bArr, int i4, int i5) {
        int min = Ints.min(i5, bits() / 8);
        Preconditions.checkPositionIndexes(i4, i4 + min, bArr.length);
        f(bArr, i4, min);
        return min;
    }
}
