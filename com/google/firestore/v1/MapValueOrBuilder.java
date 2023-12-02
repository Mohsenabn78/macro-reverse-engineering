package com.google.firestore.v1;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* loaded from: classes5.dex */
public interface MapValueOrBuilder extends MessageLiteOrBuilder {
    boolean containsFields(String str);

    @Deprecated
    Map<String, Value> getFields();

    int getFieldsCount();

    Map<String, Value> getFieldsMap();

    Value getFieldsOrDefault(String str, Value value);

    Value getFieldsOrThrow(String str);
}
