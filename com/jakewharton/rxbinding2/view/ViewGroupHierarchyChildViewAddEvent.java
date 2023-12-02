package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes6.dex */
public abstract class ViewGroupHierarchyChildViewAddEvent extends ViewGroupHierarchyChangeEvent {
    @NonNull
    @CheckResult
    public static ViewGroupHierarchyChildViewAddEvent create(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return new e(viewGroup, view);
    }
}
