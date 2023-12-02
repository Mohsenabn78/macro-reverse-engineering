package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class DialogEditDictionaryEntryBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11053a;
    @NonNull
    public final LinearLayout booleanValueContainer;
    @NonNull
    public final ImageView deleteButton;
    @NonNull
    public final TextView dialogTitle;
    @NonNull
    public final RadioButton falseRadio;
    @NonNull
    public final AppCompatEditText keyName;
    @NonNull
    public final TextInputLayout keyNameLayout;
    @NonNull
    public final AppCompatEditText textValue;
    @NonNull
    public final TextInputLayout textValueContainer;
    @NonNull
    public final RadioButton trueRadio;
    @NonNull
    public final Spinner valueTypeSpinner;

    private DialogEditDictionaryEntryBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull RadioButton radioButton, @NonNull AppCompatEditText appCompatEditText, @NonNull TextInputLayout textInputLayout, @NonNull AppCompatEditText appCompatEditText2, @NonNull TextInputLayout textInputLayout2, @NonNull RadioButton radioButton2, @NonNull Spinner spinner) {
        this.f11053a = linearLayout;
        this.booleanValueContainer = linearLayout2;
        this.deleteButton = imageView;
        this.dialogTitle = textView;
        this.falseRadio = radioButton;
        this.keyName = appCompatEditText;
        this.keyNameLayout = textInputLayout;
        this.textValue = appCompatEditText2;
        this.textValueContainer = textInputLayout2;
        this.trueRadio = radioButton2;
        this.valueTypeSpinner = spinner;
    }

    @NonNull
    public static DialogEditDictionaryEntryBinding bind(@NonNull View view) {
        int i4 = R.id.booleanValueContainer;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.booleanValueContainer);
        if (linearLayout != null) {
            i4 = R.id.deleteButton;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.deleteButton);
            if (imageView != null) {
                i4 = R.id.dialogTitle;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.dialogTitle);
                if (textView != null) {
                    i4 = R.id.falseRadio;
                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.falseRadio);
                    if (radioButton != null) {
                        i4 = R.id.keyName;
                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.keyName);
                        if (appCompatEditText != null) {
                            i4 = R.id.keyNameLayout;
                            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.keyNameLayout);
                            if (textInputLayout != null) {
                                i4 = R.id.textValue;
                                AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.textValue);
                                if (appCompatEditText2 != null) {
                                    i4 = R.id.textValueContainer;
                                    TextInputLayout textInputLayout2 = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.textValueContainer);
                                    if (textInputLayout2 != null) {
                                        i4 = R.id.trueRadio;
                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.trueRadio);
                                        if (radioButton2 != null) {
                                            i4 = R.id.valueTypeSpinner;
                                            Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.valueTypeSpinner);
                                            if (spinner != null) {
                                                return new DialogEditDictionaryEntryBinding((LinearLayout) view, linearLayout, imageView, textView, radioButton, appCompatEditText, textInputLayout, appCompatEditText2, textInputLayout2, radioButton2, spinner);
                                            }
                                        }
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
    public static DialogEditDictionaryEntryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogEditDictionaryEntryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_edit_dictionary_entry, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11053a;
    }
}
