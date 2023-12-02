package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.arlosoft.macrodroid.R;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes3.dex */
public final class ActivityTroubleshootingBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10972a;
    @NonNull
    public final Button reportBugButton;
    @NonNull
    public final TabLayout tabLayout;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final ViewPager2 viewPager;

    private ActivityTroubleshootingBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull TabLayout tabLayout, @NonNull Toolbar toolbar, @NonNull ViewPager2 viewPager2) {
        this.f10972a = linearLayout;
        this.reportBugButton = button;
        this.tabLayout = tabLayout;
        this.toolbar = toolbar;
        this.viewPager = viewPager2;
    }

    @NonNull
    public static ActivityTroubleshootingBinding bind(@NonNull View view) {
        int i4 = R.id.reportBugButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.reportBugButton);
        if (button != null) {
            i4 = R.id.tabLayout;
            TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, R.id.tabLayout);
            if (tabLayout != null) {
                i4 = R.id.toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                if (toolbar != null) {
                    i4 = R.id.viewPager;
                    ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, R.id.viewPager);
                    if (viewPager2 != null) {
                        return new ActivityTroubleshootingBinding((LinearLayout) view, button, tabLayout, toolbar, viewPager2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityTroubleshootingBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityTroubleshootingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_troubleshooting, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10972a;
    }
}
