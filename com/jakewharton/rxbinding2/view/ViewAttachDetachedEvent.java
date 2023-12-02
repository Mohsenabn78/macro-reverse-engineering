package com.jakewharton.rxbinding2.view;

import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes6.dex */
public abstract class ViewAttachDetachedEvent extends ViewAttachEvent {
    @NonNull
    @CheckResult
    public static ViewAttachDetachedEvent create(@NonNull View view) {
        return new d(view);
    }
}
