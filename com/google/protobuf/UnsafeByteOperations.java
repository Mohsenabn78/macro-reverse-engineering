package com.google.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class UnsafeByteOperations {
    private UnsafeByteOperations() {
    }

    public static ByteString unsafeWrap(byte[] bArr) {
        return ByteString.v(bArr);
    }

    public static void unsafeWriteTo(ByteString byteString, ByteOutput byteOutput) throws IOException {
        byteString.x(byteOutput);
    }

    public static ByteString unsafeWrap(byte[] bArr, int i4, int i5) {
        return ByteString.w(bArr, i4, i5);
    }

    public static ByteString unsafeWrap(ByteBuffer byteBuffer) {
        return ByteString.u(byteBuffer);
    }
}
