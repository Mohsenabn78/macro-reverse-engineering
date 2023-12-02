package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogSetPathBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11125a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final LinearLayout customFilenameLayout;
    @NonNull
    public final RadioButton customFilenameRadioButton;
    @NonNull
    public final AppCompatEditText customFilenameText;
    @NonNull
    public final RadioButton defaultFilenameRadioButton;
    @NonNull
    public final TextView directoryText;
    @NonNull
    public final TextView fileExtension;
    @NonNull
    public final Button filenameMagicTextButton;
    @NonNull
    public final RadioGroup filenameRadioButtons;
    @NonNull
    public final Button okButton;
    @NonNull
    public final ImageButton pickDirButton;

    private DialogSetPathBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull LinearLayout linearLayout3, @NonNull RadioButton radioButton, @NonNull AppCompatEditText appCompatEditText, @NonNull RadioButton radioButton2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull Button button2, @NonNull RadioGroup radioGroup, @NonNull Button button3, @NonNull ImageButton imageButton) {
        this.f11125a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.customFilenameLayout = linearLayout3;
        this.customFilenameRadioButton = radioButton;
        this.customFilenameText = appCompatEditText;
        this.defaultFilenameRadioButton = radioButton2;
        this.directoryText = textView;
        this.fileExtension = textView2;
        this.filenameMagicTextButton = button2;
        this.filenameRadioButtons = radioGroup;
        this.okButton = button3;
        this.pickDirButton = imageButton;
    }

    @NonNull
    public static DialogSetPathBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.customFilenameLayout;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.customFilenameLayout);
                if (linearLayout2 != null) {
                    i4 = R.id.custom_filename_radio_button;
                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.custom_filename_radio_button);
                    if (radioButton != null) {
                        i4 = R.id.custom_filename_text;
                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.custom_filename_text);
                        if (appCompatEditText != null) {
                            i4 = R.id.default_filename_radio_button;
                            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.default_filename_radio_button);
                            if (radioButton2 != null) {
                                i4 = R.id.directory_text;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.directory_text);
                                if (textView != null) {
                                    i4 = R.id.fileExtension;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.fileExtension);
                                    if (textView2 != null) {
                                        i4 = R.id.filename_magic_text_button;
                                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.filename_magic_text_button);
                                        if (button2 != null) {
                                            i4 = R.id.filename_radio_buttons;
                                            RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, R.id.filename_radio_buttons);
                                            if (radioGroup != null) {
                                                i4 = R.id.okButton;
                                                Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                                if (button3 != null) {
                                                    i4 = R.id.pick_dir_button;
                                                    ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.pick_dir_button);
                                                    if (imageButton != null) {
                                                        return new DialogSetPathBinding((LinearLayout) view, linearLayout, button, linearLayout2, radioButton, appCompatEditText, radioButton2, textView, textView2, button2, radioGroup, button3, imageButton);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogSetPathBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogSetPathBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_set_path, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11125a;
    }
}
