package com.google.firebase.firestore.local;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class MemoryTargetCache implements TargetCache {

    /* renamed from: c  reason: collision with root package name */
    private int f30684c;

    /* renamed from: f  reason: collision with root package name */
    private final MemoryPersistence f30687f;

    /* renamed from: a  reason: collision with root package name */
    private final Map<Target, TargetData> f30682a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final ReferenceSet f30683b = new ReferenceSet();

    /* renamed from: d  reason: collision with root package name */
    private SnapshotVersion f30685d = SnapshotVersion.NONE;

    /* renamed from: e  reason: collision with root package name */
    private long f30686e = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MemoryTargetCache(MemoryPersistence memoryPersistence) {
        this.f30687f = memoryPersistence;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void a(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i4) {
        this.f30683b.removeReferences(immutableSortedSet, i4);
        ReferenceDelegate referenceDelegate = this.f30687f.getReferenceDelegate();
        Iterator<DocumentKey> it = immutableSortedSet.iterator();
        while (it.hasNext()) {
            referenceDelegate.i(it.next());
        }
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    @Nullable
    public TargetData b(Target target) {
        return this.f30682a.get(target);
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void c(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i4) {
        this.f30683b.addReferences(immutableSortedSet, i4);
        ReferenceDelegate referenceDelegate = this.f30687f.getReferenceDelegate();
        Iterator<DocumentKey> it = immutableSortedSet.iterator();
        while (it.hasNext()) {
            referenceDelegate.h(it.next());
        }
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void d(int i4) {
        this.f30683b.removeReferencesForId(i4);
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void e(TargetData targetData) {
        g(targetData);
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void f(SnapshotVersion snapshotVersion) {
        this.f30685d = snapshotVersion;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void g(TargetData targetData) {
        this.f30682a.put(targetData.getTarget(), targetData);
        int targetId = targetData.getTargetId();
        if (targetId > this.f30684c) {
            this.f30684c = targetId;
        }
        if (targetData.getSequenceNumber() > this.f30686e) {
            this.f30686e = targetData.getSequenceNumber();
        }
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public int getHighestTargetId() {
        return this.f30684c;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public SnapshotVersion getLastRemoteSnapshotVersion() {
        return this.f30685d;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public ImmutableSortedSet<DocumentKey> h(int i4) {
        return this.f30683b.referencesForId(i4);
    }

    public boolean i(DocumentKey documentKey) {
        return this.f30683b.containsKey(documentKey);
    }

    public void j(Consumer<TargetData> consumer) {
        for (TargetData targetData : this.f30682a.values()) {
            consumer.accept(targetData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long k(LocalSerializer localSerializer) {
        long j4 = 0;
        for (Map.Entry<Target, TargetData> entry : this.f30682a.entrySet()) {
            j4 += localSerializer.k(entry.getValue()).getSerializedSize();
        }
        return j4;
    }

    public long l() {
        return this.f30686e;
    }

    public long m() {
        return this.f30682a.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n(long j4, SparseArray<?> sparseArray) {
        Iterator<Map.Entry<Target, TargetData>> it = this.f30682a.entrySet().iterator();
        int i4 = 0;
        while (it.hasNext()) {
            Map.Entry<Target, TargetData> next = it.next();
            int targetId = next.getValue().getTargetId();
            if (next.getValue().getSequenceNumber() <= j4 && sparseArray.get(targetId) == null) {
                it.remove();
                d(targetId);
                i4++;
            }
        }
        return i4;
    }

    public void o(TargetData targetData) {
        this.f30682a.remove(targetData.getTarget());
        this.f30683b.removeReferencesForId(targetData.getTargetId());
    }
}
