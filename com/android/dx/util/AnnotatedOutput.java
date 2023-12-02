package com.android.dx.util;

/* loaded from: classes2.dex */
public interface AnnotatedOutput extends Output {
    void annotate(int i4, String str);

    void annotate(String str);

    boolean annotates();

    void endAnnotation();

    int getAnnotationWidth();

    boolean isVerbose();
}
