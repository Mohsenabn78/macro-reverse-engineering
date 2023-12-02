package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class MessageDigestHashFunction extends AbstractHashFunction implements Serializable {
    private final int bytes;
    private final MessageDigest prototype;
    private final boolean supportsClone;
    private final String toString;

    /* loaded from: classes5.dex */
    private static final class MessageDigestHasher extends AbstractByteHasher {

        /* renamed from: b  reason: collision with root package name */
        private final MessageDigest f27873b;

        /* renamed from: c  reason: collision with root package name */
        private final int f27874c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f27875d;

        private void f() {
            Preconditions.checkState(!this.f27875d, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void b(byte b4) {
            f();
            this.f27873b.update(b4);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void c(ByteBuffer byteBuffer) {
            f();
            this.f27873b.update(byteBuffer);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void e(byte[] bArr, int i4, int i5) {
            f();
            this.f27873b.update(bArr, i4, i5);
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            f();
            this.f27875d = true;
            if (this.f27874c == this.f27873b.getDigestLength()) {
                return HashCode.c(this.f27873b.digest());
            }
            return HashCode.c(Arrays.copyOf(this.f27873b.digest(), this.f27874c));
        }

        private MessageDigestHasher(MessageDigest messageDigest, int i4) {
            this.f27873b = messageDigest;
            this.f27874c = i4;
        }
    }

    /* loaded from: classes5.dex */
    private static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final String algorithmName;
        private final int bytes;
        private final String toString;

        private Object readResolve() {
            return new MessageDigestHashFunction(this.algorithmName, this.bytes, this.toString);
        }

        private SerializedForm(String str, int i4, String str2) {
            this.algorithmName = str;
            this.bytes = i4;
            this.toString = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageDigestHashFunction(String str, String str2) {
        MessageDigest a4 = a(str);
        this.prototype = a4;
        this.bytes = a4.getDigestLength();
        this.toString = (String) Preconditions.checkNotNull(str2);
        this.supportsClone = b(a4);
    }

    private static MessageDigest a(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e4) {
            throw new AssertionError(e4);
        }
    }

    private static boolean b(MessageDigest messageDigest) {
        try {
            messageDigest.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.bytes * 8;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        if (this.supportsClone) {
            try {
                return new MessageDigestHasher((MessageDigest) this.prototype.clone(), this.bytes);
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new MessageDigestHasher(a(this.prototype.getAlgorithm()), this.bytes);
    }

    public String toString() {
        return this.toString;
    }

    Object writeReplace() {
        return new SerializedForm(this.prototype.getAlgorithm(), this.bytes, this.toString);
    }

    MessageDigestHashFunction(String str, int i4, String str2) {
        this.toString = (String) Preconditions.checkNotNull(str2);
        MessageDigest a4 = a(str);
        this.prototype = a4;
        int digestLength = a4.getDigestLength();
        Preconditions.checkArgument(i4 >= 4 && i4 <= digestLength, "bytes (%s) must be >= 4 and < %s", i4, digestLength);
        this.bytes = i4;
        this.supportsClone = b(a4);
    }
}
