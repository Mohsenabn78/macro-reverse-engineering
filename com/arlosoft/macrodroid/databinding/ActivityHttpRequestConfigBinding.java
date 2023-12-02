package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.arlosoft.macrodroid.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes3.dex */
public final class ActivityHttpRequestConfigBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10944a;
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final TabLayout tabBar;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final ViewPager viewPager;

    private ActivityHttpRequestConfigBinding(@NonNull LinearLayout linearLayout, @NonNull AppBarLayout appBarLayout, @NonNull TabLayout tabLayout, @NonNull Toolbar toolbar, @NonNull ViewPager viewPager) {
        this.f10944a = linearLayout;
        this.appBarLayout = appBarLayout;
        this.tabBar = tabLayout;
        this.toolbar = toolbar;
        this.viewPager = viewPager;
    }

    @NonNull
    public static ActivityHttpRequestConfigBinding bind(@NonNull View view) {
        int i4 = R.id.appBarLayout;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, R.id.appBarLayout);
        if (appBarLayout != null) {
            i4 = R.id.tabBar;
            TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, R.id.tabBar);
            if (tabLayout != null) {
                i4 = R.id.toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                if (toolbar != null) {
                    i4 = R.id.viewPager;
                    ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, R.id.viewPager);
                    if (viewPager != null) {
                        return new ActivityHttpRequestConfigBinding((LinearLayout) view, appBarLayout, tabLayout, toolbar, viewPager);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityHttpRequestConfigBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityHttpRequestConfigBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_http_request_config, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10944a;
    }
}
