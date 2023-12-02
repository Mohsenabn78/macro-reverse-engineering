package com.google.firebase.firestore.core;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.core.LimboDocumentChange;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.DocumentSet;
import com.google.firebase.firestore.remote.TargetChange;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class View {

    /* renamed from: a  reason: collision with root package name */
    private final Query f30455a;

    /* renamed from: c  reason: collision with root package name */
    private boolean f30457c;

    /* renamed from: d  reason: collision with root package name */
    private DocumentSet f30458d;

    /* renamed from: e  reason: collision with root package name */
    private ImmutableSortedSet<DocumentKey> f30459e;

    /* renamed from: b  reason: collision with root package name */
    private ViewSnapshot.SyncState f30456b = ViewSnapshot.SyncState.NONE;

    /* renamed from: f  reason: collision with root package name */
    private ImmutableSortedSet<DocumentKey> f30460f = DocumentKey.emptyKeySet();

    /* renamed from: g  reason: collision with root package name */
    private ImmutableSortedSet<DocumentKey> f30461g = DocumentKey.emptyKeySet();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.core.View$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30462a;

        static {
            int[] iArr = new int[DocumentViewChange.Type.values().length];
            f30462a = iArr;
            try {
                iArr[DocumentViewChange.Type.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30462a[DocumentViewChange.Type.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30462a[DocumentViewChange.Type.METADATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30462a[DocumentViewChange.Type.REMOVED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class DocumentChanges {

        /* renamed from: a  reason: collision with root package name */
        final DocumentSet f30463a;

        /* renamed from: b  reason: collision with root package name */
        final DocumentViewChangeSet f30464b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f30465c;

        /* renamed from: d  reason: collision with root package name */
        final ImmutableSortedSet<DocumentKey> f30466d;

        /* synthetic */ DocumentChanges(DocumentSet documentSet, DocumentViewChangeSet documentViewChangeSet, ImmutableSortedSet immutableSortedSet, boolean z3, AnonymousClass1 anonymousClass1) {
            this(documentSet, documentViewChangeSet, immutableSortedSet, z3);
        }

        public boolean needsRefill() {
            return this.f30465c;
        }

        private DocumentChanges(DocumentSet documentSet, DocumentViewChangeSet documentViewChangeSet, ImmutableSortedSet<DocumentKey> immutableSortedSet, boolean z3) {
            this.f30463a = documentSet;
            this.f30464b = documentViewChangeSet;
            this.f30466d = immutableSortedSet;
            this.f30465c = z3;
        }
    }

    public View(Query query, ImmutableSortedSet<DocumentKey> immutableSortedSet) {
        this.f30455a = query;
        this.f30458d = DocumentSet.emptySet(query.comparator());
        this.f30459e = immutableSortedSet;
    }

    private void b(TargetChange targetChange) {
        if (targetChange != null) {
            Iterator<DocumentKey> it = targetChange.getAddedDocuments().iterator();
            while (it.hasNext()) {
                this.f30459e = this.f30459e.insert(it.next());
            }
            Iterator<DocumentKey> it2 = targetChange.getModifiedDocuments().iterator();
            while (it2.hasNext()) {
                DocumentKey next = it2.next();
                Assert.hardAssert(this.f30459e.contains(next), "Modified document %s not found in view.", next);
            }
            Iterator<DocumentKey> it3 = targetChange.getRemovedDocuments().iterator();
            while (it3.hasNext()) {
                this.f30459e = this.f30459e.remove(it3.next());
            }
            this.f30457c = targetChange.isCurrent();
        }
    }

    private static int c(DocumentViewChange documentViewChange) {
        int i4 = AnonymousClass1.f30462a[documentViewChange.getType().ordinal()];
        int i5 = 1;
        if (i4 != 1) {
            i5 = 2;
            if (i4 != 2 && i4 != 3) {
                if (i4 == 4) {
                    return 0;
                }
                throw new IllegalArgumentException("Unknown change type: " + documentViewChange.getType());
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int e(DocumentViewChange documentViewChange, DocumentViewChange documentViewChange2) {
        int compareIntegers = Util.compareIntegers(c(documentViewChange), c(documentViewChange2));
        if (compareIntegers != 0) {
            return compareIntegers;
        }
        return this.f30455a.comparator().compare(documentViewChange.getDocument(), documentViewChange2.getDocument());
    }

    private boolean f(DocumentKey documentKey) {
        Document document;
        if (this.f30459e.contains(documentKey) || (document = this.f30458d.getDocument(documentKey)) == null || document.hasLocalMutations()) {
            return false;
        }
        return true;
    }

    private boolean g(Document document, Document document2) {
        if (document.hasLocalMutations() && document2.hasCommittedMutations() && !document2.hasLocalMutations()) {
            return true;
        }
        return false;
    }

    private List<LimboDocumentChange> h() {
        if (!this.f30457c) {
            return Collections.emptyList();
        }
        ImmutableSortedSet<DocumentKey> immutableSortedSet = this.f30460f;
        this.f30460f = DocumentKey.emptyKeySet();
        Iterator<Document> it = this.f30458d.iterator();
        while (it.hasNext()) {
            Document next = it.next();
            if (f(next.getKey())) {
                this.f30460f = this.f30460f.insert(next.getKey());
            }
        }
        ArrayList arrayList = new ArrayList(immutableSortedSet.size() + this.f30460f.size());
        Iterator<DocumentKey> it2 = immutableSortedSet.iterator();
        while (it2.hasNext()) {
            DocumentKey next2 = it2.next();
            if (!this.f30460f.contains(next2)) {
                arrayList.add(new LimboDocumentChange(LimboDocumentChange.Type.REMOVED, next2));
            }
        }
        Iterator<DocumentKey> it3 = this.f30460f.iterator();
        while (it3.hasNext()) {
            DocumentKey next3 = it3.next();
            if (!immutableSortedSet.contains(next3)) {
                arrayList.add(new LimboDocumentChange(LimboDocumentChange.Type.ADDED, next3));
            }
        }
        return arrayList;
    }

    public ViewChange applyChanges(DocumentChanges documentChanges) {
        return applyChanges(documentChanges, null);
    }

    public ViewChange applyOnlineStateChange(OnlineState onlineState) {
        if (this.f30457c && onlineState == OnlineState.OFFLINE) {
            this.f30457c = false;
            return applyChanges(new DocumentChanges(this.f30458d, new DocumentViewChangeSet(), this.f30461g, false, null));
        }
        return new ViewChange(null, Collections.emptyList());
    }

    public DocumentChanges computeDocChanges(ImmutableSortedMap<DocumentKey, Document> immutableSortedMap) {
        return computeDocChanges(immutableSortedMap, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSortedSet<DocumentKey> d() {
        return this.f30459e;
    }

    public ViewSnapshot.SyncState getSyncState() {
        return this.f30456b;
    }

    public ViewChange applyChanges(DocumentChanges documentChanges, TargetChange targetChange) {
        ViewSnapshot viewSnapshot;
        Assert.hardAssert(!documentChanges.f30465c, "Cannot apply changes that need a refill", new Object[0]);
        DocumentSet documentSet = this.f30458d;
        this.f30458d = documentChanges.f30463a;
        this.f30461g = documentChanges.f30466d;
        List<DocumentViewChange> a4 = documentChanges.f30464b.a();
        Collections.sort(a4, new Comparator() { // from class: com.google.firebase.firestore.core.j0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int e4;
                e4 = View.this.e((DocumentViewChange) obj, (DocumentViewChange) obj2);
                return e4;
            }
        });
        b(targetChange);
        List<LimboDocumentChange> h4 = h();
        ViewSnapshot.SyncState syncState = this.f30460f.size() == 0 && this.f30457c ? ViewSnapshot.SyncState.SYNCED : ViewSnapshot.SyncState.LOCAL;
        boolean z3 = syncState != this.f30456b;
        this.f30456b = syncState;
        if (a4.size() != 0 || z3) {
            viewSnapshot = new ViewSnapshot(this.f30455a, documentChanges.f30463a, documentSet, a4, syncState == ViewSnapshot.SyncState.LOCAL, documentChanges.f30466d, z3, false, (targetChange == null || targetChange.getResumeToken().isEmpty()) ? false : true);
        } else {
            viewSnapshot = null;
        }
        return new ViewChange(viewSnapshot, h4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f4, code lost:
        if (r18.f30455a.comparator().compare(r6, r4) > 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0102, code lost:
        if (r18.f30455a.comparator().compare(r6, r7) < 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0131, code lost:
        if (r7 == null) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.firebase.firestore.core.View.DocumentChanges computeDocChanges(com.google.firebase.database.collection.ImmutableSortedMap<com.google.firebase.firestore.model.DocumentKey, com.google.firebase.firestore.model.Document> r19, @androidx.annotation.Nullable com.google.firebase.firestore.core.View.DocumentChanges r20) {
        /*
            Method dump skipped, instructions count: 459
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.core.View.computeDocChanges(com.google.firebase.database.collection.ImmutableSortedMap, com.google.firebase.firestore.core.View$DocumentChanges):com.google.firebase.firestore.core.View$DocumentChanges");
    }
}
