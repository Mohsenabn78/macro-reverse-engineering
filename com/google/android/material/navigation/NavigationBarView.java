package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes5.dex */
public abstract class NavigationBarView extends FrameLayout {
    public static final int LABEL_VISIBILITY_AUTO = -1;
    public static final int LABEL_VISIBILITY_LABELED = 1;
    public static final int LABEL_VISIBILITY_SELECTED = 0;
    public static final int LABEL_VISIBILITY_UNLABELED = 2;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final NavigationBarMenu f23995a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final NavigationBarMenuView f23996b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final NavigationBarPresenter f23997c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private ColorStateList f23998d;

    /* renamed from: e  reason: collision with root package name */
    private MenuInflater f23999e;

    /* renamed from: f  reason: collision with root package name */
    private OnItemSelectedListener f24000f;

    /* renamed from: g  reason: collision with root package name */
    private OnItemReselectedListener f24001g;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public @interface LabelVisibility {
    }

    /* loaded from: classes5.dex */
    public interface OnItemReselectedListener {
        void onNavigationItemReselected(@NonNull MenuItem menuItem);
    }

    /* loaded from: classes5.dex */
    public interface OnItemSelectedListener {
        boolean onNavigationItemSelected(@NonNull MenuItem menuItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.navigation.NavigationBarView.SavedState.1
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

        /* renamed from: a  reason: collision with root package name */
        Bundle f24003a;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(@NonNull Parcel parcel, ClassLoader classLoader) {
            this.f24003a = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeBundle(this.f24003a);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }
    }

