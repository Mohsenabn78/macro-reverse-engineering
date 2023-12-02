package com.google.firebase.firestore.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;

/* loaded from: classes5.dex */
public interface TargetGlobalOrBuilder extends MessageLiteOrBuilder {
    long getHighestListenSequenceNumber();

    int getHighestTargetId();

    Timestamp getLastRemoteSnapshotVersion();

    int getTargetCount();

    boolean hasLastRemoteSnapshotVersion();
}
