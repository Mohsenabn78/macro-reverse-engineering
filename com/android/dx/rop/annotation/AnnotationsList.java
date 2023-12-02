package com.android.dx.rop.annotation;

import com.android.dx.util.FixedSizeList;

/* loaded from: classes2.dex */
public final class AnnotationsList extends FixedSizeList {
    public static final AnnotationsList EMPTY = new AnnotationsList(0);

    public AnnotationsList(int i4) {
        super(i4);
    }

    public static AnnotationsList combine(AnnotationsList annotationsList, AnnotationsList annotationsList2) {
        int size = annotationsList.size();
        if (size == annotationsList2.size()) {
            AnnotationsList annotationsList3 = new AnnotationsList(size);
            for (int i4 = 0; i4 < size; i4++) {
                annotationsList3.set(i4, Annotations.combine(annotationsList.get(i4), annotationsList2.get(i4)));
            }
            annotationsList3.setImmutable();
            return annotationsList3;
        }
        throw new IllegalArgumentException("list1.size() != list2.size()");
    }

    public Annotations get(int i4) {
        return (Annotations) get0(i4);
    }

    public void set(int i4, Annotations annotations) {
        annotations.throwIfMutable();
        set0(i4, annotations);
    }
}
