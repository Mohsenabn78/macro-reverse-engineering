package com.google.firebase.firestore.model;

import com.google.firebase.firestore.model.FieldIndex;

/* loaded from: classes5.dex */
final class AutoValue_FieldIndex_Segment extends FieldIndex.Segment {

    /* renamed from: a  reason: collision with root package name */
    private final FieldPath f30941a;

    /* renamed from: b  reason: collision with root package name */
    private final FieldIndex.Segment.Kind f30942b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_FieldIndex_Segment(FieldPath fieldPath, FieldIndex.Segment.Kind kind) {
        if (fieldPath != null) {
            this.f30941a = fieldPath;
            if (kind != null) {
                this.f30942b = kind;
                return;
            }
            throw new NullPointerException("Null kind");
        }
        throw new NullPointerException("Null fieldPath");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FieldIndex.Segment)) {
            return false;
        }
        FieldIndex.Segment segment = (FieldIndex.Segment) obj;
        if (this.f30941a.equals(segment.getFieldPath()) && this.f30942b.equals(segment.getKind())) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex.Segment
    public FieldPath getFieldPath() {
        return this.f30941a;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex.Segment
    public FieldIndex.Segment.Kind getKind() {
        return this.f30942b;
    }

    public int hashCode() {
        return ((this.f30941a.hashCode() ^ 1000003) * 1000003) ^ this.f30942b.hashCode();
    }

    public String toString() {
        return "Segment{fieldPath=" + this.f30941a + ", kind=" + this.f30942b + "}";
    }
}
