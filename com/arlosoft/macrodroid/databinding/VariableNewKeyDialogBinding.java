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

/* loaded from: classes3.dex */
public final class VariableNewKeyDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11401a;
    @NonNull
    public final AppCompatEditText keyName;
    @NonNull
    public final Button magicTextButton;

    private VariableNewKeyDialogBinding(@NonNull LinearLayout linearLayout, @NonNull AppCompatEditText appCompatEditText, @NonNull Button button) {
        this.f11401a = linearLayout;
        this.keyName = appCompatEditText;
        this.magicTextButton = button;
    }

    @NonNull
    public static VariableNewKeyDialogBinding bind(@NonNull View view) {
        int i4 = R.id.keyName;
        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.keyName);
        if (appCompatEditText != null) {
            i4 = R.id.magicTextButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.magicTextButton);
            if (button != null) {
                return new VariableNewKeyDialogBinding((LinearLayout) view, appCompatEditText, button);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static VariableNewKeyDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static VariableNewKeyDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.variable_new_key_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11401a;
    }
}
