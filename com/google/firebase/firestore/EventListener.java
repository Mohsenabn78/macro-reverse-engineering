package com.google.firebase.firestore;

import androidx.annotation.Nullable;

/* loaded from: classes5.dex */
public interface EventListener<T> {
    void onEvent(@Nullable T t3, @Nullable FirebaseFirestoreException firebaseFirestoreException);
}
