package com.google.firebase.firestore.model;

import java.util.Comparator;

/* compiled from: Document.java */
/* loaded from: classes5.dex */
public final /* synthetic */ class b {
    static {
        Comparator<Document> comparator = Document.KEY_COMPARATOR;
    }

    public static /* synthetic */ int a(Document document, Document document2) {
        return document.getKey().compareTo(document2.getKey());
    }
}
