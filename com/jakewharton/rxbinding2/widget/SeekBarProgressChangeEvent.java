package com.jakewharton.rxbinding2.widget;

import android.widget.SeekBar;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes6.dex */
public abstract class SeekBarProgressChangeEvent extends SeekBarChangeEvent {
    @NonNull
    @CheckResult
    public static SeekBarProgressChangeEvent create(@NonNull SeekBar seekBar, int i4, boolean z3) {
        return new q(seekBar, i4, z3);
    }

    public abstract boolean fromUser();

    public abstract int progress();
}
