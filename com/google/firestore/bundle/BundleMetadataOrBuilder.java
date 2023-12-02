package com.google.firestore.bundle;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;

/* loaded from: classes5.dex */
public interface BundleMetadataOrBuilder extends MessageLiteOrBuilder {
    Timestamp getCreateTime();

    String getId();

    ByteString getIdBytes();

    long getTotalBytes();

    int getTotalDocuments();

    int getVersion();

    boolean hasCreateTime();
}
