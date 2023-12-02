package com.jakewharton.rxbinding2.widget;

import android.widget.Adapter;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;

/* loaded from: classes6.dex */
public final class RxAdapter {
    private RxAdapter() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> InitialValueObservable<T> dataChanges(@NonNull T t3) {
        Preconditions.checkNotNull(t3, "adapter == null");
        return new b(t3);
    }
}
