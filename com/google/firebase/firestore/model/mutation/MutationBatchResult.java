package com.google.firebase.firestore.model.mutation;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.ByteString;
import java.util.List;

/* loaded from: classes5.dex */
public final class MutationBatchResult {

    /* renamed from: a  reason: collision with root package name */
    private final MutationBatch f30991a;

    /* renamed from: b  reason: collision with root package name */
    private final SnapshotVersion f30992b;

    /* renamed from: c  reason: collision with root package name */
    private final List<MutationResult> f30993c;

    /* renamed from: d  reason: collision with root package name */
    private final ByteString f30994d;

    /* renamed from: e  reason: collision with root package name */
    private final ImmutableSortedMap<DocumentKey, SnapshotVersion> f30995e;

    private MutationBatchResult(MutationBatch mutationBatch, SnapshotVersion snapshotVersion, List<MutationResult> list, ByteString byteString, ImmutableSortedMap<DocumentKey, SnapshotVersion> immutableSortedMap) {
        this.f30991a = mutationBatch;
        this.f30992b = snapshotVersion;
        this.f30993c = list;
        this.f30994d = byteString;
        this.f30995e = immutableSortedMap;
    }

    public static MutationBatchResult create(MutationBatch mutationBatch, SnapshotVersion snapshotVersion, List<MutationResult> list, ByteString byteString) {
        boolean z3;
        if (mutationBatch.getMutations().size() == list.size()) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Mutations sent %d must equal results received %d", Integer.valueOf(mutationBatch.getMutations().size()), Integer.valueOf(list.size()));
        ImmutableSortedMap<DocumentKey, SnapshotVersion> emptyVersionMap = DocumentCollections.emptyVersionMap();
        List<Mutation> mutations = mutationBatch.getMutations();
        ImmutableSortedMap<DocumentKey, SnapshotVersion> immutableSortedMap = emptyVersionMap;
        for (int i4 = 0; i4 < mutations.size(); i4++) {
            immutableSortedMap = immutableSortedMap.insert(mutations.get(i4).getKey(), list.get(i4).getVersion());
        }
        return new MutationBatchResult(mutationBatch, snapshotVersion, list, byteString, immutableSortedMap);
    }

    public MutationBatch getBatch() {
        return this.f30991a;
    }

    public SnapshotVersion getCommitVersion() {
        return this.f30992b;
    }

    public ImmutableSortedMap<DocumentKey, SnapshotVersion> getDocVersions() {
        return this.f30995e;
    }

    public List<MutationResult> getMutationResults() {
        return this.f30993c;
    }

    public ByteString getStreamToken() {
        return this.f30994d;
    }
}
