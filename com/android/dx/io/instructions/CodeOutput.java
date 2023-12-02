package com.android.dx.io.instructions;

/* loaded from: classes2.dex */
public interface CodeOutput extends CodeCursor {
    void write(short s3);

    void write(short s3, short s4);

    void write(short s3, short s4, short s5);

    void write(short s3, short s4, short s5, short s6);

    void write(short s3, short s4, short s5, short s6, short s7);

    void write(byte[] bArr);

    void write(int[] iArr);

    void write(long[] jArr);

    void write(short[] sArr);

    void writeInt(int i4);

    void writeLong(long j4);
}
