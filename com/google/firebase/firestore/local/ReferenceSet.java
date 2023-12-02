package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.model.DocumentKey;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes5.dex */
public class ReferenceSet {

    /* renamed from: a  reason: collision with root package name */
    private ImmutableSortedSet<DocumentReference> f30701a = new ImmutableSortedSet<>(Collections.emptyList(), DocumentReference.f30581c);

    /* renamed from: b  reason: collision with root package name */
    private ImmutableSortedSet<DocumentReference> f30702b = new ImmutableSortedSet<>(Collections.emptyList(), DocumentReference.f30582d);

    private void a(DocumentReference documentReference) {
        this.f30701a = this.f30701a.remove(documentReference);
        this.f30702b = this.f30702b.remove(documentReference);
    }

    public void addReference(DocumentKey documentKey, int i4) {
        DocumentReference documentReference = new DocumentReference(documentKey, i4);
        this.f30701a = this.f30701a.insert(documentReference);
        this.f30702b = this.f30702b.insert(documentReference);
    }

    public void addReferences(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i4) {
        Iterator<DocumentKey> it = immutableSortedSet.iterator();
        while (it.hasNext()) {
            addReference(it.next(), i4);
        }
    }

    public boolean containsKey(DocumentKey documentKey) {
        Iterator<DocumentReference> iteratorFrom = this.f30701a.iteratorFrom(new DocumentReference(documentKey, 0));
        if (!iteratorFrom.hasNext()) {
            return false;
        }
        return iteratorFrom.next().d().equals(documentKey);
    }

    public boolean isEmpty() {
        return this.f30701a.isEmpty();
    }

    public ImmutableSortedSet<DocumentKey> referencesForId(int i4) {
        Iterator<DocumentReference> iteratorFrom = this.f30702b.iteratorFrom(new DocumentReference(DocumentKey.empty(), i4));
        ImmutableSortedSet<DocumentKey> emptyKeySet = DocumentKey.emptyKeySet();
        while (iteratorFrom.hasNext()) {
            DocumentReference next = iteratorFrom.next();
            if (next.c() != i4) {
                break;
            }
            emptyKeySet = emptyKeySet.insert(next.d());
        }
        return emptyKeySet;
    }

    public void removeAllReferences() {
        Iterator<DocumentReference> it = this.f30701a.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public void removeReference(DocumentKey documentKey, int i4) {
        a(new DocumentReference(documentKey, i4));
    }

    public void removeReferences(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i4) {
        Iterator<DocumentKey> it = immutableSortedSet.iterator();
        while (it.hasNext()) {
            removeReference(it.next(), i4);
        }
    }

    public ImmutableSortedSet<DocumentKey> removeReferencesForId(int i4) {
        Iterator<DocumentReference> iteratorFrom = this.f30702b.iteratorFrom(new DocumentReference(DocumentKey.empty(), i4));
        ImmutableSortedSet<DocumentKey> emptyKeySet = DocumentKey.emptyKeySet();
        while (iteratorFrom.hasNext()) {
            DocumentReference next = iteratorFrom.next();
            if (next.c() != i4) {
                break;
            }
            emptyKeySet = emptyKeySet.insert(next.d());
            a(next);
        }
        return emptyKeySet;
    }
}
