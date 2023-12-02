package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes6.dex */
public interface DebugInfoOrBuilder extends MessageLiteOrBuilder {
    String getDetail();

    ByteString getDetailBytes();

    String getStackEntries(int i4);

    ByteString getStackEntriesBytes(int i4);

    int getStackEntriesCount();

    List<String> getStackEntriesList();
}
