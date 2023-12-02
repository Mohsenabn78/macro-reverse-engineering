package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.AdapterView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes6.dex */
public abstract class AdapterViewItemSelectionEvent extends AdapterViewSelectionEvent {
    @NonNull
    @CheckResult
    public static AdapterViewSelectionEvent create(@NonNull AdapterView<?> adapterView, @NonNull View view, int i4, long j4) {
        return new m(adapterView, view, i4, j4);
    }

    public abstract long id();

    public abstract int position();

    @NonNull
    public abstract View selectedView();
}
