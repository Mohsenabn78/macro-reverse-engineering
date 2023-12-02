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
import com.arlosoft.macrodroid.widget.NDSpinner;

/* loaded from: classes3.dex */
public final class DialogReadFromFileBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11114a;
    @NonNull
    public final Button addStringVariableButton;
    @NonNull
    public final TextView directoryText;
    @NonNull
    public final RadioButton dynamicFilenameRadioButton;
    @NonNull
    public final AppCompatEditText filename;
    @NonNull
    public final ImageButton pickDirButton;
    @NonNull
    public final ImageButton selectFileButton;
    @NonNull
    public final Button specialTextButtonFilename;
    @NonNull
    public final AppCompatEditText staticFilename;
    @NonNull
    public final RadioButton staticFilenameRadioButton;
    @NonNull
    public final NDSpinner stringVariableSpinner;
    @NonNull
    public final ViewFlipper viewFlipper;

    private DialogReadFromFileBinding(@NonNull ScrollView scrollView, @NonNull Button button, @NonNull TextView textView, @NonNull RadioButton radioButton, @NonNull AppCompatEditText appCompatEditText, @NonNull ImageButton imageButton, @NonNull ImageButton imageButton2, @NonNull Button button2, @NonNull AppCompatEditText appCompatEditText2, @NonNull RadioButton radioButton2, @NonNull NDSpinner nDSpinner, @NonNull ViewFlipper viewFlipper) {
        this.f11114a = scrollView;
        this.addStringVariableButton = button;
        this.directoryText = textView;
        this.dynamicFilenameRadioButton = radioButton;
        this.filename = appCompatEditText;
        this.pickDirButton = imageButton;
        this.selectFileButton = imageButton2;
        this.specialTextButtonFilename = button2;
        this.staticFilename = appCompatEditText2;
        this.staticFilenameRadioButton = radioButton2;
        this.stringVariableSpinner = nDSpinner;
        this.viewFlipper = viewFlipper;
    }

    @NonNull
    public static DialogReadFromFileBinding bind(@NonNull View view) {
        int i4 = R.id.addStringVariableButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.addStringVariableButton);
        if (button != null) {
            i4 = R.id.directory_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.directory_text);
            if (textView != null) {
                i4 = R.id.dynamicFilenameRadioButton;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.dynamicFilenameRadioButton);
                if (radioButton != null) {
                    i4 = R.id.filename;
                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.filename);
                    if (appCompatEditText != null) {
                        i4 = R.id.pick_dir_button;
                        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.pick_dir_button);
                        if (imageButton != null) {
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
                                            i4 = R.id.stringVariableSpinner;
                                            NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.stringVariableSpinner);
                                            if (nDSpinner != null) {
                                                i4 = R.id.viewFlipper;
                                                ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.viewFlipper);
                                                if (viewFlipper != null) {
                                                    return new DialogReadFromFileBinding((ScrollView) view, button, textView, radioButton, appCompatEditText, imageButton, imageButton2, button2, appCompatEditText2, radioButton2, nDSpinner, viewFlipper);
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
    public static DialogReadFromFileBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogReadFromFileBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_read_from_file, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11114a;
    }
}
