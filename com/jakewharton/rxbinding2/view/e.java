package com.jakewharton.rxbinding2.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_ViewGroupHierarchyChildViewAddEvent.java */
/* loaded from: classes6.dex */
public final class e extends ViewGroupHierarchyChildViewAddEvent {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f34190a;

    /* renamed from: b  reason: collision with root package name */
    private final View f34191b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ViewGroup viewGroup, View view) {
        if (viewGroup != null) {
            this.f34190a = viewGroup;
            if (view != null) {
                this.f34191b = view;
                return;
            }
            throw new NullPointerException("Null child");
        }
        throw new NullPointerException("Null view");
    }

    @Override // com.jakewharton.rxbinding2.view.ViewGroupHierarchyChangeEvent
    @NonNull
    public View child() {
        return this.f34191b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ViewGroupHierarchyChildViewAddEvent)) {
            return false;
        }
        ViewGroupHierarchyChildViewAddEvent viewGroupHierarchyChildViewAddEvent = (ViewGroupHierarchyChildViewAddEvent) obj;
        if (this.f34190a.equals(viewGroupHierarchyChildViewAddEvent.view()) && this.f34191b.equals(viewGroupHierarchyChildViewAddEvent.child())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f34190a.hashCode() ^ 1000003) * 1000003) ^ this.f34191b.hashCode();
    }

    public String toString() {
        return "ViewGroupHierarchyChildViewAddEvent{view=" + this.f34190a + ", child=" + this.f34191b + "}";
    }

    @Override // com.jakewharton.rxbinding2.view.ViewGroupHierarchyChangeEvent
    @NonNull
    public ViewGroup view() {
        return this.f34190a;
    }
}
