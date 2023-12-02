package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.local.OverlayedDocument;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public final class MutationBatch {
    public static final int UNKNOWN = -1;

    /* renamed from: a  reason: collision with root package name */
    private final int f30987a;

    /* renamed from: b  reason: collision with root package name */
    private final Timestamp f30988b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Mutation> f30989c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Mutation> f30990d;

    public MutationBatch(int i4, Timestamp timestamp, List<Mutation> list, List<Mutation> list2) {
        Assert.hardAssert(!list2.isEmpty(), "Cannot create an empty mutation batch", new Object[0]);
        this.f30987a = i4;
        this.f30988b = timestamp;
        this.f30989c = list;
        this.f30990d = list2;
    }

    public Map<DocumentKey, Mutation> applyToLocalDocumentSet(Map<DocumentKey, OverlayedDocument> map, Set<DocumentKey> set) {
        HashMap hashMap = new HashMap();
        for (DocumentKey documentKey : getKeys()) {
            MutableDocument mutableDocument = (MutableDocument) map.get(documentKey).getDocument();
            FieldMask applyToLocalView = applyToLocalView(mutableDocument, map.get(documentKey).getMutatedFields());
            if (set.contains(documentKey)) {
                applyToLocalView = null;
            }
            Mutation calculateOverlayMutation = Mutation.calculateOverlayMutation(mutableDocument, applyToLocalView);
            if (calculateOverlayMutation != null) {
                hashMap.put(documentKey, calculateOverlayMutation);
            }
            if (!mutableDocument.isValidDocument()) {
                mutableDocument.convertToNoDocument(SnapshotVersion.NONE);
            }
        }
        return hashMap;
    }

    public FieldMask applyToLocalView(MutableDocument mutableDocument, @Nullable FieldMask fieldMask) {
        for (int i4 = 0; i4 < this.f30989c.size(); i4++) {
            Mutation mutation = this.f30989c.get(i4);
            if (mutation.getKey().equals(mutableDocument.getKey())) {
                fieldMask = mutation.applyToLocalView(mutableDocument, fieldMask, this.f30988b);
            }
        }
        for (int i5 = 0; i5 < this.f30990d.size(); i5++) {
            Mutation mutation2 = this.f30990d.get(i5);
            if (mutation2.getKey().equals(mutableDocument.getKey())) {
                fieldMask = mutation2.applyToLocalView(mutableDocument, fieldMask, this.f30988b);
            }
        }
        return fieldMask;
    }

    public void applyToRemoteDocument(MutableDocument mutableDocument, MutationBatchResult mutationBatchResult) {
        boolean z3;
        int size = this.f30990d.size();
        List<MutationResult> mutationResults = mutationBatchResult.getMutationResults();
        if (mutationResults.size() == size) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Mismatch between mutations length (%d) and results length (%d)", Integer.valueOf(size), Integer.valueOf(mutationResults.size()));
        for (int i4 = 0; i4 < size; i4++) {
            Mutation mutation = this.f30990d.get(i4);
            if (mutation.getKey().equals(mutableDocument.getKey())) {
                mutation.applyToRemoteDocument(mutableDocument, mutationResults.get(i4));
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MutationBatch.class != obj.getClass()) {
            return false;
        }
        MutationBatch mutationBatch = (MutationBatch) obj;
        if (this.f30987a == mutationBatch.f30987a && this.f30988b.equals(mutationBatch.f30988b) && this.f30989c.equals(mutationBatch.f30989c) && this.f30990d.equals(mutationBatch.f30990d)) {
            return true;
        }
        return false;
    }

    public List<Mutation> getBaseMutations() {
        return this.f30989c;
    }

    public int getBatchId() {
        return this.f30987a;
    }

    public Set<DocumentKey> getKeys() {
        HashSet hashSet = new HashSet();
        for (Mutation mutation : this.f30990d) {
            hashSet.add(mutation.getKey());
        }
        return hashSet;
    }

    public Timestamp getLocalWriteTime() {
        return this.f30988b;
    }

    public List<Mutation> getMutations() {
        return this.f30990d;
    }

    public int hashCode() {
        return (((((this.f30987a * 31) + this.f30988b.hashCode()) * 31) + this.f30989c.hashCode()) * 31) + this.f30990d.hashCode();
    }

    public String toString() {
        return "MutationBatch(batchId=" + this.f30987a + ", localWriteTime=" + this.f30988b + ", baseMutations=" + this.f30989c + ", mutations=" + this.f30990d + ')';
    }
}
