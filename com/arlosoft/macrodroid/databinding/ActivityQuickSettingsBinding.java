package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ActivityQuickSettingsBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final NestedScrollView f10962a;
    @NonNull
    public final LinearLayout buttonsContainer;

    private ActivityQuickSettingsBinding(@NonNull NestedScrollView nestedScrollView, @NonNull LinearLayout linearLayout) {
        this.f10962a = nestedScrollView;
        this.buttonsContainer = linearLayout;
    }

    @NonNull
    public static ActivityQuickSettingsBinding bind(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.buttons_container);
        if (linearLayout != null) {
            return new ActivityQuickSettingsBinding((NestedScrollView) view, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.buttons_container)));
    }

    @NonNull
    public static ActivityQuickSettingsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityQuickSettingsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_quick_settings, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public NestedScrollView getRoot() {
        return this.f10962a;
    }
}
