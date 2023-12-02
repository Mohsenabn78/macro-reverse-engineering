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
public final class EditMacroTriggerHeaderItemBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f11194a;
    @NonNull
    public final ImageButton editMacroAddTriggerButton;
    @NonNull
    public final ImageButton pasteTriggerButton;
    @NonNull
    public final ImageButton reorderTriggersButton;
    @NonNull
    public final LinearLayout triggerLinearLayout;

    private EditMacroTriggerHeaderItemBinding(@NonNull MaterialCardView materialCardView, @NonNull ImageButton imageButton, @NonNull ImageButton imageButton2, @NonNull ImageButton imageButton3, @NonNull LinearLayout linearLayout) {
        this.f11194a = materialCardView;
        this.editMacroAddTriggerButton = imageButton;
        this.pasteTriggerButton = imageButton2;
        this.reorderTriggersButton = imageButton3;
        this.triggerLinearLayout = linearLayout;
    }

    @NonNull
    public static EditMacroTriggerHeaderItemBinding bind(@NonNull View view) {
        int i4 = R.id.edit_macro_addTriggerButton;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.edit_macro_addTriggerButton);
        if (imageButton != null) {
            i4 = R.id.pasteTriggerButton;
            ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, R.id.pasteTriggerButton);
            if (imageButton2 != null) {
                i4 = R.id.reorderTriggersButton;
                ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, R.id.reorderTriggersButton);
                if (imageButton3 != null) {
                    i4 = R.id.triggerLinearLayout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.triggerLinearLayout);
                    if (linearLayout != null) {
                        return new EditMacroTriggerHeaderItemBinding((MaterialCardView) view, imageButton, imageButton2, imageButton3, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static EditMacroTriggerHeaderItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static EditMacroTriggerHeaderItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.edit_macro_trigger_header_item, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public MaterialCardView getRoot() {
        return this.f11194a;
    }
}
