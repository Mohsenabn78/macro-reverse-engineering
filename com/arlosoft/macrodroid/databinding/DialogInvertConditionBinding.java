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
public final class DialogInvertConditionBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11079a;
    @NonNull
    public final CheckBox invertConditionCheckbox;

    private DialogInvertConditionBinding(@NonNull LinearLayout linearLayout, @NonNull CheckBox checkBox) {
        this.f11079a = linearLayout;
        this.invertConditionCheckbox = checkBox;
    }

    @NonNull
    public static DialogInvertConditionBinding bind(@NonNull View view) {
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.invert_condition_checkbox);
        if (checkBox != null) {
            return new DialogInvertConditionBinding((LinearLayout) view, checkBox);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.invert_condition_checkbox)));
    }

    @NonNull
    public static DialogInvertConditionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogInvertConditionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_invert_condition, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11079a;
    }
}
