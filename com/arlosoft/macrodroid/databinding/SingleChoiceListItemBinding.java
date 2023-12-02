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
public final class SingleChoiceListItemBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CheckedTextView f11374a;
    @NonNull
    public final CheckedTextView text1;

    private SingleChoiceListItemBinding(@NonNull CheckedTextView checkedTextView, @NonNull CheckedTextView checkedTextView2) {
        this.f11374a = checkedTextView;
        this.text1 = checkedTextView2;
    }

    @NonNull
    public static SingleChoiceListItemBinding bind(@NonNull View view) {
        if (view != null) {
            CheckedTextView checkedTextView = (CheckedTextView) view;
            return new SingleChoiceListItemBinding(checkedTextView, checkedTextView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static SingleChoiceListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SingleChoiceListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.single_choice_list_item, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CheckedTextView getRoot() {
        return this.f11374a;
    }
}
