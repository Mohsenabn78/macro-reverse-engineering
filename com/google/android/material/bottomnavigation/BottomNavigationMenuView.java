package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class BottomNavigationMenuView extends NavigationBarMenuView {
    private final int E;
    private final int F;
    private final int G;
    private final int H;
    private boolean I;
    private int[] J;

    public BottomNavigationMenuView(@NonNull Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.E = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.F = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.G = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.H = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
        this.J = new int[5];
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @NonNull
    protected NavigationBarItemView d(@NonNull Context context) {
        return new BottomNavigationItemView(context);
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.I;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        int childCount = getChildCount();
        int i8 = i6 - i4;
        int i9 = i7 - i5;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    int i12 = i8 - i10;
                    childAt.layout(i12 - childAt.getMeasuredWidth(), 0, i12, i9);
                } else {
                    childAt.layout(i10, 0, childAt.getMeasuredWidth() + i10, i9);
                }
                i10 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        MenuBuilder menu = getMenu();
        int size = View.MeasureSpec.getSize(i4);
        int size2 = menu.getVisibleItems().size();
        int childCount = getChildCount();
        int size3 = View.MeasureSpec.getSize(i5);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
        int i9 = 1;
        if (f(getLabelVisibilityMode(), size2) && isItemHorizontalTranslationEnabled()) {
            View childAt = getChildAt(getSelectedItemPosition());
            int i10 = this.H;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.G, Integer.MIN_VALUE), makeMeasureSpec);
                i10 = Math.max(i10, childAt.getMeasuredWidth());
            }
            if (childAt.getVisibility() != 8) {
                i6 = 1;
            } else {
                i6 = 0;
            }
            int i11 = size2 - i6;
            int min = Math.min(size - (this.F * i11), Math.min(i10, this.G));
            int i12 = size - min;
            if (i11 == 0) {
                i7 = 1;
            } else {
                i7 = i11;
            }
            int min2 = Math.min(i12 / i7, this.E);
            int i13 = i12 - (i11 * min2);
            for (int i14 = 0; i14 < childCount; i14++) {
                if (getChildAt(i14).getVisibility() != 8) {
                    int[] iArr = this.J;
                    if (i14 == getSelectedItemPosition()) {
                        i8 = min;
                    } else {
                        i8 = min2;
                    }
                    iArr[i14] = i8;
                    if (i13 > 0) {
                        int[] iArr2 = this.J;
                        iArr2[i14] = iArr2[i14] + 1;
                        i13--;
                    }
                } else {
                    this.J[i14] = 0;
                }
            }
        } else {
            if (size2 != 0) {
                i9 = size2;
            }
            int min3 = Math.min(size / i9, this.G);
            int i15 = size - (size2 * min3);
            for (int i16 = 0; i16 < childCount; i16++) {
                if (getChildAt(i16).getVisibility() != 8) {
                    int[] iArr3 = this.J;
                    iArr3[i16] = min3;
                    if (i15 > 0) {
                        iArr3[i16] = min3 + 1;
                        i15--;
                    }
                } else {
                    this.J[i16] = 0;
                }
            }
        }
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.J[i18], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i17 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i17, View.MeasureSpec.makeMeasureSpec(i17, 1073741824), 0), View.resolveSizeAndState(size3, i5, 0));
    }

    public void setItemHorizontalTranslationEnabled(boolean z3) {
        this.I = z3;
    }
}
