package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogMacroRunOptionsBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11092a;
    @NonNull
    public final CheckBox alwaysRunCheckBox;
    @NonNull
    public final CheckBox ignoreConstraintsCheckBox;
    @NonNull
    public final CheckBox waitToCompleteCheckBox;

    private DialogMacroRunOptionsBinding(@NonNull LinearLayout linearLayout, @NonNull CheckBox checkBox, @NonNull CheckBox checkBox2, @NonNull CheckBox checkBox3) {
        this.f11092a = linearLayout;
        this.alwaysRunCheckBox = checkBox;
        this.ignoreConstraintsCheckBox = checkBox2;
        this.waitToCompleteCheckBox = checkBox3;
    }

    @NonNull
    public static DialogMacroRunOptionsBinding bind(@NonNull View view) {
        int i4 = R.id.alwaysRunCheckBox;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.alwaysRunCheckBox);
        if (checkBox != null) {
            i4 = R.id.ignoreConstraintsCheckBox;
            CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.ignoreConstraintsCheckBox);
            if (checkBox2 != null) {
                i4 = R.id.waitToCompleteCheckBox;
                CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.waitToCompleteCheckBox);
                if (checkBox3 != null) {
                    return new DialogMacroRunOptionsBinding((LinearLayout) view, checkBox, checkBox2, checkBox3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogMacroRunOptionsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogMacroRunOptionsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_macro_run_options, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11092a;
    }
}
