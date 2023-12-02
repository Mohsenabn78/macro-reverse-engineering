package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.AdapterView;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_AdapterViewItemClickEvent.java */
/* loaded from: classes6.dex */
public final class k extends AdapterViewItemClickEvent {

    /* renamed from: a  reason: collision with root package name */
    private final AdapterView<?> f34383a;

    /* renamed from: b  reason: collision with root package name */
    private final View f34384b;

    /* renamed from: c  reason: collision with root package name */
    private final int f34385c;

    /* renamed from: d  reason: collision with root package name */
    private final long f34386d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AdapterView<?> adapterView, View view, int i4, long j4) {
        if (adapterView != null) {
            this.f34383a = adapterView;
            if (view != null) {
                this.f34384b = view;
                this.f34385c = i4;
                this.f34386d = j4;
                return;
            }
            throw new NullPointerException("Null clickedView");
        }
        throw new NullPointerException("Null view");
    }

    @Override // com.jakewharton.rxbinding2.widget.AdapterViewItemClickEvent
    @NonNull
    public View clickedView() {
        return this.f34384b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdapterViewItemClickEvent)) {
            return false;
        }
        AdapterViewItemClickEvent adapterViewItemClickEvent = (AdapterViewItemClickEvent) obj;
        if (this.f34383a.equals(adapterViewItemClickEvent.view()) && this.f34384b.equals(adapterViewItemClickEvent.clickedView()) && this.f34385c == adapterViewItemClickEvent.position() && this.f34386d == adapterViewItemClickEvent.id()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j4 = this.f34386d;
        return ((((((this.f34383a.hashCode() ^ 1000003) * 1000003) ^ this.f34384b.hashCode()) * 1000003) ^ this.f34385c) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)));
    }

    @Override // com.jakewharton.rxbinding2.widget.AdapterViewItemClickEvent
    public long id() {
        return this.f34386d;
    }

    @Override // com.jakewharton.rxbinding2.widget.AdapterViewItemClickEvent
    public int position() {
        return this.f34385c;
    }

    public String toString() {
        return "AdapterViewItemClickEvent{view=" + this.f34383a + ", clickedView=" + this.f34384b + ", position=" + this.f34385c + ", id=" + this.f34386d + "}";
    }

    @Override // com.jakewharton.rxbinding2.widget.AdapterViewItemClickEvent
    @NonNull
    public AdapterView<?> view() {
        return this.f34383a;
    }
}
