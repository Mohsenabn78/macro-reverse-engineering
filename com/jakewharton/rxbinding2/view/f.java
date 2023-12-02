package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_ViewGroupHierarchyChildViewRemoveEvent.java */
/* loaded from: classes6.dex */
public final class f extends ViewGroupHierarchyChildViewRemoveEvent {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f34192a;

    /* renamed from: b  reason: collision with root package name */
    private final View f34193b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ViewGroup viewGroup, View view) {
        if (viewGroup != null) {
            this.f34192a = viewGroup;
            if (view != null) {
                this.f34193b = view;
                return;
            }
            throw new NullPointerException("Null child");
        }
        throw new NullPointerException("Null view");
    }

    @Override // com.jakewharton.rxbinding2.view.ViewGroupHierarchyChangeEvent
    @NonNull
    public View child() {
        return this.f34193b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ViewGroupHierarchyChildViewRemoveEvent)) {
            return false;
        }
        ViewGroupHierarchyChildViewRemoveEvent viewGroupHierarchyChildViewRemoveEvent = (ViewGroupHierarchyChildViewRemoveEvent) obj;
        if (this.f34192a.equals(viewGroupHierarchyChildViewRemoveEvent.view()) && this.f34193b.equals(viewGroupHierarchyChildViewRemoveEvent.child())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f34192a.hashCode() ^ 1000003) * 1000003) ^ this.f34193b.hashCode();
    }

    public String toString() {
        return "ViewGroupHierarchyChildViewRemoveEvent{view=" + this.f34192a + ", child=" + this.f34193b + "}";
    }

    @Override // com.jakewharton.rxbinding2.view.ViewGroupHierarchyChangeEvent
    @NonNull
    public ViewGroup view() {
        return this.f34192a;
    }
}
