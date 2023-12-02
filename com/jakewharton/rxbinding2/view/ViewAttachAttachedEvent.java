package com.jakewharton.rxbinding2.view;

import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes6.dex */
public abstract class ViewAttachAttachedEvent extends ViewAttachEvent {
    @NonNull
    @CheckResult
    public static ViewAttachAttachedEvent create(@NonNull View view) {
        return new c(view);
    }
}
