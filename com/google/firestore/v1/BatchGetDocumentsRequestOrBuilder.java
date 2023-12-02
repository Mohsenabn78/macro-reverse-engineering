package com.google.firestore.v1;

import com.google.firestore.v1.BatchGetDocumentsRequest;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;
import java.util.List;

/* loaded from: classes5.dex */
public interface BatchGetDocumentsRequestOrBuilder extends MessageLiteOrBuilder {
    BatchGetDocumentsRequest.ConsistencySelectorCase getConsistencySelectorCase();

    String getDatabase();

    ByteString getDatabaseBytes();

    String getDocuments(int i4);

    ByteString getDocumentsBytes(int i4);

    int getDocumentsCount();

    List<String> getDocumentsList();

    DocumentMask getMask();

    TransactionOptions getNewTransaction();

    Timestamp getReadTime();

    ByteString getTransaction();

    boolean hasMask();

    boolean hasNewTransaction();

    boolean hasReadTime();

    boolean hasTransaction();
}
