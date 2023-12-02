package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.util.Assert;

/* loaded from: classes5.dex */
public final class DeleteMutation extends Mutation {
    public DeleteMutation(DocumentKey documentKey, Precondition precondition) {
        super(documentKey, precondition);
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    @Nullable
    public FieldMask applyToLocalView(MutableDocument mutableDocument, @Nullable FieldMask fieldMask, Timestamp timestamp) {
        f(mutableDocument);
        if (getPrecondition().isValidFor(mutableDocument)) {
            mutableDocument.convertToNoDocument(mutableDocument.getVersion()).setHasLocalMutations();
            return null;
        }
        return fieldMask;
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public void applyToRemoteDocument(MutableDocument mutableDocument, MutationResult mutationResult) {
        f(mutableDocument);
        Assert.hardAssert(mutationResult.getTransformResults().isEmpty(), "Transform results received by DeleteMutation.", new Object[0]);
        mutableDocument.convertToNoDocument(mutationResult.getVersion()).setHasCommittedMutations();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DeleteMutation.class == obj.getClass()) {
            return a((DeleteMutation) obj);
        }
        return false;
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    @Nullable
    public FieldMask getFieldMask() {
        return null;
    }

    public int hashCode() {
        return b();
    }

    public String toString() {
        return "DeleteMutation{" + c() + "}";
    }
}
