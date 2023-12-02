package com.arlosoft.macrodroid.extensions;

import android.app.Dialog;
import android.content.res.Resources;
import android.view.Window;
import android.view.WindowManager;
import com.arlosoft.macrodroid.R;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: DialogExtensions.kt */
/* loaded from: classes3.dex */
public final class DialogExtensionsKt {
    public static final void setHeightToParent(@NotNull Dialog dialog, int i4) {
        Intrinsics.checkNotNullParameter(dialog, "<this>");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = dialog.getWindow();
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        if (!dialog.getContext().getResources().getBoolean(R.bool.is_tablet)) {
            layoutParams.height = Resources.getSystem().getDisplayMetrics().heightPixels - i4;
        } else {
            layoutParams.height = (Resources.getSystem().getDisplayMetrics().heightPixels * 2) / 3;
        }
        Window window2 = dialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
    }

    public static /* synthetic */ void setHeightToParent$default(Dialog dialog, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = 0;
        }
        setHeightToParent(dialog, i4);
    }

    public static final void setWidthToParent(@NotNull Dialog dialog, int i4) {
        Intrinsics.checkNotNullParameter(dialog, "<this>");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = dialog.getWindow();
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        if (!dialog.getContext().getResources().getBoolean(R.bool.is_tablet)) {
            layoutParams.width = Resources.getSystem().getDisplayMetrics().widthPixels - i4;
        } else {
            layoutParams.width = (Resources.getSystem().getDisplayMetrics().widthPixels * 2) / 3;
        }
        Window window2 = dialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
    }

    public static /* synthetic */ void setWidthToParent$default(Dialog dialog, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = 0;
        }
        setWidthToParent(dialog, i4);
    }
}
