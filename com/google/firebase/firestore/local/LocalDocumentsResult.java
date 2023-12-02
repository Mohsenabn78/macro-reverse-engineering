package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import java.util.Map;

/* loaded from: classes5.dex */
public final class LocalDocumentsResult {

    /* renamed from: a  reason: collision with root package name */
    private final int f30596a;

    /* renamed from: b  reason: collision with root package name */
    private final ImmutableSortedMap<DocumentKey, Document> f30597b;

    LocalDocumentsResult(int i4, ImmutableSortedMap<DocumentKey, Document> immutableSortedMap) {
        this.f30596a = i4;
        this.f30597b = immutableSortedMap;
    }

    public static LocalDocumentsResult fromOverlayedDocuments(int i4, Map<DocumentKey, OverlayedDocument> map) {
        ImmutableSortedMap<DocumentKey, Document> emptyDocumentMap = DocumentCollections.emptyDocumentMap();
        for (Map.Entry<DocumentKey, OverlayedDocument> entry : map.entrySet()) {
            emptyDocumentMap = emptyDocumentMap.insert(entry.getKey(), entry.getValue().getDocument());
        }
        return new LocalDocumentsResult(i4, emptyDocumentMap);
    }

    public int getBatchId() {
        return this.f30596a;
    }

    public ImmutableSortedMap<DocumentKey, Document> getDocuments() {
        return this.f30597b;
    }
}
