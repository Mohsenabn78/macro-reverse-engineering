package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ObjectValue;
import com.google.firebase.firestore.util.Assert;
import com.google.firestore.v1.Value;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public abstract class Mutation {

    /* renamed from: a  reason: collision with root package name */
    private final DocumentKey f30984a;

    /* renamed from: b  reason: collision with root package name */
    private final Precondition f30985b;

    /* renamed from: c  reason: collision with root package name */
    private final List<FieldTransform> f30986c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Mutation(DocumentKey documentKey, Precondition precondition) {
        this(documentKey, precondition, new ArrayList());
    }

    @Nullable
    public static Mutation calculateOverlayMutation(MutableDocument mutableDocument, @Nullable FieldMask fieldMask) {
        if (mutableDocument.hasLocalMutations()) {
            if (fieldMask == null || !fieldMask.getMask().isEmpty()) {
                if (fieldMask == null) {
                    if (mutableDocument.isNoDocument()) {
                        return new DeleteMutation(mutableDocument.getKey(), Precondition.NONE);
                    }
                    return new SetMutation(mutableDocument.getKey(), mutableDocument.getData(), Precondition.NONE);
                }
                ObjectValue data = mutableDocument.getData();
                ObjectValue objectValue = new ObjectValue();
                HashSet hashSet = new HashSet();
                for (FieldPath fieldPath : fieldMask.getMask()) {
                    if (!hashSet.contains(fieldPath)) {
                        if (data.get(fieldPath) == null && fieldPath.length() > 1) {
                            fieldPath = fieldPath.popLast();
                        }
                        objectValue.set(fieldPath, data.get(fieldPath));
                        hashSet.add(fieldPath);
                    }
                }
                return new PatchMutation(mutableDocument.getKey(), objectValue, FieldMask.fromSet(hashSet), Precondition.NONE);
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Mutation mutation) {
        if (this.f30984a.equals(mutation.f30984a) && this.f30985b.equals(mutation.f30985b)) {
            return true;
        }
        return false;
    }

    @Nullable
    public abstract FieldMask applyToLocalView(MutableDocument mutableDocument, @Nullable FieldMask fieldMask, Timestamp timestamp);

    public abstract void applyToRemoteDocument(MutableDocument mutableDocument, MutationResult mutationResult);

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return (getKey().hashCode() * 31) + this.f30985b.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return "key=" + this.f30984a + ", precondition=" + this.f30985b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<FieldPath, Value> d(Timestamp timestamp, MutableDocument mutableDocument) {
        HashMap hashMap = new HashMap(this.f30986c.size());
        for (FieldTransform fieldTransform : this.f30986c) {
            hashMap.put(fieldTransform.getFieldPath(), fieldTransform.getOperation().applyToLocalView(mutableDocument.getField(fieldTransform.getFieldPath()), timestamp));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<FieldPath, Value> e(MutableDocument mutableDocument, List<Value> list) {
        boolean z3;
        HashMap hashMap = new HashMap(this.f30986c.size());
        if (this.f30986c.size() == list.size()) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "server transform count (%d) should match field transform count (%d)", Integer.valueOf(list.size()), Integer.valueOf(this.f30986c.size()));
        for (int i4 = 0; i4 < list.size(); i4++) {
            FieldTransform fieldTransform = this.f30986c.get(i4);
            hashMap.put(fieldTransform.getFieldPath(), fieldTransform.getOperation().applyToRemoteDocument(mutableDocument.getField(fieldTransform.getFieldPath()), list.get(i4)));
        }
        return hashMap;
    }

    public ObjectValue extractTransformBaseValue(Document document) {
        ObjectValue objectValue = null;
        for (FieldTransform fieldTransform : this.f30986c) {
            Value computeBaseValue = fieldTransform.getOperation().computeBaseValue(document.getField(fieldTransform.getFieldPath()));
            if (computeBaseValue != null) {
                if (objectValue == null) {
                    objectValue = new ObjectValue();
                }
                objectValue.set(fieldTransform.getFieldPath(), computeBaseValue);
            }
        }
        return objectValue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MutableDocument mutableDocument) {
        Assert.hardAssert(mutableDocument.getKey().equals(getKey()), "Can only apply a mutation to a document with the same key", new Object[0]);
    }

    @Nullable
    public abstract FieldMask getFieldMask();

    public List<FieldTransform> getFieldTransforms() {
        return this.f30986c;
    }

    public DocumentKey getKey() {
        return this.f30984a;
    }

    public Precondition getPrecondition() {
        return this.f30985b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Mutation(DocumentKey documentKey, Precondition precondition, List<FieldTransform> list) {
        this.f30984a = documentKey;
        this.f30985b = precondition;
        this.f30986c = list;
    }
}
