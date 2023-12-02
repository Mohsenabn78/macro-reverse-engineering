package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
public final class ExportDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11210a;
    @NonNull
    public final CheckBox encryptOutputCheckbox;
    @NonNull
    public final TextView exportDialogExportPath;
    @NonNull
    public final Button exportDialogFilenameMagicTextChooser;
    @NonNull
    public final Button exportDialogFolderChooser;
    @NonNull
    public final AppCompatEditText exportdialogFilename;
    @NonNull
    public final TextView fileExtension;
    @NonNull
    public final TextInputLayout inputLayoutPassword;
    @NonNull
    public final AppCompatEditText passwordEntry;
    @NonNull
    public final LinearLayout passwordLayout;

    private ExportDialogBinding(@NonNull LinearLayout linearLayout, @NonNull CheckBox checkBox, @NonNull TextView textView, @NonNull Button button, @NonNull Button button2, @NonNull AppCompatEditText appCompatEditText, @NonNull TextView textView2, @NonNull TextInputLayout textInputLayout, @NonNull AppCompatEditText appCompatEditText2, @NonNull LinearLayout linearLayout2) {
        this.f11210a = linearLayout;
        this.encryptOutputCheckbox = checkBox;
        this.exportDialogExportPath = textView;
        this.exportDialogFilenameMagicTextChooser = button;
        this.exportDialogFolderChooser = button2;
        this.exportdialogFilename = appCompatEditText;
        this.fileExtension = textView2;
        this.inputLayoutPassword = textInputLayout;
        this.passwordEntry = appCompatEditText2;
        this.passwordLayout = linearLayout2;
    }

    @NonNull
    public static ExportDialogBinding bind(@NonNull View view) {
        int i4 = R.id.encrypt_output_checkbox;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.encrypt_output_checkbox);
        if (checkBox != null) {
            i4 = R.id.export_dialog_export_path;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.export_dialog_export_path);
            if (textView != null) {
                i4 = R.id.export_dialog_filename_magic_text_chooser;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.export_dialog_filename_magic_text_chooser);
                if (button != null) {
                    i4 = R.id.export_dialog_folder_chooser;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.export_dialog_folder_chooser);
                    if (button2 != null) {
                        i4 = R.id.exportdialog_filename;
                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.exportdialog_filename);
                        if (appCompatEditText != null) {
                            i4 = R.id.fileExtension;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.fileExtension);
                            if (textView2 != null) {
                                i4 = R.id.input_layout_password;
                                TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.input_layout_password);
                                if (textInputLayout != null) {
                                    i4 = R.id.passwordEntry;
                                    AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.passwordEntry);
                                    if (appCompatEditText2 != null) {
                                        i4 = R.id.password_layout;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.password_layout);
                                        if (linearLayout != null) {
                                            return new ExportDialogBinding((LinearLayout) view, checkBox, textView, button, button2, appCompatEditText, textView2, textInputLayout, appCompatEditText2, linearLayout);
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
    public static ExportDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ExportDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.export_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11210a;
    }
}
