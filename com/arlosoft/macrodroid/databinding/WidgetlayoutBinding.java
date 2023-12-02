package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class WidgetlayoutBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11429a;
    @NonNull
    public final ImageButton widgetButton;

    private WidgetlayoutBinding(@NonNull FrameLayout frameLayout, @NonNull ImageButton imageButton) {
        this.f11429a = frameLayout;
        this.widgetButton = imageButton;
    }

    @NonNull
    public static WidgetlayoutBinding bind(@NonNull View view) {
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.widget_button);
        if (imageButton != null) {
            return new WidgetlayoutBinding((FrameLayout) view, imageButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.widget_button)));
    }

    @NonNull
    public static WidgetlayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static WidgetlayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.widgetlayout, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11429a;
    }
}
