package com.google.firebase.firestore.bundle;

import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;

/* loaded from: classes5.dex */
public class BundleDocument implements BundleElement {

    /* renamed from: a  reason: collision with root package name */
    private MutableDocument f30269a;

    public BundleDocument(MutableDocument mutableDocument) {
        this.f30269a = mutableDocument;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.f30269a.equals(((BundleDocument) obj).f30269a);
        }
        return false;
    }

    public MutableDocument getDocument() {
        return this.f30269a;
    }

    public DocumentKey getKey() {
        return this.f30269a.getKey();
    }

    public int hashCode() {
        return this.f30269a.hashCode();
    }
}
