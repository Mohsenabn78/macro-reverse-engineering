package com.google.firebase.firestore.index;

import com.google.protobuf.ByteString;

/* loaded from: classes5.dex */
public abstract class DirectionalIndexByteEncoder {
    public abstract void writeBytes(ByteString byteString);

    public abstract void writeDouble(double d4);

    public abstract void writeInfinity();

    public abstract void writeLong(long j4);

    public abstract void writeString(String str);
}
