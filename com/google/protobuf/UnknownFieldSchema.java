package com.google.protobuf;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes6.dex */
public abstract class UnknownFieldSchema<T, B> {
    abstract void a(B b4, int i4, int i5);

    abstract void b(B b4, int i4, long j4);

    abstract void c(B b4, int i4, T t3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d(B b4, int i4, ByteString byteString);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e(B b4, int i4, long j4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B f(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T g(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int h(T t3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int i(T t3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void j(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T k(T t3, T t4);

    final void l(B b4, Reader reader) throws IOException {
        while (reader.getFieldNumber() != Integer.MAX_VALUE && m(b4, reader)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean m(B b4, Reader reader) throws IOException {
        int tag = reader.getTag();
        int tagFieldNumber = WireFormat.getTagFieldNumber(tag);
        int tagWireType = WireFormat.getTagWireType(tag);
        if (tagWireType != 0) {
            if (tagWireType != 1) {
                if (tagWireType != 2) {
                    if (tagWireType != 3) {
                        if (tagWireType != 4) {
                            if (tagWireType == 5) {
                                a(b4, tagFieldNumber, reader.readFixed32());
                                return true;
                            }
                            throw InvalidProtocolBufferException.f();
                        }
                        return false;
                    }
                    B n4 = n();
                    int a4 = WireFormat.a(tagFieldNumber, 4);
                    l(n4, reader);
                    if (a4 == reader.getTag()) {
                        c(b4, tagFieldNumber, r(n4));
                        return true;
                    }
                    throw InvalidProtocolBufferException.b();
                }
                d(b4, tagFieldNumber, reader.readBytes());
                return true;
            }
            b(b4, tagFieldNumber, reader.readFixed64());
            return true;
        }
        e(b4, tagFieldNumber, reader.readInt64());
        return true;
    }

    abstract B n();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o(Object obj, B b4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void p(Object obj, T t3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean q(Reader reader);

    abstract T r(B b4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void s(T t3, Writer writer) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void t(T t3, Writer writer) throws IOException;
}
