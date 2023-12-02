package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.DocumentKey;

/* loaded from: classes5.dex */
public class LimboDocumentChange {

    /* renamed from: a  reason: collision with root package name */
    private final Type f30364a;

    /* renamed from: b  reason: collision with root package name */
    private final DocumentKey f30365b;

    /* loaded from: classes5.dex */
    public enum Type {
        ADDED,
        REMOVED
    }

    public LimboDocumentChange(Type type, DocumentKey documentKey) {
        this.f30364a = type;
        this.f30365b = documentKey;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LimboDocumentChange)) {
            return false;
        }
        LimboDocumentChange limboDocumentChange = (LimboDocumentChange) obj;
        if (!this.f30364a.equals(limboDocumentChange.getType()) || !this.f30365b.equals(limboDocumentChange.getKey())) {
            return false;
        }
        return true;
    }

    public DocumentKey getKey() {
        return this.f30365b;
    }

    public Type getType() {
        return this.f30364a;
    }

    public int hashCode() {
        return ((2077 + this.f30364a.hashCode()) * 31) + this.f30365b.hashCode();
    }
}
