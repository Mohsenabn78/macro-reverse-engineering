package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarView;

/* loaded from: classes5.dex */
public class NavigationRailView extends NavigationBarView {

    /* renamed from: h  reason: collision with root package name */
    private final int f24022h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private View f24023i;

    public NavigationRailView(@NonNull Context context) {
        this(context, null);
    }

    private void e() {
        ViewUtils.doOnApplyWindowInsets(this, new ViewUtils.OnApplyWindowInsetsListener() { // from class: com.google.android.material.navigationrail.NavigationRailView.1
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            @NonNull
            public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils.RelativePadding relativePadding) {
                relativePadding.top += windowInsetsCompat.getSystemWindowInsetTop();
                relativePadding.bottom += windowInsetsCompat.getSystemWindowInsetBottom();
                boolean z3 = true;
                if (ViewCompat.getLayoutDirection(view) != 1) {
                    z3 = false;
                }
                int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
                int systemWindowInsetRight = windowInsetsCompat.getSystemWindowInsetRight();
                int i4 = relativePadding.start;
                if (z3) {
                    systemWindowInsetLeft = systemWindowInsetRight;
                }
                relativePadding.start = i4 + systemWindowInsetLeft;
                relativePadding.applyToView(view);
                return windowInsetsCompat;
            }
        });
    }

    private boolean g() {
        View view = this.f24023i;
        if (view != null && view.getVisibility() != 8) {
            return true;
        }
        return false;
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    private int h(int i4) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i4) != 1073741824 && suggestedMinimumWidth > 0) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i4), suggestedMinimumWidth + getPaddingLeft() + getPaddingRight()), 1073741824);
        }
        return i4;
    }

    public void addHeaderView(@LayoutRes int i4) {
        addHeaderView(LayoutInflater.from(getContext()).inflate(i4, (ViewGroup) this, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: f */
    public NavigationRailMenuView d(@NonNull Context context) {
        return new NavigationRailMenuView(context);
    }

    @Nullable
    public View getHeaderView() {
        return this.f24023i;
    }

    public int getItemMinimumHeight() {
        return ((NavigationRailMenuView) getMenuView()).getItemMinimumHeight();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        NavigationRailMenuView navigationRailMenuView = getNavigationRailMenuView();
        int i8 = 0;
        if (g()) {
            int bottom = this.f24023i.getBottom() + this.f24022h;
            int top = navigationRailMenuView.getTop();
            if (top < bottom) {
                i8 = bottom - top;
            }
        } else if (navigationRailMenuView.l()) {
            i8 = this.f24022h;
        }
        if (i8 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i8, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i8);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        int h4 = h(i4);
        super.onMeasure(h4, i5);
        if (g()) {
            measureChild(getNavigationRailMenuView(), h4, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.f24023i.getMeasuredHeight()) - this.f24022h, Integer.MIN_VALUE));
        }
    }

    public void removeHeaderView() {
        View view = this.f24023i;
        if (view != null) {
            removeView(view);
            this.f24023i = null;
        }
    }

    public void setItemMinimumHeight(@Px int i4) {
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i4);
    }

    public void setMenuGravity(int i4) {
        getNavigationRailMenuView().setMenuGravity(i4);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationRailStyle);
    }

    public void addHeaderView(@NonNull View view) {
        removeHeaderView();
        this.f24023i = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = this.f24022h;
        addView(view, 0, layoutParams);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        this(context, attributeSet, i4, R.style.Widget_MaterialComponents_NavigationRailView);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f24022h = getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin);
        TintTypedArray obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(getContext(), attributeSet, R.styleable.NavigationRailView, i4, i5, new int[0]);
        int resourceId = obtainTintedStyledAttributes.getResourceId(R.styleable.NavigationRailView_headerLayout, 0);
        if (resourceId != 0) {
            addHeaderView(resourceId);
        }
        setMenuGravity(obtainTintedStyledAttributes.getInt(R.styleable.NavigationRailView_menuGravity, 49));
        int i6 = R.styleable.NavigationRailView_itemMinHeight;
        if (obtainTintedStyledAttributes.hasValue(i6)) {
            setItemMinimumHeight(obtainTintedStyledAttributes.getDimensionPixelSize(i6, -1));
        }
        obtainTintedStyledAttributes.recycle();
        e();
    }
}
