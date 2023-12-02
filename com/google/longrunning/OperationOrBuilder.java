package com.google.longrunning;

import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.rpc.Status;

/* loaded from: classes5.dex */
public interface OperationOrBuilder extends MessageLiteOrBuilder {
    boolean getDone();

    Status getError();

    Any getMetadata();

    String getName();

    ByteString getNameBytes();

    Any getResponse();

    Operation.ResultCase getResultCase();

    boolean hasError();

    boolean hasMetadata();

    boolean hasResponse();
}
