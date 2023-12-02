package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogOpenFileBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11105a;
    @NonNull
    public final TextView applicationName;
    @NonNull
    public final TextView directoryText;
    @NonNull
    public final RadioButton dynamicFilenameRadioButton;
    @NonNull
    public final AppCompatEditText filename;
    @NonNull
    public final ImageButton pickDirButton;
    @NonNull
    public final Button selectAppButton;
    @NonNull
    public final ImageButton selectFileButton;
    @NonNull
    public final Button specialTextButtonFilename;
    @NonNull
    public final AppCompatEditText staticFilename;
    @NonNull
    public final RadioButton staticFilenameRadioButton;
    @NonNull
    public final ViewFlipper viewFlipper;

    private DialogOpenFileBinding(@NonNull ScrollView scrollView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull RadioButton radioButton, @NonNull AppCompatEditText appCompatEditText, @NonNull ImageButton imageButton, @NonNull Button button, @NonNull ImageButton imageButton2, @NonNull Button button2, @NonNull AppCompatEditText appCompatEditText2, @NonNull RadioButton radioButton2, @NonNull ViewFlipper viewFlipper) {
        this.f11105a = scrollView;
        this.applicationName = textView;
        this.directoryText = textView2;
        this.dynamicFilenameRadioButton = radioButton;
        this.filename = appCompatEditText;
        this.pickDirButton = imageButton;
        this.selectAppButton = button;
        this.selectFileButton = imageButton2;
        this.specialTextButtonFilename = button2;
        this.staticFilename = appCompatEditText2;
        this.staticFilenameRadioButton = radioButton2;
        this.viewFlipper = viewFlipper;
    }

    @NonNull
    public static DialogOpenFileBinding bind(@NonNull View view) {
        int i4 = R.id.application_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.application_name);
        if (textView != null) {
            i4 = R.id.directory_text;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.directory_text);
            if (textView2 != null) {
                i4 = R.id.dynamicFilenameRadioButton;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.dynamicFilenameRadioButton);
                if (radioButton != null) {
                    i4 = R.id.filename;
                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.filename);
                    if (appCompatEditText != null) {
                        i4 = R.id.pick_dir_button;
                        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.pick_dir_button);
                        if (imageButton != null) {
                            i4 = R.id.select_app_button;
                            Button button = (Button) ViewBindings.findChildViewById(view, R.id.select_app_button);
                            if (button != null) {
                                i4 = R.id.selectFileButton;
                                ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, R.id.selectFileButton);
                                if (imageButton2 != null) {
                                    i4 = R.id.special_text_button_filename;
                                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.special_text_button_filename);
                                    if (button2 != null) {
                                        i4 = R.id.staticFilename;
                                        AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.staticFilename);
                                        if (appCompatEditText2 != null) {
                                            i4 = R.id.staticFilenameRadioButton;
                                            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.staticFilenameRadioButton);
                                            if (radioButton2 != null) {
                                                i4 = R.id.viewFlipper;
                                                ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.viewFlipper);
                                                if (viewFlipper != null) {
                                                    return new DialogOpenFileBinding((ScrollView) view, textView, textView2, radioButton, appCompatEditText, imageButton, button, imageButton2, button2, appCompatEditText2, radioButton2, viewFlipper);
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
    public static DialogOpenFileBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogOpenFileBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_open_file, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11105a;
    }
}
