package com.android.dx.io.instructions;

import java.io.EOFException;

/* loaded from: classes2.dex */
public interface CodeInput extends CodeCursor {
    boolean hasMore();

    int read() throws EOFException;

    int readInt() throws EOFException;

    long readLong() throws EOFException;
}
