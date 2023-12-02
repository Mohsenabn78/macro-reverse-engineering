package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
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
public final class ExportShareDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11211a;
    @NonNull
    public final CheckBox encryptOutputCheckbox;
    @NonNull
    public final AppCompatEditText exportdialogFilename;
    @NonNull
    public final TextView fileExtension;
    @NonNull
    public final TextInputLayout inputLayoutPassword;
    @NonNull
    public final AppCompatEditText passwordEntry;
    @NonNull
    public final TextInputLayout passwordLayout;

    private ExportShareDialogBinding(@NonNull LinearLayout linearLayout, @NonNull CheckBox checkBox, @NonNull AppCompatEditText appCompatEditText, @NonNull TextView textView, @NonNull TextInputLayout textInputLayout, @NonNull AppCompatEditText appCompatEditText2, @NonNull TextInputLayout textInputLayout2) {
        this.f11211a = linearLayout;
        this.encryptOutputCheckbox = checkBox;
        this.exportdialogFilename = appCompatEditText;
        this.fileExtension = textView;
        this.inputLayoutPassword = textInputLayout;
        this.passwordEntry = appCompatEditText2;
        this.passwordLayout = textInputLayout2;
    }

    @NonNull
    public static ExportShareDialogBinding bind(@NonNull View view) {
        int i4 = R.id.encrypt_output_checkbox;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.encrypt_output_checkbox);
        if (checkBox != null) {
            i4 = R.id.exportdialog_filename;
            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.exportdialog_filename);
            if (appCompatEditText != null) {
                i4 = R.id.fileExtension;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.fileExtension);
                if (textView != null) {
                    i4 = R.id.input_layout_password;
                    TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.input_layout_password);
                    if (textInputLayout != null) {
                        i4 = R.id.passwordEntry;
                        AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.passwordEntry);
                        if (appCompatEditText2 != null) {
                            i4 = R.id.password_layout;
                            TextInputLayout textInputLayout2 = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.password_layout);
                            if (textInputLayout2 != null) {
                                return new ExportShareDialogBinding((LinearLayout) view, checkBox, appCompatEditText, textView, textInputLayout, appCompatEditText2, textInputLayout2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ExportShareDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ExportShareDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.export_share_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11211a;
    }
}
