package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class SimpleSpinnerItemBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final TextView f11369a;
    @NonNull
    public final TextView text1;

    private SimpleSpinnerItemBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.f11369a = textView;
        this.text1 = textView2;
    }

    @NonNull
    public static SimpleSpinnerItemBinding bind(@NonNull View view) {
        if (view != null) {
            TextView textView = (TextView) view;
            return new SimpleSpinnerItemBinding(textView, textView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static SimpleSpinnerItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SimpleSpinnerItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.simple_spinner_item, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public TextView getRoot() {
        return this.f11369a;
    }
}
