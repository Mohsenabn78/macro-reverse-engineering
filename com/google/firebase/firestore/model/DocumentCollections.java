package com.google.firebase.firestore.model;

import com.google.firebase.database.collection.ImmutableSortedMap;

/* loaded from: classes5.dex */
public class DocumentCollections {

    /* renamed from: a  reason: collision with root package name */
    private static final ImmutableSortedMap<DocumentKey, ?> f30946a = ImmutableSortedMap.Builder.emptyMap(DocumentKey.comparator());

    public static ImmutableSortedMap<DocumentKey, Document> emptyDocumentMap() {
        return f30946a;
    }

    public static ImmutableSortedMap<DocumentKey, MutableDocument> emptyMutableDocumentMap() {
        return f30946a;
    }

    public static ImmutableSortedMap<DocumentKey, SnapshotVersion> emptyVersionMap() {
        return f30946a;
    }
}
