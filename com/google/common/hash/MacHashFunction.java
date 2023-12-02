package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class MacHashFunction extends AbstractHashFunction {

    /* renamed from: a  reason: collision with root package name */
    private final Mac f27866a;

    /* renamed from: b  reason: collision with root package name */
    private final Key f27867b;

    /* renamed from: e  reason: collision with root package name */
    private final String f27868e;

    /* renamed from: f  reason: collision with root package name */
    private final int f27869f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f27870g;

    /* loaded from: classes5.dex */
    private static final class MacHasher extends AbstractByteHasher {

        /* renamed from: b  reason: collision with root package name */
        private final Mac f27871b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f27872c;

        private void f() {
            Preconditions.checkState(!this.f27872c, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void b(byte b4) {
            f();
            this.f27871b.update(b4);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void c(ByteBuffer byteBuffer) {
            f();
            Preconditions.checkNotNull(byteBuffer);
            this.f27871b.update(byteBuffer);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void d(byte[] bArr) {
            f();
            this.f27871b.update(bArr);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void e(byte[] bArr, int i4, int i5) {
            f();
            this.f27871b.update(bArr, i4, i5);
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            f();
            this.f27872c = true;
            return HashCode.c(this.f27871b.doFinal());
        }

        private MacHasher(Mac mac) {
            this.f27871b = mac;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MacHashFunction(String str, Key key, String str2) {
        Mac a4 = a(str, key);
        this.f27866a = a4;
        this.f27867b = (Key) Preconditions.checkNotNull(key);
        this.f27868e = (String) Preconditions.checkNotNull(str2);
        this.f27869f = a4.getMacLength() * 8;
        this.f27870g = b(a4);
    }

    private static Mac a(String str, Key key) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(key);
            return mac;
        } catch (InvalidKeyException e4) {
            throw new IllegalArgumentException(e4);
        } catch (NoSuchAlgorithmException e5) {
            throw new IllegalStateException(e5);
        }
    }

    private static boolean b(Mac mac) {
        try {
            mac.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.f27869f;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        if (this.f27870g) {
            try {
                return new MacHasher((Mac) this.f27866a.clone());
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new MacHasher(a(this.f27866a.getAlgorithm(), this.f27867b));
    }

    public String toString() {
        return this.f27868e;
    }
}
