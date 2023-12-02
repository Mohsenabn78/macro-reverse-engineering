package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogSystemSettingBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11138a;
    @NonNull
    public final CheckBox helperFileCheckBox;
    @NonNull
    public final AppCompatEditText key;
    @NonNull
    public final Button keyMagicTextButton;
    @NonNull
    public final Spinner spinner;
    @NonNull
    public final Spinner typeSpinner;
    @NonNull
    public final AppCompatEditText value;
    @NonNull
    public final Button valueMagicTextButton;

    private DialogSystemSettingBinding(@NonNull LinearLayout linearLayout, @NonNull CheckBox checkBox, @NonNull AppCompatEditText appCompatEditText, @NonNull Button button, @NonNull Spinner spinner, @NonNull Spinner spinner2, @NonNull AppCompatEditText appCompatEditText2, @NonNull Button button2) {
        this.f11138a = linearLayout;
        this.helperFileCheckBox = checkBox;
        this.key = appCompatEditText;
        this.keyMagicTextButton = button;
        this.spinner = spinner;
        this.typeSpinner = spinner2;
        this.value = appCompatEditText2;
        this.valueMagicTextButton = button2;
    }

    @NonNull
    public static DialogSystemSettingBinding bind(@NonNull View view) {
        int i4 = R.id.helperFileCheckBox;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.helperFileCheckBox);
        if (checkBox != null) {
            i4 = R.id.key;
            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.key);
            if (appCompatEditText != null) {
                i4 = R.id.keyMagicTextButton;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.keyMagicTextButton);
                if (button != null) {
                    i4 = R.id.spinner;
                    Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.spinner);
                    if (spinner != null) {
                        i4 = R.id.typeSpinner;
                        Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, R.id.typeSpinner);
                        if (spinner2 != null) {
                            i4 = R.id.value;
                            AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.value);
                            if (appCompatEditText2 != null) {
                                i4 = R.id.valueMagicTextButton;
                                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.valueMagicTextButton);
                                if (button2 != null) {
                                    return new DialogSystemSettingBinding((LinearLayout) view, checkBox, appCompatEditText, button, spinner, spinner2, appCompatEditText2, button2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogSystemSettingBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogSystemSettingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_system_setting, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11138a;
    }
}
