package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogParentConditionConfigureBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11107a;
    @NonNull
    public final TextView dialogParentConditionDetailText;
    @NonNull
    public final CheckBox dontLogIfFalseCheckbox;

    private DialogParentConditionConfigureBinding(@NonNull ScrollView scrollView, @NonNull TextView textView, @NonNull CheckBox checkBox) {
        this.f11107a = scrollView;
        this.dialogParentConditionDetailText = textView;
        this.dontLogIfFalseCheckbox = checkBox;
    }

    @NonNull
    public static DialogParentConditionConfigureBinding bind(@NonNull View view) {
        int i4 = R.id.dialog_parent_condition_detail_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.dialog_parent_condition_detail_text);
        if (textView != null) {
            i4 = R.id.dont_log_if_false_checkbox;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.dont_log_if_false_checkbox);
            if (checkBox != null) {
                return new DialogParentConditionConfigureBinding((ScrollView) view, textView, checkBox);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogParentConditionConfigureBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogParentConditionConfigureBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_parent_condition_configure, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11107a;
    }
}
