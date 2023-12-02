package com.google.longrunning;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes5.dex */
public interface ListOperationsResponseOrBuilder extends MessageLiteOrBuilder {
    String getNextPageToken();

    ByteString getNextPageTokenBytes();

    Operation getOperations(int i4);

    int getOperationsCount();

    List<Operation> getOperationsList();
}
