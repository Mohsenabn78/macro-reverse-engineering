package com.arlosoft.macrodroid.extensions;

import android.app.Activity;
import android.view.Window;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ActivityExtensions.kt */
/* loaded from: classes3.dex */
public final class ActivityExtensionsKt {
    public static final void makeStatusBarTransparent(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(1024);
        window.setStatusBarColor(0);
    }
}
