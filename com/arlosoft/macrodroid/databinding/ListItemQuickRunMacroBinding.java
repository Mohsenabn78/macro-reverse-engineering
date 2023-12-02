package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class ListItemQuickRunMacroBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f11305a;
    @NonNull
    public final MaterialCardView container;
    @NonNull
    public final ImageView deleteButton;
    @NonNull
    public final TextView macroName;

    private ListItemQuickRunMacroBinding(@NonNull MaterialCardView materialCardView, @NonNull MaterialCardView materialCardView2, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f11305a = materialCardView;
        this.container = materialCardView2;
        this.deleteButton = imageView;
        this.macroName = textView;
    }

    @NonNull
    public static ListItemQuickRunMacroBinding bind(@NonNull View view) {
        MaterialCardView materialCardView = (MaterialCardView) view;
        int i4 = R.id.deleteButton;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.deleteButton);
        if (imageView != null) {
            i4 = R.id.macroName;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.macroName);
            if (textView != null) {
                return new ListItemQuickRunMacroBinding(materialCardView, materialCardView, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ListItemQuickRunMacroBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemQuickRunMacroBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_quick_run_macro, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public MaterialCardView getRoot() {
        return this.f11305a;
    }
}
