package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogUiInteractionPasteOptionsBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11153a;
    @NonNull
    public final CheckBox clearExistingCheckbox;
    @NonNull
    public final LinearLayout enterTextLayout;
    @NonNull
    public final RadioButton enterTextRadioButton;
    @NonNull
    public final Button magicTextButton;
    @NonNull
    public final AppCompatEditText textToMatch;
    @NonNull
    public final RadioButton useClipboardRadioButton;

    private DialogUiInteractionPasteOptionsBinding(@NonNull LinearLayout linearLayout, @NonNull CheckBox checkBox, @NonNull LinearLayout linearLayout2, @NonNull RadioButton radioButton, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText, @NonNull RadioButton radioButton2) {
        this.f11153a = linearLayout;
        this.clearExistingCheckbox = checkBox;
        this.enterTextLayout = linearLayout2;
        this.enterTextRadioButton = radioButton;
        this.magicTextButton = button;
        this.textToMatch = appCompatEditText;
        this.useClipboardRadioButton = radioButton2;
    }

    @NonNull
    public static DialogUiInteractionPasteOptionsBinding bind(@NonNull View view) {
        int i4 = R.id.clearExistingCheckbox;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.clearExistingCheckbox);
        if (checkBox != null) {
            i4 = R.id.enterTextLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.enterTextLayout);
            if (linearLayout != null) {
                i4 = R.id.enterTextRadioButton;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.enterTextRadioButton);
                if (radioButton != null) {
                    i4 = R.id.magicTextButton;
                    Button button = (Button) ViewBindings.findChildViewById(view, R.id.magicTextButton);
                    if (button != null) {
                        i4 = R.id.textToMatch;
                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.textToMatch);
                        if (appCompatEditText != null) {
                            i4 = R.id.useClipboardRadioButton;
                            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.useClipboardRadioButton);
                            if (radioButton2 != null) {
                                return new DialogUiInteractionPasteOptionsBinding((LinearLayout) view, checkBox, linearLayout, radioButton, button, appCompatEditText, radioButton2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogUiInteractionPasteOptionsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogUiInteractionPasteOptionsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_ui_interaction_paste_options, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11153a;
    }
}
