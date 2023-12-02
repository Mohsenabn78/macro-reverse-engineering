package com.jakewharton.rxbinding2.widget;

import android.widget.SeekBar;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_SeekBarStopChangeEvent.java */
/* loaded from: classes6.dex */
public final class s extends SeekBarStopChangeEvent {

    /* renamed from: a  reason: collision with root package name */
    private final SeekBar f34423a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(SeekBar seekBar) {
        if (seekBar != null) {
            this.f34423a = seekBar;
            return;
        }
        throw new NullPointerException("Null view");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SeekBarStopChangeEvent) {
            return this.f34423a.equals(((SeekBarStopChangeEvent) obj).view());
        }
        return false;
    }

    public int hashCode() {
        return this.f34423a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "SeekBarStopChangeEvent{view=" + this.f34423a + "}";
    }

    @Override // com.jakewharton.rxbinding2.widget.SeekBarChangeEvent
    @NonNull
    public SeekBar view() {
        return this.f34423a;
    }
}
