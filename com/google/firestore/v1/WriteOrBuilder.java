package com.google.firestore.v1;

import com.google.firestore.v1.DocumentTransform;
import com.google.firestore.v1.Write;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes5.dex */
public interface WriteOrBuilder extends MessageLiteOrBuilder {
    Precondition getCurrentDocument();

    String getDelete();

    ByteString getDeleteBytes();

    Write.OperationCase getOperationCase();

    DocumentTransform getTransform();

    Document getUpdate();

    DocumentMask getUpdateMask();

    DocumentTransform.FieldTransform getUpdateTransforms(int i4);

    int getUpdateTransformsCount();

    List<DocumentTransform.FieldTransform> getUpdateTransformsList();

    String getVerify();

    ByteString getVerifyBytes();

    boolean hasCurrentDocument();

    boolean hasDelete();

    boolean hasTransform();

    boolean hasUpdate();

    boolean hasUpdateMask();

    boolean hasVerify();
}
