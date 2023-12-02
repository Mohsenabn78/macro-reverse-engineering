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
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class ListItemSetVariableMultiEntryBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f11310a;
    @NonNull
    public final LinearLayout container;
    @NonNull
    public final TextView key;
    @NonNull
    public final TextView value;

    private ListItemSetVariableMultiEntryBinding(@NonNull MaterialCardView materialCardView, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f11310a = materialCardView;
        this.container = linearLayout;
        this.key = textView;
        this.value = textView2;
    }

    @NonNull
    public static ListItemSetVariableMultiEntryBinding bind(@NonNull View view) {
        int i4 = R.id.container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.container);
        if (linearLayout != null) {
            i4 = R.id.key;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.key);
            if (textView != null) {
                i4 = R.id.value;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.value);
                if (textView2 != null) {
                    return new ListItemSetVariableMultiEntryBinding((MaterialCardView) view, linearLayout, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ListItemSetVariableMultiEntryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemSetVariableMultiEntryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_set_variable_multi_entry, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public MaterialCardView getRoot() {
        return this.f11310a;
    }
}
