package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.NDSpinner;

/* loaded from: classes3.dex */
public final class DialogLoopForConfigureBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11091a;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final AppCompatEditText dialogLoopForUseNumberEdittext;
    @NonNull
    public final NDSpinner dialogLoopForVariable;
    @NonNull
    public final Button okButton;

    private DialogLoopForConfigureBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText, @NonNull NDSpinner nDSpinner, @NonNull Button button2) {
        this.f11091a = linearLayout;
        this.cancelButton = button;
        this.dialogLoopForUseNumberEdittext = appCompatEditText;
        this.dialogLoopForVariable = nDSpinner;
        this.okButton = button2;
    }

    @NonNull
    public static DialogLoopForConfigureBinding bind(@NonNull View view) {
        int i4 = R.id.cancelButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
        if (button != null) {
            i4 = R.id.dialog_loop_for_use_number_edittext;
            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.dialog_loop_for_use_number_edittext);
            if (appCompatEditText != null) {
                i4 = R.id.dialog_loop_for_variable;
                NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.dialog_loop_for_variable);
                if (nDSpinner != null) {
                    i4 = R.id.okButton;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                    if (button2 != null) {
                        return new DialogLoopForConfigureBinding((LinearLayout) view, button, appCompatEditText, nDSpinner, button2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogLoopForConfigureBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogLoopForConfigureBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_loop_for_configure, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11091a;
    }
}
