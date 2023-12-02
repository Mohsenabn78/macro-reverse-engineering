package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.firebase.firestore.core.FirestoreClient;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public final class PersistentCacheIndexManager {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private FirestoreClient f30214a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PersistentCacheIndexManager(FirestoreClient firestoreClient) {
        this.f30214a = firestoreClient;
    }

    public void deleteAllIndexes() {
        this.f30214a.deleteAllFieldIndexes();
    }

    public void disableIndexAutoCreation() {
        this.f30214a.setIndexAutoCreationEnabled(false);
    }

    public void enableIndexAutoCreation() {
        this.f30214a.setIndexAutoCreationEnabled(true);
    }
}
