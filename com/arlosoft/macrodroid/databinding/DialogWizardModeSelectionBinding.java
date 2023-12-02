package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogWizardModeSelectionBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11169a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button dialogWizardModeEmptyMacroButton;
    @NonNull
    public final Button dialogWizardModeWizardButton;

    private DialogWizardModeSelectionBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull Button button2) {
        this.f11169a = linearLayout;
        this.buttonBar = linearLayout2;
        this.dialogWizardModeEmptyMacroButton = button;
        this.dialogWizardModeWizardButton = button2;
    }

    @NonNull
    public static DialogWizardModeSelectionBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.dialog_wizard_mode_empty_macro_button;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.dialog_wizard_mode_empty_macro_button);
            if (button != null) {
                i4 = R.id.dialog_wizard_mode_wizard_button;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.dialog_wizard_mode_wizard_button);
                if (button2 != null) {
                    return new DialogWizardModeSelectionBinding((LinearLayout) view, linearLayout, button, button2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogWizardModeSelectionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogWizardModeSelectionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_wizard_mode_selection, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11169a;
    }
}
