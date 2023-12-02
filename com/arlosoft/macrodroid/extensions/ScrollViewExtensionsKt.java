package com.arlosoft.macrodroid.extensions;

import android.widget.ScrollView;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ScrollViewExtensions.kt */
/* loaded from: classes3.dex */
public final class ScrollViewExtensionsKt {
    public static final void scrollToBottom(@NotNull ScrollView scrollView) {
        Intrinsics.checkNotNullParameter(scrollView, "<this>");
        scrollView.smoothScrollBy(0, (scrollView.getChildAt(scrollView.getChildCount() - 1).getBottom() + scrollView.getPaddingBottom()) - (scrollView.getScrollY() + scrollView.getHeight()));
    }
}
