package com.google.firebase.firestore.local;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.model.mutation.Overlay;
import com.google.firebase.firestore.model.mutation.PatchMutation;
import com.google.firebase.firestore.util.Assert;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class LocalDocumentsView {

    /* renamed from: a  reason: collision with root package name */
    private final RemoteDocumentCache f30598a;

    /* renamed from: b  reason: collision with root package name */
    private final MutationQueue f30599b;

    /* renamed from: c  reason: collision with root package name */
    private final DocumentOverlayCache f30600c;

    /* renamed from: d  reason: collision with root package name */
    private final IndexManager f30601d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalDocumentsView(RemoteDocumentCache remoteDocumentCache, MutationQueue mutationQueue, DocumentOverlayCache documentOverlayCache, IndexManager indexManager) {
        this.f30598a = remoteDocumentCache;
        this.f30599b = mutationQueue;
        this.f30600c = documentOverlayCache;
        this.f30601d = indexManager;
    }

    private Map<DocumentKey, OverlayedDocument> a(Map<DocumentKey, MutableDocument> map, Map<DocumentKey, Overlay> map2, Set<DocumentKey> set) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (MutableDocument mutableDocument : map.values()) {
            Overlay overlay = map2.get(mutableDocument.getKey());
            if (set.contains(mutableDocument.getKey()) && (overlay == null || (overlay.getMutation() instanceof PatchMutation))) {
                hashMap.put(mutableDocument.getKey(), mutableDocument);
            } else if (overlay != null) {
                hashMap2.put(mutableDocument.getKey(), overlay.getMutation().getFieldMask());
                overlay.getMutation().applyToLocalView(mutableDocument, overlay.getMutation().getFieldMask(), Timestamp.now());
            } else {
                hashMap2.put(mutableDocument.getKey(), FieldMask.EMPTY);
            }
        }
        hashMap2.putAll(n(hashMap));
        HashMap hashMap3 = new HashMap();
        for (Map.Entry<DocumentKey, MutableDocument> entry : map.entrySet()) {
            hashMap3.put(entry.getKey(), new OverlayedDocument(entry.getValue(), (FieldMask) hashMap2.get(entry.getKey())));
        }
        return hashMap3;
    }

    private MutableDocument b(DocumentKey documentKey, @Nullable Overlay overlay) {
        if (overlay != null && !(overlay.getMutation() instanceof PatchMutation)) {
            return MutableDocument.newInvalidDocument(documentKey);
        }
        return this.f30598a.a(documentKey);
    }

    private ImmutableSortedMap<DocumentKey, Document> e(Query query, FieldIndex.IndexOffset indexOffset, @Nullable QueryContext queryContext) {
        Assert.hardAssert(query.getPath().isEmpty(), "Currently we only support collection group queries at the root.", new Object[0]);
        String collectionGroup = query.getCollectionGroup();
        ImmutableSortedMap<DocumentKey, Document> emptyDocumentMap = DocumentCollections.emptyDocumentMap();
        for (ResourcePath resourcePath : this.f30601d.getCollectionParents(collectionGroup)) {
            Iterator<Map.Entry<DocumentKey, Document>> it = f(query.asCollectionQueryAtPath(resourcePath.append(collectionGroup)), indexOffset, queryContext).iterator();
            while (it.hasNext()) {
                Map.Entry<DocumentKey, Document> next = it.next();
                emptyDocumentMap = emptyDocumentMap.insert(next.getKey(), next.getValue());
            }
        }
        return emptyDocumentMap;
    }

    private ImmutableSortedMap<DocumentKey, Document> f(Query query, FieldIndex.IndexOffset indexOffset, @Nullable QueryContext queryContext) {
        Map<DocumentKey, Overlay> overlays = this.f30600c.getOverlays(query.getPath(), indexOffset.getLargestBatchId());
        Map<DocumentKey, MutableDocument> c4 = this.f30598a.c(query, indexOffset, overlays.keySet(), queryContext);
        for (Map.Entry<DocumentKey, Overlay> entry : overlays.entrySet()) {
            if (!c4.containsKey(entry.getKey())) {
                c4.put(entry.getKey(), MutableDocument.newInvalidDocument(entry.getKey()));
            }
        }
        ImmutableSortedMap<DocumentKey, Document> emptyDocumentMap = DocumentCollections.emptyDocumentMap();
        for (Map.Entry<DocumentKey, MutableDocument> entry2 : c4.entrySet()) {
            Overlay overlay = overlays.get(entry2.getKey());
            if (overlay != null) {
                overlay.getMutation().applyToLocalView(entry2.getValue(), FieldMask.EMPTY, Timestamp.now());
            }
            if (query.matches(entry2.getValue())) {
                emptyDocumentMap = emptyDocumentMap.insert(entry2.getKey(), entry2.getValue());
            }
        }
        return emptyDocumentMap;
    }

    private ImmutableSortedMap<DocumentKey, Document> g(ResourcePath resourcePath) {
        ImmutableSortedMap<DocumentKey, Document> emptyDocumentMap = DocumentCollections.emptyDocumentMap();
        Document c4 = c(DocumentKey.fromPath(resourcePath));
        if (c4.isFoundDocument()) {
            return emptyDocumentMap.insert(c4.getKey(), c4);
        }
        return emptyDocumentMap;
    }

    private void m(Map<DocumentKey, Overlay> map, Set<DocumentKey> set) {
        TreeSet treeSet = new TreeSet();
        for (DocumentKey documentKey : set) {
            if (!map.containsKey(documentKey)) {
                treeSet.add(documentKey);
            }
        }
        map.putAll(this.f30600c.getOverlays(treeSet));
    }

    private Map<DocumentKey, FieldMask> n(Map<DocumentKey, MutableDocument> map) {
        FieldMask fieldMask;
        List<MutationBatch> b4 = this.f30599b.b(map.keySet());
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        for (MutationBatch mutationBatch : b4) {
            for (DocumentKey documentKey : mutationBatch.getKeys()) {
                MutableDocument mutableDocument = map.get(documentKey);
                if (mutableDocument != null) {
                    if (hashMap.containsKey(documentKey)) {
                        fieldMask = (FieldMask) hashMap.get(documentKey);
                    } else {
                        fieldMask = FieldMask.EMPTY;
                    }
                    hashMap.put(documentKey, mutationBatch.applyToLocalView(mutableDocument, fieldMask));
                    int batchId = mutationBatch.getBatchId();
                    if (!treeMap.containsKey(Integer.valueOf(batchId))) {
                        treeMap.put(Integer.valueOf(batchId), new HashSet());
                    }
                    ((Set) treeMap.get(Integer.valueOf(batchId))).add(documentKey);
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : treeMap.descendingMap().entrySet()) {
            HashMap hashMap2 = new HashMap();
            for (DocumentKey documentKey2 : (Set) entry.getValue()) {
                if (!hashSet.contains(documentKey2)) {
                    Mutation calculateOverlayMutation = Mutation.calculateOverlayMutation(map.get(documentKey2), (FieldMask) hashMap.get(documentKey2));
                    if (calculateOverlayMutation != null) {
                        hashMap2.put(documentKey2, calculateOverlayMutation);
                    }
                    hashSet.add(documentKey2);
                }
            }
            this.f30600c.saveOverlays(((Integer) entry.getKey()).intValue(), hashMap2);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Document c(DocumentKey documentKey) {
        Overlay overlay = this.f30600c.getOverlay(documentKey);
        MutableDocument b4 = b(documentKey, overlay);
        if (overlay != null) {
            overlay.getMutation().applyToLocalView(b4, FieldMask.EMPTY, Timestamp.now());
        }
        return b4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSortedMap<DocumentKey, Document> d(Iterable<DocumentKey> iterable) {
        return j(this.f30598a.getAll(iterable), new HashSet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSortedMap<DocumentKey, Document> h(Query query, FieldIndex.IndexOffset indexOffset) {
        return i(query, indexOffset, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSortedMap<DocumentKey, Document> i(Query query, FieldIndex.IndexOffset indexOffset, @Nullable QueryContext queryContext) {
        ResourcePath path = query.getPath();
        if (query.isDocumentQuery()) {
            return g(path);
        }
        if (query.isCollectionGroupQuery()) {
            return e(query, indexOffset, queryContext);
        }
        return f(query, indexOffset, queryContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSortedMap<DocumentKey, Document> j(Map<DocumentKey, MutableDocument> map, Set<DocumentKey> set) {
        HashMap hashMap = new HashMap();
        m(hashMap, map.keySet());
        ImmutableSortedMap<DocumentKey, Document> emptyDocumentMap = DocumentCollections.emptyDocumentMap();
        for (Map.Entry<DocumentKey, OverlayedDocument> entry : a(map, hashMap, set).entrySet()) {
            emptyDocumentMap = emptyDocumentMap.insert(entry.getKey(), entry.getValue().getDocument());
        }
        return emptyDocumentMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalDocumentsResult k(String str, FieldIndex.IndexOffset indexOffset, int i4) {
        Map<DocumentKey, Overlay> emptyMap;
        Map<DocumentKey, MutableDocument> b4 = this.f30598a.b(str, indexOffset, i4);
        if (i4 - b4.size() > 0) {
            emptyMap = this.f30600c.getOverlays(str, indexOffset.getLargestBatchId(), i4 - b4.size());
        } else {
            emptyMap = Collections.emptyMap();
        }
        int i5 = -1;
        for (Overlay overlay : emptyMap.values()) {
            if (!b4.containsKey(overlay.getKey())) {
                b4.put(overlay.getKey(), b(overlay.getKey(), overlay));
            }
            i5 = Math.max(i5, overlay.getLargestBatchId());
        }
        m(emptyMap, b4.keySet());
        return LocalDocumentsResult.fromOverlayedDocuments(i5, a(b4, emptyMap, Collections.emptySet()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<DocumentKey, OverlayedDocument> l(Map<DocumentKey, MutableDocument> map) {
        HashMap hashMap = new HashMap();
        m(hashMap, map.keySet());
        return a(map, hashMap, new HashSet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Set<DocumentKey> set) {
        n(this.f30598a.getAll(set));
    }
}
