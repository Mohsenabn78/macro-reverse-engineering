package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
abstract class AbstractCompositeHashFunction extends AbstractHashFunction {

    /* renamed from: a  reason: collision with root package name */
    final HashFunction[] f27809a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractCompositeHashFunction(HashFunction... hashFunctionArr) {
        for (HashFunction hashFunction : hashFunctionArr) {
            Preconditions.checkNotNull(hashFunction);
        }
        this.f27809a = hashFunctionArr;
    }

    private Hasher a(final Hasher[] hasherArr) {
        return new Hasher() { // from class: com.google.common.hash.AbstractCompositeHashFunction.1
            @Override // com.google.common.hash.Hasher
            public HashCode hash() {
                return AbstractCompositeHashFunction.this.b(hasherArr);
            }

            @Override // com.google.common.hash.Hasher
            public <T> Hasher putObject(@ParametricNullness T t3, Funnel<? super T> funnel) {
                for (Hasher hasher : hasherArr) {
                    hasher.putObject(t3, funnel);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putBoolean(boolean z3) {
                for (Hasher hasher : hasherArr) {
                    hasher.putBoolean(z3);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putByte(byte b4) {
                for (Hasher hasher : hasherArr) {
                    hasher.putByte(b4);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putChar(char c4) {
                for (Hasher hasher : hasherArr) {
                    hasher.putChar(c4);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putDouble(double d4) {
                for (Hasher hasher : hasherArr) {
                    hasher.putDouble(d4);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putFloat(float f4) {
                for (Hasher hasher : hasherArr) {
                    hasher.putFloat(f4);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putInt(int i4) {
                for (Hasher hasher : hasherArr) {
                    hasher.putInt(i4);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putLong(long j4) {
                for (Hasher hasher : hasherArr) {
                    hasher.putLong(j4);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putShort(short s3) {
                for (Hasher hasher : hasherArr) {
                    hasher.putShort(s3);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putString(CharSequence charSequence, Charset charset) {
                for (Hasher hasher : hasherArr) {
                    hasher.putString(charSequence, charset);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putUnencodedChars(CharSequence charSequence) {
                for (Hasher hasher : hasherArr) {
                    hasher.putUnencodedChars(charSequence);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putBytes(byte[] bArr) {
                for (Hasher hasher : hasherArr) {
                    hasher.putBytes(bArr);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putBytes(byte[] bArr, int i4, int i5) {
                for (Hasher hasher : hasherArr) {
                    hasher.putBytes(bArr, i4, i5);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher putBytes(ByteBuffer byteBuffer) {
                Hasher[] hasherArr2;
                int position = byteBuffer.position();
                for (Hasher hasher : hasherArr) {
                    Java8Compatibility.d(byteBuffer, position);
                    hasher.putBytes(byteBuffer);
                }
                return this;
            }
        };
    }

    abstract HashCode b(Hasher[] hasherArr);

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        int length = this.f27809a.length;
        Hasher[] hasherArr = new Hasher[length];
        for (int i4 = 0; i4 < length; i4++) {
            hasherArr[i4] = this.f27809a[i4].newHasher();
        }
        return a(hasherArr);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public Hasher newHasher(int i4) {
        Preconditions.checkArgument(i4 >= 0);
        int length = this.f27809a.length;
        Hasher[] hasherArr = new Hasher[length];
        for (int i5 = 0; i5 < length; i5++) {
            hasherArr[i5] = this.f27809a[i5].newHasher(i4);
        }
        return a(hasherArr);
    }
}
