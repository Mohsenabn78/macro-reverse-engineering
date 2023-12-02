package com.arlosoft.macrodroid.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SmartNestedScrollView.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public class SmartNestedScrollView extends NestedScrollView {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartNestedScrollView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final RecyclerView a(View view) {
        ViewGroup viewGroup;
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        int i4 = 0;
        do {
            viewGroup = (ViewGroup) view;
            RecyclerView a4 = a(viewGroup.getChildAt(i4));
            if (a4 == null) {
                i4++;
            } else {
                return a4;
            }
        } while (i4 < viewGroup.getChildCount());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public void measureChildWithMargins(@Nullable View view, int i4, int i5, int i6, int i7) {
        ViewGroup.LayoutParams layoutParams;
        if (a(view) != null) {
            if (view != null) {
                layoutParams = view.getLayoutParams();
            } else {
                layoutParams = null;
            }
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            view.measure(i4, View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, Integer.MIN_VALUE));
            return;
        }
        super.measureChildWithMargins(view, i4, i5, i6, i7);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmartNestedScrollView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmartNestedScrollView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
