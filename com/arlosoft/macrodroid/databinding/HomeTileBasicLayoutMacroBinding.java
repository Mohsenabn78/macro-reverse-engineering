package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.SquareMaterialCardView;

/* loaded from: classes3.dex */
public final class HomeTileBasicLayoutMacroBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final SquareMaterialCardView f11247a;
    @NonNull
    public final ConstraintLayout clickContainer;
    @NonNull
    public final ImageView icon;
    @NonNull
    public final Guideline iconBottomGuideline;
    @NonNull
    public final Guideline iconTopGuidline;
    @NonNull
    public final Guideline textTopGuidline;
    @NonNull
    public final SquareMaterialCardView tileContainer;
    @NonNull
    public final TextView title;

    private HomeTileBasicLayoutMacroBinding(@NonNull SquareMaterialCardView squareMaterialCardView, @NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull Guideline guideline, @NonNull Guideline guideline2, @NonNull Guideline guideline3, @NonNull SquareMaterialCardView squareMaterialCardView2, @NonNull TextView textView) {
        this.f11247a = squareMaterialCardView;
        this.clickContainer = constraintLayout;
        this.icon = imageView;
        this.iconBottomGuideline = guideline;
        this.iconTopGuidline = guideline2;
        this.textTopGuidline = guideline3;
        this.tileContainer = squareMaterialCardView2;
        this.title = textView;
    }

    @NonNull
    public static HomeTileBasicLayoutMacroBinding bind(@NonNull View view) {
        int i4 = R.id.clickContainer;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.clickContainer);
        if (constraintLayout != null) {
            i4 = R.id.icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.icon);
            if (imageView != null) {
                i4 = R.id.iconBottomGuideline;
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.iconBottomGuideline);
                if (guideline != null) {
                    i4 = R.id.iconTopGuidline;
                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, R.id.iconTopGuidline);
                    if (guideline2 != null) {
                        i4 = R.id.textTopGuidline;
                        Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, R.id.textTopGuidline);
                        if (guideline3 != null) {
                            SquareMaterialCardView squareMaterialCardView = (SquareMaterialCardView) view;
                            i4 = R.id.title;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                            if (textView != null) {
                                return new HomeTileBasicLayoutMacroBinding(squareMaterialCardView, constraintLayout, imageView, guideline, guideline2, guideline3, squareMaterialCardView, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static HomeTileBasicLayoutMacroBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static HomeTileBasicLayoutMacroBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.home_tile_basic_layout_macro, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public SquareMaterialCardView getRoot() {
        return this.f11247a;
    }
}
