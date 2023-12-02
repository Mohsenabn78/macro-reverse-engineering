package com.jakewharton.rxbinding2.widget;

import android.widget.SeekBar;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_SeekBarStartChangeEvent.java */
/* loaded from: classes6.dex */
public final class r extends SeekBarStartChangeEvent {

    /* renamed from: a  reason: collision with root package name */
    private final SeekBar f34422a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(SeekBar seekBar) {
        if (seekBar != null) {
            this.f34422a = seekBar;
            return;
        }
        throw new NullPointerException("Null view");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SeekBarStartChangeEvent) {
            return this.f34422a.equals(((SeekBarStartChangeEvent) obj).view());
        }
        return false;
    }

    public int hashCode() {
        return this.f34422a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "SeekBarStartChangeEvent{view=" + this.f34422a + "}";
    }

    @Override // com.jakewharton.rxbinding2.widget.SeekBarChangeEvent
    @NonNull
    public SeekBar view() {
        return this.f34422a;
    }
}
