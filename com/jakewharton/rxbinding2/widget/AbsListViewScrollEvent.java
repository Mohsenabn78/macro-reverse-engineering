package com.jakewharton.rxbinding2.widget;

import android.widget.AbsListView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes6.dex */
public abstract class AbsListViewScrollEvent {
    @NonNull
    @CheckResult
    public static AbsListViewScrollEvent create(AbsListView absListView, int i4, int i5, int i6, int i7) {
        return new j(absListView, i4, i5, i6, i7);
    }

    public abstract int firstVisibleItem();

    public abstract int scrollState();

    public abstract int totalItemCount();

    @NonNull
    public abstract AbsListView view();

    public abstract int visibleItemCount();
}
