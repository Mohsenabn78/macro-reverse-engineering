package com.google.android.material.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.R;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

/* loaded from: classes5.dex */
public class NavigationView extends ScrimInsetsFrameLayout {

    /* renamed from: s  reason: collision with root package name */
    private static final int[] f24004s = {16842912};

    /* renamed from: t  reason: collision with root package name */
    private static final int[] f24005t = {-16842910};

    /* renamed from: u  reason: collision with root package name */
    private static final int f24006u = R.style.Widget_Design_NavigationView;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final NavigationMenu f24007f;

    /* renamed from: g  reason: collision with root package name */
    private final NavigationMenuPresenter f24008g;

    /* renamed from: h  reason: collision with root package name */
    OnNavigationItemSelectedListener f24009h;

    /* renamed from: i  reason: collision with root package name */
    private final int f24010i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f24011j;

    /* renamed from: k  reason: collision with root package name */
    private MenuInflater f24012k;

    /* renamed from: l  reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f24013l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f24014m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f24015n;

    /* renamed from: o  reason: collision with root package name */
    private int f24016o;
    @Px

    /* renamed from: p  reason: collision with root package name */
    private int f24017p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private Path f24018q;

    /* renamed from: r  reason: collision with root package name */
    private final RectF f24019r;

    /* loaded from: classes5.dex */
    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(@NonNull MenuItem menuItem);
    }

    public NavigationView(@NonNull Context context) {
        this(context, null);
    }

    @Nullable
    private ColorStateList d(int i4) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i4, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i5 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        int[] iArr = f24005t;
        return new ColorStateList(new int[][]{iArr, f24004s, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i5, defaultColor});
    }

    @NonNull
    private final Drawable e(@NonNull TintTypedArray tintTypedArray) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(getContext(), tintTypedArray.getResourceId(R.styleable.NavigationView_itemShapeAppearance, 0), tintTypedArray.getResourceId(R.styleable.NavigationView_itemShapeAppearanceOverlay, 0)).build());
        materialShapeDrawable.setFillColor(MaterialResources.getColorStateList(getContext(), tintTypedArray, R.styleable.NavigationView_itemShapeFillColor));
        return new InsetDrawable((Drawable) materialShapeDrawable, tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetStart, 0), tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetTop, 0), tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetEnd, 0), tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    private boolean f(@NonNull TintTypedArray tintTypedArray) {
        if (!tintTypedArray.hasValue(R.styleable.NavigationView_itemShapeAppearance) && !tintTypedArray.hasValue(R.styleable.NavigationView_itemShapeAppearanceOverlay)) {
            return false;
        }
        return true;
    }

    private void g(@Px int i4, @Px int i5) {
        if ((getParent() instanceof DrawerLayout) && this.f24017p > 0 && (getBackground() instanceof MaterialShapeDrawable)) {
            MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) getBackground();
            ShapeAppearanceModel.Builder builder = materialShapeDrawable.getShapeAppearanceModel().toBuilder();
            if (GravityCompat.getAbsoluteGravity(this.f24016o, ViewCompat.getLayoutDirection(this)) == 3) {
                builder.setTopRightCornerSize(this.f24017p);
                builder.setBottomRightCornerSize(this.f24017p);
            } else {
                builder.setTopLeftCornerSize(this.f24017p);
                builder.setBottomLeftCornerSize(this.f24017p);
            }
            materialShapeDrawable.setShapeAppearanceModel(builder.build());
            if (this.f24018q == null) {
                this.f24018q = new Path();
            }
            this.f24018q.reset();
            this.f24019r.set(0.0f, 0.0f, i4, i5);
            ShapeAppearancePathProvider.getInstance().calculatePath(materialShapeDrawable.getShapeAppearanceModel(), materialShapeDrawable.getInterpolation(), this.f24019r, this.f24018q);
            invalidate();
            return;
        }
        this.f24018q = null;
        this.f24019r.setEmpty();
    }

    private MenuInflater getMenuInflater() {
        if (this.f24012k == null) {
            this.f24012k = new SupportMenuInflater(getContext());
        }
        return this.f24012k;
    }

    private void h() {
        this.f24013l = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.android.material.navigation.NavigationView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                boolean z3;
                boolean z4;
                boolean z5;
                boolean z6;
                NavigationView navigationView = NavigationView.this;
                navigationView.getLocationOnScreen(navigationView.f24011j);
                boolean z7 = true;
                if (NavigationView.this.f24011j[1] == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                NavigationView.this.f24008g.setBehindStatusBar(z3);
                NavigationView navigationView2 = NavigationView.this;
                if (z3 && navigationView2.isTopInsetScrimEnabled()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                navigationView2.setDrawTopInsetForeground(z4);
                Activity activity = ContextUtils.getActivity(NavigationView.this.getContext());
                if (activity != null) {
                    if (activity.findViewById(16908290).getHeight() == NavigationView.this.getHeight()) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    NavigationView navigationView3 = NavigationView.this;
                    navigationView3.setDrawBottomInsetForeground((z5 && z6 && navigationView3.isBottomInsetScrimEnabled()) ? false : false);
                }
            }
        };
        getViewTreeObserver().addOnGlobalLayoutListener(this.f24013l);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void a(@NonNull WindowInsetsCompat windowInsetsCompat) {
        this.f24008g.dispatchApplyWindowInsets(windowInsetsCompat);
    }

    public void addHeaderView(@NonNull View view) {
        this.f24008g.addHeaderView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NonNull Canvas canvas) {
        if (this.f24018q == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.clipPath(this.f24018q);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    @Nullable
    public MenuItem getCheckedItem() {
        return this.f24008g.getCheckedItem();
    }

    @Px
    public int getDividerInsetEnd() {
        return this.f24008g.getDividerInsetEnd();
    }

    @Px
    public int getDividerInsetStart() {
        return this.f24008g.getDividerInsetStart();
    }

    public int getHeaderCount() {
        return this.f24008g.getHeaderCount();
    }

    public View getHeaderView(int i4) {
        return this.f24008g.getHeaderView(i4);
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.f24008g.getItemBackground();
    }

    @Dimension
    public int getItemHorizontalPadding() {
        return this.f24008g.getItemHorizontalPadding();
    }

    @Dimension
    public int getItemIconPadding() {
        return this.f24008g.getItemIconPadding();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.f24008g.getItemTintList();
    }

    public int getItemMaxLines() {
        return this.f24008g.getItemMaxLines();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f24008g.getItemTextColor();
    }

    @Px
    public int getItemVerticalPadding() {
        return this.f24008g.getItemVerticalPadding();
    }

    @NonNull
    public Menu getMenu() {
        return this.f24007f;
    }

    @Px
    public int getSubheaderInsetEnd() {
        return this.f24008g.getSubheaderInsetEnd();
    }

    @Px
    public int getSubheaderInsetStart() {
        return this.f24008g.getSubheaderInsetStart();
    }

    public View inflateHeaderView(@LayoutRes int i4) {
        return this.f24008g.inflateHeaderView(i4);
    }

    public void inflateMenu(int i4) {
        this.f24008g.setUpdateSuspended(true);
        getMenuInflater().inflate(i4, this.f24007f);
        this.f24008g.setUpdateSuspended(false);
        this.f24008g.updateMenuView(false);
    }

    public boolean isBottomInsetScrimEnabled() {
        return this.f24015n;
    }

    public boolean isTopInsetScrimEnabled() {
        return this.f24014m;
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f24013l);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        int mode = View.MeasureSpec.getMode(i4);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i4 = View.MeasureSpec.makeMeasureSpec(this.f24010i, 1073741824);
            }
        } else {
            i4 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i4), this.f24010i), 1073741824);
        }
        super.onMeasure(i4, i5);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f24007f.restorePresenterStates(savedState.menuState);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.menuState = bundle;
        this.f24007f.savePresenterStates(bundle);
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        g(i4, i5);
    }

    public void removeHeaderView(@NonNull View view) {
        this.f24008g.removeHeaderView(view);
    }

    public void setBottomInsetScrimEnabled(boolean z3) {
        this.f24015n = z3;
    }

    public void setCheckedItem(@IdRes int i4) {
        MenuItem findItem = this.f24007f.findItem(i4);
        if (findItem != null) {
            this.f24008g.setCheckedItem((MenuItemImpl) findItem);
        }
    }

    public void setDividerInsetEnd(@Px int i4) {
        this.f24008g.setDividerInsetEnd(i4);
    }

    public void setDividerInsetStart(@Px int i4) {
        this.f24008g.setDividerInsetStart(i4);
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        MaterialShapeUtils.setElevation(this, f4);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.f24008g.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(@DrawableRes int i4) {
        setItemBackground(ContextCompat.getDrawable(getContext(), i4));
    }

    public void setItemHorizontalPadding(@Dimension int i4) {
        this.f24008g.setItemHorizontalPadding(i4);
    }

    public void setItemHorizontalPaddingResource(@DimenRes int i4) {
        this.f24008g.setItemHorizontalPadding(getResources().getDimensionPixelSize(i4));
    }

    public void setItemIconPadding(@Dimension int i4) {
        this.f24008g.setItemIconPadding(i4);
    }

    public void setItemIconPaddingResource(int i4) {
        this.f24008g.setItemIconPadding(getResources().getDimensionPixelSize(i4));
    }

    public void setItemIconSize(@Dimension int i4) {
        this.f24008g.setItemIconSize(i4);
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.f24008g.setItemIconTintList(colorStateList);
    }

    public void setItemMaxLines(int i4) {
        this.f24008g.setItemMaxLines(i4);
    }

    public void setItemTextAppearance(@StyleRes int i4) {
        this.f24008g.setItemTextAppearance(i4);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f24008g.setItemTextColor(colorStateList);
    }

    public void setItemVerticalPadding(@Px int i4) {
        this.f24008g.setItemVerticalPadding(i4);
    }

    public void setItemVerticalPaddingResource(@DimenRes int i4) {
        this.f24008g.setItemVerticalPadding(getResources().getDimensionPixelSize(i4));
    }

    public void setNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.f24009h = onNavigationItemSelectedListener;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i4) {
        super.setOverScrollMode(i4);
        NavigationMenuPresenter navigationMenuPresenter = this.f24008g;
        if (navigationMenuPresenter != null) {
            navigationMenuPresenter.setOverScrollMode(i4);
        }
    }

    public void setSubheaderInsetEnd(@Px int i4) {
        this.f24008g.setSubheaderInsetStart(i4);
    }

    public void setSubheaderInsetStart(@Px int i4) {
        this.f24008g.setSubheaderInsetStart(i4);
    }

    public void setTopInsetScrimEnabled(boolean z3) {
        this.f24014m = z3;
    }

    /* loaded from: classes5.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.navigation.NavigationView.SavedState.1
            @Override // android.os.Parcelable.Creator
            @Nullable
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i4) {
                return new SavedState[i4];
            }
        };
        @Nullable
        public Bundle menuState;

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeBundle(this.menuState);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public NavigationView(@androidx.annotation.NonNull android.content.Context r12, @androidx.annotation.Nullable android.util.AttributeSet r13, int r14) {
        /*
            Method dump skipped, instructions count: 504
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCheckedItem(@NonNull MenuItem menuItem) {
        MenuItem findItem = this.f24007f.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.f24008g.setCheckedItem((MenuItemImpl) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
