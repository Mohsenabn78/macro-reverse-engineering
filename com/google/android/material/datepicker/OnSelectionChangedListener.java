package com.google.android.material.datepicker;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public abstract class OnSelectionChangedListener<S> {
    public abstract void onSelectionChanged(@NonNull S s3);

    public void onIncompleteSelectionChanged() {
    }
}
