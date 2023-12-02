package com.arlosoft.macrodroid.editscreen;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LocalVarRecyclerView.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class LocalVarRecyclerView extends RecyclerView {
    public static final int $stable = 8;

    /* renamed from: a  reason: collision with root package name */
    private boolean f11812a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVarRecyclerView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i4, int i5) {
        if (this.f11812a) {
            super.onMeasure(i4, i5);
            getLayoutParams().height = -2;
            return;
        }
        super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec((Resources.getSystem().getDisplayMetrics().heightPixels * 2) / 3, Integer.MIN_VALUE));
    }

    public final void setInline(boolean z3) {
        this.f11812a = z3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVarRecyclerView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVarRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
