package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/* loaded from: classes3.dex */
public final class ActivityNewHomeScreenBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10958a;
    @NonNull
    public final BottomNavigationView bottomNavigation;
    @NonNull
    public final LinearLayout container;

    private ActivityNewHomeScreenBinding(@NonNull LinearLayout linearLayout, @NonNull BottomNavigationView bottomNavigationView, @NonNull LinearLayout linearLayout2) {
        this.f10958a = linearLayout;
        this.bottomNavigation = bottomNavigationView;
        this.container = linearLayout2;
    }

    @NonNull
    public static ActivityNewHomeScreenBinding bind(@NonNull View view) {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) ViewBindings.findChildViewById(view, R.id.bottomNavigation);
        if (bottomNavigationView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            return new ActivityNewHomeScreenBinding(linearLayout, bottomNavigationView, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.bottomNavigation)));
    }

    @NonNull
    public static ActivityNewHomeScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityNewHomeScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_new_home_screen, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10958a;
    }
}
