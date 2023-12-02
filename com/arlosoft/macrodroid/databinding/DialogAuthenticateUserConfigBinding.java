package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.NDSpinner;

/* loaded from: classes3.dex */
public final class DialogAuthenticateUserConfigBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11027a;
    @NonNull
    public final Button addVariableButton;
    @NonNull
    public final CheckBox allowPinOrSwipePatternCheckBox;
    @NonNull
    public final NDSpinner booleanVariableSpinner;
    @NonNull
    public final Button subtitleMagicTextButton;
    @NonNull
    public final AppCompatEditText subtitleText;
    @NonNull
    public final Button titleMagicTextButton;
    @NonNull
    public final AppCompatEditText titleText;

    private DialogAuthenticateUserConfigBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull CheckBox checkBox, @NonNull NDSpinner nDSpinner, @NonNull Button button2, @NonNull AppCompatEditText appCompatEditText, @NonNull Button button3, @NonNull AppCompatEditText appCompatEditText2) {
        this.f11027a = linearLayout;
        this.addVariableButton = button;
        this.allowPinOrSwipePatternCheckBox = checkBox;
        this.booleanVariableSpinner = nDSpinner;
        this.subtitleMagicTextButton = button2;
        this.subtitleText = appCompatEditText;
        this.titleMagicTextButton = button3;
        this.titleText = appCompatEditText2;
    }

    @NonNull
    public static DialogAuthenticateUserConfigBinding bind(@NonNull View view) {
        int i4 = R.id.addVariableButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.addVariableButton);
        if (button != null) {
            i4 = R.id.allowPinOrSwipePatternCheckBox;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.allowPinOrSwipePatternCheckBox);
            if (checkBox != null) {
                i4 = R.id.booleanVariableSpinner;
                NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.booleanVariableSpinner);
                if (nDSpinner != null) {
                    i4 = R.id.subtitleMagicTextButton;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.subtitleMagicTextButton);
                    if (button2 != null) {
                        i4 = R.id.subtitleText;
                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.subtitleText);
                        if (appCompatEditText != null) {
                            i4 = R.id.titleMagicTextButton;
                            Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.titleMagicTextButton);
                            if (button3 != null) {
                                i4 = R.id.titleText;
                                AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.titleText);
                                if (appCompatEditText2 != null) {
                                    return new DialogAuthenticateUserConfigBinding((LinearLayout) view, button, checkBox, nDSpinner, button2, appCompatEditText, button3, appCompatEditText2);
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
    public static DialogAuthenticateUserConfigBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogAuthenticateUserConfigBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_authenticate_user_config, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11027a;
    }
}
