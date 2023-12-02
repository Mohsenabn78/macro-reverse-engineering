package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.AdapterView;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_AdapterViewItemLongClickEvent.java */
/* loaded from: classes6.dex */
public final class l extends AdapterViewItemLongClickEvent {

    /* renamed from: a  reason: collision with root package name */
    private final AdapterView<?> f34392a;

    /* renamed from: b  reason: collision with root package name */
    private final View f34393b;

    /* renamed from: c  reason: collision with root package name */
    private final int f34394c;

    /* renamed from: d  reason: collision with root package name */
    private final long f34395d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AdapterView<?> adapterView, View view, int i4, long j4) {
        if (adapterView != null) {
            this.f34392a = adapterView;
            if (view != null) {
                this.f34393b = view;
                this.f34394c = i4;
                this.f34395d = j4;
                return;
            }
            throw new NullPointerException("Null clickedView");
        }
        throw new NullPointerException("Null view");
    }

    @Override // com.jakewharton.rxbinding2.widget.AdapterViewItemLongClickEvent
    @NonNull
    public View clickedView() {
        return this.f34393b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdapterViewItemLongClickEvent)) {
            return false;
        }
        AdapterViewItemLongClickEvent adapterViewItemLongClickEvent = (AdapterViewItemLongClickEvent) obj;
        if (this.f34392a.equals(adapterViewItemLongClickEvent.view()) && this.f34393b.equals(adapterViewItemLongClickEvent.clickedView()) && this.f34394c == adapterViewItemLongClickEvent.position() && this.f34395d == adapterViewItemLongClickEvent.id()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j4 = this.f34395d;
        return ((((((this.f34392a.hashCode() ^ 1000003) * 1000003) ^ this.f34393b.hashCode()) * 1000003) ^ this.f34394c) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)));
    }

    @Override // com.jakewharton.rxbinding2.widget.AdapterViewItemLongClickEvent
    public long id() {
        return this.f34395d;
    }

    @Override // com.jakewharton.rxbinding2.widget.AdapterViewItemLongClickEvent
    public int position() {
        return this.f34394c;
    }

    public String toString() {
        return "AdapterViewItemLongClickEvent{view=" + this.f34392a + ", clickedView=" + this.f34393b + ", position=" + this.f34394c + ", id=" + this.f34395d + "}";
    }

    @Override // com.jakewharton.rxbinding2.widget.AdapterViewItemLongClickEvent
    @NonNull
    public AdapterView<?> view() {
        return this.f34392a;
    }
}
