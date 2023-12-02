package com.jakewharton.rxbinding2.view;

import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes6.dex */
public abstract class ViewScrollChangeEvent {
    @NonNull
    @CheckResult
    public static ViewScrollChangeEvent create(@NonNull View view, int i4, int i5, int i6, int i7) {
        return new h(view, i4, i5, i6, i7);
    }

    public abstract int oldScrollX();

    public abstract int oldScrollY();

    public abstract int scrollX();

    public abstract int scrollY();

    @NonNull
    public abstract View view();
}
