package com.google.firestore.v1;

import com.google.firestore.v1.ListenResponse;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes5.dex */
public interface ListenResponseOrBuilder extends MessageLiteOrBuilder {
    DocumentChange getDocumentChange();

    DocumentDelete getDocumentDelete();

    DocumentRemove getDocumentRemove();

    ExistenceFilter getFilter();

    ListenResponse.ResponseTypeCase getResponseTypeCase();

    TargetChange getTargetChange();

    boolean hasDocumentChange();

    boolean hasDocumentDelete();

    boolean hasDocumentRemove();

    boolean hasFilter();

    boolean hasTargetChange();
}
