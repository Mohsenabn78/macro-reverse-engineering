package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class QuerySnapshot implements Iterable<QueryDocumentSnapshot> {

    /* renamed from: a  reason: collision with root package name */
    private final Query f30221a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewSnapshot f30222b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseFirestore f30223c;

    /* renamed from: d  reason: collision with root package name */
    private List<DocumentChange> f30224d;

    /* renamed from: e  reason: collision with root package name */
    private MetadataChanges f30225e;

    /* renamed from: f  reason: collision with root package name */
    private final SnapshotMetadata f30226f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class QuerySnapshotIterator implements Iterator<QueryDocumentSnapshot> {

        /* renamed from: a  reason: collision with root package name */
        private final Iterator<Document> f30227a;

        QuerySnapshotIterator(Iterator<Document> it) {
            this.f30227a = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public QueryDocumentSnapshot next() {
            return QuerySnapshot.this.b(this.f30227a.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30227a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("QuerySnapshot does not support remove().");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QuerySnapshot(Query query, ViewSnapshot viewSnapshot, FirebaseFirestore firebaseFirestore) {
        this.f30221a = (Query) Preconditions.checkNotNull(query);
        this.f30222b = (ViewSnapshot) Preconditions.checkNotNull(viewSnapshot);
        this.f30223c = (FirebaseFirestore) Preconditions.checkNotNull(firebaseFirestore);
        this.f30226f = new SnapshotMetadata(viewSnapshot.hasPendingWrites(), viewSnapshot.isFromCache());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QueryDocumentSnapshot b(Document document) {
        return QueryDocumentSnapshot.g(this.f30223c, document, this.f30222b.isFromCache(), this.f30222b.getMutatedKeys().contains(document.getKey()));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuerySnapshot)) {
            return false;
        }
        QuerySnapshot querySnapshot = (QuerySnapshot) obj;
        if (this.f30223c.equals(querySnapshot.f30223c) && this.f30221a.equals(querySnapshot.f30221a) && this.f30222b.equals(querySnapshot.f30222b) && this.f30226f.equals(querySnapshot.f30226f)) {
            return true;
        }
        return false;
    }

    @NonNull
    public List<DocumentChange> getDocumentChanges() {
        return getDocumentChanges(MetadataChanges.EXCLUDE);
    }

    @NonNull
    public List<DocumentSnapshot> getDocuments() {
        ArrayList arrayList = new ArrayList(this.f30222b.getDocuments().size());
        Iterator<Document> it = this.f30222b.getDocuments().iterator();
        while (it.hasNext()) {
            arrayList.add(b(it.next()));
        }
        return arrayList;
    }

    @NonNull
    public SnapshotMetadata getMetadata() {
        return this.f30226f;
    }

    @NonNull
    public Query getQuery() {
        return this.f30221a;
    }

    public int hashCode() {
        return (((((this.f30223c.hashCode() * 31) + this.f30221a.hashCode()) * 31) + this.f30222b.hashCode()) * 31) + this.f30226f.hashCode();
    }

    public boolean isEmpty() {
        return this.f30222b.getDocuments().isEmpty();
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<QueryDocumentSnapshot> iterator() {
        return new QuerySnapshotIterator(this.f30222b.getDocuments().iterator());
    }

    public int size() {
        return this.f30222b.getDocuments().size();
    }

    @NonNull
    public <T> List<T> toObjects(@NonNull Class<T> cls) {
        return toObjects(cls, DocumentSnapshot.ServerTimestampBehavior.f30144a);
    }

    @NonNull
    public List<DocumentChange> getDocumentChanges(@NonNull MetadataChanges metadataChanges) {
        if (MetadataChanges.INCLUDE.equals(metadataChanges) && this.f30222b.excludesMetadataChanges()) {
            throw new IllegalArgumentException("To include metadata changes with your document changes, you must also pass MetadataChanges.INCLUDE to addSnapshotListener().");
        }
        if (this.f30224d == null || this.f30225e != metadataChanges) {
            this.f30224d = Collections.unmodifiableList(DocumentChange.a(this.f30223c, metadataChanges, this.f30222b));
            this.f30225e = metadataChanges;
        }
        return this.f30224d;
    }

    @NonNull
    public <T> List<T> toObjects(@NonNull Class<T> cls, @NonNull DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        Preconditions.checkNotNull(cls, "Provided POJO type must not be null.");
        ArrayList arrayList = new ArrayList();
        Iterator<QueryDocumentSnapshot> it = iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toObject(cls, serverTimestampBehavior));
        }
        return arrayList;
    }
}
