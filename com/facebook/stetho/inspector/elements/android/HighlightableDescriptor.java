package com.facebook.stetho.inspector.elements.android;

import android.graphics.Rect;
import android.view.View;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public interface HighlightableDescriptor<E> {
    @Nullable
    Object getElementToHighlightAtPosition(E e4, int i4, int i5, Rect rect);

    @Nullable
    View getViewAndBoundsForHighlighting(E e4, Rect rect);
}
