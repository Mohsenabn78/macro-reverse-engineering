package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.arlosoft.macrodroid.R;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes3.dex */
public final class DialogSelectIconBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11121a;
    @NonNull
    public final ViewPager selectIconTopLevelViewPager;
    @NonNull
    public final TabLayout tabs;

    private DialogSelectIconBinding(@NonNull LinearLayout linearLayout, @NonNull ViewPager viewPager, @NonNull TabLayout tabLayout) {
        this.f11121a = linearLayout;
        this.selectIconTopLevelViewPager = viewPager;
        this.tabs = tabLayout;
    }

    @NonNull
    public static DialogSelectIconBinding bind(@NonNull View view) {
        int i4 = R.id.select_icon_top_level_view_pager;
        ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, R.id.select_icon_top_level_view_pager);
        if (viewPager != null) {
            i4 = R.id.tabs;
            TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, R.id.tabs);
            if (tabLayout != null) {
                return new DialogSelectIconBinding((LinearLayout) view, viewPager, tabLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogSelectIconBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogSelectIconBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_select_icon, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11121a;
    }
}
