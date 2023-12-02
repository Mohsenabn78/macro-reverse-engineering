package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class NavigationRailMenuView extends NavigationBarMenuView {
    @Px
    private int E;
    private final FrameLayout.LayoutParams F;

    public NavigationRailMenuView(@NonNull Context context) {
        super(context);
        this.E = -1;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.F = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
        setItemActiveIndicatorResizeable(true);
    }

    private int m(int i4, int i5, int i6) {
        int max = i5 / Math.max(1, i6);
        int i7 = this.E;
        if (i7 == -1) {
            i7 = View.MeasureSpec.getSize(i4);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(i7, max), 0);
    }

    private int n(View view, int i4, int i5) {
        if (view.getVisibility() != 8) {
            view.measure(i4, i5);
            return view.getMeasuredHeight();
        }
        return 0;
    }

    private int o(int i4, int i5, int i6, View view) {
        int makeMeasureSpec;
        m(i4, i5, i6);
        if (view == null) {
            makeMeasureSpec = m(i4, i5, i6);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        }
        int childCount = getChildCount();
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt != view) {
                i7 += n(childAt, i4, makeMeasureSpec);
            }
        }
        return i7;
    }

    private int p(int i4, int i5, int i6) {
        int i7;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            i7 = n(childAt, i4, m(i4, i5, i6));
            i5 -= i7;
            i6--;
        } else {
            i7 = 0;
        }
        return i7 + o(i4, i5, i6, childAt);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @NonNull
    protected NavigationBarItemView d(@NonNull Context context) {
        return new NavigationRailItemView(context);
    }

    @Px
    public int getItemMinimumHeight() {
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMenuGravity() {
        return this.F.gravity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        if ((this.F.gravity & 112) == 48) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        int childCount = getChildCount();
        int i8 = i6 - i4;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i9;
                childAt.layout(0, i9, i8, measuredHeight);
                i9 = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        int o4;
        int size = View.MeasureSpec.getSize(i5);
        int size2 = getMenu().getVisibleItems().size();
        if (size2 > 1 && f(getLabelVisibilityMode(), size2)) {
            o4 = p(i4, size, size2);
        } else {
            o4 = o(i4, size, size2, null);
        }
        setMeasuredDimension(View.resolveSizeAndState(View.MeasureSpec.getSize(i4), i4, 0), View.resolveSizeAndState(o4, i5, 0));
    }

    public void setItemMinimumHeight(@Px int i4) {
        if (this.E != i4) {
            this.E = i4;
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuGravity(int i4) {
        FrameLayout.LayoutParams layoutParams = this.F;
        if (layoutParams.gravity != i4) {
            layoutParams.gravity = i4;
            setLayoutParams(layoutParams);
        }
    }
}
