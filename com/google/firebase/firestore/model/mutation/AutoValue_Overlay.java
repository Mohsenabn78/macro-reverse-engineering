package com.google.firebase.firestore.model.mutation;

/* loaded from: classes5.dex */
final class AutoValue_Overlay extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    private final int f30979a;

    /* renamed from: b  reason: collision with root package name */
    private final Mutation f30980b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_Overlay(int i4, Mutation mutation) {
        this.f30979a = i4;
        if (mutation != null) {
            this.f30980b = mutation;
            return;
        }
        throw new NullPointerException("Null mutation");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Overlay)) {
            return false;
        }
        Overlay overlay = (Overlay) obj;
        if (this.f30979a == overlay.getLargestBatchId() && this.f30980b.equals(overlay.getMutation())) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.firestore.model.mutation.Overlay
    public int getLargestBatchId() {
        return this.f30979a;
    }

    @Override // com.google.firebase.firestore.model.mutation.Overlay
    public Mutation getMutation() {
        return this.f30980b;
    }

    public int hashCode() {
        return ((this.f30979a ^ 1000003) * 1000003) ^ this.f30980b.hashCode();
    }

    public String toString() {
        return "Overlay{largestBatchId=" + this.f30979a + ", mutation=" + this.f30980b + "}";
    }
}
