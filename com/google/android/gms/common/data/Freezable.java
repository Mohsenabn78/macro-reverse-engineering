package com.google.android.gms.common.data;

import androidx.annotation.NonNull;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public interface Freezable<T> {
    @NonNull
    T freeze();

    boolean isDataValid();
}
