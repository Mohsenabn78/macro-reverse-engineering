package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogWriteToFileBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11170a;
    @NonNull
    public final RadioButton appendRadioButton;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final TextView directoryText;
    @NonNull
    public final AppCompatEditText filename;
    @NonNull
    public final Button okButton;
    @NonNull
    public final RadioButton overwriteRadioButton;
    @NonNull
    public final ImageButton pickDirButton;
    @NonNull
    public final RadioButton prependRadioButton;
    @NonNull
    public final Button specialTextButtonFilename;
    @NonNull
    public final Button specialTextButtonTextContent;
    @NonNull
    public final AppCompatEditText textToWrite;

    private DialogWriteToFileBinding(@NonNull ScrollView scrollView, @NonNull RadioButton radioButton, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull TextView textView, @NonNull AppCompatEditText appCompatEditText, @NonNull Button button2, @NonNull RadioButton radioButton2, @NonNull ImageButton imageButton, @NonNull RadioButton radioButton3, @NonNull Button button3, @NonNull Button button4, @NonNull AppCompatEditText appCompatEditText2) {
        this.f11170a = scrollView;
        this.appendRadioButton = radioButton;
        this.buttonBar = linearLayout;
        this.cancelButton = button;
        this.directoryText = textView;
        this.filename = appCompatEditText;
        this.okButton = button2;
        this.overwriteRadioButton = radioButton2;
        this.pickDirButton = imageButton;
        this.prependRadioButton = radioButton3;
        this.specialTextButtonFilename = button3;
        this.specialTextButtonTextContent = button4;
        this.textToWrite = appCompatEditText2;
    }

    @NonNull
    public static DialogWriteToFileBinding bind(@NonNull View view) {
        int i4 = R.id.append_radio_button;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.append_radio_button);
        if (radioButton != null) {
            i4 = R.id.button_bar;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
            if (linearLayout != null) {
                i4 = R.id.cancelButton;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                if (button != null) {
                    i4 = R.id.directory_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.directory_text);
                    if (textView != null) {
                        i4 = R.id.filename;
                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.filename);
                        if (appCompatEditText != null) {
                            i4 = R.id.okButton;
                            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                            if (button2 != null) {
                                i4 = R.id.overwrite_radio_button;
                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.overwrite_radio_button);
                                if (radioButton2 != null) {
                                    i4 = R.id.pick_dir_button;
                                    ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.pick_dir_button);
                                    if (imageButton != null) {
                                        i4 = R.id.prepend_radio_button;
                                        RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.prepend_radio_button);
                                        if (radioButton3 != null) {
                                            i4 = R.id.special_text_button_filename;
                                            Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.special_text_button_filename);
                                            if (button3 != null) {
                                                i4 = R.id.special_text_button_text_content;
                                                Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.special_text_button_text_content);
                                                if (button4 != null) {
                                                    i4 = R.id.text_to_write;
                                                    AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.text_to_write);
                                                    if (appCompatEditText2 != null) {
                                                        return new DialogWriteToFileBinding((ScrollView) view, radioButton, linearLayout, button, textView, appCompatEditText, button2, radioButton2, imageButton, radioButton3, button3, button4, appCompatEditText2);
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
    public static DialogWriteToFileBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogWriteToFileBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_write_to_file, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11170a;
    }
}
