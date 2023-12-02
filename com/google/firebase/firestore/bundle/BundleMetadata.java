package com.google.firebase.firestore.bundle;

import com.google.firebase.firestore.model.SnapshotVersion;

/* loaded from: classes5.dex */
public class BundleMetadata implements BundleElement {

    /* renamed from: a  reason: collision with root package name */
    private final String f30277a;

    /* renamed from: b  reason: collision with root package name */
    private final int f30278b;

    /* renamed from: c  reason: collision with root package name */
    private final SnapshotVersion f30279c;

    /* renamed from: d  reason: collision with root package name */
    private final int f30280d;

    /* renamed from: e  reason: collision with root package name */
    private final long f30281e;

    public BundleMetadata(String str, int i4, SnapshotVersion snapshotVersion, int i5, long j4) {
        this.f30277a = str;
        this.f30278b = i4;
        this.f30279c = snapshotVersion;
        this.f30280d = i5;
        this.f30281e = j4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BundleMetadata bundleMetadata = (BundleMetadata) obj;
        if (this.f30278b != bundleMetadata.f30278b || this.f30280d != bundleMetadata.f30280d || this.f30281e != bundleMetadata.f30281e || !this.f30277a.equals(bundleMetadata.f30277a)) {
            return false;
        }
        return this.f30279c.equals(bundleMetadata.f30279c);
    }

    public String getBundleId() {
        return this.f30277a;
    }

    public SnapshotVersion getCreateTime() {
        return this.f30279c;
    }

    public int getSchemaVersion() {
        return this.f30278b;
    }

    public long getTotalBytes() {
        return this.f30281e;
    }

    public int getTotalDocuments() {
        return this.f30280d;
    }

    public int hashCode() {
        long j4 = this.f30281e;
        return (((((((this.f30277a.hashCode() * 31) + this.f30278b) * 31) + this.f30280d) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.f30279c.hashCode();
    }
}
