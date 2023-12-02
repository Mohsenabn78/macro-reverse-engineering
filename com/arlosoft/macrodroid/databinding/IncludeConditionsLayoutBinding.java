package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class IncludeConditionsLayoutBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CardView f11255a;
    @NonNull
    public final Spinner conditionsAndOrSelection;
    @NonNull
    public final LinearLayout conditionsLayout;
    @NonNull
    public final ImageButton conditonsAddConditionButton;

    private IncludeConditionsLayoutBinding(@NonNull CardView cardView, @NonNull Spinner spinner, @NonNull LinearLayout linearLayout, @NonNull ImageButton imageButton) {
        this.f11255a = cardView;
        this.conditionsAndOrSelection = spinner;
        this.conditionsLayout = linearLayout;
        this.conditonsAddConditionButton = imageButton;
    }

    @NonNull
    public static IncludeConditionsLayoutBinding bind(@NonNull View view) {
        int i4 = R.id.conditions_and_or_selection;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.conditions_and_or_selection);
        if (spinner != null) {
            i4 = R.id.conditions_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.conditions_layout);
            if (linearLayout != null) {
                i4 = R.id.conditons_add_condition_button;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.conditons_add_condition_button);
                if (imageButton != null) {
                    return new IncludeConditionsLayoutBinding((CardView) view, spinner, linearLayout, imageButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static IncludeConditionsLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static IncludeConditionsLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.include_conditions_layout, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CardView getRoot() {
        return this.f11255a;
    }
}
