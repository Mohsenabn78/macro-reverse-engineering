package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class DialogEditDictionaryEntryKeyOnlyBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11054a;
    @NonNull
    public final ImageView deleteButton;
    @NonNull
    public final TextView dialogTitle;
    @NonNull
    public final AppCompatEditText keyName;
    @NonNull
    public final TextInputLayout keyNameLayout;

    private DialogEditDictionaryEntryKeyOnlyBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull AppCompatEditText appCompatEditText, @NonNull TextInputLayout textInputLayout) {
        this.f11054a = linearLayout;
        this.deleteButton = imageView;
        this.dialogTitle = textView;
        this.keyName = appCompatEditText;
        this.keyNameLayout = textInputLayout;
    }

    @NonNull
    public static DialogEditDictionaryEntryKeyOnlyBinding bind(@NonNull View view) {
        int i4 = R.id.deleteButton;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.deleteButton);
        if (imageView != null) {
            i4 = R.id.dialogTitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.dialogTitle);
            if (textView != null) {
                i4 = R.id.keyName;
                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.keyName);
                if (appCompatEditText != null) {
                    i4 = R.id.keyNameLayout;
                    TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.keyNameLayout);
                    if (textInputLayout != null) {
                        return new DialogEditDictionaryEntryKeyOnlyBinding((LinearLayout) view, imageView, textView, appCompatEditText, textInputLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogEditDictionaryEntryKeyOnlyBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogEditDictionaryEntryKeyOnlyBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_edit_dictionary_entry_key_only, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11054a;
    }
}
