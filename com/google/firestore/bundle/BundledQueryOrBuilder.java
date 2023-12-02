package com.google.firestore.bundle;

import com.google.firestore.bundle.BundledQuery;
import com.google.firestore.v1.StructuredQuery;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes5.dex */
public interface BundledQueryOrBuilder extends MessageLiteOrBuilder {
    BundledQuery.LimitType getLimitType();

    int getLimitTypeValue();

    String getParent();

    ByteString getParentBytes();

    BundledQuery.QueryTypeCase getQueryTypeCase();

    StructuredQuery getStructuredQuery();

    boolean hasStructuredQuery();
}
