package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ViewVariableFilterEntryBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11418a;
    @NonNull
    public final CheckBox filterEnabledCheckbox;
    @NonNull
    public final TextView variableName;

    private ViewVariableFilterEntryBinding(@NonNull LinearLayout linearLayout, @NonNull CheckBox checkBox, @NonNull TextView textView) {
        this.f11418a = linearLayout;
        this.filterEnabledCheckbox = checkBox;
        this.variableName = textView;
    }

    @NonNull
    public static ViewVariableFilterEntryBinding bind(@NonNull View view) {
        int i4 = R.id.filterEnabledCheckbox;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.filterEnabledCheckbox);
        if (checkBox != null) {
            i4 = R.id.variableName;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.variableName);
            if (textView != null) {
                return new ViewVariableFilterEntryBinding((LinearLayout) view, checkBox, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ViewVariableFilterEntryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ViewVariableFilterEntryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.view_variable_filter_entry, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11418a;
    }
}
