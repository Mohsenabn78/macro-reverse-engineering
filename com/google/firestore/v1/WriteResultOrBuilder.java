package com.google.firestore.v1;

import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;
import java.util.List;

/* loaded from: classes5.dex */
public interface WriteResultOrBuilder extends MessageLiteOrBuilder {
    Value getTransformResults(int i4);

    int getTransformResultsCount();

    List<Value> getTransformResultsList();

    Timestamp getUpdateTime();

    boolean hasUpdateTime();
}
