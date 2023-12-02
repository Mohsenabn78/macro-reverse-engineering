package com.google.firestore.v1;

import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes5.dex */
public interface BloomFilterOrBuilder extends MessageLiteOrBuilder {
    BitSequence getBits();

    int getHashCount();

    boolean hasBits();
}
