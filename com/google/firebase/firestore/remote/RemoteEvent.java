package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.local.QueryPurpose;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public final class RemoteEvent {

    /* renamed from: a  reason: collision with root package name */
    private final SnapshotVersion f31128a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, TargetChange> f31129b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Integer, QueryPurpose> f31130c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<DocumentKey, MutableDocument> f31131d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<DocumentKey> f31132e;

    public RemoteEvent(SnapshotVersion snapshotVersion, Map<Integer, TargetChange> map, Map<Integer, QueryPurpose> map2, Map<DocumentKey, MutableDocument> map3, Set<DocumentKey> set) {
        this.f31128a = snapshotVersion;
        this.f31129b = map;
        this.f31130c = map2;
        this.f31131d = map3;
        this.f31132e = set;
    }

    public Map<DocumentKey, MutableDocument> getDocumentUpdates() {
        return this.f31131d;
    }

    public Set<DocumentKey> getResolvedLimboDocuments() {
        return this.f31132e;
    }

    public SnapshotVersion getSnapshotVersion() {
        return this.f31128a;
    }

    public Map<Integer, TargetChange> getTargetChanges() {
        return this.f31129b;
    }

    public Map<Integer, QueryPurpose> getTargetMismatches() {
        return this.f31130c;
    }

    public String toString() {
        return "RemoteEvent{snapshotVersion=" + this.f31128a + ", targetChanges=" + this.f31129b + ", targetMismatches=" + this.f31130c + ", documentUpdates=" + this.f31131d + ", resolvedLimboDocuments=" + this.f31132e + '}';
    }
}
