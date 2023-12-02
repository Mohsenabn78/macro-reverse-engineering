package com.android.dx.util;

/* loaded from: classes2.dex */
public interface IntSet {
    void add(int i4);

    int elements();

    boolean has(int i4);

    IntIterator iterator();

    void merge(IntSet intSet);

    void remove(int i4);
}
