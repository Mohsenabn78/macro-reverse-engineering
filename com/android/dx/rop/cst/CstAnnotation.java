package com.android.dx.rop.cst;

import com.android.dx.rop.annotation.Annotation;

/* loaded from: classes2.dex */
public final class CstAnnotation extends Constant {
    private final Annotation annotation;

    public CstAnnotation(Annotation annotation) {
        if (annotation != null) {
            annotation.throwIfMutable();
            this.annotation = annotation;
            return;
        }
        throw new NullPointerException("annotation == null");
    }

    @Override // com.android.dx.rop.cst.Constant
    protected int compareTo0(Constant constant) {
        return this.annotation.compareTo(((CstAnnotation) constant).annotation);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CstAnnotation)) {
            return false;
        }
        return this.annotation.equals(((CstAnnotation) obj).annotation);
    }

    public Annotation getAnnotation() {
        return this.annotation;
    }

    public int hashCode() {
        return this.annotation.hashCode();
    }

    @Override // com.android.dx.rop.cst.Constant
    public boolean isCategory2() {
        return false;
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        return this.annotation.toString();
    }

    public String toString() {
        return this.annotation.toString();
    }

    @Override // com.android.dx.rop.cst.Constant
    public String typeName() {
        return "annotation";
    }
}
