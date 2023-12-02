package com.google.firebase.firestore.core;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.DocumentSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class ViewSnapshot {

    /* renamed from: a  reason: collision with root package name */
    private final Query f30469a;

    /* renamed from: b  reason: collision with root package name */
    private final DocumentSet f30470b;

    /* renamed from: c  reason: collision with root package name */
    private final DocumentSet f30471c;

    /* renamed from: d  reason: collision with root package name */
    private final List<DocumentViewChange> f30472d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f30473e;

    /* renamed from: f  reason: collision with root package name */
    private final ImmutableSortedSet<DocumentKey> f30474f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f30475g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f30476h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f30477i;

    /* loaded from: classes5.dex */
    public enum SyncState {
        NONE,
        LOCAL,
        SYNCED
    }

    public ViewSnapshot(Query query, DocumentSet documentSet, DocumentSet documentSet2, List<DocumentViewChange> list, boolean z3, ImmutableSortedSet<DocumentKey> immutableSortedSet, boolean z4, boolean z5, boolean z6) {
        this.f30469a = query;
        this.f30470b = documentSet;
        this.f30471c = documentSet2;
        this.f30472d = list;
        this.f30473e = z3;
        this.f30474f = immutableSortedSet;
        this.f30475g = z4;
        this.f30476h = z5;
        this.f30477i = z6;
    }

    public static ViewSnapshot fromInitialDocuments(Query query, DocumentSet documentSet, ImmutableSortedSet<DocumentKey> immutableSortedSet, boolean z3, boolean z4, boolean z5) {
        ArrayList arrayList = new ArrayList();
        Iterator<Document> it = documentSet.iterator();
        while (it.hasNext()) {
            arrayList.add(DocumentViewChange.create(DocumentViewChange.Type.ADDED, it.next()));
        }
        return new ViewSnapshot(query, documentSet, DocumentSet.emptySet(query.comparator()), arrayList, z3, immutableSortedSet, true, z4, z5);
    }

    public boolean didSyncStateChange() {
        return this.f30475g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewSnapshot)) {
            return false;
        }
        ViewSnapshot viewSnapshot = (ViewSnapshot) obj;
        if (this.f30473e != viewSnapshot.f30473e || this.f30475g != viewSnapshot.f30475g || this.f30476h != viewSnapshot.f30476h || !this.f30469a.equals(viewSnapshot.f30469a) || !this.f30474f.equals(viewSnapshot.f30474f) || !this.f30470b.equals(viewSnapshot.f30470b) || !this.f30471c.equals(viewSnapshot.f30471c) || this.f30477i != viewSnapshot.f30477i) {
            return false;
        }
        return this.f30472d.equals(viewSnapshot.f30472d);
    }

    public boolean excludesMetadataChanges() {
        return this.f30476h;
    }

    public List<DocumentViewChange> getChanges() {
        return this.f30472d;
    }

    public DocumentSet getDocuments() {
        return this.f30470b;
    }

    public ImmutableSortedSet<DocumentKey> getMutatedKeys() {
        return this.f30474f;
    }

    public DocumentSet getOldDocuments() {
        return this.f30471c;
    }

    public Query getQuery() {
        return this.f30469a;
    }

    public boolean hasCachedResults() {
        return this.f30477i;
    }

    public boolean hasPendingWrites() {
        return !this.f30474f.isEmpty();
    }

    public int hashCode() {
        return (((((((((((((((this.f30469a.hashCode() * 31) + this.f30470b.hashCode()) * 31) + this.f30471c.hashCode()) * 31) + this.f30472d.hashCode()) * 31) + this.f30474f.hashCode()) * 31) + (this.f30473e ? 1 : 0)) * 31) + (this.f30475g ? 1 : 0)) * 31) + (this.f30476h ? 1 : 0)) * 31) + (this.f30477i ? 1 : 0);
    }

    public boolean isFromCache() {
        return this.f30473e;
    }

    public String toString() {
        return "ViewSnapshot(" + this.f30469a + ", " + this.f30470b + ", " + this.f30471c + ", " + this.f30472d + ", isFromCache=" + this.f30473e + ", mutatedKeys=" + this.f30474f.size() + ", didSyncStateChange=" + this.f30475g + ", excludesMetadataChanges=" + this.f30476h + ", hasCachedResults=" + this.f30477i + ")";
    }
}
