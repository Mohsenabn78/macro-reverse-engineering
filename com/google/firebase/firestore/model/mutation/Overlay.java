package com.google.firebase.firestore.model.mutation;

import com.google.auto.value.AutoValue;
import com.google.firebase.firestore.model.DocumentKey;

@AutoValue
/* loaded from: classes5.dex */
public abstract class Overlay {
    public static Overlay create(int i4, Mutation mutation) {
        return new AutoValue_Overlay(i4, mutation);
    }

    public DocumentKey getKey() {
        return getMutation().getKey();
    }

    public abstract int getLargestBatchId();

    public abstract Mutation getMutation();
}
