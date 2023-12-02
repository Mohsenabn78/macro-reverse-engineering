package com.jakewharton.rxbinding2.view;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_ViewAttachDetachedEvent.java */
/* loaded from: classes6.dex */
public final class d extends ViewAttachDetachedEvent {

    /* renamed from: a  reason: collision with root package name */
    private final View f34189a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(View view) {
        if (view != null) {
            this.f34189a = view;
            return;
        }
        throw new NullPointerException("Null view");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ViewAttachDetachedEvent) {
            return this.f34189a.equals(((ViewAttachDetachedEvent) obj).view());
        }
        return false;
    }

    public int hashCode() {
        return this.f34189a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "ViewAttachDetachedEvent{view=" + this.f34189a + "}";
    }

    @Override // com.jakewharton.rxbinding2.view.ViewAttachEvent
    @NonNull
    public View view() {
        return this.f34189a;
    }
}
