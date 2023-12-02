package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Dimension;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class NavigationMenuPresenter implements MenuPresenter {
    public static final int NO_TEXT_APPEARANCE_SET = 0;

    /* renamed from: a  reason: collision with root package name */
    private NavigationMenuView f23836a;

    /* renamed from: b  reason: collision with root package name */
    LinearLayout f23837b;

    /* renamed from: c  reason: collision with root package name */
    private MenuPresenter.Callback f23838c;

    /* renamed from: d  reason: collision with root package name */
    MenuBuilder f23839d;

    /* renamed from: e  reason: collision with root package name */
    private int f23840e;

    /* renamed from: f  reason: collision with root package name */
    NavigationMenuAdapter f23841f;

    /* renamed from: g  reason: collision with root package name */
    LayoutInflater f23842g;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    ColorStateList f23844i;

    /* renamed from: k  reason: collision with root package name */
    ColorStateList f23846k;

    /* renamed from: l  reason: collision with root package name */
    ColorStateList f23847l;

    /* renamed from: m  reason: collision with root package name */
    Drawable f23848m;

    /* renamed from: n  reason: collision with root package name */
    int f23849n;
    @Px

    /* renamed from: o  reason: collision with root package name */
    int f23850o;

    /* renamed from: p  reason: collision with root package name */
    int f23851p;

    /* renamed from: q  reason: collision with root package name */
    int f23852q;
    @Px

    /* renamed from: r  reason: collision with root package name */
    int f23853r;
    @Px

    /* renamed from: s  reason: collision with root package name */
    int f23854s;
    @Px

    /* renamed from: t  reason: collision with root package name */
    int f23855t;
    @Px

    /* renamed from: u  reason: collision with root package name */
    int f23856u;

    /* renamed from: v  reason: collision with root package name */
    boolean f23857v;

    /* renamed from: x  reason: collision with root package name */
    private int f23859x;

    /* renamed from: y  reason: collision with root package name */
    private int f23860y;

    /* renamed from: z  reason: collision with root package name */
    int f23861z;

    /* renamed from: h  reason: collision with root package name */
    int f23843h = 0;

    /* renamed from: j  reason: collision with root package name */
    int f23845j = 0;

    /* renamed from: w  reason: collision with root package name */
    boolean f23858w = true;
    private int A = -1;
    final View.OnClickListener B = new View.OnClickListener() { // from class: com.google.android.material.internal.NavigationMenuPresenter.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z3 = true;
            NavigationMenuPresenter.this.setUpdateSuspended(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            boolean performItemAction = navigationMenuPresenter.f23839d.performItemAction(itemData, navigationMenuPresenter, 0);
            if (itemData != null && itemData.isCheckable() && performItemAction) {
                NavigationMenuPresenter.this.f23841f.j(itemData);
            } else {
                z3 = false;
            }
            NavigationMenuPresenter.this.setUpdateSuspended(false);
            if (z3) {
                NavigationMenuPresenter.this.updateMenuView(false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class HeaderViewHolder extends ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class NavigationMenuAdapter extends RecyclerView.Adapter<ViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList<NavigationMenuItem> f23863a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        private MenuItemImpl f23864b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f23865c;

        NavigationMenuAdapter() {
            h();
        }

        private void a(int i4, int i5) {
            while (i4 < i5) {
                ((NavigationMenuTextItem) this.f23863a.get(i4)).f23870b = true;
                i4++;
            }
        }

        private void h() {
            if (this.f23865c) {
                return;
            }
            this.f23865c = true;
            this.f23863a.clear();
            this.f23863a.add(new NavigationMenuHeaderItem());
            int size = NavigationMenuPresenter.this.f23839d.getVisibleItems().size();
            int i4 = -1;
            boolean z3 = false;
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                MenuItemImpl menuItemImpl = NavigationMenuPresenter.this.f23839d.getVisibleItems().get(i6);
                if (menuItemImpl.isChecked()) {
                    j(menuItemImpl);
                }
                if (menuItemImpl.isCheckable()) {
                    menuItemImpl.setExclusiveCheckable(false);
                }
                if (menuItemImpl.hasSubMenu()) {
                    SubMenu subMenu = menuItemImpl.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i6 != 0) {
                            this.f23863a.add(new NavigationMenuSeparatorItem(NavigationMenuPresenter.this.f23861z, 0));
                        }
                        this.f23863a.add(new NavigationMenuTextItem(menuItemImpl));
                        int size2 = this.f23863a.size();
                        int size3 = subMenu.size();
                        boolean z4 = false;
                        for (int i7 = 0; i7 < size3; i7++) {
                            MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i7);
                            if (menuItemImpl2.isVisible()) {
                                if (!z4 && menuItemImpl2.getIcon() != null) {
                                    z4 = true;
                                }
                                if (menuItemImpl2.isCheckable()) {
                                    menuItemImpl2.setExclusiveCheckable(false);
                                }
                                if (menuItemImpl.isChecked()) {
                                    j(menuItemImpl);
                                }
                                this.f23863a.add(new NavigationMenuTextItem(menuItemImpl2));
                            }
                        }
                        if (z4) {
                            a(size2, this.f23863a.size());
                        }
                    }
                } else {
                    int groupId = menuItemImpl.getGroupId();
                    if (groupId != i4) {
                        i5 = this.f23863a.size();
                        if (menuItemImpl.getIcon() != null) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (i6 != 0) {
                            i5++;
                            ArrayList<NavigationMenuItem> arrayList = this.f23863a;
                            int i8 = NavigationMenuPresenter.this.f23861z;
                            arrayList.add(new NavigationMenuSeparatorItem(i8, i8));
                        }
                    } else if (!z3 && menuItemImpl.getIcon() != null) {
                        a(i5, this.f23863a.size());
                        z3 = true;
                    }
                    NavigationMenuTextItem navigationMenuTextItem = new NavigationMenuTextItem(menuItemImpl);
                    navigationMenuTextItem.f23870b = z3;
                    this.f23863a.add(navigationMenuTextItem);
                    i4 = groupId;
                }
            }
            this.f23865c = false;
        }

        @NonNull
        public Bundle b() {
            View view;
            Bundle bundle = new Bundle();
            MenuItemImpl menuItemImpl = this.f23864b;
            if (menuItemImpl != null) {
                bundle.putInt("android:menu:checked", menuItemImpl.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.f23863a.size();
            for (int i4 = 0; i4 < size; i4++) {
                NavigationMenuItem navigationMenuItem = this.f23863a.get(i4);
                if (navigationMenuItem instanceof NavigationMenuTextItem) {
                    MenuItemImpl a4 = ((NavigationMenuTextItem) navigationMenuItem).a();
                    if (a4 != null) {
                        view = a4.getActionView();
                    } else {
                        view = null;
                    }
                    if (view != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        view.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(a4.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public MenuItemImpl c() {
            return this.f23864b;
        }

        int d() {
            int i4;
            if (NavigationMenuPresenter.this.f23837b.getChildCount() == 0) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            for (int i5 = 0; i5 < NavigationMenuPresenter.this.f23841f.getItemCount(); i5++) {
                if (NavigationMenuPresenter.this.f23841f.getItemViewType(i5) == 0) {
                    i4++;
                }
            }
            return i4;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e */
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i4) {
            Drawable drawable;
            int itemViewType = getItemViewType(i4);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    if (itemViewType == 2) {
                        NavigationMenuSeparatorItem navigationMenuSeparatorItem = (NavigationMenuSeparatorItem) this.f23863a.get(i4);
                        viewHolder.itemView.setPadding(NavigationMenuPresenter.this.f23853r, navigationMenuSeparatorItem.b(), NavigationMenuPresenter.this.f23854s, navigationMenuSeparatorItem.a());
                        return;
                    }
                    return;
                }
                TextView textView = (TextView) viewHolder.itemView;
                textView.setText(((NavigationMenuTextItem) this.f23863a.get(i4)).a().getTitle());
                int i5 = NavigationMenuPresenter.this.f23843h;
                if (i5 != 0) {
                    TextViewCompat.setTextAppearance(textView, i5);
                }
                textView.setPadding(NavigationMenuPresenter.this.f23855t, textView.getPaddingTop(), NavigationMenuPresenter.this.f23856u, textView.getPaddingBottom());
                ColorStateList colorStateList = NavigationMenuPresenter.this.f23844i;
                if (colorStateList != null) {
                    textView.setTextColor(colorStateList);
                    return;
                }
                return;
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) viewHolder.itemView;
            navigationMenuItemView.setIconTintList(NavigationMenuPresenter.this.f23847l);
            int i6 = NavigationMenuPresenter.this.f23845j;
            if (i6 != 0) {
                navigationMenuItemView.setTextAppearance(i6);
            }
            ColorStateList colorStateList2 = NavigationMenuPresenter.this.f23846k;
            if (colorStateList2 != null) {
                navigationMenuItemView.setTextColor(colorStateList2);
            }
            Drawable drawable2 = NavigationMenuPresenter.this.f23848m;
            if (drawable2 != null) {
                drawable = drawable2.getConstantState().newDrawable();
            } else {
                drawable = null;
            }
            ViewCompat.setBackground(navigationMenuItemView, drawable);
            NavigationMenuTextItem navigationMenuTextItem = (NavigationMenuTextItem) this.f23863a.get(i4);
            navigationMenuItemView.setNeedsEmptyIcon(navigationMenuTextItem.f23870b);
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            int i7 = navigationMenuPresenter.f23849n;
            int i8 = navigationMenuPresenter.f23850o;
            navigationMenuItemView.setPadding(i7, i8, i7, i8);
            navigationMenuItemView.setIconPadding(NavigationMenuPresenter.this.f23851p);
            NavigationMenuPresenter navigationMenuPresenter2 = NavigationMenuPresenter.this;
            if (navigationMenuPresenter2.f23857v) {
                navigationMenuItemView.setIconSize(navigationMenuPresenter2.f23852q);
            }
            navigationMenuItemView.setMaxLines(NavigationMenuPresenter.this.f23859x);
            navigationMenuItemView.initialize(navigationMenuTextItem.a(), 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @Nullable
        /* renamed from: f */
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            return null;
                        }
                        return new HeaderViewHolder(NavigationMenuPresenter.this.f23837b);
                    }
                    return new SeparatorViewHolder(NavigationMenuPresenter.this.f23842g, viewGroup);
                }
                return new SubheaderViewHolder(NavigationMenuPresenter.this.f23842g, viewGroup);
            }
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            return new NormalViewHolder(navigationMenuPresenter.f23842g, viewGroup, navigationMenuPresenter.B);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: g */
        public void onViewRecycled(ViewHolder viewHolder) {
            if (viewHolder instanceof NormalViewHolder) {
                ((NavigationMenuItemView) viewHolder.itemView).recycle();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f23863a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i4) {
            return i4;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i4) {
            NavigationMenuItem navigationMenuItem = this.f23863a.get(i4);
            if (navigationMenuItem instanceof NavigationMenuSeparatorItem) {
                return 2;
            }
            if (navigationMenuItem instanceof NavigationMenuHeaderItem) {
                return 3;
            }
            if (navigationMenuItem instanceof NavigationMenuTextItem) {
                if (((NavigationMenuTextItem) navigationMenuItem).a().hasSubMenu()) {
                    return 1;
                }
                return 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        public void i(@NonNull Bundle bundle) {
            MenuItemImpl a4;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            MenuItemImpl a5;
            int i4 = bundle.getInt("android:menu:checked", 0);
            if (i4 != 0) {
                this.f23865c = true;
                int size = this.f23863a.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        break;
                    }
                    NavigationMenuItem navigationMenuItem = this.f23863a.get(i5);
                    if ((navigationMenuItem instanceof NavigationMenuTextItem) && (a5 = ((NavigationMenuTextItem) navigationMenuItem).a()) != null && a5.getItemId() == i4) {
                        j(a5);
                        break;
                    }
                    i5++;
                }
                this.f23865c = false;
                h();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.f23863a.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    NavigationMenuItem navigationMenuItem2 = this.f23863a.get(i6);
                    if ((navigationMenuItem2 instanceof NavigationMenuTextItem) && (a4 = ((NavigationMenuTextItem) navigationMenuItem2).a()) != null && (actionView = a4.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(a4.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void j(@NonNull MenuItemImpl menuItemImpl) {
            if (this.f23864b != menuItemImpl && menuItemImpl.isCheckable()) {
                MenuItemImpl menuItemImpl2 = this.f23864b;
                if (menuItemImpl2 != null) {
                    menuItemImpl2.setChecked(false);
                }
                this.f23864b = menuItemImpl;
                menuItemImpl.setChecked(true);
            }
        }

        public void k(boolean z3) {
            this.f23865c = z3;
        }

        public void l() {
            h();
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class NavigationMenuHeaderItem implements NavigationMenuItem {
        NavigationMenuHeaderItem() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface NavigationMenuItem {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class NavigationMenuSeparatorItem implements NavigationMenuItem {

        /* renamed from: a  reason: collision with root package name */
        private final int f23867a;

        /* renamed from: b  reason: collision with root package name */
        private final int f23868b;

        public NavigationMenuSeparatorItem(int i4, int i5) {
            this.f23867a = i4;
            this.f23868b = i5;
        }

        public int a() {
            return this.f23868b;
        }

        public int b() {
            return this.f23867a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class NavigationMenuTextItem implements NavigationMenuItem {

        /* renamed from: a  reason: collision with root package name */
        private final MenuItemImpl f23869a;

        /* renamed from: b  reason: collision with root package name */
        boolean f23870b;

        NavigationMenuTextItem(MenuItemImpl menuItemImpl) {
            this.f23869a = menuItemImpl;
        }

        public MenuItemImpl a() {
            return this.f23869a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class NavigationMenuViewAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {
        NavigationMenuViewAccessibilityDelegate(@NonNull RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(NavigationMenuPresenter.this.f23841f.d(), 0, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class NormalViewHolder extends ViewHolder {
        public NormalViewHolder(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class SeparatorViewHolder extends ViewHolder {
        public SeparatorViewHolder(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class SubheaderViewHolder extends ViewHolder {
        public SubheaderViewHolder(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* loaded from: classes5.dex */
    private static abstract class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    private void b() {
        int i4;
        if (this.f23837b.getChildCount() == 0 && this.f23858w) {
            i4 = this.f23860y;
        } else {
            i4 = 0;
        }
        NavigationMenuView navigationMenuView = this.f23836a;
        navigationMenuView.setPadding(0, i4, 0, navigationMenuView.getPaddingBottom());
    }

    public void addHeaderView(@NonNull View view) {
        this.f23837b.addView(view);
        NavigationMenuView navigationMenuView = this.f23836a;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void dispatchApplyWindowInsets(@NonNull WindowInsetsCompat windowInsetsCompat) {
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        if (this.f23860y != systemWindowInsetTop) {
            this.f23860y = systemWindowInsetTop;
            b();
        }
        NavigationMenuView navigationMenuView = this.f23836a;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom());
        ViewCompat.dispatchApplyWindowInsets(this.f23837b, windowInsetsCompat);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Nullable
    public MenuItemImpl getCheckedItem() {
        return this.f23841f.c();
    }

    @Px
    public int getDividerInsetEnd() {
        return this.f23854s;
    }

    @Px
    public int getDividerInsetStart() {
        return this.f23853r;
    }

    public int getHeaderCount() {
        return this.f23837b.getChildCount();
    }

    public View getHeaderView(int i4) {
        return this.f23837b.getChildAt(i4);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f23840e;
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.f23848m;
    }

    public int getItemHorizontalPadding() {
        return this.f23849n;
    }

    public int getItemIconPadding() {
        return this.f23851p;
    }

    public int getItemMaxLines() {
        return this.f23859x;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f23846k;
    }

    @Nullable
    public ColorStateList getItemTintList() {
        return this.f23847l;
    }

    @Px
    public int getItemVerticalPadding() {
        return this.f23850o;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.f23836a == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.f23842g.inflate(R.layout.design_navigation_menu, viewGroup, false);
            this.f23836a = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new NavigationMenuViewAccessibilityDelegate(this.f23836a));
            if (this.f23841f == null) {
                this.f23841f = new NavigationMenuAdapter();
            }
            int i4 = this.A;
            if (i4 != -1) {
                this.f23836a.setOverScrollMode(i4);
            }
            this.f23837b = (LinearLayout) this.f23842g.inflate(R.layout.design_navigation_item_header, (ViewGroup) this.f23836a, false);
            this.f23836a.setAdapter(this.f23841f);
        }
        return this.f23836a;
    }

    @Px
    public int getSubheaderInsetEnd() {
        return this.f23856u;
    }

    @Px
    public int getSubheaderInsetStart() {
        return this.f23855t;
    }

    public View inflateHeaderView(@LayoutRes int i4) {
        View inflate = this.f23842g.inflate(i4, (ViewGroup) this.f23837b, false);
        addHeaderView(inflate);
        return inflate;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this.f23842g = LayoutInflater.from(context);
        this.f23839d = menuBuilder;
        this.f23861z = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    public boolean isBehindStatusBar() {
        return this.f23858w;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z3) {
        MenuPresenter.Callback callback = this.f23838c;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z3);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(ListMenuPresenter.VIEWS_TAG);
            if (sparseParcelableArray != null) {
                this.f23836a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f23841f.i(bundle2);
            }
            SparseArray<Parcelable> sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f23837b.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.f23836a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f23836a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray(ListMenuPresenter.VIEWS_TAG, sparseArray);
        }
        NavigationMenuAdapter navigationMenuAdapter = this.f23841f;
        if (navigationMenuAdapter != null) {
            bundle.putBundle("android:menu:adapter", navigationMenuAdapter.b());
        }
        if (this.f23837b != null) {
            SparseArray<Parcelable> sparseArray2 = new SparseArray<>();
            this.f23837b.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void removeHeaderView(@NonNull View view) {
        this.f23837b.removeView(view);
        if (this.f23837b.getChildCount() == 0) {
            NavigationMenuView navigationMenuView = this.f23836a;
            navigationMenuView.setPadding(0, this.f23860y, 0, navigationMenuView.getPaddingBottom());
        }
    }

    public void setBehindStatusBar(boolean z3) {
        if (this.f23858w != z3) {
            this.f23858w = z3;
            b();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.f23838c = callback;
    }

    public void setCheckedItem(@NonNull MenuItemImpl menuItemImpl) {
        this.f23841f.j(menuItemImpl);
    }

    public void setDividerInsetEnd(@Px int i4) {
        this.f23854s = i4;
        updateMenuView(false);
    }

    public void setDividerInsetStart(@Px int i4) {
        this.f23853r = i4;
        updateMenuView(false);
    }

    public void setId(int i4) {
        this.f23840e = i4;
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.f23848m = drawable;
        updateMenuView(false);
    }

    public void setItemHorizontalPadding(int i4) {
        this.f23849n = i4;
        updateMenuView(false);
    }

    public void setItemIconPadding(int i4) {
        this.f23851p = i4;
        updateMenuView(false);
    }

    public void setItemIconSize(@Dimension int i4) {
        if (this.f23852q != i4) {
            this.f23852q = i4;
            this.f23857v = true;
            updateMenuView(false);
        }
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.f23847l = colorStateList;
        updateMenuView(false);
    }

    public void setItemMaxLines(int i4) {
        this.f23859x = i4;
        updateMenuView(false);
    }

    public void setItemTextAppearance(@StyleRes int i4) {
        this.f23845j = i4;
        updateMenuView(false);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f23846k = colorStateList;
        updateMenuView(false);
    }

    public void setItemVerticalPadding(@Px int i4) {
        this.f23850o = i4;
        updateMenuView(false);
    }

    public void setOverScrollMode(int i4) {
        this.A = i4;
        NavigationMenuView navigationMenuView = this.f23836a;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i4);
        }
    }

    public void setSubheaderColor(@Nullable ColorStateList colorStateList) {
        this.f23844i = colorStateList;
        updateMenuView(false);
    }

    public void setSubheaderInsetEnd(@Px int i4) {
        this.f23856u = i4;
        updateMenuView(false);
    }

    public void setSubheaderInsetStart(@Px int i4) {
        this.f23855t = i4;
        updateMenuView(false);
    }

    public void setSubheaderTextAppearance(@StyleRes int i4) {
        this.f23843h = i4;
        updateMenuView(false);
    }

    public void setUpdateSuspended(boolean z3) {
        NavigationMenuAdapter navigationMenuAdapter = this.f23841f;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.k(z3);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z3) {
        NavigationMenuAdapter navigationMenuAdapter = this.f23841f;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.l();
        }
    }
}
