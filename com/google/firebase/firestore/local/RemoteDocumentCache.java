package com.google.firebase.firestore.local;

import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public interface RemoteDocumentCache {
    MutableDocument a(DocumentKey documentKey);

    Map<DocumentKey, MutableDocument> b(String str, FieldIndex.IndexOffset indexOffset, int i4);

    Map<DocumentKey, MutableDocument> c(Query query, FieldIndex.IndexOffset indexOffset, @Nonnull Set<DocumentKey> set, @Nullable QueryContext queryContext);

    void d(MutableDocument mutableDocument, SnapshotVersion snapshotVersion);

    void e(IndexManager indexManager);

    Map<DocumentKey, MutableDocument> getAll(Iterable<DocumentKey> iterable);

    void removeAll(Collection<DocumentKey> collection);
}
