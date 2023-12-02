package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogActionBlockConfigBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11017a;
    @NonNull
    public final Button actionBlockName;
    @NonNull
    public final LinearLayout inputVarsContainer;
    @NonNull
    public final LinearLayout outputVarsContainer;
    @NonNull
    public final CheckBox waitToCompleteCheckBox;

    private DialogActionBlockConfigBinding(@NonNull ScrollView scrollView, @NonNull Button button, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull CheckBox checkBox) {
        this.f11017a = scrollView;
        this.actionBlockName = button;
        this.inputVarsContainer = linearLayout;
        this.outputVarsContainer = linearLayout2;
        this.waitToCompleteCheckBox = checkBox;
    }

    @NonNull
    public static DialogActionBlockConfigBinding bind(@NonNull View view) {
        int i4 = R.id.actionBlockName;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.actionBlockName);
        if (button != null) {
            i4 = R.id.inputVarsContainer;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.inputVarsContainer);
            if (linearLayout != null) {
                i4 = R.id.outputVarsContainer;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.outputVarsContainer);
                if (linearLayout2 != null) {
                    i4 = R.id.waitToCompleteCheckBox;
                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.waitToCompleteCheckBox);
                    if (checkBox != null) {
                        return new DialogActionBlockConfigBinding((ScrollView) view, button, linearLayout, linearLayout2, checkBox);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogActionBlockConfigBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogActionBlockConfigBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_action_block_config, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11017a;
    }
}
