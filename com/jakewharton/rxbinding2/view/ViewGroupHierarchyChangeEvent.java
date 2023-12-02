package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* loaded from: classes6.dex */
public abstract class ViewGroupHierarchyChangeEvent {
    @NonNull
    public abstract View child();

    @NonNull
    public abstract ViewGroup view();
}
