package com.google.firebase.firestore.bundle;

import com.google.firebase.firestore.model.SnapshotVersion;

/* loaded from: classes5.dex */
public class NamedQuery implements BundleElement {

    /* renamed from: a  reason: collision with root package name */
    private final String f30297a;

    /* renamed from: b  reason: collision with root package name */
    private final BundledQuery f30298b;

    /* renamed from: c  reason: collision with root package name */
    private final SnapshotVersion f30299c;

    public NamedQuery(String str, BundledQuery bundledQuery, SnapshotVersion snapshotVersion) {
        this.f30297a = str;
        this.f30298b = bundledQuery;
        this.f30299c = snapshotVersion;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NamedQuery namedQuery = (NamedQuery) obj;
        if (!this.f30297a.equals(namedQuery.f30297a) || !this.f30298b.equals(namedQuery.f30298b)) {
            return false;
        }
        return this.f30299c.equals(namedQuery.f30299c);
    }

    public BundledQuery getBundledQuery() {
        return this.f30298b;
    }

    public String getName() {
        return this.f30297a;
    }

    public SnapshotVersion getReadTime() {
        return this.f30299c;
    }

    public int hashCode() {
        return (((this.f30297a.hashCode() * 31) + this.f30298b.hashCode()) * 31) + this.f30299c.hashCode();
    }
}
