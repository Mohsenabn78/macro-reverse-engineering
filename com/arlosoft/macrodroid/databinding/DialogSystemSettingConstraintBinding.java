package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.NDSpinner;

/* loaded from: classes3.dex */
public final class DialogSystemSettingConstraintBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11139a;
    @NonNull
    public final AppCompatEditText key;
    @NonNull
    public final Button keyMagicTextButton;
    @NonNull
    public final RadioButton radioButtonEquals;
    @NonNull
    public final RadioButton radioButtonGreaterOrExcludes;
    @NonNull
    public final RadioButton radioButtonLessOrContains;
    @NonNull
    public final RadioButton radioButtonNotEquals;
    @NonNull
    public final NDSpinner spinner;
    @NonNull
    public final Spinner typeSpinner;
    @NonNull
    public final AppCompatEditText value;
    @NonNull
    public final Button valueMagicTextButton;

    private DialogSystemSettingConstraintBinding(@NonNull ScrollView scrollView, @NonNull AppCompatEditText appCompatEditText, @NonNull Button button, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull RadioButton radioButton3, @NonNull RadioButton radioButton4, @NonNull NDSpinner nDSpinner, @NonNull Spinner spinner, @NonNull AppCompatEditText appCompatEditText2, @NonNull Button button2) {
        this.f11139a = scrollView;
        this.key = appCompatEditText;
        this.keyMagicTextButton = button;
        this.radioButtonEquals = radioButton;
        this.radioButtonGreaterOrExcludes = radioButton2;
        this.radioButtonLessOrContains = radioButton3;
        this.radioButtonNotEquals = radioButton4;
        this.spinner = nDSpinner;
        this.typeSpinner = spinner;
        this.value = appCompatEditText2;
        this.valueMagicTextButton = button2;
    }

    @NonNull
    public static DialogSystemSettingConstraintBinding bind(@NonNull View view) {
        int i4 = R.id.key;
        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.key);
        if (appCompatEditText != null) {
            i4 = R.id.keyMagicTextButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.keyMagicTextButton);
            if (button != null) {
                i4 = R.id.radioButtonEquals;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.radioButtonEquals);
                if (radioButton != null) {
                    i4 = R.id.radioButtonGreaterOrExcludes;
                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radioButtonGreaterOrExcludes);
                    if (radioButton2 != null) {
                        i4 = R.id.radioButtonLessOrContains;
                        RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radioButtonLessOrContains);
                        if (radioButton3 != null) {
                            i4 = R.id.radioButtonNotEquals;
                            RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radioButtonNotEquals);
                            if (radioButton4 != null) {
                                i4 = R.id.spinner;
                                NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.spinner);
                                if (nDSpinner != null) {
                                    i4 = R.id.typeSpinner;
                                    Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.typeSpinner);
                                    if (spinner != null) {
                                        i4 = R.id.value;
                                        AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.value);
                                        if (appCompatEditText2 != null) {
                                            i4 = R.id.valueMagicTextButton;
                                            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.valueMagicTextButton);
                                            if (button2 != null) {
                                                return new DialogSystemSettingConstraintBinding((ScrollView) view, appCompatEditText, button, radioButton, radioButton2, radioButton3, radioButton4, nDSpinner, spinner, appCompatEditText2, button2);
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
    public static DialogSystemSettingConstraintBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogSystemSettingConstraintBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_system_setting_constraint, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11139a;
    }
}
