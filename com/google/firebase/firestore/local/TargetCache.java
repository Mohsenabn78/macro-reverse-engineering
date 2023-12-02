package com.google.firebase.firestore.local;

import androidx.annotation.Nullable;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public interface TargetCache {
    void a(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i4);

    @Nullable
    TargetData b(Target target);

    void c(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i4);

    void d(int i4);

    void e(TargetData targetData);

    void f(SnapshotVersion snapshotVersion);

    void g(TargetData targetData);

    int getHighestTargetId();

    SnapshotVersion getLastRemoteSnapshotVersion();

    ImmutableSortedSet<DocumentKey> h(int i4);
}
