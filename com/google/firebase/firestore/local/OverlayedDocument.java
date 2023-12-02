package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.mutation.FieldMask;
import javax.annotation.Nullable;

/* loaded from: classes5.dex */
public class OverlayedDocument {

    /* renamed from: a  reason: collision with root package name */
    private Document f30688a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private FieldMask f30689b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OverlayedDocument(Document document, FieldMask fieldMask) {
        this.f30688a = document;
        this.f30689b = fieldMask;
    }

    public Document getDocument() {
        return this.f30688a;
    }

    @Nullable
    public FieldMask getMutatedFields() {
        return this.f30689b;
    }
}
