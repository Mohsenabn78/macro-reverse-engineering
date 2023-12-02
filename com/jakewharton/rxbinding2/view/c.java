package com.jakewharton.rxbinding2.view;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_ViewAttachAttachedEvent.java */
/* loaded from: classes6.dex */
public final class c extends ViewAttachAttachedEvent {

    /* renamed from: a  reason: collision with root package name */
    private final View f34188a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(View view) {
        if (view != null) {
            this.f34188a = view;
            return;
        }
        throw new NullPointerException("Null view");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ViewAttachAttachedEvent) {
            return this.f34188a.equals(((ViewAttachAttachedEvent) obj).view());
        }
        return false;
    }

    public int hashCode() {
        return this.f34188a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "ViewAttachAttachedEvent{view=" + this.f34188a + "}";
    }

    @Override // com.jakewharton.rxbinding2.view.ViewAttachEvent
    @NonNull
    public View view() {
        return this.f34188a;
    }
}
