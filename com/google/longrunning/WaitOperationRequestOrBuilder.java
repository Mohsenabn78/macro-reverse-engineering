package com.google.longrunning;

import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes5.dex */
public interface WaitOperationRequestOrBuilder extends MessageLiteOrBuilder {
    String getName();

    ByteString getNameBytes();

    Duration getTimeout();

    boolean hasTimeout();
}
