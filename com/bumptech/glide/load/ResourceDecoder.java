package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

/* loaded from: classes3.dex */
public interface ResourceDecoder<T, Z> {
    @Nullable
    Resource<Z> decode(@NonNull T t3, int i4, int i5, @NonNull Options options) throws IOException;

    boolean handles(@NonNull T t3, @NonNull Options options) throws IOException;
}
