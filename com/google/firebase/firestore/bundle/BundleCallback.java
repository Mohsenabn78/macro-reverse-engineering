package com.google.firebase.firestore.bundle;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;

/* loaded from: classes5.dex */
public interface BundleCallback {
    ImmutableSortedMap<DocumentKey, Document> applyBundledDocuments(ImmutableSortedMap<DocumentKey, MutableDocument> immutableSortedMap, String str);

    void saveBundle(BundleMetadata bundleMetadata);

    void saveNamedQuery(NamedQuery namedQuery, ImmutableSortedSet<DocumentKey> immutableSortedSet);
}
