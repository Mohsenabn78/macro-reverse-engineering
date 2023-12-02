package com.jakewharton.rxbinding2.view;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_ViewScrollChangeEvent.java */
/* loaded from: classes6.dex */
public final class h extends ViewScrollChangeEvent {

    /* renamed from: a  reason: collision with root package name */
    private final View f34203a;

    /* renamed from: b  reason: collision with root package name */
    private final int f34204b;

    /* renamed from: c  reason: collision with root package name */
    private final int f34205c;

    /* renamed from: d  reason: collision with root package name */
    private final int f34206d;

    /* renamed from: e  reason: collision with root package name */
    private final int f34207e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(View view, int i4, int i5, int i6, int i7) {
        if (view != null) {
            this.f34203a = view;
            this.f34204b = i4;
            this.f34205c = i5;
            this.f34206d = i6;
            this.f34207e = i7;
            return;
        }
        throw new NullPointerException("Null view");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ViewScrollChangeEvent)) {
            return false;
        }
        ViewScrollChangeEvent viewScrollChangeEvent = (ViewScrollChangeEvent) obj;
        if (this.f34203a.equals(viewScrollChangeEvent.view()) && this.f34204b == viewScrollChangeEvent.scrollX() && this.f34205c == viewScrollChangeEvent.scrollY() && this.f34206d == viewScrollChangeEvent.oldScrollX() && this.f34207e == viewScrollChangeEvent.oldScrollY()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.f34203a.hashCode() ^ 1000003) * 1000003) ^ this.f34204b) * 1000003) ^ this.f34205c) * 1000003) ^ this.f34206d) * 1000003) ^ this.f34207e;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewScrollChangeEvent
    public int oldScrollX() {
        return this.f34206d;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewScrollChangeEvent
    public int oldScrollY() {
        return this.f34207e;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewScrollChangeEvent
    public int scrollX() {
        return this.f34204b;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewScrollChangeEvent
    public int scrollY() {
        return this.f34205c;
    }

    public String toString() {
        return "ViewScrollChangeEvent{view=" + this.f34203a + ", scrollX=" + this.f34204b + ", scrollY=" + this.f34205c + ", oldScrollX=" + this.f34206d + ", oldScrollY=" + this.f34207e + "}";
    }

    @Override // com.jakewharton.rxbinding2.view.ViewScrollChangeEvent
    @NonNull
    public View view() {
        return this.f34203a;
    }
}
