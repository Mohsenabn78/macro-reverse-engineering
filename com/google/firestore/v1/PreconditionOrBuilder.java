package com.google.firestore.v1;

import com.google.firestore.v1.Precondition;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;

/* loaded from: classes5.dex */
public interface PreconditionOrBuilder extends MessageLiteOrBuilder {
    Precondition.ConditionTypeCase getConditionTypeCase();

    boolean getExists();

    Timestamp getUpdateTime();

    boolean hasExists();

    boolean hasUpdateTime();
}
