package com.jakewharton.rxbinding2.view;

import android.view.MenuItem;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_MenuItemActionViewExpandEvent.java */
/* loaded from: classes6.dex */
public final class b extends MenuItemActionViewExpandEvent {

    /* renamed from: a  reason: collision with root package name */
    private final MenuItem f34187a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MenuItem menuItem) {
        if (menuItem != null) {
            this.f34187a = menuItem;
            return;
        }
        throw new NullPointerException("Null menuItem");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MenuItemActionViewExpandEvent) {
            return this.f34187a.equals(((MenuItemActionViewExpandEvent) obj).menuItem());
        }
        return false;
    }

    public int hashCode() {
        return this.f34187a.hashCode() ^ 1000003;
    }

    @Override // com.jakewharton.rxbinding2.view.MenuItemActionViewEvent
    @NonNull
    public MenuItem menuItem() {
        return this.f34187a;
    }

    public String toString() {
        return "MenuItemActionViewExpandEvent{menuItem=" + this.f34187a + "}";
    }
}
