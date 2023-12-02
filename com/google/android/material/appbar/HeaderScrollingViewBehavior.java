package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.badge.BadgeDrawable;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* renamed from: d  reason: collision with root package name */
    final Rect f22991d;

    /* renamed from: e  reason: collision with root package name */
    final Rect f22992e;

    /* renamed from: f  reason: collision with root package name */
    private int f22993f;

    /* renamed from: g  reason: collision with root package name */
    private int f22994g;

    public HeaderScrollingViewBehavior() {
        this.f22991d = new Rect();
        this.f22992e = new Rect();
        this.f22993f = 0;
    }

    private static int g(int i4) {
        if (i4 == 0) {
            return BadgeDrawable.TOP_START;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    public void a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i4) {
        View b4 = b(coordinatorLayout.getDependencies(view));
        if (b4 != null) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
            Rect rect = this.f22991d;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, b4.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((coordinatorLayout.getHeight() + b4.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
                rect.left += lastWindowInsets.getSystemWindowInsetLeft();
                rect.right -= lastWindowInsets.getSystemWindowInsetRight();
            }
            Rect rect2 = this.f22992e;
            GravityCompat.apply(g(layoutParams.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i4);
            int c4 = c(b4);
            view.layout(rect2.left, rect2.top - c4, rect2.right, rect2.bottom - c4);
            this.f22993f = rect2.top - b4.getBottom();
            return;
        }
        super.a(coordinatorLayout, view, i4);
        this.f22993f = 0;
    }

    @Nullable
    abstract View b(List<View> list);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int c(View view) {
        if (this.f22994g == 0) {
            return 0;
        }
        float d4 = d(view);
        int i4 = this.f22994g;
        return MathUtils.clamp((int) (d4 * i4), 0, i4);
    }

    float d(View view) {
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e(@NonNull View view) {
        return view.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int f() {
        return this.f22993f;
    }

    public final int getOverlayTop() {
        return this.f22994g;
    }

    protected boolean h() {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i4, int i5, int i6, int i7) {
        View b4;
        int i8;
        WindowInsetsCompat lastWindowInsets;
        int i9 = view.getLayoutParams().height;
        if ((i9 == -1 || i9 == -2) && (b4 = b(coordinatorLayout.getDependencies(view))) != null) {
            int size = View.MeasureSpec.getSize(i6);
            if (size > 0) {
                if (ViewCompat.getFitsSystemWindows(b4) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                    size += lastWindowInsets.getSystemWindowInsetTop() + lastWindowInsets.getSystemWindowInsetBottom();
                }
            } else {
                size = coordinatorLayout.getHeight();
            }
            int e4 = size + e(b4);
            int measuredHeight = b4.getMeasuredHeight();
            if (h()) {
                view.setTranslationY(-measuredHeight);
            } else {
                e4 -= measuredHeight;
            }
            if (i9 == -1) {
                i8 = 1073741824;
            } else {
                i8 = Integer.MIN_VALUE;
            }
            coordinatorLayout.onMeasureChild(view, i4, i5, View.MeasureSpec.makeMeasureSpec(e4, i8), i7);
            return true;
        }
        return false;
    }

    public final void setOverlayTop(int i4) {
        this.f22994g = i4;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22991d = new Rect();
        this.f22992e = new Rect();
        this.f22993f = 0;
    }
}
