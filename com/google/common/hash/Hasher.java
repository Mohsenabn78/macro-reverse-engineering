package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public interface Hasher extends PrimitiveSink {
    HashCode hash();

    @Deprecated
    int hashCode();

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putBoolean(boolean z3);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putBoolean(boolean z3);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putByte(byte b4);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putByte(byte b4);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putBytes(ByteBuffer byteBuffer);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putBytes(byte[] bArr);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putBytes(byte[] bArr, int i4, int i5);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putBytes(ByteBuffer byteBuffer);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] bArr);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] bArr, int i4, int i5);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putChar(char c4);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putChar(char c4);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putDouble(double d4);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putDouble(double d4);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putFloat(float f4);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putFloat(float f4);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putInt(int i4);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putInt(int i4);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putLong(long j4);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putLong(long j4);

    @CanIgnoreReturnValue
    <T> Hasher putObject(@ParametricNullness T t3, Funnel<? super T> funnel);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putShort(short s3);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putShort(short s3);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putString(CharSequence charSequence, Charset charset);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putString(CharSequence charSequence, Charset charset);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putUnencodedChars(CharSequence charSequence);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putUnencodedChars(CharSequence charSequence);
}
