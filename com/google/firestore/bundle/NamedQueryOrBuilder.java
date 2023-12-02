package com.google.firestore.bundle;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;

/* loaded from: classes5.dex */
public interface NamedQueryOrBuilder extends MessageLiteOrBuilder {
    BundledQuery getBundledQuery();

    String getName();

    ByteString getNameBytes();

    Timestamp getReadTime();

    boolean hasBundledQuery();

    boolean hasReadTime();
}
