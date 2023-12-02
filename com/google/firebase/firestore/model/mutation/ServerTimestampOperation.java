package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.ServerTimestamps;
import com.google.firestore.v1.Value;

/* loaded from: classes5.dex */
public class ServerTimestampOperation implements TransformOperation {

    /* renamed from: a  reason: collision with root package name */
    private static final ServerTimestampOperation f31003a = new ServerTimestampOperation();

    private ServerTimestampOperation() {
    }

    public static ServerTimestampOperation getInstance() {
        return f31003a;
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public Value applyToLocalView(@Nullable Value value, Timestamp timestamp) {
        return ServerTimestamps.valueOf(timestamp, value);
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    @Nullable
    public Value computeBaseValue(@Nullable Value value) {
        return null;
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public Value applyToRemoteDocument(@Nullable Value value, Value value2) {
        return value2;
    }
}
