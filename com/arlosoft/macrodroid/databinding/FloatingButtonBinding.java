package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.melnykov.fab.FloatingActionButton;

/* loaded from: classes3.dex */
public final class FloatingButtonBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11216a;
    @NonNull
    public final FloatingActionButton fab;

    private FloatingButtonBinding(@NonNull FrameLayout frameLayout, @NonNull FloatingActionButton floatingActionButton) {
        this.f11216a = frameLayout;
        this.fab = floatingActionButton;
    }

    @NonNull
    public static FloatingButtonBinding bind(@NonNull View view) {
        FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.fab);
        if (floatingActionButton != null) {
            return new FloatingButtonBinding((FrameLayout) view, floatingActionButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.fab)));
    }

    @NonNull
    public static FloatingButtonBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FloatingButtonBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.floating_button, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11216a;
    }
}
