package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Util;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class DocumentReference {

    /* renamed from: c  reason: collision with root package name */
    static final Comparator<DocumentReference> f30581c = new Comparator() { // from class: com.google.firebase.firestore.local.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int e4;
            e4 = DocumentReference.e((DocumentReference) obj, (DocumentReference) obj2);
            return e4;
        }
    };

    /* renamed from: d  reason: collision with root package name */
    static final Comparator<DocumentReference> f30582d = new Comparator() { // from class: com.google.firebase.firestore.local.b
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int f4;
            f4 = DocumentReference.f((DocumentReference) obj, (DocumentReference) obj2);
            return f4;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final DocumentKey f30583a;

    /* renamed from: b  reason: collision with root package name */
    private final int f30584b;

    public DocumentReference(DocumentKey documentKey, int i4) {
        this.f30583a = documentKey;
        this.f30584b = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int e(DocumentReference documentReference, DocumentReference documentReference2) {
        int compareTo = documentReference.f30583a.compareTo(documentReference2.f30583a);
        if (compareTo != 0) {
            return compareTo;
        }
        return Util.compareIntegers(documentReference.f30584b, documentReference2.f30584b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int f(DocumentReference documentReference, DocumentReference documentReference2) {
        int compareIntegers = Util.compareIntegers(documentReference.f30584b, documentReference2.f30584b);
        if (compareIntegers != 0) {
            return compareIntegers;
        }
        return documentReference.f30583a.compareTo(documentReference2.f30583a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f30584b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DocumentKey d() {
        return this.f30583a;
    }
}
