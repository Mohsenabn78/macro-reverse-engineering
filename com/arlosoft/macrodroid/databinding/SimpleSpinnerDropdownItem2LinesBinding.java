package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class SimpleSpinnerDropdownItem2LinesBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CheckedTextView f11366a;
    @NonNull
    public final CheckedTextView text1;

    private SimpleSpinnerDropdownItem2LinesBinding(@NonNull CheckedTextView checkedTextView, @NonNull CheckedTextView checkedTextView2) {
        this.f11366a = checkedTextView;
        this.text1 = checkedTextView2;
    }

    @NonNull
    public static SimpleSpinnerDropdownItem2LinesBinding bind(@NonNull View view) {
        if (view != null) {
            CheckedTextView checkedTextView = (CheckedTextView) view;
            return new SimpleSpinnerDropdownItem2LinesBinding(checkedTextView, checkedTextView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static SimpleSpinnerDropdownItem2LinesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SimpleSpinnerDropdownItem2LinesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.simple_spinner_dropdown_item_2_lines, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CheckedTextView getRoot() {
        return this.f11366a;
    }
}