    public NavigationBarView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i4, @StyleRes int i5) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i4, i5), attributeSet, i4);
        NavigationBarPresenter navigationBarPresenter = new NavigationBarPresenter();
        this.f23997c = navigationBarPresenter;
        Context context2 = getContext();
        int[] iArr = R.styleable.NavigationBarView;
        int i6 = R.styleable.NavigationBarView_itemTextAppearanceInactive;
        int i7 = R.styleable.NavigationBarView_itemTextAppearanceActive;
        TintTypedArray obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, iArr, i4, i5, i6, i7);
        NavigationBarMenu navigationBarMenu = new NavigationBarMenu(context2, getClass(), getMaxItemCount());
        this.f23995a = navigationBarMenu;
        NavigationBarMenuView d4 = d(context2);
        this.f23996b = d4;
        navigationBarPresenter.setMenuView(d4);
        navigationBarPresenter.setId(1);
        d4.setPresenter(navigationBarPresenter);
        navigationBarMenu.addMenuPresenter(navigationBarPresenter);
        navigationBarPresenter.initForMenu(getContext(), navigationBarMenu);
        int i8 = R.styleable.NavigationBarView_itemIconTint;
        if (obtainTintedStyledAttributes.hasValue(i8)) {
            d4.setIconTintList(obtainTintedStyledAttributes.getColorStateList(i8));
        } else {
            d4.setIconTintList(d4.createDefaultColorStateList(16842808));
        }
        setItemIconSize(obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationBarView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (obtainTintedStyledAttributes.hasValue(i6)) {
            setItemTextAppearanceInactive(obtainTintedStyledAttributes.getResourceId(i6, 0));
        }
        if (obtainTintedStyledAttributes.hasValue(i7)) {
            setItemTextAppearanceActive(obtainTintedStyledAttributes.getResourceId(i7, 0));
        }
        int i9 = R.styleable.NavigationBarView_itemTextColor;
        if (obtainTintedStyledAttributes.hasValue(i9)) {
            setItemTextColor(obtainTintedStyledAttributes.getColorStateList(i9));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            ViewCompat.setBackground(this, c(context2));
        }
        int i10 = R.styleable.NavigationBarView_itemPaddingTop;
        if (obtainTintedStyledAttributes.hasValue(i10)) {
            setItemPaddingTop(obtainTintedStyledAttributes.getDimensionPixelSize(i10, 0));
        }
        int i11 = R.styleable.NavigationBarView_itemPaddingBottom;
        if (obtainTintedStyledAttributes.hasValue(i11)) {
            setItemPaddingBottom(obtainTintedStyledAttributes.getDimensionPixelSize(i11, 0));
        }
        int i12 = R.styleable.NavigationBarView_elevation;
        if (obtainTintedStyledAttributes.hasValue(i12)) {
            setElevation(obtainTintedStyledAttributes.getDimensionPixelSize(i12, 0));
        }
        DrawableCompat.setTintList(getBackground().mutate(), MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, R.styleable.NavigationBarView_backgroundTint));
        setLabelVisibilityMode(obtainTintedStyledAttributes.getInteger(R.styleable.NavigationBarView_labelVisibilityMode, -1));
        int resourceId = obtainTintedStyledAttributes.getResourceId(R.styleable.NavigationBarView_itemBackground, 0);
        if (resourceId != 0) {
            d4.setItemBackgroundRes(resourceId);
        } else {
            setItemRippleColor(MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, R.styleable.NavigationBarView_itemRippleColor));
        }
        int resourceId2 = obtainTintedStyledAttributes.getResourceId(R.styleable.NavigationBarView_itemActiveIndicatorStyle, 0);
        if (resourceId2 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(resourceId2, R.styleable.NavigationBarActiveIndicator);
            setItemActiveIndicatorWidth(obtainStyledAttributes.getDimensionPixelSize(R.styleable.NavigationBarActiveIndicator_android_width, 0));
            setItemActiveIndicatorHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.NavigationBarActiveIndicator_android_height, 0));
            setItemActiveIndicatorMarginHorizontal(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.NavigationBarActiveIndicator_marginHorizontal, 0));
            setItemActiveIndicatorColor(MaterialResources.getColorStateList(context2, obtainStyledAttributes, R.styleable.NavigationBarActiveIndicator_android_color));
            setItemActiveIndicatorShapeAppearance(ShapeAppearanceModel.builder(context2, obtainStyledAttributes.getResourceId(R.styleable.NavigationBarActiveIndicator_shapeAppearance, 0), 0).build());
            obtainStyledAttributes.recycle();
        }
        int i13 = R.styleable.NavigationBarView_menu;
        if (obtainTintedStyledAttributes.hasValue(i13)) {
            inflateMenu(obtainTintedStyledAttributes.getResourceId(i13, 0));
        }
        obtainTintedStyledAttributes.recycle();
        addView(d4);
        navigationBarMenu.setCallback(new MenuBuilder.Callback() { // from class: com.google.android.material.navigation.NavigationBarView.1
            @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
            public boolean onMenuItemSelected(MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
                if (NavigationBarView.this.f24001g != null && menuItem.getItemId() == NavigationBarView.this.getSelectedItemId()) {
                    NavigationBarView.this.f24001g.onNavigationItemReselected(menuItem);
                    return true;
                } else if (NavigationBarView.this.f24000f != null && !NavigationBarView.this.f24000f.onNavigationItemSelected(menuItem)) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
            public void onMenuModeChange(MenuBuilder menuBuilder) {
            }
        });
    }

    @NonNull
    private MaterialShapeDrawable c(Context context) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
        }
        materialShapeDrawable.initializeElevationOverlay(context);
        return materialShapeDrawable;
    }

    private MenuInflater getMenuInflater() {
        if (this.f23999e == null) {
            this.f23999e = new SupportMenuInflater(getContext());
        }
        return this.f23999e;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected abstract NavigationBarMenuView d(@NonNull Context context);

    @Nullable
    public BadgeDrawable getBadge(int i4) {
        return this.f23996b.getBadge(i4);
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.f23996b.getItemActiveIndicatorColor();
    }

    @Px
    public int getItemActiveIndicatorHeight() {
        return this.f23996b.getItemActiveIndicatorHeight();
    }

    @Px
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f23996b.getItemActiveIndicatorMarginHorizontal();
    }

    @Nullable
    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.f23996b.getItemActiveIndicatorShapeAppearance();
    }

    @Px
    public int getItemActiveIndicatorWidth() {
        return this.f23996b.getItemActiveIndicatorWidth();
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.f23996b.getItemBackground();
    }

    @DrawableRes
    @Deprecated
    public int getItemBackgroundResource() {
        return this.f23996b.getItemBackgroundRes();
    }

    @Dimension
    public int getItemIconSize() {
        return this.f23996b.getItemIconSize();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.f23996b.getIconTintList();
    }

    @Px
    public int getItemPaddingBottom() {
        return this.f23996b.getItemPaddingBottom();
    }

    @Px
    public int getItemPaddingTop() {
        return this.f23996b.getItemPaddingTop();
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.f23998d;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.f23996b.getItemTextAppearanceActive();
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.f23996b.getItemTextAppearanceInactive();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f23996b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f23996b.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    @NonNull
    public Menu getMenu() {
        return this.f23995a;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MenuView getMenuView() {
        return this.f23996b;
    }

    @NonNull
    public BadgeDrawable getOrCreateBadge(int i4) {
        return this.f23996b.e(i4);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavigationBarPresenter getPresenter() {
        return this.f23997c;
    }

    @IdRes
    public int getSelectedItemId() {
        return this.f23996b.getSelectedItemId();
    }

    public void inflateMenu(int i4) {
        this.f23997c.setUpdateSuspended(true);
        getMenuInflater().inflate(i4, this.f23995a);
        this.f23997c.setUpdateSuspended(false);
        this.f23997c.updateMenuView(true);
    }

    public boolean isItemActiveIndicatorEnabled() {
        return this.f23996b.getItemActiveIndicatorEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f23995a.restorePresenterStates(savedState.f24003a);
    }

    @Override // android.view.View
    @NonNull
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f24003a = bundle;
        this.f23995a.savePresenterStates(bundle);
        return savedState;
    }

    public void removeBadge(int i4) {
        this.f23996b.h(i4);
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        MaterialShapeUtils.setElevation(this, f4);
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList colorStateList) {
        this.f23996b.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z3) {
        this.f23996b.setItemActiveIndicatorEnabled(z3);
    }

    public void setItemActiveIndicatorHeight(@Px int i4) {
        this.f23996b.setItemActiveIndicatorHeight(i4);
    }

    public void setItemActiveIndicatorMarginHorizontal(@Px int i4) {
        this.f23996b.setItemActiveIndicatorMarginHorizontal(i4);
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.f23996b.setItemActiveIndicatorShapeAppearance(shapeAppearanceModel);
    }

    public void setItemActiveIndicatorWidth(@Px int i4) {
        this.f23996b.setItemActiveIndicatorWidth(i4);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.f23996b.setItemBackground(drawable);
        this.f23998d = null;
    }

    public void setItemBackgroundResource(@DrawableRes int i4) {
        this.f23996b.setItemBackgroundRes(i4);
        this.f23998d = null;
    }

    public void setItemIconSize(@Dimension int i4) {
        this.f23996b.setItemIconSize(i4);
    }

    public void setItemIconSizeRes(@DimenRes int i4) {
        setItemIconSize(getResources().getDimensionPixelSize(i4));
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.f23996b.setIconTintList(colorStateList);
    }

    public void setItemOnTouchListener(int i4, @Nullable View.OnTouchListener onTouchListener) {
        this.f23996b.setItemOnTouchListener(i4, onTouchListener);
    }

    public void setItemPaddingBottom(@Px int i4) {
        this.f23996b.setItemPaddingBottom(i4);
    }

    public void setItemPaddingTop(@Px int i4) {
        this.f23996b.setItemPaddingTop(i4);
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f23998d == colorStateList) {
            if (colorStateList == null && this.f23996b.getItemBackground() != null) {
                this.f23996b.setItemBackground(null);
                return;
            }
            return;
        }
        this.f23998d = colorStateList;
        if (colorStateList == null) {
            this.f23996b.setItemBackground(null);
            return;
        }
        this.f23996b.setItemBackground(new RippleDrawable(RippleUtils.convertToRippleDrawableColor(colorStateList), null, null));
    }

    public void setItemTextAppearanceActive(@StyleRes int i4) {
        this.f23996b.setItemTextAppearanceActive(i4);
    }

    public void setItemTextAppearanceInactive(@StyleRes int i4) {
        this.f23996b.setItemTextAppearanceInactive(i4);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f23996b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i4) {
        if (this.f23996b.getLabelVisibilityMode() != i4) {
            this.f23996b.setLabelVisibilityMode(i4);
            this.f23997c.updateMenuView(false);
        }
    }

    public void setOnItemReselectedListener(@Nullable OnItemReselectedListener onItemReselectedListener) {
        this.f24001g = onItemReselectedListener;
    }

    public void setOnItemSelectedListener(@Nullable OnItemSelectedListener onItemSelectedListener) {
        this.f24000f = onItemSelectedListener;
    }

    public void setSelectedItemId(@IdRes int i4) {
        MenuItem findItem = this.f23995a.findItem(i4);
        if (findItem != null && !this.f23995a.performItemAction(findItem, this.f23997c, 0)) {
            findItem.setChecked(true);
        }
    }
}
