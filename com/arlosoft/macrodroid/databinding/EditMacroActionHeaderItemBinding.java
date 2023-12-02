package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class EditMacroActionHeaderItemBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f11188a;
    @NonNull
    public final LinearLayout actionLayout;
    @NonNull
    public final ImageButton editMacroAddActionButton;
    @NonNull
    public final ImageButton pasteActionButton;
    @NonNull
    public final ImageButton reorderActionsButton;

    private EditMacroActionHeaderItemBinding(@NonNull MaterialCardView materialCardView, @NonNull LinearLayout linearLayout, @NonNull ImageButton imageButton, @NonNull ImageButton imageButton2, @NonNull ImageButton imageButton3) {
        this.f11188a = materialCardView;
        this.actionLayout = linearLayout;
        this.editMacroAddActionButton = imageButton;
        this.pasteActionButton = imageButton2;
        this.reorderActionsButton = imageButton3;
    }

    @NonNull
    public static EditMacroActionHeaderItemBinding bind(@NonNull View view) {
        int i4 = R.id.actionLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.actionLayout);
        if (linearLayout != null) {
            i4 = R.id.edit_macro_addActionButton;
            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.edit_macro_addActionButton);
            if (imageButton != null) {
                i4 = R.id.pasteActionButton;
                ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, R.id.pasteActionButton);
                if (imageButton2 != null) {
                    i4 = R.id.reorderActionsButton;
                    ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, R.id.reorderActionsButton);
                    if (imageButton3 != null) {
                        return new EditMacroActionHeaderItemBinding((MaterialCardView) view, linearLayout, imageButton, imageButton2, imageButton3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static EditMacroActionHeaderItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static EditMacroActionHeaderItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.edit_macro_action_header_item, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public MaterialCardView getRoot() {
        return this.f11188a;
    }
}
