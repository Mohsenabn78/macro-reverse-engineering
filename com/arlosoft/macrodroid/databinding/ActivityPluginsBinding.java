package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.arlosoft.macrodroid.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes3.dex */
public final class ActivityPluginsBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f10961a;
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final CoordinatorLayout coordinatorLayout;
    @NonNull
    public final FrameLayout loadingBlocker;
    @NonNull
    public final TabLayout tabBar;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final ViewPager2 viewPager;

    private ActivityPluginsBinding(@NonNull FrameLayout frameLayout, @NonNull AppBarLayout appBarLayout, @NonNull CoordinatorLayout coordinatorLayout, @NonNull FrameLayout frameLayout2, @NonNull TabLayout tabLayout, @NonNull Toolbar toolbar, @NonNull ViewPager2 viewPager2) {
        this.f10961a = frameLayout;
        this.appBarLayout = appBarLayout;
        this.coordinatorLayout = coordinatorLayout;
        this.loadingBlocker = frameLayout2;
        this.tabBar = tabLayout;
        this.toolbar = toolbar;
        this.viewPager = viewPager2;
    }

    @NonNull
    public static ActivityPluginsBinding bind(@NonNull View view) {
        int i4 = R.id.appBarLayout;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, R.id.appBarLayout);
        if (appBarLayout != null) {
            i4 = R.id.coordinator_layout;
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view, R.id.coordinator_layout);
            if (coordinatorLayout != null) {
                i4 = R.id.loadingBlocker;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.loadingBlocker);
                if (frameLayout != null) {
                    i4 = R.id.tabBar;
                    TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, R.id.tabBar);
                    if (tabLayout != null) {
                        i4 = R.id.toolbar;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                        if (toolbar != null) {
                            i4 = R.id.viewPager;
                            ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, R.id.viewPager);
                            if (viewPager2 != null) {
                                return new ActivityPluginsBinding((FrameLayout) view, appBarLayout, coordinatorLayout, frameLayout, tabLayout, toolbar, viewPager2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityPluginsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityPluginsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_plugins, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f10961a;
    }
}
