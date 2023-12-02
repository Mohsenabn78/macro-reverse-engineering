package com.google.firebase.firestore.model;

import com.google.firebase.firestore.model.FieldIndex;

/* loaded from: classes5.dex */
final class AutoValue_FieldIndex_IndexOffset extends FieldIndex.IndexOffset {

    /* renamed from: a  reason: collision with root package name */
    private final SnapshotVersion f30936a;

    /* renamed from: b  reason: collision with root package name */
    private final DocumentKey f30937b;

    /* renamed from: c  reason: collision with root package name */
    private final int f30938c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_FieldIndex_IndexOffset(SnapshotVersion snapshotVersion, DocumentKey documentKey, int i4) {
        if (snapshotVersion != null) {
            this.f30936a = snapshotVersion;
            if (documentKey != null) {
                this.f30937b = documentKey;
                this.f30938c = i4;
                return;
            }
            throw new NullPointerException("Null documentKey");
        }
        throw new NullPointerException("Null readTime");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FieldIndex.IndexOffset)) {
            return false;
        }
        FieldIndex.IndexOffset indexOffset = (FieldIndex.IndexOffset) obj;
        if (this.f30936a.equals(indexOffset.getReadTime()) && this.f30937b.equals(indexOffset.getDocumentKey()) && this.f30938c == indexOffset.getLargestBatchId()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex.IndexOffset
    public DocumentKey getDocumentKey() {
        return this.f30937b;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex.IndexOffset
    public int getLargestBatchId() {
        return this.f30938c;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex.IndexOffset
    public SnapshotVersion getReadTime() {
        return this.f30936a;
    }

    public int hashCode() {
        return ((((this.f30936a.hashCode() ^ 1000003) * 1000003) ^ this.f30937b.hashCode()) * 1000003) ^ this.f30938c;
    }

    public String toString() {
        return "IndexOffset{readTime=" + this.f30936a + ", documentKey=" + this.f30937b + ", largestBatchId=" + this.f30938c + "}";
    }
}
