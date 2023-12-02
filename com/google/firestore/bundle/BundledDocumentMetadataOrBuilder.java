package com.google.firestore.bundle;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;
import java.util.List;

/* loaded from: classes5.dex */
public interface BundledDocumentMetadataOrBuilder extends MessageLiteOrBuilder {
    boolean getExists();

    String getName();

    ByteString getNameBytes();

    String getQueries(int i4);

    ByteString getQueriesBytes(int i4);

    int getQueriesCount();

    List<String> getQueriesList();

    Timestamp getReadTime();

    boolean hasReadTime();
}
