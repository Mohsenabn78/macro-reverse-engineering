package com.android.dx.io.instructions;

import java.io.EOFException;
import kotlin.UShort;

/* loaded from: classes2.dex */
public final class ShortArrayCodeInput extends BaseCodeCursor implements CodeInput {
    private final short[] array;

    public ShortArrayCodeInput(short[] sArr) {
        if (sArr != null) {
            this.array = sArr;
            return;
        }
        throw new NullPointerException("array == null");
    }

    @Override // com.android.dx.io.instructions.CodeInput
    public boolean hasMore() {
        if (cursor() < this.array.length) {
            return true;
        }
        return false;
    }

    @Override // com.android.dx.io.instructions.CodeInput
    public int read() throws EOFException {
        try {
            short s3 = this.array[cursor()];
            advance(1);
            return s3 & UShort.MAX_VALUE;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new EOFException();
        }
    }

    @Override // com.android.dx.io.instructions.CodeInput
    public int readInt() throws EOFException {
        return read() | (read() << 16);
    }

    @Override // com.android.dx.io.instructions.CodeInput
    public long readLong() throws EOFException {
        return read() | (read() << 16) | (read() << 32) | (read() << 48);
    }
}
