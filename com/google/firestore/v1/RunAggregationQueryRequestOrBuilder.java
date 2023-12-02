package com.google.firestore.v1;

import com.google.firestore.v1.RunAggregationQueryRequest;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;

/* loaded from: classes5.dex */
public interface RunAggregationQueryRequestOrBuilder extends MessageLiteOrBuilder {
    RunAggregationQueryRequest.ConsistencySelectorCase getConsistencySelectorCase();

    TransactionOptions getNewTransaction();

    String getParent();

    ByteString getParentBytes();

    RunAggregationQueryRequest.QueryTypeCase getQueryTypeCase();

    Timestamp getReadTime();

    StructuredAggregationQuery getStructuredAggregationQuery();

    ByteString getTransaction();

    boolean hasNewTransaction();

    boolean hasReadTime();

    boolean hasStructuredAggregationQuery();

    boolean hasTransaction();
}
