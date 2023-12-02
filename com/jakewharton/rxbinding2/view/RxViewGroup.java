package com.jakewharton.rxbinding2.view;

import android.view.ViewGroup;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;

/* loaded from: classes6.dex */
public final class RxViewGroup {
    private RxViewGroup() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Observable<ViewGroupHierarchyChangeEvent> changeEvents(@NonNull ViewGroup viewGroup) {
        Preconditions.checkNotNull(viewGroup, "viewGroup == null");
        return new p(viewGroup);
    }
}
