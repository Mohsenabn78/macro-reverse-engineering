package com.google.android.material.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.TextScale;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.HashSet;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public abstract class NavigationBarMenuView extends ViewGroup implements MenuView {
    private static final int[] C = {16842912};
    private static final int[] D = {-16842910};
    private NavigationBarPresenter A;
    private MenuBuilder B;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final TransitionSet f23962a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final View.OnClickListener f23963b;

    /* renamed from: c  reason: collision with root package name */
    private final Pools.Pool<NavigationBarItemView> f23964c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final SparseArray<View.OnTouchListener> f23965d;

    /* renamed from: e  reason: collision with root package name */
    private int f23966e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private NavigationBarItemView[] f23967f;

    /* renamed from: g  reason: collision with root package name */
    private int f23968g;

    /* renamed from: h  reason: collision with root package name */
    private int f23969h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private ColorStateList f23970i;
    @Dimension

    /* renamed from: j  reason: collision with root package name */
    private int f23971j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f23972k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private final ColorStateList f23973l;
    @StyleRes

    /* renamed from: m  reason: collision with root package name */
    private int f23974m;
    @StyleRes

    /* renamed from: n  reason: collision with root package name */
    private int f23975n;

    /* renamed from: o  reason: collision with root package name */
    private Drawable f23976o;

    /* renamed from: p  reason: collision with root package name */
    private int f23977p;
    @NonNull

    /* renamed from: q  reason: collision with root package name */
    private SparseArray<BadgeDrawable> f23978q;

    /* renamed from: r  reason: collision with root package name */
    private int f23979r;

    /* renamed from: s  reason: collision with root package name */
    private int f23980s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f23981t;

    /* renamed from: u  reason: collision with root package name */
    private int f23982u;

    /* renamed from: v  reason: collision with root package name */
    private int f23983v;

    /* renamed from: w  reason: collision with root package name */
    private int f23984w;

    /* renamed from: x  reason: collision with root package name */
    private ShapeAppearanceModel f23985x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f23986y;

    /* renamed from: z  reason: collision with root package name */
    private ColorStateList f23987z;

    public NavigationBarMenuView(@NonNull Context context) {
        super(context);
        this.f23964c = new Pools.SynchronizedPool(5);
        this.f23965d = new SparseArray<>(5);
        this.f23968g = 0;
        this.f23969h = 0;
        this.f23978q = new SparseArray<>(5);
        this.f23979r = -1;
        this.f23980s = -1;
        this.f23986y = false;
        this.f23973l = createDefaultColorStateList(16842808);
        AutoTransition autoTransition = new AutoTransition();
        this.f23962a = autoTransition;
        autoTransition.setOrdering(0);
        autoTransition.setDuration(MotionUtils.resolveThemeDuration(getContext(), R.attr.motionDurationLong1, getResources().getInteger(R.integer.material_motion_duration_long_1)));
        autoTransition.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), R.attr.motionEasingStandard, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        autoTransition.addTransition(new TextScale());
        this.f23963b = new View.OnClickListener() { // from class: com.google.android.material.navigation.NavigationBarMenuView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MenuItemImpl itemData = ((NavigationBarItemView) view).getItemData();
                if (!NavigationBarMenuView.this.B.performItemAction(itemData, NavigationBarMenuView.this.A, 0)) {
                    itemData.setChecked(true);
                }
            }
        };
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    @Nullable
    private Drawable c() {
        if (this.f23985x != null && this.f23987z != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.f23985x);
            materialShapeDrawable.setFillColor(this.f23987z);
            return materialShapeDrawable;
        }
        return null;
    }

    private boolean g(int i4) {
        if (i4 != -1) {
            return true;
        }
        return false;
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView acquire = this.f23964c.acquire();
        if (acquire == null) {
            return d(getContext());
        }
        return acquire;
    }

    private void i() {
        HashSet hashSet = new HashSet();
        for (int i4 = 0; i4 < this.B.size(); i4++) {
            hashSet.add(Integer.valueOf(this.B.getItem(i4).getItemId()));
        }
        for (int i5 = 0; i5 < this.f23978q.size(); i5++) {
            int keyAt = this.f23978q.keyAt(i5);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.f23978q.delete(keyAt);
            }
        }
    }

    private void k(int i4) {
        if (g(i4)) {
            return;
        }
        throw new IllegalArgumentException(i4 + " is not a valid view id");
    }

    private void setBadgeIfNeeded(@NonNull NavigationBarItemView navigationBarItemView) {
        BadgeDrawable badgeDrawable;
        int id = navigationBarItemView.getId();
        if (g(id) && (badgeDrawable = this.f23978q.get(id)) != null) {
            navigationBarItemView.setBadge(badgeDrawable);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void buildMenuView() {
        removeAllViews();
        NavigationBarItemView[] navigationBarItemViewArr = this.f23967f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView != null) {
                    this.f23964c.release(navigationBarItemView);
                    navigationBarItemView.f();
                }
            }
        }
        if (this.B.size() == 0) {
            this.f23968g = 0;
            this.f23969h = 0;
            this.f23967f = null;
            return;
        }
        i();
        this.f23967f = new NavigationBarItemView[this.B.size()];
        boolean f4 = f(this.f23966e, this.B.getVisibleItems().size());
        for (int i4 = 0; i4 < this.B.size(); i4++) {
            this.A.setUpdateSuspended(true);
            this.B.getItem(i4).setCheckable(true);
            this.A.setUpdateSuspended(false);
            NavigationBarItemView newItem = getNewItem();
            this.f23967f[i4] = newItem;
            newItem.setIconTintList(this.f23970i);
            newItem.setIconSize(this.f23971j);
            newItem.setTextColor(this.f23973l);
            newItem.setTextAppearanceInactive(this.f23974m);
            newItem.setTextAppearanceActive(this.f23975n);
            newItem.setTextColor(this.f23972k);
            int i5 = this.f23979r;
            if (i5 != -1) {
                newItem.setItemPaddingTop(i5);
            }
            int i6 = this.f23980s;
            if (i6 != -1) {
                newItem.setItemPaddingBottom(i6);
            }
            newItem.setActiveIndicatorWidth(this.f23982u);
            newItem.setActiveIndicatorHeight(this.f23983v);
            newItem.setActiveIndicatorMarginHorizontal(this.f23984w);
            newItem.setActiveIndicatorDrawable(c());
            newItem.setActiveIndicatorResizeable(this.f23986y);
            newItem.setActiveIndicatorEnabled(this.f23981t);
            Drawable drawable = this.f23976o;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.f23977p);
            }
            newItem.setShifting(f4);
            newItem.setLabelVisibilityMode(this.f23966e);
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.B.getItem(i4);
            newItem.initialize(menuItemImpl, 0);
            newItem.setItemPosition(i4);
            int itemId = menuItemImpl.getItemId();
            newItem.setOnTouchListener(this.f23965d.get(itemId));
            newItem.setOnClickListener(this.f23963b);
            int i7 = this.f23968g;
            if (i7 != 0 && itemId == i7) {
                this.f23969h = i4;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int min = Math.min(this.B.size() - 1, this.f23969h);
        this.f23969h = min;
        this.B.getItem(min).setChecked(true);
    }

    @Nullable
    public ColorStateList createDefaultColorStateList(int i4) {
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
        int[] iArr = D;
        return new ColorStateList(new int[][]{iArr, C, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i5, defaultColor});
    }

    @NonNull
    protected abstract NavigationBarItemView d(@NonNull Context context);

    /* JADX INFO: Access modifiers changed from: package-private */
    public BadgeDrawable e(int i4) {
        k(i4);
        BadgeDrawable badgeDrawable = this.f23978q.get(i4);
        if (badgeDrawable == null) {
            badgeDrawable = BadgeDrawable.create(getContext());
            this.f23978q.put(i4, badgeDrawable);
        }
        NavigationBarItemView findItemView = findItemView(i4);
        if (findItemView != null) {
            findItemView.setBadge(badgeDrawable);
        }
        return badgeDrawable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f(int i4, int i5) {
        if (i4 == -1) {
            if (i5 > 3) {
                return true;
            }
        } else if (i4 == 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public NavigationBarItemView findItemView(int i4) {
        k(i4);
        NavigationBarItemView[] navigationBarItemViewArr = this.f23967f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView.getId() == i4) {
                    return navigationBarItemView;
                }
            }
            return null;
        }
        return null;
    }

    @Nullable
    public BadgeDrawable getBadge(int i4) {
        return this.f23978q.get(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.f23978q;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.f23970i;
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.f23987z;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.f23981t;
    }

    @Px
    public int getItemActiveIndicatorHeight() {
        return this.f23983v;
    }

    @Px
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f23984w;
    }

    @Nullable
    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.f23985x;
    }

    @Px
    public int getItemActiveIndicatorWidth() {
        return this.f23982u;
    }

    @Nullable
    public Drawable getItemBackground() {
        NavigationBarItemView[] navigationBarItemViewArr = this.f23967f;
        if (navigationBarItemViewArr != null && navigationBarItemViewArr.length > 0) {
            return navigationBarItemViewArr[0].getBackground();
        }
        return this.f23976o;
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.f23977p;
    }

    @Dimension
    public int getItemIconSize() {
        return this.f23971j;
    }

    @Px
    public int getItemPaddingBottom() {
        return this.f23980s;
    }

    @Px
    public int getItemPaddingTop() {
        return this.f23979r;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.f23975n;
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.f23974m;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f23972k;
    }

    public int getLabelVisibilityMode() {
        return this.f23966e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public MenuBuilder getMenu() {
        return this.B;
    }

    public int getSelectedItemId() {
        return this.f23968g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSelectedItemPosition() {
        return this.f23969h;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(int i4) {
        k(i4);
        BadgeDrawable badgeDrawable = this.f23978q.get(i4);
        NavigationBarItemView findItemView = findItemView(i4);
        if (findItemView != null) {
            findItemView.l();
        }
        if (badgeDrawable != null) {
            this.f23978q.remove(i4);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(@NonNull MenuBuilder menuBuilder) {
        this.B = menuBuilder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(int i4) {
        int size = this.B.size();
        for (int i5 = 0; i5 < size; i5++) {
            MenuItem item = this.B.getItem(i5);
            if (i4 == item.getItemId()) {
                this.f23968g = i4;
                this.f23969h = i5;
                item.setChecked(true);
                return;
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.B.getVisibleItems().size(), false, 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBadgeDrawables(SparseArray<BadgeDrawable> sparseArray) {
        this.f23978q = sparseArray;
        NavigationBarItemView[] navigationBarItemViewArr = this.f23967f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setBadge(sparseArray.get(navigationBarItemView.getId()));
            }
        }
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        this.f23970i = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f23967f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList colorStateList) {
        this.f23987z = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f23967f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(c());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z3) {
        this.f23981t = z3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f23967f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorEnabled(z3);
            }
        }
    }

    public void setItemActiveIndicatorHeight(@Px int i4) {
        this.f23983v = i4;
        NavigationBarItemView[] navigationBarItemViewArr = this.f23967f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorHeight(i4);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(@Px int i4) {
        this.f23984w = i4;
        NavigationBarItemView[] navigationBarItemViewArr = this.f23967f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorMarginHorizontal(i4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setItemActiveIndicatorResizeable(boolean z3) {
        this.f23986y = z3;
        NavigationBarItemView[] navigationBarItemViewArr = this.f23967f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorResizeable(z3);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.f23985x = shapeAppearanceModel;
        NavigationBarItemView[] navigationBarItemViewArr = this.f23967f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(c());
            }
        }
    }

    public void setItemActiveIndicatorWidth(@Px int i4) {
        this.f23982u = i4;
        NavigationBarItemView[] navigationBarItemViewArr = this.f23967f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorWidth(i4);
            }
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.f23976o = drawable;
        NavigationBarItemView[] navigationBarItemViewArr = this.f23967f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i4) {
        this.f23977p = i4;
        NavigationBarItemView[] navigationBarItemViewArr = this.f23967f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(i4);
            }
        }
    }

    public void setItemIconSize(@Dimension int i4) {
        this.f23971j = i4;
        NavigationBarItemView[] navigationBarItemViewArr = this.f23967f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconSize(i4);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setItemOnTouchListener(int i4, @Nullable View.OnTouchListener onTouchListener) {
        if (onTouchListener == null) {
            this.f23965d.remove(i4);
        } else {
            this.f23965d.put(i4, onTouchListener);
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.f23967f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView.getItemData().getItemId() == i4) {
                    navigationBarItemView.setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    public void setItemPaddingBottom(@Px int i4) {
        this.f23980s = i4;
        NavigationBarItemView[] navigationBarItemViewArr = this.f23967f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingBottom(i4);
            }
        }
    }

    public void setItemPaddingTop(@Px int i4) {
        this.f23979r = i4;
        NavigationBarItemView[] navigationBarItemViewArr = this.f23967f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingTop(i4);
            }
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i4) {
        this.f23975n = i4;
        NavigationBarItemView[] navigationBarItemViewArr = this.f23967f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActive(i4);
                ColorStateList colorStateList = this.f23972k;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(@StyleRes int i4) {
        this.f23974m = i4;
        NavigationBarItemView[] navigationBarItemViewArr = this.f23967f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceInactive(i4);
                ColorStateList colorStateList = this.f23972k;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f23972k = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f23967f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i4) {
        this.f23966e = i4;
    }

    public void setPresenter(@NonNull NavigationBarPresenter navigationBarPresenter) {
        this.A = navigationBarPresenter;
    }

    public void updateMenuView() {
        MenuBuilder menuBuilder = this.B;
        if (menuBuilder != null && this.f23967f != null) {
            int size = menuBuilder.size();
            if (size != this.f23967f.length) {
                buildMenuView();
                return;
            }
            int i4 = this.f23968g;
            for (int i5 = 0; i5 < size; i5++) {
                MenuItem item = this.B.getItem(i5);
                if (item.isChecked()) {
                    this.f23968g = item.getItemId();
                    this.f23969h = i5;
                }
            }
            if (i4 != this.f23968g) {
                TransitionManager.beginDelayedTransition(this, this.f23962a);
            }
            boolean f4 = f(this.f23966e, this.B.getVisibleItems().size());
            for (int i6 = 0; i6 < size; i6++) {
                this.A.setUpdateSuspended(true);
                this.f23967f[i6].setLabelVisibilityMode(this.f23966e);
                this.f23967f[i6].setShifting(f4);
                this.f23967f[i6].initialize((MenuItemImpl) this.B.getItem(i6), 0);
                this.A.setUpdateSuspended(false);
            }
        }
    }
}
