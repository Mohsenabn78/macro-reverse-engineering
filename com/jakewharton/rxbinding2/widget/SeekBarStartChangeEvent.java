package com.jakewharton.rxbinding2.widget;

import android.widget.SeekBar;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes6.dex */
public abstract class SeekBarStartChangeEvent extends SeekBarChangeEvent {
    @NonNull
    @CheckResult
    public static SeekBarStartChangeEvent create(@NonNull SeekBar seekBar) {
        return new r(seekBar);
    }
}
