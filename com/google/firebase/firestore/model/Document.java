package com.google.firebase.firestore.model;

import androidx.annotation.Nullable;
import com.google.firestore.v1.Value;
import java.util.Comparator;

/* loaded from: classes5.dex */
public interface Document {
    public static final Comparator<Document> KEY_COMPARATOR = new Comparator() { // from class: com.google.firebase.firestore.model.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return b.a((Document) obj, (Document) obj2);
        }
    };

    ObjectValue getData();

    @Nullable
    Value getField(FieldPath fieldPath);

    DocumentKey getKey();

    SnapshotVersion getReadTime();

    SnapshotVersion getVersion();

    boolean hasCommittedMutations();

    boolean hasLocalMutations();

    boolean hasPendingWrites();

    boolean isFoundDocument();

    boolean isNoDocument();

    boolean isUnknownDocument();

    boolean isValidDocument();

    MutableDocument mutableCopy();
}
