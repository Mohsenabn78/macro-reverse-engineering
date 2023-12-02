package com.jakewharton.rxbinding2.widget;

import android.widget.SeekBar;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_SeekBarProgressChangeEvent.java */
/* loaded from: classes6.dex */
public final class q extends SeekBarProgressChangeEvent {

    /* renamed from: a  reason: collision with root package name */
    private final SeekBar f34419a;

    /* renamed from: b  reason: collision with root package name */
    private final int f34420b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f34421c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(SeekBar seekBar, int i4, boolean z3) {
        if (seekBar != null) {
            this.f34419a = seekBar;
            this.f34420b = i4;
            this.f34421c = z3;
            return;
        }
        throw new NullPointerException("Null view");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SeekBarProgressChangeEvent)) {
            return false;
        }
        SeekBarProgressChangeEvent seekBarProgressChangeEvent = (SeekBarProgressChangeEvent) obj;
        if (this.f34419a.equals(seekBarProgressChangeEvent.view()) && this.f34420b == seekBarProgressChangeEvent.progress() && this.f34421c == seekBarProgressChangeEvent.fromUser()) {
            return true;
        }
        return false;
    }

    @Override // com.jakewharton.rxbinding2.widget.SeekBarProgressChangeEvent
    public boolean fromUser() {
        return this.f34421c;
    }

    public int hashCode() {
        int i4;
        int hashCode = (((this.f34419a.hashCode() ^ 1000003) * 1000003) ^ this.f34420b) * 1000003;
        if (this.f34421c) {
            i4 = 1231;
        } else {
            i4 = 1237;
        }
        return hashCode ^ i4;
    }

    @Override // com.jakewharton.rxbinding2.widget.SeekBarProgressChangeEvent
    public int progress() {
        return this.f34420b;
    }

    public String toString() {
        return "SeekBarProgressChangeEvent{view=" + this.f34419a + ", progress=" + this.f34420b + ", fromUser=" + this.f34421c + "}";
    }

    @Override // com.jakewharton.rxbinding2.widget.SeekBarChangeEvent
    @NonNull
    public SeekBar view() {
        return this.f34419a;
    }
}
