package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.DocumentKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class MemoryEagerReferenceDelegate implements ReferenceDelegate {

    /* renamed from: a  reason: collision with root package name */
    private ReferenceSet f30651a;

    /* renamed from: b  reason: collision with root package name */
    private final MemoryPersistence f30652b;

    /* renamed from: c  reason: collision with root package name */
    private Set<DocumentKey> f30653c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MemoryEagerReferenceDelegate(MemoryPersistence memoryPersistence) {
        this.f30652b = memoryPersistence;
    }

    private boolean j(DocumentKey documentKey) {
        if (this.f30652b.g().i(documentKey) || k(documentKey)) {
            return true;
        }
        ReferenceSet referenceSet = this.f30651a;
        if (referenceSet != null && referenceSet.containsKey(documentKey)) {
            return true;
        }
        return false;
    }

    private boolean k(DocumentKey documentKey) {
        for (MemoryMutationQueue memoryMutationQueue : this.f30652b.k()) {
            if (memoryMutationQueue.k(documentKey)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void a(DocumentKey documentKey) {
        if (j(documentKey)) {
            this.f30653c.remove(documentKey);
        } else {
            this.f30653c.add(documentKey);
        }
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void b() {
        MemoryRemoteDocumentCache f4 = this.f30652b.f();
        ArrayList arrayList = new ArrayList();
        for (DocumentKey documentKey : this.f30653c) {
            if (!j(documentKey)) {
                arrayList.add(documentKey);
            }
        }
        f4.removeAll(arrayList);
        this.f30653c = null;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void c() {
        this.f30653c = new HashSet();
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void d(DocumentKey documentKey) {
        this.f30653c.add(documentKey);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public long e() {
        return -1L;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void f(TargetData targetData) {
        MemoryTargetCache g4 = this.f30652b.g();
        Iterator<DocumentKey> it = g4.h(targetData.getTargetId()).iterator();
        while (it.hasNext()) {
            this.f30653c.add(it.next());
        }
        g4.o(targetData);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void g(ReferenceSet referenceSet) {
        this.f30651a = referenceSet;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void h(DocumentKey documentKey) {
        this.f30653c.remove(documentKey);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void i(DocumentKey documentKey) {
        this.f30653c.add(documentKey);
    }
}
