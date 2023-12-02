package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.IOException;

/* loaded from: classes3.dex */
public interface DataRewinder<T> {

    /* loaded from: classes3.dex */
    public interface Factory<T> {
        @NonNull
        DataRewinder<T> build(@NonNull T t3);

        @NonNull
        Class<T> getDataClass();
    }

    void cleanup();

    @NonNull
    T rewindAndGet() throws IOException;
}
