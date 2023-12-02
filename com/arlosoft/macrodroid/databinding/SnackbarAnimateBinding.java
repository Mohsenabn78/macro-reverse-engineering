package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.arlosoft.macrodroid.R;
import com.google.android.material.snackbar.SnackbarAnimate;

/* loaded from: classes3.dex */
public final class SnackbarAnimateBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final SnackbarAnimate.SnackbarLayout f11376a;

    private SnackbarAnimateBinding(@NonNull SnackbarAnimate.SnackbarLayout snackbarLayout) {
        this.f11376a = snackbarLayout;
    }

    @NonNull
    public static SnackbarAnimateBinding bind(@NonNull View view) {
        if (view != null) {
            return new SnackbarAnimateBinding((SnackbarAnimate.SnackbarLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static SnackbarAnimateBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SnackbarAnimateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.snackbar_animate, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public SnackbarAnimate.SnackbarLayout getRoot() {
        return this.f11376a;
    }
}
