package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class IncludeExcludeOptionsBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11256a;
    @NonNull
    public final RadioButton radioExclude;
    @NonNull
    public final RadioButton radioInclude;

    private IncludeExcludeOptionsBinding(@NonNull LinearLayout linearLayout, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2) {
        this.f11256a = linearLayout;
        this.radioExclude = radioButton;
        this.radioInclude = radioButton2;
    }

    @NonNull
    public static IncludeExcludeOptionsBinding bind(@NonNull View view) {
        int i4 = R.id.radio_exclude;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.radio_exclude);
        if (radioButton != null) {
            i4 = R.id.radio_include;
            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radio_include);
            if (radioButton2 != null) {
                return new IncludeExcludeOptionsBinding((LinearLayout) view, radioButton, radioButton2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static IncludeExcludeOptionsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static IncludeExcludeOptionsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.include_exclude_options, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11256a;
    }
}
