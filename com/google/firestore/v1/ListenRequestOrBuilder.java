package com.google.firestore.v1;

import com.google.firestore.v1.ListenRequest;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* loaded from: classes5.dex */
public interface ListenRequestOrBuilder extends MessageLiteOrBuilder {
    boolean containsLabels(String str);

    Target getAddTarget();

    String getDatabase();

    ByteString getDatabaseBytes();

    @Deprecated
    Map<String, String> getLabels();

    int getLabelsCount();

    Map<String, String> getLabelsMap();

    String getLabelsOrDefault(String str, String str2);

    String getLabelsOrThrow(String str);

    int getRemoveTarget();

    ListenRequest.TargetChangeCase getTargetChangeCase();

    boolean hasAddTarget();

    boolean hasRemoveTarget();
}
