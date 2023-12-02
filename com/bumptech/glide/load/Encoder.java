package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.io.File;

/* loaded from: classes3.dex */
public interface Encoder<T> {
    boolean encode(@NonNull T t3, @NonNull File file, @NonNull Options options);
}
