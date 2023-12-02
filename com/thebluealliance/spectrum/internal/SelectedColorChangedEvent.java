package com.thebluealliance.spectrum.internal;

import androidx.annotation.ColorInt;

/* loaded from: classes6.dex */
public class SelectedColorChangedEvent {
    @ColorInt

    /* renamed from: a  reason: collision with root package name */
    private int f38075a;

    public SelectedColorChangedEvent(@ColorInt int i4) {
        this.f38075a = i4;
    }

    @ColorInt
    public int getSelectedColor() {
        return this.f38075a;
    }
}
