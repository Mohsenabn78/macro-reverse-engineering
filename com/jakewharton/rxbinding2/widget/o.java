package com.jakewharton.rxbinding2.widget;

import android.widget.RatingBar;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_RatingBarChangeEvent.java */
/* loaded from: classes6.dex */
public final class o extends RatingBarChangeEvent {

    /* renamed from: a  reason: collision with root package name */
    private final RatingBar f34410a;

    /* renamed from: b  reason: collision with root package name */
    private final float f34411b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f34412c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(RatingBar ratingBar, float f4, boolean z3) {
        if (ratingBar != null) {
            this.f34410a = ratingBar;
            this.f34411b = f4;
            this.f34412c = z3;
            return;
        }
        throw new NullPointerException("Null view");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RatingBarChangeEvent)) {
            return false;
        }
        RatingBarChangeEvent ratingBarChangeEvent = (RatingBarChangeEvent) obj;
        if (this.f34410a.equals(ratingBarChangeEvent.view()) && Float.floatToIntBits(this.f34411b) == Float.floatToIntBits(ratingBarChangeEvent.rating()) && this.f34412c == ratingBarChangeEvent.fromUser()) {
            return true;
        }
        return false;
    }

    @Override // com.jakewharton.rxbinding2.widget.RatingBarChangeEvent
    public boolean fromUser() {
        return this.f34412c;
    }

    public int hashCode() {
        int i4;
        int hashCode = (((this.f34410a.hashCode() ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.f34411b)) * 1000003;
        if (this.f34412c) {
            i4 = 1231;
        } else {
            i4 = 1237;
        }
        return hashCode ^ i4;
    }

    @Override // com.jakewharton.rxbinding2.widget.RatingBarChangeEvent
    public float rating() {
        return this.f34411b;
    }

    public String toString() {
        return "RatingBarChangeEvent{view=" + this.f34410a + ", rating=" + this.f34411b + ", fromUser=" + this.f34412c + "}";
    }

    @Override // com.jakewharton.rxbinding2.widget.RatingBarChangeEvent
    @NonNull
    public RatingBar view() {
        return this.f34410a;
    }
}
