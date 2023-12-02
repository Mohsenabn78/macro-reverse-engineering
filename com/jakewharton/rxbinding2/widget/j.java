package com.jakewharton.rxbinding2.widget;

import android.widget.AbsListView;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_AbsListViewScrollEvent.java */
/* loaded from: classes6.dex */
public final class j extends AbsListViewScrollEvent {

    /* renamed from: a  reason: collision with root package name */
    private final AbsListView f34373a;

    /* renamed from: b  reason: collision with root package name */
    private final int f34374b;

    /* renamed from: c  reason: collision with root package name */
    private final int f34375c;

    /* renamed from: d  reason: collision with root package name */
    private final int f34376d;

    /* renamed from: e  reason: collision with root package name */
    private final int f34377e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(AbsListView absListView, int i4, int i5, int i6, int i7) {
        if (absListView != null) {
            this.f34373a = absListView;
            this.f34374b = i4;
            this.f34375c = i5;
            this.f34376d = i6;
            this.f34377e = i7;
            return;
        }
        throw new NullPointerException("Null view");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbsListViewScrollEvent)) {
            return false;
        }
        AbsListViewScrollEvent absListViewScrollEvent = (AbsListViewScrollEvent) obj;
        if (this.f34373a.equals(absListViewScrollEvent.view()) && this.f34374b == absListViewScrollEvent.scrollState() && this.f34375c == absListViewScrollEvent.firstVisibleItem() && this.f34376d == absListViewScrollEvent.visibleItemCount() && this.f34377e == absListViewScrollEvent.totalItemCount()) {
            return true;
        }
        return false;
    }

    @Override // com.jakewharton.rxbinding2.widget.AbsListViewScrollEvent
    public int firstVisibleItem() {
        return this.f34375c;
    }

    public int hashCode() {
        return ((((((((this.f34373a.hashCode() ^ 1000003) * 1000003) ^ this.f34374b) * 1000003) ^ this.f34375c) * 1000003) ^ this.f34376d) * 1000003) ^ this.f34377e;
    }

    @Override // com.jakewharton.rxbinding2.widget.AbsListViewScrollEvent
    public int scrollState() {
        return this.f34374b;
    }

    public String toString() {
        return "AbsListViewScrollEvent{view=" + this.f34373a + ", scrollState=" + this.f34374b + ", firstVisibleItem=" + this.f34375c + ", visibleItemCount=" + this.f34376d + ", totalItemCount=" + this.f34377e + "}";
    }

    @Override // com.jakewharton.rxbinding2.widget.AbsListViewScrollEvent
    public int totalItemCount() {
        return this.f34377e;
    }

    @Override // com.jakewharton.rxbinding2.widget.AbsListViewScrollEvent
    @NonNull
    public AbsListView view() {
        return this.f34373a;
    }

    @Override // com.jakewharton.rxbinding2.widget.AbsListViewScrollEvent
    public int visibleItemCount() {
        return this.f34376d;
    }
}
