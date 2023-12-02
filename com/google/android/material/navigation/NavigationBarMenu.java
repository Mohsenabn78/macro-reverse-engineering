package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class NavigationBarMenu extends MenuBuilder {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f23960a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23961b;

    public NavigationBarMenu(@NonNull Context context, @NonNull Class<?> cls, int i4) {
        super(context);
        this.f23960a = cls;
        this.f23961b = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.view.menu.MenuBuilder
    @NonNull
    public MenuItem addInternal(int i4, int i5, int i6, @NonNull CharSequence charSequence) {
        if (size() + 1 <= this.f23961b) {
            stopDispatchingItemsChanged();
            MenuItem addInternal = super.addInternal(i4, i5, i6, charSequence);
            if (addInternal instanceof MenuItemImpl) {
                ((MenuItemImpl) addInternal).setExclusiveCheckable(true);
            }
            startDispatchingItemsChanged();
            return addInternal;
        }
        String simpleName = this.f23960a.getSimpleName();
        throw new IllegalArgumentException("Maximum number of items supported by " + simpleName + " is " + this.f23961b + ". Limit can be checked with " + simpleName + "#getMaxItemCount()");
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    @NonNull
    public SubMenu addSubMenu(int i4, int i5, int i6, @NonNull CharSequence charSequence) {
        throw new UnsupportedOperationException(this.f23960a.getSimpleName() + " does not support submenus");
    }

    public int getMaxItemCount() {
        return this.f23961b;
    }
}
