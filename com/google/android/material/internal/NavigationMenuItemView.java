package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.ItemView {

    /* renamed from: q  reason: collision with root package name */
    private static final int[] f23824q = {16842912};

    /* renamed from: g  reason: collision with root package name */
    private int f23825g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f23826h;

    /* renamed from: i  reason: collision with root package name */
    boolean f23827i;

    /* renamed from: j  reason: collision with root package name */
    private final CheckedTextView f23828j;

    /* renamed from: k  reason: collision with root package name */
    private FrameLayout f23829k;

    /* renamed from: l  reason: collision with root package name */
    private MenuItemImpl f23830l;

    /* renamed from: m  reason: collision with root package name */
    private ColorStateList f23831m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f23832n;

    /* renamed from: o  reason: collision with root package name */
    private Drawable f23833o;

    /* renamed from: p  reason: collision with root package name */
    private final AccessibilityDelegateCompat f23834p;

    public NavigationMenuItemView(@NonNull Context context) {
        this(context, null);
    }

    private void a() {
        if (c()) {
            this.f23828j.setVisibility(8);
            FrameLayout frameLayout = this.f23829k;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) layoutParams).width = -1;
                this.f23829k.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.f23828j.setVisibility(0);
        FrameLayout frameLayout2 = this.f23829k;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams2).width = -2;
            this.f23829k.setLayoutParams(layoutParams2);
        }
    }

    @Nullable
    private StateListDrawable b() {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(R.attr.colorControlHighlight, typedValue, true)) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(f23824q, new ColorDrawable(typedValue.data));
            stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            return stateListDrawable;
        }
        return null;
    }

    private boolean c() {
        if (this.f23830l.getTitle() == null && this.f23830l.getIcon() == null && this.f23830l.getActionView() != null) {
            return true;
        }
        return false;
    }

    private void setActionView(@Nullable View view) {
        if (view != null) {
            if (this.f23829k == null) {
                this.f23829k = (FrameLayout) ((ViewStub) findViewById(com.google.android.material.R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.f23829k.removeAllViews();
            this.f23829k.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.f23830l;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i4) {
        int i5;
        this.f23830l = menuItemImpl;
        if (menuItemImpl.getItemId() > 0) {
            setId(menuItemImpl.getItemId());
        }
        if (menuItemImpl.isVisible()) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        setVisibility(i5);
        if (getBackground() == null) {
            ViewCompat.setBackground(this, b());
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setActionView(menuItemImpl.getActionView());
        setContentDescription(menuItemImpl.getContentDescription());
        TooltipCompat.setTooltipText(this, menuItemImpl.getTooltipText());
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i4) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i4 + 1);
        MenuItemImpl menuItemImpl = this.f23830l;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.f23830l.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f23824q);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void recycle() {
        FrameLayout frameLayout = this.f23829k;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.f23828j.setCompoundDrawables(null, null, null, null);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z3) {
        refreshDrawableState();
        if (this.f23827i != z3) {
            this.f23827i = z3;
            this.f23834p.sendAccessibilityEvent(this.f23828j, 2048);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z3) {
        refreshDrawableState();
        this.f23828j.setChecked(z3);
    }

    public void setHorizontalPadding(int i4) {
        setPadding(i4, getPaddingTop(), i4, getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            if (this.f23832n) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.wrap(drawable).mutate();
                DrawableCompat.setTintList(drawable, this.f23831m);
            }
            int i4 = this.f23825g;
            drawable.setBounds(0, 0, i4, i4);
        } else if (this.f23826h) {
            if (this.f23833o == null) {
                Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), com.google.android.material.R.drawable.navigation_empty_icon, getContext().getTheme());
                this.f23833o = drawable2;
                if (drawable2 != null) {
                    int i5 = this.f23825g;
                    drawable2.setBounds(0, 0, i5, i5);
                }
            }
            drawable = this.f23833o;
        }
        TextViewCompat.setCompoundDrawablesRelative(this.f23828j, drawable, null, null, null);
    }

    public void setIconPadding(int i4) {
        this.f23828j.setCompoundDrawablePadding(i4);
    }

    public void setIconSize(@Dimension int i4) {
        this.f23825g = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIconTintList(ColorStateList colorStateList) {
        boolean z3;
        this.f23831m = colorStateList;
        if (colorStateList != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f23832n = z3;
        MenuItemImpl menuItemImpl = this.f23830l;
        if (menuItemImpl != null) {
            setIcon(menuItemImpl.getIcon());
        }
    }

    public void setMaxLines(int i4) {
        this.f23828j.setMaxLines(i4);
    }

    public void setNeedsEmptyIcon(boolean z3) {
        this.f23826h = z3;
    }

    public void setTextAppearance(int i4) {
        TextViewCompat.setTextAppearance(this.f23828j, i4);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f23828j.setTextColor(colorStateList);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        this.f23828j.setText(charSequence);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        AccessibilityDelegateCompat accessibilityDelegateCompat = new AccessibilityDelegateCompat() { // from class: com.google.android.material.internal.NavigationMenuItemView.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setCheckable(NavigationMenuItemView.this.f23827i);
            }
        };
        this.f23834p = accessibilityDelegateCompat;
        setOrientation(0);
        LayoutInflater.from(context).inflate(com.google.android.material.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(com.google.android.material.R.id.design_menu_item_text);
        this.f23828j = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        ViewCompat.setAccessibilityDelegate(checkedTextView, accessibilityDelegateCompat);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z3, char c4) {
    }
}
