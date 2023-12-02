package com.arlosoft.macrodroid.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExludeGestureFrameLayout.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ExludeGestureFrameLayout extends FrameLayout {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExludeGestureFrameLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        ArrayList arrayListOf;
        super.onLayout(z3, i4, i5, i6, i7);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new Rect(i4, i5, i6, i7));
        ViewCompat.setSystemGestureExclusionRects(this, arrayListOf);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExludeGestureFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExludeGestureFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
