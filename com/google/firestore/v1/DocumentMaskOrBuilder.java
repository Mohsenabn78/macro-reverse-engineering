package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes5.dex */
public interface DocumentMaskOrBuilder extends MessageLiteOrBuilder {
    String getFieldPaths(int i4);

    ByteString getFieldPathsBytes(int i4);

    int getFieldPathsCount();

    List<String> getFieldPathsList();
}
