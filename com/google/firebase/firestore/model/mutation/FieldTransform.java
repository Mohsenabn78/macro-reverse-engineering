package com.google.firebase.firestore.model.mutation;

import com.google.firebase.firestore.model.FieldPath;

/* loaded from: classes5.dex */
public final class FieldTransform {

    /* renamed from: a  reason: collision with root package name */
    private final FieldPath f30982a;

    /* renamed from: b  reason: collision with root package name */
    private final TransformOperation f30983b;

    public FieldTransform(FieldPath fieldPath, TransformOperation transformOperation) {
        this.f30982a = fieldPath;
        this.f30983b = transformOperation;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || FieldTransform.class != obj.getClass()) {
            return false;
        }
        FieldTransform fieldTransform = (FieldTransform) obj;
        if (!this.f30982a.equals(fieldTransform.f30982a)) {
            return false;
        }
        return this.f30983b.equals(fieldTransform.f30983b);
    }

    public FieldPath getFieldPath() {
        return this.f30982a;
    }

    public TransformOperation getOperation() {
        return this.f30983b;
    }

    public int hashCode() {
        return (this.f30982a.hashCode() * 31) + this.f30983b.hashCode();
    }
}
