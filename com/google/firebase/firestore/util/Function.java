package com.google.firebase.firestore.util;

import javax.annotation.Nullable;

/* loaded from: classes5.dex */
public interface Function<F, T> {
    @Nullable
    T apply(@Nullable F f4);

    boolean equals(@Nullable Object obj);
}
