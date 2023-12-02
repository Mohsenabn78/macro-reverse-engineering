package com.google.firebase.firestore.local;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class MemoryRemoteDocumentCache implements RemoteDocumentCache {

    /* renamed from: a  reason: collision with root package name */
    private ImmutableSortedMap<DocumentKey, Document> f30677a = DocumentCollections.emptyDocumentMap();

    /* renamed from: b  reason: collision with root package name */
    private IndexManager f30678b;

    /* loaded from: classes5.dex */
    private class DocumentIterable implements Iterable<Document> {
        private DocumentIterable() {
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<Document> iterator() {
            final Iterator it = MemoryRemoteDocumentCache.this.f30677a.iterator();
            return new Iterator<Document>() { // from class: com.google.firebase.firestore.local.MemoryRemoteDocumentCache.DocumentIterable.1
                @Override // java.util.Iterator
                /* renamed from: a */
                public Document next() {
                    return (Document) ((Map.Entry) it.next()).getValue();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return it.hasNext();
                }
            };
        }
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public MutableDocument a(DocumentKey documentKey) {
        Document document = this.f30677a.get(documentKey);
        if (document != null) {
            return document.mutableCopy();
        }
        return MutableDocument.newInvalidDocument(documentKey);
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public Map<DocumentKey, MutableDocument> b(String str, FieldIndex.IndexOffset indexOffset, int i4) {
        throw new UnsupportedOperationException("getAll(String, IndexOffset, int) is not supported.");
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public Map<DocumentKey, MutableDocument> c(Query query, FieldIndex.IndexOffset indexOffset, @Nonnull Set<DocumentKey> set, @Nullable QueryContext queryContext) {
        HashMap hashMap = new HashMap();
        Iterator<Map.Entry<DocumentKey, Document>> iteratorFrom = this.f30677a.iteratorFrom(DocumentKey.fromPath(query.getPath().append("")));
        while (iteratorFrom.hasNext()) {
            Map.Entry<DocumentKey, Document> next = iteratorFrom.next();
            Document value = next.getValue();
            DocumentKey key = next.getKey();
            if (!query.getPath().isPrefixOf(key.getPath())) {
                break;
            } else if (key.getPath().length() <= query.getPath().length() + 1 && FieldIndex.IndexOffset.fromDocument(value).compareTo(indexOffset) > 0 && (set.contains(value.getKey()) || query.matches(value))) {
                hashMap.put(value.getKey(), value.mutableCopy());
            }
        }
        return hashMap;
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public void d(MutableDocument mutableDocument, SnapshotVersion snapshotVersion) {
        boolean z3;
        if (this.f30678b != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "setIndexManager() not called", new Object[0]);
        Assert.hardAssert(!snapshotVersion.equals(SnapshotVersion.NONE), "Cannot add document to the RemoteDocumentCache with a read time of zero", new Object[0]);
        this.f30677a = this.f30677a.insert(mutableDocument.getKey(), mutableDocument.mutableCopy().setReadTime(snapshotVersion));
        this.f30678b.addToCollectionParentIndex(mutableDocument.getKey().getCollectionPath());
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public void e(IndexManager indexManager) {
        this.f30678b = indexManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long g(LocalSerializer localSerializer) {
        Iterator<Document> it = new DocumentIterable().iterator();
        long j4 = 0;
        while (it.hasNext()) {
            j4 += localSerializer.h(it.next()).getSerializedSize();
        }
        return j4;
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public Map<DocumentKey, MutableDocument> getAll(Iterable<DocumentKey> iterable) {
        HashMap hashMap = new HashMap();
        for (DocumentKey documentKey : iterable) {
            hashMap.put(documentKey, a(documentKey));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Iterable<Document> h() {
        return new DocumentIterable();
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public void removeAll(Collection<DocumentKey> collection) {
        boolean z3;
        if (this.f30678b != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "setIndexManager() not called", new Object[0]);
        ImmutableSortedMap<DocumentKey, Document> emptyDocumentMap = DocumentCollections.emptyDocumentMap();
        for (DocumentKey documentKey : collection) {
            this.f30677a = this.f30677a.remove(documentKey);
            emptyDocumentMap = emptyDocumentMap.insert(documentKey, MutableDocument.newNoDocument(documentKey, SnapshotVersion.NONE));
        }
        this.f30678b.updateIndexEntries(emptyDocumentMap);
    }
}
