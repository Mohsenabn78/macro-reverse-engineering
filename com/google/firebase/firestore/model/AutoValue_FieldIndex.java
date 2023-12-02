package com.google.firebase.firestore.model;

import com.google.firebase.firestore.model.FieldIndex;
import java.util.List;

/* loaded from: classes5.dex */
final class AutoValue_FieldIndex extends FieldIndex {

    /* renamed from: a  reason: collision with root package name */
    private final int f30932a;

    /* renamed from: b  reason: collision with root package name */
    private final String f30933b;

    /* renamed from: c  reason: collision with root package name */
    private final List<FieldIndex.Segment> f30934c;

    /* renamed from: d  reason: collision with root package name */
    private final FieldIndex.IndexState f30935d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_FieldIndex(int i4, String str, List<FieldIndex.Segment> list, FieldIndex.IndexState indexState) {
        this.f30932a = i4;
        if (str != null) {
            this.f30933b = str;
            if (list != null) {
                this.f30934c = list;
                if (indexState != null) {
                    this.f30935d = indexState;
                    return;
                }
                throw new NullPointerException("Null indexState");
            }
            throw new NullPointerException("Null segments");
        }
        throw new NullPointerException("Null collectionGroup");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FieldIndex)) {
            return false;
        }
        FieldIndex fieldIndex = (FieldIndex) obj;
        if (this.f30932a == fieldIndex.getIndexId() && this.f30933b.equals(fieldIndex.getCollectionGroup()) && this.f30934c.equals(fieldIndex.getSegments()) && this.f30935d.equals(fieldIndex.getIndexState())) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex
    public String getCollectionGroup() {
        return this.f30933b;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex
    public int getIndexId() {
        return this.f30932a;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex
    public FieldIndex.IndexState getIndexState() {
        return this.f30935d;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex
    public List<FieldIndex.Segment> getSegments() {
        return this.f30934c;
    }

    public int hashCode() {
        return ((((((this.f30932a ^ 1000003) * 1000003) ^ this.f30933b.hashCode()) * 1000003) ^ this.f30934c.hashCode()) * 1000003) ^ this.f30935d.hashCode();
    }

    public String toString() {
        return "FieldIndex{indexId=" + this.f30932a + ", collectionGroup=" + this.f30933b + ", segments=" + this.f30934c + ", indexState=" + this.f30935d + "}";
    }
}
