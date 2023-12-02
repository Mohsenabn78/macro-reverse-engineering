package com.jakewharton.rxbinding2.widget;

import android.widget.AdapterView;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_AdapterViewNothingSelectionEvent.java */
/* loaded from: classes6.dex */
public final class n extends AdapterViewNothingSelectionEvent {

    /* renamed from: a  reason: collision with root package name */
    private final AdapterView<?> f34406a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AdapterView<?> adapterView) {
        if (adapterView != null) {
            this.f34406a = adapterView;
            return;
        }
        throw new NullPointerException("Null view");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AdapterViewNothingSelectionEvent) {
            return this.f34406a.equals(((AdapterViewNothingSelectionEvent) obj).view());
        }
        return false;
    }

    public int hashCode() {
        return this.f34406a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "AdapterViewNothingSelectionEvent{view=" + this.f34406a + "}";
    }

    @Override // com.jakewharton.rxbinding2.widget.AdapterViewSelectionEvent
    @NonNull
    public AdapterView<?> view() {
        return this.f34406a;
    }
}
