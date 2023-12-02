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
public final class SimpleSpinnerItemTitleWhiteTextBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final TextView f11370a;
    @NonNull
    public final TextView text1;

    private SimpleSpinnerItemTitleWhiteTextBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.f11370a = textView;
        this.text1 = textView2;
    }

    @NonNull
    public static SimpleSpinnerItemTitleWhiteTextBinding bind(@NonNull View view) {
        if (view != null) {
            TextView textView = (TextView) view;
            return new SimpleSpinnerItemTitleWhiteTextBinding(textView, textView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static SimpleSpinnerItemTitleWhiteTextBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SimpleSpinnerItemTitleWhiteTextBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.simple_spinner_item_title_white_text, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public TextView getRoot() {
        return this.f11370a;
    }
}
