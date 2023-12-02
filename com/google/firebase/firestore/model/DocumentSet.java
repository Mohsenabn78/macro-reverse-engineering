package com.google.firebase.firestore.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class DocumentSet implements Iterable<Document> {

    /* renamed from: a  reason: collision with root package name */
    private final ImmutableSortedMap<DocumentKey, Document> f30950a;

    /* renamed from: b  reason: collision with root package name */
    private final ImmutableSortedSet<Document> f30951b;

    private DocumentSet(ImmutableSortedMap<DocumentKey, Document> immutableSortedMap, ImmutableSortedSet<Document> immutableSortedSet) {
        this.f30950a = immutableSortedMap;
        this.f30951b = immutableSortedSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b(Comparator comparator, Document document, Document document2) {
        int compare = comparator.compare(document, document2);
        if (compare == 0) {
            return Document.KEY_COMPARATOR.compare(document, document2);
        }
        return compare;
    }

    public static DocumentSet emptySet(final Comparator<Document> comparator) {
        return new DocumentSet(DocumentCollections.emptyDocumentMap(), new ImmutableSortedSet(Collections.emptyList(), new Comparator() { // from class: com.google.firebase.firestore.model.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int b4;
                b4 = DocumentSet.b(comparator, (Document) obj, (Document) obj2);
                return b4;
            }
        }));
    }

    public DocumentSet add(Document document) {
        DocumentSet remove = remove(document.getKey());
        return new DocumentSet(remove.f30950a.insert(document.getKey(), document), remove.f30951b.insert(document));
    }

    public boolean contains(DocumentKey documentKey) {
        return this.f30950a.containsKey(documentKey);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DocumentSet.class != obj.getClass()) {
            return false;
        }
        DocumentSet documentSet = (DocumentSet) obj;
        if (size() != documentSet.size()) {
            return false;
        }
        Iterator<Document> it = iterator();
        Iterator<Document> it2 = documentSet.iterator();
        while (it.hasNext()) {
            if (!it.next().equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public Document getDocument(DocumentKey documentKey) {
        return this.f30950a.get(documentKey);
    }

    @Nullable
    public Document getFirstDocument() {
        return this.f30951b.getMinEntry();
    }

    @Nullable
    public Document getLastDocument() {
        return this.f30951b.getMaxEntry();
    }

    @Nullable
    public Document getPredecessor(DocumentKey documentKey) {
        Document document = this.f30950a.get(documentKey);
        if (document != null) {
            return this.f30951b.getPredecessorEntry(document);
        }
        throw new IllegalArgumentException("Key not contained in DocumentSet: " + documentKey);
    }

    public int hashCode() {
        Iterator<Document> it = iterator();
        int i4 = 0;
        while (it.hasNext()) {
            Document next = it.next();
            i4 = (((i4 * 31) + next.getKey().hashCode()) * 31) + next.getData().hashCode();
        }
        return i4;
    }

    public int indexOf(DocumentKey documentKey) {
        Document document = this.f30950a.get(documentKey);
        if (document == null) {
            return -1;
        }
        return this.f30951b.indexOf(document);
    }

    public boolean isEmpty() {
        return this.f30950a.isEmpty();
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Document> iterator() {
        return this.f30951b.iterator();
    }

    public DocumentSet remove(DocumentKey documentKey) {
        Document document = this.f30950a.get(documentKey);
        if (document == null) {
            return this;
        }
        return new DocumentSet(this.f30950a.remove(documentKey), this.f30951b.remove(document));
    }

    public int size() {
        return this.f30950a.size();
    }

    public List<Document> toList() {
        ArrayList arrayList = new ArrayList(size());
        Iterator<Document> it = iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<Document> it = iterator();
        boolean z3 = true;
        while (it.hasNext()) {
            Document next = it.next();
            if (z3) {
                z3 = false;
            } else {
                sb.append(", ");
            }
            sb.append(next);
        }
        sb.append("]");
        return sb.toString();
    }
}
