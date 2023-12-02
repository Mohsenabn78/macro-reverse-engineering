package com.google.firestore.v1;

import com.google.firestore.v1.StructuredQuery;
import com.google.protobuf.Int32Value;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes5.dex */
public interface StructuredQueryOrBuilder extends MessageLiteOrBuilder {
    Cursor getEndAt();

    StructuredQuery.CollectionSelector getFrom(int i4);

    int getFromCount();

    List<StructuredQuery.CollectionSelector> getFromList();

    Int32Value getLimit();

    int getOffset();

    StructuredQuery.Order getOrderBy(int i4);

    int getOrderByCount();

    List<StructuredQuery.Order> getOrderByList();

    StructuredQuery.Projection getSelect();

    Cursor getStartAt();

    StructuredQuery.Filter getWhere();

    boolean hasEndAt();

    boolean hasLimit();

    boolean hasSelect();

    boolean hasStartAt();

    boolean hasWhere();
}
