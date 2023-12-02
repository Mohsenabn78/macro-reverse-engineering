package com.jakewharton.rxbinding2.widget;

import android.widget.RatingBar;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes6.dex */
public abstract class RatingBarChangeEvent {
    @NonNull
    @CheckResult
    public static RatingBarChangeEvent create(@NonNull RatingBar ratingBar, float f4, boolean z3) {
        return new o(ratingBar, f4, z3);
    }

    public abstract boolean fromUser();

    public abstract float rating();

    @NonNull
    public abstract RatingBar view();
}
