package com.google.protobuf;

import com.google.protobuf.ArrayDecoders;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes6.dex */
public interface Schema<T> {
    void a(T t3, Writer writer) throws IOException;

    void b(T t3, byte[] bArr, int i4, int i5, ArrayDecoders.Registers registers) throws IOException;

    void c(T t3, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    boolean equals(T t3, T t4);

    int getSerializedSize(T t3);

    int hashCode(T t3);

    boolean isInitialized(T t3);

    void makeImmutable(T t3);

    void mergeFrom(T t3, T t4);

    T newInstance();
}
