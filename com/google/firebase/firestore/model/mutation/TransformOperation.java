package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firestore.v1.Value;

/* loaded from: classes5.dex */
public interface TransformOperation {
    Value applyToLocalView(@Nullable Value value, Timestamp timestamp);

    Value applyToRemoteDocument(@Nullable Value value, Value value2);

    @Nullable
    Value computeBaseValue(@Nullable Value value);
}
