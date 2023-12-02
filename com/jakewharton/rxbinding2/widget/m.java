package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.AdapterView;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_AdapterViewItemSelectionEvent.java */
/* loaded from: classes6.dex */
public final class m extends AdapterViewItemSelectionEvent {

    /* renamed from: a  reason: collision with root package name */
    private final AdapterView<?> f34399a;

    /* renamed from: b  reason: collision with root package name */
    private final View f34400b;

    /* renamed from: c  reason: collision with root package name */
    private final int f34401c;

    /* renamed from: d  reason: collision with root package name */
    private final long f34402d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AdapterView<?> adapterView, View view, int i4, long j4) {
        if (adapterView != null) {
            this.f34399a = adapterView;
            if (view != null) {
                this.f34400b = view;
                this.f34401c = i4;
                this.f34402d = j4;
                return;
            }
            throw new NullPointerException("Null selectedView");
        }
        throw new NullPointerException("Null view");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdapterViewItemSelectionEvent)) {
            return false;
        }
        AdapterViewItemSelectionEvent adapterViewItemSelectionEvent = (AdapterViewItemSelectionEvent) obj;
        if (this.f34399a.equals(adapterViewItemSelectionEvent.view()) && this.f34400b.equals(adapterViewItemSelectionEvent.selectedView()) && this.f34401c == adapterViewItemSelectionEvent.position() && this.f34402d == adapterViewItemSelectionEvent.id()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j4 = this.f34402d;
        return ((((((this.f34399a.hashCode() ^ 1000003) * 1000003) ^ this.f34400b.hashCode()) * 1000003) ^ this.f34401c) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)));
    }

    @Override // com.jakewharton.rxbinding2.widget.AdapterViewItemSelectionEvent
    public long id() {
        return this.f34402d;
    }

    @Override // com.jakewharton.rxbinding2.widget.AdapterViewItemSelectionEvent
    public int position() {
        return this.f34401c;
    }

    @Override // com.jakewharton.rxbinding2.widget.AdapterViewItemSelectionEvent
    @NonNull
    public View selectedView() {
        return this.f34400b;
    }

    public String toString() {
        return "AdapterViewItemSelectionEvent{view=" + this.f34399a + ", selectedView=" + this.f34400b + ", position=" + this.f34401c + ", id=" + this.f34402d + "}";
    }

    @Override // com.jakewharton.rxbinding2.widget.AdapterViewSelectionEvent
    @NonNull
    public AdapterView<?> view() {
        return this.f34399a;
    }
}
