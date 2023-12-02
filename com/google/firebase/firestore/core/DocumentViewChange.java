package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;

/* loaded from: classes5.dex */
public class DocumentViewChange {

    /* renamed from: a  reason: collision with root package name */
    private final Type f30332a;

    /* renamed from: b  reason: collision with root package name */
    private final Document f30333b;

    /* loaded from: classes5.dex */
    public enum Type {
        REMOVED,
        ADDED,
        MODIFIED,
        METADATA
    }

    private DocumentViewChange(Type type, Document document) {
        this.f30332a = type;
        this.f30333b = document;
    }

    public static DocumentViewChange create(Type type, Document document) {
        return new DocumentViewChange(type, document);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DocumentViewChange)) {
            return false;
        }
        DocumentViewChange documentViewChange = (DocumentViewChange) obj;
        if (!this.f30332a.equals(documentViewChange.f30332a) || !this.f30333b.equals(documentViewChange.f30333b)) {
            return false;
        }
        return true;
    }

    public Document getDocument() {
        return this.f30333b;
    }

    public Type getType() {
        return this.f30332a;
    }

    public int hashCode() {
        return ((((1891 + this.f30332a.hashCode()) * 31) + this.f30333b.getKey().hashCode()) * 31) + this.f30333b.getData().hashCode();
    }

    public String toString() {
        return "DocumentViewChange(" + this.f30333b + "," + this.f30332a + ")";
    }
}
