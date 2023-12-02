package com.jakewharton.rxbinding2.widget;

import android.view.MenuItem;
import android.widget.PopupMenu;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;

/* loaded from: classes6.dex */
public final class RxPopupMenu {
    private RxPopupMenu() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Observable<Object> dismisses(@NonNull PopupMenu popupMenu) {
        Preconditions.checkNotNull(popupMenu, "view == null");
        return new y(popupMenu);
    }

    @NonNull
    @CheckResult
    public static Observable<MenuItem> itemClicks(@NonNull PopupMenu popupMenu) {
        Preconditions.checkNotNull(popupMenu, "view == null");
        return new z(popupMenu);
    }
}
