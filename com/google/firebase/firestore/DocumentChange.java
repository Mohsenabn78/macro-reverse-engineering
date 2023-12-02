package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentSet;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class DocumentChange {

    /* renamed from: a  reason: collision with root package name */
    private final Type f30132a;

    /* renamed from: b  reason: collision with root package name */
    private final QueryDocumentSnapshot f30133b;

    /* renamed from: c  reason: collision with root package name */
    private final int f30134c;

    /* renamed from: d  reason: collision with root package name */
    private final int f30135d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.DocumentChange$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30136a;

        static {
            int[] iArr = new int[DocumentViewChange.Type.values().length];
            f30136a = iArr;
            try {
                iArr[DocumentViewChange.Type.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30136a[DocumentViewChange.Type.METADATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30136a[DocumentViewChange.Type.MODIFIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30136a[DocumentViewChange.Type.REMOVED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum Type {
        ADDED,
        MODIFIED,
        REMOVED
    }

    @VisibleForTesting
    DocumentChange(QueryDocumentSnapshot queryDocumentSnapshot, Type type, int i4, int i5) {
        this.f30132a = type;
        this.f30133b = queryDocumentSnapshot;
        this.f30134c = i4;
        this.f30135d = i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<DocumentChange> a(FirebaseFirestore firebaseFirestore, MetadataChanges metadataChanges, ViewSnapshot viewSnapshot) {
        int i4;
        int i5;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        ArrayList arrayList = new ArrayList();
        if (viewSnapshot.getOldDocuments().isEmpty()) {
            Document document = null;
            int i6 = 0;
            for (DocumentViewChange documentViewChange : viewSnapshot.getChanges()) {
                Document document2 = documentViewChange.getDocument();
                QueryDocumentSnapshot g4 = QueryDocumentSnapshot.g(firebaseFirestore, document2, viewSnapshot.isFromCache(), viewSnapshot.getMutatedKeys().contains(document2.getKey()));
                if (documentViewChange.getType() == DocumentViewChange.Type.ADDED) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Assert.hardAssert(z5, "Invalid added event for first snapshot", new Object[0]);
                if (document != null && viewSnapshot.getQuery().comparator().compare(document, document2) >= 0) {
                    z6 = false;
                } else {
                    z6 = true;
                }
                Assert.hardAssert(z6, "Got added events in wrong order", new Object[0]);
                arrayList.add(new DocumentChange(g4, Type.ADDED, -1, i6));
                document = document2;
                i6++;
            }
        } else {
            DocumentSet oldDocuments = viewSnapshot.getOldDocuments();
            for (DocumentViewChange documentViewChange2 : viewSnapshot.getChanges()) {
                if (metadataChanges != MetadataChanges.EXCLUDE || documentViewChange2.getType() != DocumentViewChange.Type.METADATA) {
                    Document document3 = documentViewChange2.getDocument();
                    QueryDocumentSnapshot g5 = QueryDocumentSnapshot.g(firebaseFirestore, document3, viewSnapshot.isFromCache(), viewSnapshot.getMutatedKeys().contains(document3.getKey()));
                    Type b4 = b(documentViewChange2);
                    if (b4 != Type.ADDED) {
                        i4 = oldDocuments.indexOf(document3.getKey());
                        if (i4 >= 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        Assert.hardAssert(z4, "Index for document not found", new Object[0]);
                        oldDocuments = oldDocuments.remove(document3.getKey());
                    } else {
                        i4 = -1;
                    }
                    if (b4 != Type.REMOVED) {
                        oldDocuments = oldDocuments.add(document3);
                        i5 = oldDocuments.indexOf(document3.getKey());
                        if (i5 >= 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        Assert.hardAssert(z3, "Index for document not found", new Object[0]);
                    } else {
                        i5 = -1;
                    }
                    arrayList.add(new DocumentChange(g5, b4, i4, i5));
                }
            }
        }
        return arrayList;
    }

    private static Type b(DocumentViewChange documentViewChange) {
        int i4 = AnonymousClass1.f30136a[documentViewChange.getType().ordinal()];
        if (i4 != 1) {
            if (i4 != 2 && i4 != 3) {
                if (i4 == 4) {
                    return Type.REMOVED;
                }
                throw new IllegalArgumentException("Unknown view change type: " + documentViewChange.getType());
            }
            return Type.MODIFIED;
        }
        return Type.ADDED;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof DocumentChange)) {
            return false;
        }
        DocumentChange documentChange = (DocumentChange) obj;
        if (!this.f30132a.equals(documentChange.f30132a) || !this.f30133b.equals(documentChange.f30133b) || this.f30134c != documentChange.f30134c || this.f30135d != documentChange.f30135d) {
            return false;
        }
        return true;
    }

    @NonNull
    public QueryDocumentSnapshot getDocument() {
        return this.f30133b;
    }

    public int getNewIndex() {
        return this.f30135d;
    }

    public int getOldIndex() {
        return this.f30134c;
    }

    @NonNull
    public Type getType() {
        return this.f30132a;
    }

    public int hashCode() {
        return (((((this.f30132a.hashCode() * 31) + this.f30133b.hashCode()) * 31) + this.f30134c) * 31) + this.f30135d;
    }
}
