package com.jakewharton.rxbinding2.view;

import android.view.MenuItem;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_MenuItemActionViewCollapseEvent.java */
/* loaded from: classes6.dex */
public final class a extends MenuItemActionViewCollapseEvent {

    /* renamed from: a  reason: collision with root package name */
    private final MenuItem f34181a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MenuItem menuItem) {
        if (menuItem != null) {
            this.f34181a = menuItem;
            return;
        }
        throw new NullPointerException("Null menuItem");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MenuItemActionViewCollapseEvent) {
            return this.f34181a.equals(((MenuItemActionViewCollapseEvent) obj).menuItem());
        }
        return false;
    }

    public int hashCode() {
        return this.f34181a.hashCode() ^ 1000003;
    }

    @Override // com.jakewharton.rxbinding2.view.MenuItemActionViewEvent
    @NonNull
    public MenuItem menuItem() {
        return this.f34181a;
    }

    public String toString() {
        return "MenuItemActionViewCollapseEvent{menuItem=" + this.f34181a + "}";
    }
}
