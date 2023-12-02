package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogEnterTextBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11060a;
    @NonNull
    public final CheckBox ignoreConstraints;
    @NonNull
    public final TextView invokeMacroLabel;
    @NonNull
    public final Spinner macroSpinner;
    @NonNull
    public final Button specialTextButton;
    @NonNull
    public final AppCompatEditText text;

    private DialogEnterTextBinding(@NonNull LinearLayout linearLayout, @NonNull CheckBox checkBox, @NonNull TextView textView, @NonNull Spinner spinner, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText) {
        this.f11060a = linearLayout;
        this.ignoreConstraints = checkBox;
        this.invokeMacroLabel = textView;
        this.macroSpinner = spinner;
        this.specialTextButton = button;
        this.text = appCompatEditText;
    }

    @NonNull
    public static DialogEnterTextBinding bind(@NonNull View view) {
        int i4 = R.id.ignore_constraints;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.ignore_constraints);
        if (checkBox != null) {
            i4 = R.id.invoke_macro_label;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.invoke_macro_label);
            if (textView != null) {
                i4 = R.id.macro_spinner;
                Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.macro_spinner);
                if (spinner != null) {
                    i4 = R.id.special_text_button;
                    Button button = (Button) ViewBindings.findChildViewById(view, R.id.special_text_button);
                    if (button != null) {
                        i4 = R.id.text;
                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.text);
                        if (appCompatEditText != null) {
                            return new DialogEnterTextBinding((LinearLayout) view, checkBox, textView, spinner, button, appCompatEditText);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogEnterTextBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogEnterTextBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_enter_text, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11060a;
    }
}
