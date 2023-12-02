package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class TabIndicatorInterpolator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static RectF a(TabLayout tabLayout, @Nullable View view) {
        if (view == null) {
            return new RectF();
        }
        if (!tabLayout.isTabIndicatorFullWidth() && (view instanceof TabLayout.TabView)) {
            return b((TabLayout.TabView) view, 24);
        }
        return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    static RectF b(@NonNull TabLayout.TabView tabView, @Dimension(unit = 0) int i4) {
        int contentWidth = tabView.getContentWidth();
        int contentHeight = tabView.getContentHeight();
        int dpToPx = (int) ViewUtils.dpToPx(tabView.getContext(), i4);
        if (contentWidth < dpToPx) {
            contentWidth = dpToPx;
        }
        int left = (tabView.getLeft() + tabView.getRight()) / 2;
        int top = (tabView.getTop() + tabView.getBottom()) / 2;
        int i5 = contentWidth / 2;
        return new RectF(left - i5, top - (contentHeight / 2), i5 + left, top + (left / 2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(TabLayout tabLayout, View view, View view2, @FloatRange(from = 0.0d, to = 1.0d) float f4, @NonNull Drawable drawable) {
        RectF a4 = a(tabLayout, view);
        RectF a5 = a(tabLayout, view2);
        drawable.setBounds(AnimationUtils.lerp((int) a4.left, (int) a5.left, f4), drawable.getBounds().top, AnimationUtils.lerp((int) a4.right, (int) a5.right, f4), drawable.getBounds().bottom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(TabLayout tabLayout, View view, @NonNull Drawable drawable) {
        RectF a4 = a(tabLayout, view);
        drawable.setBounds((int) a4.left, drawable.getBounds().top, (int) a4.right, drawable.getBounds().bottom);
    }
}
