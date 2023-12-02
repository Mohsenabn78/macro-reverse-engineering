package com.google.firebase.firestore.local;

import android.util.SparseArray;
import com.google.firebase.firestore.core.ListenSequence;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class MemoryLruReferenceDelegate implements ReferenceDelegate, LruDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final MemoryPersistence f30656a;

    /* renamed from: b  reason: collision with root package name */
    private final LocalSerializer f30657b;

    /* renamed from: d  reason: collision with root package name */
    private ReferenceSet f30659d;

    /* renamed from: e  reason: collision with root package name */
    private final LruGarbageCollector f30660e;

    /* renamed from: f  reason: collision with root package name */
    private final ListenSequence f30661f;

    /* renamed from: c  reason: collision with root package name */
    private final Map<DocumentKey, Long> f30658c = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private long f30662g = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MemoryLruReferenceDelegate(MemoryPersistence memoryPersistence, LruGarbageCollector.Params params, LocalSerializer localSerializer) {
        this.f30656a = memoryPersistence;
        this.f30657b = localSerializer;
        this.f30661f = new ListenSequence(memoryPersistence.g().l());
        this.f30660e = new LruGarbageCollector(this, params);
    }

    private boolean k(DocumentKey documentKey, long j4) {
        if (m(documentKey) || this.f30659d.containsKey(documentKey) || this.f30656a.g().i(documentKey)) {
            return true;
        }
        Long l4 = this.f30658c.get(documentKey);
        if (l4 != null && l4.longValue() > j4) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(long[] jArr, Long l4) {
        jArr[0] = jArr[0] + 1;
    }

    private boolean m(DocumentKey documentKey) {
        for (MemoryMutationQueue memoryMutationQueue : this.f30656a.k()) {
            if (memoryMutationQueue.k(documentKey)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void a(DocumentKey documentKey) {
        this.f30658c.put(documentKey, Long.valueOf(e()));
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void b() {
        boolean z3;
        if (this.f30662g != -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Committing a transaction without having started one", new Object[0]);
        this.f30662g = -1L;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void c() {
        boolean z3;
        if (this.f30662g == -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Starting a transaction without committing the previous one", new Object[0]);
        this.f30662g = this.f30661f.next();
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void d(DocumentKey documentKey) {
        this.f30658c.put(documentKey, Long.valueOf(e()));
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public long e() {
        boolean z3;
        if (this.f30662g != -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Attempting to get a sequence number outside of a transaction", new Object[0]);
        return this.f30662g;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void f(TargetData targetData) {
        this.f30656a.g().e(targetData.withSequenceNumber(e()));
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public void forEachOrphanedDocumentSequenceNumber(Consumer<Long> consumer) {
        for (Map.Entry<DocumentKey, Long> entry : this.f30658c.entrySet()) {
            if (!k(entry.getKey(), entry.getValue().longValue())) {
                consumer.accept(entry.getValue());
            }
        }
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public void forEachTarget(Consumer<TargetData> consumer) {
        this.f30656a.g().j(consumer);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void g(ReferenceSet referenceSet) {
        this.f30659d = referenceSet;
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public long getByteSize() {
        long k4 = this.f30656a.g().k(this.f30657b) + 0 + this.f30656a.f().g(this.f30657b);
        for (MemoryMutationQueue memoryMutationQueue : this.f30656a.k()) {
            k4 += memoryMutationQueue.l(this.f30657b);
        }
        return k4;
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public LruGarbageCollector getGarbageCollector() {
        return this.f30660e;
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public long getSequenceNumberCount() {
        long m4 = this.f30656a.g().m();
        final long[] jArr = new long[1];
        forEachOrphanedDocumentSequenceNumber(new Consumer() { // from class: com.google.firebase.firestore.local.e0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                MemoryLruReferenceDelegate.l(jArr, (Long) obj);
            }
        });
        return m4 + jArr[0];
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void h(DocumentKey documentKey) {
        this.f30658c.put(documentKey, Long.valueOf(e()));
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void i(DocumentKey documentKey) {
        this.f30658c.put(documentKey, Long.valueOf(e()));
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public int removeOrphanedDocuments(long j4) {
        MemoryRemoteDocumentCache f4 = this.f30656a.f();
        ArrayList arrayList = new ArrayList();
        for (Document document : f4.h()) {
            DocumentKey key = document.getKey();
            if (!k(key, j4)) {
                arrayList.add(key);
                this.f30658c.remove(key);
            }
        }
        f4.removeAll(arrayList);
        return arrayList.size();
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public int removeTargets(long j4, SparseArray<?> sparseArray) {
        return this.f30656a.g().n(j4, sparseArray);
    }
}
