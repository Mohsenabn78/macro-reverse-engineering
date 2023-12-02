package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.ListPreloader;

/* loaded from: classes3.dex */
public class FixedPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f17575a;

    public FixedPreloadSizeProvider(int i4, int i5) {
        this.f17575a = new int[]{i4, i5};
    }

    @Override // com.bumptech.glide.ListPreloader.PreloadSizeProvider
    @Nullable
    public int[] getPreloadSize(@NonNull T t3, int i4, int i5) {
        return this.f17575a;
    }
}
