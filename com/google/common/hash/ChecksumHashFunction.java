package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.zip.Checksum;

/* JADX INFO: Access modifiers changed from: package-private */
@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class ChecksumHashFunction extends AbstractHashFunction implements Serializable {
    private static final long serialVersionUID = 0;
    private final int bits;
    private final ImmutableSupplier<? extends Checksum> checksumSupplier;
    private final String toString;

    /* loaded from: classes5.dex */
    private final class ChecksumHasher extends AbstractByteHasher {

        /* renamed from: b  reason: collision with root package name */
        private final Checksum f27822b;

        @Override // com.google.common.hash.AbstractByteHasher
        protected void b(byte b4) {
            this.f27822b.update(b4);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void e(byte[] bArr, int i4, int i5) {
            this.f27822b.update(bArr, i4, i5);
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            long value = this.f27822b.getValue();
            if (ChecksumHashFunction.this.bits == 32) {
                return HashCode.fromInt((int) value);
            }
            return HashCode.fromLong(value);
        }

        private ChecksumHasher(Checksum checksum) {
            this.f27822b = (Checksum) Preconditions.checkNotNull(checksum);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChecksumHashFunction(ImmutableSupplier<? extends Checksum> immutableSupplier, int i4, String str) {
        boolean z3;
        this.checksumSupplier = (ImmutableSupplier) Preconditions.checkNotNull(immutableSupplier);
        if (i4 != 32 && i4 != 64) {
            z3 = false;
        } else {
            z3 = true;
        }
        Preconditions.checkArgument(z3, "bits (%s) must be either 32 or 64", i4);
        this.bits = i4;
        this.toString = (String) Preconditions.checkNotNull(str);
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.bits;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new ChecksumHasher(this.checksumSupplier.get());
    }

    public String toString() {
        return this.toString;
    }
}
