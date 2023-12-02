package com.google.firebase.firestore.model;

import com.google.firebase.firestore.model.FieldIndex;

/* loaded from: classes5.dex */
final class AutoValue_FieldIndex_IndexState extends FieldIndex.IndexState {

    /* renamed from: a  reason: collision with root package name */
    private final long f30939a;

    /* renamed from: b  reason: collision with root package name */
    private final FieldIndex.IndexOffset f30940b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_FieldIndex_IndexState(long j4, FieldIndex.IndexOffset indexOffset) {
        this.f30939a = j4;
        if (indexOffset != null) {
            this.f30940b = indexOffset;
            return;
        }
        throw new NullPointerException("Null offset");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FieldIndex.IndexState)) {
            return false;
        }
        FieldIndex.IndexState indexState = (FieldIndex.IndexState) obj;
        if (this.f30939a == indexState.getSequenceNumber() && this.f30940b.equals(indexState.getOffset())) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex.IndexState
    public FieldIndex.IndexOffset getOffset() {
        return this.f30940b;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex.IndexState
    public long getSequenceNumber() {
        return this.f30939a;
    }

    public int hashCode() {
        long j4 = this.f30939a;
        return this.f30940b.hashCode() ^ ((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003);
    }

    public String toString() {
        return "IndexState{sequenceNumber=" + this.f30939a + ", offset=" + this.f30940b + "}";
    }
}
