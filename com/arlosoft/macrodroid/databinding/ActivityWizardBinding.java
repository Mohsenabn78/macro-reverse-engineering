package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.arlosoft.macrodroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes3.dex */
public final class ActivityWizardBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f10980a;
    @NonNull
    public final FrameLayout contentOverlay;
    @NonNull
    public final CoordinatorLayout coordinatorLayout;
    @NonNull
    public final FloatingActionButton fab;
    @NonNull
    public final TabLayout tabbar;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final LinearLayout toolbarContainer;
    @NonNull
    public final LinearLayout topContainer;
    @NonNull
    public final RelativeLayout triggerOverlay;
    @NonNull
    public final ViewPager viewpager;

    private ActivityWizardBinding(@NonNull View view, @NonNull FrameLayout frameLayout, @NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull TabLayout tabLayout, @NonNull Toolbar toolbar, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull RelativeLayout relativeLayout, @NonNull ViewPager viewPager) {
        this.f10980a = view;
        this.contentOverlay = frameLayout;
        this.coordinatorLayout = coordinatorLayout;
        this.fab = floatingActionButton;
        this.tabbar = tabLayout;
        this.toolbar = toolbar;
        this.toolbarContainer = linearLayout;
        this.topContainer = linearLayout2;
        this.triggerOverlay = relativeLayout;
        this.viewpager = viewPager;
    }

    @NonNull
    public static ActivityWizardBinding bind(@NonNull View view) {
        int i4 = R.id.content_overlay;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.content_overlay);
        if (frameLayout != null) {
            i4 = R.id.coordinator_layout;
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view, R.id.coordinator_layout);
            if (coordinatorLayout != null) {
                i4 = R.id.fab;
                FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.fab);
                if (floatingActionButton != null) {
                    i4 = R.id.tabbar;
                    TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, R.id.tabbar);
                    if (tabLayout != null) {
                        i4 = R.id.toolbar;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                        if (toolbar != null) {
                            i4 = R.id.toolbar_container;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.toolbar_container);
                            if (linearLayout != null) {
                                i4 = R.id.top_container;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.top_container);
                                if (linearLayout2 != null) {
                                    i4 = R.id.triggerOverlay;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.triggerOverlay);
                                    if (relativeLayout != null) {
                                        i4 = R.id.viewpager;
                                        ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, R.id.viewpager);
                                        if (viewPager != null) {
                                            return new ActivityWizardBinding(view, frameLayout, coordinatorLayout, floatingActionButton, tabLayout, toolbar, linearLayout, linearLayout2, relativeLayout, viewPager);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityWizardBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.activity_wizard, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f10980a;
    }
}
