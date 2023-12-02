package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ObjectValue;
import com.google.firestore.v1.Value;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public final class SetMutation extends Mutation {

    /* renamed from: d  reason: collision with root package name */
    private final ObjectValue f31004d;

    public SetMutation(DocumentKey documentKey, ObjectValue objectValue, Precondition precondition) {
        this(documentKey, objectValue, precondition, new ArrayList());
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public FieldMask applyToLocalView(MutableDocument mutableDocument, @Nullable FieldMask fieldMask, Timestamp timestamp) {
        f(mutableDocument);
        if (!getPrecondition().isValidFor(mutableDocument)) {
            return fieldMask;
        }
        Map<FieldPath, Value> d4 = d(timestamp, mutableDocument);
        ObjectValue m4168clone = this.f31004d.m4168clone();
        m4168clone.setAll(d4);
        mutableDocument.convertToFoundDocument(mutableDocument.getVersion(), m4168clone).setHasLocalMutations();
        return null;
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public void applyToRemoteDocument(MutableDocument mutableDocument, MutationResult mutationResult) {
        f(mutableDocument);
        ObjectValue m4168clone = this.f31004d.m4168clone();
        m4168clone.setAll(e(mutableDocument, mutationResult.getTransformResults()));
        mutableDocument.convertToFoundDocument(mutationResult.getVersion(), m4168clone).setHasCommittedMutations();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SetMutation.class != obj.getClass()) {
            return false;
        }
        SetMutation setMutation = (SetMutation) obj;
        if (a(setMutation) && this.f31004d.equals(setMutation.f31004d) && getFieldTransforms().equals(setMutation.getFieldTransforms())) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    @Nullable
    public FieldMask getFieldMask() {
        return null;
    }

    public ObjectValue getValue() {
        return this.f31004d;
    }

    public int hashCode() {
        return (b() * 31) + this.f31004d.hashCode();
    }

    public String toString() {
        return "SetMutation{" + c() + ", value=" + this.f31004d + "}";
    }

    public SetMutation(DocumentKey documentKey, ObjectValue objectValue, Precondition precondition, List<FieldTransform> list) {
        super(documentKey, precondition, list);
        this.f31004d = objectValue;
    }
}
