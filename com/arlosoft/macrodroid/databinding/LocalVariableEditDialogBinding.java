package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class LocalVariableEditDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11321a;
    @NonNull
    public final LinearLayout booleanValueContainer;
    @NonNull
    public final ImageView clearButton;
    @NonNull
    public final ImageView deleteButton;
    @NonNull
    public final EditText enterVariableDialogValue;
    @NonNull
    public final RadioButton falseRadio;
    @NonNull
    public final TextInputLayout textValueContainer;
    @NonNull
    public final RadioButton trueRadio;
    @NonNull
    public final AppCompatEditText variableName;

    private LocalVariableEditDialogBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull EditText editText, @NonNull RadioButton radioButton, @NonNull TextInputLayout textInputLayout, @NonNull RadioButton radioButton2, @NonNull AppCompatEditText appCompatEditText) {
        this.f11321a = linearLayout;
        this.booleanValueContainer = linearLayout2;
        this.clearButton = imageView;
        this.deleteButton = imageView2;
        this.enterVariableDialogValue = editText;
        this.falseRadio = radioButton;
        this.textValueContainer = textInputLayout;
        this.trueRadio = radioButton2;
        this.variableName = appCompatEditText;
    }

    @NonNull
    public static LocalVariableEditDialogBinding bind(@NonNull View view) {
        int i4 = R.id.booleanValueContainer;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.booleanValueContainer);
        if (linearLayout != null) {
            i4 = R.id.clearButton;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.clearButton);
            if (imageView != null) {
                i4 = R.id.deleteButton;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.deleteButton);
                if (imageView2 != null) {
                    i4 = R.id.enter_variable_dialog_value;
                    EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.enter_variable_dialog_value);
                    if (editText != null) {
                        i4 = R.id.falseRadio;
                        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.falseRadio);
                        if (radioButton != null) {
                            i4 = R.id.textValueContainer;
                            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.textValueContainer);
                            if (textInputLayout != null) {
                                i4 = R.id.trueRadio;
                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.trueRadio);
                                if (radioButton2 != null) {
                                    i4 = R.id.variable_name;
                                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.variable_name);
                                    if (appCompatEditText != null) {
                                        return new LocalVariableEditDialogBinding((LinearLayout) view, linearLayout, imageView, imageView2, editText, radioButton, textInputLayout, radioButton2, appCompatEditText);
                                    }
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
    public static LocalVariableEditDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static LocalVariableEditDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.local_variable_edit_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11321a;
    }
}
