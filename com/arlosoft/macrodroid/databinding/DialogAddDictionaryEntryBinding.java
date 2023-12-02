package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class DialogAddDictionaryEntryBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11022a;
    @NonNull
    public final AppCompatEditText keyName;
    @NonNull
    public final TextInputLayout keyNameLayout;
    @NonNull
    public final Button keyNameMagicTextButton;
    @NonNull
    public final Spinner valueTypeSpinner;

    private DialogAddDictionaryEntryBinding(@NonNull LinearLayout linearLayout, @NonNull AppCompatEditText appCompatEditText, @NonNull TextInputLayout textInputLayout, @NonNull Button button, @NonNull Spinner spinner) {
        this.f11022a = linearLayout;
        this.keyName = appCompatEditText;
        this.keyNameLayout = textInputLayout;
        this.keyNameMagicTextButton = button;
        this.valueTypeSpinner = spinner;
    }

    @NonNull
    public static DialogAddDictionaryEntryBinding bind(@NonNull View view) {
        int i4 = R.id.keyName;
        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.keyName);
        if (appCompatEditText != null) {
            i4 = R.id.keyNameLayout;
            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.keyNameLayout);
            if (textInputLayout != null) {
                i4 = R.id.keyNameMagicTextButton;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.keyNameMagicTextButton);
                if (button != null) {
                    i4 = R.id.valueTypeSpinner;
                    Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.valueTypeSpinner);
                    if (spinner != null) {
                        return new DialogAddDictionaryEntryBinding((LinearLayout) view, appCompatEditText, textInputLayout, button, spinner);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogAddDictionaryEntryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogAddDictionaryEntryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_add_dictionary_entry, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11022a;
    }
}
