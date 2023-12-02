package com.google.firestore.v1;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* loaded from: classes5.dex */
public interface AggregationResultOrBuilder extends MessageLiteOrBuilder {
    boolean containsAggregateFields(String str);

    @Deprecated
    Map<String, Value> getAggregateFields();

    int getAggregateFieldsCount();

    Map<String, Value> getAggregateFieldsMap();

    Value getAggregateFieldsOrDefault(String str, Value value);

    Value getAggregateFieldsOrThrow(String str);
}
