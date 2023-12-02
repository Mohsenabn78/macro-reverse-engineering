package com.jakewharton.rxbinding2.view;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_ViewLayoutChangeEvent.java */
/* loaded from: classes6.dex */
public final class g extends ViewLayoutChangeEvent {

    /* renamed from: a  reason: collision with root package name */
    private final View f34194a;

    /* renamed from: b  reason: collision with root package name */
    private final int f34195b;

    /* renamed from: c  reason: collision with root package name */
    private final int f34196c;

    /* renamed from: d  reason: collision with root package name */
    private final int f34197d;

    /* renamed from: e  reason: collision with root package name */
    private final int f34198e;

    /* renamed from: f  reason: collision with root package name */
    private final int f34199f;

    /* renamed from: g  reason: collision with root package name */
    private final int f34200g;

    /* renamed from: h  reason: collision with root package name */
    private final int f34201h;

    /* renamed from: i  reason: collision with root package name */
    private final int f34202i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        if (view != null) {
            this.f34194a = view;
            this.f34195b = i4;
            this.f34196c = i5;
            this.f34197d = i6;
            this.f34198e = i7;
            this.f34199f = i8;
            this.f34200g = i9;
            this.f34201h = i10;
            this.f34202i = i11;
            return;
        }
        throw new NullPointerException("Null view");
    }

    @Override // com.jakewharton.rxbinding2.view.ViewLayoutChangeEvent
    public int bottom() {
        return this.f34198e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ViewLayoutChangeEvent)) {
            return false;
        }
        ViewLayoutChangeEvent viewLayoutChangeEvent = (ViewLayoutChangeEvent) obj;
        if (this.f34194a.equals(viewLayoutChangeEvent.view()) && this.f34195b == viewLayoutChangeEvent.left() && this.f34196c == viewLayoutChangeEvent.top() && this.f34197d == viewLayoutChangeEvent.right() && this.f34198e == viewLayoutChangeEvent.bottom() && this.f34199f == viewLayoutChangeEvent.oldLeft() && this.f34200g == viewLayoutChangeEvent.oldTop() && this.f34201h == viewLayoutChangeEvent.oldRight() && this.f34202i == viewLayoutChangeEvent.oldBottom()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((this.f34194a.hashCode() ^ 1000003) * 1000003) ^ this.f34195b) * 1000003) ^ this.f34196c) * 1000003) ^ this.f34197d) * 1000003) ^ this.f34198e) * 1000003) ^ this.f34199f) * 1000003) ^ this.f34200g) * 1000003) ^ this.f34201h) * 1000003) ^ this.f34202i;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewLayoutChangeEvent
    public int left() {
        return this.f34195b;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewLayoutChangeEvent
    public int oldBottom() {
        return this.f34202i;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewLayoutChangeEvent
    public int oldLeft() {
        return this.f34199f;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewLayoutChangeEvent
    public int oldRight() {
        return this.f34201h;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewLayoutChangeEvent
    public int oldTop() {
        return this.f34200g;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewLayoutChangeEvent
    public int right() {
        return this.f34197d;
    }

    public String toString() {
        return "ViewLayoutChangeEvent{view=" + this.f34194a + ", left=" + this.f34195b + ", top=" + this.f34196c + ", right=" + this.f34197d + ", bottom=" + this.f34198e + ", oldLeft=" + this.f34199f + ", oldTop=" + this.f34200g + ", oldRight=" + this.f34201h + ", oldBottom=" + this.f34202i + "}";
    }

    @Override // com.jakewharton.rxbinding2.view.ViewLayoutChangeEvent
    public int top() {
        return this.f34196c;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewLayoutChangeEvent
    @NonNull
    public View view() {
        return this.f34194a;
    }
}
