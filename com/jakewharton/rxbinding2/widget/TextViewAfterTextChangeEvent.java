package com.jakewharton.rxbinding2.widget;

import android.text.Editable;
import android.widget.TextView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes6.dex */
public abstract class TextViewAfterTextChangeEvent {
    @NonNull
    @CheckResult
    public static TextViewAfterTextChangeEvent create(@NonNull TextView textView, @Nullable Editable editable) {
        return new t(textView, editable);
    }

    @Nullable
    public abstract Editable editable();

    @NonNull
    public abstract TextView view();
}
