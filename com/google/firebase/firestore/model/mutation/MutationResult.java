package com.google.firebase.firestore.model.mutation;

import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firestore.v1.Value;
import java.util.List;

/* loaded from: classes5.dex */
public final class MutationResult {

    /* renamed from: a  reason: collision with root package name */
    private final SnapshotVersion f30996a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Value> f30997b;

    public MutationResult(SnapshotVersion snapshotVersion, List<Value> list) {
        this.f30996a = (SnapshotVersion) Preconditions.checkNotNull(snapshotVersion);
        this.f30997b = list;
    }

    public List<Value> getTransformResults() {
        return this.f30997b;
    }

    public SnapshotVersion getVersion() {
        return this.f30996a;
    }
}
