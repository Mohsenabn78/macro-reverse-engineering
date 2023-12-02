package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public interface PrimitiveSink {
    @CanIgnoreReturnValue
    PrimitiveSink putBoolean(boolean z3);

    @CanIgnoreReturnValue
    PrimitiveSink putByte(byte b4);

    @CanIgnoreReturnValue
    PrimitiveSink putBytes(ByteBuffer byteBuffer);

    @CanIgnoreReturnValue
    PrimitiveSink putBytes(byte[] bArr);

    @CanIgnoreReturnValue
    PrimitiveSink putBytes(byte[] bArr, int i4, int i5);

    @CanIgnoreReturnValue
    PrimitiveSink putChar(char c4);

    @CanIgnoreReturnValue
    PrimitiveSink putDouble(double d4);

    @CanIgnoreReturnValue
    PrimitiveSink putFloat(float f4);

    @CanIgnoreReturnValue
    PrimitiveSink putInt(int i4);

    @CanIgnoreReturnValue
    PrimitiveSink putLong(long j4);

    @CanIgnoreReturnValue
    PrimitiveSink putShort(short s3);

    @CanIgnoreReturnValue
    PrimitiveSink putString(CharSequence charSequence, Charset charset);

    @CanIgnoreReturnValue
    PrimitiveSink putUnencodedChars(CharSequence charSequence);
}
