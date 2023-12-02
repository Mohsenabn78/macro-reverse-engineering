package com.google.firebase.firestore.bundle;

import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import java.util.List;

/* loaded from: classes5.dex */
public class BundledDocumentMetadata implements BundleElement {

    /* renamed from: a  reason: collision with root package name */
    private final DocumentKey f30291a;

    /* renamed from: b  reason: collision with root package name */
    private final SnapshotVersion f30292b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f30293c;

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f30294d;

    public BundledDocumentMetadata(DocumentKey documentKey, SnapshotVersion snapshotVersion, boolean z3, List<String> list) {
        this.f30291a = documentKey;
        this.f30292b = snapshotVersion;
        this.f30293c = z3;
        this.f30294d = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BundledDocumentMetadata bundledDocumentMetadata = (BundledDocumentMetadata) obj;
        if (this.f30293c != bundledDocumentMetadata.f30293c || !this.f30291a.equals(bundledDocumentMetadata.f30291a) || !this.f30292b.equals(bundledDocumentMetadata.f30292b)) {
            return false;
        }
        return this.f30294d.equals(bundledDocumentMetadata.f30294d);
    }

    public boolean exists() {
        return this.f30293c;
    }

    public DocumentKey getKey() {
        return this.f30291a;
    }

    public List<String> getQueries() {
        return this.f30294d;
    }

    public SnapshotVersion getReadTime() {
        return this.f30292b;
    }

    public int hashCode() {
        return (((((this.f30291a.hashCode() * 31) + this.f30292b.hashCode()) * 31) + (this.f30293c ? 1 : 0)) * 31) + this.f30294d.hashCode();
    }
}
