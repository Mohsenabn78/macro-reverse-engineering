package com.google.firebase.firestore.model;

import com.google.firebase.Timestamp;

/* loaded from: classes5.dex */
public final class SnapshotVersion implements Comparable<SnapshotVersion> {
    public static final SnapshotVersion NONE = new SnapshotVersion(new Timestamp(0, 0));

    /* renamed from: a  reason: collision with root package name */
    private final Timestamp f30970a;

    public SnapshotVersion(Timestamp timestamp) {
        this.f30970a = timestamp;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof SnapshotVersion) && compareTo((SnapshotVersion) obj) == 0) {
            return true;
        }
        return false;
    }

    public Timestamp getTimestamp() {
        return this.f30970a;
    }

    public int hashCode() {
        return getTimestamp().hashCode();
    }

    public String toString() {
        return "SnapshotVersion(seconds=" + this.f30970a.getSeconds() + ", nanos=" + this.f30970a.getNanoseconds() + ")";
    }

    @Override // java.lang.Comparable
    public int compareTo(SnapshotVersion snapshotVersion) {
        return this.f30970a.compareTo(snapshotVersion.f30970a);
    }
}
