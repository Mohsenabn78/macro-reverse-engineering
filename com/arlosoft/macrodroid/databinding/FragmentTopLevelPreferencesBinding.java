package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: classes3.dex */
public final class FragmentTopLevelPreferencesBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11238a;
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final FrameLayout content;
    @NonNull
    public final TextView title;
    @NonNull
    public final Toolbar toolbar;

    private FragmentTopLevelPreferencesBinding(@NonNull LinearLayout linearLayout, @NonNull AppBarLayout appBarLayout, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull Toolbar toolbar) {
        this.f11238a = linearLayout;
        this.appBarLayout = appBarLayout;
        this.content = frameLayout;
        this.title = textView;
        this.toolbar = toolbar;
    }

    @NonNull
    public static FragmentTopLevelPreferencesBinding bind(@NonNull View view) {
        int i4 = R.id.appBarLayout;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, R.id.appBarLayout);
        if (appBarLayout != null) {
            i4 = R.id.content;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.content);
            if (frameLayout != null) {
                i4 = R.id.title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                if (textView != null) {
                    i4 = R.id.toolbar;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                    if (toolbar != null) {
                        return new FragmentTopLevelPreferencesBinding((LinearLayout) view, appBarLayout, frameLayout, textView, toolbar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static FragmentTopLevelPreferencesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentTopLevelPreferencesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.fragment_top_level_preferences, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11238a;
    }
}
