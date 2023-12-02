package com.airbnb.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import com.airbnb.lottie.LottieComposition;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class LottieCompositionCache {

    /* renamed from: b  reason: collision with root package name */
    private static final LottieCompositionCache f1603b = new LottieCompositionCache();

    /* renamed from: a  reason: collision with root package name */
    private final LruCache<String, LottieComposition> f1604a = new LruCache<>(20);

    @VisibleForTesting
    LottieCompositionCache() {
    }

    public static LottieCompositionCache getInstance() {
        return f1603b;
    }

    public void clear() {
        this.f1604a.evictAll();
    }

    @Nullable
    public LottieComposition get(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.f1604a.get(str);
    }

    public void put(@Nullable String str, LottieComposition lottieComposition) {
        if (str == null) {
            return;
        }
        this.f1604a.put(str, lottieComposition);
    }

    public void resize(int i4) {
        this.f1604a.resize(i4);
    }
}
