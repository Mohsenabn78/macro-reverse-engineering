package com.android.dx.util;

import com.android.dex.util.ByteOutput;

/* loaded from: classes2.dex */
public interface Output extends ByteOutput {
    void alignTo(int i4);

    void assertCursor(int i4);

    int getCursor();

    void write(ByteArray byteArray);

    void write(byte[] bArr);

    void write(byte[] bArr, int i4, int i5);

    @Override // com.android.dex.util.ByteOutput
    void writeByte(int i4);

    void writeInt(int i4);

    void writeLong(long j4);

    void writeShort(int i4);

    int writeSleb128(int i4);

    int writeUleb128(int i4);

    void writeZeroes(int i4);
}
