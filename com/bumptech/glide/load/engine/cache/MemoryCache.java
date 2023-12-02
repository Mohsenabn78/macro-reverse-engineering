package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: classes3.dex */
public interface MemoryCache {

    /* loaded from: classes3.dex */
    public interface ResourceRemovedListener {
        void onResourceRemoved(@NonNull Resource<?> resource);
    }

    void clearMemory();

    long getCurrentSize();

    long getMaxSize();

    @Nullable
    Resource<?> put(@NonNull Key key, @Nullable Resource<?> resource);

    @Nullable
    Resource<?> remove(@NonNull Key key);

    void setResourceRemovedListener(@NonNull ResourceRemovedListener resourceRemovedListener);

    void setSizeMultiplier(float f4);

    void trimMemory(int i4);
}
