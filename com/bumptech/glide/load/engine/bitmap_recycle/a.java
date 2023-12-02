package com.bumptech.glide.load.engine.bitmap_recycle;

/* compiled from: ArrayAdapterInterface.java */
/* loaded from: classes3.dex */
interface a<T> {
    int getArrayLength(T t3);

    int getElementSizeInBytes();

    String getTag();

    T newArray(int i4);
}
