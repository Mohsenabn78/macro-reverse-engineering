package com.google.firebase.firestore.local;

import androidx.annotation.Nullable;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.local.IndexManager;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes5.dex */
class MemoryIndexManager implements IndexManager {

    /* renamed from: a  reason: collision with root package name */
    private final MemoryCollectionParentIndex f30654a = new MemoryCollectionParentIndex();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class MemoryCollectionParentIndex {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap<String, HashSet<ResourcePath>> f30655a = new HashMap<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(ResourcePath resourcePath) {
            boolean z3 = true;
            if (resourcePath.length() % 2 != 1) {
                z3 = false;
            }
            Assert.hardAssert(z3, "Expected a collection path.", new Object[0]);
            String lastSegment = resourcePath.getLastSegment();
            ResourcePath popLast = resourcePath.popLast();
            HashSet<ResourcePath> hashSet = this.f30655a.get(lastSegment);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.f30655a.put(lastSegment, hashSet);
            }
            return hashSet.add(popLast);
        }

        List<ResourcePath> b(String str) {
            HashSet<ResourcePath> hashSet = this.f30655a.get(str);
            if (hashSet != null) {
                return new ArrayList(hashSet);
            }
            return Collections.emptyList();
        }
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void addToCollectionParentIndex(ResourcePath resourcePath) {
        this.f30654a.a(resourcePath);
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public List<ResourcePath> getCollectionParents(String str) {
        return this.f30654a.b(str);
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    @Nullable
    public List<DocumentKey> getDocumentsMatchingTarget(Target target) {
        return null;
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public Collection<FieldIndex> getFieldIndexes(String str) {
        return Collections.emptyList();
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public IndexManager.IndexType getIndexType(Target target) {
        return IndexManager.IndexType.NONE;
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public FieldIndex.IndexOffset getMinOffset(Target target) {
        return FieldIndex.IndexOffset.NONE;
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    @Nullable
    public String getNextCollectionGroupToUpdate() {
        return null;
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public Collection<FieldIndex> getFieldIndexes() {
        return Collections.emptyList();
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public FieldIndex.IndexOffset getMinOffset(String str) {
        return FieldIndex.IndexOffset.NONE;
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void deleteAllFieldIndexes() {
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void start() {
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void addFieldIndex(FieldIndex fieldIndex) {
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void createTargetIndexes(Target target) {
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void deleteFieldIndex(FieldIndex fieldIndex) {
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void updateIndexEntries(ImmutableSortedMap<DocumentKey, Document> immutableSortedMap) {
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void updateCollectionGroup(String str, FieldIndex.IndexOffset indexOffset) {
    }
}
