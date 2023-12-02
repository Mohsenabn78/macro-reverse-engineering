package com.google.firestore.v1;

import com.google.firestore.v1.DocumentTransform;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes5.dex */
public interface DocumentTransformOrBuilder extends MessageLiteOrBuilder {
    String getDocument();

    ByteString getDocumentBytes();

    DocumentTransform.FieldTransform getFieldTransforms(int i4);

    int getFieldTransformsCount();

    List<DocumentTransform.FieldTransform> getFieldTransformsList();
}
