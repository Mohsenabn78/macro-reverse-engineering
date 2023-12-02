package com.google.protobuf;

import java.util.Collection;
import java.util.List;

/* loaded from: classes6.dex */
public interface LazyStringList extends ProtocolStringList {
    void add(ByteString byteString);

    void add(byte[] bArr);

    boolean addAllByteArray(Collection<byte[]> collection);

    boolean addAllByteString(Collection<? extends ByteString> collection);

    List<byte[]> asByteArrayList();

    byte[] getByteArray(int i4);

    ByteString getByteString(int i4);

    Object getRaw(int i4);

    List<?> getUnderlyingElements();

    LazyStringList getUnmodifiableView();

    void mergeFrom(LazyStringList lazyStringList);

    void set(int i4, ByteString byteString);

    void set(int i4, byte[] bArr);
}
