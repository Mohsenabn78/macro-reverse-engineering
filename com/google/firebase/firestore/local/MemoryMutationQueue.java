package com.google.firebase.firestore.local;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.remote.WriteStream;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class MemoryMutationQueue implements MutationQueue {

    /* renamed from: a  reason: collision with root package name */
    private final List<MutationBatch> f30663a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private ImmutableSortedSet<DocumentReference> f30664b = new ImmutableSortedSet<>(Collections.emptyList(), DocumentReference.f30581c);

    /* renamed from: c  reason: collision with root package name */
    private int f30665c = 1;

    /* renamed from: d  reason: collision with root package name */
    private ByteString f30666d = WriteStream.EMPTY_STREAM_TOKEN;

    /* renamed from: e  reason: collision with root package name */
    private final MemoryPersistence f30667e;

    /* renamed from: f  reason: collision with root package name */
    private final MemoryIndexManager f30668f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MemoryMutationQueue(MemoryPersistence memoryPersistence, User user) {
        this.f30667e = memoryPersistence;
        this.f30668f = memoryPersistence.c(user);
    }

    private int m(int i4) {
        if (this.f30663a.isEmpty()) {
            return 0;
        }
        return i4 - this.f30663a.get(0).getBatchId();
    }

    private int n(int i4, String str) {
        boolean z3;
        int m4 = m(i4);
        if (m4 >= 0 && m4 < this.f30663a.size()) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Batches must exist to be %s", str);
        return m4;
    }

    private List<MutationBatch> p(ImmutableSortedSet<Integer> immutableSortedSet) {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = immutableSortedSet.iterator();
        while (it.hasNext()) {
            MutationBatch d4 = d(it.next().intValue());
            if (d4 != null) {
                arrayList.add(d4);
            }
        }
        return arrayList;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void a() {
        if (this.f30663a.isEmpty()) {
            Assert.hardAssert(this.f30664b.isEmpty(), "Document leak -- detected dangling mutation references when queue is empty.", new Object[0]);
        }
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public List<MutationBatch> b(Iterable<DocumentKey> iterable) {
        ImmutableSortedSet<Integer> immutableSortedSet = new ImmutableSortedSet<>(Collections.emptyList(), Util.comparator());
        for (DocumentKey documentKey : iterable) {
            Iterator<DocumentReference> iteratorFrom = this.f30664b.iteratorFrom(new DocumentReference(documentKey, 0));
            while (iteratorFrom.hasNext()) {
                DocumentReference next = iteratorFrom.next();
                if (!documentKey.equals(next.d())) {
                    break;
                }
                immutableSortedSet = immutableSortedSet.insert(Integer.valueOf(next.c()));
            }
        }
        return p(immutableSortedSet);
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    @Nullable
    public MutationBatch c(int i4) {
        int m4 = m(i4 + 1);
        if (m4 < 0) {
            m4 = 0;
        }
        if (this.f30663a.size() > m4) {
            return this.f30663a.get(m4);
        }
        return null;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    @Nullable
    public MutationBatch d(int i4) {
        boolean z3;
        int m4 = m(i4);
        if (m4 >= 0 && m4 < this.f30663a.size()) {
            MutationBatch mutationBatch = this.f30663a.get(m4);
            if (mutationBatch.getBatchId() == i4) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assert.hardAssert(z3, "If found batch must match", new Object[0]);
            return mutationBatch;
        }
        return null;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void e(MutationBatch mutationBatch, ByteString byteString) {
        boolean z3;
        boolean z4;
        int batchId = mutationBatch.getBatchId();
        int n4 = n(batchId, "acknowledged");
        if (n4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Can only acknowledge the first batch in the mutation queue", new Object[0]);
        MutationBatch mutationBatch2 = this.f30663a.get(n4);
        if (batchId == mutationBatch2.getBatchId()) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assert.hardAssert(z4, "Queue ordering failure: expected batch %d, got batch %d", Integer.valueOf(batchId), Integer.valueOf(mutationBatch2.getBatchId()));
        this.f30666d = (ByteString) Preconditions.checkNotNull(byteString);
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public MutationBatch f(Timestamp timestamp, List<Mutation> list, List<Mutation> list2) {
        boolean z3 = true;
        Assert.hardAssert(!list2.isEmpty(), "Mutation batches should not be empty", new Object[0]);
        int i4 = this.f30665c;
        this.f30665c = i4 + 1;
        int size = this.f30663a.size();
        if (size > 0) {
            if (this.f30663a.get(size - 1).getBatchId() >= i4) {
                z3 = false;
            }
            Assert.hardAssert(z3, "Mutation batchIds must be monotonically increasing order", new Object[0]);
        }
        MutationBatch mutationBatch = new MutationBatch(i4, timestamp, list, list2);
        this.f30663a.add(mutationBatch);
        for (Mutation mutation : list2) {
            this.f30664b = this.f30664b.insert(new DocumentReference(mutation.getKey(), i4));
            this.f30668f.addToCollectionParentIndex(mutation.getKey().getCollectionPath());
        }
        return mutationBatch;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public int g() {
        if (this.f30663a.isEmpty()) {
            return -1;
        }
        return this.f30665c - 1;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public ByteString getLastStreamToken() {
        return this.f30666d;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void h(MutationBatch mutationBatch) {
        boolean z3;
        if (n(mutationBatch.getBatchId(), "removed") == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Can only remove the first entry of the mutation queue", new Object[0]);
        this.f30663a.remove(0);
        ImmutableSortedSet<DocumentReference> immutableSortedSet = this.f30664b;
        for (Mutation mutation : mutationBatch.getMutations()) {
            DocumentKey key = mutation.getKey();
            this.f30667e.getReferenceDelegate().d(key);
            immutableSortedSet = immutableSortedSet.remove(new DocumentReference(key, mutationBatch.getBatchId()));
        }
        this.f30664b = immutableSortedSet;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void i(ByteString byteString) {
        this.f30666d = (ByteString) Preconditions.checkNotNull(byteString);
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public List<MutationBatch> j() {
        return Collections.unmodifiableList(this.f30663a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k(DocumentKey documentKey) {
        Iterator<DocumentReference> iteratorFrom = this.f30664b.iteratorFrom(new DocumentReference(documentKey, 0));
        if (!iteratorFrom.hasNext()) {
            return false;
        }
        return iteratorFrom.next().d().equals(documentKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long l(LocalSerializer localSerializer) {
        long j4 = 0;
        for (MutationBatch mutationBatch : this.f30663a) {
            j4 += localSerializer.i(mutationBatch).getSerializedSize();
        }
        return j4;
    }

    public boolean o() {
        return this.f30663a.isEmpty();
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void start() {
        if (o()) {
            this.f30665c = 1;
        }
    }
}
