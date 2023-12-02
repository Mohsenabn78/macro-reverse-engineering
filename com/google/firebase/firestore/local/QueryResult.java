package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;

/* loaded from: classes5.dex */
public class QueryResult {

    /* renamed from: a  reason: collision with root package name */
    private final ImmutableSortedMap<DocumentKey, Document> f30699a;

    /* renamed from: b  reason: collision with root package name */
    private final ImmutableSortedSet<DocumentKey> f30700b;

    public QueryResult(ImmutableSortedMap<DocumentKey, Document> immutableSortedMap, ImmutableSortedSet<DocumentKey> immutableSortedSet) {
        this.f30699a = immutableSortedMap;
        this.f30700b = immutableSortedSet;
    }

    public ImmutableSortedMap<DocumentKey, Document> getDocuments() {
        return this.f30699a;
    }

    public ImmutableSortedSet<DocumentKey> getRemoteKeys() {
        return this.f30700b;
    }
}
