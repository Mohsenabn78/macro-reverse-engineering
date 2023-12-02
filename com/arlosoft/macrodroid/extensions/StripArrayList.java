package com.arlosoft.macrodroid.extensions;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;

/* compiled from: ArrayListExtensions.kt.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class StripArrayList<T> extends ArrayList<T> {
    public static final int $stable = 0;
    private final int maxSize;

    public StripArrayList(int i4) {
        this.maxSize = i4;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(T t3) {
        if (size() == this.maxSize) {
            remove(0);
        }
        return super.add(t3);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ T remove(int i4) {
        return (T) removeAt(i4);
    }

    public /* bridge */ Object removeAt(int i4) {
        return super.remove(i4);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }
}
