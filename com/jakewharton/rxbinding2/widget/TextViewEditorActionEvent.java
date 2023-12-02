package com.jakewharton.rxbinding2.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes6.dex */
public abstract class TextViewEditorActionEvent {
    @NonNull
    @CheckResult
    public static TextViewEditorActionEvent create(@NonNull TextView textView, int i4, @Nullable KeyEvent keyEvent) {
        return new v(textView, i4, keyEvent);
    }

    public abstract int actionId();

    @Nullable
    public abstract KeyEvent keyEvent();

    @NonNull
    public abstract TextView view();
}
