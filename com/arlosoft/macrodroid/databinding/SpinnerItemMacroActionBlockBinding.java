package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class SpinnerItemMacroActionBlockBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11380a;
    @NonNull
    public final TextView nameText;
    @NonNull
    public final TextView typeText;

    private SpinnerItemMacroActionBlockBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f11380a = linearLayout;
        this.nameText = textView;
        this.typeText = textView2;
    }

    @NonNull
    public static SpinnerItemMacroActionBlockBinding bind(@NonNull View view) {
        int i4 = R.id.nameText;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.nameText);
        if (textView != null) {
            i4 = R.id.typeText;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.typeText);
            if (textView2 != null) {
                return new SpinnerItemMacroActionBlockBinding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static SpinnerItemMacroActionBlockBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SpinnerItemMacroActionBlockBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.spinner_item_macro_action_block, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11380a;
    }
}
