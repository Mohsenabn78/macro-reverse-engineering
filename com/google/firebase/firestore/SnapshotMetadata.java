package com.google.firebase.firestore;

import androidx.annotation.Nullable;

/* loaded from: classes5.dex */
public class SnapshotMetadata {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f30233a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f30234b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SnapshotMetadata(boolean z3, boolean z4) {
        this.f30233a = z3;
        this.f30234b = z4;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SnapshotMetadata)) {
            return false;
        }
        SnapshotMetadata snapshotMetadata = (SnapshotMetadata) obj;
        if (this.f30233a == snapshotMetadata.f30233a && this.f30234b == snapshotMetadata.f30234b) {
            return true;
        }
        return false;
    }

    public boolean hasPendingWrites() {
        return this.f30233a;
    }

    public int hashCode() {
        return ((this.f30233a ? 1 : 0) * 31) + (this.f30234b ? 1 : 0);
    }

    public boolean isFromCache() {
        return this.f30234b;
    }

    public String toString() {
        return "SnapshotMetadata{hasPendingWrites=" + this.f30233a + ", isFromCache=" + this.f30234b + '}';
    }
}
