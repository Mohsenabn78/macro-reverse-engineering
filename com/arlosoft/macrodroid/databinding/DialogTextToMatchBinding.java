package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogTextToMatchBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11145a;
    @NonNull
    public final RadioButton containsRadioButton;
    @NonNull
    public final CheckBox includeScreenOverlaysCheckBox;
    @NonNull
    public final Button magicTextButton;
    @NonNull
    public final RadioButton matchesRadioButton;
    @NonNull
    public final AppCompatEditText textToMatch;
    @NonNull
    public final TextView wildcardText;

    private DialogTextToMatchBinding(@NonNull LinearLayout linearLayout, @NonNull RadioButton radioButton, @NonNull CheckBox checkBox, @NonNull Button button, @NonNull RadioButton radioButton2, @NonNull AppCompatEditText appCompatEditText, @NonNull TextView textView) {
        this.f11145a = linearLayout;
        this.containsRadioButton = radioButton;
        this.includeScreenOverlaysCheckBox = checkBox;
        this.magicTextButton = button;
        this.matchesRadioButton = radioButton2;
        this.textToMatch = appCompatEditText;
        this.wildcardText = textView;
    }

    @NonNull
    public static DialogTextToMatchBinding bind(@NonNull View view) {
        int i4 = R.id.containsRadioButton;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.containsRadioButton);
        if (radioButton != null) {
            i4 = R.id.includeScreenOverlaysCheckBox;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.includeScreenOverlaysCheckBox);
            if (checkBox != null) {
                i4 = R.id.magicTextButton;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.magicTextButton);
                if (button != null) {
                    i4 = R.id.matchesRadioButton;
                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.matchesRadioButton);
                    if (radioButton2 != null) {
                        i4 = R.id.textToMatch;
                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.textToMatch);
                        if (appCompatEditText != null) {
                            i4 = R.id.wildcardText;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.wildcardText);
                            if (textView != null) {
                                return new DialogTextToMatchBinding((LinearLayout) view, radioButton, checkBox, button, radioButton2, appCompatEditText, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogTextToMatchBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogTextToMatchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_text_to_match, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11145a;
    }
}
