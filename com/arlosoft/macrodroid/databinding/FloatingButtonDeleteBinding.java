package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class FloatingButtonDeleteBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f11217a;

    private FloatingButtonDeleteBinding(@NonNull ImageView imageView) {
        this.f11217a = imageView;
    }

    @NonNull
    public static FloatingButtonDeleteBinding bind(@NonNull View view) {
        if (view != null) {
            return new FloatingButtonDeleteBinding((ImageView) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static FloatingButtonDeleteBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FloatingButtonDeleteBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.floating_button_delete, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ImageView getRoot() {
        return this.f11217a;
    }
}
