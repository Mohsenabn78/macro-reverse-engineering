package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ObjectValue;
import com.google.firestore.v1.Value;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public final class PatchMutation extends Mutation {

    /* renamed from: d  reason: collision with root package name */
    private final ObjectValue f30999d;

    /* renamed from: e  reason: collision with root package name */
    private final FieldMask f31000e;

    public PatchMutation(DocumentKey documentKey, ObjectValue objectValue, FieldMask fieldMask, Precondition precondition) {
        this(documentKey, objectValue, fieldMask, precondition, new ArrayList());
    }

    private List<FieldPath> g() {
        ArrayList arrayList = new ArrayList();
        for (FieldTransform fieldTransform : getFieldTransforms()) {
            arrayList.add(fieldTransform.getFieldPath());
        }
        return arrayList;
    }

    private Map<FieldPath, Value> h() {
        HashMap hashMap = new HashMap();
        for (FieldPath fieldPath : this.f31000e.getMask()) {
            if (!fieldPath.isEmpty()) {
                hashMap.put(fieldPath, this.f30999d.get(fieldPath));
            }
        }
        return hashMap;
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    @Nullable
    public FieldMask applyToLocalView(MutableDocument mutableDocument, @Nullable FieldMask fieldMask, Timestamp timestamp) {
        f(mutableDocument);
        if (!getPrecondition().isValidFor(mutableDocument)) {
            return fieldMask;
        }
        Map<FieldPath, Value> d4 = d(timestamp, mutableDocument);
        Map<FieldPath, Value> h4 = h();
        ObjectValue data = mutableDocument.getData();
        data.setAll(h4);
        data.setAll(d4);
        mutableDocument.convertToFoundDocument(mutableDocument.getVersion(), mutableDocument.getData()).setHasLocalMutations();
        if (fieldMask == null) {
            return null;
        }
        HashSet hashSet = new HashSet(fieldMask.getMask());
        hashSet.addAll(this.f31000e.getMask());
        hashSet.addAll(g());
        return FieldMask.fromSet(hashSet);
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public void applyToRemoteDocument(MutableDocument mutableDocument, MutationResult mutationResult) {
        f(mutableDocument);
        if (!getPrecondition().isValidFor(mutableDocument)) {
            mutableDocument.convertToUnknownDocument(mutationResult.getVersion());
            return;
        }
        Map<FieldPath, Value> e4 = e(mutableDocument, mutationResult.getTransformResults());
        ObjectValue data = mutableDocument.getData();
        data.setAll(h());
        data.setAll(e4);
        mutableDocument.convertToFoundDocument(mutationResult.getVersion(), mutableDocument.getData()).setHasCommittedMutations();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PatchMutation.class != obj.getClass()) {
            return false;
        }
        PatchMutation patchMutation = (PatchMutation) obj;
        if (a(patchMutation) && this.f30999d.equals(patchMutation.f30999d) && getFieldTransforms().equals(patchMutation.getFieldTransforms())) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public FieldMask getFieldMask() {
        return this.f31000e;
    }

    public ObjectValue getValue() {
        return this.f30999d;
    }

    public int hashCode() {
        return (b() * 31) + this.f30999d.hashCode();
    }

    public String toString() {
        return "PatchMutation{" + c() + ", mask=" + this.f31000e + ", value=" + this.f30999d + "}";
    }

    public PatchMutation(DocumentKey documentKey, ObjectValue objectValue, FieldMask fieldMask, Precondition precondition, List<FieldTransform> list) {
        super(documentKey, precondition, list);
        this.f30999d = objectValue;
        this.f31000e = fieldMask;
    }
}
