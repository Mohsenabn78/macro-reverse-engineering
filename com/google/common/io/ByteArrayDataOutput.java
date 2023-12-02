package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.DataOutput;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
public interface ByteArrayDataOutput extends DataOutput {
    byte[] toByteArray();

    @Override // java.io.DataOutput
    void write(int i4);

    @Override // java.io.DataOutput
    void write(byte[] bArr);

    @Override // java.io.DataOutput
    void write(byte[] bArr, int i4, int i5);

    @Override // java.io.DataOutput
    void writeBoolean(boolean z3);

    @Override // java.io.DataOutput
    void writeByte(int i4);

    @Override // java.io.DataOutput
    @Deprecated
    void writeBytes(String str);

    @Override // java.io.DataOutput
    void writeChar(int i4);

    @Override // java.io.DataOutput
    void writeChars(String str);

    @Override // java.io.DataOutput
    void writeDouble(double d4);

    @Override // java.io.DataOutput
    void writeFloat(float f4);

    @Override // java.io.DataOutput
    void writeInt(int i4);

    @Override // java.io.DataOutput
    void writeLong(long j4);

    @Override // java.io.DataOutput
    void writeShort(int i4);

    @Override // java.io.DataOutput
    void writeUTF(String str);
}
