package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class ListItemWizardHeaderBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11317a;
    @NonNull
    public final FrameLayout constraintAndOrFrame;
    @NonNull
    public final Spinner constraintLogicSpinner;
    @NonNull
    public final TextView emptyText;
    @NonNull
    public final MaterialCardView infoCardView;
    @NonNull
    public final LinearLayout itemsList;

    private ListItemWizardHeaderBinding(@NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull Spinner spinner, @NonNull TextView textView, @NonNull MaterialCardView materialCardView, @NonNull LinearLayout linearLayout2) {
        this.f11317a = linearLayout;
        this.constraintAndOrFrame = frameLayout;
        this.constraintLogicSpinner = spinner;
        this.emptyText = textView;
        this.infoCardView = materialCardView;
        this.itemsList = linearLayout2;
    }

    @NonNull
    public static ListItemWizardHeaderBinding bind(@NonNull View view) {
        int i4 = R.id.constraint_and_or_frame;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.constraint_and_or_frame);
        if (frameLayout != null) {
            i4 = R.id.constraint_logic_spinner;
            Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.constraint_logic_spinner);
            if (spinner != null) {
                i4 = R.id.empty_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.empty_text);
                if (textView != null) {
                    i4 = R.id.infoCardView;
                    MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, R.id.infoCardView);
                    if (materialCardView != null) {
                        i4 = R.id.items_list;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.items_list);
                        if (linearLayout != null) {
                            return new ListItemWizardHeaderBinding((LinearLayout) view, frameLayout, spinner, textView, materialCardView, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ListItemWizardHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemWizardHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_wizard_header, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11317a;
    }
}
